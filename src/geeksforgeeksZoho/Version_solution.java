package geeksforgeeksZoho;

public class Version_solution {
 	public static void main(String[] args) {
		int res1 = compareVersion("1.01", "1.001");
		System.out.println(res1);

		int res2 = compareVersion("1.0", "1.0.0");
		System.out.println(res2);

		int res3 = compareVersion("0.1", "1.0");
		System.out.println(res3);
	}
 	
 	public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }


/*	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int i = 0;
		while (i < arr1.length || i < arr2.length) {
			if (i < arr1.length && i < arr2.length) {
				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
					return -1;
				} else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
					return 1;
				}
			} else if (i < arr1.length) {
				if (Integer.parseInt(arr1[i]) != 0) {
					return 1;
				}
			} else if (i < arr2.length) {
				if (Integer.parseInt(arr2[i]) != 0) {
					return -1;
				}
			}
			i++;
		}
		return 0;
	} */

	/*	static int compareVersion(String v1, String v2) {

		v1 = removeExtraDots(v1);
		v2 = removeExtraDots(v2);

		double vnum1 = Double.parseDouble(v1);
		double vnum2 = Double.parseDouble(v2);
		if (vnum1 > vnum2) {
			return 1;
		} else if (vnum1 < vnum2) {
			return -1;
		} else
			return 0;
	}

	public static String removeExtraDots(String str) {
		int firstindex = str.indexOf(".");
		if (firstindex != -1) {
			String firstPath = str.substring(0, firstindex + 1);
			String secondPath = str.substring(firstindex + 1);
			secondPath = secondPath.replace(".", "");
			String newStr = firstPath + secondPath;
		//	System.out.println(newStr);
			return newStr;
		}
		return str;
	}
*/
 	

}