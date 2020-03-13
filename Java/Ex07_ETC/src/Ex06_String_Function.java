import java.util.StringTokenizer;

/* String Ŭ����(���ڿ�)
 * ������ �Լ�... ���ڿ� �ڸ��� ��ġ�� �̾Ƴ���
 * Stirng: static �Լ� + �Ϲ� �Լ�
 * 10�� �ϱ�
*/






public class Ex06_String_Function {

    public static void main(String[] args) {
        //�ʱ�ȭ
        String str=""; //�� ���ڿ��� �ʱ�ȭ, null�� �ʱ�ȭ�ϸ� �޸𸮰��� �Ȱ��´�.
        
        //�迭�� �翬�� ����
        String[] strarr = {"aaa","bbb","ccc"};
        for(String s : strarr) {
            System.out.println(s);
        }
        
        //�Լ�
        String ss = "hello";       
        String concatstr =ss.concat("world");  //concat: ���ڿ� ����
        System.out.println(concatstr);
 
        
        boolean bo = ss.contains("hel"); //contains: ���Ե� ����sequnce�ִ��� ����
        System.out.println(bo);
        
 
        bo = concatstr.contentEquals("hel");    
        System.out.println(bo);
        
                
        
        
        String ss2 = "a b c d"; //heap [a][ ][b][ ][c][ ][d]
        System.out.println(ss2.length());  //7. ���鵵 ���̿� ����
        
        String filename = "hello java world";
        System.out.println(filename.indexOf("h")); //index �迭���� ÷��
        System.out.println(filename.indexOf("java")); //6. ���ڿ� ������ �˷���
        
        System.out.println(filename.indexOf("����")); //-1. �ش� ���ڰ� ���ڿ��� ���Ե��� �ʴ´ٴ� �ǹ�
        //�Ź���� �˻� indexof ���� 0���� ū ���� ���´� > �ּ� 1���� �ִ�
        if(filename.indexOf("world") !=-1){
            System.out.println("world ���ڿ��� ���ԵǾ� �ִ�");
        }
        
        System.out.println(filename.lastIndexOf("a")); //���� ���߿� ��ġ�� a�� index�� ����
        
        //���� ���� String �޼����
        //length, indexOf, substring, replace, split
        String result = "superman";
        System.out.println(result.substring(0)); //superman
        System.out.println(result.substring(2)); //perman. �ش� index���� �����ϴ� ���ڿ� ����
        System.out.println(result.substring(1,2));//u. index�� 1<=���ڿ�<2�� ����
        System.out.println(result.substring(0,0)); // �ƹ��͵� �ȳ���. �ֳĸ� 0<=���ڿ�<0 �� �ǹ����� ����
        
        //Quiz
        String filename2 = "1.txt";  //hong.png ���� �۵��ؾ� ��
        //���⼭ ���ϸ�� Ȯ���ڸ� �и��ؼ� ����غ�����
        System.out.println("���ϸ�: "+ filename2.substring(0,filename2.indexOf(".")));
        System.out.println("Ȯ���ڸ�: "+filename2.substring(filename2.indexOf(".")+1));

        //replace (ġȯ �Լ�)
        String s4= "ABCDADDDDDA";
        
        String result4 = s4.replace("DDDD", "������ �ݿ����Դϴ�.");
        System.out.println("reslut4 : "+result4);
        result4 = s4.replace("A", "��");    // �� �Ű����� ���ڸ� �� �Ű����� ���ڷ� ġȯ
        System.out.println(result4);
        
        //charAt
        System.out.println(s4.charAt(0)); //A. 
        
        //endsWith
        System.out.println(s4.endsWith("DDA")); //true. 
        
        //equalsIgnoreCase
        System.out.println(s4.equalsIgnoreCase("abcdaddddDA")); //true.
        
        //hashCode
        System.out.println(s4.hashCode()); //�ּҰ� ���
        
        //Today Point: split
        String s6 = "���۸�,��Ƽ,�����,������,������";
        String[] namearray = s6.split(",");
        for(String s: namearray) {
            System.out.println(s);
        }
        
        //����ǥ���� (java, javascript, Oracle, C#) �������� ��Ģ
        //Ư���� ���ڷ� ���� ���� > ������ ���Ĵ�� �Է� �������� ����
        //�ֹι�ȣ(���� 6�ڸ� - ���� ���� 7�ڸ�) >> ǥ�� >> ����ڰ� �Է��� �ֹι�ȣ�� �̸� ������ ���ϰ� ��ġ
        //��ȭ��ȣ, ������ȣ, �����ȣ, ������ �ּ�, �̸��� �ּ�
        
        //010-{\d4}-0000 ����ǥ��
        //010-444-0000 >> (false)
        //010-1111-0000 >> (true)
        
        //���� ���� .. ���� ǥ���� �����ϱ�
        // . ����ǥ�� ���� >> \.  >> \. �ڹٿ��� �����Ϸ���  \t, \nó�� \\.���� �ؾ���
        
        
        String filename3 = "bit.hwp";  
//        String[] namearry = filename3.split("."); //split�� ����ǥ������ ���ڷ� ��� �Ѵ�
        String[] namearry = filename3.split("\\."); //�̷��� �־���� �۵�
        for(String s5: namearry) {
            System.out.println(s5);
          
        }
        
        
        //StringTokenizer (����)
        String s7 = "a/b,c.d-f"; //a b c d f ����
        StringTokenizer sto = new StringTokenizer(s7, "/,.-"); 
        while(sto.hasMoreTokens()) {                 //StringTokenizer�� while�����θ� ��� ����
            System.out.println(sto.nextToken());
        }
        
        
        //�ͼ���
        String s8="ȫ                ��                  ��";
        // >"ȫ�浿"���� ��µǰ� �غ���
        
//        StringTokenizer sto2 = new StringTokenizer(s8, " "); //�䷱ ������ �������� ����
//        while(sto2.hasMoreTokens()) {                 
//            System.out.print(sto2.nextToken());
//        }System.out.println();
        
        //�� ���� ���
        System.out.println(s8.replace(" ", "")); //�ξ� ���ϴ�
        
        
        //trim
        String s9= "        ȫ�浿          ";
        System.out.println(">"+s9+"<");
        System.out.println(">"+s9.trim()+"<");
        
        
        
        String s10="       ȫ     ��    ��      ";
        //ȫ�浿 ���
        String re = s10.trim();
        String re2 = re.replace(" ", "");
        System.out.println(re2);  //������ ���
        
        //****** ���� ���� �Լ��� �����ؼ� ���(method chain ���)
        System.out.println(s10.trim().replace(" ", ""));
       
        
        //Quiz-1
        int sum=0;
        String[] numarr = {"1","2","3","4","5"};
        //����: �迭�� �ִ� ���ڰ����� ���� sum������ ��Ƽ� ���: ��� 15
        
        for( String i : numarr) {
            sum+=Integer.parseInt(i);
        }
        System.out.println(sum);
        
        //Quiz-2
        String jumin = "123456-1234567";
        //�� �ֹι�ȣ�� ���� ���ϼ���
        jumin = jumin.replace("-", "");
        System.out.println(jumin);
        
        int sum2=0;
        for(int i=0; i<jumin.length();i++) {
            sum2+=(jumin.charAt(i)-'0');
        }
        System.out.println(sum2);
        
        
        //������ �ش�
        String jumin2="123456-1234567";
        //�� �ֹι�ȣ�� ���� ���ϼ���_1
        int sum3=0;
        for(int i = 0 ; i < jumin2.length() ; i++) {
            String numstr =jumin2.substring(i, i+1);    //���ڿ��� �� ��� ���ڿ��� �ɰ���
            if(numstr.equals("-")) continue;  // - �� �� ��� ����
            sum3+= Integer.parseInt(numstr);  // ���ڿ��� int�� ����ȯ
        } 
        System.out.println("�ֹι�ȣ ��:" + sum2);
        
      //�� �ֹι�ȣ�� ���� ���ϼ���_2
        String jumin3="123456-1234567";
        String[] numarr2 = jumin3.replace("-","").split("");  //replace�� -�� �����ϰ� split�� �̿��� �迭ȭ�Ѵ�.
        int sum4=0;
        for(String i : numarr2) {
            sum4+= Integer.parseInt(i); 
        }
        System.out.println("�ֹι�ȣ ��2:" + sum3);
        
      //�� �ֹι�ȣ�� ���� ���ϼ���_3
        String jumin4 = jumin3.replace("-", "");
        int sum5=0;
        for(int i = 0 ; i < jumin4.length() ;i++) {
            sum5+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));  //String.valueOf() ��Ʈ�� ������ ��ȯ
        }
        System.out.println("�ֹι�ȣ ��4:" + sum5);
        
        
  
        
        
        
        
        
        
        
    }

}
