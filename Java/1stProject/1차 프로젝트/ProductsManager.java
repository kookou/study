import java.util.ArrayList;


public class ProductsManager implements Manager{
 
	public static void main(String[] args) {

		ArrayList<Product> productsArray = new ArrayList();//��ǰproducts array
		
		productsArray.add(new Product("������",210321,2000,10));
		productsArray.add(new Product("������1",210321,2000,10));
		productsArray.add(new Product("������2",210321,2000,10)); //product array�� product �߰�.				
		
	}	
	
	//��ǰ���� �����ֱ�
	public void productsList(ArrayList arraylist) {
		for(Object d: arraylist) { //product array�� �����ְ� �ʹ�.
		System.out.println(d);
		}
	}	
	//���ų��� ********user Ŭ���� �ʿ�*******
	public void buyHistory() {
	
		}
	//������ �����ҷ����� ******user Ŭ���� �ʿ�*****
	public void userInfo() {
		
	}
	//��������
	public void changeQuantity(Product product,int num) {
		product.setQuantity(num);
		System.out.println(product.getPname()+"�� ������"+num+"���� �����Ͽ����ϴ�.");
	}	
	// ****������� �𸣰���****
	public void add() {
	}
	public void remove() {	
	}
	
}

class Product{
	private int price;
	private int pnumber;
	private int quantity;
	private String pname;
	Product(){}
	Product(String pname,int pnumber,int price,int quantity) {
		this.price = price;
		this.pname = pname;
		this.pnumber= pnumber;
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Product [price=" + price + ", pnumber=" + pnumber + ", quantity=" + quantity + ", pname=" + pname + "]";
	}
}
class Iphone extends Product{
	
}
class Macbook extends Product{
	
}
class Ipad extends Product{
	
}
