import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*Collection Framework
 * ������ �ڿ��� ���� ���������� �����ؼ� ���� �����ϴ� ǥ�� ����
 * Iterator �������̽�
 * 1. hasNext(), Next() ... �̷� �̸����� �����϶�� ����
 * 2. Collection {public Iterator iterator();} >> List ��� >> ArrayList ����
 * >> Collection �������̽��� Iterator �������̽��� ��ȯ�ϴ� iterator��� �߻�޼��带 ������ �ְ�, �̸� ArrayList���� ����
 *  >>hasNext(), Next(), remove() >> ������ ����
 * 3.ListIterator : ����� ����(Iterator ���� ����) > ������ read ǥ��ȭ ����
*/



public class Ex08_Collection_Iterator {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(100);
        list.add(200);
        list.add(300);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        
        //ǥ��ȭ �� ��¹��
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        
                
        
//        ArrayList<int> intlist = new ArrayList<int>(); //generic<> �ȿ��� ����Ÿ�Ը� �� �� ����
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        intlist.add(44);
        intlist.add(55);
        intlist.add(66);
        
        //iterator �̿��ؼ� �غ���
        Iterator<Integer> list2 = intlist.iterator(); //list2�� intlist��� ArrayList�� iterator�޼��带 ������ �޴� ����
        
        while(list2.hasNext()) {
            System.out.println(list2.next());
//            System.out.println(intlist.iterator().next()); //�ٷ� �� ����� ����. ���� ǥ��ȭ�� ǥ�� ����ϻ�
        }
        
        for (int i = 0; i < intlist.size(); i++) {
            System.out.println(intlist.get(i));
        }
        
        //�Ϲ� for�� ������
        for (int i = intlist.size()-1; i >=0; i--) {
            System.out.println(intlist.get(i));
        }
        
        //Iterator�� ������ ��ȸ �Ұ�
        
        //������ ��ȸ.. (����: ������ ���� �� �����⸸ ���� >> ó������ ������ �ȵ�)
        
        ListIterator<Integer> li2 =  intlist.listIterator();
        
        System.out.println("***************");
        //������
        while(li2.hasNext()) {
            System.out.println(li2.next());
        }
        System.out.println("***************");
        //������
        while(li2.hasPrevious()) {
            System.out.println(li2.previous());
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
