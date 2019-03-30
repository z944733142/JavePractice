package IO;

import java.io.File;
import java.io.IOException;

public class DirCopy {
    public static void main(String[] args) throws IOException {
        copyDir("E:/123/123.txt","E:/128");
    }
    public static void copyDir (String in ,String out) throws IOException {
         File  aFile  = new File(in);
        File   aFile2 = new File(out);
        copyDir(aFile,aFile2);
    }
    public static void copyDir (File in ,File out) throws IOException {

        if(in.isFile())
        {
            out.mkdirs();
            out = new File(out,in.getName());
            app.xupt.File.FileCopy.FileCopy(in,out);
        }
        File aOut = null;
        if (in.isDirectory()) {
            aOut = new File(out, in.getName());
            aOut.mkdirs();
        }
        if(in.listFiles() != null) {
            for (File temp : in.listFiles()) {
//                Copydir(temp, aOut);
            }
        }
    }

//    public static void Copydir(File aFile, File dest) throws IOException {
//
//        dest = new File(dest,aFile.getName());
//        if (aFile.isFile()) {
//
//            app.xupt.IO.FileCopy.FileCopy(aFile, dest);
//        }
//
//        if (aFile.isDirectory() && aFile.listFiles() != null) {
//            dest.mkdirs();
//            for (File temp : aFile.listFiles()) {
//                Copydir(temp, new File(dest, temp.getName()));
//
//            }
//        }
//    }
}
