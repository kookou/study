package java_study_ex;

import java.util.Scanner;

public class Ex2_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== �ݾ��� �����Ͻÿ� ====");
		int a = sc.nextInt();
		System.out.println("============");
		System.out.println("1. �ݶ� : 600��");
		System.out.println("2. ���̴� : 400��");
		System.out.println("3. ȯŸ : 900��");
		System.out.println("============");
		System.out.println("������� �����Ͻÿ�(1/2/3)");

		int c = sc.nextInt();
		int p = 0;
		String s = "";
		switch (c) {
		case (1):
			p = 600;
			s = "�ݶ�";
			break;
		case (2):
			p = 400;
			s = "���̴�";
			break;
		case (3):
			p = 900;
			s = "ȯŸ";
			break;
		}

		if (a > p) {
			System.out.printf("�ֹ��Ͻ� ������� %s�Դϴ�.\n", s);
			System.out.println("�ܵ�" + (a - p) + "���� ���Խ��ϴ�");
		} else {
			System.out.println((p - a) + "���� �����մϴ�...");
			System.out.println("���Աݾ� " + a + "���� ���Խ��ϴ�");
		}
	}
}