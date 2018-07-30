package app.xupt.Net;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket Client = new Socket("localhost",9998);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream iS = new DataInputStream(Client.getInputStream());
        DataOutputStream oS = new DataOutputStream(Client.getOutputStream());
        String string = input.readLine();

        // 输出流
        oS.writeUTF(string);
        oS.flush();

        // 输入流
        String  data = iS.readUTF();
        System.out.println(data);





    }
}
