import java.util.Scanner;
//�ֹι�ȣ : �޹�ȣ ù�ڸ� : 1,3 ���� , 2,4 ���� ��� ��� ...
//main �Լ� Scanner ��� �ֹι�ȣ �Է¹ް�
//��:6�ڸ� ��:7�ڸ�
//�Է°� : 123456-1234567 
//1. �ڸ��� üũ (���)�Լ� (14 ok)
//2. �޹�ȣ ù��° �ڸ��� 1~4������ ���� ��� ����Լ�
//3. �޹�ȣ ù��° �ڸ����� ������ 1,3 ���� , 2,4 ���� ��� ����Լ�
//3���� �Լ� static 

public class String_groupwork {

    static String jumin = "";
    
    static Scanner sc = new Scanner(System.in);
    
    static void checkDigits() {
      
            do {
                System.out.println("�ֹι�ȣ�� �Է��ϼ���. �Է� ��:123456-1234567");
                jumin = sc.nextLine();
                try {
                    if (jumin.length() == 14) {
                        break;
                    }else
                        throw new Exception("�ڸ����� �߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
                        

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                  
                }
            } while (true);
            

        }
    static void checkGender() {
        do {
            
            try {
                if (1<=(jumin.charAt(7)-'0')&&(jumin.charAt(7)-'0')<=4) {
                    break;
                }else
                    throw new Exception("������ �߸� �Է��ϼ̽��ϴ�. ������ 1~4 �߿��� ������ �ּ���. ");
                    

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("�ֹι�ȣ�� �Է��ϼ���. �Է� ��:123456-1234567");
                jumin = sc.nextLine();
              
            }
        } while (true);

    }
    
    static void gender() {
        if(jumin.charAt(7)=='1'||jumin.charAt(7)=='3') {
            System.out.println("����� �����Դϴ�.");
        }else {
            System.out.println("����� �����Դϴ�.");
        }
          
    }
        



    public static void main(String[] args) {

    
        checkDigits();
        checkGender();
        System.out.println("�ֹι�ȣ: "+jumin);
        gender();
        


    }

}
