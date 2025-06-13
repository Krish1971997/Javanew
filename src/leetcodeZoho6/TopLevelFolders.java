package leetcodeZoho6;

//need to learn
import java.util.*;

public class TopLevelFolders {

	public List<String> listTopLevelFolders(String[] paths) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < paths.length; i++) {
			boolean isSubfolder = false;
			String current = paths[i];
			// Ensure path ends with "/" for accurate prefix check
			String currentWithSlash = current.endsWith("/") ? current : current + "/";

			// Check if current path is a subfolder of any other path
			for (int j = 0; j < paths.length; j++) {
				if (i == j)
					continue; // Skip same path
				String other = paths[j];
				String otherWithSlash = other.endsWith("/") ? other : other + "/";

				// If current path starts with another path, it's a subfolder
				if (currentWithSlash.startsWith(otherWithSlash)) {
					isSubfolder = true;
					break;
				}
			}

			// If not a subfolder, add to result
			if (!isSubfolder) {
				result.add(current);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// Test case
		String[] paths = { "/Zoho/crm", "/Zoho/crm/.../mail" };
		TopLevelFolders solution = new TopLevelFolders();
		List<String> result = solution.listTopLevelFolders(paths);

		// Print the result
		System.out.println("Input: " + Arrays.toString(paths));
		System.out.println("Output: " + result);
	}
}