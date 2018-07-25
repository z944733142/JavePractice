package app.xupt.IO;

import java.io.*;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {

        BufferedReader a = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("E:/123/123.txt")
                        ),"gbk"));
        BufferedReader a2 = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("E:/123/123.txt")
                        ),"utf-8"));
        char[] chars = new char[1024];
        char[] chars2 = new char[1024];
        a.read(chars);
        System.out.println(chars);
        a2.read(chars2);
        System.out.println(chars2);
    }
}
