import kr.or.bit.Pclass;

/*
 * public, default, private, ��Ӱ��� >> protected
 * 
 * protected
 * ��鼺�� ����(default, public)
 * 
 * ����� ���� Ŭ���� �ȿ��� protected �����ڴ� default�� ����
 * 
 * protected�� ����ϴ� �ǵ�
 * >> ����� �� �������ؼ� ���� ���ڴ�
 * 
*/

class Dclass{
    public int j;
    private int o;
    int p;
    protected int k;
}

class Child2 extends Pclass{
    void method() {
        this.k = 1000;  //��� ���迡�� �ڽ��� �θ��� protected ������ �ڿ��� publicó�� ��� ����
        System.out.println(this.k);
    }
}


public class Ex08_Inherit_Protected {

    public static void main(String[] args) {
        Dclass dc = new Dclass();
//        dc.j ok >>public
//        dc.p ok >>default(���� ���� ��)
//        dc.k ok >>protected(���� ���� �ȿ��� default�� ��������)
//        dc.o >> private(x)
//        �ᱹ proteced�� ��� ���迡���� ���
        Pclass pc = new Pclass();
//        pc.j >> public�� �̰͸� ����
        
        Child2 ch = new Child2();
        ch.method();       
        
    }

}
