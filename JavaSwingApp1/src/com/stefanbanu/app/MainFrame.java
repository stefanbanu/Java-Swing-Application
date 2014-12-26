package com.stefanbanu.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2121833309172278947L;

	private TextPanel textPanel;
	private JButton button;
	
	public MainFrame() {
		super("My App");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		button = new JButton("Click me!");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Hello \n");
				
			}
		});
		
		add(textPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
