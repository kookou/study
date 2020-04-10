package Template_Method;

public abstract class HouseTemplate {
	
	//final�������� Override ����
	//�ѹ��� �����ϱ� ���ؼ� �޼ҵ� ���� �� �Լ� ȣ��
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built");
	}
	
	//�⺻���� ���� �Ǵ� �޼ҵ� 
	public void buildWindows() {
		System.out.println("Bilding Glass Windows");
	}
	
	//����Ŭ�������� ���� ������ �޼ҵ� 
	public abstract void buildWalls();
	public abstract void buildPillars();

	//�⺻���� ���� �Ǵ� �޼ҵ�
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
}