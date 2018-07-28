package app.xupt.IO;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {

        File aFile = new File("E:/123/123.txt");
        Reader reader = new FileReader(aFile);
        char[] chars = new char[1024];
        int len = 0;
        while (-1 != (len = reader.read(chars)))
        {
            System.out.println(chars);
        }
        reader.close();




    }
}
