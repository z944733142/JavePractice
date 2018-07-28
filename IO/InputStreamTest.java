package app.xupt.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest {

    public static void main(String[] args) {
        File aFile = new File("E:/123/123.txt");
        FileInputStream inPut = null;
        try {
            inPut = new FileInputStream(aFile);
            byte[] arr = new byte[10];
            try {
                while ( -1 != inPut.read(arr))
                {
                    System.out.println(new String(arr));
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("读取失败");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件打开失败");
        }finally {
            try {
                inPut.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭失败");
            }
        }

    }
}
