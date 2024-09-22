package codeiozoho;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBracketNumber {

	public static void main(String[] args) {
		String s="(aa(bdcp(()dee)))eae";
		Stack<Integer> stack=new Stack<Integer>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		int count=1;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push(count);
				list.add(count);
				count++;
			}else if(stack.size()>0&&s.charAt(i)==')') {
				int value=stack.pop();
				list.add(value);
			} 
		}
		
		for (Integer integer : list) {
			System.out.print(integer+", ");
		}
	}
}
