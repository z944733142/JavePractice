package app.xupt.Net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
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
        private boolean key1 = false;

        public xian(Socket socket) throws IOException {
            iS = new DataInputStream(socket.getInputStream());
            oS = new DataOutputStream(socket.getOutputStream());
        }

        private void send(xian a, String s) throws IOException {
            a.oS.writeUTF(s);
            a.oS.flush();
        }

        private void sendAll(String s) throws IOException {
            Iterator<xian> b = collection.iterator();
            while (b.hasNext()) {
                send(b.next(), s);
            }
        }

        public void run() {
            try {
                this.name = iS.readUTF();
                sendAll(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date()) + " " + name + "加入了聊天室");
                System.out.println(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date()) + " " + name + "链接成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (flag) {
                // 输入流
                String string = null;
                String url = null;
                try {
                    string = iS.readUTF();

                } catch (IOException e) {
                    collection.remove(this);
                    flag = false;
                    try {
                        sendAll(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date()) + " " + name + "离开了聊天室");
                        System.out.println(new SimpleDateFormat("yyy-MM-dd  HH:mm:ss").format(new Date()) + " " + name + "离开了聊天室");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    return;
                }
                if (string.startsWith("@") &&
                        (string.indexOf(":") > -1 || string.indexOf("：") > -1) &&
                            string.indexOf("@", 1) == -1) {
                    String name = string.substring(1, string.indexOf("：") == -1 ?
                            string.indexOf(":") :
                            string.indexOf("：")
                    );
                    String content = string.substring(string.indexOf("：") == -1 ?
                            string.indexOf(":") + 1 :
                            string.indexOf("：") + 1, string.length()
                    );
                    Iterator<xian> b = collection.iterator();
                    while (b.hasNext()) {
                        xian a = b.next();
                        if (a.name.equals(name)) {
                            try {

                                send(this, "你悄悄地对 " + a.name + "说  " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n" + content);
                                send(a, this.name + "悄悄地对你说  " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n" + content);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
//                else if (string.startsWith("@") &&
//                        string.indexOf("@", 1) > -1 &&
//                        string.startsWith("文件", string.indexOf("@", 1) + 1) &&
//                        (string.indexOf(":", string.indexOf("@", 1)) > -1 || string.indexOf("：", string.indexOf("@", 1)) > -1))
//                {
//                    String name = string.substring(1, string.indexOf("@",1));
//                    url = string.substring(string.indexOf("：") == -1 ?
//                            string.indexOf(":") + 1 :
//                            string.indexOf("：") + 1, string.length());
//                    if (new File(url).isFile())
//                    {
//                        try
//                        {
//                            url = "file:///" + url;
//                              Iterator it = collection.iterator();
//                              while (it.hasNext())
//                              {
//                                  xian a = (xian) it.next();
//                                  if(a.name.equals(name))
//                                  {
//                                      send(a,new String(this.name + "对你发送文件，回复@" + this.name  +"@接收： +  目录接收，回复其他任意拒绝。"));
//                                      System.out.println("send File msg succeed");
//                                      key1 = true;
//                                  }
//                              }
//
//                        } catch (IOException e)
//                        {
//                              e.printStackTrace();
//                        }
//                    }
//                }
//                else if (string.startsWith("@") &&
//                        string.indexOf("@", 1) > -1 &&
//                        string.startsWith("接收", string.indexOf("@", 1) + 1) &&
//                        (string.indexOf(":", string.indexOf("@", 1)) > -1 || string.indexOf("：", string.indexOf("@", 1)) > -1))
//                {
//                    String name = string.substring(1, string.indexOf("@",1));
//                    url = string.substring(string.indexOf("：") == -1 ?
//                            string.indexOf(":") + 1 :
//                            string.indexOf("：") + 1, string.length());
//                    url = "file:///" + url;
//                    Iterator it = collection.iterator();
//                    while (it.hasNext())
//                    {
//                        xian a = (xian) it.next();
//                        if(a.name.equals(name))
//                        {
//                            try {
//                                send(a, "@" + a.name + "@@" + url);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("send File msg succeed");
//                        }
//                    }
//                }
//
//                else if (string.startsWith("@") && string.indexOf("@@", 1) > -1 && key1)
//                {
//                    url = string.substring(string.indexOf("@@") + 1, string.length());
//                }

                // 输出流
                else {

                    try {
                        sendAll(name + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n" + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
