import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * read, write ����� File�� ���(�������� ����>> 1.txt, data.txt)
 * FileInputStream
 * FileOutputStream
 * 
 * c:\\IOtemp\\a.txt\\HELLO
*/



public class Ex02_POINT_File_read_write {

    public static void main(String[] args) {
        /*
        try {
            //POINT: I/O �۾��� ��κ� ������ �÷����� ����� �ƴϴ�
            //������� �ڿ��� ������ �ؾ� ��(��ȯ �۾� �ʿ� >>close() >>���������� �Ҹ��� ȣ��)
        FileInputStream fs = new FileInputStream("D:\\tae\\IOTemp\\a.txt");
        int data = 0;
        while((data=fs.read())!=-1) {
            System.out.println("����(����): "+data);  //data�� int���̱� ������ ���ڰ� �ƴ� �ƽ�Ű�ڵ尪�� ���´�
            //���ڰ�����..
            char c =(char)data;
            System.out.println(c);
        }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {    //finally ����/������ ��� ���İ��� �ϴ� ����
            fs.close();  //������ ������ �۵�����
        }
        */
        FileInputStream fs=null;  //try�� �ۿ��� ���� �����ؾ� �Ѵ�
        FileOutputStream fos=null;
        String path = "D:\\tae\\IOTemp\\a.txt";
        try {
            //POINT: I/O �۾��� ��κ� ������ �÷����� ����� �ƴϴ�
            //������� �ڿ��� ������ �ؾ� ��(��ȯ �۾� �ʿ� >>close() >>���������� �Ҹ��� ȣ��)
        fs = new FileInputStream(path);
        fos = new FileOutputStream("D:\\tae\\IOTemp\\new.txt",false);  //false�� �⺻��: ���� �����͸� ���
//        fos = new FileOutputStream("D:\\tae\\IOTemp\\new.txt",true);  // true�� append �Ѵ�.

        //write
        //FileOutputStream�� ���� ��������� ������ ������
        //>> ���Ͽ� write�� �� ������ �������� ������ [������ ����]
        int data = 0;
        while((data=fs.read())!=-1) {
//            System.out.println("����(����): "+data);  //data�� int���̱� ������ ���ڰ� �ƴ� �ƽ�Ű�ڵ尪�� ���´�
//            //���ڰ�����..
//            char c =(char)data;
//            System.out.println(c);
              fos.write(data); //data���� read >>write D:\\tae\\IOTemp\\a.txt
              
        }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {    //finally ����/������ ��� ���İ��� �ϴ� ����
            try{fs.close();             //� ��쿡�� �ڿ��� �ݴ� �۾��� �Ѵ�(���ҽ� ����)
                fos.close();
            }catch (IOException e) {
               e.printStackTrace();
           }
        }
        
        
    
    
    
    
    
    
    
    
    
    }

}
