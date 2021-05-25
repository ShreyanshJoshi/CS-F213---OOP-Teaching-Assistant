/**
 * Represents a branch of the bank
 */
public class Bank {
	/**
	 * Customer who hold an account with the bank
	 */
	Customer customers[];
	/**
	 * Maximum number of customers a branch can support
	 */
	final static int maxCustomers = 10;
	
	/**
	 * Number of customers currently registered in the branch
	 */
	private int numCustomers;

	/**
	 * Getter method for numCustomers
	 */
	public int getNumCustomers() {
		return numCustomers;
	}

	/**
	 * Open a new bank branch 
	 */
	public Bank()
	{
		this.customers = new Customer[maxCustomers];
		this.numCustomers = 0;		
	}

	/**
	 * To add a customer to the bank with a standard savings account
	 * new customer with same name as that of an existing customer is not allowed to open an account 
	 * @param Name name of the new customer
	 * @return true if the new account is made successfully
	 */
	public boolean addCustomer(String Name)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(customers[i].getCustomerName()))
				return false;
		}
		customers[this.numCustomers] = new Customer(Name);
		this.numCustomers++;
		return true;
	}

	/**
	 * To add a customer to the bank with a premium savings account
	 * new customer with same name as that of an existing customer is not allowed to open an account
	 * @param Name name of the customer
	 * @param minBalance fixed minimum balance of the new account
	 * @return true if the new account is made successfully
	 */
	public boolean addCustomer(String Name, double minBalance)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(this.customers[i].getCustomerName()))
				return false;
		}
		customers[this.numCustomers] = new Customer(Name, minBalance);
		this.numCustomers++;
		return true;
	}

	/**
	 * To open a new fixed deposit account.
	 * Only existing customers can open a fixed deposit account.
	 * @param Name name of the customer
	 * @param amount amount of the deposit
	 * @param numYears maturity period of the deposit
	 * @return true if the account is made successfully 
	 */
	public boolean openFD(String Name, double amount, int numYears)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(this.customers[i].getCustomerName()))
				return this.customers[i].addFDAccount(amount, numYears);	
		}
		return false;
	}

	/**
	 * To transfer money from one customer to another
	 * @param sender name of the sender
	 * @param receiver name of the receiver
	 * @param amount the amount to be transferred
	 * @return true if the transfer was successful
	 */
	public boolean transferMoney(String sender, String receiver, double amount)
	{
		int senderIndex=-1, receiverIndex=-1;
		for(int i=0; i<this.numCustomers ; i++)
		{
			if(sender.equals(this.customers[i].getCustomerName()))
			{
				senderIndex = i;
			}
			if(receiver.equals(this.customers[i].getCustomerName()))
			{
				receiverIndex = i;
			}
		}
		if(senderIndex!=-1 && receiverIndex!=-1)
		{
			if(this.customers[senderIndex].withdrawAmount(amount) && 
					this.customers[receiverIndex].depositAmount(amount))
					return true;
			else
				return false;
		}
		else 
			return false;
	}

	/**
	 * To deposit money into a customer's account
	 * @param Name name of the customer
	 * @param amount amount to be deposited
	 * @return true if the amount was deposited successfully
	 */
	public boolean depositMoney(String Name, double amount)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(this.customers[i].getCustomerName()))
				return this.customers[i].depositAmount(amount);
		}
		return false;
	}

	/**
	 * To withdraw money from a customer's account
	 * @param Name name of the customer
	 * @param amount amount to be withdrawn
	 * @return true if the amount can be withdrawn successfully
	 */
	public boolean withdrawMoney(String Name, double amount)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(this.customers[i].getCustomerName()))
				return this.customers[i].withdrawAmount(amount);
		}
		return false;
	}

	/**
	 * To check if any of the fixed deposits have matured.
	 * If matured, transfer the amount from deposit account to saving account.
	 * Also, remove the matured deposits so that new one can be opened.
	 * @param Name name of the customer
	 * @return number of fixed deposits that have matured and -1 in other cases
	 */
	public int matureFixedDeposit(String Name)
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			if(Name.equals(this.customers[i].getCustomerName()))
				return this.customers[i].fixedDepositsMatured();
		}
		return -1;
	}

	/**
	 * At the end of each year, update the balance for all accounts of all the customers.
	 */
	public void endYear()
	{
		for(int i=0; i < this.numCustomers; i++)
		{
			for(int j=0; j < this.customers[i].getNumberOfAccounts(); j++)
			{
				this.customers[i].accounts[j].yearEnd();
			}
		}
	}	
}