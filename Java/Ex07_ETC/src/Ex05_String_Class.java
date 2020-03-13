/*
 * String Ŭ����
 * String str = new String("ȫ�浿"); <������ �̷��� ��� ��
 * ���Ǹ� ���� 8���� �⺻ Ÿ�԰� �����ϰ� ����� �� �ֵ��� ����
 * 
 * 1. String Ŭ����: ������ ���� ���� : char[] �迭���� > ȫ�浿 > [ȫ][��][��]
 * ex) String ename = "ABC" >> char[] >> [A][B][C]
 * class String extends Object{
 *  char[] ...
 *  void length(){}
 *  @override
 *  String toString(){
 *      ������...
 * }
*/

public class Ex05_String_Class {

    public static void main(String[] args) {
        String str = "ȫ�浿";
        System.out.println(str.length());  //�����Ͱ� char[]�� �����Ǳ� ������ .length ����
        System.out.println(str.toString()); //toString�� ���� �ּҰ� ������ �޼����ε�, �������̵��ؼ� ���� ����ϰ� ���� ��
        
        String str1 = "AAA";
        String str2 = "AAA";
        System.out.println("str1: "+System.identityHashCode(str1));
        System.out.println("str2: "+System.identityHashCode(str2));
        
        System.out.println(str1);  //str1.toString()�� ������. ���� �ּҰ� �ƴ� ������ ����
        System.out.println(str1 == str2); //true��. String�� ���޸𸮿� ���� ���ڿ��� ������ ���� ������ ����. ���� �ּҰ��� ���� ��
        //���ڿ� '=='�� �ּҰ��� ���ϴ� �� (xx���� == xx����)
        
        System.out.println(str1.equals(str2)); //������ ���� �ִ� ���� ���ϴ� �� ("AAA" == "AAA")
        
        //�׷���....
        
        String str3 = new String("BBB"); //new�� ����ϸ� ���ο� ��ü ����
        String str4 = new String("BBB");
        System.out.println("str3: "+System.identityHashCode(str3));
        System.out.println("str4: "+System.identityHashCode(str4));
        
        System.out.println(str3==str4); //false. ���� �ٸ� �� �޸� ������ ���� ��
        System.out.println(str3.equals(str4)); //true.
        
        //�ͼ���
        String s = "A";    // ���� char�迭 ��ü ����

        s+="B";             // ���� �迭�̹Ƿ� ���ο� ��ü ���� 
        s+="C";             // �� �ٽ� ���ο� ��ü ����
        System.out.println(s);
        
        s="A";              // ���� ���� �迭(char[] ��Ұ��� A�� ��)�� �����Ƿ� �װ� ����

        System.out.println(s);    // 
        
        
        
        
        

    }

}
