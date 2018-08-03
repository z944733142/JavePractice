package app.xupt.Download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTest {
    public static void main(String[] args) throws IOException {
        URL aUral = new URL("https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.12.0.msi");
        BufferedInputStream in = new BufferedInputStream(aUral.openStream());
        BufferedOutputStream BOS = new BufferedOutputStream(
                new FileOutputStream(new File("H:/123.msi"))
        );
        byte[] bytes = new byte[20480];
        int len = 0;
        while((len = in.read(bytes)) > -1)
        {
            BOS.write(bytes, 0, len);
            BOS.flush();
        }
        in.close();
        BOS.close();
    }
}
