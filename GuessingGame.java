/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. ___ARNAV JALAN___
*/

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class GuessingGame {

	// fill in code here
	// common data structures and variables

	private int numberOfGuesses;
	private ArrayList<Integer> possibleNumbers;
	private int guess;

	public GuessingGame() {
		
		// fill in code here
		// initialization

		// An array list with all possible numbers is created 

		possibleNumbers = new ArrayList<Integer>();

		for (int i = 1000; i <= 9999; i++) { 

			possibleNumbers.add(i);

		}

		numberOfGuesses = 0; 

	}

	public int myGuessIs() { 
		// fill in code here
		// this should return the current guess

		// the program randomly guesses a number from the array list 
		// if the size of the array goes below one then the number does not exist or a mistake was made by the user
		
		if (possibleNumbers.size() > 0) {
			int random = (int)(Math.random() * possibleNumbers.size()); 
			guess = (possibleNumbers.get(random)); 
			numberOfGuesses++;
		}

		else {  			
			guess = -1;		
	}		
		
		return guess;		
	
	}
	
	public int totalNumGuesses() {
		// fill in code here
		// this should return the total number of guesses taken
		return numberOfGuesses;
	}
 
	public void updateMyGuess(int nmatches) {
		// fill in code here
		// update the guess based on the number of matching digits claimed by the user

		// the four digits of the integer guess
		int firstD 	= (guess / 1000);
		int secondD = (guess / 100) % 10;
		int thirdD 	= (guess / 10) % 10;
		int fourthD = (guess % 10);

		for (int i = 0; i < possibleNumbers.size(); i++) {

			// number of matching digits
			int numberofMatches = 0; 

			// All numbers in the integer array list who's number of matching digits do not equal the given number of matches inputted by the user are removed
			// Each digit is compared individually and if there is a match then numberofmatches is incremented by 1. 
				
				if (firstD == (possibleNumbers.get(i) / 1000)) { 
					numberofMatches++; 
				}

				if (secondD == (possibleNumbers.get(i) / 100) % 10) {
					numberofMatches++;
				}

				if (thirdD 	== (possibleNumbers.get(i) / 10) % 10) {
					numberofMatches++;
				}

				if (fourthD == (possibleNumbers.get(i) % 10)) {
					numberofMatches++;
				}			

				if (numberofMatches != nmatches) { 
					possibleNumbers.remove(i);
			}
		}
	}
	
	// fill in code here (optional)
	// feel free to add more methods as needed
	
	// you shouldn't need to change the main function
	public static void main(String[] args) {

		GuessingGame gamer = new GuessingGame( );
  
		JOptionPane.showMessageDialog(null, "Think of a number between 1000 and 9999.\n Click OK when you are ready...", "Let's play a game", JOptionPane.INFORMATION_MESSAGE);
		int numMatches = 0;
		int myguess = 0;
		
		do {
			myguess = gamer.myGuessIs();
			if (myguess == -1) {
				JOptionPane.showMessageDialog(null, "I don't think your number exists.\n I could be wrong though...", "Mistake", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			String userInput = JOptionPane.showInputDialog("I guess your number is " + myguess + ". How many digits did I guess correctly?");
			// quit if the user input nothing (such as pressed ESC)
			if (userInput == null)
				System.exit(0);
			// parse user input, pop up a warning message if the input is invalid
			try {
				numMatches = Integer.parseInt(userInput.trim());
			}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 4", "Warning", JOptionPane.WARNING_MESSAGE);
				continue;
			}
			// the number of matches must be between 0 and 4
			if (numMatches < 0 || numMatches > 4) {
				JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 4", "Warning", JOptionPane.WARNING_MESSAGE);
				continue;
			}
			if (numMatches == 4)
				break;
			// update based on user input
			gamer.updateMyGuess(numMatches);
			
		} while (true);
		
		// the game ends when the user says all 4 digits are correct
		System.out.println("Aha, I got it, your number is " + myguess + ".");
		System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
	}
}