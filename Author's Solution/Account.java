/** 
 * Represents a bank account, which can be one of three kinds: Standard Savings account, Premium Savings account, Fixed Deposit account 
 */
public class Account {

	/**
	 * A number to uniquely identify a customer's account
	 */
	private int accountNumber;

	/**
	 * Denotes the type of the bank account - 'S' for Savings accounts, 'F' for Fixed Deposit accounts
	 */
	private char accountType;

	/**
	 * Rate at which bank provides interest on your deposits annually:
	 * 2.7% for Standard Savings accounts, 3.7% for Premium Savings accounts, 4.9% for Fixed Deposit accounts 
	 */
	private float interestRate;

	/**
	 * Total balance of the account
	 */
	private double accountCurrentBalance;

	/**
	 * Minimum allowed balance for an account that has to be maintained 
	 * Transactions below it are not allowed
	 */
	private double minBalance;

	/**
	 * The maturity period of fixed deposit, to be set -1 for Savings accounts
	 */
	private int maturityPeriod;

	/**
	 * Open a Standard Savings account with zero minimum balance
	 * @param account_number the account number
	 */
	public Account(int account_number)
	{
		this.accountNumber = account_number;
		this.accountType = 'S';
		this.minBalance = 0;
		this.accountCurrentBalance = 0;
		this.interestRate = 0.027f;
		this.maturityPeriod = -1;
	}

	/**
	 * Open a Premium Savings account with a fixed minimum balance
	 * @param account_number account number
	 * @param min_balance minimum balance of the account
	 */
	public Account(int account_number, double min_balance)
	{
		this.accountNumber = account_number;
		this.accountType = 'S';
		this.minBalance = min_balance;
		this.accountCurrentBalance = 0;
		this.interestRate = 0.037f;
		this.maturityPeriod = -1;
	}

	/**
	 * Open a Fixed deposit account with a fixed balance and a fixed maturity period
	 * @param account_number account number
	 * @param balance amount to be deposited
	 * @param maturity_period maturity period of the deposit
	 */
	public Account(int account_number, double balance, int maturity_period)
	{
		this.accountNumber = account_number;
		this.accountType = 'F';
		this.accountCurrentBalance = balance;
		this.maturityPeriod = maturity_period;
		this.interestRate = 0.049f;
	}

	/**
	 * Getter method for accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Getter method for accountType
	 */
	public char getAccountType() {
		return accountType;
	}

	/**
	 * Getter method for interestRate
	 */
	public float getInterestRate() {
		return interestRate;
	}

	/**
	 * Getter method for balance
	 */
	public double getBalance() {
		return accountCurrentBalance;
	}

	/**
	 * Getter method for maturityPeriod
	 */
	public int getMaturityPeriod() {
		return maturityPeriod;
	}

	/**
	 * To deposit money to the account
	 * @param depositAmount the amount to be deposited
	 * @return true if the balance after deposit can be stored in the system
	 */
	public boolean deposit(double depositAmount)
	{
		double updatedBalance = this.accountCurrentBalance + depositAmount;
		if(updatedBalance < Double.MAX_VALUE)
		{
			this.accountCurrentBalance = updatedBalance;
			return true;
		}
		return false;
	}
	
	/**
	 * To withdraw money only from a savings account
	 * @param withdrawAmount the amount to be withdrawn
	 * @return true if the withdrawal can be made
	 */
	public boolean withdraw(double withdrawAmount)
	{
		if(this.accountType!='S')
			return false;
		double updatedBalance = this.accountCurrentBalance - withdrawAmount;
		if(updatedBalance >= this.minBalance)
		{
			this.accountCurrentBalance = updatedBalance;
			return true;
		}
		return false;
	}

	/**
	 * To check the value of a fixed deposit.
	 * An FD is worth the balance amount only if the maturity period is over, otherwise it is worth 0.
	 * @return the current balance of a Fixed Deposit Account if it is matured else return zero
	 */
	public double matureFD()
	{
		if(this.accountType == 'F' && this.maturityPeriod == 0)
				return this.accountCurrentBalance;
		else
			return 0;
	}
	
	/**
	 * To evaluate the monetary value of an account at the end of an year.
	 * Add the interest due on the balance amount, and reduce the maturity period for unmatured fixed deposits by an year
	 */
	public void yearEnd()
	{
		if(this.accountType=='S') {
			double interest = (this.accountCurrentBalance) * (this.interestRate);
			double updatedBalance = this.accountCurrentBalance + interest;
			if(updatedBalance < Double.MAX_VALUE)
			{
				this.accountCurrentBalance = updatedBalance;
			}
		}
		if(this.accountType == 'F' && this.maturityPeriod > 0 )
		{
			double interest = (this.accountCurrentBalance) * (this.interestRate);
			double updatedBalance = this.accountCurrentBalance + interest;
			this.maturityPeriod--;
			if(updatedBalance < Double.MAX_VALUE)
			{
				this.accountCurrentBalance = updatedBalance;
			}
		}
	}
}
