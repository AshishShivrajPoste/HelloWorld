package com.edu.hangman;

/**
 * HangManModel is the Model of Hang Man Game,it contains all the methods required to build up a HandMan game.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class Final1 {

	private String selectedWord;
	private List<Character> hiddenWord;
	private Set<String> lettersGuessed;
	private List<String> words;
	private Final2 getInput;

	public Final1(String filePath) {
		this.getInput = new Final2(filePath);
		this.hiddenWord = new ArrayList<Character>();
		this.lettersGuessed = new HashSet<String>();
		this.words = new ArrayList<String>();
		
	}
	public void init(){
		getListofWords();
		setWord();
		setHiddenWord();
	}
	public void clear(){
		lettersGuessed.clear();
	}
	/**
	 * getListofWords() Method is used to get all the words available in input File
	 */
	private void getListofWords() {
		words = getInput.getListOfWords();
	}
	/**
	 * setWord() Method is used to get a random word out of available words which will be considered as our guessing word
	 */
	public void setWord() {
		selectedWord = words.get(new Random().nextInt(words.size()));
	}

	public String getWord() {
		return selectedWord;
	}
	/**
	 * setHiddenWord() represents our word which player figures out in his attempt to solve the Hangman puzzle.
	 */
	private void setHiddenWord() {
		for (char letter : selectedWord.toCharArray()) {
			hiddenWord.add('-');
		}
	}

	public List<Character> getHiddenWord() {
		return hiddenWord;
	}

	private ArrayList<Integer> getIndexesOf(char letter) {
		ArrayList<Integer> instances = new ArrayList<Integer>();
		for (int i = 0; i < selectedWord.length(); i++) {
			if (Character.toUpperCase(selectedWord.charAt(i)) == Character.toUpperCase(letter)) {
				instances.add(i);
			}
		}
		return instances;
	}

	public void revealLetter(char letter) {
		for (int i : getIndexesOf(letter)) {
			hiddenWord.set(i, selectedWord.charAt(i));
		}
	}

	public void addGuess(String letter) {
		lettersGuessed.add(letter);
	}
	/***
	 * Checks whether the character provided by player is repated
	 * @param letter : charcter
	 * @return : true or false
	 */
	private boolean isGuessed(String letter) {
		// return lettersGuessed.contains(letter);
		for (String c : lettersGuessed) {
			if (c.equalsIgnoreCase(letter)) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}
	/***
	 * Get the result if current guess is "CORRECT" , "INCORRECT" , or "ALREADY GUESSED"
	 * @param letter : Input Character
	 * @return
	 */
	public Final3 getResult(char letter) {
		if (!isGuessed(letter + "")) {
			if (getIndexesOf(letter).size() > 0) {
				revealLetter(letter);
				return Final3.CORRECT;
			} else {

				return Final3.INCORRECT;
			}
		} else {
			return Final3.ALREADY_GUESSED;
		}
	}

	public Set<String> getLettersGuessed() {
		return lettersGuessed;
	}

	public void setLettersGuessed(Set<String> lettersGuessed) {
		this.lettersGuessed = lettersGuessed;
	}
	/***
	 * Check if entered word match with th puzzle word.
	 * @param guess
	 * @return
	 */
	public Final3 checkGuess(String guess) {
		if (selectedWord.equalsIgnoreCase(guess)) {
			return Final3.CORRECT;
		} else {
			return Final3.INCORRECT;
		}
	}
	/***
	 * check if the player has completlly guessed the word.
	 * @return
	 */
	public Boolean isWordGuessed() {
		if (hiddenWord.contains('-')) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @return the words
	 */
	public List<String> getWords() {
		return words;
	}

	/**
	 * @param words
	 *            the words to set
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}

}
