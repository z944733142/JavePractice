package app.xupt.IO;

import java.io.*;

public class OutputSteamWriteTest {
    public static void main(String[] args) throws IOException {

    BufferedWriter a = new BufferedWriter(
            new OutputStreamWriter(
                    new FileOutputStream(
                            new File("E:/123/124.txt"),true
                    ),"utf-8")
    );

    String aString = new String("张硕计科1702\r\n师东璇计科1707\r\n郝建强计科1704\r\n");
    a.write(aString,0,aString.length());
    a.flush();
    a.close();
    }

}
