//�ڹ� ������ (���)
class Pbase{
    int p = 100;
}

class Cbase extends Pbase{
    int c = 200;
}

class Dbase extends Pbase{
    
}



public class Ex11_Inherit_Polymorphism {

    public static void main(String[] args) {
            Cbase cbase = new Cbase();
            System.out.println(cbase.toString());
            
            Pbase p = cbase; //������
            //�θ�Ÿ���� �������� p�� �ڽ� Ÿ���� �������� cbase�� ������ �ּҰ��� ���� �� �ִ�. 
            //�θ�Ÿ���� �������� p�� ������ �θ�ü�� ���� ����.. �ڽİ�ü�� ���� �Ұ� (��, �������̵� �� �޼���� ���� ����)
            
            Dbase dbase = new Dbase();
            
            p = dbase; //����
            //�θ�Ÿ�� p�� �ڽ�Ÿ�� cbase�� �ּҵ� ���� �� �ְ�, �� �ٸ� �ڽ�Ÿ�� dbase�� �ּҵ� ���� �� �ִ�.
            
            
        
        
        
        
        
        
        
        
    }

}
