import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ex02_ArrayList {

    public static void main(String[] args) {
        ArrayList arraylist = new ArrayList();
        
        arraylist.add(100);
        arraylist.add(200);
        arraylist.add(300);
        
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
            
        }
        
        System.out.println(arraylist.toString()); //toString ���� ����
        
        System.out.println("Ư�� �濡 �ִ� ��: "+ arraylist.get(0));
        //add ���������� ������ �ֱ�
        //arraylist.add �� �����ε� �Ǿ� ���� 
        arraylist.add(0,111);           //0��° �ڸ��� 111 ���� >> 0��° index ��Ұ� ������ �ƴ϶� �ϳ��� �ڷ� �з�����
        System.out.println(arraylist);  //[111, 100, 200, 300]
        arraylist.add(4,444);
        System.out.println(arraylist);
        
        //��������� ������ �߰�, ������ �ϰ� �Ǹ� ���� ������
        //arraylist.remove(index)
        //arraylist.add(index, element) 
        
        //������ ������ �߰�, ������ ��︲
        
        System.out.println(arraylist.contains(200));  //true
        
        System.out.println(arraylist.isEmpty()); //size�� 0�̸� true
        
        arraylist.clear(); //siez ==0
        
        System.out.println(arraylist.isEmpty()); //true
 
        arraylist.add(101);
        arraylist.add(102);
        arraylist.add(103);
        System.out.println(arraylist);
        
        //���� remove()
        System.out.println("���� �� : "+arraylist.size());
        Object value = arraylist.remove(0); //0��° ���� ���� ����. ���� ����(�����)
        System.out.println("������ ������ : "+value);
        System.out.println(arraylist);
        System.out.println("���� �� : "+arraylist.size()); 
        
        //Point
        //������ �� �ϻ�ٹݻ�
        //ArrayList alist = new ArrayList(); //�̷��� ���� �ʰ�
        List li = new ArrayList();  //ArrayList�� List �������̽��� ������ ���̹Ƿ� ������ >> Ȯ�强, ������ ����
        li.add("��");
        li.add("��");
        li.add("��");
        li.add("��");
        
        //sublist �ش� ���� �迭�� �迭�� �����Ͽ� �θ�Ÿ������ ����
        List li4 = li.subList(0, 2); 
        System.out.println(li4);
        
        
        //Collections.sort()
        ArrayList alist = new ArrayList();
        alist.add(50);
        alist.add(1);
        alist.add(7);
        alist.add(40);
        alist.add(45);
        alist.add(3);
        alist.add(15);
        
        System.out.println("before : "+alist);
        Collections.sort(alist); //Collections �ʺ������ڴ� �������� > �Ƿ��� �ȴ�
        System.out.println("after : "+alist);
        Collections.reverse(alist);   //�� ������ ������, ���ĵ� ����Ʈ�� �������� ���� ����
        System.out.println("reverse: "+alist);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        

    }

}
