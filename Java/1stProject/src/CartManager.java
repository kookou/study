import java.util.HashMap;

class CartManager implements Manager{
	CustomerManager customer = new CustomerManager();
	HashMap<String, Cart> cartManage = new HashMap<String, Cart>();
	
	
	public void add() {
		cartManage.put(customer.customerList.get(key),new Cart()); //�� īƮ �߰�
	}
	public void remove() { //ȸ���� īƮ�� �����ϴ� ���� ������ remove�� ����...
		
	}
}