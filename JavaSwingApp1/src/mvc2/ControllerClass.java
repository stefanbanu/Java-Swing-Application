package mvc2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClass {

	private ModelClass model;
	private ViewClass view;
	
	public ControllerClass(ViewClass view, ModelClass model) {
	
		this.view = view;
		this.model = model;
		
		view.addCalculateListener(new CalculateListener());
	
	}
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			String name = view.getNr1Field().getText();
			String name2 = view.getNr2Field().getText();
			
			model.appendText(view.getArea(), name, name2);
			
		}
		
	}
}
