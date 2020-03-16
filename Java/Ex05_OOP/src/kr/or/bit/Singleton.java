package kr.or.bit;
//<�̱��� ����>
//������ ����(��������) >> new >>��ü�� ����� ���
//��ü �ϳ��� ���� ����
//ȸ��: ����������

//����: ��ü�� �ּҰ� �׻� �����ϴ�. 
//��, Ŭ���� ������ p�� ��� ��ü ���������� �ּҰ��� �ǰ� �ؼ� �� �޸𸮿� �ϳ��� ��ü�� �����ϰ� ����ϰ� �ȴ�.

//Ȱ��: JDBC: JAVA <- (JDBC: CRUD) -> DB

//main
//Singleton singleton = new Singleton(); //������ ȣ�� >> ����x(private)
public class Singleton {
    
    private static Singleton p;   //private static���� Ŭ����Ÿ�� ���� ����
    private Singleton() { //������(default)  //���� ��ü ���� �Ұ��ϰ� private ������ ����
        
    }
    public static Singleton getInstance() {   //getInstance �޼��带 ���� ��ü ���� �� ������ ��ü�� �����ϰ� ��
        if(p==null) {
            p=new Singleton(); //singleton = new Singleton(); 
                                 //Ŭ���� ���ο����� public, private�� �������� ����
        }
        return p;
    }
    
    
    
    

}
