import java.util.*;

public class temp2 {
    
    static char arr[][]; 
    public static void triangle(int a,int b,int n) {
        int div = 0;
        if(n==3) {           
            for(int i=0;i<3;i++) { //5*5 �⺻ ��� ����
                for(int j=0;j<5;j++) {
                    if((i==0 && j%5!=2)||
                       (i==1 && j%2!=1)                                
                            ) continue;
              arr[i][j] = '*';
                }
            }
            return;
        }
         div= n/2; 
        
        
//                triangle(a+(div*i),b+(div*j),div); //������ ����
        
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n= sc.nextInt();
        
        arr = new char[n][n+2];
        System.out.println(3%2);
        for(int i=0;i<arr.length;i++) {  //���ο� �Է� �� �迭 û��
            Arrays.fill(arr[i],' ');
        }
        
        triangle(0,0,n); //��� �޼���
        for(int i=0;i<arr.length;i++) {  //���� ���
            System.out.println(arr[i]);
        }
    }
}