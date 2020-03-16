/*
 * User �����: provider ������
 * 
 * class A {}, class B{}
 * ����: A�� B�� ����մϴ�
 * 
 * 1. ���: A extends B
 * 2. ����: AŬ���� �ȿ��� Member Field B ��� >> class A {B b;}
 * 
 * 2.1 ��ü ����
 * 
 * class B{}
 * class A{
 *      int i;
 *      B b; //A�� B�� ����մϴ�... ����
 *      A(){
 *          b= new B();
 *      }
 * }
 * A a = new A();  >> A��ü�� ��������� B��ü�� ���� ����  >> A��ü�� ������� B��ü�� �����
 * ---------------------------------------------
 * 2.2 �κ� ����
 * 
 * class B{}
 * class A{
 *      int i;
 *      B b;  //A�� B�� ����մϴ�... ����
 *      A(B b){
 *          this.b = b
 *      }
 * }
 * 
 * B b = new B();
 * A a = new A();   >> A�� B ��ü�� ������ ����
 * --------------------------------------
 * 3. ����
 * class B{}
 * class A{
 *      int i;
 *      //������ ����: member field B��� Ÿ���� ������ ������ ����
 *      void print(B b){}
 *      
 *      B print(){
 *          B b = new B();
 *          return B;
 *      }
 * }
 * 
 * >>B b = new B();
 * >> A a = new A();
 * 
 * a.print(b);          //�̷��Ե� �ǰ�    >> �Ʒ� ������ �� ��� Ȱ��
 * B b2 = a.print();   //�� ������ ��� ����      
 * 
 * 
 * ***** parameter�� ���Ǵ� Ÿ���� ���� ���*****
 * 
 *    
*/

interface Icall{
    void m();
}

class D implements Icall{

    @Override
    public void m() {
        System.out.println("D�� Icall �������̽��� m() ����");
    }
    
}

class F implements Icall{

    @Override
    public void m() {
        System.out.println("F�� Icall �������̽��� m() ����");
    }
    
}

//interface Ȱ��  >> ���뿡 �־ ���α׷��� ���� >> �����ϰ�
//�������迡�� interface Ȱ���
class C{
    void method(Icall ic) { //�Լ� ic ������ � Ÿ���� ��ü�� ���� �� �������
        ic.m();
    }
}




public class Ex_05_User_Provider {

    public static void main(String[] args) {
        C c = new C();
        D d = new D();
        F f = new F();
        c.method(d);
        c.method(f);  //�� �� �����ϴ�. �������̽� Ȱ���� ����
        
        
        
        
        
        
        
    }

}
