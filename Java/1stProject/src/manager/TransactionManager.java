package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import entity.Transaction;
import main.Mall;

public class TransactionManager implements Manager {

	public static HashMap<String, ArrayList<Transaction>> transactionList = new HashMap<String, ArrayList<Transaction>>();

	static Scanner sc = new Scanner(System.in);

	// ��ü ȸ�� �ֹ� ���� ��ȸ
	public void userTransactionList() {
		Set<String> set = CustomerManager.customerList.keySet();
		ArrayList<String> arraySet = new ArrayList<String>(set);
		Collections.sort(arraySet);
		for (String c : arraySet) {
			if (transactionList.get(c) == null) {
				if (c.equals("admin")) {
					continue;
				}else {
				System.out.println("ȸ�� " + c + " ���� ���ų����� �����ϴ�.");
				}
			} else
				userTransactionHistory(c);
		}
	}

	// Ư�� ȸ�� �ֹ� ���� ��ȸ
	public void userTransactionHistory(String userId) {
		if (CustomerManager.customerList.containsKey(userId)) {
			if (transactionList.get(userId) == null) {
				System.out.println(userId + " ȸ������ �ŷ������� �����ϴ�.");
				return;
			} else {
				System.out.println(userId + " ���� �ŷ����� �Դϴ�.");
				System.out.println("--��ǰ��----��ǰ����----����----�ֹ��ڼ���-------�ŷ��Ͻ�-------");
				ArrayList list = transactionList.get(userId);
				for (Object e : list) {
					System.out.println(e);
				}
			}
		} else {
			System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
		}
	}

	// �� �ֹ� ���� ��ȸ
	public void myTransactiontHistory() {
		System.out.println("**�ֹ� ����**");
		String id = Mall.getId();

		if (transactionList.get(id) == null || transactionList.get(id).isEmpty()) {
			System.out.println("�ֹ� ������ �����ϴ�.");
		} else {
			System.out.println("--��ǰ��--��ǰ����--����----�ֹ��ڼ���-------�ŷ��Ͻ�-------");
			for (Object o : transactionList.get(id)) {
				System.out.println(o);
			}
		}
	}

	@Override
	public void add() {

	}

	@Override
	public void remove() {
	}

	@Override
	public String toString() {
		return "TransactionManager [transactionList=" + transactionList + "]";
	}

	// I/O�� ���� ����ȭ ����
	public void save() {
		File file = new File("TransactionDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // ����ȭ ������ ���� ������Ʈ��

			oos.writeObject(transactionList);
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
		File file = new File("TransactionDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

			transactionList = (HashMap) ois.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ

			ois.close();
			bis.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
}
