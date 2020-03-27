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

class CartManager implements Manager {
	static Scanner sc = new Scanner(System.in);
	HashMap<String, Cart> cartList = new HashMap<String, Cart>();
	ProductsManager productsManager = new ProductsManager();
	TransactionManager transactionManager = new TransactionManager();
	static int i;

	// ��ٱ��Ͽ� ��ǰ �߰�
	public void add() {

		String id = Mall.id;
		// īƮ�� �ڲ� ������� if�� �߰��ؾ� ��

		if (!cartList.containsKey(id)) {

			cartList.put(id, new Cart()); // user�� id����, ���ο� īƮ ����.
		}

		System.out.println("�߰��� ��ǰ ��ȣ�� �Է��� �ּ���.");
		int pnumber = Integer.parseInt(sc.nextLine()); // ��ǰ��ȣ �Է�

		Product p = ProductsManager.productList.get(pnumber); // �Է��� ��ǰ ȣ��
		System.out.println(p.toString());

		Set<Product> set = cartList.get(id).cartArray.keySet();

		if (set.isEmpty()) {
			i = 1;
			cartList.get(id).cartArray.put(p, i); // �� īƮ�� ��ǰ �߰�
		} else {
			outer: while (true) {
				for (Product s : set) {
					if (s.getPname().equals(p.getPname())) {

						cartList.get(id).cartArray.replace(s, cartList.get(id).cartArray.get(s) + 1);
						break outer;
					}

				}
				i = 1;
				cartList.get(id).cartArray.put(p, i);
				break;
			}
		}

		Product p2 = (Product) p;
		p2.setQuantity(p2.getQuantity() - 1); // ��ǰ ���� -1

		cartList.get(id).totalprice += p.getPrice();
		productsManager.save();
		save();
		cartList.get(id).show();

		System.out.println("��ٱ��Ͽ� ��ǰ�� �߰��Ǿ����ϴ�.");

	}

	public void remove() { // ȸ���� īƮ ��ü�� �����ϴ� ���� ������ remove�� ����...
		String id = Mall.id;
		System.out.println(id);

		cartList.get(id).cartArray.clear();
		cartList.get(id).totalprice = 0;
		System.out.println("��ٱ��ϸ� ������ϴ�.");
		save();

	}

	public void buy() {
        String id = Mall.id;     
        Customer customer = (Customer)CustomerManager.customerList.get(id);
        System.out.println(customer);
        

        Set<Product> set = cartList.get(id).cartArray.keySet();
        

		if (set.isEmpty()) {
			System.out.println("��ٱ��ϰ� ������ϴ�.");
		}else {

        for(Product p : set) {
          
            
            
            Transaction t = new Transaction(customer.getId(),p.getPname(), p.getPrice(), cartList.get(id).cartArray.get(p));      
            customer.transactionArray.add(t);
            
            
            TransactionManager.transactionList.put(id, customer.transactionArray);
           
        
            
            
            System.out.print(p.getPname()+", ");
            
            
            
        }transactionManager.save();
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
		System.out.println("����Ǿ����ϴ�.");
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