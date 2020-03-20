import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ���ڱ���� ������ ó��
 * char[]�� ������ ���� (String Ŭ���� ���������� ������ char[] ����)
 * 
 * �ѱ� 1�� >> 2byte >> Stream class�� �ذ� �ȵ�(byte)
 * 
 * reader , write �߻� Ŭ����
 * 
 * ��� File�̸�, FileReader, FileWriter
 * 
*/

public class Ex05_Reader_Writer {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;
        
        try {
            fr = new FileReader("Ex01_Stream.java");  //�� ������ �аڴ�  //�⺻ ��δ� �� �ڹ������� ��Ʈ����
            fw = new FileWriter("copy_Stream.txt");   //���� ���� >> ���⿡ write �۾� �� ��
            
            int data = 0;
            while((data=fr.read())!=-1) {
//                System.out.println((char)data);  //charĳ������ ���ϸ� �ƽ�Ű�ڵ尪���� ��µ�
                fw.write(data); //data���� copy_Stream.txt�� write
                if(data != '\n' && data !='\r' && data !='\t' && data !=' ') {   //\r�� �ٹٲ�  ���н��� \n, ������� \r\n
                    fw.write(data);  //��������(������ ũ�⸦ ����: ���� ����)  // �����̳� ���Ͱ� ��� �����Ǿ����Ƿ�
              
                }
            }fw.flush();  // Writer�� flush�� ����� �Ѵ�
        } catch (Exception e) {

               
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
