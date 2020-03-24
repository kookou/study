/*
 * ����: Thread(����)
 * Main Thread�� ������ ���� ��
 * �ѱ� >> �۾� >> 3�� �������� �۾����� ����
 * �ѱ��۾� ���� >> �۾� ���� 
*/


public class Ex08_Daemon_Thread implements Runnable {
    static boolean autosave = false;
    public static void main(String[] args) {
      
        Thread th = new Thread(new Ex08_Daemon_Thread());
        //th��� ������� main�������� ����(Daemon)
        //main �ϳ��� ������(non-daemon)
        //main �Լ��� ������� ����� ���� �ϰڴ� (����: th)
        th.setDaemon(true);  //�⺻���� false(non-daemon)�̹Ƿ� true�� �μ���
        th.start();
        
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(1000); //1��
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Main Thread ����: " +i);
            if(i==5) {  //i���� 5�� �Ǵ� ��������
                System.out.println("i: "+ i);
                autosave = true;
            }
        }
        
    }
    public void autoSave() {
        System.out.println("���ڰ� 3�� �������� �ڵ� ����Ǿ����ϴ�.");
    }
    @Override
    public void run() {
        while (true) {
           try {
            Thread.sleep(3000);  //3�� ����
        } catch (Exception e) {

        }
           if(autosave) {  //static boolean autosave �� true���̶��
               autoSave();
           }
            
        }
    }

}
