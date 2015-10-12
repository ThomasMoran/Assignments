
import java.util.Scanner;

public class DecimalNumbers {

	private static Scanner in;

	public static void main(String[] args) {
		
		UserInput();

	}
	
	static String UserInput() {
		
		String inputString;
		
		System.out.println("This program checks to see if your input is a valid decimal number. \nEnter a string... \n");     // Ask the user for a string.
		
		in = new Scanner(System.in);
		inputString = in.next();                   // Place the input string into the object variable.
		
		System.out.println(CheckIfDecimal(inputString));
		UserInput();
		
		return null;
	}
	
	static String CheckIfDecimal(String inputString) {
		
		String outNotDecimal = "The value you entered is not decimal. Try again...";
		String output = "The value you entered is decimal. Enter another String";		
		
		String[] stringArray = inputString.split("(?!^)");
		
		for(String character : stringArray) {
			
			isDecimal(character);
		}
		return output;
		
	}
	
	static boolean isDecimal(String str) {  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
