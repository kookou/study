/*
 * ������ (��� ���迡�� ����)
 * ������: ���� ���� ����(����)�� ���� �� �ִ� �ɷ�
 * 
 * C#: ������(overloading, override) �ɷ�
 * 
 * JAVA: [��� ����]���� [�ϳ��� ��������]�� [���� ���� Ÿ��]�� ���� �� �ִ� �ɷ�
 *       ��, �ϳ��� ���������� [�θ� Ÿ��]�̾�� �Ѵ�.
 *       �θ� Ŭ���� Ÿ���� ���������� ���� ���� �ڽ� Ŭ���� ��ü�� ���� �� �� �ִ�.
 *       
 * ������: ���� ����� �ݴ�: �ڽ��� �θ𿡰� ���Ǿ��� �帰��.
*/

class Tv2{   //�θ�(�Ϲ�ȭ, �߻�ȭ) �����ڿ�
    boolean power;
    int ch;
    
    void power() {
        this.power=!this.power;
    }    
    void chUp() {
        this.ch++;
    }
    void chDown() {
        this.ch--;
    }
}

class CapTv extends Tv2{  //Tv�� Ư��ȭ, ��üȭ, ������ ǥ��
    String text;
    String captionText() {
        return this.text = "���� �ڸ� ó�� ��...";
    }
}


public class Ex10_Inherit_polymorphism {

    public static void main(String[] args) {
        
        CapTv captv = new CapTv();
        captv.power();
        System.out.println("����: "+captv.power);
        
        captv.chUp();
        System.out.println("ä�� ����: "+captv.ch);
        System.out.println("�ڸ� ó��: "+captv.captionText());
        //���� ��� ����
        
        Tv2 tv2 = captv;  //��� ���迡�� �θ� Ÿ���� �ڽ� Ÿ���� �ּҸ� ���� �� �ִ�(�̰� ������)
        //[��� ����]���� [�θ� Ÿ�� ����]�� [�ڽ� Ÿ�� ����]�� �ּҸ� ���� �� �ִ�(������)
        //�� �θ�� �ڽ��� ��ü�� �� �� �ִ�
        //�� �����Ǹ� �����ϰ�...
                
//        Tv2 tv = new Tv2(); //�̷��� �ϸ� �� �ϳ��� �ν��Ͻ��� ����� �� > �޸� ����. ���� �������� �̿�
        System.out.println(tv2.toString());
        System.out.println(captv.toString());   // �� ���� ������ �ּҴ� ����        

        
        
        
        
        
        
        
    }

}
