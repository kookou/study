import java.util.Scanner;

public class temp2 {

	public static void main(String[] args) {
  
		Scanner sc = new Scanner(System.in); 		

		
		int[] num = new int[3];
		int[] ran = new int[3];

		System.out.println("���� 3�ڸ��� �Է��ϼ���");
		int data= Integer.parseInt(sc.nextLine());
		num[0] = data/100;
		num[1] = data%100/10;
		num[2] = data%100%10;       //�� �ڸ����� ��������
		
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);

	    for(int i=0;i<ran.length;i++) {
	    	ran[i]=(int)(Math.random()*10);
	    	System.out.print(ran[i]);
	    }                            //���� ���� ���
	    System.out.println();      
		
		 if(ran[0]==num[0]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[1]==num[1]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[2]==num[2]) {
			 System.out.println("STRIKE");
		 }
		 else if(ran[0]==num[1]||ran[0]==num[2]) {
			 System.out.println("BALL");
		 }
		 else if(ran[1]==num[0]||ran[1]==num[2]) {
			 System.out.println("BALL");
		 }
		 else if(ran[2]==num[0]||ran[2]==num[1]) {
			 System.out.println("BALL");
		 }
		 else System.out.println("OUT");

		

		 }
}