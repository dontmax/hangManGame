package hangManGame;

import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class WordMask {
	
	private String word;
	private String[] mask;
	
	private final Set<String> usedLetters=new HashSet<>();
	private final Set<String> wordUniqueLetters=new HashSet<>();
	int numberGuessedLetters=0;
	
	public void userInput(String letter) {
		usedLetters.add(letter.toLowerCase());
	}
	
	public void setWord(String word) {
		this.word=word;
		this.mask=new String[word.length()];
		Arrays.fill(mask,"*");
		Collections.addAll(wordUniqueLetters, word.toLowerCase().split(""));
	}
	
	public void openLetter(String letter) {
		for(int i=0;i<word.length();i++) {
			if(Character.toString(word.charAt(i)).equalsIgnoreCase(letter))
				mask[i]=Character.toString(word.charAt(i));
		}
		numberGuessedLetters++;
	}
	
	public boolean isLetterUsed(String letter) {
		return usedLetters.contains(letter.toLowerCase());
	}
	
	public HashSet<String> getUsedLetters() {
		return (HashSet<String>) usedLetters;
	}
	
	public boolean isLetterGuessed(String letter) {
		return wordUniqueLetters.contains(letter.toLowerCase());
	}
	
	public 	String[] getMask() {
		return mask;
	}
	
	public int numberOfUniqueLetters() {
		return wordUniqueLetters.size();
	}
	
	public void cleanBuffer() {
		usedLetters.clear();
		wordUniqueLetters.clear();
		numberGuessedLetters=0;	
	}
}
