import java.io.File;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex09_File_Format {

    public static void main(String[] args) {
        //ȭ�����ó��
        DecimalFormat df = new DecimalFormat("#,###.0");
        String result = df.format(1234567.89);
        System.out.println(result);
        String result2 = df.format(100000000000L);
        System.out.println(result2);
        
        
        //��¥ ó��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
        Calendar cal = Calendar.getInstance();
        String sdate = sdf.format(cal.getTime());
        System.out.println(sdate);
        
        //���ڿ� ����(>>printf(), String.format..
        //MessageFormat Ŭ����
        String userid = "kglim";
        String message = "ȸ��id: {0} \nȸ���̸�: {1} \nȸ�� ��ȭ��ȣ:{2}";
        String result3 = MessageFormat.format(message, userid, "ȫ�浿", "111-1111");
        System.out.println(result3);
        
        File dir = new File("C:\\Temp");
        File[] files = dir.listFiles();  //Temp �Ʒ� �ִ� ������ ������ �迭��...
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            String name = file.getName(); //���ϸ�, ������
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd-HH-mma");
            String attribute="";
            String size="";
            if(files[i].isDirectory()) {
                attribute="<DIR>";
            }else {
                size = file.length() +"byte";
                attribute = file.canRead()?"R":"";
                attribute += file.canWrite()?"W":"";
                attribute += file.isHidden()?"H":"";
            }
            System.out.printf("%s  %3s   %10s   %s   \n",
                    dt.format(new Date(file.lastModified())),
                    attribute,
                    size,
                    name
            );
            //����, ���� ���� ���ϱ��
        }

        
        
        
        
        
       
        
        
        
        
        
        
        
        
    }

}
