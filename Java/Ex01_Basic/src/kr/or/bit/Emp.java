package kr.or.bit;

//����̶�� ���赵
//����� ������ ��� ����� ����ϴ� �Լ��� ������ ����
//class 155th {}

public class Emp {
	public int empno;
	//������ ��� ����, ����� ����� ������ �ִ�(��� : ����������)
	public String ename; //�̸�
	public String job; //����
	
	//���� > ����(������)�� ���� �� �ִ� > ��ȭ(��) > instance variable -> member field
	private int data;
	//ĸ��ȭ: �ڿ� ��ȣ
	//���� �Ҵ��� ���� ���� �Ҵ��� ���ؼ� ������ ��ȣ
	
	//���, ���� ���� > �Լ� > method
	public int getData() { //getter
		return data; 
	}	
	//��� > method > write
	public void setData(int input) { //setter �����͸� ��ȣ�� �� �ִ� Ư�� ������ �ɾ��ִ� ����
		if(input < 0) {
			data = 0;
		}else {data = input;
		}
	}
    // ĸ��ȭ�� �ڿ��� ���ؼ� read, write(getter, setter) �Լ� ����
	// �Լ��� �ݵ�� ȣ�⿡ ���ؼ��� ����
	public void getEmpInfo() {
		System.out.println(empno +"/" + ename + "/"+job);
	}
}	
