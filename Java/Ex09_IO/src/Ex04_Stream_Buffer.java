import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Fileó�� (in Disk) read, write
 * �⺻�� �� Byte read, write�� �Ѵ� >>ȿ�������� ����
 * ��Ƽ� �� ���� �������� read, write �ϰ��� �� (����Ÿ�� �� ���� ����)
 * ���� >> Buffer
 * File read, write �߰� [Buffer] >> I/O
 * 
 * 1. I/O ���ɰ���
 * 2. Line ����(����)
 * 
 * �������� ��ü ���� �Ұ�(�� Ŭ������ ����)
 *  
*/


public class Ex04_Stream_Buffer {

    public static void main(String[] args) {
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {                            //����ó�� ����(���� ����)
            fos = new FileOutputStream("data.txt");  //default: false : ���� ����
            bos = new BufferedOutputStream(fos);    // �⺻ �����ڰ� ���� �Ű������� outputStream(�߻�Ŭ����)�� ���� >> ������ ��ü ���� �Ұ�
            
            for (int i = 0; i < 10; i++) {
                bos.write('A');                
            }
            //bos���� ������� �۾��� �������� �ʾұ� ������ ������ �����ǵ� �����Է� X
            //Java Buffer ũ�� > 8kbtye => 8192byte
            //1. buffer ���� ������ 8kb�� ä������ ������ ���� �۾� >>���������� flush�� �߻�
            //2. buffer ������ ����(flush �Ǵ� close)
            //3. bos.close() �ڿ�����  >> close() >> ���������� flush ȣ��
//            bos.flush();       // ������� ��ɾ�
            
        } catch (Exception e) {

        }finally {
            try {
                bos.close();  //flush ��� ����
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
