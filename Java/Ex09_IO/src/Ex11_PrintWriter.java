import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

//������� ����
//ģô : printf , String.format()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try {
			//console �۾���  txt ���Ͽ��� �۾� ..
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			pw.println("*******************************************");
			pw.println("*             HOMEWORK                    *");
			pw.println("*******************************************");
			pw.printf("%3s : %5d  %5d  %5d  %5.1f", "�ƹ���",100,90,50,(float)((100+90+50)/3));
			pw.println();
			pw.close(); //close() 
			
			//homework.txt read (Line) 
			FileReader fr = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s="";
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			//����� .. ^^!
		}
	}

}
