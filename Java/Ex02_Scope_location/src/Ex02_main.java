import kr.or.bit.common.Car;

/*
 Ŭ���� == ���赵 == Ÿ��

 Ŭ���� ���� ���: [�ʵ�+�Լ�] + ������
 *�ʵ�(field) : ��������, ��������, ����(��ǰ)���� �ڿ��� ��� �ִ� ����
 *�Լ�(function) : ��� (���� ����)
 *������(constructor) : �ʵ��� �ʱ�ȭ�� �������� �ϴ� �Լ�
 
 Ŭ����, �ʵ� , ������, �Լ�: �ڽ��� ����(����) ����(������, ������, ������)
 >����������(Access Modifier) : public, private, default, protected ��

 1. public class Test{}

 2. class Test{} >> �����Ϸ��� ���������� default��� �����ڸ� �ٿ��� �����
    defalut ������: ���� �������� ���� ����, �ٸ� ������ ������ ���� ���� �Ұ�
    default
 3. �ϳ��� �������� �ڹ� ������ ���� ���� Ŭ������ ���� �� �ִ� 
        ��, �׷� ���, public Ŭ������ �ϳ��� �����ؾ� �Ѵ�    
    
    
    
    
    
    �ǽ�
    src ���� >> Ex01_main
    kr.or.bit.common >> public Bitmain
    kr.or.bit.common >> public Car
    kr.or.bit.common >> (default)Car
    
*/
//������ �տ� defualt�� �����Ǿ� ����
class Test {
    int d_iv;  //�����Ϸ��� �ڵ����� default�� �����ڷ� �ؼ�
    public int p_iv; //��𿡼��� ��������
    private int pri_iv; //��������(���߾���/����)
}



public class Ex02_main {

    public static void main(String[] args) {
       Car car = new Car();
      // kr.or.bit.common.Person p = new Person(); // default Ŭ������ ���� ���������� ���� ����
       car.color="red"; // color�� public�̶� ���� ����
      //car.door=100; //door�� default�� ���� �Ұ���
       
       Test t = new Test();
       t.d_iv = 100; //default ���� ����
       t.p_iv = 200; //public ���� ����
       //t.pri_iv  // private �̶� ���� �Ұ���
       
 
       
       
       

    }

}
