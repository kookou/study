package kr.or.bit;
//class == ���赵 == Type
//���赵 ��üȭ(�޸� �÷���)�� ���ؼ� ��ü�� �����Ǿ�� �Ѵ�
//��üȭ�� �� > ��ü, �ν��Ͻ�

//���赵�� �⺻���� �������(�ʵ� + �Լ�) + ������

//class Car{}   >>default class Car{}  > ���� ����������
//public class Car {public String color; int door; > default int door}
 public class Person {
     public String name; //member field > instance variable
                         //�ʱ�ȭ�� ���� �ʾƵ� �ȴ�(�ʱ�ȭ: ���ʿ� ���� �Ҵ� �ϴ� ��)
                         //�����Ǵ� ��ü(���)���� �ٸ� �̸��� ������ ������..
                         //Person p = new Person(); p.name="ȫ�浿";
                         //Person p2 = new Person(); p.name="������";
                         //default ���� ������
                         //public int age; //default���� 0
                         //public boolean power //default���� false
     public boolean power;
     public int age;
     
     //���(����) >> method
     public void print() {
         System.out.println("name : "+name+" / age : "+age);
         
     }
     
}
