package java_study_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Temp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //����
		String s = bf.readLine(); //String
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer���ڰ��� �Է� ���ڿ� ����
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// ����

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken()); //ù��° ȣ��
			int b = Integer.parseInt(st.nextToken()); //�ι�° ȣ��
			bw.write((a+b) + "\n");// ���
		}
		

//		for (int i = 0; i < n; i += 2) {
//
//			System.out.println(a + b);
//		}


		bw.flush();// �����ִ� �����͸� ��� ��½�Ŵ
		bw.close();// ��Ʈ���� ����

	}
}