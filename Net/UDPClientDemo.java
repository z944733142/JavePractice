package app.xupt.Net;

import sun.security.krb5.internal.HostAddress;

import java.io.IOException;
import java.net.*;

public class UDPClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket a = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        bytes = "123".getBytes();
        DatagramPacket b = new DatagramPacket(bytes,bytes.length,new InetSocketAddress("localhost",8989));

        a.send(b);

        a.close();


    }
}
