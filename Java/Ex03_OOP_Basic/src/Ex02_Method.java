import kr.or.bit.Fclass;
import kr.or.bit.NoteBook;


public class Ex02_Method {

    public static void main(String[] args) {
       Fclass fc = new Fclass();       
       fc.m();
       
       fc.m2(10);
       
       int result = fc.m3();  //return�� �ִ� �Լ��̹Ƿ� ������ ���� �޾���
       System.out.println(result); //100. m3�� ���ϰ��� ���
       
       result = fc.m4(100);
       System.out.println(result);
       
//       fc.subSum(); ȣ�� �Ұ� �����ڰ� default �̹Ƿ�
       
       fc.CallSubSum();//ȣ�� ����
           
       System.out.println(fc.opSum(-1));
       
       NoteBook nb = new NoteBook();
       nb.color="red";
       nb.setYear(-2000);
       int rs = nb.getYear();
       System.out.println(rs);       //������ �־����Ƿ� get set�� ���� 1999 ����
   
       nb.setYear(2020);
       rs=nb.getYear();
       System.out.println(rs);    // ����̹Ƿ� �״�� 2020 ���
               
       
       
       
       
       
       
       
       
       
       
       
       
       
    
    }
   
}
