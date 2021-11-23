package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

       //  userService.createUsersTable();

        userService.saveUser("Alexdasd", "Spencer", (byte) 23);
        userService.saveUser("Msdaadsax", "Spencer", (byte) 45);
        userService.saveUser("Filsads", "Spencer", (byte) 12);
        userService.saveUser("Tadsoasdm", "Spencer", (byte) 33);

//        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
       //userService.dropUsersTable();
    }
}
