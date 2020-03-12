/*
 * this : ��ü �ڽ��� ����Ű�� �������� (this.empno)
 * this() : �����ڸ� ȣ���ϴ� this �޼��� (this(100,"ȫ�浿")
 * 
 * ���
 * �θ�: �ڽ�
 * super(���� �ڽ��� �θ� �����ϴ� �ּҰ�) : super(�θ��� �ּ�)
 * 
 * super
 * 1. ��� ���迡�� �ڽ��� �θ� �ڿ��� ����
 * super()
 * 2. ��� ���迡�� �θ��� �����ڸ� ȣ���ϴ� �޼���
 * 
*/

class Base{
    String basename;
    Base(){
        System.out.println("Base �⺻ ������ �Լ�");
    }
    Base(String basename){
        this.basename = basename;
        System.out.println("bname : "+this.basename);
    }
    void method() {
        System.out.println("�θ� method");
    }
}

class Derived extends Base{
    String dname;
    Derived(){
        System.out.println("Derived �⺻ ������ �Լ�");
    }
    
    Derived(String dname){
        //�ڽ� ���忡�� �θ��� �������ؼ� �θ��� �ּҰ� �ʿ�
        super(dname);  //�θ��� String Ÿ�� �Ű����� �ϳ��� ���� ������ ȣ���ؼ� dname �Է�
        this.dname = dname;
        System.out.println("dname : "+this.dname);
    }
    @Override
    void method() {
        System.out.println("�ڽ� method");
    }
    //����� �θ��� �ڿ��� �׸��� �θ� method �Լ��� ȣ���ϰ� ���� ��
    //������ ���: super  (�ڽ��� �Լ� �������� ��� ����)
    
    void p_method() {
        super.method();
    }
    
}

public class Ex06_Inherit_Super {

    public static void main(String[] args) {
//        Derived d = new Derived();
        Derived d = new Derived("Hello");
        d.method();
        d.p_method();

    }

}
