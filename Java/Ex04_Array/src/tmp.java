
public class tmp {
    public static void main(String[] args) {
        
        int[] lotto= new int[6]; //�迭   
        for(int i=0;i<lotto.length;i++) {
         int random =(int)(Math.random()*45 + 1); //��������.   
         lotto[i]=random; //������ �迭�� �ϳ��� �������.  
         if(i>=1) {
            if(lotto[i]!=lotto[i-1]) {
                if(lotto[i]<lotto[i-1]) {
                    lotto[i-1]=lotto[i];
                }
                else break;
            }  
         } System.out.println(lotto[i]); 
        }
        
    }
}
