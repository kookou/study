package kr.or.bit;
import java.io.IOException;
/*
 * ���赵(class) ���� ��
 * �� ���赵�� ����ϴ� �����ڰ� ���ܸ� ó���� �־����� [������]
 * 
 * ����ó�� ����
 * ������ throws IOException NullPointerException > throw's'�� ����: ���� ���� ������ �� ����
 * �Լ� throws �� ��������
 * 
*/

public class ExceptionClass {
    public ExceptionClass(String path) throws IOException, NullPointerException{  //�� �����ڸ� ���� �̷� ������ ���� �� �ִٰ� �˷���  //����ó���� �ϵ��� ����
        
    }
    
    public void call() throws ArithmeticException, IndexOutOfBoundsException{
        System.out.println("call �Լ� start");
        int i = 0/0;
        System.out.println("call �Լ� end");
        
    }

}
