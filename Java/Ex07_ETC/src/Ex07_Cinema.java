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
    static String customerName;
    static String customerSeatInput;
    static String customerNameInput = "";
    static int row=0;
    static int col = 0;

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
    // �¼����� �����ֱ�
    void showSeat() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.printf("[%s]",
                        customerSeat[i][j].equals("") ? (i + 1) + "-" + (j + 1) : "����");
            }
            System.out.println();
        }
    }
    
    void nameInput() {
              
        System.out.println("�̸��� �Է����ּ���. ��)ȫ�浿");
        customerName = sc.nextLine();        
    }
        
    

    void reservation() {

   

        
       outer: while (true) {
            
            showSeat();
            nameInput();
            
            // �¼� �����ϱ�
            
          
            int i = 0;
            int j = 0;

            while (true) {
                System.out.println("�¼��� �������ּ���. ��)1-1");
                customerSeatInput = sc.nextLine();
                String[] customerSeatInputArray = customerSeatInput.split("-");
                row = (Integer.parseInt(customerSeatInputArray[0])) - 1;
                col = (Integer.parseInt(customerSeatInputArray[1])) - 1;
   
                //���� ���ľ� ��
//                if (!seat[row][col].equals("����")) {
                    System.out.println("���� �����մϴ�. �����Ͻðڽ��ϱ�?");

                    outer2: do {
                        System.out.println("��(1), �ƴϿ�(2)�� �ϳ��� �Է����ּ���.");
                        int choice = 0;
                        choice = Integer.parseInt(sc.nextLine());
                        try {
                            if (choice == 1 || choice == 2) {
                                if (choice == 1) {
                                    seat[row][col] = customerSeatInput;
                                    customerSeat[row][col] = customerName;

                                    System.out.printf(
                                            "������ �Ϸ�Ǿ����ϴ�. %s������ �����Ͻ� �¼��� %s�Դϴ�. �����մϴ�.\n\n",customerName,seat[i][j]);
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
                    System.out.println("�̹� ���� �Ǿ����ϴ�");
                }
            }
       }

    }
    
    void reservationInquiry() {        
        System.out.println("�����Ͻ� �� ����� �̸��� �Է����ּ���. ��)ȫ�浿");
        customerNameInput = sc.nextLine();

     outer3:   for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (customerSeat[i][j].contentEquals(customerNameInput)) {
                    System.out.printf("%s���� �����Ͻ� �¼��� %s�Դϴ�.\n\n", customerSeat[i][j], seat[i][j]);             
                    break outer3;
                }else {
                    System.out.println("�� �̸��� ��ġ�ϴ� �����ڸ��� �����ϴ�.");
                    break;
                }
            }

        }
        
    }

    void canclation() {
        reservationInquiry();
        System.out.println("������ ����Ͻðڽ��ϱ�? ��(1), �ƴϿ�(2) �� �ϳ��� �Է����ּ���.");
        outer2: do {
            System.out.println("��(1), �ƴϿ�(2)�� �ϳ��� �Է����ּ���.");
            
            
            int choice = 0;
            choice = Integer.parseInt(sc.nextLine());
            try {
                if (choice == 1 || choice == 2) {
                    if (choice == 1) {
                        //���� �Է��� �̸��� ��ġ�ϴ� 
                        outer3:   for (int i = 0; i < seat.length; i++) {
                            for (int j = 0; j < seat[i].length; j++) {
                                if (customerSeat[i][j].contentEquals(customerNameInput)) {
                                    seat[i][j] = (i + 1) + "-" + (j + 1);                                       
                                    break outer3;
                                }else {                                  
                                    break;
                                }
                            }

                        }

                        System.out.printf(
                                "������ ��ҵǾ����ϴ�. �����մϴ�.\n\n");
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
