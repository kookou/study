import java.util.Scanner;

/*��ȭ�� ���� ���α׷�
����
���
��ȸ
��� �⺻������ �־ ���弼��*/

public class Ex07_Cinema {
	static Scanner sc = new Scanner(System.in);
	static String[][] seat;
	static String[][] seatWithCustomerName;
	static String customerName;

	public Ex07_Cinema() {

		seat = new String[3][5];
		seatWithCustomerName = new String[3][5];

		// �¼� ����
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = (i + 1) + "-" + (j + 1);
			}
		}

		// �¼� ���� ����
		for (int i = 0; i < seatWithCustomerName.length; i++) {
			for (int j = 0; j < seatWithCustomerName[i].length; j++) {
				seatWithCustomerName[i][j] = "";
			}
		}

	}

	// �ʱ� �޴�

	int displayMenu() {
		System.out.println();
		System.out.println("**********************");
		System.out.println("*****��ȭ ���� �ý���*****");
		System.out.println("**********************");
		System.out.println("1. �����ϱ�");
		System.out.println();
		System.out.println("2. ������ȸ");
		System.out.println();
		System.out.println("3. �������");
		System.out.println();

		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					break;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("1~3���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);
		return menu;
	}

	// �¼����� �����ֱ�
	void showSeat() {
		System.out.println("*********�¼� ��Ȳ**********");
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.printf("[%s]", seatWithCustomerName[i][j].equals("") ? (i + 1) + "-" + (j + 1) : "����");
			}
			System.out.println();

		}
		System.out.println("-------------------------");
	}

	void nameInput() {

		System.out.println("���Ÿ� ���� ������ �Է����ּ���. ��)ȫ�浿");
		customerName = sc.nextLine();
	}

	void reservation() {
		int row = 0;
		int col = 0;
		outer: while (true) {

			nameInput();

			// �¼� �����ϱ�
			while (true) {
				String input;
				outer4: do {
					try {
						showSeat();
						System.out.println("�¼��� �������ּ���. ��)1-1");
						System.out.println("�̹� ���ŵ� �¼��� \"����\"��� ǥ�õ˴ϴ�.");
						input = sc.nextLine();
						String[] inputArray = input.split("-");
						row = (Integer.parseInt(inputArray[0])) - 1;
						col = (Integer.parseInt(inputArray[1])) - 1;

						for (int i = 0; i < seat.length; i++) {
							for (int j = 0; j < seat[i].length; j++) {

								if (seat[i][j].contentEquals(input)) {
									break outer4;
								} else if (seat[i][j].contentEquals("����")) {
									break outer4;
								}

							}
						}
						throw new Exception("�Է� ����");

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("�¼� �Է� ������ �߸��Ǿ����ϴ�.");
					}
				} while (true);

				if (!seat[row][col].contentEquals("����")) {
					System.out.println("���� �����մϴ�. �����Ͻðڽ��ϱ�?");

					outer2: do {
						System.out.println("��(1), �ƴϿ�(2)�� �ϳ��� �Է����ּ���.");
						int choice = 0;
						choice = Integer.parseInt(sc.nextLine());
						try {
							if (choice == 1 || choice == 2) {
								if (choice == 1) {
									seat[row][col] = "����";
									seatWithCustomerName[row][col] = customerName;
									System.out.println();
									System.out.printf("������ �Ϸ�Ǿ����ϴ�. %s������ �����Ͻ� �¼��� %s�Դϴ�. �����մϴ�.\n\n", customerName,
											input);
									break outer;
								} else {

									break outer2;
								}

							} else
								throw new Exception("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");

						} catch (Exception e) {
							System.out.println(e.getMessage());

						}
					} while (true);

				} else {
					System.out.println();
					System.out.println("�̹� ����� �¼��Դϴ�");
				}
			}
		}

	}

	boolean reservationInquiry() {
		do {
			System.out.println("�����Ͻ� �� ����� �̸��� �Է����ּ���. ��)ȫ�浿");
			customerName = sc.nextLine();
			if (customerName.contentEquals("")) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			} else {
				for (int i = 0; i < seat.length; i++) {
					for (int j = 0; j < seat[i].length; j++) {
						if (seatWithCustomerName[i][j].contentEquals(customerName)) {
							System.out.println();
							System.out.printf("%s���� �����Ͻ� �¼��� %s�Դϴ�.\n\n", seatWithCustomerName[i][j],
									(i + 1) + "-" + (j + 1));
							return true;
						}
					}
				}
				System.out.println();
				System.out.println("�� �̸��� ��ġ�ϴ� �����ڸ��� �����ϴ�.");
				return false;
			}
		} while (true);
	}

	void canclation() {
		if (reservationInquiry()) {
			System.out.println("���Ÿ� ����Ͻðڽ��ϱ�?");
			outer2: do {
				System.out.println("��(1), �ƴϿ�(2)�� �ϳ��� �Է����ּ���.");

				int choice = 0;
				choice = Integer.parseInt(sc.nextLine());
				try {
					if (choice == 1 || choice == 2) {
						if (choice == 1) {

							outer3: for (int i = 0; i < seat.length; i++) {
								for (int j = 0; j < seat[i].length; j++) {
									if (seatWithCustomerName[i][j].contentEquals(customerName)) {
										seatWithCustomerName[i][j] = "";
										seat[i][j] = (i + 1) + "-" + (j + 1);
										break outer3;
									}
								}

							}

							System.out.printf("������ ��ҵǾ����ϴ�. �����մϴ�.\n\n");
							break;
						} else {

							break outer2;
						}

					} else
						throw new Exception("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");

				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
			} while (true);
		}
	}

	public static void main(String[] args) {

		Ex07_Cinema cinema = new Ex07_Cinema();

		while (true) {
			switch (cinema.displayMenu()) {
			case 1: {
				cinema.reservation();
				break;
			}
			case 2: {
				cinema.reservationInquiry();
				break;
			}
			case 3: {
				cinema.canclation();
				break;
			}

			}

		}

	}

}
