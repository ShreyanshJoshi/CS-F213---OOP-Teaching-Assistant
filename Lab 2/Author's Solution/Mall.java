/**
 * 
 * @author Shreyansh, Santosh
 *
 */

public class Mall {
	
	
	/**
	 * Represents the number of shops in the mall.
	 */
    private int shopCount;
    
    
    /**
     * Represents the maximum number of shops that the mall can have. Should be initialized to 6.
     */
    static final int MAX_SHOPS = 6;
    
    
    /**
     * An array of Shop objects that represents all of the shops present in the mall.
     */
    private Shop[] shopList;
    

    /**
     * Constructor for the Mall class. Used to create an array of Shops (shopList) and initialize shopCount.
     */
    public Mall() {
    	shopList = new Shop[MAX_SHOPS];
        shopCount = 0;
    }
    
    
    /**
     * This method is used to add a new Shop to the mall. The new shop is added to the end of shopList.
     * 
     * @param capacity An integer representing the capacity of the shop that is going to be added to the mall.
     * @param price An integer representing the price of each product in this newly added shop.
     * @return True if a shop is successfully added to the mall. False otherwise.
     * 
     */
    public boolean addShop(int capacity, int price) {                       
        if(shopCount < MAX_SHOPS) {
        	shopList [shopCount] = new Shop(capacity, price);
			shopCount+=1;
			return true;
		}
		else
			return false;
    }
    


   /**
    * This method adds a product to the shop in the mall specified by shopNumber.
    * 
    * @param shopNumber An integer used to identify a particular shop in the mall.
    * @param productName A string representing the name of the product to be added to the shop. 
    * @return True if a product is successfully added to the shop. False otherwise.
    * 
    */
    public boolean addProduct(int shopNumber, String productName) {         		  
        if(shopNumber >= 0 && shopNumber < shopCount)
			return shopList[shopNumber].addProduct(productName);
        else 
        	return false;
    }
    
    
    /**
     * This method returns the total number of products present in the entire mall.
     * 
     * @return An integer representing the number of total number of products in the entire mall.
     * 
     */
    public int getTotalProductCount() {
    	
        int totalProductCount = 0;
        for(int i = 0; i < shopCount; i++)
        	totalProductCount += shopList[i].getProductCount();

		return totalProductCount;
    }
    
    
    /**
	 * This method returns the total number of customers that have visited the mall today.
	 * 
	 * @return An integer representing the total number of customers that have visited the mall today.
	 */
    public int getCustomerCountToday() {                       
        int customerCountToday = 0;
        for(int i=0 ; i < shopCount ; i++)
        	customerCountToday += shopList[i].getCustomerCountToday();

		return customerCountToday;
    }
    
    
    /**
     * This method returns the number of customers currently in the mall.
     * 
     * @return An integer representing the number of customers currently in the mall.
     */
    public int getCurrentCustomerCount() { 
    	int currentCustomerCount = 0;
        for(int i = 0 ; i < shopCount ; i++)
        	currentCustomerCount += shopList[i].getCurrentCustomerCount();

		return currentCustomerCount;
    }
    
    
    /**
     * This method returns the total revenue the mall has made today.
     * 
     * @return An integer representing the total revenue the mall has made today.
     */
    public int getRevenueToday() {									
        int revenueToday = 0;
        for(int i = 0; i < shopCount ; i++)
			revenueToday += shopList[i].getRevenueToday();

		return revenueToday;
    }
    
    
    /**
     * This method returns the list of products that are available for purchase in the shop specified by shopNumber.
     * 
     * 
     * @param shopNumber An integer used to identify a particular shop in the mall.
     * @return An array of strings (productList) containing the names of all the products in the shop. Return null if shopNumber is invalid.
     */
    public String[] getProductList (int shopNumber) {
    	if(shopNumber >= 0 && shopNumber < shopCount) 
    		return shopList[shopNumber].getProductList();
    	else
    		return null;
    }
    
    
    /**
     * This method is used to check in a customer to the shop specified by shopNumber.
     * 
     * @param shopNumber An integer used to identify a particular shop in the mall.
     * @param customerID An integer representing the ID of the customer.
	 * @param wantToBuy A boolean variable representing whether the customer wants to buy a product or not. 
	 * @param numProducts An integer representing the number of products that the customer wants to buy. 
     * @return True if a customer is successfully checked in to the shop. False otherwise.
     * 
     */
    public boolean checkIn(int shopNumber, int customerID, boolean wantToBuy, int numProducts) {                         
		if(shopNumber >= 0 && shopNumber < shopCount) 
			return shopList[shopNumber].checkIn(customerID, wantToBuy, numProducts);
		else
			return false;
	}


    /**
     * This method is used to check out a customer from the shop specified by shopNumber.
     * 
     * @param shopNumber An integer used to identify a particular shop in the mall.
     * @return True if a customer is successfully checked out of the shop. False otherwise.
     */
	public boolean checkOut(int shopNumber) {                         
		if(shopNumber >= 0 && shopNumber < shopCount)
			return shopList[shopNumber].checkOut();     
		else
			return false;
	}
}