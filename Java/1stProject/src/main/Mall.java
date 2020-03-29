package main;

import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import user.*;
import manager.*;

public class Mall {

	Scanner sc = new Scanner(System.in);
	CustomerManager customerManager = new CustomerManager();
	ProductsManager productsManager = new ProductsManager();
	CartManager cartManager = new CartManager();
	TransactionManager transactionManager = new TransactionManager();
	Admin admin = new Admin();
	private static String id;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Mall.id = id;
	}

	Mall() {

		File file = new File("CustomerDB.txt");
		File file2 = new File("ProductDB.txt");
		File file3 = new File("CartDB.txt");
		File file4 = new File("TransactionDB.txt");

		if (file.exists()) {
			customerManager.load();
		} else {
			// customerList ���� ����
			try {
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

				CustomerManager.customerList.put(admin.getId(), admin);
				oos.writeObject(CustomerManager.customerList);
				// writeObject �޼��带 �̿��ؼ� ����ȭ ����
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("�����߻�!!!");
				e.printStackTrace();
			}
		}
		if (file2.exists()) {
			productsManager.load();
		} else {
			// productsArray ���� ����
			try {
				FileOutputStream fos = new FileOutputStream(file2);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

				oos.writeObject(productsManager.productList);
				// writeObject �޼��带 �̿��ؼ� ����ȭ ����
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("�����߻�!!!");
				e.printStackTrace();
			}
		}

		if (file3.exists()) {
			cartManager.load();
		} else {
			// productsArray ���� ����
			try {
				FileOutputStream fos = new FileOutputStream(file3);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

				oos.writeObject(cartManager.cartList);
				// writeObject �޼��带 �̿��ؼ� ����ȭ ����
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("�����߻�!!!");
				e.printStackTrace();
			}
		}

		if (file4.exists()) {
			transactionManager.load();
		} else {

			try {
				FileOutputStream fos = new FileOutputStream(file4);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

				oos.writeObject(transactionManager.transactionList);
				// writeObject �޼��带 �̿��ؼ� ����ȭ ����
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				System.out.println("�����߻�!!!");
				e.printStackTrace();
			}
		}
	}

	void mallMain() {
		while (true) {
			switch (mallMainMenu()) {
			case 1: {
				this.signIn();

				break;
			}
			case 2: {
				customerManager.signUp();
				break;
			}
			case 3: {
				System.exit(0);
			}

			}
		}
	}

	// �ʱ� �޴�
	int mallMainMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("***************************");
				System.out.println("*******VIP ���ý����*******");
				System.out.println("***************************");
				System.out.println("1. �α���");
				System.out.println();
				System.out.println("2. ȸ�� ����");
				System.out.println();
				System.out.println("3. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~3���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);
	}

	// �α���
	void signIn() {

		System.out.println("**�α���**");
		System.out.println("ID�� �Է����ּ���");
		System.out.print(">>");
		id = sc.nextLine();
		System.out.println("��й�ȣ�� �Է����ּ���");
		System.out.print(">>");
		String pwd = sc.nextLine();
		if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) {
			System.out.println("������ �α���");
			admin();

		} else if (customerManager.signIn(id, pwd) != null) {
			customer();

		} else {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}
	}

	void customer() {

		while (true) {
			switch (this.customerMenu()) {
			case 1: {
				productsManager.productList();
				addCart();
				break;
			}
			case 2: {
				cart();
				break;
			}
			case 3: {
				myPage();
				break;
			}
			case 4: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			case 5: {
				System.exit(0);
			}
			}
		}
	}

	// �� �޴� ȭ��
	int customerMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****�� �޴�*****");
				System.out.println("*********************************");
				System.out.println("1. ��ǰ ��� ��ȸ");
				System.out.println();
				System.out.println("2. ��ٱ���");
				System.out.println();
				System.out.println("3. ����������");
				System.out.println();
				System.out.println("4. ���� �޴���");
				System.out.println();
				System.out.println("5. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 5) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~5���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);
	}

	// ������ ���α׷�
	void admin() {

		while (true) {
			switch (this.adminMenu()) {
			case 1: {
				productsManager.productList();

				break;
			}
			case 2: {
				productsManager.add();
				break;
			}
			case 3: {
				productsManager.remove();
				break;
			}
			case 4: {
				productsManager.changeQuantity();
				break;
			}
			case 5: {
				customerManager.userList();
				break;
			}
			case 6: {
				lookup();
				break;
			}
			case 7: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			case 8: {
				System.exit(0);
			}
			}
		}
	}

	// ������ �޴� ȭ��
	int adminMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("******     ������ �޴�           ********");
				System.out.println("*********************************");
				System.out.println("1. ��ǰ ��� ��ȸ");
				System.out.println();
				System.out.println("2. ��ǰ �߰�");
				System.out.println();
				System.out.println("3. ��ǰ ����");
				System.out.println();
				System.out.println("4. ��ǰ ��� ����");
				System.out.println();
				System.out.println("5. ȸ�� ���� ��ȸ");
				System.out.println();
				System.out.println("6. �Ǹ� ���� ��ȸ");
				System.out.println();
				System.out.println("7. ���� �޴���");
				System.out.println();
				System.out.println("8. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 8) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~8���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	void lookup() {
		System.out.println("*�Ǹ� ���� ��ȸ");
		while (true) {
			switch (lookUpMenu()) {
			case 1: {
				transactionManager.userTransactionList();
				return;
			}
			case 2: {
				System.out.println("ȸ�� ���̵� �Է��ϼ���.");
				System.out.print(">>");
				String userId = sc.nextLine();
				transactionManager.userTransactionHistory(userId);
			}
			case 3: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			}
		}
	}

	int lookUpMenu() {
		int menu = 0;
		do {
			try {
				System.out.println("1. ��� ȸ�� ���� ����");
				System.out.println();
				System.out.println("2. Ư�� ȸ�� ���� ����");
				System.out.println();
				System.out.println("3. ���� �޴���");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 3) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~3���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	void addCart() {

		while (true) {
			switch (this.addCartMenu()) {
			case 1: {
				productsManager.productList();
				cartManager.add();
				break;
			}
			case 2: {
				cart();
				break;
			}
			case 3: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			case 4: {
				System.exit(0);
			}

			}
		}

	}

	// ��ǰ ��ȸ ������ �޴� ȭ��
	int addCartMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("1. ��ٱ��Ͽ� ��ǰ �߰�");
				System.out.println();
				System.out.println("2. ��ٱ���");
				System.out.println();
				System.out.println("3. ���� �޴���");
				System.out.println();
				System.out.println("4. �ý��� ����");
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 4) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~4���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	void cart() {
		System.out.println("**��ٱ���**");
		while (true) {

			cartManager.cartList.get(id).show();

			// ��ٱ��� �����ֱ�
			switch (this.cartMenu()) {
			case 1: {
				cartManager.buy();
				break;
			}
			case 2: {
				cartManager.remove();
				break;
			}
			case 3: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			case 4: {
				System.exit(0);
			}

			}
		}
	}

	// īƮ �޴� ȭ��
	int cartMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****��ٱ��� �޴�*****");
				System.out.println("*********************************");
				System.out.println("1. ��ٱ��� ��ǰ ����");
				System.out.println();
				System.out.println("2. ��ٱ��� ��ǰ ����");
				System.out.println();
				System.out.println("3. ���� �޴���");
				System.out.println();
				System.out.println("4. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 4) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~4���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	void myPage() {
		System.out.println("**����������**");
		while (true) {
			switch (this.myPageMenu()) {
			case 1: {
				customerManager.MyInfo();
				break;
			}
			case 2: {
				transactionManager.myTransactiontHistory();
				break;
			}
			case 3: {
				cart();

				break;
			}
			case 4: {
				return; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
			}
			case 5: {
				System.exit(0);
			}

			}

		}

	}

	// ���������� �޴� ȭ��
	int myPageMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****���� ������ �޴�*****");
				System.out.println("*********************************");
				System.out.println("1. �� ���� ��ȸ");
				System.out.println();
				System.out.println("2. �ֹ� ����");
				System.out.println();
				System.out.println("3. ��ٱ���");
				System.out.println();
				System.out.println("4. ���� �޴���");
				System.out.println();
				System.out.println("5. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 5) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~5���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	public static void main(String[] args) {

		Mall mall = new Mall();

		mall.mallMain();

	}
}
