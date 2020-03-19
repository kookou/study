import java.util.Calendar;
import java.util.Date;

import kr.or.bit.utils.Edu_Date;

/*
* Calendar �� ��ӹ޾� ������ ������ Ŭ������ 
 * GregorianCalendar
   buddhisCalendar �ִµ� getInstance()�� [�ý����� ������ ��������]�� [Ȯ��]�ؼ�
      �±��� ��� buddhisCalendar �� �ν��Ͻ��� ��ȯ�ϰ� �� �ܿ��� GregorianCalendar
     �� �ν��Ͻ��� ��ȯ�Ѵ�
   GregorianCalendar �� Calendar�� ��ӹ޾� ���ó� ������ �������� ����ϰ� �ִ� 
   �׷����¿� �°� ������ ������ �±��� ������ ������ ���������� GregorianCalendar ���
   �׷��� �ν��Ͻ��� ���� �����ؼ� ������� �ʰ� �޼��带 ���ؼ� �ν��Ͻ��� ��ȯ�ް��ϴ�
   ������ �ּ��� �������� ���α׷� ������ �ϵ��� �ϱ� ����
   class MyApp{
     static void main(){
      Calendar cal = new GregorianCalendar();
      �ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����......    }  }
   class MyApp{
     static void main(){
      Calendar cal = new getInstance();
        �ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����......   }  }
  API : ������ Protected Calendar() 
 */
//Java API
//��¥ : Date (��) -> Calendar(��)
public class Ex09_Calendar {

	public static void main(String[] args) {
	    //������
	    Date dt = new Date();
	    System.out.println(dt.toString());
	    
	    //�Ź���
	    Calendar cal = Calendar.getInstance(); //getInstance�� ���ϰ��� Calendar�̹Ƿ� �̷��� ��
	    System.out.println(cal);
	    
	    //����� �ʿ��� ������ �����ؼ� �����ؼ� ���
	    
	    System.out.println("�⵵: "+cal.get(Calendar.YEAR));  //�⵵ ����
	    System.out.println("��: "+(cal.get(Calendar.MONTH)+1)); //�� ���. 0���� �����ϹǷ� +1����� ��
	    System.out.println("��: "+cal.get(Calendar.DATE));
	    System.out.println("�� ���� ��° ��: "+cal.get(Calendar.WEEK_OF_MONTH));
	    System.out.println("�� ���� ��° ��: "+cal.get(Calendar.DAY_OF_WEEK));  //�Ͽ��Ϻ��� ������
	    
	    
	    //��, ��, ��
	    System.out.println("��: "+cal.get(Calendar.HOUR));
	    System.out.println("��: "+cal.get(Calendar.MINUTE));
	    System.out.println("��: "+cal.get(Calendar.SECOND));
	    
	    //����, ����
	    System.out.println("����/����: "+cal.get(Calendar.AM_PM));  //���� 0, ����:1 �ε�
	    
        /*
         * �л���� �ý���
         * ���� 200Page > 150Page ��¥�� ��
         * ���� ���������� �ڵ带 �ִ´ٸ�
         * 1page >> 2020-03-19
         * 2page >> 2020-03-19
         * �䱸����: 2020�� 3�� 19�Ϸ� ���� >>150�� �ؾ���-_-
         * �ذ�å: �� �� ���� >> 150���� page ��¥ ����
         * ��¥ ���õ� Ŭ���� >> �޼��� 
         * class EduDate { static String todate(){...��¥ ���� ����}}
        */
	    
	    String date = Edu_Date.DateString(Calendar.getInstance());
	    System.out.println(date);
	    
	    String date2 = Edu_Date.DateString(Calendar.getInstance(),"/");
        System.out.println(date2);
        
        String date3 = Edu_Date.monthFormat_DateString(Calendar.getInstance(), "-");
        System.out.println(date3);
	    

	}

}
