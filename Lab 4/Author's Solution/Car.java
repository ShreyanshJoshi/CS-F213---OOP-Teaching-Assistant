public class Car extends Vehicle {
	
	/**
	 * Array containing tyre objects of the car
	 */
	private Tyre[] tyres;
	
	/**
	 * Constructor for the Car class, initializes the companyName, modelName, registrationNum, price, and tyres
	 * @param companyName Name of the car's company
	 * @param modelName Name of the car's model
	 * @param registrationNum Registration number of the car
	 * @param price Price of the car
	 * @param tyreCompany The company of the car's tyres
	 */
	public Car(String companyName, String modelName, int registrationNum, int price, String tyreCompany) {
		super(companyName, modelName, registrationNum, price);
		this.tyres = new Tyre[4];
		
		for(int i=0; i<=3; i++) {
			tyres[i] = new Tyre("car", tyreCompany);
		}
		
	}

	/**
	 * Method to return the array containing the car's tyres
	 * @return tyres
	 */
	public Tyre[] getTyres() {
		return tyres;
	}

	/**
	 * Method to change the tyres of the car with the given array of tyres.
	 * @param tyres array of tyres that are to be changed
	 */
	public void changeTyres(Tyre[] tyres) {
		this.tyres = tyres;
	}
	
}
