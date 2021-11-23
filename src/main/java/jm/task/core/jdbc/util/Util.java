package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jm.task.core.jdbc.model.User;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/users_schema";
    private final static String USER = "root";
    private final static String PSW = "11111";

    public static class JDBCUtil {
        private static Connection connection = null;

        public static Connection getConnection() {
            try {
                connection = DriverManager.getConnection(URL, USER, PSW);
            } catch (SQLException e) {
                System.out.println("Error");
            }
            return connection;
        }
    }

    public static class HibernateUtil {
        private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();

                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settings.put(Environment.URL, URL);
                    settings.put(Environment.USER, USER);
                    settings.put(Environment.PASS, PSW);
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                    settings.put(Environment.SHOW_SQL, "true");

                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                    settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                    configuration.setProperties(settings);

                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }
    }

}
