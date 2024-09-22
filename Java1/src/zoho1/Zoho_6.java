package zoho1;

import java.util.Arrays;

public class Zoho_6 {
    public static void main(String[] args) {
        int num=5;
        int[] f=new int [num+1];
        for (int i = 0; i <=num ; i++) {
            f[i]=f[i>>1]+(i&1);
        }
        System.out.println(Arrays.toString(f));
    }
}