/**
 * Name:           Thomas Moran
 * 
 * Student Number: 11462188
 * 
 * File Name:      DecimalNumbers.java
 * 
 * Description:    This program simulates a DFA designed for question 4: Programming Exercise, as part of 
 *                 Homework 3 for the Foundations of Computing module (COMP30010). The program starts by
 *                 asking instroducing the program and asking the user to input a string. The program then
 *                 sends this string to the DFA function (CheckIfDecimal()) which implements the DFA outlined
 *                 in the Homework solutions handed up in class on the 14/10/2015. The program then outputs
 *                 a string to the console, telling the user if the string was decimal or not decimal before
 *                 asking for a new input.
 * 
 * Example 1:      Run the program.
 * 		           Input the string "12.2"
 *                 Output will be "NOT DECIMAL. Try again..." 
 *                 
 * Example 2:      Run the program.
 * 		           Input the string "-3a.2"
 *                 Output will be "DECIMAL. Try another input..." 
 *                 
 * Date:           14/10/2015
 */
import java.util.Scanner;

public class DecimalNumbers {

	private static Scanner in;          // Scanner to take input from user.
	public static String[] str = {};    // String array to hold individual characters from input string.
	static String outNotDecimal = "NOT DECIMAL. Try again...";    // output if valid decimal input.
	static String outDecimal = "DECIMAL. Try another input...";	  // output if not valid decimal input.
	static char state = 'A';                                     // Starting state initialised.

	public static void main(String[] args) {
		
		System.out.println("This program checks to see if your input is a valid decimal number. \nEnter a string... \n");  // Intro.
		UserInput();    // Call for user input.

	}
	
	static void UserInput() {
		
		String inputString;    // Variable to hold input string.
		
		in = new Scanner(System.in);  // Scanning for input from user.
		inputString = in.next();      
		
		System.out.println(CheckIfDecimal(inputString));    // Output the result of checking if string is valid decimal.
		UserInput();                          // Call for new input from user.
		
		return;
	}
	
	static String CheckIfDecimal(String inputString) {
		
		str = inputString.split("");       // Splitting input string into array of individual character strings.
		state = 'A';                       // Starting state is always A.
		
		for(int i=0; i<str.length; i++) {   // Loop for entire string.
			
			/* The following if statements check the current state of the DFA and then changes the state depending
			 * on the next character string from the input, before looping again for the next character string.
			 */
			
			if(state == 'A'){               // State A in DFA.
				if(isNumeric(str[i])) {
					state = 'C';  // Move to state C.
				}
				else if(str[i].equals("+") || str[i].equals("-")){
					state = 'B';    // Move to state B.
				}
				else if(str[i].equals(".")) {
					state = 'E';    // Move to state E.
				}
				else {
					state = 'D';     // Move to state D.
				}
				
			}
			else if(state == 'B') {     // State B of DFA.
				if(isNumeric(str[i])) {
					state = 'C';     // Move to state C.
				}
				else if(str[i].equals(".")){
					state = 'E';    // Move to state E.
				}
				else {
					state = 'D';     // Move to state D.
				}
			}
			else if(state == 'C') {     // State C of DFA.
				if(isNumeric(str[i])) {
					// Remain at state C.
				}
				else if(str[i].equals(".")){
					state = 'G';     // Move to state G.
				}
				else {
					state = 'D';     // Move to state D.
				}
			}
			else if(state == 'D') {     // State D of DFA.
				// Dead state.
				return outNotDecimal;   // If we ever reach dead state, the input string cannot be a valid decimal. Ignore remaining input character strings.
			}
			else if(state == 'E') {    // State E of DFA.
				if(isNumeric(str[i])) {
					state = 'F';     // Move to state F.
				}
				else {
					state = 'D';     // Move to state D.
				}
			}
			else if(state == 'F') {     // State F of DFA.
				if(isNumeric(str[i])) {
					// Remain in state F.
				}
				else {
					state = 'D';    // Move to state D.
				}
			}
			else if(state == 'G') {    // State G of DFA.
				if(isNumeric(str[i])) {
					state = 'F';    // Move to state F.
				}
				else {
					state = 'D';    // Move to state D.
				}
			}
		}
		
		if(state == 'C' || state == 'F') {    // If we finish in an accepting state, we have a valid decimal.
			return outDecimal;
		}
		else {
			return outNotDecimal;	
		}
	}
	
	/**
	 * Function to check if a string is a numeric character. 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {  
	  try {
	      double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe) {
	      return false;  
	  }  
	  return true;  
	}
}
