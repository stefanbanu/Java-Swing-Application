package com.test2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	SimplePanel sp;
	Panel2 p2;
	
	public Window() {
		super("fdsfds");
		
		
		sp = new SimplePanel();
		p2 = new Panel2();
		
		setLayout(new BorderLayout());
		
		sp.setListener(new MyListener() {
			
			@Override
			public void myAction(String txt) {
				p2.appendText(txt);
				
			}
		});
		
		add(sp, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
