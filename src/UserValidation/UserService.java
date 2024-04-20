package UserValidation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserService {
    private User[] users;

    public UserService() {
        loadUsers();
    }
    UserService userService = new UserService();
    private void loadUsers() {
        ArrayList<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 3) {
                    userList.add(new User(userDetails[0], userDetails[1], userDetails[2]));
                }
            }
            users = userList.toArray(new User[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}