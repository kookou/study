import java.util.Scanner;

/*��ȭ�� ���� ���α׷�
����
���
��ȸ
��� �⺻������ �־ ���弼��*/

public class Ex07_Cinema {
	
	private static String[][] seat;
	private static String[][] seatWithCustomerName;
	private static String customerName;
	
	public Scanner sc;
	

	public Ex07_Cinema() {

		seat = new String[3][5];
		seatWithCustomerName = new String[3][5];
		sc = new Scanner(System.in);

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
		int menu = 0;
		do {
			try {
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
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~3���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);
		
	}

	// �¼����� �����ֱ�
	void showSeat() {
		System.out.println();
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

		
	}

	void reservation() {
		int row = 0;
		int col = 0;
		String inputSeatNumber;
		outer: while (true) {

			System.out.println("���Ÿ� ���� ������ �Է����ּ���. ��)ȫ�浿");
			customerName = sc.nextLine();

			// �¼� �����ϱ�
			while (true) {
				
				outer4: do {
					try {
						showSeat();
						System.out.println("�¼��� �������ּ���. ��)1-1");
						System.out.println("�̹� ���ŵ� �¼��� \"����\"��� ǥ�õ˴ϴ�.");
						inputSeatNumber = sc.nextLine();
						String[] inputArray = inputSeatNumber.split("-");
						row = (Integer.parseInt(inputArray[0])) - 1;
						col = (Integer.parseInt(inputArray[1])) - 1;

						for (int i = 0; i < seat.length; i++) {
							for (int j = 0; j < seat[i].length; j++) {

								if (seat[i][j].contentEquals(inputSeatNumber)) {
									break outer4;
								} else if (seat[i][j].contentEquals("����")) {
									break outer4;
								}

							}
						}
						throw new Exception("<�Է� ������ ���� �ʰ�>");

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("�¼� �Է� ������ �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
						System.out.println();
					}
				} while (true);

				if (!seat[row][col].contentEquals("����")) {
					System.out.println("���� �����մϴ�. �����Ͻðڽ��ϱ�?");

					outer2: do {
						System.out.println("��(1), �ƴϿ�(2), �ʱ�ȭ��(0)�� �ϳ��� �Է����ּ���.");
						
						try {
							int choice = 0;
							choice = Integer.parseInt(sc.nextLine());
							if (choice == 1 || choice == 2 || choice ==0) {
								if (choice == 1) {
									seat[row][col] = "����";
									seatWithCustomerName[row][col] = customerName;
									System.out.println();
									System.out.printf("������ �Ϸ�Ǿ����ϴ�. %s������ �����Ͻ� �¼��� %s�Դϴ�. �����մϴ�.\n\n", customerName,
											inputSeatNumber);
									break outer;
								} else if(choice==0) {
									break outer;
								}
								else {

									break outer2;
								}

							} else
								throw new Exception("<�Է� ���� �ʰ�>");

						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");

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
						throw new Exception("<�Է� ���� �ʰ�>");
					

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
					System.out.println();

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
