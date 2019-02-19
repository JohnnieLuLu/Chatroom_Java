package com.server.mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MainFrame extends JFrame{
	
	
	JLabel success = new JLabel("Identity Confirmed, Welcome !");
	JTextField texts = new JTextField();
	JButton startbutton = new JButton("Let's Rock and Roll  !");
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JTextArea area = new JTextArea();
	
	public MainFrame(){
		
		super("Server");
		this.setSize(600,300);
		this.setLocation(500, 250);
		
		JPanel panelBasic = new JPanel();
		panelBasic.setLayout(new BorderLayout());
		
		JPanel upPanel = new JPanel();
		upPanel.setLayout(null);
		upPanel.setBackground(new Color(120,200,255));
		
		success.setBounds(195,50,250,20);
		upPanel.add(success);
		
		
		//JButton startbutton = new JButton("Let's Rock and Roll  !");
		panelBasic.add(startbutton,BorderLayout.SOUTH);
		startbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int port = getPort();
				if(port != -1){
					startbutton.setEnabled(false);
					success.setVisible(true);
					
				}else{
					ta.append("Sorry,the port you input is wrong"+"\r\n");
				}
				
				
				
			}
		});
		
		
		
	
		JLabel label1 = new JLabel("PORT");
		label1.setBounds(200, 80, 50, 20);
		upPanel.add(label1);
		
		
		texts.setBounds(200+50, 80, 80, 20);
		upPanel.add(texts);
		
		ta.setLineWrap(true);
		sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(0, 105, 585, 130);
		upPanel.add(sp);
		
		success.setVisible(false);
		
		
		panelBasic.add(upPanel,BorderLayout.CENTER);
		
				
		
		this.setContentPane(panelBasic);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
		
		
		
		
		
	}
	
	public int getPort(){
		
		if(texts != null){
			String tmp = texts.getText();
			int resPort = -1;
			try{
				resPort = Integer.parseInt(tmp);
				return resPort;
				
			}catch(Exception e){
				return -1;
			}
			
		}
		
		
		return -1;
		
	}
	
	public void setStateTextarea(String mg){
		if(area != null){
			area.append("\n");
			area.append(mg);
		}
	}

	

	

}