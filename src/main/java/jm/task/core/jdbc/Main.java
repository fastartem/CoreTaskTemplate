package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

       // userService.createUsersTable();

        userService.saveUser("Alex2", "Spencer", (byte) 23);
        userService.saveUser("Max2", "Spencer", (byte) 45);
        userService.saveUser("Fil2", "Spencer", (byte) 12);
        userService.saveUser("Tom2", "Spencer", (byte) 33);

//        userService.getAllUsers().forEach(System.out::println);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
