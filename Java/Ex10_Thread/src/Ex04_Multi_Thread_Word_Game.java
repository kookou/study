import javax.swing.JOptionPane;

class WordTime extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                System.out.println("���� �ð�: "+ i);
                sleep(1000);  //1�ʰ� �ްԽǿ� �� �ִ� ���� sleep(milisecond)
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
}



public class Ex04_Multi_Thread_Word_Game {

    public static void main(String[] args) {
        WordTime timer = new WordTime();
        timer.start();
        
        String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
        System.out.println("�Է°� : "+inputdata);


    }

}
