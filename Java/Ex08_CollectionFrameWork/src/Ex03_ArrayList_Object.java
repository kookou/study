import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object {

    public static void main(String[] args) {
        
        //��� 1���� ���弼��
        Emp emp = new Emp(100, "������", "����");
        System.out.println(emp.toString());
        
        //Array(���� �迭)
        //��� 2�� ���弼��
        Emp[] emplist = {new Emp(100, "�达", "�Ϲ���"), new Emp(200, "�ھ�", "�л�")};
        for( Emp e : emplist) {
            System.out.println(e);  //toString ����
        }
        //������� ���� ���
        
        //�� ���� �Ի縦 �� �߳׿�. �߰���Ű����
        
        //Collection
        ArrayList list = new ArrayList();
        list.add(new Emp(1, "��", "IT"));
        list.add(new Emp(2, "ȫ", "IT"));
        
       
        System.out.println(list);   //toString�� Emp Ŭ�������� �������̵� �߱� ������ ���� ���
        //toString Ȱ������ ���� ��� ����� ������
        //�Ϲ� for��
        for (int i = 0; i < list.size(); i++) {
            //list.get(i)
            Object obj = list.get(i);   //get()�޼����� ������ Object Ÿ���̴�
//            System.out.println(list.get(i));
            
            //getter�� ����ؼ� ������ ����غ���
            Emp e =(Emp)list.get(i); //�θ�Ÿ���� �ּҸ� �ڽ�Ÿ�Կ��� �ַ��� �ڽ�Ÿ�Կ� �°� ĳ�����ؾ� �Ѵ�
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //toString�� ������� ���� ������ for���� ����ϼ���
        //��¥�� �ٿ� ĳ���� ������..
        for(Object obj : list) {
            Emp e = (Emp)obj;
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //Object ������ �ؼ� ����
        //���׸�(Ÿ���� ����)        
        
        ArrayList<Emp> list2 = new ArrayList<Emp>();  //���� ������ ���� Ÿ���� EmpŸ��
        list2.add(new Emp(1, "A", "IT"));
        list2.add(new Emp(2, "B", "IT"));
        
        for(Emp e: list2) {     //���׸��� Ȱ���ؼ� ���ϰ� for�� ���
            System.out.println(e.getEmpno()+"/"+e.getEname()+"/"+e.getJob());
        }
        
        //�׷���...
        //�Ի� �� �� �߰�
        list2.add(new Emp(3, "New", "IT"));  // �迭 �߰��� �ſ� ����!!
        System.out.println(list2);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
