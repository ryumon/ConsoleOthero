
public class Board {

	//�R�}����
	int[] coma = new int[64];


	/**
	 * �Ղ̑S�Ẵ}�X��0�ŏ�������A�����z�u�̂S�̃R�}������
	 */
	public void makeBoard() {
		for(int i=0; i<64; i++) {
			coma[i] = 0;
		}
		//�ŏ��ɒu����Ă���R�}
		coma[27] = 1;
		coma[36] = 1;
		coma[28] = 2;
		coma[35] = 2;
	}

	/**
	 * �Ղ�\������
	 */
	public void show(){
		//�Ղ̍s�ԍ��\��
		System.out.println("�@1 2 3 4 5 6 7 8");





		for(int i=0; i<64; i++) {

			if(i%8==0){
				System.out.println();
				//�Ղ̗�ԍ��\��
				System.out.print(i/7+1);
			}

			if(coma[i]==0) {
				System.out.print(" #");	
			}else if(coma[i]==1) {
				System.out.print(" ��");
			}else {
				System.out.print(" ��");
			}

		}
	}
	
	public void method(boolean player1, int x, int y) {
		
		if(player1) {
			coma[(y-1)*8+x-1] = 1;
		}else {
			coma[(y-1)*8+x-1] = 2;
		}
		
		
	}
}
