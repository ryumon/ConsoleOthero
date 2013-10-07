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

			//入力を受けてその周囲に相手のコマがあるかどうかを判定。あった場合その方向を1~8で返し、無かった場合0を返す
			int direction = board.check(player1, x,y);
			if(direction==0) {
				System.out.println("コマが置けません。やり直してください。");
				continue;
			}
			
//			switch(direction) {
//			case 1:
//				board.checkLine1(player1, x, y);
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			case 5:
//				break;
//			case 6:
//				break;
//			case 7:
//				break;
//			case 8:
//				break;
//				default:
//					System.out.println("コマが置けません。やり直してください。");
//					continue;
//					
//			}
			
			

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
