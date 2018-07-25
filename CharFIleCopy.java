package app.xupt.IO;

import java.io.*;

public class CharFIleCopy {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("E:/123/111.txt");
        Reader reader = new FileReader("E:/123/123.txt");
        int len = 0;
        char[] flush = new char[1024];
        while (-1 != (len = reader.read(flush)))
        {
            writer.write(flush);
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
