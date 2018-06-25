package app.xupt;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		System.out.println();
		int[] a = {3,4,5,1,2,3,4,52,1,32,14,214,214,21,421,412,4,25};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(Arrays.toString(a));
//		System.arraycopy(src, srcPos, dest, destPos, length);
		
	}
}
