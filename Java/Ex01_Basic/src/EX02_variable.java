/*
1. Ex02_Variable Ŭ���� >> ���赵
2. public static void main(String[] args) �Լ��� ������ �ִ� Ŭ����: ���α׷��� ������, ������
*Ŭ������ ������ 2����
-class Test {public static void main(String[] args){}}
-class Test{} �����Լ� ���� Ŭ����. �������� ����x :�ٸ� Ŭ������ �����ִ� Ŭ����(lib)

Tip)
C# > public static void Main()
������ ��ġ�� ������ ���� C# å�� ���� 70%�� ���ذ� �ȴ�. �� �� ��ü������

����: variable
�����͸� ���� �� �ִ� ������ �̸�
������ Ÿ��(������ ũ��=�ڷ���=������Ÿ��)�� ������

������ ����Ǵ� ��ġ(scope : ��ȿ ����)
1. instance variable : ��ü���� >> class person {int age}
2. local variable : ��������(�Լ� �ȿ� �ִ� ����) class Person {public void run() {int speed}} �� �� speed�� �������� run�� ����ǰ� ���� �������
                                             �Լ� �ȿ� if��, for �� �ȿ� �ִ� ������ ��������
3. static variable : ��������(�ڿ�) : ��ü�� �����ڿ�

 */

//class�� ���赵�̴� == class Type�̴� (���� ���� ���� Ÿ���� ������ �ִ� ū Ÿ��)
class Test {
	int iv = 500; //instance variable
	//instance variable�� �ʱ�ȭ���� �ʾƵ� �ȴ� (�⺻��: default)
	int window; // default�� 0�� ����
	//�ʱ�ȭ: ó�� ���� ���� ��(�Ҵ��� ���ؼ�)
	//�� �ʱ�ȭ�� ���� �ʾƵ� ��� �����ұ�
	//(hint) : ���赵�� �ϳ�... ���赵�� ������� ����Ʈ�� ������.... ���� ����Ʈ���� â�� ������ �ٸ� �� �ִ�)
	//��) ����Ʈ(��ü)���� �ٸ� ���� ���� �� �ִ�
	
	Test(){ //������(constructor, �ʱ���)�Լ��� �̸��� Ŭ���� �̸��� ���� �Լ�
			//��ü�� ������ ���ÿ� �ڵ����� �Լ� ȣ��ȴ�
	}
	
	Test(int data){ //�����ε�(overloading) : �ϳ��� �̸����� �������� ����� ����
		window = data; //â���� ���� �ʱ�ȭ
	}
	
	void write() {
		int num = 100; //local variable
					   // �Լ��� ȣ��Ǹ� �� �� �޸𸮿� �ö󰡰� �Լ��� ����Ǹ� �������
		// �Լ� �ȿ����� window(��ü ����)�� �ʱ�ȭ�ؼ� ����� �� �ִ�
		window = 111;
		
		int age; //�Լ� �ȿ� �����Ƿ� ��������
		//System.out.println(age); // ���������� �ʱ�ȭ �ؾ� ��. �� ���� ���� �� ���� ���� �ȳ�
	}
	void print() {
		System.out.println("iv : "+iv); //
		//System.out.println("num : "+ num); num�� write�Լ��� local variable�̱� ������ ���� �ȵ�
	}
}

class Apt {
	int window;
}


public class EX02_variable {
	public static void main(String[] args) { //main�� �Լ�(�������� ���� Ư���� �Լ�)
		Test t = new Test();
		t.print();
		t.window = 10;
		System.out.println("t.window : "+t.window);
		
		Test t2 = new Test(100);
		System.out.println(t2.window);
		
		Test t3 = new Test(2);
		System.out.println(t3.window);
		t3.write();
		System.out.println("window �Լ� ȣ���� ���� t3.window :"+t3.window);
	
		
		int lv = 500; // "=" �Ҵ翬���� ";"������� �� �������� ���ڴٴ� ��
					  // "lv" local variable(���� ����)
		System.out.println("lv ������ : "+lv);
		//Ex02 Variable > javac ������ > class > java > ���� > JVM
		// �����: ctrl + F11 (������>>����)
		
		/* ������ ����Ʈ:
		1. local variable�� �ݵ�� initialize�ϰ� ����ؾ� ��
		 initialize: ������ ó�� ���� �Ҵ��ϴ� ��
		2. �Լ� ���� ������ �ݵ�� �ʱ�ȭ����. main�� �Լ���.
		*/
		
		
		int number = 0; //�ʱ�ȭ
		number = 100;
		number = 200;
		System.out.println("number : "+number);
		
		//����� �Ҵ�(�ʱ�ȭ) �и� ����
		int a; //����
		int b;
		//System.out.println(a);// ���� ���� a �ʱ�ȭ���� �ʾ����Ƿ� ���� 
		a = 10; //�ʱ�ȭ
		b = 20;
		System.out.println(a); 
		
		Apt ssung = new Apt(); // ssung�� ��üŸ�� ������ �ȴ�
		System.out.println(ssung.window);
		Apt ppark = ssung;
		ppark.window = 100;
		System.out.println(ssung.window); //�굵 100���� �ȴ�
		System.out.println(ppark); //���赵 �̸� +@+�ּҰ� ��� :Apt@15db9742
		
		Apt c = new Apt(); //���ο� ��ü �ν��Ͻ��̹Ƿ� �ּҰ� ����
		System.out.println(c); //Apt@6d06d69c
		c = ppark;
		System.out.println(c); // ��ü c�� ppark�� ��ȯ�����Ƿ� �������� ����
	}

}
