package mvc2;



public class MainClass {

	public static void main(String[] args) {
		ViewClass theView = new ViewClass();
		ModelClass theModel = new ModelClass();
		
		new ControllerClass(theView, theModel);

		theView.setVisible(true);

	}
}
