
public class Casting {

	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1;  // �ս��� ���� ������ �ڵ����� Casting�� ���� ���� (double) 1;�̳� ��������
		System.out.println(b);  // double���̹Ƿ� 1.0���� �����õ�
		
//		int c = 1.1;  // ����. �ս��� �Ͼ�Ƿ�
		double d = 1.1;
		int e = (int) 1.1; // ������ ��Ƽ���� �ٲٴ� ���
		System.out.println(e); // 1�� �ȴ�
		
		// 1 to String
		String f = Integer.toString(1);
		System.out.println("f's class ="+f.getClass());
	}

}
