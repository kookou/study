import kr.or.bit.Emp;

public class Ex05_Array_Object {

    public static void main(String[] args) {
        
        //1. ��� 3���� ���弼�� (�� �迭�� ����ϼ���)
        //1000, "ȫ�浿"
        //2000, "������"
        //3000, "������"
        //������ ������ ����ϼ���
        
        Emp[] emplist = new Emp[3];
//        for(int i=0;i<emplist.length;i++) {
//            emplist[i] = new Emp();
//        }
//        emplist[0].setEmpno(1000);
//        emplist[0].setEname("ȫ�浿");
//        
//        emplist[1].setEmpno(2000);
//        emplist[1].setEname("������");
//        
//        emplist[2].setEmpno(3000);
//        emplist[2].setEname("������");
        
        emplist[0] = new Emp(1000,"ȫ�浿");
        emplist[1] = new Emp(2000,"������");
        emplist[2] = new Emp(3000,"������");
        
        //2. ��� 3���� ����� �̸��� ����ϼ���
        for(int i=0;i<emplist.length;i++) {
            System.out.println(emplist[i].getEmpno()+"/"+emplist[i].getEname());
        }
        
        //int[] arr = new int[]{10,20,30}
        
        //��� 2�� ���弼��
        
        //�� ��° �������
        
        Emp[] emplist2 = new Emp[] {new Emp(1,"�̾�"), new Emp(2,"�ھ�")};
        for(int i=0;i<emplist2.length;i++) {
            System.out.println(emplist2[i].getEmpno()+"/"+emplist2[i].getEname());
        }
        
        
        //int[] arr ={10,20}
        Emp[] emplist3 = {new Emp(3,"�达"), new Emp(4,"�־�")};
        
        for(int i=0;i<emplist3.length;i++) {
            System.out.println(emplist3[i].getEmpno()+"/"+emplist3[i].getEname());
        }
        
        
        
        
        
        
        
        
        
        
        

    }

}
