package leetcodeZoho5_dp;

import java.util.HashMap;
import java.util.Map.Entry;

public class GrandChildrenProblem {

	public static void main(String[] args) {
		HashMap<String, String> parentList=new HashMap<String, String>();
		parentList.put("luke", "shaw");
		parentList.put("wayne", "rooney");
		parentList.put("rooney", "ronaldo");
		parentList.put("shaw", "rooney");
		
		String grandParent="ronaldo";
		System.out.println(getNumberOfGrandChilders(parentList,grandParent));
	}

	private static int getNumberOfGrandChilders(HashMap<String, String> parentList, String grandParent) {
		String parent=parentList.get(grandParent);
		int count=0;
		
		for (Entry<String, String> map : parentList.entrySet()) {
			if(map.getKey().equals(parent))
				count++;
		}
		
		return count;
	}
}
