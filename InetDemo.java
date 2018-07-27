package app.xupt.Net;

import sun.security.krb5.internal.HostAddress;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static app.xupt.Net.InetAddressdemo.func;
import static app.xupt.Net.InetSocketAddressdemo.func2;

public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {
        func();
        func2();
    }
}

class InetAddressdemo {
    public static void func ()
    {
        System.out.println("---------------------------");
        InetAddress a = null;
        try {
            a = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(a.getHostAddress());
        System.out.println(a.getHostName());

        InetAddress b = null;
        try {
            b = InetAddress.getByName("xupt.app");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(b.getHostName());
        System.out.println(b.getHostAddress());

        InetAddress b2 = null;
        try {
            b2 = InetAddress.getByName("222.24.63.101");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(b2.getHostName());
        System.out.println(b2.getHostAddress());
    }
}

class InetSocketAddressdemo {
    public static void func2()
    {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1 ",80);

        System.out.println("---------------------------");
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
        System.out.println(address.getAddress());
    }

}

