package java_study_ex;

import java.util.Scanner;

public class Ex3_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		String grade;
		System.out.println("=== �����Է� ===");
		if(score>=90) grade = "A";
		else if(score>=80) grade="B";
		else if(score>=70) grade="C";
		else if(score>=60) grade="D";
		else grade="E";
		
		switch (grade) {
		case "A":
			System.out.printf("������ %s�Դϴ�.\n�� ���Ͽ����ϴ�.",grade);
			break;
		case "B":
			System.out.printf("������ %s�Դϴ�.\n�� ���Ͽ����ϴ�.",grade);
			break;
		case "C":
			System.out.printf("������ %s�Դϴ�.\n���� �� ����ϼ���.",grade);
			break;
		case "D":
			System.out.printf("������ %s�Դϴ�.\n���� �� ����ϼ���.",grade);
			break;
		case "E":
			System.out.printf("������ %s�Դϴ�.\n������ �ٽ� �����ϼ���.",grade);	
		default:
			break;
		}
		
		
	}

}
