
public class Board {
	
	//�R�}����
	int[] coma = new int[64];

	
	public void show(){
		//�Ղ̍s�ԍ��\��
		System.out.println("�@1 2 3 4 5 6 7 8");

		//�����z�u
		for(int i=0; i<64; i++) {
			coma[i] = 0;
		}

		//�ŏ��ɒu����Ă���R�}
		coma[27] = 1;
		coma[36] = 1;
		coma[28] = 2;
		coma[35] = 2;

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
}
