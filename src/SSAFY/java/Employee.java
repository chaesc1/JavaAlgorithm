package SSAFY.java;

public class Employee implements Comparable<Employee> {
	private String en;    //사번
	private String name;  //이름
	private String level; //직책
	private int salary;   //월급

  public Employee(String en, String name, String level, int salary){
		this.en = en;
		this.name = name;
		this.level = level;
		this.salary = salary;
	}

	//getter setter 작성
	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	//toString 작성

	@Override
	public String toString() {
		return "Employee{" +
				"en='" + en + '\'' +
				", name='" + name + '\'' +
				", level='" + level + '\'' +
				", salary=" + salary +
				'}';
	}

	@Override
	public int compareTo(Employee o) {
		return this.getEn().compareTo(o.getEn());
	}
}