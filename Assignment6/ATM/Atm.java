package ATM;
import java.util.*;

public class Atm {
	private double availableAmountInMachine;
	private double transactionFee;
	private static final int recentTransNum=10;
	
	protected static Map<String, AtmUser> customers;
	
	protected static Map<String,String> nameToAccount;
	
	protected static Map<String, List<String>> transactions;
	
	Scanner scanner;
	
	double getAvailableAmountInMachine() {
		return availableAmountInMachine;
	}
	double getTransactionFee() {
		return transactionFee;
	}
	void setTransactionFee(double transactionFee) {
		this.transactionFee=transactionFee;
	}
	Map<String, String> getNameToAccount(){
		return nameToAccount;
	}
	void setNameToAccount(Map<String, String> nameToAccount) {
		Atm.nameToAccount=nameToAccount;
	}
	protected Map<String, AtmUser> getCustomers(){
		return customers;
	}
	void setCustomers(Map<String, AtmUser> customers) {
		Atm.customers=customers;
	}
	protected static Map<String, List<String>> getTransactions(){
		return transactions;
	}
	protected static void setTransactions(Map<String, List<String>> transactions) {
		Atm.transactions=transactions;
	}
	
	public Atm() {
		this(true,true);
	}
	public Atm(boolean loadRecentRecords, boolean backToStart) {
		this(loadRecentRecords, backToStart);
	}
	protected Atm(double money, double fee, boolean loadRecentRecords, boolean backToStart) {
		scanner = new Scanner(System.in);
		availableAmountInMachine=money;
		transactionFee=fee;
		if(!loadRecentRecords) {
			Atm.customers=new HashMap<>();
			Atm.nameToAccount=new HashMap<>();
			Atm.transactions=new HashMap<>();
		}else {
			Atm.loadData();
		}
		if(backToStart) {
			this.start();
		}
	}
	
	void start() {
		 System.out.println("Are you a current or new user? New->1; Current->2; Forget password->0");
			 String input = scanner.nextLine();
			 if(input.equals("1")) {
				 AtmUser user=this.register();
				 this.run(user);
			 }else if(input.equals("2")){
				 this.login();
			 }else if(input.equals("0")) {
				 this.resetPassword();
			 }
	}
	AtmUser register() {
		AtmUser user = new AtmUser();
		System.out.println("What is your bank account number?: ");
		user.setBankAccountNumber(scanner.nextLine());
		System.out.println("Create your password: ");
		user.setPassword(scanner.nextLine());
		System.out.println("What is your phone number?: ");
		user.setPhoneNumber(scanner.nextLine());
		System.out.println("What is your name?: ");
		user.setName(scanner.nextLine());
		System.out.println("How old are you?: ");
		user.setAge(scanner.nextInt());
	}
	void register(AtmUser user) {
		customers.put(user.getBankAccountNumber(), user);
		nameToAccount.put(user.getName(), user.getBankAccountNumber());
	}
	
	void login(String name) {
		System.out.println("Enter your name and password to log in your account: ");
		String Name = scanner.nextLine();
		String password = scanner.nextLine();
		AtmUser user = customers.get(nameToAccount.get(Name));
		if(user!=null && user.getPassword().equals(password)) {
			String account = nameToAccount.get(name);
			this.run(user);
		}
			
	}
	
	private void run(AtmUser user) {
			String input = scanner.nextLine();
			if(input.equals("get balance")) {
				this.getBalance(user);
			}else if(input.equals("withdraw")) {
				System.out.println("How much would you like to withdraw?");
				double withdrawal = scanner.nextDouble();
				if(withdrawal>user.getAvailableBalance()) {
					System.out.println("You can't withdraw more than your balance.")
				}else {
					double balance = user.getAvailableBalance()-withdrawal;
				}
			}else if(input.equals("deposit")) {
				System.out.println("How much do you want to deposit?");
				double deposit = scanner.nextDouble();
				this.deposit(user,deposit);
			}else if(input.equals("recent transactions")) {
				this.recentTransactions(user);
			}else if(input.equals("change password")) {
				String newPassword = scanner.nextLine();
				this.changePassword(user, newPassword);
			}else if(input.equals("exit")) {
				this.exit();
			}
		
	}
    void exit() {
		System.out.println("You have logged out and finished process.");
		scanner.close();
		return;
		
	}
	void changePassword(AtmUser user, String newPassword) {
		user.setPassword(newPassword);
		System.out.println("You have changed your password.");
		
	}
	void recentTransactions(AtmUser user) {
		List<String> record = transactions.get(user.getBankAccountNumber());
		for(int i=record.size()-1;i>=record.size()-1-10;i--) {
			System.out.println(record.get(i));
		}
		
	}
	void deposit(AtmUser user, double deposit) {
		double balance = user.getAvailableBalance()+deposit;
		user.setAvailableBalance(balance);
		this.availableAmountInMachine+=deposit;
		
	}
   double getBalance(AtmUser user) {
		double balance = user.getAvailableBalance();
		System.out.println("Your balance is "+balance);
		return balance;
		
	}
	boolean resetPassword() {
		System.out.println("Enter your name, age and phone number to reset password: ");
		String name = scanner.nextLine();
		int age = scanner.nextInt();
		String phoneNumber = scanner.nextLine();
		if(this.validate(name, age, phoneNumber)) {
			System.out.println("You are a verified user. Enter your new password: ");
			String passord = scanner.nextLine();
			return this.resetPassword();
		}else {
			return false;
		}
	}
	private boolean validate(String name, int age, String phoneNumber) {
		AtmUser user = customers.get(nameToAccount.get(name));
		if(user.getName().equals(name) && user.getAge()==age && user.getPhoneNumber().equals(phoneNumber)) {
			return true;
		}else
		return false;
	}
	
	  
	
}
