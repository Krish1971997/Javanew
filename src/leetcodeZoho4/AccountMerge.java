package leetcodeZoho4;

import java.util.*;

public class AccountMerge {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap<>();
		Map<String, String> parent = new HashMap<>();

		// Initialize Union-Find structure with email as its own parent initially
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				emailToName.put(email, name);
				parent.put(email, email);
			}
		}

		// Union operation: link each email to the first email in the account
		for (List<String> account : accounts) {
			String firstEmail = account.get(1);
			for (int i = 2; i < account.size(); i++) {
				union(parent, firstEmail, account.get(i));
			}
		}

		// Group emails by their root parents
		Map<String, List<String>> unions = new HashMap<>();
		for (String email : parent.keySet()) {
			String rootEmail = find(parent, email);
			unions.computeIfAbsent(rootEmail, x -> new ArrayList<>()).add(email);
		}

		// Construct final result with name and sorted list of emails
		List<List<String>> result = new ArrayList<>();
		for (List<String> emails : unions.values()) {
			Collections.sort(emails);
			List<String> account = new ArrayList<>();
			account.add(emailToName.get(emails.get(0)));
			account.addAll(emails);
			result.add(account);
		}

		return result;
	}

	// Union-Find helper to find root of the email
	private String find(Map<String, String> parent, String email) {
		if (!email.equals(parent.get(email))) {
			parent.put(email, find(parent, parent.get(email))); // Path compression
		}
		return parent.get(email);
	}

	// Union helper to connect two emails
	private void union(Map<String, String> parent, String email1, String email2) {
		String root1 = find(parent, email1);
		String root2 = find(parent, email2);
		if (!root1.equals(root2)) {
			parent.put(root1, root2); // Union by attaching root1 to root2
		}
	}

	public static void main(String[] args) {
		AccountMerge solution = new AccountMerge();
		List<List<String>> accounts = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
				Arrays.asList("John", "johnnybravo@mail.com"),
				Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
				Arrays.asList("Mary", "mary@mail.com"));

		List<List<String>> mergedAccounts = solution.accountsMerge(accounts);
		System.out.println("Merged Accounts:");
		for (List<String> account : mergedAccounts) {
			System.out.println(account);
		}
	}
}
