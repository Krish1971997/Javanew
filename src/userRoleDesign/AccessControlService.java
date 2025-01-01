package userRoleDesign;

import java.util.List;

public class AccessControlService {
	private UserDatabase userDatabase;

	public AccessControlService() {
		this.userDatabase = new UserDatabase();
	}

	public boolean register(String username, String password, List<String> roleNames) {
		String hashedPassword = hashPassword(password);
		User user = new User(username, hashedPassword);

		for (String roleName : roleNames) {
			Role role = userDatabase.getRole(roleName);
			if (role == null) {
				throw new IllegalArgumentException("Role does not exist: " + roleName);
			}
			user.addRole(role);
		}
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

	public boolean hasAccess(String username, String permissionName) {
		User user = userDatabase.getUser(username);
		if (user == null) {
			return false;
		}
		return user.hasPermission(permissionName);
	}

	private String hashPassword(String password) {
		// Simple hash for demonstration (replace with real hashing like BCrypt in
		// production)
		int hash = password.hashCode();
		return Integer.toString(hash);
	}

	public void initialize() {
		// Create Roles
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");

		// Add Permissions
		admin.addPermission(new Permission("VIEW_PRODUCTS"));
		admin.addPermission(new Permission("ADD_PRODUCT"));
		admin.addPermission(new Permission("DELETE_PRODUCT"));

		user.addPermission(new Permission("VIEW_PRODUCTS"));

		// Add Roles to Database
		userDatabase.addRole(admin);
		userDatabase.addRole(user);
	}
}
