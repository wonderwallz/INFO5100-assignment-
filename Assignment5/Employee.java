package assignment5;

public abstract class Employee {
	private String Name;
	private int paymentPerHour;
	
	public Employee(String name, int paymentPerHour) {
		this.Name = name;
		this.paymentPerHour = paymentPerHour;
	}
	
	public abstract int calculateSalary();
	
	public String getName() {
		return getClass().getSimpleName();
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getPaymentPerHour() {
		return paymentPerHour;
	}
	public void setPaymentPerHour(int paymentPerHour) {
		this.paymentPerHour = paymentPerHour;
	}

}

class Contractor extends Employee{
	private int workingHours;
	
	public Contractor(String name, int paymentPerHour, int workingHours) {
		super(name,paymentPerHour);
		this.workingHours = workingHours;
	}
	
	public int calculateSalary() {
	    return getPaymentPerHour() * workingHours;
	}
}

class FullTime extends Employee{
	public FullTime(String name, int paymentPerHour) {
		super(name,paymentPerHour);
	}
	
	public int calculateSalary() {
		return 8 * getPaymentPerHour();
	}
}