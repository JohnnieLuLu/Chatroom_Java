package com.server.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

import com.server.main.Main;

public class ServerThread implements Runnable{
	
	ServerSocket serversocket;
	private static Vector<ClientThread> clientThreadList = new Vector<ClientThread>();

	public ServerThread(ServerSocket serversocket){
		if(serversocket != null){
		this.serversocket = serversocket;
		}
		
	}
	
	
	public void run() {
		while(true){
			try {
				Socket socket = serversocket.accept();
				
				InputStream is = socket.getInputStream();
				byte[] buff = new byte[1024];
				int len = is.read(buff);
				while(len != -1){
					System.out.println("");
					len = is.read();
				}
				ClientThread clientThread = new ClientThread(socket);//ʵ�����ͻ��˵��߳� ��Ӧ�Ŀͻ���Socket��Ϊ����
				Thread thread = new Thread(clientThread);//��ʼ�����߳�
				thread.start();
				clientThreadList.add(clientThread);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void sendAll(String msg){
		Iterator<ClientThread> clieniterator = clientThreadList.iterator();
		int sendNum = 0;
		
		while(clieniterator.hasNext()){
			ClientThread iClienThread = clieniterator.next();
			boolean isRun = false;
			if(iClienThread !=null){
				isRun = iClienThread.send(msg);
			}
			if(!isRun){
				Main.main.setStateTextarea("�пͻ����˳�");
				clieniterator.remove();
			}else{
				sendNum++;
			}
		}
	}
	

}
