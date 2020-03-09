//���������� ���ӱ�
//- ���������� �¸� �� 1~20 �� ������ ���ΰ��� ȹ��(�����ϴٸ� 2�ܰ� ����ȹ�� ���� 1,2,4,7,10,20���� �����ϰ� �� Ȯ���� �ֱ�)
//- �¸� �� ���� �������� �ٽ� ���� ����
//- �������� �� ������� ȹ���� ���� �� ��� (�������� �������� �־ �ܿ������� �ִµ��� ������ ���)

//�߰����: 
//- Ŀ�������� Ȯ����/����ȹ�氹�� ����
//- ȹ�� ���� ��(����)�� ���� ��ǰ ����

import java.util.Scanner;

public class RSP_Game {

	static Scanner sc = new Scanner(System.in); //�ν��Ͻ� �ʱ�ȭ ��
	private static int totalCoin;
	static void playGame() {
			
			while (true) {
			int you;
			System.out.println("************");
			System.out.println("����~����~��!");
			System.out.println("************");
			System.out.println("����(1), ����(2), ��(3) �� �ϳ��� �Է��ϼ���.");
			int com = (int) (Math.random() * 3 + 1); // ��ǻ���� ���� ����


			do {
				try { // try catch ���� ������ ó���ϴ°� �ƴ϶� ������ �߻��ص� �켱 catch������ ������ ��� ���α׷��� ����� �� �ְ� ���ִ� ��
					you = Integer.parseInt(sc.nextLine());
					if (1 <= you && you <= 3) {
						break; // whileŻ��( 1<= menu <=3)
					} else {
						// 1���� �۰ų� 4���� ū �� < ���α׷��� ������ �ƴ����� �� ������ ���ڴٴ� ��
						// System.out.println("�߸� �Է��Ͽ����ϴ�");
						throw new Exception("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());			
					System.out.println("�Է� ���� �߻�");
					System.out.println("����(1), ����(2), ��(3) �� �ϳ��� �Է��ϼ���.");
				}

			} while (true);

			if (com == 1)
				System.out.print("��ǻ�ʹ� ����, "); // ��ǻ���� ����
			else if (com == 2)
				System.out.print("��ǻ�ʹ� ����, ");
			else if (com == 3)
				System.out.print("��ǻ�ʹ� ��, ");
			if (you == 1)
				System.out.print("����� ����! "); // ����� ����
			else if (you == 2)
				System.out.print("����� ����! ");
			else if (you == 3)
				System.out.print("����� ��! ");
			if (com == you) {
				System.out.println("�����ϴ�."); // ���
				System.out.println("�ٽ� �� �� �������ּ���.");
			}
			else if ((you - com == -2) || (you - com == 1)) {
				System.out.println("����� �̰���ϴ�.");
				roulette();
				reGame();
			}
			else if ((com - you == 1) || (com - you == -2)) {
				System.out.println("����� �����ϴ�.");
				reGame();				
			}
		}

	}
	
	private static void reGame() {
		System.out.println("���� ���� �հ�: "+totalCoin);
		if(totalCoin>0) {			
			int re;
			System.out.println("�ٽ� �Ͻðڽ��ϱ�?");
			System.out.println("��(1), �ƴϿ�(2) �� �ϳ��� �Է��ϼ���.");
			do {
				try { // try catch ���� ������ ó���ϴ°� �ƴ϶� ������ �߻��ص� �켱 catch������ ������ ��� ���α׷��� ����� �� �ְ� ���ִ� ��
					re = Integer.parseInt(sc.nextLine());
					if (1 <= re && re <= 2) {
						break; // whileŻ��( 1<= menu <=2)
					} else {
						// 1���� �۰ų� 4���� ū �� < ���α׷��� ������ �ƴ����� �� ������ ���ڴٴ� ��
						// System.out.println("�߸� �Է��Ͽ����ϴ�");
						throw new Exception("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("�Է� ���� �߻�");
					System.out.println("��(1), �ƴϿ�(2) �� �ϳ��� �Է��ϼ���.");
				}

			} while (true);
			if(re==1) {
				totalCoin-=1;
			}else {
				System.out.println("���� ȹ�� ���� ����: "+totalCoin+"��");
				System.out.println("������ �����մϴ�. �����մϴ�.");
				System.exit(0);
			}
			
		}else {			
			System.out.println("������ �� ���������ϴ�. ������ �����մϴ�. �����մϴ�.");
			System.exit(0);
		}
	}
	
	private static void roulette() {
		int point = (int) (Math.random() * 100 + 1);
		int getCoin;
		if(1<=point&&point<=40) {
			getCoin=1;
			totalCoin+=getCoin;
		}else if(point<=65) {
			getCoin=2;
			totalCoin+=getCoin;
		}else if(point<=80) {
			getCoin=4;
			totalCoin+=getCoin;
		}else if(point<=90) {
			getCoin=7;
			totalCoin+=getCoin;
		}else if(point<=98) {
			getCoin=10;
			totalCoin+=getCoin;
		}else  {
			getCoin=20;
			totalCoin+=getCoin;
		}
		System.out.println("�����մϴ�. ���� "+ getCoin+ "�� ȹ��!");		
	}

	public static void main(String[] args) {
		playGame();		
	}
}
