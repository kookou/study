/*
 * 1. �ڹٴ� �ý����� �����ϴ�  �⺻ 8���� Ÿ���� ����(�ڷ���)
 * 2. 8���� �⺻ Ÿ���� ���� �����ϴ� Ÿ��
 * 3. ���� -> ���� -> (���� ����, 0, ���� ����) -> byte(-128~127)
 * 									  -> char(�� ���ڸ� ǥ���ϴ� Ÿ��)
 * 									           �ѹ���(2byte) >> �ѱ�1��(2byte)
 * 														������, Ư��, ����(1byte)
 * 														���� -> char(��� ���� �� ���ڷ� ǥ������ -> unicode)
 * 									    -> short(C��� ȣȯ��: 2byte)
 * 										-> int (-21�� ~ 21��: 4byte) **Java ���� ���� �⺻ Ÿ��**
 * 										-> long (8byte)
 * 			�Ǽ�(�ε��Ҽ���) -> float(4byte) , double(8byte)
 * 			>> ���е� ���� -> ǥ�� ������ ũ��.**Java �Ǽ� ������ �⺻ Ÿ���� double**
 * 	�� -> ��, ���� -> boolean >> ���α׷��� ���� �帧 ����
 * 
 *  �ñ��� ��: ���ڿ��� ǥ���� �� �ִ� Ÿ����? Ŭ����(����Ÿ��) >> ��� String s = new String("ȫ�浿");�̶� �����
 * 
 * 
 * �ڹٴ� ũ�� 
 * 1. ��Ÿ��(value type): ����, �� �� 8����
 * 2. ����Ÿ��(reference type): Ŭ����, �迭 �� > ������ ���� ����Ǵ� ���� �ƴ϶� �ּҰ� ����(������)
 * 
 * ** class == ���赵 == Type
 */

class Car { // Car�� type==���赵�̴� > ��üȭ�� �깰 > ��üȭ(�޸�)
	String color;
	int window;

}

public class Ex03_DataType {
	public static void main(String[] args) {
		String str = "ȫ�浿";
		int age = 100;

		Car c; // ����. c�� main�ȿ� �ִ� ���������̹Ƿ� �ʱ�ȭ�� �ؾ� �Ѵ�.
				// c ��� ������ �ʱ�ȭ > �ּҸ� ���� ���ؼ���
		c = new Car();
		System.out.println(c); // Car@15db9742

		Car c2 = new Car(); // ����� ���ÿ� �ʱ�ȭ
		System.out.println(c == c2); // false. �ּҰ��� ���� �ٸ��� ����
		c2.window = 100;
		c2.color = "blue";

		int i = 10; // ����� �Ҵ�

		int j; // ����
		j = 20; // �Ҵ� �и�

		int k;
		k = j;
		System.out.println("k : " + k);
		k = 300;
		System.out.println("k : " + k);

		// int i = 200; // ���� �Լ� �ȿ� ���� ������ ���� X

		int p, q; // �̷��� �ҰŸ� Array ���. int[] arr = new int[3];

		// int(ǥ������: -21��~21��)
		// Today Point
		// literal >> �ִ� �״��
		// ���� ���ͷ�: 1000000000 : �ڹ��� ���� ���ͷ����� int�� default
		// ���ڸ��ͷ�: ABC
		// int p = 10000000000; //out of range
		long num2 = 100;
		// long num3 = 10000000000; // long Ÿ���� ���������� ���ͷ��� out of range�� ������ ���� ���ͷ�����
		// int�� default�̱� ����
		long num3 = 10000000000L; // ���� long Ÿ���� ǥ���ϴ� ���ڴ� �ڿ� ���� L�� �ٿ���� �Ѵ�.

		// int p = 10000000000L; // �� �� long type ���ͷ� ���ڸ� int�� �Ҵ��Ϸ��� �߱� ������ ����. convert��
		// �Ұ��ϴ�

		// char : 2byte (������)
		// �� ���ڸ� ǥ���ϴ� �ڷ���(������ Ÿ��)
		// �Ϲ�������
		// 1. �ѱ� 1�� : 2byte
		// 2. ������, Ư������, ���� : 1byte
		// unicode >> �ѱ�, ���� >> 2byte ���
		// char �� ���ڸ� �޴´�
		// Today Point
		// ���ڿ�: "��", "Hello"
		// ����: 'A', '��'

		char single = '��';
		System.out.println(single);
		char ch = 'A';
		System.out.println(ch);
		// char�� ���ڸ� ���������� ���������� �������� ������ �ִ�(�ƽ�Ű �ڵ�ǥ)����
		// casting(Ÿ�Ժ�ȯ)
		int intch = 'A'; // �ڵ�����(����������) �Ͻ��� �� ��ȯ. ���� Ÿ�Կ��� �� ū Ÿ������ ���� ���� �ڵ� ��ȯ
		System.out.println("intch : " + intch); // intch : 65 �� ���. char���ͷ��� �ڵ������� int�� convert�� ��

		System.out.println((int) ch); // type casting�Ǿ� 65�� ���

		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int) ch2);// charŸ�� ch2�� (int)ch2�� �̿��� intŸ������ ĳ����. ����� ����ȯ(Explicit Type Conversion) 97
										// ���

		int intch2 = 65;
		// char ch3 = intch2; // intch2�� ���� 65�� charŸ�Կ� ���⿡ ����� ���� ��������, Ÿ���� int�̱� ������
		// �޸� �Ҵ翡�� ���� �߻�
		char ch3 = (char) intch2; // ����� ����ȯ �ʿ�
		// Key Point : �� ū Ÿ�Կ��� �� ���� Ÿ������ ��ȯ�� ���� ����� ����ȯ �ʿ��ϴ�. �ٸ�, �ս��� �����ؾ� �Ѵ�.

		int intch3 = ch3; // ������ ����ȯ(Explicit Type Conversion) �� ���� Ÿ���� �� ū Ÿ������ �Ҵ��� ���� �ڵ����� ���ش�.
							// int intch3 = (int)ch3;�� ��������
		System.out.println(intch3);

		// Today point
		// 1. �Ҵ翡�� ������ ������ �ִ� ���� �������� '������ Ÿ��'�� ����
		// 2. ������ Ÿ�� ũ�⸦ Ȯ������
		// 3. ūŸ�Կ��� ���� Ÿ���� ���� �� �ִ�.
		// 4. ���� Ÿ�Կ��� ū Ÿ�԰��� �� �ִ´�.
		// 5. ���� -> ū �Ϸ��� casting�� �ʿ��ϴ�. �ٸ� �ս��� �����ؾ� �Ѵ�.
		// boolean�� ����ȯ���� �ʴ´�.

		int intValue = 10165468;
		byte byteValue = (byte) intValue; // ����� �� ��ȯ, casting
		System.out.println(byteValue); // �սǵ� �� ����

		// String(���ڿ�) Ÿ������ ����
		String name = "hello world";
		System.out.println(name);

		String name2 = name + " �ȳ��ϼ���";
		System.out.println(name2);
		// DB(oracle >> + ������(���)�θ� ���� , ���� �����ڴ� '||'�� ����)

		// TIP java Ư������ ����ϱ�
		char sing = '\''; // Ư�����ڸ� �����ϱ� ���� '\'�� ���

		// ȫ"��"�� �̶�� ���ڸ� String ������ �����ϰ� ȭ�鿡 ����� ������.
		String ename = "ȫ\"��\"��";
		System.out.println(ename);

		String str3 = "1000";
		String str4 = "10";

		String result = str3 + str4;

		System.out.println(100 + "100"); // 100100. int + String�� �� �� string ��� ���� ����
		System.out.println(100 + 100 + "100"); // 200100. ������ �⺻������ ������ �켱���̴�.
		System.out.println(100 + (100 + "100")); // 100100100. ��ȣ�� ������ �� ���� �켱���̴�.
		System.out.println(100 + "100" + 100); // 100100100. ���ʺ��� �����ϹǷ� �� ���ڿ� ���� ���꿡 �ش�ȴ�

		
		//C:\temp ȭ�鿡 ����ϼ��� (String ������ �ְ� ȭ�� println ���)
		  
		String temp = "C:\\temp"; // '\t'�� tab ������. ���� \�� �տ� ����� ���ڿ��� �״�� ��µȴ�. (\n-> new line) System.out.println(temp);
		
				
//		�Ǽ�(�ε��Ҽ���) : ���ٴϴ� ��
//		float : 4byte
//		double : 8byte : **�Ǽ��� �⺻ Ÿ��(���ͷ���)�� double**
		
		float f = 3.14f; //���ͷ� 3.14�� doubleŸ��. ���� f�� �ڿ� �ٿ���� �Ѵ�.
		
		float f2 = 1.123456789f;
		System.out.println("f2 : " + f2); // 1.1234568
//		floatŸ���� �Ҽ����� 7�ڸ����� ǥ�������ϹǷ� �̸� �Ѿ ��� �Ҽ����� 8��° �ڸ����� �ݿø��ؼ� ���� ������
		
		double d = 1.123456789123456789; //�뷫 �Ҽ����� 16�ڸ� ǥ��
		System.out.println("d : " + d ); // 1.1234567891234568 �ݿø���
		
		//Quiz
		//byte q = 128; //128�̶� �������� �⺻������ int �׸��� ����� ����
		byte bt = (byte)128;
		System.out.println(bt); // -128 (overflow�� ��ȯ��)
		
		//double d2 = 100; //������ ����ȯ
		double d2 = (double)100; // ������ �̷��� �Ǵ� ��
		System.out.println(d2); //100.0  double Ÿ������ ĳ���õǾ����Ƿ� 100�� �ƴ� 100.0�� ���
		
		
		//Quiz
		double d3 = 100;
		int i5 = 100;
		//int result = d3 + i5; //int = int + double(���� = ���� + �Ǽ�)�̹Ƿ� ���� ����Ÿ��+�Ǽ�Ÿ���� �Ǽ�Ÿ���̴�
		// �ذ�å
		//1. int -> double
		//double result2 = d3 + i5;
		
		//2. casting
		//int result2 = d3 + i5;
		
		//3. casting
		//int result2 =(int)(d3 + i5);
		
		//1������ �ؾ� ������ �ս��� �߻����� �ʴ´�
		
		//Today Point
		//���� Ÿ�� + ū Ÿ�� >> ū Ÿ��
		//Ÿ�԰� ��ȯ >> ������ ������ ���� ���� ���� ������ Ÿ���� ���� �Ǵ�����
		//����� ����ȯ(casting) (�ٲٷ��� Ÿ��)���� �Ǵ� ��
		
		int i6 = 100;
		byte b2 = (byte)i6; //����� ����ȯ
		System.out.println(b2);
		
		byte b3 = 20;
		int i7 = b3;
		//�����Ϸ��� ���������� (int)b3 ���� : �Ͻ��� ����ȯ
		
		
		
			
			
				
		 
		  
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
