package app.xupt.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket Client;
    public static void main(String[] args) throws IOException {
        Server aServer = new Server();
        aServer.start();
        aServer.receive();


    }

    public void start() throws IOException {
        server = new ServerSocket(8888);
    }

    public void receive() throws IOException {
        Client = server.accept();
        InputStream IS = Client.getInputStream();
        StringBuilder msg = new StringBuilder();
        String n = null;
        byte[] a = new byte[30000];
        System.out.println(new String(a,0,IS.read(a)));
        IS.close();
    }

}
