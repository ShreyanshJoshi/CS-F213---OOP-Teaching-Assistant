public class Student {
	private String ID;
	private int preferredLab;
	
	Student(String ID, int preferredLab){
		this.ID = ID;
		this.preferredLab = preferredLab;
	}
	
	String getID() {
		return this.ID;
	}
	
	int getYear() {
		//Extracting characters one by one and converting them to int
		int sum = 0;
		for(int i=0;i<4;i++) {
			int temp = (int)(ID.charAt(i) - '0'); //Typecasting
			sum *= 10;
			sum = sum + temp;
		}
		return sum;
	}
	
	String getBranch() {
		return ID.substring(4, 6);
	}
	
	int getPreferredLab() {
		return preferredLab;
	}
}
