import java.util.Stack;

import kr.or.bit.Coin;

public class Ex05_Stack_Collection {

    public static void main(String[] args) {
        //Stack Ŭ����(LIFO)�� Java�� ����
        //Stack Ȱ�� > �������� ����
        
        
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        System.out.println(stack.pop()); //B�� ���� ����
        System.out.println(stack.pop()); //�� ���� A�� ����
        //System.out.println(stack.pop()); //���� �߻�
        System.out.println(stack.isEmpty());  //����ֳ� Ȯ��
        
        //�����ڽ�
        Stack<Coin> coinbox = new Stack<Coin>();
        coinbox.push(new Coin(100));
        coinbox.push(new Coin(50));
        coinbox.push(new Coin(500));
        coinbox.push(new Coin(100));
        
        while(!coinbox.isEmpty()) {
            Coin coin = coinbox.pop();
            System.out.println("���� ����: "+ coin.getValue()+"��");
        }
        
        
        
        
        
        
        
        
        
        
        

    }

}
