package user.validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	List<User> users;

	public UserService() {
		this.users = new ArrayList<>();
		loadUsersFromFile();
	}

	private void loadUsersFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
//	               System.out.println(line); 
				String[] parts = line.split(",");
				String username = parts[0];
				String password = parts[1];
				String name = parts[2];
				users.add(new User(username, password, name));
			}
		} catch (IOException e) {
			System.err.println("Error reading user data: " + e.getMessage());
		}
	}

	public boolean authenticate(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
