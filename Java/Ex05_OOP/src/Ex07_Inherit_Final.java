/*
 * ���<->����
 * ���: �� �� ���� �ʱ�ȭ�Ǹ� ���� �Ұ�
 * ��� �ڿ�: ������(�ֹι�ȣ). �������� ��: PI=3.14159...
 * ����� ���������� [�빮��]
 * 
 *  java: final int NUM  = 10;
 *  C#: const int NUM = 10;
 *  
 *  final Ű����
 *  Ŭ���� �տ� >> final class Car{}  >> final Math >> ��� �Ұ�
 *  �Լ� �տ�: public final void print(){} >> �������̵� �Ұ�
 *           public static final void print(){}  >> �����ڿ�, �����Լ�, �������̵� �Ұ�
 *  ���: public final String KIND="heart"  //���
*/
    
class Vcard {
//    final String KIND;   //����� �ʱ�ȭ�� �� �ʿ�(�⺻�� �ʱ�ȭ �ȵ�)
    final String KIND = "heart";
    final int NUM = 10;
    
    void method() {
        //�ڹ� API
        System.out.println(Math.PI);
    }
}

//Vcard ī�� 53���� ����� ��� ī�� ����� KIND>> heart
//Ȥ�� 53���� ī�� KIND �� �ٸ���. ��������� �ٲ��� �ʰ�

class Vcard2{
    final String KIND;
    final int NUM;
    
//    Vcard2(){
//        this.KIND="heart";
//        this.NUM=10;
//    }
//    Vcard2(){} //����� ���� �ʱ�ȭ�� ���߱� ������ ����
    Vcard2(String kind, int num){   //�����ε��� �̿��ϸ� ��ü ���� ���� ���� ����� ���� ����
        this.KIND=kind;
        this.NUM=num;
    }

    @Override
    public String toString() {
        return "Vcard2 [KIND=" + KIND + ", NUM=" + NUM + "]";
    }
    
    
}

public class Ex07_Inherit_Final {

    public static void main(String[] args) {
        Vcard v = new Vcard();
        v.method();
//        v.NUM=1000; //The final field Vcard.NUM cannot be assigned �� �� �ʱ�ȭ�� ���� ���� �Ұ�
        
        Vcard2 c = new Vcard2("spade", 1);
        System.out.println(c.toString());
        Vcard2 c2 = new Vcard2("spade", 2);
        System.out.println(c2.toString());
        Vcard2 c3 = new Vcard2("spade", 3);
        System.out.println(c3.toString());
        
//        c.KIND = "heart"; //����� �� �� �ʱ�ȭ �� ���� ������ �Ұ���
        

        
        
        
        
        
        
        

        
    }

}
