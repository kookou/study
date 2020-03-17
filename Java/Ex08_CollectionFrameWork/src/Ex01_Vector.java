import java.util.Vector;

/*
 * Collection FrameWork
 * [�ټ��� �����͸�] �ٷ�� ǥ��ȭ�� �������̽��� �����ϰ� �ִ� Ŭ���� ����
 * 
 * Collection �������̽� <- List(���)<---- ArrayList(����)
 *                    <- Set(���)<----HashSet, TreeSet(����)
 * Map �������̽�(key, value)<----HashMap(����)
 * ArrayList, HashMap �߿�
 * -------------------------------------------------
 * List Interface (���� ���ÿ�)
 * ����(��ȣǥ), �ߺ�(���) >>���������� ������(�ڷ�, ��ü)���� �迭�� ����
 * 
 * 1. Vector(������) -> ����ȭ(��Ƽ������) -> Lock(��ȣ) -> ���� �� ������  
 * ��) �Ѱ� ȭ���
 * 2. ArrayList(�Ź���) -> ����ȭ(��Ƽ������) -> Lock(�ʿ信 ����) -> ���� ���
 * ��) �Ѱ� ����� ����(���� ���Ա� ����)
 * 
 * Array
 * 1. �迭�� ũ�Ⱑ ����: Car[] card = {new Car(), new Car()};
 * 2. ���� ���: index(÷��) index�� 0���� ���� 
 * 3. �ʱ� ���� ���� �Ұ�
 * 
 * List �������̽��� ������ Ŭ����:: Vector, ArrayList
 * 1. �迭�� ũ�⸦ �������� Ȯ��/��� ���� >> ����� �迭�� ���Ҵ�
 * 2. ������ ����(Array), ������(index), �ߺ��� ���
 * 3. ������ ���� ����(Array)
*/


public class Ex01_Vector {

    public static void main(String[] args) {
        
        Vector v = new Vector();  //���׸� ǥ�⸦ ���ϸ� ���� ������ ObjectŸ������ ���� ����
        System.out.println("�ʱ�  default �뷮: "+v.capacity()); //�⺻������ 10�� �� ����
        v.add("AA");
        v.add("BB");
        v.add("AA");
        v.add(100);
        
        System.out.println(v);
        
        //Array >> length >> �迭�� ����
        //List >> size >> ���� ����
        
        for (int i = 0; i < v.size(); i++) {
            //����(Array: arr[i]
            System.out.println(v.get(i));          //get() ���� �������� �޼���
        }
        //������ for�� ���
        for(Object i: v) {
            System.out.println(i);  //print()�� Object�� �����ε� �Ǿ�����
        }
        //���׸� >> Ÿ���� ����
        Vector<String> v2 = new Vector<String>();
        
        v2.add("Hello");
        v2.add("world");
        v2.add("king");
        for(String str : v2) {
            System.out.println(str);
        }
        System.out.println(v2.toString());
        System.out.println(v2.get(2));
        System.out.println("size ������ ����: "+v2.size());
        System.out.println("Capacity: "+v2.capacity());
        
        Vector<String> v3 = new Vector<>();  //Ÿ�� ���� ������ ��� �ν��Ͻ��� ���׸� ǥ��� ���� ����
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        System.out.println(v3.capacity()); //�⺻ ĳ�۽�Ƽ�� 10 
        v3.add("A");                       //10���� �Ѱ� ����
        System.out.println(v3.capacity()); //20. size�� �⺻ ������ �ʰ��ϸ� ĳ�۽�Ƽ�� �� ��� �ø�
        
        
                
        
        
        
        
        
        

    }

}
