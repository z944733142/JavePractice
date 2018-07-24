package app.xupt.File;

import java.io.File;
import java.io.IOException;

public class FileOpr {
    public static void main(String[] args) {

        File aFile = new File("E:/FileTest");
        if( !aFile.exists())
        {
            try {
                aFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println("是文件夹吗" + aFile.isDirectory() + "是文件吗" + aFile.isFile() + "长度" + aFile.length());
            System.out.println("删除"  + aFile.delete());
            System.out.println("存在" + aFile.exists());


    }
}
