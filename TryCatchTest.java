package app.xupt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class TryCatchTest {

	public static void main(String[] args) {
		FileReader a = null;
		try {
			a = new FileReader("e:/test.txt");
			System.out.println(a.read() + "" + a.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (a != null)
					a.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		ArithmeticException
////		ParseException


	}

}
