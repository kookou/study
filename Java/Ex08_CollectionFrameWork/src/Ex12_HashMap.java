import java.util.HashMap;
import java.util.Scanner;

public class Ex12_HashMap {

    public static void main(String[] args) {
        //�ϻ� ��Ȱ���� (ȸ������ >> �α��� >> id, pwd)
        HashMap loginmap = new HashMap();
        loginmap.put("kim", "kim1004");
        loginmap.put("scott","tiger");
        loginmap.put("lee", "kim1004");
        //�츮 �ý��� ���Ե� ȸ�� ����(id, pwd)
        //id(o), pwd(o) ȸ��(ȯ��)
        //id(o), pwd(x) ����(��й�ȣ �Է�)
        
        
        //id(x), pwd(o)
        //id(x), pwd(x)
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("ID, PWD �Է��� �ּ���");
            System.out.println("ID");
            String id = sc.nextLine().trim().toLowerCase();
            
            System.out.println("PWD");
            String pwd = sc.nextLine().trim();
            
            if(!loginmap.containsKey(id)) {  //id����
                System.out.println("ID Ʋ����.. ���Է� �ϼ���");
            }else {
                //ID(o)
                //����� ����
                if(loginmap.get(id).equals(pwd)) {
                    System.out.println("ȸ���� �氡�氡^^");
                    break;
                }else {
                    System.out.println("����� Ȯ���ϼ���");
                }
            }
        }
        
        
        
        
        
    }

}
