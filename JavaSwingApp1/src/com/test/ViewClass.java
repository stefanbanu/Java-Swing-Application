package com.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ViewClass extends JFrame  {

	private MainPanel panel;
	private PanelArea panelArea;
	
	public ViewClass() {
		super("Test Window");
		
		setLayout(new BorderLayout());
		panel = new MainPanel();
		panelArea = new PanelArea();
		
		add(panel, BorderLayout.NORTH);
		add(panelArea, BorderLayout.CENTER);
		
		panel.setListener(new SomeListener() {
			
			@Override
			public void actionPerformed(String text) {
				panelArea.appendText(text);
				
			}
		});
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}



}
