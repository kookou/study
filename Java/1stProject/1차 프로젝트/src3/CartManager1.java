import java.util.HashMap;
import java.util.Map;

class CartManager extends Cart implements Manager {
	//CustomerManager customer = new CustomerManager();

	HashMap<String, Cart> cartManager = new HashMap<String, Cart>();
	User user = new User();
	
	public void add() {
		cartManager.put(user.getId(),new Cart()); //user�� id����, ���ο� īƮ ����.
	}
	public void remove() { //ȸ���� īƮ ��ü�� �����ϴ� ���� ������ remove�� ����...
		
	}
	
	
}

