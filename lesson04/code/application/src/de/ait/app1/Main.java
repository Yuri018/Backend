package de.ait.app1;

import de.ait.app1.controllers.UserController;
import de.ait.app1.repositories.UserRepository;
import de.ait.app1.repositories.impl.UserRepositoryListImpl;
import de.ait.app1.services.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // внедряем зависимости
        UserRepository userRepository = new UserRepositoryListImpl();
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        UserController userController = new UserController(scanner, userService);

        // userController.addUser();

        boolean isRun = true;

        while (isRun) {
            System.out.println("Input command (address): ");
            String command = scanner.nextLine();

            switch (command) {
                case "/addUser" -> userController.addUser(); // вызов сервиса
                case "/users" -> userController.getAllUsers(); // вызов сервиса
                case "/exit" -> isRun = false;
            }
        }
    }
}
