import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.or.bit.UserInfo;

public class Ex15_ObjectDateOutputStream {

    public static void main(String[] args) {
        String filename = "UserData.txt";
        
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream out = null;
        
        try {
            fos = new FileOutputStream(filename,true);
            bos = new BufferedOutputStream(fos);
            
            //����ȭ
            out = new ObjectOutputStream(bos);
            
            
            
            UserInfo u1 = new UserInfo("ȫ�浿", "super", 500); //����ǰ
            UserInfo u2 = new UserInfo("scott", "tiger", 50); //����ǰ
            
            
            //����ȭ �۾�
            out.writeObject(u1); //�����ؼ� ���� ������ ���� write
            out.writeObject(u2);
            //���Ͽ� Userinfo ��ü 2�� write
           
            
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            try {
                out.close();
                bos.close();
                fos.close();
                System.out.println("���� ���� -> buffer -> ����ȭ -> ���� write");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
