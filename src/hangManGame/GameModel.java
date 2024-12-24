package hangManGame;

import java.util.Random;

public class GameModel {
	
	WordMask mask;
	
	private String word;
	private final static int MISTAKEAmount=6;
	private int mstkLeft=MISTAKEAmount;
	Random rand;
	private int lvl;
	private int guessedWordsCount=0;
	public GameModel(){
		mask=new WordMask();
		rand=new Random();
		lvl=5;
	}
	
	private void getWordFromFile() {
		word=GetRandomFromFile.getWord(lvl);
		mask.setWord(word);
	}
	
	public void setNewWord() {
		getWordFromFile();
	}
	
	public String getWord() {
		return word;
	}
	
	public void setLvl(int lvl){
		this.lvl=lvl;
	}
	
	public int getMistakeLeft() {
		return mstkLeft;
	}
	
	public void setMistakeLeft(int mstkLeft) {
		this.mstkLeft=mstkLeft;
	}
	
	public int getMistakeAmount() {
		return MISTAKEAmount;
	}
	
	public boolean checkForVictory() {
		return mask.numberGuessedLetters==mask.numberOfUniqueLetters();
	}
	public boolean checkForLoss() {
		return (mstkLeft==0);
	}
	
	public void checkLetter(String letter) {
		if(mask.isLetterUsed(letter)) {
			
		}
	}

	public int getGuessedWordsCount() {
		return guessedWordsCount;
	}

	public void setGuessedWordsCount() {
		this.guessedWordsCount++;
	}
}
