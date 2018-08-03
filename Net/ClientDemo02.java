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
    private String  name ;
    private  boolean isRunning = true;
    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("请输入昵称：");
        try {
            name = console.readLine();
            send(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (isRunning)
        {
            try {
                send(getMsgFromConsole());
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;

            }
        }


    }

    public void send (String msg) throws IOException {
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

        }
    }
}

class Receive implements Runnable {
    private DataInputStream iS;
    private DataOutputStream oS;
    private Socket aSocket;
    private boolean flag = true;


    public Receive(Socket Client) {
        try {
            this.aSocket = Client;
            iS = new DataInputStream(Client.getInputStream());
        } catch (IOException e) {
            flag = false;
        }
    }

    public String receive(){
        String msg = "";
        try {
            msg = iS.readUTF();
        } catch (IOException e) {
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
