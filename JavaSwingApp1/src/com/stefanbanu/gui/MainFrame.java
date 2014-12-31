package com.stefanbanu.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2121833309172278947L;

	private TextPanel textPanel;
	private ToolBar toolBar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;

	public MainFrame() {
		super("My App");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolBar = new ToolBar();
		formPanel = new FormPanel();
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		setJMenuBar(createMenuBar());

		toolBar.setStringListener(new MyListener() {
			public void stringActionPerformed(String text) {
				textPanel.appendText(text);

			}
		});

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int age = e.getAge();
				String empCat = e.getEmploymentCategory();
				String gender = e.getGender();

				textPanel.appendText(name + " - " + occupation + " - " + age
						+ "," + empCat + " gender: " + gender + "\n");

			}
		});

		add(formPanel, BorderLayout.WEST);
		add(toolBar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(600, 500));
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		menuFile.add(exportDataItem);
		menuFile.add(importDataItem);
		menuFile.addSeparator();
		menuFile.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(menuFile);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();

				formPanel.setVisible(item.isSelected());
			}
		});

		menuFile.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
				
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
				
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Are you sure you want to exit?", "Exit Confirmation",
						JOptionPane.OK_CANCEL_OPTION);
				
				if(action == JOptionPane.OK_OPTION){
				System.exit(0);
				}
			}
		});

		return menuBar;
	}

}
