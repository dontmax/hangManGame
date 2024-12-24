package hangManGame;

import java.util.Scanner;

public class GameController {
	GameModel model;
	GameView view;
	Scanner scanner;
	String listener;
	
	public GameController(GameModel model, GameView view) {
		this.model=model;
		this.view=view;
		scanner=new Scanner(System.in);
		startApp();
		}
	
	public void startApp() {
		view.printMenu();
		listener=scanner.nextLine();
		Menu();
	}
	public void Menu() {
		while(true) {

				switch(listener) {
			case "1":
				startNewGame();
				model.mask.cleanBuffer();
				break;
			case "2":
				exit();
				break;
			case "3":
				setLvl();
				break;
			default:
				missClick();
				break;
				}
				view.printMenu();
				listener=scanner.nextLine();
		}		
	}
	
		public void startNewGame() {
		model.setNewWord();
		model.setMistakeLeft(model.getMistakeAmount());
		view.printGame(model.mask.getMask(),model.getMistakeLeft(),model.mask.getUsedLetters());
		gameCycle();
	}
	
	public void gameCycle() {
		while(!model.checkForVictory()&&!model.checkForLoss()) {
			listener=scanner.nextLine();
				if(checkEnter(listener))
					{
					if(!model.mask.isLetterUsed(listener))
						{
						model.mask.userInput(listener);
						if(model.mask.isLetterGuessed(listener))
						{
							model.mask.openLetter(listener);
							} else {
						   		wrongLetter(); 
					      		}
						view.printGame(model.mask.getMask(), model.getMistakeLeft(),model.mask.getUsedLetters());
					}	else view.printAlreadyUsed();
				} else {
					missClick();
			}
		}
		if(model.checkForVictory()) {
			model.setGuessedWordsCount();
			view.printVictory(model.getGuessedWordsCount());
		} else {
			view.printGameOver(model.getWord());
		}
	}
	
	public void setLvl() {
		while(true){
			view.printSetLvl();
			listener=scanner.nextLine();
			if(checkEnterForDigit(listener)==false)
				missClick();
			else {
				if(3<=Integer.parseInt(listener)&&Integer.parseInt(listener)<=8)
					{
					model.setLvl(Integer.parseInt(listener));
					break;
					}	
			}
		}
	}
	
	public void wrongLetter() {
		model.setMistakeLeft((model.getMistakeLeft()-1));
		view.printMistakesView(model.getMistakeLeft());
	}
		
	public boolean checkEnterForDigit(String listener) {
		try{listener.matches("\\d");
		} catch(Exception e) {
			return false;
		} return true;
		}
	
	public boolean checkEnter(String listener) {
		return listener.matches("^[a-zA-Z]$");
	}

	public void missClick() {
		view.printMissClick();
	}
	
	public void gameOver() {
		view.printGameOver(model.getWord());
	}
	
		public void exit() {
		System.exit(1);
	}
}
