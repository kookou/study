import java.util.Scanner;
import java.awt.font.TextLayout.CaretPolicy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class Mall {

    Scanner sc = new Scanner(System.in);
    CustomerManager customerManager = new CustomerManager();
    ProductsManager productsManager = new ProductsManager();
    CartManager cartManager = new CartManager();
    TransactionManager transactionManager = new TransactionManager();
    Admin admin = new Admin();
    static String id;
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

    void program() {
        while (true) {
            switch (MainMenu()) {
            case 1: {
                this.signInProgram();

                break;
            }
            case 2: {
                this.signUpProgram();
                break;
            }
            case 3: {
                System.exit(0);
            }

            }

        }
    }
    
    // �ʱ� �޴�
    int MainMenu() {
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

    // ȸ������
    void signUpProgram() {
        System.out.println("ȸ�� ����");
        System.out.println("ID�� �Է����ּ���");
        String id = sc.nextLine();
        System.out.println("��й�ȣ�� �Է����ּ���");
        String pwd = sc.nextLine();
        System.out.println("�̸��� �Է����ּ���");
        String name = sc.nextLine();
        System.out.println("��ȭ��ȣ�� �Է����ּ���");
        String tel = sc.nextLine();
        System.out.println("�ּ����� �Է����ּ���");
        String address = sc.nextLine();
        customerManager.signUp(id, pwd, name, tel, address); // ������� customer ��ü�� ����
    } // ȸ������ ��ġ�� �α��� ���� ȭ������ �����ؾ� �Ѵ�

  
    // �α���
    void signInProgram() {

        System.out.println("**�α���**");
        System.out.println("ID�� �Է����ּ���");
        id = sc.nextLine();
        System.out.println("��й�ȣ�� �Է����ּ���");
        String pwd = sc.nextLine();
        if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) {
            System.out.println("������ �α���");
            AdminProgram();

        } else if (customerManager.signIn(id, pwd) != null) {
            CustomerProgram();

        } else {
            System.out.println("��ġ�ϴ� ������ �����ϴ�.");
        }
    }

    void CustomerProgram() {

        outer: while (true) {
            switch (this.CustomerMenu()) {
            case 1: {
                System.out.println("**��ǰ��ȸ**");
                productsManager.productList();
                buyProgram();
                break;
            }
            case 2: {
                System.out.println("**��ٱ���**");
                CartProgram();
                break;
            }
            case 3: {
                System.out.println("**����������**");
                MyPageProgram();

                break;
            }

            case 4: {
                break outer; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }
    
    // �� �޴� ȭ��
    int CustomerMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****�� �޴�*****");
                System.out.println("*********************************");
                System.out.println("1. ��ǰ ����Ʈ ��ȸ");
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
    
    //������ ���α׷�
    void AdminProgram() {

        outer: while (true) {
            switch (this.AdminMenu()) {
            case 1: {
                productsManager.productList();

                break;
            }
            case 2: {                
                productsManager.add();
                break;
            }
            case 3: {
                System.out.println("**��ǰ ����**");
                productsManager.remove();
                break;
            }
            case 4: {
                System.out.println("**��ǰ ��� ����**");
                productsManager.changeQuantity();
                break;
            }
            case 5: {
                System.out.println("**ȸ�� ����Ʈ ��ȸ**");
                customerManager.userList();
                break;
            }

            case 6: {
                break outer; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
            }
            case 7: {
                System.exit(0);
            }

            }

        }

    }
    
    // ������ �޴� ȭ��
    int AdminMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****�α��� �޴�*****");
                System.out.println("*********************************");
                System.out.println("1. ��ǰ ����Ʈ ��ȸ");
                System.out.println();
                System.out.println("2. ��ǰ �߰�");
                System.out.println();
                System.out.println("3. ��ǰ ����");
                System.out.println();
                System.out.println("4. ��ǰ ��� ����");
                System.out.println();
                System.out.println("5. ȸ�� ���� ��ȸ");
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
                System.out.println("1~5���� �޴� �� �ϳ��� �����ϼ���");
            }
        } while (true);

    }
        
    void buyProgram() {
        
        outer: while (true) {
            switch (this.BuyMenu()) {
            case 1: {
                System.out.println("**��ٱ��Ͽ� ��ǰ �߰�**");
                
                cartManager.add();    

                break;
            }
            case 2: {
                System.out.println("**��ٱ���**");
                CartProgram();
                break;
            }
            case 3: {
                break outer; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
            }
            case 4: {
                System.exit(0);
            }

            }
        }

    }
    

    // ��ǰ ��ȸ ������ �޴� ȭ��
    int BuyMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.printf("1. ��ٱ��Ͽ� ��ǰ �߰�    2.��ٱ���   3.���� �޴���   4.�ý��� ����\n");

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
    

    

    void CartProgram() {
    	
        outer: while (true) {
        	cartManager.cartList.get(id).show();
           
            switch (this.CartMenu()) {
            case 1: {
                System.out.println("**��ٱ��� ��ǰ ����**");
                cartManager.buy();
                break;
            }
            case 2: {
                System.out.println("**��ٱ��� ����**");
                cartManager.remove();
                break;
            }

            case 3: {
                break outer; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
            }
            case 4: {
                System.exit(0);
            }

            }

        }

    }
    
    // īƮ �޴� ȭ��
    int CartMenu() {
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

    void MyPageProgram() {

        outer: while (true) {
            switch (this.MyPageMenu()) {
            case 1: {
                System.out.println("**�� ���� ��ȸ**");
                customerManager.MyInfo();
                break;
            }
            case 2: {
                System.out.println("**�ֹ� ����**");
                customerManager.watchBuyHistory();
                break;
            }
            case 3: {
                System.out.println("**��ٱ���**");
                CartProgram();
                
                break;
            }

            case 4: {
                break outer; // return�ϸ� �ش��ϴ� ���� ���� �޼��� �� Ż��
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }


    // ���������� �޴� ȭ��
    int MyPageMenu() {
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

        mall.program();

    }

}
