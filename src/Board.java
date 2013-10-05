
public class Board {

	//マス生成
	int[] masu = new int[64];


	/**
	 * 盤の全てのマスを0で初期化後、初期配置の４つのコマをつくる
	 */
	public void makeBoard() {
		for(int i=0; i<64; i++) {
			masu[i] = 0;
		}
		//最初に置かれているコマ
		masu[27] = 1;
		masu[36] = 1;
		masu[28] = 2;
		masu[35] = 2;
	}

	/**
	 * 盤を表示する
	 */
	public void show(){
		//盤の行番号表示
		System.out.println("　1 2 3 4 5 6 7 8");

		for(int i=0; i<64; i++) {

			if(i==0) {
				System.out.print("1");
			}else if(i%8==0){
				System.out.println();
				//盤の列番号表示
				System.out.print(i/7+1);
			}

			if(masu[i]==0) {
				System.out.print(" #");	
			}else if(masu[i]==1) {
				System.out.print(" ●");
			}else {
				System.out.print(" ○");
			}

		}

		System.out.println();

		System.out.println("入力してください(x,y)＞");
	}

	public void method(boolean player1, int x, int y) {

		if(player1) {
			masu[(y-1)*8+x-1] = 1;
		}else {
			masu[(y-1)*8+x-1] = 2;
		}

	}

	/**
	 * コマが置ける場所か判定する
	 */
	public boolean check(boolean player1, int x, int y) {
		//指定されたマス
		int assign = (y-1)*8+x-1;
		
		//黒の手番なら白があるか、白の手番なら黒があるか
		int a;
		if(player1) {
			a = 2;
		}else {
			a = 1;
		}
		
		//既にコマが置いてあった場合
		if(masu[assign] != 0) {
			return false;
		}
		
		//四隅の判定
		if(assign==0) {
			if(masu[1] == a || masu[9] == a || masu[8] == a) {
				return true;
			}else {
				return false;
			}
		}
		
		if(assign==7) {
			if(masu[6] == a || masu[15] == a || masu[14] == a) {
				return true;
			}else {
				return false;
			}
		}
		
		if(assign==56) {
			if(masu[48] == a || masu[49] == a || masu[57] == a) {
				return true;
			}else {
				return false;
			}
		}
		
		if(assign==63) {
			if(masu[62] == a || masu[54] == a || masu[55] == a) {
				return true;
			}else {
				return false;
			}
		}
		//上辺のチェック(端２つは除外)masu[1]~masu[6]について←↙↓↘→のマスを確認
		if(1<=assign && assign<=6) {
			if(masu[assign-1] == a || masu[assign+1] == a || masu[assign+9] == a || masu[assign+8] == a || masu[assign+7] == a) {
				return true;
			}else {
				return false;
			}
		}
		//下辺のチェック(端２つは除外)masu[57]~masu[62]について←↖↑↗→のマスを確認
		if(57<=assign && assign<=62) {
			if(masu[assign-1] == a || masu[assign-9] == a || masu[assign-8] == a || masu[assign-7] == a || masu[assign+1] == a) {
				return true;
			}else {
				return false;
			}
		}
		
		//外側辺のチェック
		//左辺
		if(assign % 8 == 0) {
			if(masu[assign-8] == a || masu[assign-7] == a || masu[assign+1] == a || masu[assign+9] == a || masu[assign+8] == a) {
				return true;
			}else {
				return false;
			}
		}
		//右辺
		if((assign + 1) % 8 == 0) {
			if(masu[assign-1] == a || masu[assign-9] == a || masu[assign-8] == a || masu[assign+8] == a || masu[assign+7] == a) {
				return true;
			}else {
				return false;
			}
		}
		
		//指定されたマスの左隣のマスから時計回りに
		if(masu[assign-1] == a || masu[assign-9] == a || masu[assign-8] == a || masu[assign-7] == a || masu[assign+1] == a || masu[assign+9] == a || masu[assign+8] == a || masu[assign+7] == a) {
			return true;
		}else {
			return false;
		}

	}
}
