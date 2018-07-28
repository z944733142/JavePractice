package app.xupt.Net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo02 {
    public static void main(String[] args) throws IOException {
        URL aurl = new URL("http://www.baidu.com:80/index.html#a?uname=zs");
        InputStream a1 = aurl.openStream();
        BufferedWriter a2 = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("E:/123/999.txt"),"utf-8"));

        byte[] bytes = new byte[2000];

        while (-1 != a1.read(bytes)){
            System.out.println(new String(bytes));
            a2.write(new String(bytes));
        }
        a2.flush();
        a2.close();
        a1.close();


    }
}
