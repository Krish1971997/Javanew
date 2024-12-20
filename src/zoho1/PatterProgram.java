package zoho1;

public class PatterProgram {

	/**
	 * public static void main(String[] args) { StringBuilder sb=new
	 * StringBuilder("MADURAI"); //MADURAI ADURAIM DURAIMA URAIMAD RAIMADU AIMADUR
	 * IMADURA for(int i=0;i<sb.length();i++) { for (int j = 0; j < sb.length();
	 * j++) { System.out.print(sb.charAt(j)+" "); } System.out.println("");
	 * sb.insert(sb.length(),sb.charAt(0)); sb.replace(0, 1, ""); } }
	 */

	public static void main(String[] args) {
		String str = "MADURAI";
		int length = str.length();

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(str.charAt((i + j) % length) + " ");
			}
			System.out.println();
		}
	}
}
