package kr.or.bit;
/*
Tv ���赵 �䱸��������
Tv�� ä�� ������ ������ �ִ� (���� ��� 1~ 200 ���� ���� �� �ִ�)
Tv�� �귣�� �̸��� ������ �ִ� (���� ��� ����  , �Ｚ )
Tv�� ä�� ��ȯ ����� ������ �ִ�(ä���� �� ä�ξ� �̵��� �����ϴ�)
->ä���� ���� ��Ű�� ����� ������ �ִ�
->ä���� ���� ��Ű�� ����� ������ �ִ�
*/
public class Tv {
	public int ch;  //default >> 0
	public String brandname;  //default >> null
	
	//��� (����) ���� method
	public void ch_Up() {
		ch++;
	}
	
	public void ch_Down() {
		ch--;
	}
	
	//ch �� , brandname ���� ����ϴ� ��� �߰�
	public void tvPrint() {
		System.out.printf("[%s] , [%d] \n",brandname,ch);
	}
	
}










