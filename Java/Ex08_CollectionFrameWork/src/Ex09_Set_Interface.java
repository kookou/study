import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* Set �������̽��� �����ϴ� Ŭ����
 * ������ ���� ����(x), �ߺ�(x)
 * �����ϴ� Ŭ���� : HashSet, TreeSet
*/

public class Ex09_Set_Interface {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        hs.add(100);
        boolean bo2 = hs.add(55);
        System.out.println(bo2);
        System.out.println(hs.toString());
        bo2 = hs.add(1);  //���� �����ʹ� �߰� �ȵ�
        System.out.println(bo2);
        System.out.println(hs.toString());
        hs.add(2);
        System.out.println(hs);  //toString ����. ���� ���� x
        
        HashSet<String> hs2 = new HashSet<String>();
        hs2.add("b");
        hs2.add("A");
        hs2.add("F");
        hs2.add("c");
        hs2.add("z");
        hs2.add("A");
        hs2.add("A");
        hs2.add("A");
        System.out.println(hs2);
        
        String[] obj = {"A","B","C","D","B","A"};
        HashSet<String> hs3 = new HashSet<String>();
        for (int i = 0; i < obj.length; i++) {
            hs3.add(obj[i]);
        }
        System.out.println(hs3);
        
        //Quiz
        //HashSet �� �̿��ؼ� 1~45���� ���� 6���� ��������
        //hint size�� Ȱ��
        HashSet<Integer> lotto = new HashSet<Integer>();
        for (int i = 0; lotto.size()<6; i++) {
            int num = (int)(Math.random()*45)+1;
            lotto.add(num);
        }
        
        while(lotto.size()<6) {
            lotto.add((int)(Math.random()*45+1));
        }
        System.out.println(lotto);
        
        Set set2 = new HashSet();
        int index=0;
        while(set2.size()<6) {
            System.out.println("index: "+(++index));
            set2.add((int)(Math.random()*45+1));
        }
        System.out.println(set2);
        
        HashSet<String> set3 = new HashSet<String>();
        set3.add("AA");
        set3.add("DD");
        set3.add("ABC");
        set3.add("FFFF");
        System.out.println(set3.toString());
        
        Iterator<String> s = set3.iterator();
        while(s.hasNext()) {
            System.out.println(s.next());   //������ �������� �ʴ´�. set�̴ϱ�
        }
        
        //Collections.sort(List<T>);
        //sort�Լ��� parameter�δ� List �������̽��� ������ ��ü�� ����
        //vector, stack, ArrayList�� ����������, Set�� �Ұ�
        
        List list = new ArrayList(set3); //ArrayList ������ parameter���� Collection Interface Ÿ�� ������ ���� >> HashSet�� ����(������)
        System.out.println("before ������: "+list);
        Collections.sort(list);
//        list.sort(null);  //�̰͵� �Ǵµ� �̰� ����
        System.out.println("sort : "+list);
        
        Collections.reverse(list);
        System.out.println("reverse : "+list);
        
        
        
        
        
        
        
        
        
    }

}
