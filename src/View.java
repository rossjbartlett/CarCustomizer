import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame{
	
	
	private JButton refreshButton = new JButton ("Refresh");
	
	private JTextField solution = new JTextField(25); //TODO rename, make this an image

	private JLabel exteriorLabel = new JLabel ("Exterior Color:");
	private JLabel interiorLabel = new JLabel ("Interior");
	private JLabel yearLabel = new JLabel ("Year:");
	private JLabel makeLabel = new JLabel ("Make:");
	private JLabel modelLabel = new JLabel ("Model:");

	
	private String[] exteriors = { "Black", "Red", "Blue"};
	private String[] interiors = { "Black Cloth", "Black Leather", "Beige Leather"};
	private JComboBox<String> exteriorColorComboBox = new JComboBox<String>(exteriors);
	private JComboBox<String> interiorColorComboBox = new JComboBox<String>(interiors);
	

	private Integer[] years = { 2019, 2018, 2017 };
	private JComboBox<Integer> yearComboBox = new JComboBox<Integer>(years);


	private String[] makes = { "Honda", "Ford", "Toyota"};
	private JComboBox<String> makeComboBox = new JComboBox<String>(makes);
	
	private String[] hondaModels = { "Civic", "Accord", "Ridgeline"};
	private String[] fordModels = { "F-150", "Focus", "Mustang"};
	private String[] toyotaModels = { "Camry", "Prius", "Corolla"};

	Map<String, String[]> makesToModels = new HashMap<String, String[]>();
	private JComboBox<String> modelComboBox = new JComboBox<String>(hondaModels);

	

	View(){
		this.setSize(900,600);
		this.setResizable(false);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicesPanel = new JPanel ();

		JPanel resultPanel = new JPanel ();
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));


	    makesToModels.put("Honda", hondaModels);
	    makesToModels.put("Ford", fordModels);
	    makesToModels.put("Toyota", toyotaModels);

		makeComboBox.setSelectedIndex(0); 
		makeComboBox.setSelectedIndex(0);

		choicesPanel.add(yearLabel);
		choicesPanel.add(yearComboBox);
		choicesPanel.add(makeLabel);
		choicesPanel.add(makeComboBox);
		choicesPanel.add(modelLabel);
		choicesPanel.add(modelComboBox);
		choicesPanel.add(exteriorLabel);
		choicesPanel.add(exteriorColorComboBox);
		choicesPanel.add(interiorLabel);
		choicesPanel.add(interiorColorComboBox);

		solution.setAlignmentX(CENTER_ALIGNMENT);
		resultPanel.add(solution);
		refreshButton.setAlignmentX(CENTER_ALIGNMENT);
		resultPanel.add(refreshButton);

		
		makeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//auto-update the model choices according to the selected make 
				modelComboBox.removeAllItems();
		        for (String model : makesToModels.get(getMake())) { // get models for that make
		            modelComboBox.addItem(model);
		        }
			}
		});

		this.add(choicesPanel);
		this.add(resultPanel);

	}

	public int getYear()
	{
		return (int) yearComboBox.getSelectedItem();
	}
	public String getMake()
	{
		return (String) makeComboBox.getSelectedItem();
	}
	public String getModel()
	{
		return (String) modelComboBox.getSelectedItem();
	}
	public String getExteriorColor()
	{
		return (String) exteriorColorComboBox.getSelectedItem();
	}
	public String getInteriorColor()
	{
		return (String) interiorColorComboBox.getSelectedItem();
	}
	
	public void setSolution (String string)
	{
		solution.setText(string);
	}
	void addRefreshListener (ActionListener listenForCalcButton)
	{
		refreshButton.addActionListener(listenForCalcButton);
	}
	void displayErrorMessage (String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}


	
}
