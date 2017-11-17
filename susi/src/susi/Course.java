package susi;

public class Course implements Subject {

	private String id;
	private String name;
	private int credit;

	private void setCredit(int credit) {
		if (credit > 0)
			this.credit = credit;
	}

	public Course(String id, String name, int credit) {
		setId(id);
		setName(name);
		setCredit(credit);
	}

	@Override
	public void setId(String id) {
		if (id != null && !id.isEmpty())
			this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setName(String name) {
		if (name != null && !name.isEmpty())
			this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id.equals(other.id);
	}

	public double getCredit() {
		return credit;
	}

}
