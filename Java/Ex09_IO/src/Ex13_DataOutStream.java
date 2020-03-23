import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ���� ��Ʈ��
 * DataOutPutStream, DataInputStream
 * Java 8���� �⺻Ÿ��(Ÿ�Ժ��� write, read)
 * ��, DataOutPutStream/DataInputStream ������ ��밡��
 * txt: 100,30,80,60 >> split >> convert >> ���� �� ������ �ս��� ����
*/


public class Ex13_DataOutStream {

    public static void main(String[] args) {

        int[] score = {100,60,55,94,23};
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("score.txt");
            dos = new DataOutputStream(fos);
            for(int i = 0; i<score.length;i++) {
                dos.writeInt(score[i]);  //������ write >> read �ݵ�� DataInputStream����
//                dos.writeUTF(str); web �ѱ�ó�� �� �� ���
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                dos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        }
        
        
        
        
        
        
        
        
        
        
        
    }

}
