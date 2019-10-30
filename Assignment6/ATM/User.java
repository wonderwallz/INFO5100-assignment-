package ATM;

public class User {
	private String name, address, phoneNumber, bankAccountNumber;
	private int age;
	
	User(String name, String phoneNumber){
		this.name=name;
		this.phoneNumber=phoneNumber;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name=name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age=age;
	}
	String getAddress() {
		return address;
	}
	void setAddress(String address) {
		this.address=address;
	}
	String getPhoneNumber() {
		return phoneNumber;
	}
	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	String getBankAccountNumber() {
		return bankAccountNumber;
	}
	void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber=bankAccountNumber;
	}
	public String toString() {
		return name +", "+age+", "+address+", "+phoneNumber+", "+bankAccountNumber;
	}
	

}

class AtmUser extends User{
	private double availableBalance;
	private String password;
	
	double getAvailableBalance() {
		return availableBalance;
	}
	void setAvailableBalance(double availableBalance) {
		this.availableBalance=availableBalance;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password=password;
	}

	AtmUser(String name, String phoneNumber) {
		super(name, phoneNumber);
	}
	AtmUser(String name, String phoneNumber, int age, String cardNumber, String password){
		super(name, phoneNumber);
		super.setAge(age);
		super.setBankAccountNumber(cardNumber);
		this.availableBalance=0.0;
		this.password=password;
	}
	public String toString() {
		return super.toString()+", "+availableBalance+", "+password;
	}
	
}
