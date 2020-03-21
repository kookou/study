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
import java.util.TreeSet;

/*
 * Buffer ���� : Line ���� ó�� ����
*/

public class Ex06_FileReader_FileWriter_Buffer {

    public static void main(String[] args) {
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy��MM��dd��HH��mm��ss��");

        
        try {
        FileWriter fw = new FileWriter("Lotto.txt",true);  //true: append
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        
        
        TreeSet<Integer> lottoSet = new TreeSet<Integer>();
        while(lottoSet.size()<7) {
        int lottonum = (int)(Math.random()*44)+1;

            lottoSet.add(lottonum);

        } 
        bw.write(dateformat2.format(cal.getTime()));
        bw.newLine();
        bw.write(lottoSet.toString());
        bw.newLine();
        bw.flush();
        
        
        
        

        }catch (Exception e) {
            
        }
    
        
        
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr=new FileReader("Ex01_Stream.java");
            br = new BufferedReader(fr);
            String line ="";
            for (int i = 0; (line=br.readLine())!=null; i++) {  //readLine() �� ������ �д� �޼���
//                System.out.println(line);
                if(line.indexOf(";")!=-1) {  //;�� �ִ� ���常 
                    System.out.println(line);
                }
            }
        } catch (Exception e) {

        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        
    
        
    }

}
