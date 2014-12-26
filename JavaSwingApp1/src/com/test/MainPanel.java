package com.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel extends JPanel implements ActionListener {

	JButton button1;
	JButton button2;
	
	SomeListener someListener;
	
	
	public MainPanel() {
	
		
		button1 = new JButton("btn1");
		button2 = new JButton("Btn2");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
	
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(button1 == e.getSource()){
			if(someListener != null){
				someListener.actionPerformed("Hi there!");
			}
		}else
			someListener.actionPerformed("bla bla");
		
	}


	public void setListener(SomeListener someListener) {
		this.someListener = someListener;
		
	}
}
