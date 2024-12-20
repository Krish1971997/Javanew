package geeksforgeeksZoho_1;

import java.util.ArrayList;

public class SearchPattern {
	public static void main(String[] args) {
		String txt = "ebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddaeebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddbabebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddbcbebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddeebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddabebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddbadebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddeebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddbebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddecebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddeebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddbebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabaddebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabadd";
		String pat = "ebbabdbacccadeaaeecadedbbaedbedeaccccdbaeecbcbdbacabadd";
		ArrayList<Integer> list = search(pat, txt);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}

	public static ArrayList<Integer> search(String pat, String txt) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int first = txt.indexOf(pat);

		if (first != -1) {
			list.add(first+1);
			for (int i = first + 1; i < txt.length(); i++) {
				if (first != -1) {
					first = txt.indexOf(pat, first + 1);
					if(first!=-1) {
						list.add(first + 1);
					}
				}
			}
			return list;
		}
		list.add(-1);
		return list;
	}
}
