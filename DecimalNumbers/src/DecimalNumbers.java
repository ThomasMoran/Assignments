
import java.util.Scanner;

public class DecimalNumbers {

	private static Scanner in;

	public static void main(String[] args) {
		
		System.out.println("This program checks to see if your input is a valid decimal number. \nEnter a string... \n");     // Ask the user for a string.
		UserInput();

	}
	
	static String UserInput() {
		
		String inputString;
		
		in = new Scanner(System.in);
		inputString = in.next();                   // Place the input string into the object variable.
		
		System.out.println(CheckIfDecimal(inputString));
		UserInput();
		
		return null;
	}
	
	static String CheckIfDecimal(String inputString) {
		
		String outNotDecimal = "NOT DECIMAL. Try again...";
		String output = "DECIMAL. Enter another String";		
		String[] stringArray = inputString.split("(?!^)");    // Creates an array of characters out of input string.
		for(String character : stringArray) {
			if(!(character.matches("^([+-]?\\d*\\.?\\d*)$"))) {
				output = outNotDecimal;
			}
		}
		return output;	
	}
}
