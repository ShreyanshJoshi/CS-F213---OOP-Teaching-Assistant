/**
 * 
 * @author Shreyansh, Santosh
 *
 */
public class Customer {
	
	/**
	 * Represents the ID of the customer.
	 */
	private int customerID;
	
	
	/**
	 * Represents whether the customer wants to buy a product or not. 
	 */
	private boolean wantToBuy;
	
	
	/**
	 * Represents the number of products that the customer wants to buy IF he/she wants to buy a product. If wantToBuy is true, numProducts should be > 0. If wantToBuy is false, numProducts doesn't matter.
	 */
	private int numProducts;
	
	
	/**
	 * Constructor for the Customer class. Used to initialize customerID, wantToBuy, and numProducts.
	 * @param customerID An integer representing the ID of the customer.
	 * @param wantToBuy A boolean variable representing whether the customer wants to buy a product or not. 
	 * @param numProducts An integer representing the number of products that the customer wants to buy. This value does not matter if wantToBuy is false.
	 */
	public Customer (int customerID, boolean wantToBuy, int numProducts) {	
		this.customerID = customerID;
		this.wantToBuy = wantToBuy;
		this.numProducts = numProducts;
	}
	
	
	
	/**
	 * This method returns whether a customer wants to buy a product or not.
	 * @return A boolean variable that represents whether a customer wants to buy a product or not. 
	 */
	public boolean getWantToBuy() {
		return wantToBuy;
	}
	
	
	/**
	 * This method returns the number of products that the customer wants to buy
	 * @return An integer that represents the number of products that the customer wants to buy. 
	 */
	public int getNumProducts() {
		return numProducts;
	}
	
	
	/**
	 * This method returns the ID of the customer.
	 * @return An integer that represents the ID of the customer.
	 */
	public int getCustomerID() {
		return customerID;
	}
}