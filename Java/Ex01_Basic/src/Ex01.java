import kr.or.bit.Emp;

public class Ex01 {

	public static void main(String[] args) {
		//System.out.println("Hello World"); ���� �ּ�
		Emp emp = new Emp();
		emp.empno = 1000;
		emp.ename = "ȫ�浿";
		emp.job = "����";
      //emp.data = 10; //ĸ��ȭ �Ǿ� �־� ���� ȣ�� �Ұ�
		
		emp.setData(10); //setter 
		System.out.println(emp.getData());
		emp.getEmpInfo();
		
		Emp emp2 = new Emp();
		emp2.empno = 2000;
		emp2.ename = "������";
		emp2.job = "����";
		emp2.getEmpInfo(); 
		
	}

}
