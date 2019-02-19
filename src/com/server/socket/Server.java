package com.server.socket;

import java.io.IOException;
import java.net.ServerSocket;

import com.server.main.Main;
import com.server.thread.ServerThread;

public class Server {
	public Server(int port){
		try {
			
			ServerSocket serversocket = new ServerSocket(port);
			ServerThread serverThread = new ServerThread(serversocket);//实现Runnable 实例化服务器并将服务器Socket放到线程类中
			Thread thread = new Thread(serverThread);//实例化一个线程将服务器传进来
			thread.start();//启动线程
			
			
			Main.main.setStateTextarea("服务器已上线");
			System.out.println("服务器已上线");
			
		} catch (IOException e) {
			System.out.println("网络出现错误");
			e.printStackTrace();
		}
		
	}

}
