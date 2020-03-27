import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Payment {
		//���1
		HashMap<String, Cart> cartManager = new HashMap<String, Cart>();
		User user = new User();
		//���2
		CartManager cartManager1 = new CartManager();

		//user�� cart�� �ִ� �� 
		public void order() {
			//���1
			Map<String, Cart> map = (Map<String, Cart>) cartManager.get(user.getId());
			for(int i=0;i<map.size();i++) {
		     map.get(i); //cart�� i��° �ִ� product�� �ǹ�.
			}
			//���2
			cartManager1.show(); //īƮ��Ϻ�����.
		}
		public void pay() {

			save(); // paymentDB�� ����.
		}
		 private void save() {
		        File file = new File("PaymentDB.txt");
		        
		        try{
		            FileOutputStream fos = new FileOutputStream(file);
		            BufferedOutputStream bos = new BufferedOutputStream(fos);
		            ObjectOutputStream oos = new ObjectOutputStream(bos);  //����ȭ ������ ���� ������Ʈ��
		            
		            oos.writeObject(cartManager.get(user.getId())); 
		                                        // writeObject �޼��带 �̿��ؼ� ����ȭ ����
		            oos.close();
		            bos.close();
		            fos.close();
		        }catch(Exception e){
		            System.out.println("�����߻�!!!");
		            e.printStackTrace();
		        }
		        System.out.println("����Ǿ����ϴ�.");
		    }
		    //I/O�� ���� ������ȭ �ε�
		    void load() {
		        File file = new File("PaymentDB.txt");
		        try{
		            FileInputStream fis = new FileInputStream(file);
		            BufferedInputStream bis = new BufferedInputStream(fis);
		            ObjectInputStream oos = new ObjectInputStream(bis); //������ȭ�� ���� ������Ʈ��
		            
		            cartManager = (HashMap)oos.readObject(); //readObject�޼��带 �̿��ؼ� ������ȭ
		                                                  //���ϰ��� Object�̹Ƿ� �ٿ�ĳ����           
		            oos.close();
		            bis.close();
		            fis.close();
		            
		        }catch(Exception e){
		            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
		            e.printStackTrace();
		        }
		    }
			
}