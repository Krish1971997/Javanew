package zoho1;

import java.util.HashMap;

public class Anagram {
	public static void main(String[] args) {
		String a="allergy";
		String b="allergic";
		System.out.println("Result --> "+isAnagram(a, b));

	}
	public static boolean isAnagram(String a,String b)
    {
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<a.length();i++){
            map.put(a.charAt(i),map.getOrDefault(a.charAt(i),0)+1);
        }
        
        for(int i=0;i<b.length();i++){
            if(map.getOrDefault(b.charAt(i),0)>0){
                map.put(b.charAt(i),map.getOrDefault(b.charAt(i),0)-1);
            }
            else
                return false;
        }
        
        return true;
        
    }

}
