
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
	 * 周囲に相手の色のコマがあるかどうかチェックする
	 */
	public int check(boolean player1, int x, int y) {

		//返す値 1~8で方向を返す　置けないときは0を返す
		int direct = 0;
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
			direct = 0;
			System.out.println("既にコマがあります。");
			return direct;
		}

		//四隅の判定
		if(assign==0) {
			if(masu[1] == a) {
				checkAndFlipLine5(player1,x,y);
				direct = 5;		
			}

			if(masu[9] == a) {
				checkAndFlipLine6(player1,x,y);
				direct = 6;
			}
			if(masu[8] == a) {
				checkAndFlipLine7(player1,x,y);
				direct = 7;
			}
			return direct;
		}

		if(assign==7) {
			if(masu[6] == a) {
				checkAndFlipLine1(player1,x,y);
				direct = 1;
			}

			if(masu[15] == a) {
				checkAndFlipLine7(player1,x,y);
				direct = 7;
			}

			if(masu[14] == a) {
				checkAndFlipLine8(player1,x,y);
				direct = 8;
			}
			return direct;
		}

		if(assign==56) {
			if(masu[48] == a) {
				checkAndFlipLine3(player1,x,y);
				direct = 3;
			}
			if(masu[49] == a) {
				checkAndFlipLine4(player1,x,y);
				direct = 4;
			}

			if(masu[57] == a) {
				checkAndFlipLine5(player1,x,y);
				direct = 5;
			}
			return direct;
		}

		if(assign==63) {
			if(masu[62] == a) {
				checkAndFlipLine1(player1,x,y);
				direct = 1;
			}
			if(masu[54] == a) {
				checkAndFlipLine2(player1,x,y);
				direct = 2;
			}
			if(masu[55] == a) {
				checkAndFlipLine3(player1,x,y);
				direct = 3;
			}
			return direct;
		}
		//上辺のチェック(端２つは除外)masu[1]~masu[6]について←↙↓↘→のマスを確認
		if(1<=assign && assign<=6) {
			if(masu[assign-1] == a) {
				checkAndFlipLine1(player1,x,y);
				direct = 1;
			}
			if(masu[assign+1] == a) {
				checkAndFlipLine5(player1,x,y);
				direct = 5;
			}
			if(masu[assign+9] == a) {
				checkAndFlipLine6(player1,x,y);
				direct = 6;
			}
			if(masu[assign+8] == a) {
				checkAndFlipLine7(player1,x,y);
				direct = 7;
			}
			if(masu[assign+7] == a) {
				checkAndFlipLine8(player1,x,y);
				direct = 8;
			}

			return direct;
		}
		//下辺のチェック(端２つは除外)masu[57]~masu[62]について←↖↑↗→のマスを確認
		if(57<=assign && assign<=62) {
			if(masu[assign-1] == a) {
				checkAndFlipLine1(player1,x,y);
				direct = 1;
			}
			if(masu[assign-9] == a) {
				checkAndFlipLine2(player1,x,y);
				direct = 2;
			}
			if(masu[assign-8] == a) {
				checkAndFlipLine3(player1,x,y);
				direct = 3;
			}
			if(masu[assign-7] == a) {
				checkAndFlipLine4(player1,x,y);
				direct = 4;
			}
			if(masu[assign+1] == a) {
				checkAndFlipLine5(player1,x,y);
				direct = 5;
			}

			return direct;
		}

		//外側辺のチェック
		//左辺
		if(assign % 8 == 0) {
			if(masu[assign-8] == a) {
				checkAndFlipLine3(player1,x,y);
				direct = 3;
			}
			if(masu[assign-7] == a) {
				checkAndFlipLine4(player1,x,y);
				direct = 4;
			}
			if(masu[assign+1] == a) {
				checkAndFlipLine5(player1,x,y);
				direct = 5;
			}
			if(masu[assign+9] == a) {
				checkAndFlipLine6(player1,x,y);
				direct = 6;
			}
			if(masu[assign+8] == a) {
				checkAndFlipLine8(player1,x,y);
				direct = 7;
			}

			return direct;
		}
		//右辺
		if((assign + 1) % 8 == 0) {
			if(masu[assign-1] == a) {
				checkAndFlipLine1(player1,x,y);
				direct = 1;
			}
			if(masu[assign-9] == a) {
				checkAndFlipLine2(player1,x,y);
				direct = 2;
			}
			if(masu[assign-8] == a) {
				checkAndFlipLine3(player1,x,y);
				direct = 3;
			}
			if(masu[assign+8] == a) {
				checkAndFlipLine7(player1,x,y);
				direct = 7;
			}
			if(masu[assign+7] == a) {
				checkAndFlipLine8(player1,x,y);
				direct = 8;
			}

			return direct;
		}

		//指定されたマスの左隣のマスから時計回りに
		if(masu[assign-1] == a) {
			checkAndFlipLine1(player1,x,y);
			direct = 1;
			
		}
		if(masu[assign-9] == a) {
			checkAndFlipLine2(player1,x,y);
			direct = 2;
			
		}
		if(masu[assign-8] == a) {
			checkAndFlipLine3(player1,x,y);
			direct = 3;
			
		}
		if(masu[assign-7] == a) {
			checkAndFlipLine4(player1,x,y);
			direct = 4;
			
		}
		if(masu[assign+1] == a) {
			checkAndFlipLine5(player1,x,y);
			direct = 5;
			
		}
		if(masu[assign+9] == a) {
			checkAndFlipLine6(player1,x,y);
			direct = 6;
			
		}
		if(masu[assign+8] == a) {
			checkAndFlipLine7(player1,x,y);
			direct = 7;
			
		}
		if(masu[assign+7] == a) {
			checkAndFlipLine8(player1,x,y);
			direct = 8;
			
		}

		return direct;
	}


	public void checkAndFlipLine1(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign-1-i]==0) {
				break;
			}
			if(masu[assign-1-i]==a) {
				continue;
			}
			if(masu[assign-1-i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign-1-i+j]=b;
				}
			}
		}
	}

	public void checkAndFlipLine2(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign-9-9*i]==0) {
				break;
			}
			if(masu[assign-9-9*i]==a) {
				continue;
			}
			if(masu[assign-9-9*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign-9-9*i+9*j]=b;
				}
			}
		}
	}
	public void checkAndFlipLine3(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign-8-8*i]==0) {
				break;
			}
			if(masu[assign-8-8*i]==a) {
				continue;
			}
			if(masu[assign-8-8*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign-8-8*i+8*j]=b;
				}
			}
		}
	}

	public void checkAndFlipLine4(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign-7-7*i]==0) {
				break;
			}
			if(masu[assign-7-7*i]==a) {
				continue;
			}
			if(masu[assign-7-7*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign-7-7*i+7*j]=b;
				}
			}
		}
	}
	public void checkAndFlipLine5(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign+1+i]==0) {
				break;
			}
			if(masu[assign+1+i]==a) {
				continue;
			}
			if(masu[assign+1+i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign+1+i-j]=b;
				}
			}
		}
	}
	
	public void checkAndFlipLine6(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign+9+9*i]==0) {
				break;
			}
			if(masu[assign+9+9*i]==a) {
				continue;
			}
			if(masu[assign+9+9*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign+9+9*i-9*j]=b;
				}
			}
		}
	}



	public void checkAndFlipLine7(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign+8+8*i]==0) {
				break;
			}
			if(masu[assign+8+8*i]==a) {
				continue;
			}
			if(masu[assign+8+8*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign+8+8*i-8*j]=b;
				}
				break;
			}
		}
	}
	
	public void checkAndFlipLine8(boolean player1, int x, int y) {

		//指定されたマス
		int assign = (y-1)*8+x-1;

		int a;
		int b;
		if(player1) {
			a = 2;
			b = 1;
		}else {
			a = 1;
			b = 2;
		}

		for(int i=1; i<=6; i++) {
			if(masu[assign+7+7*i]==0) {
				break;
			}
			if(masu[assign+7+7*i]==a) {
				continue;
			}
			if(masu[assign+7+7*i]==b) {

				for(int j=1; j<=i; j++) {
					masu[assign+7+7*i-7*j]=b;
				}
			}
		}
	}

}
