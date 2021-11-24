package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String sql = "CREATE TABLE IF NOT EXISTS user " +
                    "(id BIGINT UNSIGNED not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age TINYINT, " +
                    " PRIMARY KEY ( id ))";

            session.createSQLQuery(sql).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = new User(name, lastName, age);

            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object persistentInstance = session.load(User.class, id);

            if (persistentInstance != null) {
                session.delete(persistentInstance);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        final List<User> list = new ArrayList<>();
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("From User");

            for (final Object o : query.list()) {
                list.add((User) o);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;

        try (Session session = Util.HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createQuery("delete from User").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }
}
