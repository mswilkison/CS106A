/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;

import java.io.*;
import java.util.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord() {
		wordList = new ArrayList<String>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while (true) {
				String word = rd.readLine();
				if (word == null) break;
				wordList.add(word);
			}
			int index = rgen.nextInt(getWordCount());
			return wordList.get(index);
		} catch (IOException ex) {
			throw new ErrorException("getWord: Cannot open file");
		}
	}
	
	private ArrayList<String> wordList;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
