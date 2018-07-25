package app.xupt.IO;

import java.io.*;

public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream a = new ByteArrayOutputStream();
        String aString = new String ("张硕计科1702");
        byte[] bytes = aString.getBytes();
        byte[] bytes1 = new byte[1024];
        a.write(bytes);
        bytes1 = a.toByteArray();
        System.out.println(new String(bytes1));
        a.flush();
        a.close();
    }
}
