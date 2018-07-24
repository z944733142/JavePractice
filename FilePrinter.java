package app.xupt.File;

import java.io.File;

public class FilePrinter {

    public static void main(String[] args) {
        File file = new File("G:/新建文件夹");
        printfFile(file);
        File[] files = file.listRoots();
    }

    public static  void printfFile (File a)
    {
        if(a != null && a.exists() && (a.isFile() || a.isDirectory()))
        {
            System.out.println(a.getAbsolutePath());
        }
        else return;

        if (a.isDirectory())
        {
            for ( File b :a.listFiles())
            {
                printfFile(b);
             }
        }
    }
}
