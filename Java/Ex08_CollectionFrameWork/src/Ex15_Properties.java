import java.util.Properties;

/*
 * <Properties>
 * Map �������̽��� ������ Ŭ����
 * Ư���� ������ map <String, String> ���� ������ Map
 * ������
 * APP ��ü�� ����, ȯ�� ����, ���α׷��� ����, ���� ���, ���� ���� ���� �����ϰ���
 * 
 * ex)
 * config.properties
*/


public class Ex15_Properties {

    public static void main(String[] args) {
        Properties  prop = new Properties();  // ���׸��� �̹� <String, String>���� ���õǾ� �ִ�
        prop.setProperty("master", "bit@bit.or.kr");
        prop.setProperty("version", "1.x.x.x");
        prop.setProperty("defaultpath", "C:\\Temp\\images");
        
        //������ ���� ����������
        System.out.println(prop.getProperty("master")); //�̷� ������ ���
        System.out.println(prop.getProperty("defaultpath"));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
