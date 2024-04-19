package UserValidation;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UserLoginApplication {
	private static final int MAX_LOGIN_ATTEMPTS = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserService();
		int attempts = 0;

		while (attempts < MAX_LOGIN_ATTEMPTS) {
			System.out.println("Enter your email: ");
			String username = scanner.nextLine().trim().toLowerCase();

			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			User loggedInUser = userService.validateUser(username, password);
			if (loggedInUser != null) {
				System.out.println("Welcome, " + loggedInUser.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again.");
				attempts++;
			}
			if (attempts == MAX_LOGIN_ATTEMPTS) {
				System.out.println("Too many failed login attempts, you are now locked out.");
			}
			scanner.close();
		}
	}
}
