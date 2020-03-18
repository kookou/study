import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

//Today POINT
public class Ex02_ArrayList1 {
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for(int i = 0 ; i < arraylist.size() ; i++) {
			System.out.println(arraylist.get(i));
		}
		
		System.out.println(arraylist.toString());
		
		System.out.println("Ư�� �濡 �ִ� �� : " + arraylist.get(0));
		//add ���������� ������ �ֱ�
		//arraylist.add overloading .... index , element
		arraylist.add(0,111); //[111, 100, 200, 300]
		System.out.println(arraylist.toString());
		arraylist.add(4,444);
		System.out.println(arraylist.toString());
		//��������� ������ �߰� , ����   >> ArrayList (������ �ִ� ������ ����)
		//[��������] ������ �߰� , ����  ^^
		
		//������ ���� (add)  : �߰� >> ������ ������ �̵� 
		//������ ���� ...
		//arraylist.remove(index)
		//arraylist.add(index, element);
		
		//ArrayList ������ �Լ� �н�
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(5555));
		
		System.out.println(arraylist.isEmpty()); //false �� ��� ���� �ʾ�
		//true >> size == 0
		arraylist.clear(); // size ==0
		System.out.println(arraylist.isEmpty());
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.toString());
		
		//���� remove()
		System.out.println("������ : " + arraylist.size());
		Object value = arraylist.remove(0); //0��° ���� ���� ����
		System.out.println("������ ������ : " + value);
		System.out.println(arraylist.toString());
		System.out.println("������ : " + arraylist.size());
		
		//POINT
		//������ ... �ϻ�ٹݻ� ..
		List li = new ArrayList();  //������ >> Ȯ�强 , ������
		//li.add(e)
		//ArrayList alist = new  ArrayList();
		li.add("��");
		li.add("��");
		li.add("��");
		li.add("��");
		
		List li4 =  li.subList(0, 2); //sublist ����� �ִ� �����Ͱ� .. ������ ������ ����
		System.out.println(li4.toString());
		
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(45);
		alist.add(3);
		alist.add(15);
		
		//Arrays.sort(a);
		System.out.println("before : " + alist.toString());
		Collections.sort(alist);  //Collections �ʺ������ڴ� ���� ..(x)
		System.out.println("after : " + alist.toString());
	    //[1, 3, 7, 15, 40, 45, 50]
		Collections.reverse(alist);
		System.out.println("after : " + alist.toString());
	
	}

}




























