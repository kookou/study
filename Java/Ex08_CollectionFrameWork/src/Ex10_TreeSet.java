import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_TreeSet {

    public static void main(String[] args) {
        
        
        //HashSet Ȯ��  >> LinkedHash(��������)>> Linked(�ּ�: node)
        Set<String> hs2 = new LinkedHashSet<String>();
        hs2.add("B");
        hs2.add("A");       
        hs2.add("F");        
        hs2.add("K");       
        hs2.add("G");       
        hs2.add("D");       
        hs2.add("P");
        hs2.add("A");
        System.out.println(hs2.toString()); //[B, A, F, K, G, D, P]. ������ ������
        
        //TreeSet
        //�ڷᱸ��(����(x), �ߺ�(x), ����(0))
        //�˻��ϰų� ������ �ʿ�� �ϴ� ������ ���� ��)�ζ�
        //1. ���� �˻� Ʈ��(binary search tree) ������ ������ �ִ�
        //2. �����Ͱ� ����� �� ���ĵȴ�
        
        Set<Integer> lotto = new TreeSet<Integer>();
        for (int i = 0; lotto.size()<6; i++) {
            lotto.add((int)(Math.random()*45)+1);            
        }
        System.out.println(lotto.toString());
        
        
        
        //Iterator�� �����
        Iterator<Integer> lo = lotto.iterator();
        while(lo.hasNext()) {
            System.out.println(lo.next());
        } 
        
        
        
        
        
    
        
        
    }

}
