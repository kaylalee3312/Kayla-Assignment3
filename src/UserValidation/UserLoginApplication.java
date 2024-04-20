package UserValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class UserLoginApplication {
	public static void main(String[] args) {
	UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in);

    int maxAttempts = 5;
    int attempts = 0;

    while (attempts < maxAttempts) {
        System.out.print("Enter your email: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userService.authenticate(username, password)) {
            System.out.println("Welcome: " + findNameByUsername(userService, username)); 
            break; 
        } else {
            attempts++;
            System.out.println("Invalid login, please try again.");
        }

        if (attempts >= maxAttempts) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }
    }

    scanner.close();
}

// Helper function to find the user's name based on username
private static String findNameByUsername(UserService userService, String username) {
    for (User user : userService.users) {
        if (user.getUsername().equalsIgnoreCase(username)) {
            return user.getName();
        }
    }
    return null; 
}
}
