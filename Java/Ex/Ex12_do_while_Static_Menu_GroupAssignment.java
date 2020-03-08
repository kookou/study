import java.util.Scanner;

public class Ex12_do_while_Static_Menu_GroupAssignment {
	static Scanner sc = new Scanner(System.in);

	// �ʱ� �޴� ȭ�� �Լ�
	static int displayMenu() {
		System.out.println("****************");
		System.out.println("****���� �޴�*****");
		System.out.println("1. �ѽ�");
		System.out.println();
		System.out.println("2. ���");
		System.out.println();
		System.out.println("3. �߽�");
		System.out.println();
		System.out.println("4. ������");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 4) {
					break; // whileŻ��( 1<= menu <=4)
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("�޴� 1~4������ �Է�");
			}
		} while (true);
		return menu;
	}

	// �ѽĸ޴� �Լ�
	static int kFood() {
		System.out.println("****************");
		System.out.println("****�ѽ� �޴�*****");
		System.out.println("1. ��ġ�");
		System.out.println();
		System.out.println("2. �����");
		System.out.println();
		System.out.println("3. ���ܺ����");
		System.out.println();
		System.out.println("4. ��������");
		System.out.println();
		System.out.println("5. ���� �޴���");
		System.out.println();
		System.out.println("6. ���α׷� ����");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("�޴� 1~6������ �Է�");
			}
		} while (true);
		// ���Ⱑ ����ƴٴ� ���� ����ڰ� 1~6���� ��ȣ �߿��� �ϳ��� ������ ��
		return menu;
	}

	static int wFood() {
		System.out.println("****************");
		System.out.println("****��� �޴�*****");
		System.out.println("1. ���");
		System.out.println();
		System.out.println("2. ����");
		System.out.println();
		System.out.println("3. ���İ�Ƽ");
		System.out.println();
		System.out.println("4. �ܹ���");
		System.out.println();
		System.out.println("5. ���� �޴���");
		System.out.println();
		System.out.println("6. ���α׷� ����");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("�޴� 1~6������ �Է�");
			}
		} while (true);
		// ���Ⱑ ����ƴٴ� ���� ����ڰ� 1~6���� ��ȣ �߿��� �ϳ��� ������ ��
		return menu;
	}

	static int cFood() {
		System.out.println("****************");
		System.out.println("****�߽� �޴�*****");
		System.out.println("1. ¥���");
		System.out.println();
		System.out.println("2. «��");
		System.out.println();
		System.out.println("3. ������");
		System.out.println();
		System.out.println("4. ���꽽");
		System.out.println();
		System.out.println("5. ���� �޴���");
		System.out.println();
		System.out.println("6. ���α׷� ����");
		System.out.println();
		// return 0;
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					break;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("�޴� 1~6������ �Է�");
			}
		} while (true);
		// ���Ⱑ ����ƴٴ� ���� ����ڰ� 1~6���� ��ȣ �߿��� �ϳ��� ������ ��
		return menu;
	}

	// ���ø޴� �Լ�
	static void decision(String s, int p) {
		System.out.printf("%s��(��) %d�� �Դϴ�.\n", s, p);
		System.out.printf("%s�� �����Ͻðڽ��ϱ�?\n", s);
		System.out.println("��(1), �ƴϿ�(2) �Է��� �ּ���.");
		int d;
		do {
			try {
				d = Integer.parseInt(sc.nextLine());
				if (1 <= d && d <= 2) {
					break; // whileŻ��( 1<= menu <=4)
				} else {
					throw new Exception("��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("��(1), �ƴϿ�(2) �Է��� �ּ���.");
			}
		} while (true);
		if (d == 1) {
			System.out.printf("%s�� �ֹ��ϼ̽��ϴ�. �����մϴ�.\n", s);
			System.exit(0);
		} else {
			System.out.println("�޴��� �ٽ� �����ϼ���.");
		}
	}

	public static void main(String[] args) {
		// Ex12_do_while_Static_Menu ex11 = new Ex12_do_while_Static_Menu();
		while (true) {

			switch (Ex12_do_while_Static_Menu_GroupAssignment.displayMenu()) {
			case 1: {
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.kFood()) {
					case 1:
						Ex12_do_while_Static_Menu_GroupAssignment.decision("��ġ�", 5000);
						break;
					case 2:
						Ex12_do_while_Static_Menu_GroupAssignment.decision("�����", 5000);
						break;
					case 3:
						decision("���ܺ����", 4500);
						break;
					case 4:
						decision("��������", 6000);
						break;
					case 5:
						System.out.println("�ʱ� �޴��� ���ư��ϴ�");
						break outer;
					case 6: {
						System.out.println("���α׷� ����");
						System.exit(0);
					}
					}
					
				} break;
			}

			case 2:
			{
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.wFood()) {
					case 1:
						decision("���", 6000);
						break;
					case 2:
						decision("����", 10000);
						break;
					case 3:
						decision("���İ�Ƽ", 8000);
						break;
					case 4:
						decision("�ܹ���", 5000);
						break;
					case 5:
						System.out.println("�ʱ� �޴��� ���ư��ϴ�");
						break outer;
					case 6: {
						System.out.println("���α׷� ����");
						System.exit(0);
					}
					}
					
				} break;
			}
			case 3:
			{
				outer: while (true) {
					switch (Ex12_do_while_Static_Menu_GroupAssignment.cFood()) {
					case 1:
						decision("¥���", 5000);
						break;
					case 2:
						decision("«��", 5000);
						break;
					case 3:
						decision("������", 7000);
						break;
					case 4:
						decision("���꽽", 20000);
						break;
					case 5:
						System.out.println("�ʱ� �޴��� ���ư��ϴ�");
						break outer;
					case 6: {
						System.out.println("���α׷� ����");
						System.exit(0);
					}
					}
					
				} break;
			}
			case 4:
				System.out.println("���α׷� ����");
				System.exit(0);
			}
		}
	}
}