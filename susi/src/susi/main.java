package susi;

public class main {

	public static void main(String[] args) {
		Student s = new Student("a",123);
		System.out.println(s.getFacultyNumber());
		Student m = new Student("a",1234);
		System.out.println(s.equals(m));
		SusiCockpit aCockpit = new SusiCockpit();
		Course math = new Course("12", "math", 12);
		Course lit = new Course("123", "lit", 1);
		Course climbing = new Course("124", "math", 2);
		System.out.println(aCockpit.getGPA(s));
		aCockpit.registerStudent(s);
		aCockpit.registerStudent(m); 
		aCockpit.registerStudent(m); 
		aCockpit.registerStudent(s);
		aCockpit.setGrade(s, math, 3);
		aCockpit.setGrade(s, math, 4);
		System.out.println(aCockpit.getGPA(s));
		System.out.println(aCockpit.getTotalCredits(s));

		System.out.println(aCockpit.getStudentsCount());

	}

}
