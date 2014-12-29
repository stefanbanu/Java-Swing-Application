package mvc2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewClass extends JFrame{
	
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JTextField nr1Field;
	private JTextField nr2Field;
	private JTextField solutionField;
	private JButton okBtn;	
	private JTextArea area;
	

	ViewClass() {
		firstLabel = new JLabel("First Nr: ");
		secondLabel = new JLabel("Second Nr: ");
		nr1Field = new JTextField(5);
		nr2Field = new JTextField(5);
		solutionField = new JTextField(10);
		okBtn = new JButton("+");
		area = new JTextArea();
		
		
		
		this.setLayout(new GridLayout(2,1));

		// Sets up the view and adds the components

		JPanel calcPanel = new JPanel();
		calcPanel.setLayout(new FlowLayout());
		
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		

		calcPanel.add(firstLabel);
		calcPanel.add(nr1Field);
		calcPanel.add(secondLabel);
		calcPanel.add(nr2Field);
		calcPanel.add(okBtn);
		calcPanel.add(solutionField);
		

		this.add(calcPanel);
		
		this.add(new JScrollPane(area));

		// End of setting up the components --------

	}


	public JTextField getNr1Field() {
		return nr1Field;
	}


	public JTextArea getArea() {
		return area;
	}


	public void setArea(JTextArea area) {
		this.area = area;
	}


	public void setNr1Field(JTextField nr1Field) {
		this.nr1Field = nr1Field;
	}


	public JTextField getNr2Field() {
		return nr2Field;
	}


	public void setNr2Field(JTextField nr2Field) {
		this.nr2Field = nr2Field;
	}


	public JButton getOkBtn() {
		return okBtn;
	}


	public void setOkBtn(JButton okBtn) {
		this.okBtn = okBtn;
	}
	// If the calculateButton is clicked execute a method
		// in the Controller named actionPerformed
		
		void addCalculateListener(ActionListener listenForCalcButton){
			
			okBtn.addActionListener(listenForCalcButton); }
	
}
