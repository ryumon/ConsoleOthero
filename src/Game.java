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

			//���͂��󂯂Ă����ɃR�}���u���邩�ǂ����𔻒肷�郁�\�b�h
			boolean isOK = board.check(player1, x,y);
			if(isOK==false) {
				System.out.println("�R�}���u���܂���B��蒼���Ă��������B");
				continue;
			}

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
