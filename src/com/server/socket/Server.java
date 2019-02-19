package com.server.socket;

import java.io.IOException;
import java.net.ServerSocket;

import com.server.main.Main;
import com.server.thread.ServerThread;

public class Server {
	public Server(int port){
		try {
			
			ServerSocket serversocket = new ServerSocket(port);
			ServerThread serverThread = new ServerThread(serversocket);//ʵ��Runnable ʵ��������������������Socket�ŵ��߳�����
			Thread thread = new Thread(serverThread);//ʵ����һ���߳̽�������������
			thread.start();//�����߳�
			
			
			Main.main.setStateTextarea("������������");
			System.out.println("������������");
			
		} catch (IOException e) {
			System.out.println("������ִ���");
			e.printStackTrace();
		}
		
	}

}
