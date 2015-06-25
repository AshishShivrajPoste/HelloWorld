package com.edu.hangman;

/**
 * 
 * @author
 * HandManController is the main entry point of the hangman game
 */

public class FinalDemo {
	
	private static Final1 hangManModel;
	private static Final2 getInput;
	/** MAX NUMBER OF INPUTS AVAILABLE TO ANY USER*/
	private static int allowedGuess = 6;
	private Boolean isGameWon = false;
	
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println(Final4.PROVIDE_FILEPATH_OF_WORDS);
			return;
		}
		getInput = new Final2();
		hangManModel = new Final1(args[1]);
		FinalDemo hangManController = new FinalDemo();
		hangManModel.init();
		hangManController.PayGame();
		hangManModel.clear();
		
		
	}
	/***
	 * Entry Point of the HandMan Game.
	 */
	public void PayGame(){
		int numberofGuessMade = 0;
		Final3 result;
		System.out.println(Final4.HEADER);
		do{
			clearScreen();
			System.out.println(Final4.WORD_TO_GUESS+hangManModel.getHiddenWord());
			System.out.println(Final4.GUESSES_MADE +hangManModel.getLettersGuessed());
			System.out.println(Final4.ATTEMPTS_LEFT+(allowedGuess - numberofGuessMade));
			System.out.println(Final4.MAKE_GUESS);
			String guess = getInput.getGuess();
			char[] character = guess.toCharArray();
			if(guess.equals("") || guess == null){
				System.out.println(Final4.PROVIDE_INPUT_WARNING);
				continue;
			}
			Boolean isValidInput = getInput.validateInput(guess);
			if(!isValidInput)
			{
				System.out.println(Final4.INVALID_INPUT_WARNING);
				continue;
			}
			/***
			 * check if player is attempting to guess the word character by character or whole word at a time
			 */
			if(guess.length() > 1){
				result = hangManModel.checkGuess(guess);
				if(result.equals(Final3.CORRECT)){
					isGameWon = true;
					System.out.println(Final4.GOOD_GUESS);
					System.out.println(Final4.WIN_MSG);
					break;
				}else {
					System.out.println(Final4.BAD_GUESS);
					numberofGuessMade++;
				}
			}else{
				result = hangManModel.getResult(character[0]);
				if(result.equals(Final3.CORRECT)){
					System.out.println(Final4.GOOD_GUESS);
					if(hangManModel.isWordGuessed()){
						isGameWon = true;
						System.out.println(Final4.WIN_MSG);
						break;
					}
				}else if(result.equals(Final3.INCORRECT)){
					System.out.println(Final4.BAD_GUESS);
					numberofGuessMade++;
				}else if(result.equals(Final3.ALREADY_GUESSED)) {
					System.out.println(Final4.ALREADY_GUESSED_CHARACTER);
				}
			}
			/**Adding into guessed List*/
			hangManModel.addGuess(guess);
		}while(numberofGuessMade < allowedGuess);
		if(!isGameWon){
			System.out.println(Final4.LOST_MSG);
			System.out.println("CORRECT WORD IS : "+hangManModel.getWord());
		}
		
	}
	/***
	 * Clears the Screen after every guess made by the Player
	 */
	public void clearScreen(){
		Process process;
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	           process =  Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	        	process = Runtime.getRuntime().exec("clear");
	        }
	        process.waitFor();
	    }
	    catch (final Exception e)
	    {
	    }
	}

}
