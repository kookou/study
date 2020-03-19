import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_Stream_ImageCopy {

    public static void main(String[] args) {
        
        String orifile = "D:\\tae\\IOTemp\\1.jpg";
        String targetfile = "copy.jpg";   //�⺻ ����� ������Ʈ ������ ����
        
        FileInputStream fs = null;
        FileOutputStream fos = null;
        
        try {
            fs = new FileInputStream(orifile);
            fos = new FileOutputStream(targetfile,false);  //�⺻���� false�� false�� ��� ���� ����
            
            int data=0;
            while((data=fs.read())!=-1) {
                fos.write(data); //data���� read�ؼ� targetfile write �۾�
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
            try {
                fs.close();
                fos.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        }

        
        
        
        
    }

}
