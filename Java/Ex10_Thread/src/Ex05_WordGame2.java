import javax.swing.JOptionPane;

/*
����
main �Լ� ������ Thread 2�� ����
1. �ð�(time) �����ϴ� Thread
2. �ܾ� �Է��� ó���ϴ� Thread

main �Լ� 2�� ����

�� �ܾ �ϳ��� �Է��ؼ� Ȯ�� ��ư�� ������ �ð��� ���߰� �ϼ���
hint) �����ڿ� (static)




*/
class WordInputProcess2 extends Thread{
	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("dan" + "�� ���� �Է�");
		if(inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame2.inputdata = inputdata;
		}
		System.out.println("�Է��� ����: " + inputdata);
	}
}


class WordTimeOut2 extends Thread{
	@Override
	public void run() {
		for(int i=10; i > 0 ; i--) {
			
			if(Ex05_WordGame2.inputdata!=null)return; //run�Լ� Ż��
			
			System.out.println("���� �ð�: " + i);
			try {
				 Thread.sleep(1000); //���ǿ��� 1�ʰ� ������ ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
public class Ex05_WordGame2 {
	static String inputdata= null;
	public static void main(String[] args) {
		WordInputProcess2 word = new WordInputProcess2();
		WordTimeOut2 time = new WordTimeOut2();
			
		word.start();
		time.start();
		
		System.out.println("Main END");

	}

}
