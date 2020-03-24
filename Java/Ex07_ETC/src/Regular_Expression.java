import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
 
public class Regular_Expression {
//    static String data = "";
//    static String regExp;
    static Scanner sc = new Scanner(System.in); //�Է�
 
    public static void main(String[] args) throws Exception {
 
        while (true) {
            System.out.println("1.�̸� 2.��й�ȣ 3.�ڵ�����ȣ 4.�̸��� 5.�ֹι�ȣ 6.������");
            int a = sc.nextInt();
            sc.nextLine();
 
            switch (a) {
            
            case 1:
                name();
                break;
            case 2:
                pwd();
                break;
            case 3:
                phone();
                break;
            case 4:
                email();
                break;
            case 5:
                jumin();
                break;
            case 6:
                System.out.println("�����մϴ�");
                System.exit(0);
                break;
                
            default:System.out.println("�߸��Է��ϼ̽��ϴ�.");
            break;
 
            }
        }
    }
 
    public static void name() {
        
        System.out.println("1.�̸� �Է�:");
        // ^ ������ ó���̳� ���ڿ��� ó���� ǥ��
        //[] �ȿ� �ִ� ���� �� �ϳ�, ������ '-'�� ����
        //+�տ��� �� ���� �̻��� �ܾ �ݵ�� �;� �Ѵ�.
        //$������ ��
        String regExpaa = "^[��-����-�R]+$";
        
        String data = sc.nextLine();
        
       //����ǥ������ ���Ͽ� ��ġ�ϴ��� ���θ� �׽�Ʈ�Ѵ�.
       //java.util.regex ��Ű���� �ִ� Match Ŭ������ Pattern Ŭ������ ����Ͽ� 
       //���ڿ��� ����ǥ�������� ������ �� �ִ�.
       boolean b = data.matches(regExpaa); // true ,false
 
        if (b == true) {
            System.out.println("�ùٸ� �����Դϴ� , ¦¦¦!!");
        } else {
            System.out.println("�̸����� �ѱ۸� ���ü� �־��.");
        }
 
    }
 
    public static void pwd() {
        System.out.println("2.��й�ȣ �Է�:");
        //[] ���ȣ ���� ���� ��ġ�� �ǹ�
        //[A-Za-z �ҹ���a���� �빮��Z ������ 0-9 ����
        //^ :���ڿ��� ������ ��Ÿ��
        //{} : ���๮�ڰ� ��Ÿ���� Ƚ�� �Ǵ� ������ ��Ÿ����
        //!@#$%^~*+=- Ư������ ����
        //{6,20} �ݺ������� �ǹ�
        //?=.* ��� �ϳ�
        String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
        String data = sc.nextLine();
 
        boolean b1 = data.matches(regExp); // true ,false ��ȿ�� �˻�
 
        if (b1 == true) {
            System.out.println("�ùٸ� �����Դϴ� , ¦¦¦!!");
        } else {
            System.out.println("�߸� �Է��ϼ̽��ϴ�. 8~20�� ���̿� ��� �ϳ��� ����빮��,Ư�����ڰ� ���ԵǾ�� �մϴ�.");
        }
    }
 
    public static void phone() {
        System.out.println("3.�޴��ȣ �Է�:");
        // (01[1679]{1}) : 01 �ڿ� 1,6,7,9 �� �ϳ��� �;���
        // [-.\\s]? : -,.,������ �������� �������� ����
        // (\\d{3,4}) : 3~4�ڸ� ����
        // (\\d{4}) : 4�ڸ� ����
        // \d ����(����)
        //{} ��ȣ ���� ���ڸ�ŭ ���� ���ڿ��� �ݺ�
 
        String regExp = "(01[1679]{1})[-.\\s]?(\\d{3,4})[-.\\s]?(\\d{4})";
        String data = sc.nextLine();
 
        boolean b2 = data.matches(regExp); // true ,false ��ȿ�� �˻�
 
        if (b2 == true) {
            System.out.println("�ùٸ� �����Դϴ�, ¦¦¦!!!");
        } else {
            System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���!! ex) 010-1234-1234, 011.123.1234, 01612341234, 019 1234 1234");
        }
 
    }
 
    public static void email() {
        //^ :���ڿ��� ����
        //([a-zA-Z0-9_-\\.]{5,}) : ��� 5���� �̻��� ���� ��/�ҹ���, ����, _ ,- 
        //@[a-zA-Z0-9] : @�ڿ� ���� ��/�ҹ���, ���ڸ�
        //\\.[a-zA-Z] : . �ڿ� ���� ��/�ҹ��ڸ�
        //$ :���ڿ��� ��
        System.out.println("4.E-Mail �Է�:");
 
        String regExp = "^([a-zA-Z0-9_-]{5,})@[a-zA-Z0-9]+\\.[a-zA-Z]+$";
        String data = sc.nextLine();
 
        boolean b3 = data.matches(regExp); // true ,false ��ȿ�� �˻�
 
        if (b3 == true) {
            System.out.println("�ùٸ� �����Դϴ� , ¦¦¦!!");
        } else {
            System.out.println("E-mail ������ ex)abcde@aaa.bbb (���̵� �κ� �ּ� 5�� �̻�)�Դϴ�. �ٽ� �Է� �ϼ��� ");
        }
    }
    public static void jumin(){
          System.out.println("5.�ֹι�ȣ �Է�:");
          //\d ����(����) (0~9)
          //{} ���ڿ� �ݺ� ������ �ǹ� - �ڸ���
          //[1-4] 1~4���� ���� ������ �ǹ�
          String regExp = "^\\d{6}-[1-4]\\d{6}";
          String data = sc.nextLine();
          
          boolean b4 = data.matches(regExp); // true ,false ��ȿ�� �˻�
          
          if(b4 == true){
             System.out.println("�ùٸ� �����Դϴ� , ¦¦¦!!");
          }
          else {
             System.out.println("�ֹι�ȣ ������ xxxxxx-xxxxxxx�̰�, ���ڸ� ù��° ��ȣ�� 1~4�� �Է� ���� �մϴ�.");
          }
       }
 
    
}