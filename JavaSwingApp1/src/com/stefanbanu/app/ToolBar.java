package com.stefanbanu.app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ToolBar extends javax.swing.JPanel implements ActionListener {
	
	JButton button1;
	JButton button2;
	
	private TextPanel textPanel;
	
	public ToolBar() {
		
		button1 = new JButton("Hello!");
		button2 = new JButton("Goodbye!");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(button1);
		add(button2);
	}

	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(button1 == obj){
			textPanel.appendText("Hello! \n");
		}else
			textPanel.appendText("Goodbye! \n");
		
	}

}
