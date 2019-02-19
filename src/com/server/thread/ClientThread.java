package com.server.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.server.main.main;


public class ClientThread implements Runnable{

	private Socket clientSocket;
	private PrintWriter clientPrint;
	private String clientIp;
	private InputStream is;
	private OutputStream os;
	//�������췽�� �ѿͻ��˵�socket��Ϊ����
	public ClientThread(Socket socket){
		//�ѿͻ��˵�����socket��ֵ���Լ���Աsocket
		this.clientSocket = socket;
		
		try{
			//��ȡ������
			is = socket.getInputStream();
			os = socket.getOutputStream();
		} catch (IOException e){
			e.printStackTrace();                                                             
		}
		
	}
	
	public boolean send(String author, String msg){
		if(clientSocket != null){
			try{
				clientPrint = new PrintWriter(clientSocket.getOutputStream());
				clientPrint.write(author+":"+msg);
				clientPrint.flush();
				return true;
			}catch(Exception e){
				main.mainFrame.setStateTextArea("�ͻ�["+clientIp+"]�Ͽ�������");
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	public void run() {
		
		while(true){
			if(socket != null){
				try{
					InputStream is = socket.getInputStream();
					byte[] buff = new byte[1024];
					int l = is.read(buff);
					while(l != -1){
						ServerThread.sendAll(new String[buff]);
						l = is.read(buff);
					}
				}else{
					break;
				}
			}
			
			
		}
		
	}

}
