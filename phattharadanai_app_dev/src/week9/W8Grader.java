package week9;

public class W8Grader {
	
	public static String decideGrade(int mark) {
		String grade = null;
		if(mark < 50) {
			grade = "F";
		} else if(mark < 60) {
			grade = "D";
		} else if(mark < 70) {
			grade = "C";
		} else if(mark < 80) {
			grade = "B";
		} else {
			grade = "A";
		}
		return grade;
	}

}
