import java.util.Arrays;
import java.util.Scanner;

//3������ ���� ���ڿ� ����ڰ� �Է��� ���� ���Ͽ�
//���ڵ� ���� �ڸ��� ������ STRIKE��
//���ڴ� ������ �ڸ��� �ٸ��� BALL��
//���ڰ� �ٸ��� OUT�� ����ϴ� �߱����� �����.

public class Baseball {
	static int pickNumber() {
		// return (int) (Math.random() * 10); //0~9����
		return (int) (Math.random() * 9) + 1; // 1~9����
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int q1 = pickNumber();
		int q2 = pickNumber();
		while (q1 == q2) {
			q2 = pickNumber();
		}
		int q3 = pickNumber();
		while (q1 == q2 || q2 == q3 || q1 == q3) {
			q3 = pickNumber();
		}

		int player;
		int p1, p2, p3;
		int count = 0; // �÷��� Ƚ��
		int[] log = new int[9];

//		System.out.println(q1);
//		System.out.println(q2);
//		System.out.println(q3);

		System.out.println("************");
		System.out.println("   ���ھ߱� ����");
		System.out.println("************");

		while (true) {
			System.out.println("�� ���� �ٸ� ���ڸ� �Է��� �ּ���.");

			do {
				try { // try catch ���� ������ ó���ϴ°� �ƴ϶� ������ �߻��ص� �켱 catch������ ������ ��� ���α׷��� ����� �� �ְ� ���ִ� ��
					player = Integer.parseInt(sc.nextLine());
					p1 = player / 100;
					p2 = player % 100 / 10;
					p3 = player % 10;
					if ((0 <= player && player <= 999) && p1 != p2 && p2 != p3 && p3 != p1) {
						break;
					} else {
						throw new Exception("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("�Է� ���� �߻�");
					System.out.println("�� ���� �ٸ� ���ڸ� �Է��� �ּ���.");
				}

			} while (true);

			int strike = 0;
			int ball = 0;
			int[] quiz = { q1, q2, q3 };
			int[] play = { p1, p2, p3 };

			for (int i = 0; i < quiz.length; i++) {
				if (quiz[i] == play[i]) {
					strike++;
				}
				for (int j = 0; j < play.length; j++) {
					if (quiz[i] != play[i] && quiz[i] == play[j]) {
						ball++;
					}
				}
			}
			System.out.printf("%dSTRIKE, %dBALL %dOUT�Դϴ�.%n", strike, ball, 3 - (strike + ball));
			log[count] = player;
			count++;
			System.out.println("���� �÷��� Ƚ��: " + (9 - count));
			System.out.println("�÷��� ���: " + Arrays.toString(log));
			if (9 - count == 0) {
				System.out.println("���� �÷��� Ƚ���� �� ���̽��ϴ�. ���ӿ���");
				System.exit(0);
			}
			if (q1 == p1 && q2 == p2 && q3 == p3) {
				System.out.println("*****�����Դϴ�!*****");
				System.exit(0);
			}
		}
	}

}
