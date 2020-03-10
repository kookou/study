package kr.or.bit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//1. 1~45������ ������ �߻����� 6���� �迭�� ��������
//(int)(Math.random()*45 + 1)
//lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
//2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�  (�ߺ��� ���� :����� ���)
//3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����  (���� : �ڸ��ٲ�)
//4. �� ����� ��� �ִ� �迭�� ����ϼ��� (ȭ�� ���)

// Ÿ��: �⺻ 8���� + String + class + �迭(Array)

//���赵
//���: **�ʱ�ȭ�� �����ڿ��� ����** �ʿ��ϴٸ� �����ε�
public class Lotto {
//    public int[] numbers = new int[6]; Ʋ���ڵ�� �ƴ����� �̿��̸� �����ڸ� Ȱ���ϴ°� ����
    private int[] numbers;    
    private Scanner scanner;
    private Random r;
    int noNum;
    boolean a;
    int[] noNumArr;
   

    public Lotto() { // ����: �ʱ�ȭ(member field)
//      
        numbers = new int[6];
        scanner = new Scanner(System.in); // �̰͵� �ʱ�ȭ�� �ش��ϹǷ� �����ڿ��� �ϴ°� ����
        r = new Random();
        int noNum=0;
        a=true;
        noNumArr = new int [0];

        
    }

    // ��� (method) >> �Լ� �ϳ��� ��� �� ����
    // �ߺ����� ������ �ȵǿ�
    // ���� ������ ���� ��Ű����
    // ����ϼ���(ȭ�� ���)
    // �޴� ���... ����...
    // 1>> �ζ� ����
    // 2>> ���α׷� ����

    public void selectLottoNumber() {      
        loop_1: while (true) {
            String selectionNum = showMenu(scanner);
           
            switch (selectionNum) {
            case "1": 
                noNumberMenu();   
                do {                    
                    makeLottoNumber(r, numbers); // ��ȣ ����
                } while (!checkNumber());
                showLottoNumbers(); // ���� �ϰ� ����ϱ�
                break;
            case "2": // ���α׷� ����: return(�Լ� Ż��), System.exit(0), �󺧰� ���
                System.out.println("Good Lucky^^");
                break loop_1;
            default:
                System.out.println("Not in Operation");
                break;
            }
        }
    }

    // private �� ����: ���ο����� ����ϰڴ�
    private String showMenu(Scanner sc) { // ��� ��ĳ�ʸ� �Ű������� ���൵ ������ �������
        System.out.println("*******************");
        System.out.println("*1. ��÷ ���� ��ȣ ����*");
        System.out.println("*2. ���α׷� ���� ^^!*");
        System.out.println("*******************");
        System.out.println("���ϴ� �۾� ��ȣ�� �Է��ϼ���:");
        String selectionNum = sc.nextLine();
        return selectionNum;
    }

    // ��ȣ ����(�ߺ��� ����)  //�⺻ ����
    private void makeLottoNumber(Random r, int[] numbers) { // parameter ����
        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = (int) (Math.random() * 45 + 1);
              numbers[i]=r.nextInt(45)+1;  
//              numbers[i]=(r.nextInt(22)+1)*2;  //¦���� �ޱ�
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--; // �ٽ� ������
                    break;
                }
            }
        }
    }
    


    // ȭ�� ��±��
    private void showLottoNumbers() {
        System.out.println("[������ Lotto ��ȣ]");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;

                }
            }

        }

        // ����ϱ�
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("[%2d]", numbers[i]);
        }
        System.out.println();
    }

    // ������� ��Ģ(�迭�� ���� ����� Ư�� ������ ����� ������)
//    private boolean checkAverage() {
//        int sum = 0;
//        int average = 0;
//        for (int num : numbers) {
//            sum += num;
//        }
//        average = sum / numbers.length;
//        System.out.println("��� : " + average);
//        return (average >= 15 && average <= 35); // true , false
//    }
    
    //������� ��Ģ �����
    
    private void noNumberMenu() {
        System.out.println("������ ��ȣ �Է�(1~45) : ��) 3�� ������ ���: 1,2,3");
        noNum = Integer.parseInt(scanner.nextLine());       
    }
    //��ȣ ���� �� �ߺ��� ����
    private boolean checkNumber() {
        
        for (int num : numbers) {
            if(num==noNum) {
                a=false;
                break;
            }else
                a=true;
        }
        return a;
       
    }
    


}
