import kr.or.bit.Emp;


class Test2{
    void print() {
        System.out.println("�θ��Լ�(Test2)");
    }
}

class Test3 extends Test2{
    @Override
    void print() {
        System.out.println("�ڽ��� �θ��Լ��� ������");
    }
    //�����ε�(��Ӱ� ����� ����)
    void print(String str) {
        System.out.println("�� �����ε� �Լ���^^"+str);
    }
}


public class Ex05_Inherit_Override {

    public static void main(String[] args) {
        
        Emp emp = new Emp(1000,"������");
//        System.out.println(emp.toString()); //kr.or.bit Emp@15db9742
//        System.out.println(emp);  //kr.or.bit.Emp@15db9742 ���� �����. toString()�� �����ص� �� ������ ������ �� ��
        
        System.out.println(emp.toString()); //Emp [empno=1000, ename=������]  :toString �������̵�
        System.out.println(emp);  //Emp [empno=1000, ename=������]   :������ toString �������̵�. �������� �˾Ƽ� ������  �� 
        
        Test3 test3 = new Test3();
        test3.print();
        test3.print("�����ε�");
        
        
    }

}
