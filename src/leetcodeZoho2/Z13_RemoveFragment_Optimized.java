package leetcodeZoho2;

import java.util.*;
//working
public class Z13_RemoveFragment_Optimized {

	public static void main(String[] args) {
		String s1 = "Every morning I want to do exercise regularly";
		String s2 = "Every morning I want to do meditation without fail";
		String s3 = "It is important that I want to be happy always";

		List<String> result = removeCommon3Fragment(s1, s2, s3);
		for (String r : result)
			System.out.println(r);
	}

	// Returns list of processed sentences (if no common fragment, returns
	// originals)
	public static List<String> removeCommon3Fragment(String s1, String s2, String s3) {
		String[] a1 = tokenize(s1);
		String[] a2 = tokenize(s2);
		String[] a3 = tokenize(s3);

		// build sets of triples for s2 and s3
		Set<String> set2 = buildTripleSet(a2);
		Set<String> set3 = buildTripleSet(a3);

		// find first triple from s1 that exists in both set2 and set3
		String fragment = null;
		for (int i = 0; i + 2 < a1.length; i++) {
			String triple = a1[i] + " " + a1[i + 1] + " " + a1[i + 2];
			if (set2.contains(triple) && set3.contains(triple)) {
				fragment = triple;
				break;
			}
		}

		if (fragment == null) {
			return Arrays.asList(s1, s2, s3);
		}

		// remove occurrences from each token array
		String r1 = removeFragmentFromTokens(a1, fragment);
		String r2 = removeFragmentFromTokens(a2, fragment);
		String r3 = removeFragmentFromTokens(a3, fragment);

		return Arrays.asList(r1, r2, r3);
	}

	private static String[] tokenize(String s) {
		s = s == null ? "" : s.trim();
		if (s.isEmpty())
			return new String[0];
		return s.split("\\s+");
	}

	// build set of all consecutive 3-word triples from tokens
	private static Set<String> buildTripleSet(String[] tokens) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i + 2 < tokens.length; i++) {
			set.add(tokens[i] + " " + tokens[i + 1] + " " + tokens[i + 2]);
		}
		return set;
	}

	// remove all (non-overlapping) occurrences of fragment from tokens and join
	private static String removeFragmentFromTokens(String[] tokens, String fragment) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < tokens.length) {
			if (i + 2 < tokens.length) {
				String cand = tokens[i] + " " + tokens[i + 1] + " " + tokens[i + 2];
				if (cand.equals(fragment)) {
					i += 3; // skip this triple (non-overlapping skip)
					continue;
				}
			}
			if (sb.length() > 0)
				sb.append(' ');
			sb.append(tokens[i]);
			i++;
		}
		return sb.toString();
	}
}
