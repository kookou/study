import java.io.IOException;

public class Ex03_Exception_finally {
    
    static void startInstall() {
        System.out.println("START INSTALL");
    }
    
    static void copyFiles() {
        System.out.println("COPY FILES");
    }
    
    static void fileDelete() {
        System.out.println("DELETE FILES");
    }
    

	public static void main(String[] args) {
	    System.out.println("Main Start");
	    
	    try {
            copyFiles();
            startInstall();
            //throw : �������� ���Ƿ� ���� �߻����Ѽ� ������ ����ó�� �ϵ��� �ϴ� ���
            throw new IOException("Install �� ���� �߻�");
        } catch (Exception e) {
            System.out.println("���� �޽��� ���: "+ e.getMessage());
        
        }finally { //������ ���� �� (���ܰ� �߻��� ����, return���� �ִ��� finally�� �����)
            fileDelete();
        }

	    
	    System.out.println("Main End");
	    
	}

}
