import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private View theView;
	private Model theModel;
	
	public Controller (View v, Model m)
	{
		theView = v;
		theModel = m;
		
		theView.addRefreshListener(new RefreshListener());
	}

	//inner class listener 
	class RefreshListener implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent arg0)
		{
			try
			{
				theModel.setYear(theView.getYear());
				theModel.setMake(theView.getMake());
				theModel.setModel(theView.getModel());
				theModel.setExterior(theView.getExteriorColor());
				theModel.setInterior(theView.getInteriorColor());

				theModel.calcResult();
				theView.setSolution(theModel.getResult());
			}
			catch (Exception e)
			{
				theView.displayErrorMessage(e.getMessage());
			}
		}
	}

}
