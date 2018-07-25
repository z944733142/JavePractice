package app.xupt.File;

import java.io.File;

public class FilePrinter {

    public static void main(String[] args) {
        File file = new File("E:\\");
    //    printfFile(file);
        File[] files = file.listRoots();
        for (File temp : files) {
            printfFile(temp);
        }
    }

    public static  void printfFile (File a)
    {
        if (a == null) return;
        if(a.isFile())
        {
            System.out.println(a.getAbsolutePath());
        } else if (a != null && a.isDirectory())
        {
            File[] files = a.listFiles();
            if(files == null)
                return;
            for ( File b : files)
            {
                printfFile(b);
             }
        }
    }
}
