package app.xupt.Net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
//        URL aurl = new URL("http://www.baidu.com:80/index.html#a?uname=zs");
        URL aurl = new URL("http://www.baidu.com");
        System.out.println("协议" + aurl.getProtocol());
        System.out.println("域名" + aurl.getHost());
        System.out.println("端口" + aurl.getPort());
        System.out.println("资源" + aurl.getFile());
        System.out.println("相对路径" + aurl.getPath());
        System.out.println("锚点" + aurl.getRef());
        System.out.println("参数" + aurl.getQuery());   // ？参数 ： 存在锚点返回null，不存在返回正确
    }
}
