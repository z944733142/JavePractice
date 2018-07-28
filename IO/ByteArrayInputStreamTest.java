package app.xupt.IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {
        String aString = new String("张硕计科1702");
        byte[] bytes = aString.getBytes();
        BufferedInputStream a = new BufferedInputStream(
                new ByteArrayInputStream(
                        bytes
                )
        );
        int len = 0;
        byte[] flush = new byte[1024];
        while (-1 != (len = a.read(flush)))
        {
            System.out.println(new String(flush));
        }
        a.close();

    }
}
