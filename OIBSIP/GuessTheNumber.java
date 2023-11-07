//import the Scanner class for user input
import java.util.Scanner;

//import the Random class for generating random numbers
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        //create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        //create a Random object for generating random numbers
        Random random = new Random();

        //declare and initialize the variables for the game
        int range = 100; //the range of the random number, from 1 to 100
        int number = random.nextInt(range) + 1; //the random number to be guessed, from 1 to 100
        int guess = 0; //the user's guess
        int attempts = 0; //the number of attempts
        int maxAttempts = 10; //the maximum number of attempts allowed
        int score = 0; //the user's score
        int points = 10; //the points awarded for each correct guess
        boolean win = false; //the flag to indicate if the user has won or not

        //display the welcome message and the instructions
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        System.out.println("You will get " + points + " points for each correct guess.");
        System.out.println("Let's begin!");

        //start the game loop
        while (attempts < maxAttempts && !win) {
            //prompt the user to enter their guess
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            //increment the number of attempts
            attempts++;

            //check if the guess is correct, too high, or too low
            if (guess == number) {
                //the guess is correct, the user has won
                win = true;
                //update the score
                score += points;
                //display the congratulatory message and the score
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                System.out.println("Your score is " + score + ".");
            } else if (guess > number) {
                //the guess is too high
                //display the hint and the remaining attempts
                System.out.println("Your guess is too high.");
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            } else {
                //the guess is too low
                //display the hint and the remaining attempts
                System.out.println("Your guess is too low.");
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            }
        }

        //end the game loop
        //check if the user has lost
        if (!win) {
            //the user has run out of attempts and has not guessed the number
            //display the losing message and the correct number
            System.out.println("Sorry, you have lost the game.");
            System.out.println("The number was " + number + ".");
        }

        //close the Scanner object
        scanner.close();
    }
}
