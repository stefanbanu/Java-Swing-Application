package com.test2;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Panel2 extends JPanel{

	private JTextArea textArea;
	
	public Panel2() {
		
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	public void appendText(String txt){
		textArea.append(txt);
	}
}
