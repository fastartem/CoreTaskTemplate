package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Alex", "Spencer", (byte) 23);
        userService.saveUser("Max", "Spencer", (byte) 45);
        userService.saveUser("Fil", "Spencer", (byte) 12);
        userService.saveUser("Tom", "Spencer", (byte) 33);

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
