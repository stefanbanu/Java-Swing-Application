package com.stefanbanu.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7933390278902953432L;

	private JTextArea textArea;
	
	
	public TextPanel() {
		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createEtchedBorder());
		
		setLayout(new BorderLayout());

		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String txt){
		textArea.append(txt);
	}


}
