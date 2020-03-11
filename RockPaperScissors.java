import java.util.Random;
import java.util.Scanner;

/**
 * This program is a rock, paper, scissors game between the user and the computer.
 * 
 * @author Amin Zeina
 * @version 1.0
 * @since 2020-03-09
 */
public class RockPaperScissors {
  
  /**
  * This class plays rock, paper, scissors. 
  */
  public static void main(String[] args) {
    
    // Declare variables
    String userChoiceWord;
    String computerChoiceWord;
    String playAgain;
    int userChoice;
    int computerChoice;
    int winCounter = 0;
    int lossCounter = 0;
    int tieCounter = 0;
    boolean gameEnded = false;
    
    // Create random and scanner objects
    Random random = new Random();
    Scanner userInput = new Scanner(System.in);
    
    // Loop for user to play again if they want to 
    while (gameEnded == false) {
      // Generate # from 1-3 for computer's action
      computerChoice = random.nextInt(3) + 1;
      
      // Get word equivalent  to show user what the computer had 
      if (computerChoice == 1) {
        computerChoiceWord = "rock";
      } else if (computerChoice == 2) {
        computerChoiceWord = "paper";
      } else {
        // If not 1 or 2, must be 3 -> scissors
        computerChoiceWord = "scissors";
      }
      
      System.out.print("Enter 'rock', 'paper', or 'scissors': ");
      // Convert to lower case so any capitalization will be valid 
      userChoiceWord = userInput.nextLine().toLowerCase();
      
      if (userChoiceWord.equals("rock")) {
        userChoice = 1;
      } else if (userChoiceWord.equals("paper")) {
        userChoice = 2;
      } else if (userChoiceWord.equals("scissors")) {
        userChoice = 3;
      } else {
        System.err.println("Invalid input. Valid inputs are 'rock', 'paper', and 'scissors'.");
        // Restart the loop to get new input 
        continue;
      }
      
      if (userChoice == computerChoice) {
        // User ties
        tieCounter++;
        System.out.println("It's a tie. You chose " + userChoiceWord + " and the computer chose " 
            + computerChoiceWord + ".");
      } else if (userChoice - computerChoice == 1 || userChoice - computerChoice == -2) {
        /* 
        User win. The logic used to determine whether user wins or loses is to subtract user's # 
        by computer's #. The only winning cases = -2 and 1. EX: user wins as rock vs scissors 
        (1 - 3 = -2), as paper vs rock (2 - 1 =  1), and as scissors vs paper (3 - 2 = 1).
        */
        winCounter++;
        System.out.println("You win! You chose " + userChoiceWord + " and the computer chose " 
            + computerChoiceWord + ".");
      } else {
        // User loses, no logic needed because if its not a tie or win, loss is only option
        lossCounter++;
        System.out.println("You lose! You chose " + userChoiceWord + " and the computer chose " 
            + computerChoiceWord + ".");
      }
      // Show user their current score
      System.out.println("You have " + winCounter + " win(s), " + lossCounter + " loss(es), and " 
          + tieCounter + " tie(s).");
      
      // Ask if user wants to play again
      System.out.print("Do you want to play again? (yes/no): ");
      // Convert to lower case so capital Y is valid 
      playAgain = userInput.nextLine().toLowerCase();
      
      if (playAgain.equals("yes")) {
        // User wants to keep playing
        gameEnded = false;
      } else {
        // User wants to end the game
        gameEnded = true;
      }
    }
    System.out.print("Program End.");
  } 
}