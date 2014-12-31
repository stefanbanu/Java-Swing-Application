package com.stefanbanu.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private static final long serialVersionUID = -3649004350813203920L;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList<Object> ageList;
	private DefaultListModel<Object> ageModel;
	private JComboBox<String> comboBox;
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;

	public FormPanel() {
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID: ");
		
		createJList();
		createComboBox();
		createRadioButtons();
		
		// set up some mnemonics
		okBtn = new JButton("OK");
		okBtn.setMnemonic(KeyEvent.VK_O);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nameLabel.setLabelFor(nameField);
		
		// set up tax ID
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		citizenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
		
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory obj = (AgeCategory) ageList.getSelectedValue();
				String empCategory = (String) comboBox.getSelectedItem();
				String taxId = taxField.getText();
				boolean usCitizen = citizenCheck.isSelected();
				String genderCommand = genderGroup.getSelection().getActionCommand();
				
				FormEvent ev = new FormEvent(this, name, occupation, obj.getId(), empCategory, taxId, usCitizen, genderCommand);
				
				if(formListener != null){
					formListener.formEventOccurred(ev);
				}
				
			}
		});
	
		createFormPanel();
	}

	private void createRadioButtons() {
		maleRadio = new JRadioButton("male");
		femaleRadio = new JRadioButton("female");
		genderGroup = new ButtonGroup();
		
		maleRadio.setActionCommand("male");
		femaleRadio.setActionCommand("female");
		maleRadio.setSelected(true);

		// set up the radio buttons
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);

	}
	private void createComboBox() {
		comboBox = new JComboBox<String>();
		DefaultComboBoxModel<String>	empModel = new DefaultComboBoxModel<String>();
		empModel.addElement("employed");
		empModel.addElement("self-employed");
		empModel.addElement("unemployed");
		comboBox.setModel(empModel);
		comboBox.setSelectedIndex(0);
		
	}
	private void createFormPanel() {
		Dimension dim = getPreferredSize();		
		dim.width = 250;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//////////// First row ///////////////////////////////////
		
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		////////////Second row ///////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
		
		////////////Third row ///////////////////////////////////
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age: "), gc);
				
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);
		
		// //////////Fourth row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(comboBox, gc);
		
		// //////////Fourth row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("US citizen: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheck, gc);
		
		// //////////Fourth row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxField, gc);
		
		// ////////// maleRadio button row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Gender: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(maleRadio, gc);
		
		////////////femaleRadion button row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(femaleRadio, gc);
		
		//////////// Fifth row  the ok button ///////////////////////////////////
		
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
		
	}
	private void createJList() {
		ageList = new JList<Object>();
		ageModel = new DefaultListModel<Object>();
		
		ageModel.addElement(new AgeCategory(0, "Under 18"));	
		ageModel.addElement(new AgeCategory(1,"18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(112, 70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		
	}
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
		
	}
}
class AgeCategory{
	private int id;
	private String text;

	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	@Override
	public String toString() {
	
		return text;
	}
	public int getId() {
		return id;
	}
	
}
