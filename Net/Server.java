package app.xupt.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
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

            System.out.println("链接成功");
        }
    }

        class xian implements Runnable {

            private DataInputStream iS;
            private DataOutputStream oS;

            public xian(Socket socket) throws IOException {
                iS = new DataInputStream(socket.getInputStream());
                oS = new DataOutputStream(socket.getOutputStream());
            }

            public void run() {
                while (true) {
                    // 输入流
                    String string = null;
                    try {
                        string = iS.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 输出流
                    try {
                        Iterator<xian> b = collection.iterator();
                        while (b.hasNext())
                        {
                            xian c = b.next();
                            c.oS.writeUTF(string);
                            c.oS.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
