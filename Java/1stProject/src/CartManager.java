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
import java.util.Set;

class CartManager implements Manager, Serializable {
   
    static HashMap<String, Cart> cartList = new HashMap<String, Cart>();
    
    static Scanner sc = new Scanner(System.in);
        
    
    
    // ��ٱ��Ͽ� ��ǰ �߰�
    public void add() {
        String id = Mall.id;
        int pnumber;
        //��ٱ��� ����
        
//        if(cartList.get(id).cartArray==null) {
//        	cartList.put(id, new Cart()); 	
//        }

        while (true) {
            System.out.println("�߰��� ��ǰ ��ȣ�� �Է��� �ּ���.");
            pnumber = Integer.parseInt(sc.nextLine()); // ��ǰ��ȣ �Է�
            if (!ProductsManager.productList.containsKey(pnumber)) {
                System.out.println("�������� �ʴ� ��ǰ ��ȣ�Դϴ�. �ٽ� ������ �ּ���.");
            } else
                break;
        }
       
        

        Product p = ProductsManager.productList.get(pnumber); // �Է��� ��ǰ ȣ��
        if (p.getQuantity() < 1) {
            System.out.println("��ǰ�� ǰ���Ǿ� ������ �� �����ϴ�.");

            return;
        }
        System.out.println(p.getPname() + "�� �����մϴ�.");
        System.out.println();
        
        int quantity;
        while (true) {
            System.out.println("������ ������ �Է��� �ּ���");
            quantity = Integer.parseInt(sc.nextLine());
            if (p.getQuantity() < quantity) {
                System.out.println("��ǰ�� ������ �����Ͽ� ������ �� �����ϴ�.");

            } else
                break;

        }
        Set<Product> set = cartList.get(id).cartArray.keySet(); // �� īƮ�� īƮ����� ���δ�Ʈ�� �ټ���.
    

        if (set.isEmpty()) { // īƮ�� �������,
            cartList.get(id).cartArray.put(p, quantity); // �� īƮ�� ��ǰ �߰�
        }else { // īƮ�� ��ǰ�� �� �־����Ÿ�,
            outer: while (true) {
                for (Product s : set) { // īƮ����� ���δ�Ʈ��ο���,
                    if (s.getPname().equals(p.getPname())) { // �˻��ؼ�, �̸��� ��ġ�ϴ»�ǰ�� ������,
                        cartList.get(id).cartArray.replace(s, cartList.get(id).cartArray.get(s) + quantity);
                        break outer;
                    }
                }
                cartList.get(id).cartArray.put(p, quantity); // �ش�īƮ��, ���δ�Ʈ p�� ������ �߰��Ѵ�.
                break;
            }
        }

    
        p.setQuantity(p.getQuantity() - quantity);

        cartList.get(id).totalprice += p.getPrice() * quantity;
        ProductsManager productsManager = new ProductsManager();
        productsManager.save();
        save();
        cartList.get(id).show();

        System.out.println("��ٱ��Ͽ� ��ǰ�� �߰��Ǿ����ϴ�.");

    }
    //��ٱ��� ����
    public void remove() {  
    	String id = Mall.id;
        //��ٱ��ϰ� ����� �� 
        if(cartList.get(id).cartArray.isEmpty()) {
            System.out.println("��ٱ��ϰ� ������ϴ�. ������ ��ǰ�� �����ϴ�.");
            return;
        }

        cartList.get(id).cartArray.clear();
        cartList.get(id).totalprice = 0;
        System.out.println("��ٱ��ϸ� ������ϴ�.");
        save();

    }
    
    //��ٱ��Ͽ� ��� ���� ���
    public void buy() {
        //��ٱ��ϰ� ����� �� 
    	String id = Mall.id;
        if(cartList.get(id).cartArray.isEmpty()) {
            System.out.println("��ٱ��ϰ� ������ϴ�. ������ ��ǰ�� �����ϴ�.");
            return;
        }
        
        //���� ��� ����
        while(true) {
        System.out.println("���� ����� ������ �ּ���   1. ī�� ����   2. ���� ��ü");
        String choice = sc.nextLine();
        if(choice.equals("1")) {
            System.out.println("ī��� �����մϴ�.");
            System.out.println("������ �Ϸ�Ǿ����ϴ�.");
            break;
        }else if(choice.equals("2")) {
            System.out.println("���� ��ü�� �����մϴ�.");
            System.out.println("���� ��ü Ȯ��.");
            System.out.println("������ �Ϸ�Ǿ����ϴ�.");
            break;
        }else {
            System.out.println("�߸� �Է��Ͽ����ϴ�.");
        }
        }
        
        
        Customer customer = (Customer) CustomerManager.customerList.get(id);
        System.out.println(customer);

        Set<Product> set = cartList.get(id).cartArray.keySet();

        if (set.isEmpty()) {
            System.out.println("��ٱ��ϰ� ������ϴ�.");
        } else {

            // ���ų��� ����
            for (Product p : set) {

                Transaction t = new Transaction(customer.getId(), p.getPname(), p.getPrice(),
                        cartList.get(id).cartArray.get(p));
                customer.transactionArray.add(t);
                TransactionManager.transactionList.put(id, customer.transactionArray);
                System.out.print(p.getPname() + ", ");
            }
            TransactionManager transactionManager = new TransactionManager();
            transactionManager.save();
            System.out.println("�� �����ϼ̽��ϴ�.");
            remove();
        }

    }

//	public void show() {
//		cartList.get(CustomerManager.id).show();
//	}

    // I/O�� ���� ����ȭ ����
    public void save() {
        File file = new File("CartDB.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

            oos.writeObject(cartList);
            // writeObject �޼��带 �̿��ؼ� ����ȭ ����
            oos.close();
            bos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("�����߻�!!!");
            e.printStackTrace();
        }
    }

    // I/O�� ���� ������ȭ �ε�
    public void load() {
        File file = new File("CartDB.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

            cartList = (HashMap) ois.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ
                                                   // ���ϰ��� Object�̹Ƿ� �ٿ�ĳ����

            ois.close();
            bis.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
            e.printStackTrace();
        }
    }

}