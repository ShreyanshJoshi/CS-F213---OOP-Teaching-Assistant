/**
 * @author Anirudh Nagaraj
 * @author Dhaval Pungaliya
 * @author Yash Kothawade
 * 
 * Package containing 2 classes-Stadium and Stall.
 */


package infrastructure;

/**
 * 
 * Stadium class.
 *
 */

public class Stadium {
	/**
	 * unique stadium ID
	 */
	private int stadiumID;
	
	/**
	 * The name of the home team associated with this stadium.
	 */
	private String homeTeamName;
	
	/**
	 * The number of stalls currently associated with this stadium.
	 */
	private int numberOfStalls;
	
	/**
	 * The maximum number of stalls that can be associated with this stadium. Initialize the value to 4.
	 */
	private static final int MAX_STALLS = 4;
	
	/**
	 * An array of Stalls associated with this stadium.
	 */
	private Stall[] stallsArray;
	
	/**
	 * Constructor to initialize the data members.
	 * @param stadiumID
	 * @param homeTeamName
	 */
	
	public Stadium(int stadiumID, String homeTeamName) {
		this.stadiumID = stadiumID;
		this.homeTeamName = homeTeamName;
		this.numberOfStalls = 0;
		this.stallsArray = new Stall[Stadium.MAX_STALLS];
	}
	
	/**
	 * 
	 * Stall class.
	 *
	 */
	
	private class Stall{
		
		/**
		 * The revenue this stall generates.
		 */
		private int revenueGenerated;
		
		/**
		 * Stall constructor that initializes the data member.
		 * @param revenueGenerated
		 */
		
		private Stall(int revenueGenerated) {
			this.revenueGenerated = revenueGenerated;
		}
		
		/**
		 * 
		 * @return The revenue generated by this stall.
		 */
		
		private int getRevenueGenerated() {
			return this.revenueGenerated;
		}
	}
	
	/**
	 * 
	 * @return The stadium ID.
	 */
	
	public int getStadiumID() {
		return this.stadiumID;
	}
	
	/**
	 * 
	 * @return The name of the home team associated with this stadium.
	 */
		
	public String getHomeTeamName() {
		return this.homeTeamName;
	}
	
	/**
	 * 
	 * @return The number of stalls currently associated with this stadium.
	 */
	
	public int getNumberOfStalls() {
		return this.numberOfStalls;
	}
	
	/**
	 * 
	 * @return The array of Stalls associated with this stadium.
	 */
	
	public Stall[] getStallsArray() {
		return this.stallsArray;
	}
	
	/**
	 * Add a stall to the stadium. 
	 * A stall cannot be added to the stadium if all the slots are full.
	 * @param revenueGenerated
	 * @return True if the Stall is added to the Stadium successfully, false otherwise.
	 * 
	 */
	
	public boolean addStall(int revenueGenerated) {
		if(this.numberOfStalls >= Stadium.MAX_STALLS) {
			return false;
		}
		Stall newStall = new Stall(revenueGenerated);
		this.stallsArray[this.numberOfStalls++] = newStall;
		return true;
	}
	
	/**
	 * 
	 * @return The revenue this stadium generated, which is the sum of the revenues generated by each stall in this stadium.
	 */
	
	public int getStadiumRevenue() {
		int stadiumRevenue = 0;
		for(Stall currentStall : this.stallsArray) {
			stadiumRevenue += currentStall.getRevenueGenerated();
		}
		return stadiumRevenue;
	}
	
}
