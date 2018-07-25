package app.xupt.IO;

import java.io.*;



public class FileWriteTest {
    public static void main(String[] args) throws IOException {

        File aFile = new File("E:/123/123.txt");
        Writer aWrite = new FileWriter(aFile,false);
        String flush = new String("计科1707师东璇\r\n计科1704郝建强\r\n计科1702张硕");
        int len = 0;
        aWrite.write(flush);
        aWrite.flush();
        aWrite.close();


    }
}
