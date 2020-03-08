import kr.or.bit.BodyInfo;
import kr.or.bit.Emp;
import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {

    public static void main(String[] args) {
       
        
        //�� Ÿ��(�������: �޸�)
        int i = 100;
        i = 200;
        System.out.println("i : "+i);
        
        //����Ÿ��
        
        Person person;  //����    >> stack�̶�� �޸� ������ ������ ����� ��
        person = new Person(); //person��� ������ ��(�ּҰ�)�� �Ҵ�
        System.out.println(person); //����Ÿ���� �ּҰ��� ���´�. ��°�: kr.or.bit.Person@15db9742
        
        //�ʱⰪ �Ҵ�
        
        Person person2 = null; //null (��ü�� �ʱⰪ: ���� ����, ��� �ִ�)
        System.out.println(person2); //�޸𸮸� ������ ���� �ʴ�
        
        //person2�� �޸𸮸� ���� �����
        //1. person2 = new Person();
        //2. person2 = person; �ٸ� ��ü �ּҰ��� �Ҵ�
        
        person2 = person;
        System.out.println(person2==person); //true ���
        
        person2.name="ȫ�浿";
        person2.age=100;
        person2.print();
        
        System.out.println(person.name);
        
        //����� �Ҵ��� ���ÿ�
        Person myperson = new Person();
        myperson.name="�ƹ���";
        myperson.print(); //��°�: �ƹ��� / age : 0  age�� �Ҵ����� �ʾƼ� �⺻�� 0 ���
        System.out.println(myperson.power); 
               
        Tv stv = new Tv();
        
        stv.brandname="��Ʈ";
        
        System.out.println("���� ä�� ���� : " + stv.ch);  // ����� 0��(int �⺻��)
        
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        stv.ch_Up();
        
        System.out.println("���� ä�� ���� : " + stv.ch); // 5��
        
        stv.ch_Down();
        stv.ch_Down();
                
        System.out.println("���� ä�� ���� : " + stv.ch);  //3��
        System.out.println("�귣�� �̸� : " + stv.brandname);
        stv.tvPrint();
        
        //���1�� ����
        Emp emp = new Emp();
        emp.empno = 7788;
        emp.name = "������";
        emp.job = "IT";
        System.out.println(emp.bodyinfo);
        
        BodyInfo bodyinfo = new BodyInfo();
        bodyinfo.height = 190;
        bodyinfo.weight = 90;
        
        emp.bodyinfo = bodyinfo;
        
        System.out.println(emp.empno+ "/ "+emp.bodyinfo);
        System.out.println(emp.empno + "/ " + emp.bodyinfo.height);
        System.out.println(emp.empno + "/ " + emp.bodyinfo.weight);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
