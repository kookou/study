import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * HashMap<k, v>
 * HashMap<String, String>
 * HashMap<Integer, String>
 * HashMap<String, Emp>
 * >>put("hong", new Emp()); << �̷� ��찡 ���� ���� ��Ʈ�� Ű�� ���� �� Ÿ���� ��ü��
*/

class Student{
    int kor=100;
    int math=50;
    int eng=20;
    String name;
    public Student(String name, int kor, int math, int eng) {
        this.name=name;
        this.kor=kor;
        this.math=math;
        this.eng=eng;
    }
}

public class Ex13_HashMap_Generic {

    public static void main(String[] args) {
        
        HashMap<String, Student> sts = new HashMap<String, Student>();  //������Ʈ�� �� �̷� ������ ���� ���� ����
        sts.put("hong", new Student("ȫ�浿", 100, 50, 30));
        sts.put("kim", new Student("������", 50, 100, 60));
        
        Student std = sts.get("hong");
        System.out.println(std.kor);
        System.out.println(std.math);
        
        //Tip
        //Map �ȿ� �ִ� key, value ��� ���� ���
        //entrySet()
        Set set = sts.entrySet(); //key+"="+value
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());   //hong=Student@15db9742  value���� �ּҰ����� ���� �Ǵ� ������ �����
        }
        
        //����
        //���࿡ value�� Object(��ü)���
        //Map.Entry���� getKey(), getValue() �����޴´�
        for(Map.Entry m: sts.entrySet()) {
            System.out.println(m.getKey()+"/"+((Student)m.getValue()).name);  //Map.Entry���� name ������ �����Ƿ� Student�� �ٿ�ĳ������ ���� name�����´�
        }
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
