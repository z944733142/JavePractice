package app.xupt.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Server {
    Collection<xian> collection;

    public static void main(String[] args) throws IOException {
        new Server().func();

    }

    private void func() throws IOException {
        ServerSocket server = new ServerSocket(9997);
        collection = new LinkedList<xian>();


        while (true) {

            Socket socket = server.accept();
            xian a = new xian(socket);
            collection.add(a);
            new Thread(a).start();


        }
    }

    class xian implements Runnable {

        private DataInputStream iS;
        private DataOutputStream oS;
        String name;
        private boolean flag = true;

        public xian(Socket socket) throws IOException {
            iS = new DataInputStream(socket.getInputStream());
            oS = new DataOutputStream(socket.getOutputStream());
        }
        private void send(xian a, String s) throws IOException {
            oS.writeUTF(s);
            oS.flush();
        }

        private void sendAll(String s) throws IOException {
            Iterator<xian> b = collection.iterator();
            while (b.hasNext()) {
                send(b.next(),s);

            }
        }
        public void run() {

            try {
                this.name = iS.readUTF();
//                Iterator<xian> b = collection.iterator();
//                while (b.hasNext()) {
//                    xian c = b.next();
//                    c.oS.writeUTF();
//                    c.oS.flush();
//                }
                sendAll(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date()) + name + "加入了聊天室");
                System.out.println(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date())  + name + "链接成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (flag) {
                // 输入流
                String string = null;
                try {
                    string = iS.readUTF();
                } catch (IOException e) {
                    collection.remove(this);
                    flag = false;
                    try {
                        sendAll(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date())  + name + "离开了聊天室");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
//                    Iterator<xian> b = collection.iterator();
//                    while (b.hasNext()) {
//                        xian c = b.next();
//                        try {
//                            c.oS.writeUTF(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date())  + name + "离开了聊天室");
//                            c.oS.flush();
//                        } catch (IOException e1) {
//                            e1.printStackTrace();
//                        }
//                    }
                    return;
                }

                if (string.startsWith("@") && string.indexOf(":") > -1 || string.indexOf("：")> -1) {
                    String name = string.substring(1, string.indexOf("：") == -1 ? string.indexOf(":") :string.indexOf("：") );
                    String content = string.substring(string.indexOf("：") == -1 ? string.indexOf(":") + 1:string.indexOf("：") + 1,string.length());
                    Iterator<xian> b = collection.iterator();
                    while (b.hasNext()) {
                        xian a = b.next();
                        if (a.name.equals(name)) {
                            try {
                                a.oS.writeUTF(this.name + "悄悄地对你说  " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n"+ content);
                                a.oS.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                // 输出流
                else {
//                    try {
//                        Iterator<xian> b = collection.iterator();
//                        while (b.hasNext()) {
//                            xian c = b.next();
//                            c.oS.writeUTF(name + "   " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n" + string);
//                            c.oS.flush();
//                        }
                    try {
                        sendAll(name + "   " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n" + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                    catch (IOException e) {
//                        collection.remove(this);
//                        flag = false;
//                        return;
//                    }
                }
            }
        }
    }
}
