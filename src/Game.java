import java.util.Scanner;

public class Game {

	public void start() {
		System.out.println("ゲームスタート！");
		
		Board board = new Board();
		board.show();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			int input = scan.nextInt();
			int x = input % 10;
			int y = input / 10;
			
		}
		
		


	}
}
