import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//https://cafe.naver.com/opensourceweb/441 ����

public class Ex10_Format_Date {
	public static void main(String[] args) throws ParseException  {
		Date curdate = new Date();
		Calendar cal = Calendar.getInstance();
		System.out.println("Date : " + curdate); //formatȭ �Ǽ� ���
		System.out.println("cal : " + cal);  //���ڿ� �״�� ���
		System.out.println("cal getTime()" + cal.getTime()); //formatȭ �Ǿ� ���
		
	
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(dateformat.format(curdate));
		System.out.println(dateformat.format(cal.getTime()));
		
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy��MM��dd��HH��mm��");
		System.out.println(dateformat2.format(curdate));
		System.out.println(dateformat2.format(cal.getTime()));
		
		String StringDate = "202012121212";
		
		Date stringdate =  dateformat.parse(StringDate);      //���ڿ� ������ ���� ��¥�Է��� �������ϴ� ���
		System.out.println("StringDate : " + StringDate);
		System.out.println("stringdate : " + stringdate);
		
//		long datelong = stringdate.getTime();
//		System.out.println(datelong);   //11�� ���Ϸ� �Ѿ��
		

	}

}







