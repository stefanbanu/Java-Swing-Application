package com.test2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SimplePanel extends JPanel implements ActionListener {

	JButton b1;
	JButton b2;
	MyListener myListener;
	String teet = "Stefan Banu \n";
	String teet2 = "Cris  \n";
	
	public SimplePanel() {
		b1 = new JButton("Buton1");
		b2 = new JButton("Buton2");
		
		setLayout(new FlowLayout());
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(b1);
		add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(b1 == e.getSource()){
			if(myListener != null){
				myListener.myAction(teet);
			}
		}else 
			myListener.myAction(teet2);
	}

	public void setListener(MyListener myListener) {
		this.myListener = myListener;
		
	}
}
