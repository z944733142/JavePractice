package app.xupt;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File a = new File("E:/javatest");
		
		printFile(a, 0);

	}
	
	public static void printFile (File a, int b)
	{
		for(int i = 0; i < b;i ++)
		{
			System.out.print("--- ");
		}
		System.out.println(a.getName());
		if(a.isDirectory()) 
		{
			File[] files = a.listFiles();
			for (File temp : files)
			{
				printFile(temp, b + 1);
			}
		}
	}


}
