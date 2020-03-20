import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Buffer 장점 : Line 단위 처리 가능
*/

public class Ex06_FileReader_FileWriter_Buffer {

    public static void main(String[] args) {
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy년MM월dd일HH시mm분ss초");

        
        try {
        FileWriter fw = new FileWriter("Lotto.txt",true);  //true: append
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        
        
        HashSet<Integer> lottoSet = new HashSet<Integer>();
        while(lottoSet.size()<7) {
        int lottonum = (int)(Math.random()*8)+1;

            lottoSet.add(lottonum);

        } 
        bw.write(dateformat2.format(cal.getTime()));
        bw.newLine();
        bw.write(lottoSet.toString());
        bw.newLine();
        bw.flush();
        
        
        
        
        
//        bw.flush();
        
        
//        int[] lottoArray = new int[6];
//        Iterator<Integer> it = lottoSet.iterator();   
//        for(int i=0; i<6;i++) {
//            lottoArray[i]=it.next();
//        }
//        System.out.println(Arrays.toString(lottoArray));
        
   
                   
        
        
        
        
        
//        bw.write("로또");
//        bw.newLine();
//        bw.write("1,45,20,4,3,5");
//        bw.newLine();
//        bw.flush();
        }catch (Exception e) {
            
        }
    
        
        
//        FileReader fr = null;
//        BufferedReader br = null;
//        
//        try {
//            fr=new FileReader("Ex01_Stream.java");
//            br = new BufferedReader(fr);
//            String line ="";
//            for (int i = 0; (line=br.readLine())!=null; i++) {  //readLine() 줄 단위로 읽는 메서드
////                System.out.println(line);
//                if(line.indexOf(";")!=-1) {  //;이 있는 문장만 
//                    System.out.println(line);
//                }
//            }
//        } catch (Exception e) {
//
//        }finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            
//        }

        
    
        
    }

}
