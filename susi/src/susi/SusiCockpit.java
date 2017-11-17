package susi;

public class SusiCockpit implements Susi{
	
	private Student students[];

	private boolean isRegistered(Student student) {
		if (students == null)
			return false;
		for (int i = 0; i < students.length; i++)
		{
			if (students[i].equals(student))
				return true;
		}
		return false;
	}

	@Override
	public boolean registerStudent(Student student) {
		if (student != null)
		{
			if(students == null)
			{
				students = new Student[1];
				students[0] = student;
				return true;
			}
			if (students.length >= 1000)
			{
				System.out.println("Sorry, all the places are taken!!!");
				return false;
			}
			if (isRegistered(student))
			{
				System.out.println("This student is already registered in the system");
				return false;
			}
				Student newStudents[] = new Student[students.length + 1];
				for (int i=0; i<students.length;i++)
				{
					newStudents[i] = students[i];
				}
				newStudents[students.length] = student;
				students = new Student[students.length + 1];
				students = newStudents;
				return true;
		}
		return false;
	}

	@Override
	public int getStudentsCount() {
		return students.length;
	}

	@Override
	public boolean setGrade(Student student, Course course, double grade) {
		if(!isRegistered(student))
			return false;
		if (grade >= 2 && grade <=6)
		{
			student.setGrade(course, grade);
			return true;
		}
		return false;
	}

	@Override
	public double getTotalCredits(Student student) {
		if (isRegistered(student))
			return student.getTotalCredits();
		return 0.0;
	}

	@Override
	public double getGPA(Student student) {
		if (isRegistered(student))
			return student.getGPA();
		return 0.0;
	}

}
