import java.util.Scanner;

public class Ex09_Statement {

    public static void main(String[] args) {
//        System.out.println("�Է�");
//        Scanner sc = new Scanner(System.in);
//
//        if (sc.hasNextInt()) { // �ǹ���. �Է°��� �������̸� Ture, �ƴϸ� False�� ����
//            System.out.println("���� �Է�");
//        } else {
//            System.out.println("������ �ƴϳ� �ٽ� �Է�");
//        }

        // �ϱ����� (�� �ϱ� �׽�Ʈ)
        // ���ǹ� : if ����(3����), switch(����){case ��: break;}
        // �ݺ���: for(�ݺ�Ƚ�� ��Ȯ}, while, do~while
        // �б⹮: break(�� Ż��), countinue(�Ʒ� ���� skip)

//      int count = 0;
//    if(count < 1) System.out.println("true");  //�� ���̸� �߰�ȣ ��������
//    if��
//    if(count < 1) {
//          System.out.println("true");
//    }
//    if else��
//    if(count < 1) {
//        System.out.println("true");
//    }else {
//        System.out.println("false");
//    }
        // if else if ��
        // ����

        // �ݺ���
        // 1~100������ ���� sum�̶�� ������ ��Ƽ� ����ϼ���.
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.printf("1���� 100������ ���� %s�Դϴ�.\n", sum);

        // for���� ����ؼ� 1~10������ Ȧ���� ���� ���غ�����. ��, for�� �ϳ��� ���
        int sum2 = 0;
        for (int i = 1; i <= 10; i += 2) { // ���� ���ǿ� ���������ڸ� �����ϴٴ� ������ ������.
            sum2 += i;
        }
        System.out.printf("1���� 10������ Ȧ���� ���� %s�Դϴ�.\n", sum2);

        // if�� ����ؼ� 1~100������ ¦���� ���� ���Ͻÿ�.
        int sum3 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) { // ������ == �� ����!
                sum3 += i;
            }
        }
        System.out.printf("1���� 100������ ¦���� ���� %s�Դϴ�.\n", sum3);

        // 1~100���� �Ҽ��� ���غ��� �Ҽ�: 1�� �ڱ� �ڽ� ���� �μ��� ���� ��       
     
        
        int i,j,count;       
        for(i=2 ; i<=100 ; i++){

            count=0;   // count�� �ʱ�ȭ

            for(j=2 ; j<i; j++) {

                if(i%j==0) {
                    count+=1;
                }
            }
            if(count==0) {
                System.out.print(i+", "); // 
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
}