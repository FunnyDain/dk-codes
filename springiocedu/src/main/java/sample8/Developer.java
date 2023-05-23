package sample8;

public class Developer{

	private Emp emp;		//7과 달리 포함관계(상속관계x)
	private String dept;
	
	public Developer() {
		super();
	}
	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp.toString() + " Department : " + dept;
	}
}
