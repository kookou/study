import java.util.Scanner;

public class stars {
    
    public static void main(String[] args) {
     //���� ����� 1   
//     Scanner sc = new Scanner(System.in);    
//     int n = Integer.parseInt(sc.nextLine());
//     
//     for(int i=1;i<=n;i++) {
//         for(int j=1;j<=i;j++) {
//             System.out.print("*");
//         }System.out.println();
//     }
     //����� 2
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=(n-i);j++) {
//                System.out.print(" ");
//            }for(int j=1;j<=i;j++) {
//                System.out.print("*");
//            }System.out.println(); 
//        }
     //����� 3��
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     for(int i=0;i<n;i++) {
//         for(int j=1;j<=(n-i);j++) {   //i��ŭ ������ �پ��
//             System.out.print("*");
//         }System.out.println();
//     }
      //����� 4��
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++) {
//            for(int j=1;j<=i;j++) {  //������ i����ŭ �߰�
//                System.out.print(" ");
//            }for(int j=1;j<=(n-i);j++) {
//                System.out.print("*"); //���� n-i����ŭ �߰�
//            }System.out.println();   //�ٹٲ�
//        }
    //����� 5��
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) { //������ n-i����ŭ �߰�
                System.out.print(" ");
            }for(int j=1;j<=2*i-1;j++) { //���� 2i-1����ŭ �߰�
                System.out.print("*");
            }System.out.println(); //�ٹٲ�
        }
    //����� 6��
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int i=1;i<=n;i++) {  
          for(int j=1;j<i;j++) {  //���� i-1�� �Է�
              System.out.print(" ");
          }for(int j=1;j<=2*(n-i)+1;j++) { //�� 2*(n-i)+1�� �Է�
               System.out.print("*");
          }System.out.println(); //�ٹٲ�
      }
     //����� 7��
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt(); 
     for(int i=1;i<=2*n-1;i++) {    //��ü �� �� 
         if(i<=n) {                 //��ܺ�
           for(int j=1;j<=n-i;j++) {   //���� 
               System.out.print(" ");
           }for(int j=1;j<=2*i-1;j++) {
               System.out.print("*");  // ��
           }System.out.println();     
         }else {                     //�ϴܺ�
        	 for(int j=1;j<=i-n;j++) { //����
        		 System.out.print(" ");
        	 }
             for(int j=1;j<=2*(2*n-i)-1;j++) { //��
            	 System.out.print("*");
             }System.out.println();
           }
     }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
