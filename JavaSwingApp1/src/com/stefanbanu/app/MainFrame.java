package com.stefanbanu.app;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2121833309172278947L;

	private JTextArea textArea;
	private JButton button;
	
	public MainFrame() {
		super("My App");
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		button = new JButton("Click me!");
		
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
