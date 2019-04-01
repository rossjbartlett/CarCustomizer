
public class Model {
	
	private int year;
	private String make;
	private String model;
	private String exterior;
	private String interior;
	private String result; // TODO unused
	private String exteriorName;
	private String interiorName;


	
	public String getExterior() {
		return exterior;
	}

	public void setExterior(String exterior) {
		this.exterior = exterior;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	


	public void calcResult() {
		result = (year + "_"+ make + "_"+ model+"_"+exterior + "_"+interior);
		exteriorName = (year + "_"+ make + "_"+ model+"_"+exterior) + ".png";
		interiorName = (make + "_"+ model+"_"+interior) + ".png";
	}

	
	public String getResult()
	{
		return result;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInteriorName() {
		return interiorName;
	}


	public String getExteriorName() {
		return exteriorName;
	}

}
