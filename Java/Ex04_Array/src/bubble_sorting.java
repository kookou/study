/*Bubble ���� �����ϰ� ��ǥ �ϱ�

�������Ŀ� ���� ���� ����� �����ϰ� 
������ ����� ��ǥ�ϱ�*/

public class bubble_sorting {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) { // �ߺ����� ���� �� �̱�

            arr[i] = (int) (Math.random() * 100 + 1);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) { // ���� �迭 ���
            System.out.print(arr[i] + " ");
        }
        System.out.println();

//        for (int i = 0; i < arr.length; i++) { // ���� ���� �˰���
//            for (int j = 1; j < arr.length - i; j++) {
//                if (arr[j - 1] > arr[j]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = tmp;
//                    for (int k = 0; k < arr.length; k++) { // ���ĵǴ� ���� ���
//                        System.out.print(arr[k] + " ");
//
//                    }
//                    System.out.println();
//
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) { // ������ ���� �˰���
            for (int j = arr.length-1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    for (int k = 0; k < arr.length; k++) { // ���ĵǴ� ���� ���
                        System.out.print(arr[k] + " ");

                    }
                    System.out.println();

                }
            }
        }

    }

}
