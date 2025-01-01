package test;

import java.util.HashMap;
import java.util.Map;

class User {
	private String username;
	private String hashedPassword;

	public User(String username, String hashedPassword) {
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}
}

class UserDatabase {
	private Map<String, User> userMap;

	public UserDatabase() {
		userMap = new HashMap<>();
	}

	public boolean addUser(User user) {
		if (userMap.containsKey(user.getUsername())) {
			return false; // User already exists
		}
		userMap.put(user.getUsername(), user);
		return true;
	}

	public User getUser(String username) {
		return userMap.get(username);
	}
}

class LoginService {
	private UserDatabase userDatabase;

	public LoginService() {
		this.userDatabase = new UserDatabase();
	}

	public boolean register(String username, String password) {
		String hashedPassword = hashPassword(password);
		User user = new User(username, hashedPassword);
		return userDatabase.addUser(user);
	}

	public boolean login(String username, String password) {
		User user = userDatabase.getUser(username);
		if (user == null) {
			return false; // User not found
		}
		String hashedPassword = hashPassword(password);
		return hashedPassword.equals(user.getHashedPassword());
	}

	private String hashPassword(String password) {
		// Simple hash for demonstration (replace with real hashing like BCrypt in
		// production)
		int hash = password.hashCode();
		return Integer.toString(hash);
	}
}

public class HashCodePasswordEncryption {
	public static void main(String[] args) {
		LoginService loginService = new LoginService();

		// Register users
		System.out.println("Registering user1: " + loginService.register("user1", "password123"));
		System.out.println("Registering user2: " + loginService.register("user2", "mypassword"));

		// Attempt login
		System.out.println("Login user1 with correct password: " + loginService.login("user1", "password123"));
		System.out.println("Login user1 with wrong password: " + loginService.login("user1", "wrongpassword"));
		System.out.println("Login non-existent user: " + loginService.login("user3", "anyPassword"));
	}
}
