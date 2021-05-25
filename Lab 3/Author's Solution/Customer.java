/**
 * Represents a customer of the bank - all customers can have upto 5 accounts, but have only 1 savings account.
 */
public class Customer {
	/**
	 * Name of the customer
	 */
	private String customerName;
	/**
	 * Accounts held by a customer
	 */
	Account accounts[];
	/**
	 * The maximum number of accounts that can be held by one customer
	 */
	final static int maxAccounts = 5;
	/**
	 * The number of accounts the customer holds
	 */
	private int numAccounts = 0;
	
	/**
	 * Getter method for customerName
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	/**
	 * Getter method for the numAccounts
	 * @return
	 */
	public int getNumberOfAccounts() {
		return this.numAccounts;
	}

	/**
	 * Initialize a new customer with a standard savings account
	 * The account number of the new account opened is the current value of numAccounts
	 * @param customerName Name of the new customer
	 */
	public Customer(String customerName)
	{
		this.customerName = customerName;
		this.accounts = new Account[maxAccounts];
		accounts[this.numAccounts] = new Account(this.numAccounts);
		this.numAccounts++;
	}

	/**
	 * Initialize a new customer with a premium savings account
	 * The account number of the new account opened is the current value of numAccounts
	 * @param customerName Name of the new customer
	 * @param minBalance Fixed minimum balance of the new account
	 */
	public Customer(String customerName, double minBalance)
	{
		this.customerName = customerName;
		this.accounts = new Account[maxAccounts];
		accounts[this.numAccounts] = new Account(this.numAccounts, minBalance);
		this.numAccounts++;
	}

	/**
	 * To open a new Fixed Deposit account for the existing customer
	 * The account number of the new account opened is the current value of numAccounts
	 * The minimum amount that can be deposited into a fixed deposit account is 5000 and the minimum tenure of deposit is 1 year
	 * @param amount the amount to be deposited
	 * @param numYears the maturity period of the deposit (in years)
	 * @return true if the new account was opened successfully, false otherwise. 
	 */
	public boolean addFDAccount(double amount, int numYears)
	{
		if(this.numAccounts > 0 && this.numAccounts < maxAccounts)
		{
			if(amount >= 5000f && numYears >= 1)
			{
				accounts[this.numAccounts] = new Account(this.numAccounts, amount, numYears);
				this.numAccounts++;
				return true;
			}
			else return false;
		}
		return false;
	}

	/**
	 * To deposit given amount of money into the savings account
	 * @param amount the amount to be deposited
	 * @return true if the deposit was successful
	 */
	public boolean depositAmount(double amount)
	{
		if(this.accounts[0] != null)
			return this.accounts[0].deposit(amount);
		else
			return false;
	}

	/**
	 * To withdraw a given amount from the savings account
	 * @param amount the amount to be withdrawn
	 * @return true if the withdrawal was successful
	 */
	public boolean withdrawAmount(double amount)
	{
		if(this.accounts[0] != null)
			return this.accounts[0].withdraw(amount);
		else 
			return false;
	}

	/**
	 * To check if any of the fixed deposits have reached maturity
	 * if the fixed deposits are matured, transfer the money from deposit account to saving account
	 * also, remove the matured deposits so that new deposits can be opened
	 * @return the number of deposits that have matured.
	 */
	public int fixedDepositsMatured()
	{
		int maturedAccounts = 0;

		int i=1;
		while(i < this.numAccounts)
		{
			if(this.accounts[i].matureFD() > 0)
			{
				this.accounts[0].deposit(this.accounts[i].matureFD());
				for(int j=i; j<this.numAccounts-1; j++)
					this.accounts[j] = this.accounts[j+1];
				this.numAccounts--;
				maturedAccounts++;
			}
			else {
				i++;
			}
		}
		return maturedAccounts;
	}	
}