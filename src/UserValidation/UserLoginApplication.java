package UserValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class UserLoginApplication {
	private UserService userService; 
	
	public UserLoginApplication(String filename) {
		userService = new UserService(filename);
	}
	public void loginUser() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		String username = scanner.nextLine(); //Read user input for username
		
		System.out.println("Enter password: ");
		String password = scanner.nextLine(); // Read user input for password
		
		boolean isAuthenticated = userService.authenticateUser(username, password);
		if(isAuthenticated) {
			System.out.println("Login successful!");
		} else {
			System.out.println("An error occurred: " + e.getMessage());
		}
			User user = userService.authenticateUser(username, password);
		if (user != null) {
			System.out.println("Login successful: Welcome " + user.getName());
		} else {
			System.out.println("Login failed: Incorrect username or password.");
		}
		scanner.close();
		}
	public static void main(String[] args) {
		UserLoginApplication app = new UserLoginApplication("data.txt");
		app.loginUser();
	}
}