package app.xupt;

import java.util.Scanner;

public class TestSuper {

	public static void main(String[] args)  {
		
		int[] a = new int[10];
		Scanner c = new Scanner(System.in);
		for(int i = 0; i < 10; i++)
		{
			a[i] = i*11;
		}
		for(int m: a)
		{
			System.out.println(m);
		}
	}


}


