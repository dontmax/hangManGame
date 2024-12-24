package hangManGame;

import java.util.HashSet;

public class GameView {
	
	public void printMenu() {
		System.out.println("\nPress 1 to start a game or 2 to exit,"+
				"\n3 to change lvl");
	}
	
	public void printGame(String []mask,int mstkLeft,HashSet<String> usedLetters) {
		System.out.print("Guessed word: ");
		printMask(mask);
		System.out.println(" "+mstkLeft+" mistakes has left");
		if(usedLetters.size()!=0) {
		System.out.print(" Used letters: ");
		usedLetters.stream().forEach(s->System.out.print("\""+s+"\" "));
		}
	}
	
	public void printMissClick() {
		System.out.println("Wrong action!");
	}
	
	public void printMask(String[] mask) {
		for(String m:mask)
		System.out.print(m);
	}
	
	public void printSetLvl() {
		System.out.println("Enter lvl of difficulty dependent on word length between 3-8");
	}
	
	public void printGameOver(String word) {
		System.out.println("Hidden word was: "+word+". You lost this game");
	}
	
	public void printAlreadyUsed() {
		
	}
	
	public void printMistakesView(int mstkLeft) {
		switch(mstkLeft) {
		case 5:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
			break;
		case 4:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
			break;
		case 3:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ "  |   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
			break;
		case 2:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
			break;
		case 1:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ " /    |\r\n"
					+ "      |\r\n"
					+ "=========");
			break;
		case 0:
			System.out.println(
					  "  +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ " / \\  |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
	}
	
	public void printVictory(int guessedWordsCount) {
		System.out.println("Excellent, you Won!!! ");
		if(guessedWordsCount>0)
			System.out.println("Guessed words: "+guessedWordsCount);
	}
}
