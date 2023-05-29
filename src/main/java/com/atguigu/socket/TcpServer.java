package com.atguigu.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket tcpServer = null;
        Socket tcpSocket = null;
        InputStream in  = null;
        OutputStream out = null;
        try{
             tcpServer = new ServerSocket(8000);
            System.out.println("服务端成功启动，监听端口为8000，等待客户端连接...");
            while (true){
                //等待客户端连接
                tcpSocket = tcpServer.accept();
                System.out.println("客户端连接成功，客户端信息为："+tcpSocket.getRemoteSocketAddress());
                //读取客户端的数据
                in = tcpSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len=in.read(buffer))>0){
                    System.out.println(new String(buffer,0,len));
                }
                //向客户端写数据
                out = tcpSocket.getOutputStream();
                out.write("这是向客户端写的数据...".getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
