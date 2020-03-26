import java.io.Serializable;
import java.util.ArrayList;
 class Cart implements Manager, Serializable{

	int count;
	int totalprice;
	ArrayList<Product> cartArray;
	
	Cart(){
	    count=0;
	    totalprice=0;
	    cartArray= new ArrayList<Product>();
	}
	
//īƮ��� �����ִ�.................
	public void show() {
		System.out.println(cartArray.toString());
		count = cartArray.size();
		System.out.println("�� ������ ������ " + count + "�Դϴ�.");
		System.out.println("�� ������ " + totalprice + "�Դϴ�.");
	}
	
 //īƮ�� ���δ�Ʈ �߰�.
	public void add(Product product) {
		cartArray.add(product);
		count++;
	}

//īƮ�� ���δ�Ʈ ����.
	public void remove(Product product) { 

		for(int i=0;i<cartArray.size();i++) {
		if(cartArray.get(i)==product) { //cart�� �ش� product�� ������ �����Ѵ�.
			cartArray.remove(i);
			count--;
			totalprice-=cartArray.get(i).getPrice();
		}else {
			System.out.println("��ٱ��Ͽ� ���� ��ǰ�Դϴ�.");
			return;
		}
		} 	
		
	}
//**�������̽� ������ ���� ���̰�, parameter�� product �޴°� ���������� �ؼ� ���� �����ε� ��Ŵ**
		public void add() {			
		}
		public void remove() {			
		}
		@Override
		public String toString() {
			return "Cart [cartArray=" + cartArray + "]";
		}		
}