package java_study_ex;

import java.util.Scanner;

public class Ex3_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("��ǥ �ݾ��� �Է��ϼ���(100���� ����)");

		int goal = sc.nextInt();

		int a=0; 
		int sum = 0;
		while (true) {
			System.out.println("�Աݾ��� �Է��Ͻÿ�(20���� ����)");
			a= sc.nextInt();
			if (a > 20) {
				System.out.println("20���� ������ �ݾ��� �Ա��Ͻÿ�");
			} else {
				System.out.println(a + "������ �Ա��Ͽ����ϴ�.");
				sum += a - 5;
				System.out.printf("���� ���� �ܾ��� %d���Դϴ�.\n", sum);
				if (sum > goal) {
					System.out.println("��ǥ���� �޼��Ͽ����ϴ�.");
				break;
				}
			}
		}

	}

}
