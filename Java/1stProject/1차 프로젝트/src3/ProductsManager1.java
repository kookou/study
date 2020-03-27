import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductsManager implements Manager {

	ArrayList<Product> productsArray = new ArrayList<Product>();// ��ǰproducts array

	// ��ǰ���� �����ֱ�
	public void productsList() {
		for (Object d : productsArray) { // product array�� �����ְ� �ʹ�.
			System.out.println(d);
		}
	}

	// Mypage>�Һ��ڰ� ���� ���ų���
	public void buyHistory() {
		Payment payment = new Payment(); //���� ���� ����?
		payment.load();
	}

	// Mypage>������ ���� �ҷ�����
	public void userInfo(Customer customer) {
		System.out.println(customer.getName()+"ȸ���� �ȳ��ϼ��� ^^");
		System.out.println("ȸ������ ���̵��: "+customer.getId()+" �Դϴ�.");
		System.out.println("ȸ������ ��й�ȣ��: "+customer.getPwd()+" �Դϴ�.");
		System.out.println("ȸ������ �޴��� ��ȣ��: "+customer.getTel()+" �Դϴ�.");
		System.out.println("ȸ������ �ּҴ�: "+customer.getAddress()+" �Դϴ�.");
	}

	// ��������
	public void changeQuantity(Product product, int num) {
		product.setQuantity(num);
		System.out.println(product.getPname() + "�� ������" + num + "���� �����Ͽ����ϴ�.");
	}

	public void add() {
	}

	// product array�� product �߰�.
	public void add(String pname, int pnumber, int price, int quantity, String kind) {
		productsArray.add(new Product(pname, pnumber, price, quantity, kind));
		save();
	}

	public void remove() {
	}

	// I/O�� ���� ����ȭ ����
	private void save() {
		File file = new File("ProductDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

			oos.writeObject(productsArray);
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
	void load() {
		File file = new File("ProductDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream oos = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

			productsArray = (ArrayList) oos.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ
			// ���ϰ��� Object�̹Ƿ� �ٿ�ĳ����

			oos.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}

}
