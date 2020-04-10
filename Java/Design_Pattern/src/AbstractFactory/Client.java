package AbstractFactory;

public class Client {
	public static void main(String[] args) {
		AbstractFactory abf = new SamsungFactory(); //�Ｚ ���� ����
		abf.createSmartPhone().getSmartPhone();
		abf.createBtEarPhone().getBtEarPhone();
		
		AbstractFactory abf2 = new AppleFactory(); //���� ���� ����
		abf2.createSmartPhone().getSmartPhone();
		abf2.createBtEarPhone().getBtEarPhone();
	}
	

}
