package java_study_ex;

import java.util.Scanner;

public class Ex4_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== ������ ��� ���α׷� ===");
		System.out.println("���� �ܼ��� �Է��Ͻÿ�");
		int a = sc.nextInt();
		System.out.println("�� �ܼ��� �Է��Ͻÿ�");
		int b = sc.nextInt();
		int n;
		for(n = a; n<=b;n++) {
			System.out.printf("*** %d�� ***\n",n);
			for(int i=1;i<10;i++) {
				System.out.printf("%d * %d = %d\n",n,i,(n*i));
				
			}System.out.println("");
		}
		
	}

}
