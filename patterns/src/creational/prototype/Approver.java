package creational.prototype;

public class Approver {

	private String name;
	private String designation;

	public Approver(String name, String designation){
		this.name = name;
		this.designation = designation;
	}

	public String toString(){
		return "[Approver: " + name + "," + designation + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}