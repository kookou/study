import java.util.ArrayList;

/*
 * 8���� �⺻ Ÿ��(��Ÿ��) : JAVA API ����
 * 
 * 8���� �⺻ Ÿ�Կ� ���ؼ� ��ü ���·� ��밡�� �ϵ��� ���� �� (wrapper class)
 * 
 * �⺻ Ÿ���� ���δ� ��ü ���·� �ٷ��� �� ���� ����
 * 1. �Ű������� ��ü�� �䱸�� ��
 * 2. �⺻�� ���� �ƴ� ��ü�� ����Ǿ�� �� ��
 * 3. ��ü �� �� �񱳰� �ʿ��� ��
 * 4. Ÿ�� ��ȯ�� ó���ϱ� ����
*/

public class Ex08_Wrapper_Class {

    public static void main(String[] args) {
        int i = 100;
        Integer n = new Integer(500); //()�ȿ� int�� ������ ��
        System.out.println("n : "+ n);  //��� �ּҰ��� ��µǾ�� ������, toString�� �������̵��ż� ���� ���
        System.out.println(n.MAX_VALUE);
        System.out.println(n.MIN_VALUE);
        
        //POINT Ȱ�� ...
        //parameter Ȱ��
        //generic
        
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(100);
        li.add(200);
        for(int value : li) {
            System.out.println(value);
        }
        
        Integer i2 = new Integer(100);
        Integer i3 = new Integer(100);
        
        int i4=100;
        int i5=100;
        System.out.println(i4==i5);   //true
        
        System.out.println(i2==i3);   //false. �̰� �ּҰ� ���̱� ����
        System.out.println(i2.equals(i3)); //���� ���Ϸ��� �̷��� ���ؾ� �Ѵ�
        
        Integer t = new Integer(500);
        integerMethod(t); //t��� ���������� �ּҰ�
        intMethod(t);    //t��� ���������� ������ ��. �̾�� ������ toString �������̵��� ���� �� ���
        
    }
    
    static void integerMethod(Integer i) {
        System.out.println("integer param: "+ i);  //toString() �������̵��� ���� �� ���
        System.out.println(i.MAX_VALUE);
    }
    
    static void intMethod(int i) {
        System.out.println("int param: "+ i);
    }

}
