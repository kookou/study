import java.util.Scanner;

/*��ȭ�� ���� ���α׷�
����
���
��ȸ
��� �⺻������ �־ ���弼��*/

public class Ex07_Cinema {

    static String[][] seat;
    static String[][] customerSeat;
    static Scanner sc = new Scanner(System.in);

    public Ex07_Cinema() {

        seat = new String[3][5];
        customerSeat = new String[3][5];

        // �¼� ����
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = (i + 1) + "-" + (j + 1);
            }
        }
        
        // �¼� ���� ����
        for (int i = 0; i < customerSeat.length; i++) {
            for (int j = 0; j < customerSeat[i].length; j++) {
                customerSeat[i][j] = "";
            }
        }

    }

    // �ʱ� �޴�

    int displayMenu() {
        System.out.println("****************");
        System.out.println("****��ȭ�� �޴�*****");
        System.out.println("1. ����");
        System.out.println();
        System.out.println("2. ������ȸ");
        System.out.println();
        System.out.println("3. �������");
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

    void reservation() {

   

        // �¼����� �����ֱ�
       outer: while (true) {
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    System.out.printf("[%s]",
                            seat[i][j].equals((i + 1) + "-" + (j + 1)) ? (i + 1) + "-" + (j + 1) : "����");
                }
                System.out.println();
            }

            // �¼� �����ϱ�
            String customerName = "";
            String customerSeatInput = "";
            int row, col;
            row = 0;
            col = 0;
            int i = 0;
            int j = 0;
            System.out.println("�̸��� �Է����ּ���. ��)ȫ�浿");
            customerName = sc.nextLine();

            while (true) {
                System.out.println("�¼��� �������ּ���. ��)1-1");

                customerSeatInput = sc.nextLine();
                row = (customerSeatInput.charAt(0) - '0') - 1;
                col = (customerSeatInput.charAt(2) - '0') - 1;

                if (seat[row][col].equals(customerSeatInput.charAt(0) + "-" + customerSeatInput.charAt(2))) {
                    System.out.println("���� �����մϴ�. �����Ͻðڽ��ϱ�?");

                    outer2: do {
                        System.out.println("��(1), �ƴϿ�(2)�� �Է����ּ���.");
                        int choice = 0;
                        choice = Integer.parseInt(sc.nextLine());
                        try {
                            if (choice == 1 || choice == 2) {
                                if (choice == 1) {
                                    seat[row][col] = customerSeatInput;
                                    customerSeat[row][col] = customerName;

                                    System.out.printf(
                                            "������ �Ϸ�Ǿ����ϴ�. %s������ �����Ͻ� �¼��� %s�Դϴ�. �����մϴ�.\n",customerName,seat[i][j]);
                                    break outer;
                                } else {

                                    break outer2;
                                }

                            } else
                                throw new Exception("�ڸ����� �߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }
                    } while (true);

                } else {
                    System.out.println("�̹� ���� �Ǿ����ϴ�");
                }
            }
        }

    }

    void canclation() {
        String str = "";
        System.out.println("�����Ͻ� �� ����� �̸��� �Է����ּ���. ��)ȫ�浿");
        str = sc.nextLine();

     outer3:   for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (customerSeat[i][j].contentEquals(str)) {
                    System.out.printf("%s���� �����Ͻ� �¼��� %s�Դϴ�.", customerSeat[i][j], seat[i][j]);
                    break outer3;
                }else {
                    System.out.println("�� �̸��� ��ġ�ϴ� �¼��� �����ϴ�.");
                    break;
                }
            }

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
                cinema.canclation();
                break;
            }
            case 3: {
                cinema.canclation();
                break;
            }
            case 4: {
                System.out.println("���α׷� ����");
                System.exit(0);
            }
            }

            // �¼��ʱ�ȭ
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    seat[i][j] = (i + 1) + "-" + (j + 1);
                }
            }
        }

    }

}
