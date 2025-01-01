package userRoleDesign;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
	private Map<String, User> users;
	private Map<String, Role> roles;

	public UserDatabase() {
		users = new HashMap<>();
		roles = new HashMap<>();
	}

	public void addRole(Role role) {
		roles.put(role.getName(), role);
	}

	public Role getRole(String roleName) {
		return roles.get(roleName);
	}

	public boolean addUser(User user) {
		if (users.containsKey(user.getUsername())) {
			return false; // User already exists
		}
		users.put(user.getUsername(), user);
		return true;
	}

	public User getUser(String username) {
		return users.get(username);
	}
}
