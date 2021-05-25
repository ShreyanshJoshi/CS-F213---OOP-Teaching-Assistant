public class Vehicle {
	
	/**
	 * Represents the name of the company of the vehicle
	 */
	private String companyName;
	
	/**
	 * Represents the model name of the vehicle
	 */
	private String modelName;
	
	/**
	 * Represents the registration number of the vehicle
	 */
	private int registrationNum;
	
	/**
	 * Represents the price of the vehicle
	 */
	private int price;
	
	/**
	 * Constructor for the Vehicle class, initializes companyName, modelName, registration number, price
	 * @param companyName Name of the company of this vehicle
	 * @param modelName Name of the model of this vehicle
	 * @param registrationNum Registration number of this vehicle
	 * @param price Price of the vehicle 
	 */
	Vehicle(String companyName, String modelName, int registrationNum, int price) {
		this.companyName = companyName;
		this.modelName = modelName;
		this.registrationNum = registrationNum;
		this.price = price;
	}
	
	/**
	 * A class containing the details of the tyres of the vehicle
	 */
	public class Tyre {
		
		/**
		 * Represents the company of the tyres
		 */
		private String tyreCompany;
		
		/**
		 * Represents the type of the vehicle('car' or 'bike') that the tyres are part of
		 */
		private String vehicleType;
		
		/**
		 * Constructor for the tyre class, initializes vehicleType and tyreCompany
		 * @param vehicleType Type of vehicle 
		 * @param tyreCompany Company of tyres
		 */
		public Tyre(String vehicleType, String tyreCompany) {
			this.tyreCompany = tyreCompany;
			this.vehicleType = vehicleType;
		}
		
		/**
		 * Method to get the type of the vehicle
		 * @return A string variable denoting the vehicle type
		 */
		public String getVehicleType() {
			return vehicleType;
		}
	
		/**
		 * Method to get the tyre company 
		 * @return A string variable denoting the tyre company
		 */
		public String getTyreCompany() {
			return tyreCompany;
		}

	}
	
	/**
	 * Method to get the name of the company of the vehicle
	 * @return A string variable denoting the company name
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Method to get the model name of the company of the vehicle
	 * @return A string variable denoting the model name
	 */
	public String getModelName() {
		return modelName;
	}
	
	/**
	 * Method to get the registration number of the vehicle
	 * @return An integer having the registraion number of the vehicle
	 */
	public int getRegistrationNum() {
		return registrationNum;
	}
	
	/**
	 * Method to get the price of the vehicle
	 * @return An integer having the price of the vehicle
	 */
	public int getPrice() {
		return price;
	}
	
}
