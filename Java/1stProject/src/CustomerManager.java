import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class CustomerManager implements Manager, Serializable{
    HashMap<String, User> customerList = new HashMap<String, User>();
    ProductsManager p = new ProductsManager();
    static String id;
    
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
        return customer;       
    }
  
    Customer signIn(String id, String pwd) {
        
        if(customerList.containsKey(id)&&
                ((customerList.get(id).getPwd()).equals(pwd))) {

            System.out.println("�α��� ����");
            this.id = id;
            return (Customer) customerList.get(id);
        }else {
            System.out.println("�α��� ����");
            return null;
        }        
    }
    
    
    void productList() {       
        p.load();
        p.productList();
    }

    void buy() {
        
    }



    void watchBuyHistory() {

    }
    
    public void userList() {
        Set<String> set= customerList.keySet();
        //���2
        System.out.println("==========================Vip��������==========================");
        System.out.println("       ID    Password    ����           ��ȭ��ȣ                     �����");
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
        
//        System.out.println("ȸ������ ���� �Դϴ�.");
//        load(); //�ӽ÷� �� load
//        Set<String> set = customerList.keySet();
//        customerList.keySet();
//        
//        for(String a : set) {
//            String name = customerList.get(a).getId();
//            
//        }
        Customer my = (Customer)customerList.get(id); //(user)Ÿ������ �ִ� value�� �ٿ�ĳ�����ʿ�.
       System.out.println("ȸ������ �̸��� "+my.getName());
       System.out.println("ȸ������ ���̵�� "+my.getId());
       System.out.println("ȸ������ ��й�ȣ��"+my.getPwd());
       System.out.println("ȸ������ ��ȭ��ȣ��"+my.getTel());
       System.out.println("ȸ������ �ּҴ�"+my.getAddress());

        
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
    private void save() {
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
        System.out.println("����Ǿ����ϴ�.");
    }
    //I/O�� ���� ������ȭ �ε�
    void load() {
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