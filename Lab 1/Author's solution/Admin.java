public class Admin {
	public Student[] student;
	public Lab[] labs;
	private int maxPerYearCapacity;
	private int[] currentPerYearStudent;
	private int currentNumberOfStudents;
	private int numberOfLabs;
	private int numberOfStudentsApplied;
	private int[] numberOfPeopleAppliedForALab;
	
	Admin(int maxPerYearCapacity, Lab[] labs){
		student = new Student[100];
		this.labs = labs;
		currentPerYearStudent = new int[4];
		this.maxPerYearCapacity = maxPerYearCapacity;
		numberOfStudentsApplied = 0;
        numberOfLabs=5;
		numberOfPeopleAppliedForALab = new int[numberOfLabs];
       
	}
    //Lab index 0 - 4 only
	int getCurrentNumberOfStudents() {
		return currentNumberOfStudents;
	}
	
	boolean addStudent(Student student) {
		//First checking if there is capacity per year wise
		numberOfStudentsApplied++;
		int labCode = student.getPreferredLab();
		for(int i=0;i<numberOfLabs;i++) {
			if(labs[i].getLabCode() == labCode) {
					numberOfPeopleAppliedForALab[i]++;
			}
		}
		int year = student.getYear();
		int mappedIndex = year - 2017;
		if(currentPerYearStudent[mappedIndex] >= maxPerYearCapacity) 
			return false;

		//Then checking if their preferred lab section has vacancy
		for(int i=0;i<numberOfLabs;i++) {
			if(labs[i].getLabCode() == labCode) {
				if(labs[i].getCurrentNumberOfStudents() >= labs[i].getMaxCapacity()) {
					return false;
				}
				else labs[i].updateCurrentNumberOfStudents();
			}
		}
		//If both satisfied, then adding the student to the students array
		this.student[currentNumberOfStudents++] = student;
		currentPerYearStudent[mappedIndex]++;
		return true;
	}
	
	void increaseLabCapacity(int labCode, int num) {
		for(int i=0;i<numberOfLabs;i++) {
			if(labs[i].getLabCode() == labCode) {
				labs[i].increaseSeats(num);
			}
		}
	}
	
	double successRatio() {
		return (double)currentNumberOfStudents/ numberOfStudentsApplied;
	}
	
	double[] labSuccess() {
		double[] labPerc = new double[numberOfLabs];
		for(int i=0;i<5;i++) {
			labPerc[i] = (double)labs[i].getCurrentNumberOfStudents() / numberOfPeopleAppliedForALab[i];
		}
		return labPerc;
	}
}