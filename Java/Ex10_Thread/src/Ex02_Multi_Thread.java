/*
 * Thread : ���μ������� �ϳ��� �ּ� �������
 * 
 * Thread �����ϴ� ���
 * 1. Thread Ŭ������ ��� -> class Test extends Thread >> ���ο� stack�� �ö� �غ�
 * �ݵ�� Thread ������ run() ����
 * >> Thread�� �Ϲ� Ŭ���� >> ������ ��ü ���� ����
 * 
 * 2. Runnable �������̽� ���� -> class Test extends Car implements Runnable 
 * �ڹٴ� ���߻���� �Ұ��ϹǷ�, �ٸ� Ŭ������ �ڽ�Ŭ������ ������ȭ�ϱ� ���� 
 * 
*/

class Thread_1 extends Thread{

    @Override
    public void run() { //run() >> main�Լ��� ������ ���� //���ο� stack ó�� �ö󰡴� �Լ�
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread_1: "+i+this.getName());
        }
        System.out.println("Thread_1 run() END");
    }
    
}

class Thread_2 implements Runnable{  
    @Override
    public void run() { //run() >> main�Լ��� ������ ���� //���ο� stack ó�� �ö󰡴� �Լ�
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread_2: "+i);
        }
        System.out.println("Thread_2 run() END");
    }
}

public class Ex02_Multi_Thread {

    public static void main(String[] args) {  //main�� �ϳ��� Thread
        //1��
        Thread_1 th = new Thread_1();
        th.start();  //POINT >> call stack �ϰ� �� stack�� run()�Լ� �÷�����
        
        //2��
        Thread_2 th2 = new Thread_2(); //Thread�� �ƴϴ�. �������̽��� ������ Ŭ����
        Thread thread = new Thread(th2);  //Thread ��ü�� ������ �̿��ؼ� ������ȭ
        thread.start();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println("main: "+i);
            
        }System.out.println("Main END");
        
        
        

    }

}
