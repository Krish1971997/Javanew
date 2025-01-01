package userRoleDesign;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String username;
	private String hashedPassword;
	private Set<Role> roles; // Updated to allow multiple roles

	public User(String username, String hashedPassword) {
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.roles = new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public boolean hasPermission(String permissionName) {
		for (Role role : roles) {
			if (role.hasPermission(permissionName)) {
				return true;
			}
		}
		return false;
	}
}