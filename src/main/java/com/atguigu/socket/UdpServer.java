package com.atguigu.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) {
        try {
            //DatagramSocket代表声明一个UDP协议的Socket
            DatagramSocket udpSocket = new DatagramSocket(8888);
            //byte数组用于数据存储
            byte[] data = new byte[1024];
            //DatagramPacket 类用来表示数据报包DatagramPacket
            DatagramPacket udpPacket = new DatagramPacket(data, data.length);
            //创建DatagramPacket的receive()方法来进行数据的接收,等待接收一个socket请求后才执行后续操作
            System.out.println("等待udp协议传输数据...");
            udpSocket.receive(udpPacket);
            //packet.getLength返回将要发送或者接收的数据的长度
            int length = udpPacket.getLength();
            System.out.println("数据来了："+new String(data,0,length));
            udpSocket.close();
            System.out.println("udp协议Socket接收成功...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
