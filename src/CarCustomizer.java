
public class CarCustomizer {
	
	public static void main (String [] args)
	{
		View theView = new View();
		
		Model theModel = new Model ();
		
		@SuppressWarnings("unused")
		Controller theController = new Controller (theView, theModel);
		
		theView.setVisible(true);
		
	}

}
