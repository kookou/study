package java_study_ex;

import java.util.Scanner;

public class Ex4_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("=== ��� �ִ����� ===");
		System.out.println("ù ��° ���� �Է� : ");
		int a = sc.nextInt();
		System.out.println("�� ��° ���� �Է� : ");
		int b = sc.nextInt();
		System.out.printf("�Է��� ���� : %d %d\n",a,b);
		System.out.print(a+"�� ����� : ");
		for(int i=1;i<=a;i++) {
			if(a%i==0) {
				System.out.print(i+" ");
			}
		}System.out.println();
		System.out.print(b+"�� ����� : ");
		for(int i=1;i<=b;i++) {
			if(b%i==0) {
				System.out.print(i+" ");
			}
		}System.out.println();
		
		int c=(a>b)?a:b;
		
		for(int i=c;i>0;i--) {
			if(i==1) {
				System.out.println("�� ���� ���μ��Դϴ�.");
				break;
			}
			else if(a%i==0&&b%i==0) {
				System.out.println("�� ���� �ִ����� : "+i);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
