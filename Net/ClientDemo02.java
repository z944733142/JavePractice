package app.xupt.Net;

import java.io.*;
import java.net.Socket;

public class ClientDemo02 {
    public static void main(String[] args) throws IOException {
        Socket Client = new Socket("localhost",9997);
        Thread send = new Thread(new Send(Client));
        Thread send2 = new Thread(new Receive(Client));
        send.start();
        send2.start();
    }
}


class Send implements Runnable {
    // 控制台
    private BufferedReader console;
    private DataOutputStream dos;
    private  boolean isRunning = true;
    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (isRunning)
        {
            try {
                send();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;

            }
        }
    }

    public void send () throws IOException {
        String msg = getMsgFromConsole();
        if(msg != null && !msg.equals(""))
        {
            dos.writeUTF(msg);
            dos.flush();
        }
    }

    private String getMsgFromConsole () throws IOException {
        return console.readLine();
    }

    public Send(Socket Client) throws IOException {
        this();
        try {
            dos = new DataOutputStream(Client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            dos.close();
            console.close();
        }
    }
}

class Receive implements Runnable {
    private DataInputStream iS;
    private boolean flag = true;


    public Receive(Socket Client) {
        try {
            iS = new DataInputStream(Client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
    }

    public String receive(){
        String msg = "";
        try {
            msg = iS.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(111);
            flag = false;
        }
        return msg;
    }
    @Override

    public void run() {
        while(flag)
        {
            System.out.println(receive());
        }
    }
}
