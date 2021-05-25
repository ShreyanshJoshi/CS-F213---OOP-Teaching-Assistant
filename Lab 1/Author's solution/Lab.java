public class Lab {
	public int labCode;
	private int currentNumberOfStudents;
	public int maxCapacity;
	
	Lab(int labCode, int maxCapacity){
		this.labCode = labCode;
		this.currentNumberOfStudents = 0;
		this.maxCapacity = maxCapacity;
	}
	
	int getLabCode() {
		return labCode;
	}
	
	int getCurrentNumberOfStudents() {
		return currentNumberOfStudents;
	}
	
	int getMaxCapacity() {
		return maxCapacity;
	}
	
	void increaseSeats(int numSeats) {
		maxCapacity += numSeats;
	}
	
	void updateCurrentNumberOfStudents() {
		currentNumberOfStudents++;
	}
}
