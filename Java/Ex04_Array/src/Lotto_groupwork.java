import java.util.Arrays;

/*
 *1. 1~45������ ������ �߻����� 6���� �迭�� ��������
      (int)(Math.random()*45 + 1)
      lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
 *2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�  (�ߺ��� ���� :����� ���)
 *3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����  (���� : �ڸ��ٲ�)
 *4. �� ����� ��� �ִ� �迭�� ����ϼ��� (ȭ�� ���)

 ���Ŀ��� ������ Ŭ���� �и��ؼ� Lotto.java ..... 
 ���� main �Լ� �ȿ��� ��� ....����...

���� 1�� �Դϴ�
  
 */
public class Lotto_groupwork {

    public static void main(String[] args) {

        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = (int) (Math.random() * 45 + 1);
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
//                    lotto[j] = (int) (Math.random() * 45 + 1);
                    i--;   // �ٽ� ������
                    break;
                }
            }
        }
        
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf(lotto[i] + " ");
         
        }
        System.out.println();
        
//        for (int i = 0; i < lotto.length; i++) {      //������ ������ ���ʿ��� ������ ����
//            for (int j = 0; j < lotto.length; j++) {
//                if (lotto[i] < lotto[j]) {
//                    int tmp = lotto[i];
//                    lotto[i] = lotto[j];
//                    lotto[j] = tmp;
//
//                }
//            }System.out.println(Arrays.toString(lotto));
//
//        }
        for (int i = 0; i < lotto.length; i++) {
            for (int j = i+1; j < lotto.length; j++) {
                if (lotto[i] > lotto[j]) {
                    int tmp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = tmp;
                    System.out.println(Arrays.toString(lotto));

                }
            }

        }
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf(lotto[i] + " ");
        }

    }

}
