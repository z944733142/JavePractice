package app.xupt.Net;

import sun.security.krb5.internal.HostAddress;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;


public class UDPClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket a = new DatagramSocket(7275);
        Scanner sc = new Scanner(System.in);
        String astring = sc.nextLine();
        InputStream IS = new FileInputStream(astring);
        byte[] bytes = new byte[20480];
        IS.read(bytes);
        DatagramPacket b = new DatagramPacket(bytes,bytes.length,new InetSocketAddress("localhost",7575));
        a.send(b);
        a.close();


    }
}
