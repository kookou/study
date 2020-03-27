import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class TransactionManager implements Manager, Serializable{
    
        
    static HashMap<String, ArrayList> transactionList = new HashMap<String, ArrayList>();

    @Override
    public void add() {
      
    }
    @Override
    public void remove() {
    }
    
    
    
    
    
  @Override
    public String toString() {
        return "TransactionManager [transactionList=" + transactionList + "]";
    }
    
   //I/O�� ���� ����ȭ ����
    public void save() {
        File file = new File("TransactionDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //����ȭ ������ ���� ������Ʈ��
            
            oos.writeObject(transactionList); 
                                        // writeObject �޼��带 �̿��ؼ� ����ȭ ����
            oos.close();
            bos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("�����߻�!!!");
            e.printStackTrace();
        }
    }
    //I/O�� ���� ������ȭ �ε�
    public void load() {
        File file = new File("TransactionDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis); //������ȭ�� ���� ������Ʈ��
            
            transactionList = (HashMap)ois.readObject(); //readObject�޼��带 �̿��ؼ� ������ȭ
                                                  //���ϰ��� Object�̹Ƿ� �ٿ�ĳ����
            
            ois.close();
            bis.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
            e.printStackTrace();
        }
    }

    

}
