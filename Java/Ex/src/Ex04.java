import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		//4-2
//		int sum=0;
//		for(int i=1;i<=20;i++) {
//			if(i%2!=0&&i%3!=0) {
//				sum += i;
//			}
//		}System.out.println(sum);
				
	    //4-3
//		int sum1=0, sum2=0;
//		
//		for(int i=1;i<=10;i++) {
//			sum1 +=i;
//			sum2 +=sum1;
//		}System.out.println(sum2);
		
		//4-4
//		int sum=0;
//		int i=0;
//		while(sum<100) {
//			i++;               //sum ������ i���� �����ؾ� ��
//			if(i%2!=0) {
//				sum+=i;
//			}else {
//				sum+=-i;
//			}
//		}System.out.println(i);
		
		//4-5  for���� while������
//		for(int i=0;i<=10;i++) {
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}System.out.println();
//		}
		
		
//		int i=0;
//		while(i<=10) {
//			int j=0;           //j �ʱ�ȭ ������ ����
//			while(j<=i) {				
//				System.out.print("*");
//				j++;
//			}i++;
//			System.out.println();
//		}
		
		//4-6  �� �ֻ��� ���� ���� 6�� ����� �� ���
//		for(int i=1;i<=6;i++) {
//			for(int j=1;j<=6;j++) {
//				if(i+j==6) {
//					System.out.printf("(%d,%d)\t",i,j);
//				}
//			}
//		}
		
		//4-7
//		String str = "12345";
//		int sum = 0;
//		
//		for(int i=0; i<str.length();i++) {
//			sum += str.charAt(i)-'0';
//		}
//		System.out.println("sum= "+sum);
		
		//4-8
//		int value =(int)(Math.random()*6)+1;
//				
//		System.out.println("value:"+value);
		
		//4-9
//		int num = 12345;
//		int sum = 0;
//		
//		while(true) {
//			sum += num%10;
//			num /=10;			
//			if(num==0) break;
//		}
//		
//		System.out.println("sum="+sum);
		
//		4-10 ���� ������ ����
		
		//1~100������ ������ ���� �� answer�� �����Ѵ�.
		int answer = (int)(Math.random()*100)+1;
		int input = 0;   //������Է��� ������ ����
		int count = 0;   //�õ�Ƚ���� ���� ���� ����
		
		//ȭ�����κ��� ����� �Է��� �ޱ� ���ؼ� ScannerŬ���� ���
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.println("1�� 100������ ���� �Է��ϼ��� :");
			input = s.nextInt();   //�Է¹��� ���� ���� input�� �����Ѵ�.
			
			if(input<answer) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			}else if(input>answer) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			}else {
				System.out.println("�������ϴ�.");
				System.out.printf("�õ�Ƚ���� %d���Դϴ�.%n",count);
				break;
			}
		}while(true);   //���ѹݺ���
		
		
		
		
		


	}
}