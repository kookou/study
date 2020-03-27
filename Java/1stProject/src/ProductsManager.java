import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ProductsManager implements Manager, Serializable{

    static HashMap<Integer, Product> productList = new HashMap<Integer, Product>();// ��ǰproducts array

    static Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "ProductsManager [productList=" + productList + "]";
    }

    // ��ǰ���� �����ֱ�
    public void productList() {

        Set<Integer> set = productList.keySet(); // ��ǰ��ȣ�� �� set�� ����Ǿ� �ְ�,
        System.out.println("----------VIP Product List-----------");
        System.out.println("    ����          ��ǰ��      ��ǰ��ȣ      ����     ����");
        for (Integer num : set) {
            String name = productList.get(num).getPname();
            int price = productList.get(num).getPrice();
            int quantity = productList.get(num).getQuantity();
            int number = productList.get(num).getPnumber();
            String kind = productList.get(num).getKind();
            System.out.printf("%7s %10s %5d %7d %3d", kind, name, number, price, quantity);
            System.out.println();
        }
        System.out.println("-------------------------------------");

    }

    // ���ų��� ********user Ŭ���� �ʿ�*******
    public void buyHistory() {

    }

    // ������ �����ҷ����� ******user Ŭ���� �ʿ�*****
    public void userInfo(Customer customer) {

        System.out.println("");
        System.out.println(customer.getName() + "ȸ���� �ȳ��ϼ��� ^^");
        System.out.println("ȸ������ ���̵��: " + customer.getId() + " �Դϴ�.");
        System.out.println("ȸ������ ��й�ȣ��: " + customer.getPwd() + " �Դϴ�.");
        System.out.println("ȸ������ �޴��� ��ȣ��: " + customer.getTel() + " �Դϴ�.");
        System.out.println("ȸ������ �ּҴ�: " + customer.getAddress() + " �Դϴ�.");
    }

    // ��������
    public void changeQuantity() {

        System.out.println("��ǰ ��� ����");
        productList();
        System.out.println("������ ��ǰ�� ��ȣ�� �Է��Ͻʽÿ�");
        int pKey = Integer.parseInt(sc.nextLine());
        int quantity = 0;
        if (productList.containsKey(pKey)) {
            System.out.println("������ ��ǰ�� ������ �Է��Ͻʽÿ�");
            quantity = Integer.parseInt(sc.nextLine());
            productList.get(pKey).setQuantity(quantity);
        } else {
            System.out.println("�߸� �Է��ϼ̽��ϴ�.");
        }
        System.out.println(productList.get(pKey).getPname() + "�� ������" + quantity + "���� �����Ͽ����ϴ�.");
        save();
        productList();
    }

    public void add() {
        System.out.println("**��ǰ �߰�**");
        System.out.println("��ǰ���� �Է����ּ���");
        String pname = sc.nextLine();
        System.out.println("��ǰ��ȣ�� �Է����ּ���");
        int pnumber = Integer.parseInt(sc.nextLine());
        System.out.println("��ǰ ������ �Է����ּ���");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("��ǰ ������ �Է����ּ���");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("��ǰ ������ �Է����ּ���");
        String kind = sc.nextLine();
        productList.put(pnumber, new Product(pname, pnumber, price, quantity, kind));
        save();
        productList();
        System.out.println("��ǰ�� �߰��Ǿ����ϴ�.");
    }

    public void remove() {
        productList();
        System.out.println("������ ��ǰ��ȣ�� �Է����ּ���");
        int pnumber = Integer.parseInt(sc.nextLine());
        if (productList.containsKey(pnumber)) {
            productList.remove(pnumber);
            productList();
            System.out.println("��ǰ�� �����Ǿ����ϴ�.");
            save();
        }else {
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
        System.out.println("����Ǿ����ϴ�.");
    }

    // I/O�� ���� ������ȭ �ε�
    public void load() {
        File file = new File("ProductDB.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis); // ������ȭ�� ���� ������Ʈ��

            productList = (HashMap) ois.readObject(); // readObject�޼��带 �̿��ؼ� ������ȭ
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
