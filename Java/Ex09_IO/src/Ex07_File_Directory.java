import java.io.File;
import java.io.IOException;

/*
 * I/O �۾�
 * ���ϰ� ������ �ٷ� �� �ִ� Ŭ����
 * 
 * Java: ����, ���� �ٷ�� �� �ϳ��� Ŭ������ ����: File
 * C# : ����(File), ����(Directory) ����
 * >> a.txt ����, ����, ����, ���� read
 * >> Temp ����, ����, ���� read
 * 
 * ���
 * ������: C:\\, D:\\  >>C:\\Temp\\a.txt
 * �����: ���� ������ �߽����� 
 *
*/


public class Ex07_File_Directory {

    public static void main(String[] args) throws IOException { 
        String path = "C:\\Temp\\file.txt";
        File f = new File(path);
        f.createNewFile();  //�Լ��� ȣ���� �� ������ ����
        //File Ŭ������ ���ؼ� (�پ��� ����)
        String filename = f.getName();
        System.out.println("���ϸ�: "+ filename);
        System.out.println("*��ü ���: "+f.getPath());   //�Է��� ��ü ���  ex) path�� �Է��� ���ڿ�
        System.out.println("���� ���: "+f.getAbsolutePath());  
        System.out.println("*�� ������: "+f.isDirectory());
        System.out.println("*�� �����̴�: "+f.isFile());
        System.out.println("*����ũ��: "+f.length());
        System.out.println("�θ���: "+f.getParent());
        System.out.println("*���翩��(����,����): "+f.exists());
        
        //f.delete()  return >> true, false
        //f.canRead()
        //f.canWrite()
        
        
        
        
        
        

    }

}
