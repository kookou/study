package java_study_ex;

import java.util.Scanner;

public class Ex4_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� �Ƕ�̵��� �� ���� �Է��Ͻÿ� : ");
		int n = sc.nextInt();
		for(int i=1; i<=n;i++) {
			for(int j=n-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}
