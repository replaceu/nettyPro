package com.atguigu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) {
        try {
            //创建套接字对象socket并封装ip与port
            Socket tcpSocket = new Socket("127.0.0.1", 8000);
            //根据创建的socket对象获得一个输出流
            OutputStream out = tcpSocket.getOutputStream();
            //控制台输入以IO的形式发送到服务器
            System.out.println("tcp连接成功\n请输入：");
            while (true){
                byte[] in = new Scanner(System.in).nextLine().getBytes();
                out.write(in);
                System.out.println("tcp协议的socket发送成功...");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
