package app.xupt.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket a = new DatagramSocket(8989);

        byte[] bytes = new byte[1024];
        DatagramPacket b = new DatagramPacket(bytes,bytes.length);

        a.receive(b);

        System.out.println(new String(bytes));
        a.close();
    }
}
