import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bank {
	private ArrayList<Account> accounts; // ����(0�� �̻�)
	private int totalAccount; // �� ���¼�
	private HashSet<String> accountNoSet;
	
	Scanner sc = new Scanner(System.in);

	Bank() {
		accounts = new ArrayList<Account>();
		totalAccount = 0;
		this.accountNoSet = new HashSet<String>();

	}

	// ���¸� �����Ѵ�
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		System.out.println("���¸� �����߽��ϴ�.");
		System.out.println("������ ����:" + new Account(accountNo, name));
		totalAccount++;
	}

	// ���¸� ã�´�(���¹�ȣ��)
	public Account getAccount(String accountNo) {
		for (Account acc : accounts) {
			if (acc.getAccountNo().equals(accountNo)) {
				System.out.printf("���¹�ȣ:%s ��(��) ��ġ�ϴ� ���� �߰�.\n", accountNo);
				System.out.println(acc);
				return acc;
			}
		}
		System.out.println("�ش� ���¹�ȣ�� ��ġ�ϴ� ���°� �����ϴ�.");
		return null;
	}

	// ���¸� ã�´�(�����ڸ�����)
	public ArrayList<Account> findAccounts(String name) {
		ArrayList<Account> list = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (acc.getName().equals(name)) {
				list.add(acc);
			}

		}
		if (list.size() != 0) {
			System.out.printf("�����ڸ�:%s ��(��) ��ġ�ϴ� ���� �߰�.\n", name);
			for (Account acc : list) {
				System.out.println(acc);
			}
		} else {
			System.out.println("�ش� �����ڸ�� ��ġ�ϴ� ���¸���� �����ϴ�.");
		}
		return list;
	}

	// ���¸���� ����
	public ArrayList<Account> getAccounts() {

		System.out.println("���� ���: ");
		for (Account acc : accounts) {
			System.out.println(acc);
		}
		return accounts;
	}

	// �Ѱ��¼��� ��ȯ�Ѵ�
	public int getTotalAccount() {
		System.out.printf("�� ���¼��� %d���Դϴ�.\n", totalAccount);
		return totalAccount;
	}
	
	// �α��ο� ���¸� ã�´�(���¹�ȣ��)
		public Account login(String accountNo) {
			for (Account acc : accounts) {
				if (acc.getAccountNo().equals(accountNo)) {
					return acc;
				}
			}
			System.out.println("�ش� ���¹�ȣ�� ��ġ�ϴ� ���°� �����ϴ�.");
			return null;
		}

	// ���α׷� ���� ����

	void program() {
		while (true) {
			switch (displayMenu()) {
			case 1: {
				this.programB();
				break;
			}
			case 2: {
				this.programA();
				break;
			}
			case 3: {
				System.exit(0);
			}

			}

		}
	}

	void programB() {
		outer: while (true) {
			switch (displayMenuB()) {
			case 1: {
				System.out.println("**���� ����**");
				System.out.println("�̸��� �Է����ּ���");
				String name = sc.nextLine();
				String accountNo="";
				while(true) {
				accountNo = (int)((Math.random() * 90000000) + 10000000)+"";
				if(!accountNoSet.contains(accountNo)) {
					break;
				}				
				}
				addAccount(accountNo, name);
				break;
			}
			case 2: {
				System.out.println("**���� ã��(���¹�ȣ��)**");
				System.out.println("���¹�ȣ�� �Է����ּ���");
				String accountNo = sc.nextLine();
				getAccount(accountNo);
				break;
			}
			case 3: {
				System.out.println("**���� ã��(������ ������)**");
				System.out.println("�̸��� �Է����ּ���");
				String name = sc.nextLine();
				findAccounts(name);
				break;
			}
			case 4: {
				System.out.println("**���� ��� ����**");
				getAccounts();
				break;
			}
			case 5: {
				System.out.println("**�� ���¼� ��ȯ**");
				getTotalAccount();
				break;
			}
			case 6: {
				break outer;
			}
			case 7: {
				System.exit(0);
			}

			}

		}
	}

	void programA() {
		System.out.println("���¹�ȣ�� �Է����ּ���");
		String accountNo = sc.nextLine();
		System.out.println("�̸��� �Է����ּ���");
		String name = sc.nextLine();
		if (login(accountNo).getName().equals(name)) {
			outer: while (true) {
				switch (this.displayMenuA()) {
				case 1: {
					System.out.println("**�Ա�**");
					System.out.println("�Աݾ��� �Է����ּ���");
					long amount = Integer.parseInt(sc.nextLine());
					getAccount(accountNo).deposit(amount);
					break;
				}
				case 2: {
					System.out.println("**���**");
					System.out.println("��ݾ��� �Է����ּ���");
					long amount = Integer.parseInt(sc.nextLine());
					getAccount(accountNo).withdraw(amount);
					break;
				}
				case 3: {
					System.out.println("**�ܰ� Ȯ��**");
					getAccount(accountNo).getBalance();
					break;
				}
				case 4: {
					System.out.println("**�ŷ� ���� ����**");
					getAccount(accountNo).getTransactions();
					break;
				}
				case 5: {
					break outer;
				}
				case 6: {
					System.exit(0);
				}

				}

			}
		}else {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}
	}

	// �ʱ� �޴�

	int displayMenu() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("***************************");
				System.out.println("*****���� ���� �ý��� �׽�Ʈ*****");
				System.out.println("***************************");
				System.out.println("1. ������");
				System.out.println();
				System.out.println("2. ����");
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

	int displayMenuB() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****���� ���� �ý��� �׽�Ʈ(������)*****");
				System.out.println("*********************************");
				System.out.println("1. ���� ����");
				System.out.println();
				System.out.println("2. ���� ã��(���� ��ȣ �̿�)");
				System.out.println();
				System.out.println("3. ���� ã��(�����ڸ� �̿�)");
				System.out.println();
				System.out.println("4. ���� ��� ����");
				System.out.println();
				System.out.println("5. �� ���¼� ����");
				System.out.println();
				System.out.println("6. ���� �޴���");
				System.out.println();
				System.out.println("7. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 7) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~7���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	int displayMenuA() {
		int menu = 0;
		do {
			try {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*****���� ���� �ý��� �׽�Ʈ(����)*****");
				System.out.println("*********************************");
				System.out.println("1. �Ա� �ϱ�");
				System.out.println();
				System.out.println("2. ��� �ϱ�");
				System.out.println();
				System.out.println("3. �ܰ� Ȯ��");
				System.out.println();
				System.out.println("4. �ŷ� ���� ����");
				System.out.println();
				System.out.println("5. ���� �޴���");
				System.out.println();
				System.out.println("6. �ý��� ����");
				System.out.println();
				menu = Integer.parseInt(sc.nextLine());
				if (1 <= menu && menu <= 6) {
					return menu;
				} else {
					throw new Exception("�޴� ���� ��ȣ�� �߸� �Ǿ����ϴ�");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<�Է� ����>");
				System.out.println("1~6���� �޴� �� �ϳ��� �����ϼ���");
			}
		} while (true);

	}

	public static void main(String[] args) {

		Bank bank = new Bank();

		bank.program();

//       //���� ����
//       System.out.println("**���� ����**");
//       bank.addAccount("00-0000-0001", "�ʱ�");
//       bank.addAccount("00-0000-0002", "����");
//       bank.addAccount("00-0000-0003", "�ʱ�");
//       
//       //���� ã��(���¹�ȣ��)
//       System.out.println("**���� ã��(���¹�ȣ��)**");
//       bank.getAccount("00-0000-0001");  //��ġ�ϴ� ���¹�ȣ �ִ� ���
//       bank.getAccount("99-9999-9999");  //��ġ�ϴ� ���¹�ȣ ���� ���

//       //���� ã��(������ ������)
//       System.out.println("**���� ã��(������ ������)**");
//       bank.findAccounts("�ʱ�");         //��ġ�ϴ� ���°� �ִ� ���  
//       bank.findAccounts("������");        //��ġ�ϴ� ���°� ���� ���
//      
//       //���¸�� ����
//       System.out.println("**���� ��� ����**");
//       System.out.println(bank.getAccounts());
//       
//       //�� ���¼� ��ȯ
//       System.out.println("**�� ���¼� ��ȯ**");
//       System.out.println(bank.totalAccount);

//       //�Ա�
//       System.out.println("**�Ա�**");
//       bank.accounts.get(0).deposit(10000L);
//       
//       //���
//       System.out.println("**���**");
//       bank.accounts.get(0).withdraw(5000L);
//       
//       //�ܰ� Ȯ��
//       System.out.println("**�ܰ� Ȯ��**");
//       bank.accounts.get(0).getBalance();
//       
//       //�ŷ����� Ȯ��
//       System.out.println("**�ŷ����� Ȯ��**");
//       bank.accounts.get(0).getTransactions();

	}

}
