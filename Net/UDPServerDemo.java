package app.xupt.Net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket a = new DatagramSocket(7575);
        Scanner sc = new Scanner(System.in);
        String astring = sc.nextLine();
        OutputStream OS = new FileOutputStream(astring);
        byte[] bytes = new byte[20480];
        DatagramPacket b = new DatagramPacket(bytes, bytes.length);
        a.receive(b);
        OS.write(bytes, 0 , bytes.length);
        OS.flush();
        a.close();
    }
}
