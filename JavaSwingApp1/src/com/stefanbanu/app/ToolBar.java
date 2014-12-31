package com.stefanbanu.app;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;


public class ToolBar extends javax.swing.JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7930172032227393497L;
	JButton button1;
	JButton button2;
	
	private MyListener listener;
	
	public ToolBar() {
		/*Border innerBorder = BorderFactory.createTitledBorder("Tool Bar");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));*/

		
		button1 = new JButton("Hello!");
		button2 = new JButton("Goodbye!");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(button1);
		add(button2);
	}

	public void setStringListener(MyListener listener) {
		this.listener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(button1 == obj){
			if(listener != null){
				listener.stringActionPerformed("Hello World! \n");
			}
		}else
			listener.stringActionPerformed("Goodbye World! \n");
		
	}

}
