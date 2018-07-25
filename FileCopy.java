package app.xupt.File;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileCopy("E:/123/File类文件操作.png","E:/123/附件2.png");
    }

    public static void FileCopy (String src, String dest) throws IOException{
        FileCopy(new File(src), new File(dest));
    }

    public static void FileCopy (File src, File dest) throws IOException {
        if (!src.isFile())
        {
            throw new IOException("不是文件");
        }
        InputStream inputStream = new FileInputStream(src);
        OutputStream outputStream = new FileOutputStream(dest);
        byte[] flush = new byte[1024];
        int len = 0;
        while(-1 != (len = inputStream.read(flush)))
        {
            outputStream.write(flush, 0, len);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
