
import java.util.Arrays;
import java.util.Scanner;

public class DecimalNumbers {

	private static Scanner in;

	public static void main(String[] args) {
		
		System.out.println("This program checks to see if your input is a valid decimal number. \nEnter a string... \n");  // Intro.
		UserInput();

	}
	
	static void UserInput() {
		
		String inputString;
		
		in = new Scanner(System.in);
		inputString = in.next();                   // Place the input string into the object variable.
		
		System.out.println(CheckIfDecimal(inputString));
		UserInput();
		
		return;
	}
	
	static String CheckIfDecimal(String inputString) {
		
		String outNotDecimal = "NOT DECIMAL. Try again...";
		String output = "DECIMAL. Try agan...";	
		String[] str = {};
		int length = inputString.length();
		str = inputString.split("");
		
		for(String s : str) {
			System.out.println(s);
		}
		
//		for(int i=0; i<length; i++) {                        // Creating array of characters from input string.
//			str[i] = inputString(i);
//		}
		
		
		
		return output;	
	}
}
