import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Cart implements Serializable {

    int count;
    int totalprice;
    HashMap<Product, Integer> cartArray;  //Integer�� ���� ������

    Cart() {
        count = 0;
        totalprice = 0;
        cartArray = new HashMap<Product, Integer>();
    }

    // īƮ��� �����ֱ�
    public void show() {
        count=0;
        Set<Product> set= cartArray.keySet();
        //���2
        System.out.println("==========================��ٱ��� ����Ʈ==========================");
        System.out.println("       ��ǰ��    ����    ����        �ջ갡��              ");
        for(Product p : set) {
    
  
            System.out.printf("%10s %10s %5s %10s",p.getPname(), p.getPrice(), cartArray.get(p), p.getPrice()*cartArray.get(p));
            System.out.println();
            count +=cartArray.get(p);
        }
        
        

        
        System.out.println("�� ������ ������ " + count + "�Դϴ�.");
        System.out.println("�� ������ " + totalprice + "�Դϴ�.");
    }


    }


