package susi;

public class Student implements User{

	private String name;
	private int facultyNumber;
	private double grades[];
	private Course courses[];
	
	private void updateCourseGrade(int index, double grade) {
		grades[index] = grade;
		
	}

	private int getRepeatedCourseIndex(Course course) {
		for(int i = 0; i < courses.length; i++)
		{
			if (courses[i] == course)
			{
				return i;
			}
		}
		return -1;
	}
	
	public Student(String name, int facultyNumber) {
		setName(name);
		setFacultyNumber(facultyNumber);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		if(name != null && !name.isEmpty())
			this.name = name;		
	}

	@Override
	public int getFacultyNumber() {
		return facultyNumber;
	}

	@Override
	public void setFacultyNumber(int facultyNumber) {
		if (facultyNumber > 0)
			this.facultyNumber = facultyNumber;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return facultyNumber == other.facultyNumber;
	}

	public boolean setGrade(Course course, double grade)
	{
		if (course != null)
		{
			if (courses == null)
			{
				courses = new Course[1];
				courses[0] = course;
				grades = new double[1];
				grades[0] = grade;
				return true;
			}
			int index = getRepeatedCourseIndex(course);

			if (index >= 0)
			{
				updateCourseGrade(index, grade);
				return true;
			}
			Course tempCourses[] = new Course[courses.length + 1];
			double tempGrades[] = new double[courses.length + 1];
			for(int i = 0; i < courses.length; i++)
			{
				tempCourses[i] = courses[i];
				tempGrades[i] = grades[i];
			}
			tempCourses[courses.length] = course;
			tempGrades[courses.length] = grade;
			courses = tempCourses;
			grades = tempGrades;
			return true;
		}
		return false;
		
	}

	public double getGPA() {
		double sum = 0;
		double avg = 0;
		if (grades != null)
		{
			for(int i = 0; i < grades.length; i++)
				sum+=grades[i]; 
			avg = sum/grades.length;
		}
		return avg;
	}

	public double getTotalCredits() {
		double sum = 0;
		if (courses != null)
		{
			for(int i = 0; i < courses.length; i++)
				sum+=courses[i].getCredit(); 
		}
		return sum;
	}

}



