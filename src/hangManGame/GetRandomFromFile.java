package hangManGame;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GetRandomFromFile {
	static private File wordsFile;
	private static String[] words;
	private static String word;
	
	public static void getWordsFromFile() {
		StringBuilder wordList=new StringBuilder();
		try {
			wordsFile=new File("src\\dictionary.txt");
		} catch (Exception e) {
			System.out.println("There`s no dictionary");
		}
		try(BufferedReader reader=new BufferedReader(new FileReader(wordsFile))) {
			reader.lines().forEach(wordList::append);
		} catch(IOException e) {
			e.getStackTrace();
		}
		words = wordList.toString().split(", ");
	}
	
	
	private static void setWord(int lvl) {
		Random rand=new Random();
		StringBuilder randWord=new StringBuilder();
		do {
			randWord.setLength(0);
			randWord.append(words[rand.nextInt(words.length)]);
		} while(randWord.toString().length()!=lvl);
		word = randWord.toString();
	}
	
	public static String getWord(int lvl) {
		getWordsFromFile();
		setWord(lvl);
		return word;
	}
}
