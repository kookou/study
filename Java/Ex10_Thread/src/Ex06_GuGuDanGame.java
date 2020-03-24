import java.util.ArrayList;

import javax.swing.JOptionPane;

class QuizLog {
    String qst;
    String anw;
    String corAnw;
    
   public QuizLog(String qst, String anw, String corAnw) {
    this.qst=qst;
    this.anw=anw;
    this.corAnw=corAnw;
}
}

class WordInputProcess1 extends Thread{
    static int i;
    static int j;
    ArrayList<QuizLog> list = new ArrayList<QuizLog>();
    
    String question() {
        i = (int)(Math.random()*8)+2;
        j = (int)(Math.random()*9)+1;
                
        return i+"X"+j+"��?";
        
    }
    
    @Override
    public void run() {
        while(true) {
        String inputdata = JOptionPane.showInputDialog(question());
        if(inputdata.equals(i*j+"")) {
            System.out.println("�����Դϴ�.");
            Ex06_GuGuDanGame.correct++;
            
        }else {
            System.out.println("Ʋ�Ⱦ�� �Ф�");
        }
        
        Ex06_GuGuDanGame.total++;
    }
    }
}


class WordTimeOut1 extends Thread{
    @Override
    public void run() {
        for(int i=10; i > 0 ; i--) {
            

            
            System.out.println("���� �ð�: " + i);
            try {
                 Thread.sleep(1000); //���ǿ��� 1�ʰ� ������ ....
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Ex06_GuGuDanGame {
    static int total;
    static int correct;
    public static void main(String[] args) {
        WordInputProcess1 word = new WordInputProcess1();
        WordTimeOut1 time = new WordTimeOut1();
            
        word.start();
        time.start();
        
        try {
            time.join(); //main����  time�� ������ ������ ����϶�� ���
        } catch (Exception e) {

        }  
        
        System.out.println("�� ������: " + total+" "+"���� ����: "+correct
                );
        System.out.println("���� ����");
        System.exit(0);
    }

}
