package app.xupt.File;

import java.io.*;

public class OutPutStreamTest {
    public static void main(String[] args) {

        File aFile = new File("E:/123/123.txt");
        OutputStream aStream = null;
        try {
            aStream = new FileOutputStream(aFile,false);
            String aString = new String("张硕计科1702 \r\n");
            try {
                aStream.write(aString.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件写入失败");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件打开失败");
        }finally {
            try {
                aStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭失败");
            }
        }

    }
}
