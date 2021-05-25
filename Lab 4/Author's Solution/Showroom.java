/**
 * A showroom class that has different vehicles, and the ability to sell and buy vehicles, and change their tyres.
 * 
 */
public class Showroom {
	
	/**
	 * Represents an integer that is used as the showroomId
	 */
	private int showroomId;
	
	/**
	 * Represents the current account balance of the showroom
	 */
	private int currentAccountBalance;
	
	/**
	 * Represents the number of cars the showroom currently has
	 */
	private int numCars;
	
	/**
	 * Represents the number of bikes the showroom currently has
	 */
	private int numBikes;
	
	/**
	 * An array containing all the cars in the showroom
	 */
	private Car[] cars;
	
	/**
	 * An array containing all the bikes in the showroom
	 */
	private Bike[] bikes;
	
	/**
	 * A constant integer having the maximum number of cars that a showroom can have(=10)
	 */
	static final int MAX_CARS = 10;
	
	/**
	 * A constant integer having the maximum number of the bikes that the showroom can have(=15)
	 */
	static final int MAX_BIKES = 15;
	
	/**
	 * Constructor for Showroom class, initializes showroomId, currentAccountBalance, numCars, numBikes, cars, bikes
	 * @param showroomId An integer representing the ID of the showroom
	 */
	public Showroom(int showroomId) {
		this.showroomId = showroomId;
		this.currentAccountBalance = 10000;
		this.numCars = 0;
		this.numBikes = 0;
		this.cars = new Car[MAX_CARS];
		this.bikes = new Bike[MAX_BIKES];
		
	}
	
	/**
	 * Method to get the cars array
	 * @return An array containing all the cars in the showroom
	 */
	public Car[] getCars() {
		return cars;
	}

	/**
	 * Method to get the bikes array
	 * @return An array containing all the bikes in the showroom
	 */
	public Bike[] getBikes() {
		return bikes;
	}

	/**
	 * Method to get the number of bikes in this showroom
	 * @return numBikes 
	 */
	public int getNumBikes() {
		return numBikes;
	}
	
	/**
	 * Method to get the number of cars in this showroom
	 * @return numCars 
	 */
	public int getNumCars() {
		return numCars;
	}
	
	/**
	 * Method to get the current account balance in this showroom
	 * @return currentAccountBalance 
	 */
	public int getCurrentAccountBalance() {
		return currentAccountBalance;
	}
	
	/**
	 * Method to get the showroomId
	 * @return showroomId 
	 */
	public int getShowroomId() {
		return showroomId;
	}
	
	/**
	 * Method to add a car to the showroom, doesn't affect current balance
	 * @param carToAdd The car object of the car to be added
	 */
	public void addCar(Car carToAdd) {
		cars[numCars] = carToAdd;
		numCars++;
	}
	
	/**
	 * Method to add a bike to the showroom, doesn't affect current balance
	 * @param bikeToAdd The bike object of the bike to be added
	 */
	public void addBike(Bike bikeToAdd) {
		bikes[numBikes] = bikeToAdd;
		numBikes++;
	}
	
	/**
	 * Method to remove a car from the showroom, doesn't affect current balance
	 * @param carIdx Index of the car to be removed, in the cars array
	 */
	public void removeCar(int carIdx) {
		for(int i=carIdx; i<numCars-1; i++) {
			cars[i] = cars[i+1];
		}
		numCars--;
	}
	
	/**
	 * Method to remove a bike from the showroom, doesn't affect current balance
	 * @param bikeIdx Index of the bike to be removed, in the bikes array
	 */
	public void removeBike(int bikeIdx) {
		for(int i=bikeIdx; i<numBikes-1; i++) {
			bikes[i] = bikes[i+1];
		}
		numBikes--;
	}
	
	/**
	 * Method to sell a car in the showroom with the given index in the cars array
	 * @param carIdx Index of the car in the cars array
	 * @return An object of type Car having the details of the car to sell 
	 */
	public Car sellCar(int carIdx) {
		Car carToSell = cars[carIdx];
		removeCar(carIdx);
		currentAccountBalance += carToSell.getPrice();
		
		return carToSell;
	}
	
	/**
	 * Method to sell a bike in the showroom with the given index in the bikes array
	 * @param bikeIdx Index of the bike in the bikes array
	 * @return An object of type Bike having the details of the bike to sell 
	 */
	public Bike sellBike(int bikeIdx) {
		Bike bikeToSell = bikes[bikeIdx];
		removeBike(bikeIdx);
		currentAccountBalance += bikeToSell.getPrice();
		
		return bikeToSell;
	}
	
	/**
	 * Method to buy a car (of a particular company and model) from another showroom, with the given price requirement. If the car is found, perform the transaction and return true, else return false.
	 * @param companyName Name of the company of the car
	 * @param modelName Name of the model of the car
	 * @param maxPrice Max price that the showroom is willing to pay
	 * @return true if a car with the given parameters is found and transaction is done, else false
	 */
	public boolean buyCar(String companyName, String modelName, int maxPrice) {
		//check array of showrooms 
		//companyName, modelName should match
		//choose the one with the lowest price
		//price should be <= maxPrice
		//if conditions met, remove that vehicle from the right array of the selling showroom, add it to array of buying showroom
		//return true if sale successful, otherwise return false
				
		
			//checking all showrooms in the city
			for(int i=0; i<City.showrooms.length; i++) {
				
				if(City.showrooms[i].getShowroomId()==showroomId) {
					continue;
				}
				
				//checking each car in the showroom
				Car[] showroomCarsArr = City.showrooms[i].getCars();
				for(int j=0; j<City.showrooms[i].getNumCars(); j++) {
					
					if(showroomCarsArr[j].getCompanyName() == companyName && showroomCarsArr[j].getModelName() == modelName
						&& showroomCarsArr[j].getPrice() <= maxPrice) {
						
						//make the sale
						addCar(City.showrooms[i].sellCar(j));
						currentAccountBalance -= cars[numCars-1].getPrice();
						return true;
					}
				}
			}
			
			return false;
			
	}	
	
	/**
	 * Method to buy a bike (of a particular company and model) from another showroom, with the given price requirement. If the bike is found, perform the transaction and return true, else return false.
	 * @param companyName Name of the company of the bike
	 * @param modelName Name of the model of the bike
	 * @param maxPrice Max price that the showroom is willing to pay
	 * @return true if a bike with the given parameters is found and transaction is done, else false
	 */
	public boolean buyBike(String companyName, String modelName, int maxPrice) {
		//checking all showrooms in the city
		for(int i=0; i<City.showrooms.length; i++) {
			
			if(City.showrooms[i].getShowroomId()==showroomId) {
				continue;
			}
			
			//checking each car in the showroom
			Bike[] showroomBikesArr = City.showrooms[i].getBikes();
			
			for(int j=0; j<City.showrooms[i].getNumBikes(); j++) {
				
				if(showroomBikesArr[j].getCompanyName() == companyName && showroomBikesArr[j].getModelName() == modelName
					&& showroomBikesArr[j].getPrice() <= maxPrice) {
					
					//make the sale
					addBike(City.showrooms[i].sellBike(j));
					currentAccountBalance -= bikes[numBikes-1].getPrice();
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Method to change all tyres of a given car with new tyres of a given tyre company.
	 * @param carObj The car object whose tyres are to be changed
	 * @param newTyreCompany The new tyre company
	 */
	public void changeCarTyres(Car carObj, String newTyreCompany) {
		Car.Tyre[] newTyresArray = new Car.Tyre[4];
		
		for(int i=0; i<=3; i++) {
			newTyresArray[i] = carObj.new Tyre("car", newTyreCompany);
		}
		
		carObj.changeTyres(newTyresArray);
	}
	
	/**
	 * Method to change all tyres of a given bike with new tyres of a given tyre company.
	 * @param bikeObj The bike object whose tyres are to be changed
	 * @param newTyreCompany The new tyre company
	 */
	public void changeBikeTyres(Bike bikeObj, String newTyreCompany) {
		Bike.Tyre[] newTyresArray = new Bike.Tyre[2];
		
		for(int i=0; i<=1; i++) {
			newTyresArray[i] = bikeObj.new Tyre("bike", newTyreCompany);
		}
		
		bikeObj.changeTyres(newTyresArray);
	}
	
}

/*General:
 * Assume all vehicles are always available for sale
 * maxPrice will be reasonable (it will be less than currentAccountBalance)
 * Each showroom will have only one car of a particular model and company
 * Each showroom is a showroom+servicing center, where tyres can also be changed
 * A car can be bought from any showroom that has it and is selling at a price <= maxPrice 
 * A showroom will not try to buy more cars than the maximum it can have 
 */
