import kr.or.bit.Bird;

/*
 * protected > ��� ���迡����
 * ����: ��� ���迡�� �����Ǹ� ����
 * ����� ���� ����Ѵٸ� �� �ڿ�(�Լ�) ������ ������ ���ھ�
 * 
 *  
*/
//��
class Ostrich extends Bird{
    //��üȭ, Ư��ȭ
    void run() {
        System.out.println("run ^^");
    }
    
  

    @Override
    protected void moveFast() {    //public�� �ٸ��� �ڼ�Ŭ�������� �������̵����� ������ ������� ���Ѵ�.
        super.moveFast();
        run();
    }
    
}


public class Ex09_Inherit_Proteced {

    public static void main(String[] args) {
        
        Ostrich ostrich = new Ostrich();
        ostrich.moveFast();    // run^^ : �������̵��ؼ� Ÿ���� �°� �ٲ�. 
        
        
        
        
        
        
        
        

    }

}
