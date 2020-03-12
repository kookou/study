
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

class Product3 {
    int price;
    int bonuspoint;

    Product3() {
        this(100);
    }

    Product3(int price) {
        this.price = price;
        this.bonuspoint = (int) (price / 10.0);
    }

}

class Tv extends Product3 {

    Tv() {
        super(300);
    }

    @Override
    public String toString() {
        return "Tv";
    }

}

class Audio extends Product3 {

    Audio() {
        super(100);
    }

    @Override
    public String toString() {
        return "Audio";
    }

}

class Buyer3 {
    int money;
    int bonusPoint;
    Product3[] cart;
    int index;

    Buyer3() {
        this(10000, 0);
    }

    Buyer3(int money, int bonusPoint) {
        this.money = money;
        this.bonusPoint = bonusPoint;
        cart = new Product3[10];
    }

    void buy(Product3 product) {
        if (this.money < product.price) {
            System.out.println("�ܾ��� �����մϴ�.");
            return;
        }

        if (this.index >= 10) {
            System.out.println("�� �̻� īƮ�� ���� �� �����ϴ�.");
            return;
        }
        this.cart[index++] = product;
        this.money -= product.price;
        this.bonusPoint += product.bonuspoint;
        System.out.printf("������ ��ǰ: %s ��ǰ ����: %d\n", product.toString(), product.price);
        System.out.println("ȹ�� ����Ʈ: " + this.bonusPoint);

    }

    void summary() {
        int totalPrice = 0;
        int totalBonusPoint = 0;
        String productList = "";

        for (int i = 0; i < index; i++) {
            totalPrice += cart[i].price;
            totalBonusPoint += cart[i].bonuspoint;
            productList += cart[i].toString() + " ";

            System.out.println("�� ���� ���: " + productList);
            System.out.println("�� ���� �ݾ�: " + totalPrice);
            System.out.println("���� ����Ʈ: " + totalBonusPoint);

        }

    }

}

public class Inherit_Polymorphism_ex {

    public static void main(String[] args) {

        Tv tv = new Tv();
        System.out.println(tv.toString());

        Audio audio = new Audio();
        System.out.println(audio.toString());

        Buyer3 buyer3 = new Buyer3();
        buyer3.buy(tv);
        buyer3.buy(audio);

        buyer3.summary();

    }

}
