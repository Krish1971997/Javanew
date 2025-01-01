package userRoleDesign;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private String name;
	private Set<Permission> permissions;

	public Role(String name) {
		this.name = name;
		this.permissions = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void addPermission(Permission permission) {
		permissions.add(permission);
	}

	public boolean hasPermission(String permissionName) {
		for (Permission permission : permissions) {
			if (permission.getName().equals(permissionName)) {
				return true;
			}
		}
		return false;
	}
}