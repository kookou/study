
public class Ex05_Operation {

	public static void main(String[] args) {

		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;
		System.out.println(result); // �� ������
		
		//�������� ���ϴ� ������(%)
		result = 13%2;
		System.out.println(result);
		
		//����, ����(������ ������: ++, --)
		// ++ : 1�� ����
		int i = 10;
		//i = i +1; 
		
		++i; //��ġ����
		System.out.println("��ġ i : " + i);
		
		i++; //��ġ����
		System.out.println("��ġ i :" + i);
		
		//���� ȥ�� ���� ��, ��ġ, ��ġ�� ���̰� ����
		
		//Point. ������ ��ġ, ��ġ ����
		int i2 = 5;
		int j2 = 4;
		
		int result2 = i2 + ++j2;
		System.out.println("result2 : "+ result2 + ", j2 : " + j2);  
		//result2 : 10, j2 : 5   ��ġ�� �������� �����ϰ� �ֿ����� ����ȴ�
		
		result2 = i2 + j2++; 
		System.out.println("result2 : "+ result2 + ", j2 : " + j2);
		//result2 : 10, j2 : 6  ��ġ�� �ֿ��� �����ϰ� ���� ������ �ѱ� ��, ���������� ����ȴ�
		
		//Today Point
		//�ڹ��� �����Ģ
		//[����]�� ��� ������ [int]�� ��ȯ �� ó���ȴ�
		//byte + byte �� �ϸ� �����Ϸ��� int + int ��ȯ�ؼ� ���� -> �⺻ ����� ���� �⺻���� �Ǿ�����
		byte b = 100; // -128~127
		byte c = 1;
		//byte d = b + c; //b+c�� ���� ����� ����Ǳ� ������ ����
		//byte d =(byte)(b + c); //�ս� �߻�
		int d = b + c; 
		System.out.println("d : " + d); 
		// �ս��� �߻����� �ʴ� ����� �ؾ� �Ѵ�
		
		//byte + short -> �����Ϸ��� int + int
		//char + char -> �����Ϸ��� int + int
		//���� ó�� �� point : �������꿡 int���� ���� Ÿ���� int ��ȯ(long ����)
		//(byte, char, short ���� -> int)
		
		//byte + short -> int + int
		//char + int -> int + int
		//int + long -> long + long
		
		//���� + �Ǽ� > Ÿ��ũ�� ������� > �Ǽ� ����
		long ll = 1000000000L;
		float ff = 1.2f;
		float fresult = ll + ff; //  floatŸ������ ����
		System.out.println(fresult);
		
		float num2 = 10.45f;
		int num3 = 20;
		//num2 + num3
		//float + int >> float + float
		//float result5 = num2 + num3;
		//System.out.println(result5);
		
		int result5 = (int)(num2 + num3);
		System.out.println("�������� ��� : " +  result5);
		
		char c2 = '!'; //char ���� Ÿ��
		char c3 = '!';
		
		int result6 = c2 + c3; //int ������ �ǹǷ�
		System.out.println("result6 : " + result6);
		System.out.println((char)result6); //66�̶�� ���� �ƽ�Ű �ڵ�ǥ ���� B��
		
		//���
		//�߼ұ���� ���蹮��(������ ���) >> ���� ����� (�ﰢ��)
		
		int sum = 0;
		for(int j = 1; j <= 100; j++ ) {
			//System.out.println("j : " + j);
			if(j%2 == 0) {   //¦����
				sum += j;
			}
		}
		System.out.println(sum);  //¦���� ��
		//System.out.println(j);// ����. ���� j�� for���� ����Ǹ� �����Ǿ��ٰ� for���� ������ �����
		
		
		//== ������ (���� ���ϴ� ������)
		if(10 == 10.0f) {  
			System.out.println("True");
		}else {
			System.out.println("False"); 
		}  // ���� ��� True. ==�� ���� ���ϴ� �������̱� ����
		
		// ! ���� ������ 
		if('A' != 65) {
			System.out.println("True");
		}else {
			System.out.println("False");
		} // ���� ��� True. 'A'�� 65�� ���� �ʱ� ������
		
		//�ϱ�����(Today Point)
		//���׿�����
		int p = 10;
		int k = -10;
		int result8 =(p == k)? p : k;  //��ȣ ���� ���̸� :���� ���ϰ�, �����̸� k�� ����
		System.out.println("result8 : " + result8);
		
		//���� �����ڴ� ��� if
		if(p==k) {
			result8 = p;
		}else {
			result8 = k;
		} // ��  3�� �����ڴ�  �� if���� ����
				
//		������
//		0 : false
//		1 : True
		
//		Oracle (sql)
//		
//		select *
//		form emp
//		where empno = 1000 and sal > 2000; 
//		
//		0�� 1�� ��ȯ�ؼ� bit ����
		
//		|| ������(or)
//		&& ������(AND)
		
		
		//��Ʈ����
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y)); //7 ->�������� 
		//������ -> 2����ȭ
		//128 64 32 16 8 4 2 1
		//             0 0 1 1 //������ 3�� 2���� 0011�̴�
		//             0 1 0 1 //������ 5�� 2���� 0101�̴�
		//             0 1 1 1 //x|y�� ��������� 0111, �� 10���� 7�� �ȴ�
		
		//Today Point (&&(and) , ||(or))
//		if(10 > 0 && -1 > 1 && 100 >2 && 1>-1) {���๮} 
//		if(10 > 0 || -1 > 1 || 100 >2 || 1>-1) {���๮} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
