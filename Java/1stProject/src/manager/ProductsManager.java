package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import entity.Product;

public class ProductsManager implements Manager {

	public static HashMap<Integer, Product> productList = new HashMap<Integer, Product>();// ��ǰproducts array

	static Scanner sc = new Scanner(System.in);

	@Override
	public String toString() {
		return "ProductsManager [productList=" + productList + "]";
	}

	// ��ǰ���� �����ֱ�
	public void productList() {
		System.out.println("**��ǰ ��� ��ȸ**");
		Set<Integer> set = productList.keySet();
		System.out.println("----------VIP Product List-----------");
		System.out.println("    ����          ��ǰ��      ��ǰ��ȣ          ����              ����");
		for (Integer num : set) {
			String name = productList.get(num).getPname();
			int price = productList.get(num).getPrice();
			String pFormat = String.format("%,d", price);
			int quantity = productList.get(num).getQuantity();
			String qFormat = String.format("%,d", quantity);
			int number = productList.get(num).getPnumber();
			String kind = productList.get(num).getKind();
			System.out.printf("%5s %10s %7d %10s %5s", kind, name, number, pFormat, qFormat);
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}

	// ��������
	public void changeQuantity() {
		do {
			try {

				System.out.println("**��ǰ ��� ����**");
				productList();
				System.out.println("������ ��ǰ�� ��ȣ�� �Է��Ͻʽÿ�");
				System.out.print(">>");
				int pKey = Integer.parseInt(sc.nextLine());
				int quantity = 0;
				if (productList.containsKey(pKey)) {
					System.out.println("������ ��ǰ�� ������ �Է��Ͻʽÿ�");
					System.out.print(">>");
					quantity = Integer.parseInt(sc.nextLine());
					productList.get(pKey).setQuantity(quantity);
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					continue;
				}
				String qFormat = String.format("%,d", quantity);

				System.out.println(productList.get(pKey).getPname() + "�� ������ " + qFormat + "���� �����Ͽ����ϴ�.");
				save();
				productList();
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է°����մϴ�.");
			}
		} while (true);
	}

	// ��ǰ �߰�
	public void add() {
		System.out.println("**��ǰ �߰�**");
		String pname;
		int pnumber, price, quantity;

		// ��ǰ�� �Է�
		outer: while (true) {
			System.out.println("��ǰ���� �Է����ּ���.");
			System.out.print(">>");
			pname = sc.nextLine();
			Set<Integer> pset = productList.keySet();
			if (pset.isEmpty()) {
				break;
			}
			for (int p : pset) {
				if (productList.get(p).getPname().equals(pname)) {
					System.out.println("�̹� �����ϴ� ��ǰ���Դϴ�.");
				} else {
					break outer;
				}
			}
		}

		// ��ǰ ��ȣ �Է�
		do {
			try {
				System.out.println("��ǰ ��ȣ�� �Է����ּ���.");
				System.out.print(">>");
				pnumber = Integer.parseInt(sc.nextLine());
				if (productList.containsKey(pnumber)) {
					System.out.println("�̹� �����ϴ� ��ǰ ��ȣ�Դϴ�.");
				} else if (pnumber < 1) {
					System.out.println("��ǰ ��ȣ�� ����� �����մϴ�.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("��ǰ ��ȣ�� ���ڸ� �����մϴ�.");
			}
		} while (true);

		// ��ǰ ���� �Է�
		do {
			try {
				System.out.println("��ǰ ���ݸ� �Է����ּ���.");
				System.out.print(">>");
				price = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("��ǰ ������ ���ڸ� �����մϴ�.");
			}
		} while (true);

		// ��ǰ ���� �Է�
		do {
			try {
				System.out.println("��ǰ ������ �Է����ּ���.");
				System.out.print(">>");
				quantity = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("��ǰ ������ ���ڸ� �����մϴ�.");
			}
		} while (true);

		// ��ǰ ���� �Է�
		System.out.println("��ǰ ������ �Է����ּ���");
		System.out.print(">>");
		String kind = sc.nextLine();
		productList.put(pnumber, new Product(pname, pnumber, price, quantity, kind));
		save();
		productList();
		System.out.println("��ǰ�� �߰��Ǿ����ϴ�.");
	}

	// ��ǰ ����
	public void remove() {
		int pnumber;
		do {
			try {
				System.out.println("**��ǰ ����**");
				productList();
				System.out.println("������ ��ǰ��ȣ�� �Է����ּ���");
				System.out.print(">>");
				pnumber = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("��ǰ ��ȣ�� ���ڸ� �����մϴ�.");
			}
		} while (true);
		if (productList.containsKey(pnumber)) {
			productList.remove(pnumber);
			productList();
			System.out.println("��ǰ�� �����Ǿ����ϴ�.");
			save();
		} else {
			System.out.println("��ġ�ϴ� ��ǰ��ȣ�� �����ϴ�.");
		}
	}

	// I/O�� ���� ����ȭ ����
	public void save() {
		File file = new File("ProductDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

			oos.writeObject(productList);
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
		File file = new File("ProductDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

			productList = (HashMap) ois.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ

			ois.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
}
