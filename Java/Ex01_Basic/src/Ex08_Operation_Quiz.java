import java.util.Scanner;

/*
������ ��Ģ ����� (+ , - , * , /)
�Է°� 3�� (�Է°��� nextLine() �޾Ƽ� �ʿ��ϴٸ� ���� ��ȯ)
���� : Integer.parseInt() ,  **equals() Ȱ��**
ȭ��
>�Է°�:����
>�Է°�(��ȣ): +
>�Է°�:���� 
>������ :200

-------------
>�Է°�:100
>�Է°�(��ȣ): -
>�Է°�:100
>������ :0


*/
public class Ex08_Operation_Quiz {

    public static void main(String[] args) {
        /*
       �� if���� ���ǰ��� boolean��, switch���� ������(byte, short, int)�� ������(char), ���ڿ�(String)
       �� long, boolean, float, double�� ��� �Ұ�
     
        Scanner sc = new Scanner(System.in);
        char ch =   sc.nextLine().charAt(0);
        switch (ch) {
        case '+':System.out.println("+ �Դϴ�");
            break;
        default: System.out.println("�ٸ� ���� �Դϴ�");
            break;
        }
        
        
        Scanner sc = new Scanner(System.in);
        String ch =   sc.nextLine();
        switch (ch) {
        case "+":System.out.println("+ �Դϴ�");
            break;
        default: System.out.println("�ٸ� ���� �Դϴ�");
            break;
        }
        */
        
        
        
        String opr="";//���ڿ� �ʱ�ȭ
        int input_1=0;
        int input_2=0;
        int result=0;
        Scanner sc = new Scanner(System.in);
        
        
          System.out.print("�����Է�: ");
          input_1 = Integer.parseInt(sc.nextLine());
          
              
          System.out.print("�����ȣ(+,-,*,/): ");
          opr = sc.nextLine();

          System.out.print("�����Է�: ");
          input_2 = Integer.parseInt(sc.nextLine());

          
          
          if(opr.equals("+")) {  //POINT ���ڿ��� �񱳴� == �ƴϰ� (x) , equals (String)
              result = input_1 + input_2;
              
          }else if(opr.equals("-")) {
              result = input_1 - input_2;
              
          }else if(opr.equals("*")) {
              result = input_1 * input_2;
              
          }else if(opr.equals("/")) {
              result = input_1 / input_2;
          }else {
              System.out.println("�������� �ʴ� ������ �Դϴ�");
              //key point (���⼭�� main �Լ�)
              //return Ű���� :  [�Լ�����]�� ������  > main �Լ� Ż�� > ����
              return;
             
              //System.exit(0); //�������� ���α׷� ����
              
          }
          
          System.out.printf("[%d %s %d = %d]",input_1,opr,input_2,result);
    }

}



/*
������ ��Ģ �����(+, -, *, /)
�Է°� 3�� (�Է°� nextLine() �޾Ƽ� �ʿ��ϴٸ� ���� ��ȯ)
����: Integer.parseInt(), **equals() Ȱ��**  �����Ͱ��� �� �Ҹ��� ���� ��ȯ
ȭ��
>�Է°�: ����
>�Է°�(��ȣ): +
>�Է°�:����
>������: 200

------------------------
>�Է°�:100
>�Է°�:(��ȣ): -
>�Է°�:100
>������: 0
 
 
*/        
        //����
//	    Scanner sc = new Scanner(System.in);
//        System.out.println("�Է°�: ");
//        int num1 = Integer.parseInt(sc.nextLine());   //ù ��° ��
//        System.out.println("�Է°�(��ȣ): ");
//        String operator = sc.nextLine(); //������ �Է�
//        System.out.println("�Է°�: ");
//        int num2 = Integer.parseInt(sc.nextLine()); //�� ��° ��
//        int sum = 0;
//        if (operator.equals("+")) {  // �Ҹ��� ���� ��ȯ�Ǳ� ������ if���� ��
//            sum = num1 + num2;
//           
//        }else if(operator.equals("-")) {
//            sum = num1 - num2;
//            
//        }else if(operator.equals("*")) {
//            sum = num1 * num2;
//          
//        }else if(operator.equals("/")) {
//            sum = num1 / num2;
//        }else {
//            System.out.printf("������: %d�Դϴ� \n", sum);
        
        //switch Ȱ��
//      switch(operator) {
//      case("+"):
//          sum = num1 + num2;
//           break;
//      case("-"):
//          sum = num1 - num2;
//          break;
//      case("*"):
//          sum = num1 * num2;
//          break;
//      case("/"):
//          sum = num1 / num2;     
//          break;   
//      }
//         System.out.printf("������: %d�Դϴ� \n", sum);
        
        //���� ����
//        
//            System.out.println("�Է°�: ");
//            int num1 = Integer.parseInt(sc.nextLine());   //ù ��° ��
//            System.out.println("�Է°�(��ȣ): ");
//            String operator = sc.nextLine(); //������ �Է�
//            System.out.println("�Է°�: ");
//            int num2 = Integer.parseInt(sc.nextLine()); //�� ��° ��
//            int sum = 0;
//            if (operator.equals("+")) {  // �Ҹ��� ���� ��ȯ�Ǳ� ������ if���� ��
//                sum = num1 + num2;
//               
//            }else if(operator.equals("-")) {
//                sum = num1 - num2;
//                
//            }else if(operator.equals("*")) {
//                sum = num1 * num2;
//              
//            }else if(operator.equals("/")) {
//                sum = num1 / num2;
//            }else {
//                System.out.printf("�߸� �Է��ϼ̽��ϴ�.");
//            }
//                System.out.printf("������: %d�Դϴ� \n", sum);
//                
//	}
//}