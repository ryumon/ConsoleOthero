import java.util.Scanner;

public class Game {

	public void start() {
		System.out.println("�Q�[���X�^�[�g�I");

		Board board = new Board();
		board.makeBoard();
		board.show();

		//��ԁ@true�̂Ƃ��͍����Afalse�̂Ƃ��͔���
		boolean player1 = true;

		Scanner scan = new Scanner(System.in);


		while(true) {
			int input = scan.nextInt();

			//���f����999
			if(input==999) {
				break;
			}

			int x = input / 10;
			int y = input % 10;

			//���͂��󂯂Ă��̎��͂ɑ���̃R�}�����邩�ǂ����𔻒�B�������ꍇ���̕�����1~8�ŕԂ��A���������ꍇ0��Ԃ�
			int direction = board.check(player1, x,y);
			if(direction==0) {
				System.out.println("�R�}���u���܂���B��蒼���Ă��������B");
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
//					System.out.println("�R�}���u���܂���B��蒼���Ă��������B");
//					continue;
//					
//			}
			
			

			//���͂��󂯂āA�R�}��u�����\�b�h ���\�b�h����ōl����
			board.method(player1, x, y);

			board.show();
			//��Ԃ̌��@�p�X�Ƃ��܂��l���Ȃ�
			player1 = !player1;
		}



		//�I�����b�Z�[�W�\��
		System.out.println("999�����͂��ꂽ�̂ŏI�����܂��B");

	}
}
