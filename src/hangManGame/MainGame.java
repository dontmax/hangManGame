package hangManGame;

public class MainGame {

	public static void main(String[] args) {
		
		GameModel model=new GameModel();
		GameView view=new GameView();
		
		new GameController(model,view);

	}
}
