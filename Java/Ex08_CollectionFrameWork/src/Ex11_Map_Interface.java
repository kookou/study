import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* Map �������̽�
 * Key�� value��� ���� ������ ���� �迭
 * ex) ������ȣ(02, ����), (031, ���)
 * key: �ߺ�(x)
 * value: �ߺ�(o)
 * 
 * generic ����
 * 
 * Map �������̽� ���� Ŭ����
 * ������: HashTable (Vector�� ���������� ����ȭ ����(lock�� ������ ����))
 * �Ź���: HashMap (����ȭ�� �������� ����: ���� ���) 
 * (Thread�� ����� ������ ����ȭ�� �ǹ̰� ����)
 * 
*/



public class Ex11_Map_Interface {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Tiger", "1004");
        map.put("scott", "1004");
        map.put("sueprman", "1004");
        
        //containsKey()  �ش� Ű�� ���� �ִ��� ������
        System.out.println(map.containsKey("Tiger"));
        System.out.println(map.containsKey("scott"));
        System.out.println(map.containsKey("1004"));
        
        //key �����ϸ� value ���� ��°� �ʿ�
        //get()  Ű�� �Ű������� �Ͽ� ���� ��ȯ
        System.out.println(map.get("Tiger")); 
        System.out.println(map.get("hong"));  //null. �ش�Ǵ� Ű�� �������� ������ null��ȯ
        
        //put()  �ش� Ű�� ���� ����, Ȥ�� �Է�
        map.put("Tiger","1005"); //Tiger�� value�� 1005�� ���
        System.out.println(map.get("Tiger"));
        map.put("�Ʊ�", 1004);  //�Է��� ���
        System.out.println(map.get("�Ʊ�"));
        
        
        //remove()
        Object value = map.remove("superman");
        System.out.println("value: "+ value);
        System.out.println(map.toString());
        
        
        //KeySet()
        Set set = map.keySet();  //key ������ Set�̾�� �ϹǷ�
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        Collection vlist = map.values();   //������ Collection Ÿ������ �޾ƾ� �Ѵ�
        System.out.println(vlist.toString());
        
        
        
        
        
        
        
        
    }

}
