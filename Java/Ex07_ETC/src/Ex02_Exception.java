
public class Ex02_Exception {

    public static void main(String[] args) {

        int num = 100;
        int result = 0;
        System.out.println("Main Start");
        try {
            for (int i = 0; i < 10; i++) {
                result = num / (int) (Math.random() * 10); // 0~9
                System.out.println("result : " + result + " i: " + i);
            }

        } catch (ArithmeticException e) { // ������ �߻��ϸ� �� ���ܿ� �´� ��ü�� �ڵ� ����
            System.out.println("���꿹�� �߻� [�����ڿ��� �̸���]");
            System.out.println(e.getMessage());
            e.printStackTrace();
            // java.lang.ArithmeticException: / by zero
            // ������ �߻��ϸ� ����������
            // new ArithmeticException() >> ��ü���ٰ� ������ ��� �� >> �� �ּҸ� e������ �ޱ�
//            at Ex02_Exception.main(Ex02_Exception.java:11)
        } catch (NullPointerException e) {  ///NullPoint ���ܴ� ���� ������

        } catch (Exception e) { // ������ �߻��ϴ� ��� ���ܴ� ���� ó���Ұ�

        }

        System.out.println("Main End");
    }

}
