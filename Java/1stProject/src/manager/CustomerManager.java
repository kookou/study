package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import entity.*;
import main.Mall;
import user.*;

public class CustomerManager implements Manager, Serializable {

	public static HashMap<String, User> customerList = new HashMap<String, User>();

	static Scanner sc = new Scanner(System.in);

	// ȸ�� ����
	public Customer signUp() {
		System.out.println("ȸ�� ����");
		String id, pwd, name, tel, address;

		// ID �Է�
		while (true) {
			System.out.println("ID�� �Է����ּ���. (5~20��. ���� ��ҹ���, ����, _ �� ��밡��)");
			System.out.print(">>");
			String regExpaa = "^[a-zA-Z0-9_]{5,20}+$";
			id = sc.nextLine();
			Mall.setId(id);
			boolean b = id.matches(regExpaa); // true ,false

			if (b == true) {
				if (CustomerManager.customerList.containsKey(id)) {
					System.out.println("�̹� �����ϴ� ID�Դϴ�.");
				} else {
					break;
				}

			} else {
				System.out.println("������ �߸��Ǿ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}

		// ��й�ȣ �Է�
		while (true) {
			System.out.println("��й�ȣ�� �Է����ּ���. (8~20��.��� �ϳ��� ����빮�� �ҹ���,����,Ư�����ڰ� ���� ���ԵǾ�� ��)");
			System.out.print(">>");
			String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
			;

			pwd = sc.nextLine();

			boolean b = pwd.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("������ �߸��Ǿ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
		// �̸� �Է�
		while (true) {
			// ID �Է�
			System.out.println("�̸��� �Է����ּ���. (�ѱ۸� ��밡��)");
			System.out.print(">>");
			String regExp = "^[��-����-�R]+$";

			name = sc.nextLine();

			boolean b = name.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("������ �߸��Ǿ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}

		// �޴��� ��ȣ �Է�
		while (true) {
			// ID �Է�
			System.out.println("�޴��� ��ȣ�� �Է����ּ���. ex) 010-123(4)-1234)");
			System.out.print(">>");
			String regExp = "(01[01679]{1})-(\\d{3,4})-(\\d{4})";

			tel = sc.nextLine();

			boolean b = tel.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("������ �߸��Ǿ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}

		// ����� �ּ� �Է�
		System.out.println("����� �ּҸ� �Է����ּ���");
		System.out.print(">>");
		address = sc.nextLine();

		Customer customer = new Customer(id, pwd, name, tel, address);
		customer.setId(id);
		customer.setPwd(pwd);
		customer.setName(name);
		customer.setTel(tel);
		customer.setAddress(address);

		customerList.put(id, customer);
		save();
		// ���� �� īƮ ����
		CartManager cartManager = new CartManager();
		cartManager.cartList.put(id, new Cart());
		cartManager.save();

		// ���� �� �ŷ����� �迭 ����
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.transactionList.put(id, new ArrayList<Transaction>());
		transactionManager.save();
		return customer;
	}

	public Customer signIn(String id, String pwd) {

		if (customerList.containsKey(id) && ((customerList.get(id).getPwd()).equals(pwd))) {

			System.out.println("�α��� ����");
			Mall.setId(id);
			return (Customer) customerList.get(id);
		} else {
			System.out.println("�α��� ����");
			return null;
		}
	}

	// ������ �޴� >> ȸ�� ���� ��ȸ
	public void userList() {
		System.out.println("**ȸ�� ��� ��ȸ**");

		Set<String> set = customerList.keySet();
		ArrayList<String> arraySet = new ArrayList<String>(set);
		Collections.sort(arraySet);
		System.out.println("==========================Vip�����==========================");
		System.out.println("       ID    Password    ����           �޴��� ��ȣ                     �����");

		for (String c : arraySet) {
			if (c.equals("admin")) {
				continue;
			}
			Customer user = (Customer) (customerList.get(c));
			System.out.printf("%10s %10s %5s %15s %17s", user.getId(), user.getPwd(), user.getName(), user.getTel(),
					user.getAddress());
			System.out.println();
		}
	}

	// ���������� >> �� ���� ��ȸ
	public void MyInfo() {
		System.out.println("**�� ���� ��ȸ**");
		do {
			try {
				System.out.println("��й�ȣ�� �Է��Ͻʽÿ�");
				System.out.print(">>");
				String password = sc.nextLine();
				if (customerList.get(Mall.getId()).getPwd().equals(password)) {
					Customer my = (Customer) customerList.get(Mall.getId()); // (user)Ÿ������ �ִ� value�� �ٿ�ĳ�����ʿ�.
					System.out.printf("[�̸� : %s]\n[���̵� : %s]\n[��й�ȣ : %s]\n[��ȭ��ȣ : %s]\n[�ּ� : %s]\n", my.getName(),
							my.getId(), my.getPwd(), my.getTel(), my.getAddress());
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

	public String toString() {
		return null;
	}

	@Override
	public void add() {
	}

	@Override
	public void remove() {
	}

	// I/O�� ���� ����ȭ ����
	public void save() {
		File file = new File("CustomerDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

			oos.writeObject(customerList);
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
		File file = new File("CustomerDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream oos = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

			customerList = (HashMap) oos.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ
			// ���ϰ��� Object�̹Ƿ� �ٿ�ĳ����

			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}

}