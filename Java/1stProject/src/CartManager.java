import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CartManager extends Cart implements Manager{
    CustomerManager customerManager = new CustomerManager();
    static Scanner sc = new Scanner(System.in);
    HashMap<String, Cart> cartList = new HashMap<String, Cart>();       
    ProductsManager productsManager = new ProductsManager();
    TransactionManager transactionManager = new TransactionManager();

    public void add() {
        
        
        customerManager.load();
        String id = customerManager.id;
        //īƮ�� �ڲ� ������� if�� �߰��ؾ� ��
      
        cartList.put(id,new Cart()); //user�� id����, ���ο� īƮ ����.

        System.out.println("�߰��� ��ǰ ��ȣ�� �Է��� �ּ���.");
        productsManager.load();
        int pnumber = Integer.parseInt(sc.nextLine()); //��ǰ��ȣ �Է�  
        
        Product p =productsManager.productList.get(pnumber);  //�Է��� ��ǰ ȣ��
        System.out.println(p.toString());
        cartList.get(id).cartArray.add(p); //�� īƮ�� ��ǰ �߰�
        p.setQuantity(p.getQuantity()-1);  //��ǰ ���� -1
     
        cartList.get(id).totalprice += p.getPrice();
        productsManager.save();
        save();
        cartList.get(id).show();
        
        System.out.println("��ٱ��Ͽ� ��ǰ�� �߰��Ǿ����ϴ�.");

        
    }
    public void remove() { //ȸ���� īƮ ��ü�� �����ϴ� ���� ������ remove�� ����...
        String id = customerManager.id;
        System.out.println(id);
        
        Customer customer = (Customer)customerManager.customerList.get(id);
        
        customer.transactionArray.clear();
        
    }
    
    public void buy() {
        String id = customerManager.id;
        
        Customer customer = (Customer)customerManager.customerList.get(id);
        
        if(customer.transactionArray==null) {
            return;
        }
        for(Product p : cartList.get(id).cartArray) {
          
            System.out.println(customer);
            
            
            Transaction t = new Transaction(customer.getId(),p.getPname(), p.getPrice(), p.getQuantity());      
            customer.transactionArray.add(t);
            
            
            transactionManager.transactionList.put(id, customer.transactionArray);
           
            transactionManager.save();
            
            
            System.out.print(p.getPname()+", ");
            
            
            
        }customer.transactionArray.clear();
        System.out.println("�� �����ϼ̽��ϴ�.");
       
        
        
        
        
    }
    
    public void show() {
        cartList.get(customerManager.id).show();
    }
    
    //I/O�� ���� ����ȭ ����
    private void save() {
        File file = new File("CartDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //����ȭ ������ ���� ������Ʈ��
            
            oos.writeObject(cartList); 
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
        File file = new File("CartDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //������ȭ�� ���� ������Ʈ��
            
            cartList = (HashMap)oos.readObject(); //readObject�޼��带 �̿��ؼ� ������ȭ
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