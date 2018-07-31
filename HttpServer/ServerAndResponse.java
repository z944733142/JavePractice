package app.xupt.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerAndResponse {
    private ServerSocket server;
    private Socket Client;
    public static final String CRLF = "\r\n";
    public static final String BLANK= " ";
    public static void main(String[] args) throws IOException {
        ServerAndResponse aServer = new ServerAndResponse();
        aServer.start();
        aServer.receive();


    }

    public void start() throws IOException {
        server = new ServerSocket(8888);
    }

    public void receive() throws IOException {
        Client = server.accept();

        // 接受
        InputStream IS = Client.getInputStream();
//        StringBuilder msg = new StringBuilder();
//        String n = null;
        byte[] a = new byte[30000];
        int len = IS.read(a);
        System.out.println(new String(a,0,len).trim());
        // 响应
        StringBuilder responseContext = new StringBuilder();
        responseContext.append("<html>\r\n" +
                "<head>\r\n" +
                "<title>\r\n" +
                "第一个表单\r\n" +
                " </title>\r\n" +
                "</head>\r\n" +
                "<body>\r\n" +
                "<pre>\r\n" +
                "some tips\r\n" +
                "</pre>\r\n" +
                "<form method = \"post\" action = \"http://localhost:8888/index.html\">\r\n" +
                "用户名：<input type = \"text\" name = \"uname\" id = \"name\" />\r\n" +
                "密码：<input type = \"password\" name = \"pwd\"  id = \"pass\"/>\r\n" +
                "<input type = \"submit\" value = \"登录\"/>\r\n" +
                "</form>\r\n" +
                "</body>\r\n" +
                "</html>");
        StringBuilder response = new StringBuilder();
        // 1.HTTP协议版本 状态代码 描述
        response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
        // 2. 响应头（response head）
        response.append("Server:zs").append(BLANK).append("Server/0.0.1").append(CRLF);
        response.append("Date:").append(new Date()).append(CRLF);
        response.append("Content-type:text/HTML;charset=UTF-8").append(CRLF);
        response.append("content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
        response.append(CRLF);
        response.append(responseContext);
        OutputStream OS = Client.getOutputStream();
        OS.write(response.toString().getBytes());
        OS.flush();
        OS.close(); 
        IS.close();
    }

}
