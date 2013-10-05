import java.util.Scanner;

public class Game {

	public void start() {
		System.out.println("ゲームスタート！");

		Board board = new Board();
		board.makeBoard();
		board.show();

		//手番　trueのときは黒を、falseのときは白を
		boolean player1 = true;

		Scanner scan = new Scanner(System.in);


		while(true) {
			int input = scan.nextInt();

			//中断判定999
			if(input==999) {
				break;
			}

			int x = input / 10;
			int y = input % 10;

			//入力を受けてそこにコマが置けるかどうかを判定するメソッド
			boolean isOK = board.check(player1, x,y);
			if(isOK==false) {
				System.out.println("コマが置けません。やり直してください。");
				continue;
			}

			//入力を受けて、コマを置くメソッド メソッド名後で考える
			board.method(player1, x, y);

			board.show();
			//手番の交代　パスとかまだ考えない
			player1 = !player1;
		}



		//終了メッセージ表示
		System.out.println("999が入力されたので終了します。");

	}
}
