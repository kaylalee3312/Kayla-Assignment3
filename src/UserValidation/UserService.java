package UserValidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> users = new ArrayList<>();
	public int maxLoginAttempts = 5;

	public boolean authenticateUser(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true; 
			}
		} return false; 
	}
	public UserService(String filename) {
		loadUsers(filename);
	}

	private void loadUsers(String filename) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 3) {
					String username = parts[0].trim(); // Assigning the first part to username
					String password = parts[1].trim(); // Assigning the second part to password
					String name = parts[2].trim();  
					
					User newUser = createUser(username, password, name);
					users.add(newUser);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading file: " + filename);
			e.printStackTrace();}
		}

	private User createUser(String username, String password, String name) {
		return new User(username, password, name);
	}
	public List<User> getUsers() {
		return users;
//	public User login(String username, String password) {
//		for (User user : users) {
//			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//				return user;
	}

}

}}