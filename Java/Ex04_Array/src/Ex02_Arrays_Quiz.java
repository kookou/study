import java.util.Arrays;

public class Ex02_Arrays_Quiz {

    public static void main(String[] args) {
        //���а� �л����� �⸻��� ��������
        
        int[] score = new int[] {79,88,97,54,56,95};
        int max = score[0];  //max >> 79
        int min = score[0];  //min >> 79
        
        //����� ����ؼ� max������ �������� �ִ���, min������ �ּڰ��� ��������
        //��µǴ� �����: max = 97, min = 54
        //�� for���� �� ���� ����ϼ���
        
        for(int i=0; i<score.length;i++) {
//           if(score[i]>max) {
//               max=score[i];
//           }
//           if(score[i]<min) {
//               min=score[i];
//           }
            max=(score[i]>max)?score[i]:max;   //���׿����� Ȱ������
            min=(score[i]<min)?score[i]:min;
     
           
        }System.out.println("max: "+max+", min: "+min);
        
        int[] number = new int[10];
        //10���� ���� ���� 1~10���� ������ �ʱ�ȭ �ϼ���
        //number[0] >> 1,,,,,,,,number[9] >>10
        //for�� ���
        
        for(int i=0;i<number.length;i++) {
            number[i]=i;
        }System.out.println(Arrays.toString(number));
       
        
        //��� �л��� �⸻��� ��������(5����)
        int sum =0;
        float average = 0f;
        int[] jumsu = {100,55,90,60,78};
        
        //1. �� ���� ��
        //2. ������ ��
        //3. ������ ���
        //�� 2,3 ������ �ϳ��� for���� �ذ��ϼ���
        

        for(int i=0;i<jumsu.length;i++) {
            sum+=jumsu[i];
            
            if(i==jumsu.length-1) {
            average = (float)sum/jumsu.length;
            }
        }


        System.out.printf("�Ѱ����[%d], ����[%d], ���[%f]\n",jumsu.length,sum,average);
        
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
