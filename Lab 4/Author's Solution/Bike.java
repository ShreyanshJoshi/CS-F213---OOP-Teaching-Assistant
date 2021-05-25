public class Bike extends Vehicle{
	
	/**
	 * Array containing tyre objects of the bike
	 */
	private Tyre[] tyres;

	/**
	 * Constructor for the Bike class, initializes the companyName, modelName, registrationNum, price and tyres
	 * @param companyName Name of the bike's company
	 * @param modelName Name of the bike's model
	 * @param registrationNum Registration number of the bike
	 * @param price Price of the bike
	 * @param tyreCompany The company of the bike's tyres
	 */
	public Bike(String companyName, String modelName, int registrationNum, int price, String tyreCompany) {
		super(companyName, modelName, registrationNum, price);
		this.tyres = new Tyre[2];
		
		for(int i=0; i<=1; i++) {
			tyres[i] = new Tyre("bike", tyreCompany);
		}
	}

	/**
	 * Method to get the array of tyres of the bike
	 * @return tyres
	 */
	public Tyre[] getTyres() {
		return tyres;
	}
	
	/**
	 * Method to change the tyres of the bike with the given array of tyres
	 * @param tyres Array containing the new tyres
	 */
	public void changeTyres(Tyre[] tyres) {
		this.tyres = tyres;
	}
}