import java.util.ArrayList;
import java.util.Stack;

/*
 * Today Point
 * Generic
 * jdk 1.5����
 * C#, Java �ʼ� ���
 * 
 * Collection Ŭ��������(��������� Ÿ��: Object) 
 * 1. Object Ÿ�� ���� >> Ÿ��?? >> Ÿ�԰��� >> ���׸�
 * 2. Ÿ�� ������(Ÿ�� ����)
 * 3. ����ȯ(castring)�� �ʿ����
 * 
 * ����� ����: Ŭ���� ���� >> Ÿ���� �����ϵ���
*/

class MyGen<T>{ //Type parameter   <T>
    T obj;
    
    void add(T obj) {
        this.obj=obj;
    }
    T get() {
        return this.obj;
    }
}

class Person extends Object {
    int age = 100;
}

public class Ex06_Generic {

    public static void main(String[] args) {
        
        MyGen<String> mygen = new MyGen<String>();
        mygen.add("���ڿ�");
        String result = mygen.get();
        System.out.println(result);
        
        ArrayList list = new ArrayList();     //���׸��� ������� ������ �⺻Ÿ���� Object�� �ȴ�
        
        list.add(10);
        list.add("ȫ�浿");
        list.add(new Person());  //�� ���� �� �ִ�
        
        //���
        for(Object obj : list) {
//            System.out.println(obj);  //�ּҰ��� ���
//            Person p =(Person)(obj);
//            System.out.println(p.age);
            //�Ǵ�(��ü, �� ���� .. ��ȯ)
            if(obj instanceof Person) {         //���׸��� ������ �̷��� �����ϰ� �ؾ��Ѵ�
                Person p = (Person)(obj);
                System.out.println(p.age);
            }else {
                System.out.println((obj));
            }
        }
        
        ArrayList<Person> plist = new ArrayList<Person>();  //�캯 ���׸��� ������ �� ������ ȣȯ���� ���� �ǵ��� ǥ������
        plist.add(new Person());
        plist.add(new Person());
        for(Person p : plist) {
            System.out.println(p.age);
        }

        MyGen<Person> myobj = new MyGen<Person>();
        myobj.add(new Person());
        Person pe = myobj.get();
        System.out.println(pe.age);
        
        Stack<String> s = new Stack<String>();
        s.push("���ڿ�");
        String str = s.pop();
        System.out.println(str);
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
