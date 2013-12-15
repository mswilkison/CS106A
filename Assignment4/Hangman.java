/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    }

    public void run() {
    	println("Welcome to Hangman!");
    	// select random secret word
		setup();
		play();
		// basic control structure (user guess letter, track guesses remaining, print messages, end game, etc.
	}
        
    private void setup() {
    	// get secret word
    	secretWord = lexicon.getWord();
		// initialize guessWord
		guessWord = secretWord.replaceAll(".", "-");
		// reset canvas
		canvas.reset();
    }
    
    private void play() {
    	while (true) {
    		canvas.displayWord(guessWord);
    		println("The word now looks like this: " + guessWord);
    		println("You have " + guessesRemaining + " guesses left.");
    		guessLetter();
    		if (correctGuess == secretWord.length()) {
    			println("You guessed the word " + guessWord + ".");
    			println("You win.");
    			break;
    		};
    		if (guessesRemaining == 0) {
    			println("You're completely hung!");
    			println("The word was: " + secretWord);
    			println("You lose!");
    			break;
    		}
    	}
    }
    
    private void guessLetter() {
    	while (true) {
	    	String guess = readLine("Your guess: ");
	    	if (guess.matches("[a-zA-Z]")) {
	        	checkLetter(guess.toUpperCase());
	        	break;
	    	} else {
	    		println("Please enter a valid guess.");
	    	}
    	}
    }
    
    private void checkLetter(String guess) {
    	if (secretWord.contains(guess) && !guessWord.contains(guess)) {
    		char charGuess = guess.charAt(0);
	    	for (int i = 0; i < secretWord.length(); i++) {
	    		if (charGuess == secretWord.charAt(i)) {
	    			println("That guess is correct!");
	    			guessWord = guessWord.substring(0, i) + charGuess + guessWord.substring(i+1);
	    			correctGuess++;
	    		}
	    	}
    	} else {
    		println("There are no " + guess + "'s in the word.");
    		canvas.noteIncorrectGuess(guess.charAt(0));
    		guessesRemaining--;
    	}
    }

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanLexicon lexicon = new HangmanLexicon();
    private static final int MAX_GUESSES = 8;
    private String secretWord;
    private String guessWord;
    private int correctGuess = 0;
    private int guessesRemaining = MAX_GUESSES;
    private HangmanCanvas canvas;
}
