
public class Ex06_Operation {

	public static void main(String[] args) {

		int sum = 0;
		// ���Կ�����: +=, -+, *=, ....
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum - 1;
		System.out.println(sum);

		// ������ ���� ����
		// ����: A+, A-, B+, B-, ..... F
		// ������ ����: 94��

		// �Ǵܱ��� : 90�� �̻�? ... A
		// �׷��� 95���̻�? .... A+
		// �ƴѵ�... A-

		int score = 92;
		String grade = ""; // ���ڿ��� �ʱ�ȭ
		System.out.println("����� ������ : " + score);

		// ������� ����
		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println("����� ������ : " + grade);

//		if(score >= 90) {          //3�� ������ ���
//			grade =(score >= 95)? "A+" : "A-";			
//		}else if(score >= 80) {
//			grade =(score >= 85)? "B+" : "B-";			
//		}else if(score >= 70) {
//			grade =(score >= 75)? "C+" : "C-";			
//		}else {
//			grade = "F";			
//		}
//		System.out.println("����� ������ : " + grade);

		// Tip: �ҽ� �����ϱ�
		// Ctrl+Shift+f (�ڵ�����)

		// switch��

		int data = 80;
		switch (data) {
		case 100:
			System.out.println("100�Դϴ�");
			break;
		case 90:
			System.out.println("90�Դϴ�");
			break;
		case 80:
			System.out.println("80�Դϴ�");
			break;
		default:
			System.out.println("defalut");
		}

		// break�� �������� �ƴ�
		// break ���� �����ϴ� �� ���ĺ��� ��� ����

		int month = 2;
		String res = "";
		switch (month) {
		case 1:
			; // �����Ұ� ������ ��� ;�� �Ƚᵵ �ȴ�
		case 3:
			;
		case 5:
			;
		case 7:
			;
		case 8:
			;
		case 10:
			;
		case 12:
			res = "31";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30";
			break;
		case 2:
			res = "29";
			break;
		default:
			System.out.println("�� �����Ͱ� �ƴմϴ�.");
		}
		System.out.println(month + "���� " + res + "�� �Դϴ�.");

		// ����(������: ������ ���Ⱚ)
		// https://docs.oracle.com/javase/8/docs/api/index.html
		// �˻�
		// java.lang.Math (Math Ŭ����)
		// Math.Random() �Լ�: ȣ�⿡ ���ؼ� �����
		// java ���������� default�� ������� ������ �ִ�. (java.lang)
		// ���� import java.lang �����ϰ� Math.random()���� ȣ���� �� �ִ�
		// static: ��ü�� �������� �ʾƵ� ��� ������ �Լ�
		// random�� ���� ����: greater than or equal to 0.0 and less than 1.0
		// ���: double �Ǽ� : 0.0 <= random < 1.0

		System.out.println("Math.random() : " + Math.random());
		System.out.println("Math.random() * 10 :" + Math.random() * 10);
		
		System.out.println("(int)Math.random() * 10 :" + (int)(Math.random() * 10)); // 0~9���� ������
		
		System.out.println("(int)Math.random() * 10 :" + (int)(Math.random() * 10 + 1)); // 1~10������ ������
		// �ζ�
		System.out.println("�ζ� ��ȣ ���� :" + (int) (Math.random() * 44 + 1));

		/*
		 * ������ Ǯ�� ������ --3�� �Ǵ� 2���� ���� Ǯ����� --������ Ǫ�ø� ���ݱ��� ��� �� ���� �ϰ� ������ ���� �츮�� ��ȭ�� ��ǰ
		 * �ý����� ������� �Ѵ� ��ǰ �ý����� ������ ������ ���� ��ǰ�� �����ϴ� �ý����̴� ��ǰ ��÷�� 1000 ������ ������ ��ǰ���� TV ,
		 * NoteBook , ����� , �ѿ켼Ʈ , ���� ��ǰ ��÷�� 900 ������ ������ ��ǰ���� NoteBook , ����� , �ѿ켼Ʈ , ����
		 * ��ǰ ��÷�� 800 ������ ������ ��ǰ���� ����� , �ѿ켼Ʈ , ���� ��ǰ ��÷�� 700 ������ ������ ��ǰ���� �ѿ켼Ʈ , ���� ��ǰ
		 * ��÷�� 600 ������ ������ ��ǰ���� ���� �׿� ������ 100 ~ 500 ������ ĩ�� ��ǰ�ý����� ���� ������ 100 ~ 1000 ������
		 * �����Ǿ� �ִ� ����ڰ� ��ǰ �ý����� ���� �����ϰ� 100 ~ 1000������ ���� ������ �Ǿ� �ֽ��ϴ�.
		 * 
		 */

		// ��ȭ�� ��ǰ �ý���
		String gift = "";
		int point = ((int) (Math.random() * 10 + 1) * 100);
		switch (point) {
			case (1000):
				gift += "TV, ";
			case (900):
				gift += "NoteBook, ";
			case (800):
				gift += "�����, ";
			case (700):
				gift += "�ѿ켼Ʈ, ";
			case (600):
				gift += "����";
				break;
			default:
				gift += "ĩ��";
		}
		System.out.println("�����մϴ�!! ����� ������ " + point + "�Դϴ�. ������ ��ǰ�� " + gift + "�Դϴ�~^^");

		// ������ �ش�
		int jumsu = ((int) (Math.random() * 10) + 1) * 100;
		System.out.println("��÷��ȣ : " + jumsu);
		String msg = ""; // �ʱ�ȭ
		msg += "������ ������ " + jumsu + "�̰� ��ǰ�� ";
		switch (jumsu) {
			case (1000):
				msg += "TV, ";
			case (900):
				msg += "NoteBook, ";
			case (800):
				msg += "�����, ";
			case (700):
				msg += "�ѿ켼Ʈ, ";
			case (600):
				msg += "����";
				break;
			default:
				msg += "ĩ��";
		}
		System.out.println(msg + "�Դϴ�.");

	}

}
