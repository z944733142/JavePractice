package app.xupt.IO;

import java.io.UnsupportedEncodingException;

public class ByteAndChar {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*  编码解码字符集不同，导致乱码  */
        String a = new String("张硕计科1702");             // 解码  byte -> char
        byte[] bytes = a.getBytes("gbk");             // 编码  char -> byte
        byte[] bytes1 = a.getBytes("utf-8");
        String a2 = new String(bytes,"gbk");
        String a3 = new String(bytes,"utf-8");
        String a5 = new String(bytes,"gbk");
        String a4 = new String(bytes,"utf-8");
        System.out.println(a2 + "  " + a3);
        System.out.println(a4 + "  " + a5);

        /*  长度缺失  乱码  */
        System.out.println(new String(bytes,0,5,"gbk"));
    }
}
