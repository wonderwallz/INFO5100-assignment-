package assignment5;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
	public static void count() {
		Scanner n = new Scanner(System.in);
		int numerator, denominator, quotient;
		int x = 1;
		
		do {
		try {
			System.out.println("Enter numerator: ");
			numerator = n.nextInt();
		    System.out.println("Enter denominator: ");
		    denominator = n.nextInt();
		    quotient = result(numerator,denominator);
		    System.out.println("Quotient:"+quotient);
		    x=2;
		}
		catch(ArithmeticException ar) {
			System.out.println(ar.toString());
			
			}
		catch(InputMismatchException im) {
			System.out.println("You need to enter integer.");
		}
		n.nextLine();
		}while(x==1);
		
	}
	
	
	public static int result(int numerator, int denominator) {
		if(denominator==0) {
			throw new ArithmeticException("Zero is invalid denominator. Try different integer.");
		}
		return(numerator/denominator);
	}
	
	public static void main(String[] args) {
		Number number = new Number();
		number.count();
		
	}

}
