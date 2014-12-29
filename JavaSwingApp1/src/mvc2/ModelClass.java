package mvc2;

import javax.swing.JTextArea;

public class ModelClass {

	public void appendText(JTextArea area, String text, String sectext){
		area.append(text + ": " + sectext + "\n"); 
	}

}
