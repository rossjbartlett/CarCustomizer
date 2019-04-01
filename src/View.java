import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame{
	
	
	private JButton refreshButton = new JButton ("Refresh");
	
	private JLabel exteriorPic = new JLabel();
	private JLabel interiorPic = new JLabel(); 

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
	
	private String[] hondaModels = { "Civic", "Accord"};
	private String[] fordModels = { "F-150", "Mustang"};
	private String[] toyotaModels = {"Camry"};

	Map<String, String[]> makesToModels = new HashMap<String, String[]>();
	private JComboBox<String> modelComboBox = new JComboBox<String>(hondaModels);
	
	JPanel resultPanel;
	JPanel choicesPanel;

	

	View(){
		this.setTitle("CADA Car Customizer");
		this.setSize(950,600);
		this.setResizable(false);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setupComboBoxes();
		setupChoicesPanel();
		setupResultsPanel();

		refreshButton.setAlignmentX(CENTER_ALIGNMENT);

		this.add(choicesPanel);
		this.add(refreshButton);
		this.add(resultPanel);
	}
	
	private void setupComboBoxes() {
		//setup combo boxes map, key (make name) to array of models for that make 
	    makesToModels.put("Honda", hondaModels);
	    makesToModels.put("Ford", fordModels);
	    makesToModels.put("Toyota", toyotaModels);
	    
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
	}

	
	private void setupChoicesPanel() {
		choicesPanel = new JPanel();
		choicesPanel.setLayout(new BoxLayout(choicesPanel, BoxLayout.X_AXIS));
		choicesPanel.setMaximumSize( new Dimension(900, 50));
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
	}
	private void setupResultsPanel() {
		resultPanel = new JPanel ();
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
		resultPanel.setMaximumSize( new Dimension(900, 500));
		resultPanel.add(exteriorPic);
		resultPanel.add(interiorPic);
//		setExteriorPic("pics/2017_Honda_Civic_Black.png");
//		setInteriorPic("pics/Honda_Accord_Beige_Leather.png");
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
	
	public void setExteriorPic (String file)
	{
		setPic (exteriorPic,  file);
	}
	public void setInteriorPic (String file)
	{
		setPic (interiorPic,  file);
	}
	
	
	private void setPic (JLabel jLabel, String file)
	{
		try {
			BufferedImage myPicture = ImageIO.read(new File(file));
			ImageIcon img = new ImageIcon(new ImageIcon(myPicture).getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
			jLabel.setIcon(img);
		} catch (IOException e) {
			System.err.println(e.getMessage() + " "+ file);
			jLabel = new JLabel(file); // TODO not working, maybe make it a blank image 
		}
	}
	
	
	void addRefreshListener (ActionListener listener)
	{
		refreshButton.addActionListener(listener);
	}


	
}
