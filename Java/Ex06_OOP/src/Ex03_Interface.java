/*
 * �߻� Ŭ����: �������̽� (ǥ��, ���, ��Ģ, �Ծ� ����� ����)
 * 1. ������ ��ü ���� �Ұ���(new ������ ��� �Ұ���)
 * �߻� Ŭ����(�̿ϼ�), �������̽�(��� ���� �߻� �ڿ�(�̿ϼ�))
 * 
 * 2. ���(extends), ����(implements)�� ���ؼ��� ��밡��(heap ���� ����)
 * 3. ������ ���� ������ ���� ����

 * �߻�Ŭ������ �������̽��� �ٸ� ��
 * 1. �������̽��� ���� ���� ����(���(ǥ��) �۰� ���� : ���� ��� > ��Ƽ� ũ��)
 *    class Test extends Object implements Ia, Ib, Ic  // ���� ��� ����
 *    
 * 2. �߻�Ŭ������ ���� ��� ��Ģ(������ ���)
 * 
 * 3. �߻�Ŭ������ �ϼ��� �ڵ� + �̿ϼ� �ڵ�
 * 
 * 4. �������̽��� ����� ������ �������� �̿ϼ�(�߻�)  JDK 8����(Default��, Static ���� ����)
 * 
 * 
 * �������̽�: ����Ʈ���� ���� �ֻ��� �ܰ�
 * � ������Ʈ�� ����... 
 * ���θ� ���� ... 
 * 
 * **������(�ʱ�)**
 * 1. �������̽��� [������] �������� ���� (�������̽��� �θ� Ÿ������)
 * 2. ���� �������� ���� Ŭ������ �ϳ��� �����ִ� ����� �ϴ� ����(�θ� �����ϰ� ������)
 * 3. �������̽��� ������ �ʾƵ� JAVA API ���� ���� > (��븸 ���ص� ����� ���� ����)
 * 4. �������̽��� (~able): �� �� �ִ�, ������ �� �ִ� (����)
 * 5. ��ü ���� ���� ��(��ü ���� ����)
 * 
 * 
 * ����Ʈ���� ����
 * 1. ���ߴܰ��� �ֻ��� >> �䱸���� >> ����(�������̽�)
 * 2. ���� ǥ�� >> ���� ����(����) >> ������
 * 
 * Interface
 * 1. ���� �����ΰ� ���� : ���� ���� ����: ���(�ý��ۿ��� �̵�: move, ��ǥ�� ����)
 *                                  void move(int x, int y); //�߻�޼���
 * JavaAPI (���߿� �ʿ��� ������ �������̽� ����: �������̽��� ������� ������ Ŭ����)
 * >>Collection (���� �迭) >> Vector, ArrayList, Hashset, HashMap
 * >> ���� ���� interface�� ����
 * 
 * ���� ���
 * 1. ���(final): public static final int VERSION=1; [public static final] ���� ����> �����Ϸ��� �߰���
 * 2. �Լ�(method) : public abstract void run(); >> [public abstract] ���� ����
 * 
 * interface Ia{
 *      int VERSION=1;
 *      void run();
 *      Stirng move(int x, int y);
 * }
 * 
 * 
 * 
 * 
*/
//interface Ia{void run();}  // �ƹ� ���뵵 ��� �ǰ�, �ִٸ� �߻�����
//interface Ib{}
//interface Ic{}
//
//// class Test extends Object implements Ia, Ib, Ic{}   //��� Ŭ������ Object�� ����ϹǷ� Object�� �����Ȱų� ��������
//class Test implements Ia, Ib, Ic{  //���� ��� ����
//
//    @Override
//    public void run() {
//    }
//    
//}

interface Ia{
    int AGE=100; //public static final ����
    String GENDER="��";
    
    String print(); //public abstract ����
    void message(String str);
}

interface Ib{
    int AGE=10;
    void info();
    String val(String s);
}

class Test2 extends Object implements Ia, Ib{

    @Override
    public String print() {
        return null;
    }

    @Override
    public void message(String str) {
    }

    @Override
    public void info() {
    }

    @Override
    public String val(String s) {
        return null;
    }
    
}



public class Ex03_Interface {

    public static void main(String[] args) {
        Test2 t = new Test2();
        
       
//        System.out.println(t.AGE); // ����. �� interface�� AGE �� � ������ �Ǵ� �ȵǱ� ����
        Ia ia = t; //������
        System.out.println(ia.AGE);  // �������� �̿��� �θ�Ÿ�� �����ؼ� ��� ����
        Ib ib =t;
        System.out.println(ib.AGE);  // �������� �̿��� �θ�Ÿ�� �����ؼ� ��� ����
        
        

        
        
        
        
        
        
        
        
        
        
        
    }

}
