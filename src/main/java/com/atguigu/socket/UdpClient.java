package com.atguigu.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpClient {
	public static void main(String[] args) {
		try {
			//DatagramSocket代表声明一个UDP协议的Socket
			DatagramSocket udpSocket = new DatagramSocket(2468);
			//字符串存储人Byte数组
			byte[] in = "udp协议的Socket请求，有可能失败哟...".getBytes();
			//InetSocketAddress类主要作用是封装端口
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
			//DatagramPacket 类用来表示数据报包DatagramPacket
			DatagramPacket packet = new DatagramPacket(in, in.length, address);
			//send()发送数据包
			udpSocket.send(packet);
			System.out.println("udp协议的socket发送成功...");
			udpSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
