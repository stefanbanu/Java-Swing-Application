package com.stefanbanu.app;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 2121833309172278947L;

	private TextPanel textPanel;
	private ToolBar toolBar;
	private FormPanel formPanel;
	
	public MainFrame() {
		super("My App");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		toolBar = new ToolBar();
		formPanel = new FormPanel();
		
		toolBar.setStringListener(new MyListener() {
			
			@Override
			public void stringActionPerformed(String text) {
				textPanel.appendText(text);
				
			}
		});
		
		add(formPanel, BorderLayout.WEST);
		add(toolBar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
