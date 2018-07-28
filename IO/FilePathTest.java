package app.xupt.File;

import java.io.File;
import java.io.IOException;

public class FilePathTest {
    public static void main(String[] args) throws IOException {


        File a = new File("E:\\study\\2.png");
        System.out.println(a.getName() + "\n" + a.getAbsolutePath()  + "\n" + a.getParent() + "\n" + a.getPath());

        File b = new File("2.txt");
        System.out.println(b.getName() + "\n" + b.getAbsolutePath()  + "\n" + b.getParent() + "\n" + b.getPath());

    }
}
