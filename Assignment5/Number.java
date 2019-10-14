package assignment5;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
	public static void count() {
		Scanner n = new Scanner(System.in);
		int numerator, denominator, quotient;
		try {
			System.out.println("Enter numerator: ");
			numerator = n.nextInt();
		    System.out.println("Enter denominator: ");
		    denominator = n.nextInt();
		    quotient = result(numerator,denominator);
		    System.out.println("Quotient:"+quotient);
		}
		catch(ArithmeticException ar) {
			System.out.println(ar.toString());
			System.out.println("Zero is invalid denominator. Try different integer.");
			}
		catch(InputMismatchException im) {
			System.out.println("You need to enter integer.");
		}
		
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
