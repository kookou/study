
/*
���� Ǯ�� ������ ^^
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� ��� ������ǰ�� ���� �� �ִ� 
īƮ�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... īƮ�� ��´�

���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ���
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���

hint) īƮ ������ ��� ���� (Buy())
hint) Buyer ..>> summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�
*/
class Product2 {
    int price;
    int bonuspoint;

    // Product2() {}
    Product2(int price) {
        this.price = price;
        this.bonuspoint = (int) (this.price / 10.0);
    }
}

class KtTv2 extends Product2 {
    KtTv2() {
        super(500);
    }

    @Override
    public String toString() {
        return "KtTv2";
    }
}

class Audio2 extends Product2 {
    Audio2() {
        super(100);
    }

    @Override
    public String toString() {
        return "Audio2";  
    }
}

class NoteBook2 extends Product2 {
    NoteBook2() {
        super(150);
    }

    @Override
    public String toString() {
        return "NoteBook2";
    }
}

class Buyer2 { // ������
    int money;
    int bonuspoint;
    Product2[] cart; // īƮ
    int index;

    Buyer2() {
        this(1000, 0);

    }

    Buyer2(int money, int bonuspoint) {
        this.money = money;
        this.bonuspoint = bonuspoint;
        cart = new Product2[10];
    }

    // ���ű�� �ȿ� ��ٱ���(cart) �ִ� ��� ���� �����ϼ���
    void Buy(Product2 product) {
        if (this.money < product.price) {
            System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
            return; // �Լ����� > kttvBuy Ż�� (���� ���� ����)
        }
        // Cart ���� ����
        if (this.index >= 10) {
            System.out.println("[���� �׸� �缼��]");
            return;
        }
        // ��ٱ��� ���        
        cart[index++] = product;

        // �� ���� ����
        this.money -= product.price; // �ܾ�
        this.bonuspoint += product.bonuspoint; // ����
        System.out.println("������ ������ : " + product.toString());
        System.out.println("�ܾ� : " + this.money);
        System.out.println("����Ʈ : " + this.bonuspoint);

    }

    // ���� (��ٱ���)
    // ��ٱ��Ͽ� ��� ������ ���
    // ������ �Ѿ�
    // ������ ��� ���
    void Summary() {
//	        for (Product2 p : cart) {             // ������ ���� ���� �迭 ��Ұ��� null�̿��� java.lang.NullPointerException ���� �߻�
                                                  // ��, null�� ���� ��Ҹ� ȣ���ϴ� ���� �Ǽ� ���� �߻��� �� (null.toString(),null.price)
//	            System.out.printf("�̸�: %s, ����: %d\n",p.toString(),p.price);	           
//	        } System.out.println(1000-money);
        int totalPrice = 0;
        int totalBounsPoint = 0;
        String productList = "";

        for (int i = 0; i < index; i++) { // index ����(īƮ�� ������ �־��� ���̷� ������ �ִ°� ����Ʈ)
            totalPrice += cart[i].price;
            totalBounsPoint += cart[i].bonuspoint;
            productList += cart[i].toString() + " ";
        }

        System.out.println("*******************");
        System.out.println("������ ���� ���: " + productList);
        System.out.println("������ ���� �Ѿ�: " + totalPrice);
        System.out.println("���� ����Ʈ �հ�: " + totalBounsPoint);

    }

}

public class Ex13_Inherit_KeyPoint_Override_Array {
    public static void main(String[] args) {

        KtTv2 ktTv2 = new KtTv2();
        Audio2 audio2 = new Audio2();
        NoteBook2 noteBook2 = new NoteBook2();

        Buyer2 buyer2 = new Buyer2();

        buyer2.Buy(noteBook2);
        buyer2.Buy(audio2);
        buyer2.Buy(ktTv2);

        buyer2.Summary();

    }

}
