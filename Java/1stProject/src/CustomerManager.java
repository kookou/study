import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CustomerManager implements Manager, Serializable{
    
	static HashMap<String, User> customerList = new HashMap<String, User>();
       
    static Scanner sc = new Scanner(System.in);
 
    
    //ȸ�� ����
    Customer signUp(String id, String pwd, String name, String tel, String address) {
        Customer customer = new Customer(id, pwd, name, tel, address);
        customer.setId(id);
        customer.setPwd(pwd);
        customer.setName(name);
        customer.setTel(tel);
        customer.setAddress(address);

        customerList.put(id,customer);
           
        save();
        CartManager cartManager = new CartManager();
        cartManager.cartList.put(id, new Cart()); 
        cartManager.save();
        return customer;       
    }
  
    Customer signIn(String id, String pwd) {
        
        if(customerList.containsKey(id)&&
                ((customerList.get(id).getPwd()).equals(pwd))) {

            System.out.println("�α��� ����");
            Mall.id = id;
            return (Customer) customerList.get(id);
        }else {
            System.out.println("�α��� ����");
            return null;
        }        
    }
    
    
    void productList() {  
        ProductsManager p = new ProductsManager();
        p.load();
        p.productList();
    }


    void myTransactiontHistory() {

       

        if (TransactionManager.transactionList.get(Mall.id) == null) {
            System.out.println("�ֹ� ������ �����ϴ�.");
        } else {
            System.out.println(TransactionManager.transactionList.get(Mall.id));
        }

    }
    
    public void userList() {
        Set<String> set= customerList.keySet();
        //���2
        System.out.println("==========================Vip�����==========================");
        System.out.println("       ID    Password    ����           �޴��� ��ȣ                     �����");
        for(String c : set) {
            if(c.equals("admin")) {
                continue;
            }
            Customer user = (Customer)(customerList.get(c));
            System.out.printf("%10s %10s %5s %10s %17s",user.getId(),user.getPwd(),user.getName(),user.getTel(),user.getAddress());
            System.out.println();
        }
    }
    
    void MyInfo() {
        do {
            try {
                 System.out.println("��й�ȣ�� �Է��Ͻʽÿ�");
                 String password = sc.nextLine();
                 if(customerList.get(Mall.id).getPwd().equals(password)) {
                     Customer my = (Customer)customerList.get(Mall.id); //(user)Ÿ������ �ִ� value�� �ٿ�ĳ�����ʿ�.
                     System.out.printf("[�̸� : %s]\n[���̵� : %s]\n[��й�ȣ : %s]\n[��ȭ��ȣ : %s]\n[�ּ� : %s]\n", my.getName(),my.getId(),my.getPwd(),my.getTel(),my.getAddress());
                      break;
                } else {
                    throw new Exception("");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<�Է� ����>");
                System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��Ͻʽÿ�.");
         
            }
        } while (true);

        
    }
    
    public void userTransactionList() {
        Set<String> set= customerList.keySet();
        for(String c: set) {
            if(TransactionManager.transactionList.get(c)==null) {
                if(c.equals("admin")) {
                    continue;
                }
            System.out.println("             ȸ�� "+c+" ���� ���ų����� �����ϴ�.");
            }else userTransactionHistory(c);
        }   
    }
    
    void userTransactionHistory(String id) {
        if(TransactionManager.transactionList.get(id)==null){
            System.out.println(id+" ȸ������ �ŷ������� �����ϴ�.");
            return;
        }else {
            System.out.println(id+" ���� �ŷ����� �Դϴ�.");
            System.out.println(TransactionManager.transactionList.get(id));
        }
    }
    

    public String toString() {
        return null;
    }
    
    @Override
    public void add() {
    }

    @Override
    public void remove() {
    }
    
    
    //I/O�� ���� ����ȭ ����
    public void save() {
        File file = new File("CustomerDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //����ȭ ������ ���� ������Ʈ��
            
            oos.writeObject(customerList); 
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
        File file = new File("CustomerDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //������ȭ�� ���� ������Ʈ��
            
            customerList = (HashMap) oos.readObject(); //readObject�޼��带 �̿��ؼ� ������ȭ
                                                  //���ϰ��� Object�̹Ƿ� �ٿ�ĳ����
            
            oos.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
            e.printStackTrace();
        }
    }


}