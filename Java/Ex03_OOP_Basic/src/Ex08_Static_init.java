
class InitTest{
    static int cv=10;
    int iv=1;
    
        static{ //static �ʱ���: static ���� �ʱ�ȭ(���� ����)
            cv =20;
            
        }
        
    
    

        //instance �ʱ���(static memberfield �� memberfield�� ���� �ʱ�ȭ)
        { //�ʱ��� : �޸𸮿� iv��� ������ �ö󰡰� ���� �ٷ� ����
            //instance ������ �ʱ�ȭ    //������ �ڵ� �ʱ�ȭ�� �ϱ� ���� �ʿ� ex) cv2=cv+10; 
            iv = 3;
    
        }

}

public class Ex08_Static_init {

    public static void main(String[] args) {
        System.out.println(InitTest.cv);
        InitTest init = new InitTest();
        System.out.println(init.iv); //�ʱ�ȭ�ؾ߸� iv���� ���� ����

    }

}
