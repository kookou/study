package Template_Method;

public class Main {

	public static void main(String[] args) {
		
		//���ø� �޼ҵ� ���(Wooden House)
		//�θ�Ŭ���� Ÿ���� ������ �ڽ� Ŭ������ �ּҰ� �Ҵ� 
		HouseTemplate houseType = new WoodenHouse();
		
		houseType.buildHouse();
		
		//���м� ���� 
		System.out.println();
		System.out.println("***************");
		System.out.println();
		
		//���ø� �޼ҵ� ���(Glass House)
		//�ּҰ� �� �Ҵ� 
		houseType = new GlassHouse();
		
		houseType.buildHouse();
	}
}