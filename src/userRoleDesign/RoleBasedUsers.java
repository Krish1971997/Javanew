package userRoleDesign;

import java.util.Arrays;
import java.util.Collections;

public class RoleBasedUsers {
	public static void main(String[] args) {
		AccessControlService accessControl = new AccessControlService();
		accessControl.initialize();

		// Register Users with Multiple Roles
		System.out.println(
				"Registering admin: " + accessControl.register("admin", "admin123", Arrays.asList("ADMIN", "USER")));
		System.out.println(
				"Registering user: " + accessControl.register("user1", "user123", Collections.singletonList("USER")));

		// Attempt Login
		System.out.println("Login admin: " + accessControl.login("admin", "admin123"));
		System.out.println("Login user1: " + accessControl.login("user1", "user123"));

		// Check Permissions
		System.out.println("Admin can view products: " + accessControl.hasAccess("admin", "VIEW_PRODUCTS"));
		System.out.println("Admin can add products: " + accessControl.hasAccess("admin", "ADD_PRODUCT"));
		System.out.println("User1 can add products: " + accessControl.hasAccess("user1", "ADD_PRODUCT"));
	}
}
