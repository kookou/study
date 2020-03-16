/*
 * �߻� Ŭ����
 * >> �̿ϼ� Ŭ����(���赵)
 * 1. �ϼ��� �ڵ� + �̿ϼ� �ڵ�
 * 2. �ϼ�(�Լ�) ������� �ִ� �Լ� + �̿ϼ�(�Լ�) ������� ���� �Լ�(public void run();)
 * 3. �ϼ��� �̿ϼ� ���� (new ��ü ����(�ϼ�), �̿ϼ�(��ü ���� �Ұ���)
 * 
 * ����
 * 1. �߻�Ŭ����(�̿ϼ�) ������ ��ü ���� �Ұ�(new ��� �Ұ�)
 * 2. �߻�Ŭ������ �ᱹ... �ϼ��� Ŭ������ �Ǵ� ���� ����... >> ����� ����
 * 3. ��Ӱ��迡�� �̿ϼ��� �ڿ�(�߻��ڿ�) �ϼ�(����)�ض� >> ������ �ض�(override)
 * 
 * ������ ���忡�� 
 * ���࿡ �߻�Ŭ������ ����ٸ� ���� �ǵ��� �����ϱ�  >> ������ ������ ��������(�����ǿ� ���� ������)
 * 
*/

abstract class Abclass{
    //�߻� Ŭ���� > �߻� �ڿ��� ����ڴ�
    int pos;
    void run() {
        pos++;
    }
    //�̿ϼ�
    abstract void stop();  //�߻��ڿ� {} ������� ����
    
}

//����� �������� ������, �߻�Ŭ������ ���������� �ʾҴ�
class Child extends Abclass {

    @Override
    void stop() { //������� �־ ��������. 
        this.pos = 0;
        System.out.println("stop: "+this.pos);
    }
    
    
}

public class Ex01_abstract_class {

    public static void main(String[] args) {
//        Abclass ab = new Abclass(); //�Ұ�
        
        Child ch = new Child();
        ch.run();
        ch.run();
        System.out.println(ch.pos);
        ch.stop();
        
        Child ch2 = new Child();
        ch2.run();
        ch2.run();
        System.out.println(ch2.pos);
        ch2.stop();

        //������
        Abclass ab = ch;  //�θ�Ÿ���� ���������� �ڽ�Ÿ���� ��ü �ּҸ� ���� �� �ִ�
                          //�θ�� �ڽ��� Ÿ���ڿ��鸸 Ȱ��
                          //****** �θ� ����.... �� �ڿ��� ������  [�ڽ� �ڿ�] ���� ******
        ab.run();
        ab.stop();   //�������̵��� �ڽ��ڿ� ��� ����
        
        
        
        
        
        
        
    }

}
