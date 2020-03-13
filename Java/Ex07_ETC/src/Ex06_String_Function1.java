import java.util.StringTokenizer;

//String Ŭ���� (���ڿ�)
//�� ���� �Լ� ... ���ڿ� �ڸ��� ��ġ�� �̾Ƴ��� ...
//String : static �Լ� + �Ϲ� �Լ� ...
// 10�� �ϱ� ....
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str=""; //���ڿ��� �ʱ�ȭ ,null
		//int , double ó�� ����ϼ���
		String[] strarr = {"aaa","bbb","ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
    
		//�Լ�
		String ss ="hello";
		String concatstr = ss.concat(" world");
		System.out.println(concatstr);
		
		boolean bo = ss.contains("hel");
		System.out.println(bo);
		
		bo = ss.contains("helo");
		System.out.println(bo);
		
		bo = ss.contentEquals("hello");
		System.out.println("bo :" + bo);
		
		String ss2 = "a b c d"; //heap [a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("h")); //index �迭���� ÷��
		System.out.println(filename.indexOf("java")); //6
		
		System.out.println(filename.indexOf("����")); //-1 ���� ....
		//-1 return ���ϴ� ���� �迭�� �����
		//�Ź���� �˻�  indexof ����  0���� ū���� .... �ּ� 1�� �ִ�
		if(filename.indexOf("world") != -1) {
			System.out.println("world ���ڿ��� ���ԵǾ� �ִ�");
		}
		System.out.println(filename.lastIndexOf("a"));
		
		//length() , indexOf() , substring() , replace() , Split() ..
		String result = "superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(2)); //perman
		System.out.println(result.substring(1,2)); //endIndex - 1  //u
		System.out.println(result.substring(0,0));  //(0,-1)  �ȳ��Ϳ�
		System.out.println(result.substring(0,1)); //s
		System.out.println(result.substring(1,1));
		System.out.println(result.substring(2,3));
		/*
		  Returns a string that is a substring of this string. 
		  The substring begins at the specified beginIndex 
		  and extends to the character at index endIndex - 1.
		  Thus the length of the substring is endIndex-beginIndex. 
		 */
		
		//Quiz
		String filename2 = "aaaaaaa.wp"; //hong.png 
		//���⼭ ���ϸ�� Ȯ���ڸ� �и��ؼ� ����غ�����
		//1  ���ϸ� , txt Ȯ����
		//hong ���ϸ� , png Ȯ����
		//���� �� ������ ���͸� ����ϼ���
		//indexOf , length , substring()
		//hint) ������ >> .
		
		int position = filename2.indexOf(".");
		String file = filename2.substring(0,position); //position - 1
		
		String extention = filename2.substring(position + 1, filename2.length());
		String extention2 = filename2.substring(++position);
		
		System.out.println(file);
		System.out.println(extention);
		System.out.println(extention2);
		
		//replace (ġȯ�Լ�)
		String s4 = "ABCDADDDDDA";
		String result4 = s4.replace("DDDDD", "������ �ݿ��� �Դϴ�");
		System.out.println("result4 : " + result4);
		
		result4 = s4.replace("A", "a");
		System.out.println("result4 : " + result4);
		
		//ETC ... 
		//String s4 = "ABCDADDDDDA";
		System.out.println(s4.charAt(0));
		System.out.println(s4.charAt(3));
		System.out.println(s4.endsWith("DDDA")); //true
		System.out.println(s4.endsWith("BDDA")); //false
		System.out.println(s4.equalsIgnoreCase("abcdADDDDDA")); //��ҹ��� �������� ��
		
		//Today Point (split)
		String s6 ="���۸�,��Ƽ,�����,������,������";
		String[] namearray = s6.split(",");
		for(String s : namearray) {
			System.out.println(s);
		}
		//����ǥ���� (java , javascript , Oracle , C#) �������� ��Ģ
		//Ư���� ���ڷ� ���� ����  > ������ ���Ĵ�� �Է� > ����
		//�ֹι�ȣ(���� 6�ڸ� - ���� ���� 7�ڸ�) >> ǥ��  >> ����� �Է��� �ֹι�ȣ�� �̸� ������ ���ϰ� ��ġ
		//��ȭ��ȣ , �ڵ��� , ������ȣ , �����ȣ , ������ �ּ� , �̸��� �ּ� 
		
		//010-{\d4}-0000 ����ǥ��
		//010-444-0000 >> (false)
		//010-1111-0000 >> (true)
		
		//���� ����  ...���Խ� ǥ���� �����ϱ�
		// . ����ǥ�� ���� >> \.   >> \. �ڹٿ��� ���� >> \\.  
		//\t , \n
		String filename3 = "bit.hwp";
		String[] filearray = filename3.split("\\.");
		System.out.println(filearray.length);
		for(String s : filearray) {
			System.out.println(s);
		}
		
		String s7 = "a/b,c.d-f"; //a  b  c  d  f ����
		StringTokenizer sto = new StringTokenizer(s7,"/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//�ͼ���
		String s8="ȫ           ��          ��";
		//>>"ȫ�浿"  ��������
		System.out.println(s8.replace(" ", ""));
		
		String s9="      ȫ�浿           ";
		System.out.println(">"+s9+"<");
		System.out.println(">"+s9.trim()+"<");
		
		String s10="    ȫ      ��      ��       ";
		//"ȫ�浿" ���
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2); //�����ؿ� ....
		
		//***** �������� �Լ��� �����ؼ� ���  (method chain ���)
		System.out.println(s10.trim().replace(" ", "").substring(2));
		
		 //Quiz-1
		   int sum=0;
		   String[] numarr = {"1","2","3","4","5"};
		   //����: �迭�� �ִ� ���ڰ����� ���� sum ������ ��Ƽ� ��� : ��� 15
		   for(String s : numarr) {
			   sum+=Integer.parseInt(s);
		   }
		   System.out.println("sum : " + sum);
		   
		   
		   
		   
		   
		   
		 //Quiz-2
		   String jumin="123456-1234567";
		   //�� �ֹι�ȣ�� ���� ���ϼ���_1
		   int sum2=0;
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue;
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("�ֹι�ȣ ��:" + sum2);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_2
		 //String jumin="123456-1234567";
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("�ֹι�ȣ ��2:" + sum3);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("�ֹι�ȣ ��4:" + sum4);
		
	}

}



















