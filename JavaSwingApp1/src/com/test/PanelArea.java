package com.test;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelArea extends JPanel{

	private TextArea textArea;
	
	
	public PanelArea() {
		
		textArea = new TextArea();
		
		setLayout(new BorderLayout());

		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String txt){
		textArea.append(txt);
	}
}
