/**
 * 
 * @author Santosh, Shreyansh
 *
 */
public class Shop {
	
	/**
	 * Represents the maximum number of customers that can be in the shop at any point of time.
	 */
    private int capacity;
    
    
    /**
     * Represents the price of a product. All of the products in a shop have this same price.
     */
    private int priceOfProduct;
    
    
    /**
     * Represents the number of customers currently present in the shop.
     */
    private int currentCustomerCount;
    
    
    /**
     * Represents the number of customers who have visited the shop today.
     */
    private int customerCountToday;
    
    
    /**
     * Represents the number of products that the shop currently has.
     */
    private int productCount;
    
    
    /**
     * Represents the total revenue that the shop has made today.
     */
    private int revenueToday;
    
    
    /**
     * An array of strings containing the names of all the products in the shop.
     */
    private String [] productList;
    
    /**
     * An array of Customer objects that stores each customer that is present in the shop.
     */
    private Customer [] customerList;
    
    /**
     * Represents the maximum number of products that a shop can sell. Should be initialized to 10.
     */
    static final int MAX_PRODUCTS = 10;
    
    

    /**
     * 
     * Constructor for the Shop class. It is used to initialize capacity, priceOfProduct, productList, customerList, currentCustomerCount, customerCountToday, productCount, and revenueToday.
     * 
     * @param capacity An integer representing the maximum number of customers that can be in the shop at any point of time.
     * @param priceOfProduct An integer representing the price of all the products in the shop. All products in the shop have the same price.
     * 
     */
    public Shop (int capacity, int priceOfProduct) {            
		this.capacity = capacity;
        this.priceOfProduct = priceOfProduct;
		productList = new String[MAX_PRODUCTS];
		customerList = new Customer [capacity];
		currentCustomerCount = 0;
		customerCountToday = 0;
		productCount = 0;
        revenueToday = 0;
	}
    

    /**
     * This method is used to add a new product of type string to productList (if possible). New products are added to the end of productList.
     * 
     * @param productName A string that denotes the name of the product.
     * @return True if an item is added to the product list and false otherwise.
     * 
     */
    public boolean addProduct (String productName) {
        if(productCount < MAX_PRODUCTS) {
			productList [productCount] = productName;
			productCount += 1;
			return true;
		}
		else 
			return false;
    }
    
    
    /**
     * This method returns the number of products available for purchase in the shop.
     * 
     * @return An integer representing the number of products that the shop currently has.
     */
    public int getProductCount() {
        return productCount;
    }
    
    
    
    /**
     * 	This method returns the list of products that are available for purchase in the shop.
     * 
     * @return An array of strings (productList) containing the names of all the products in the shop.
     */
    public String[] getProductList() {
    		return productList;
    }
    
    
    
    /**
     * This method returns the number of customers that have visited the shop today.
     * 
     * @return An integer representing the number of customers that have visited the shop today.
     */
    public int getCustomerCountToday() {
        return customerCountToday;
    }
    
    
    /**
     * This method returns the number of customers that are currently present in the shop.
     *
     * @return An integer representing the number of customers that are currently present in the shop
     */
    public int getCurrentCustomerCount() {
    	return currentCustomerCount;
    }
    
    
    /**
     * This method returns the total revenue that the shop has made today.
     * 
     * @return An integer representing the total revenue that the shop has made today.
     */
    public int getRevenueToday() {
        return revenueToday;
    }
    
    
    
    /**
     * This method is used to check in a customer to the shop. The new customer is added to the end of customerList. Note that customers buy a product only while checking-out from the shop and not upon checking in.
     * 
     * @param customerID An integer representing the ID of the customer entering the shop.
     * @param wantToBuy A boolean variable representing whether a customer wants to buy a product or not. True if he/she wants to buy products from the shop and false otherwise
     * @param numProducts An integer representing the number of products that the customer wants to buy IF he/she wants to buy a product.
     * 
     * @return True if a customer can enter a shop. False if there are too many people in the shop and hence the customer cannot enter.
     * 
     */
    public boolean checkIn(int customerID, boolean wantToBuy, int numProducts) {                          
    	
		if(currentCustomerCount < capacity) {
			customerList [currentCustomerCount] = new Customer(customerID, wantToBuy, numProducts);
			currentCustomerCount += 1;
			customerCountToday += 1;
			return true;
		}
		else
			return false;
	}
    

    /**
     * This method is used to checkout a customer from the shop. Products are bought while checking out.
     * Items in the shop are bought from the beginning (index 0) of productList. Customers are checked-out from the end of customerList.
     * Hence, productList, customerList, and the relevant fields are to be updated accordingly.
     * 
     * If the number of products that the customer wants to buy (numProducts) is greater than the number of products available in the shop (productCount),
     * then the customer buys all the products left in the shop.
     * 
     * Note that only the remaining products would be checked in the test cases.
     * 
     * @return True if a customer exits a shop and false if there are no more customers left in the shop.
     * 
     */
	public boolean checkOut() {
		if(currentCustomerCount > 0) {
			currentCustomerCount-=1;			// just decreasing the count is enough. No need to free the space occupied before, it can be overwritten later
			
			if(customerList[currentCustomerCount].getWantToBuy()==true) {
				
				int var = Math.min(productCount, customerList[currentCustomerCount].getNumProducts());		// these many products will be bought
				int temp = productCount;																// holds the current value of no of products
		        productCount -= var;
		        revenueToday += priceOfProduct*var;
		        
		        String [] productList2 = new String[MAX_PRODUCTS];
		        for(int i=0; i<temp-var; i++) 
		        	productList2[i] = productList[var+i];
		       
		        for(int i=0; i<temp-var; i++)
		        	productList[i] = productList2[i];
		         
			}
			return true;
		}
		else
			return false;
	}
}