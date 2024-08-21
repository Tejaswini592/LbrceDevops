package Devops;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Signup {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Signup System");

        while (true) {
            System.out.println("\n1. Sign Up");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signup();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void signup() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Simple username validation
        if (username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another one.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Simple password validation
        if (password.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        users.add(new User(username, password));
        System.out.println("Sign up successful!");
    }
}

