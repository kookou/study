//�������� ������ �켱�ο� .... ������(cpu)
//Min 1  ~  Max 10  >> default 5

class Pth extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("----------------");
		}
	}
}
class Pth2 extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("||||||||||||||||");
		}
	}
}
class Pth3 extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("***************");
		}
	}
}
public class Ex07_priority {
	public static void main(String[] args) {
		Pth pth = new Pth();
		Pth2 pth2 = new Pth2();
		Pth3 pth3 = new Pth3();
		
		System.out.println(pth.getPriority());    //�켱���� �⺻���� 5
		System.out.println(pth2.getPriority());   //���������� 5
		System.out.println(pth3.getPriority());   //���������� 5
		
		
		//�켱������: 1~10 ����. ���� Ŭ���� ���� �켱����
		pth.setPriority(10);   //�켱 ������ ������
		pth3.setPriority(1);   //�켱 ������ ������
		
		pth.start();
		pth2.start();
		pth3.start();

	}

}








