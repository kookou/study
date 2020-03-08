import java.util.Arrays;
import java.util.Scanner;

/*����Ƽ�� ���� �Ĺֱ�

���⸦ �ڵ����� 100ȸ �Ĺ�, ������ �� �ɼ�, �ɼ��� ����� ����, �Ĺ��� Ƚ���� ���.
������ ������, ��Ÿ�, ������, �ݵ�, ���ۼ�, źâ, ���� �ӵ�, ���� ������ �ִ�.
�ɼ��� 4���� ĭ�� ������, �� ĭ���� �ѿ� �ɼ�, źâ �ɼ�, ��ƿ��Ƽ �ɼ�, �� �ɼ��� �ϳ��� ����.

�ѿ� �ɼ� : ���� �ѿ�(��Ÿ� + 10, ���ۼ� - 10, �ݵ� +10), �ұ���(��Ÿ� + 7, ������ + 7), ������(������ +=10, ���ۼ� -5, �ݵ� +10), ���� ����(��Ÿ� +5, ������+5, ���ۼ� +5)
źâ �ɼ� : �뱸�� ź��(��Ÿ� +5), ö��ź(��Ÿ� +5), ���� źâ(������ �ӵ� -20, źâ +3), ��ź ź��(������ +10, ��Ÿ� +5), �淮 źâ(��Ÿ� +5, ������ �ӵ� +10)
��ƿ��Ƽ �ɼ� : �ż� �߻�, �ڵ� ���� ����, ���� ������, ����
�� �ɼ� : ��� źâ, ����, ��Ÿ� Ȯ�� ��ġ, �̵� ǥ��, ���� óġ źâ

���⸦ �ѹ� �Ĺ��� ������ 4���� ĭ�� �� �ɼǵ��� �ϳ��� ����, �̰��� ��� �������� ����ȴ�.*/

class StatsNOptn {
	
	//���ȵ�
			int demage = 0;
			int range = 0;
			int safety = 0;
			int recoil = 0;
			int operability = 0;
			int magazine = 0;
			int reloadSpeed = 0;
			int aimCorrection = 0;
		
			
			//�ɼǵ�
			 String[] barrelOptn = {"���� �ѿ�","�ұ���","������","���� ����"};
			 String[] magazineOptn = {"�뱸�� ź��","ö��ź","���� źâ", "��ź ź��","�淮 źâ"};
			 String[] utilOptn = {"�ż� �߻�", "�ڵ� ���� ����", "���� ������", "����"};
			 String[] dealOptn = {"��� źâ", "����", "��Ÿ� Ȯ�� ��ġ", "�̵� ǥ��", "���� óġ źâ"};
	
	public void initStats() {
		 demage = 0;
		 range = 0;
		 safety = 0;
		 recoil = 0;
		 operability = 0;
		 magazine = 0;
		 reloadSpeed = 0;
		 aimCorrection = 0;
	}
			 
			 
	public String[]  expandsArray(String[] a, String b) {
		String[] tmp = new String[a.length+1];
		for(int i=0;i<a.length;i++) {
			tmp[i]=a[i];				
		}
		tmp[a.length] = b;
		a = tmp;
		return a;			
	}
	
	
	public void farming() {
	Scanner sc = new Scanner(System.in);
	int count;
	count = sc.nextInt();
		for(int i=1;i<=count;i++) {
			initStats();   // ���� �� �ʱ�ȭ
		
		// �ɼ� ���� ����
		String optn1 = barrelOptn[(int) (Math.random() * barrelOptn.length)];
		String optn2 = magazineOptn[(int) (Math.random() * magazineOptn.length)];
		String optn3 = utilOptn[(int) (Math.random() * utilOptn.length)];
		String optn4 = dealOptn[(int) (Math.random() * dealOptn.length)];
		
		String[] myOptn = {optn1, optn2, optn3, optn4};

		
		//���� �ݿ�
		
		switch(optn1) {
			case "���� �ѿ�": range +=10; operability -=10; recoil+=10; 
				break;
			case "�ұ���":   range+=7;safety+=7;
				break;
			case "������":   safety+=10; operability-=5; recoil+=10;   
				break;
			case "���� ����":  range+=5; safety+=5; operability+=5;
				break;
			default :
				break;
		}

		switch(optn2) {
		case "�뱸�� ź��": range +=5;
			break;
		case "ö��ź":   range+=5;
			break;
		case "���� źâ":   reloadSpeed-=20; magazine+=3;   
			break;
		case "��ź ź��":  safety+=10; range+=5;
			break;
		case "�淮 źâ":  range+=5; reloadSpeed+=10;
		break;
		default :
			break;
	    }
	
		
		System.out.println("**********");
		System.out.println(i+"�� �Ĺ� ����");
		System.out.println("�ɼ�: "+Arrays.deepToString(myOptn));
		System.out.printf("����: [������:%d, ��Ÿ�:%d, ������:%d, �ݵ�:%d, ���ۼ�:%d, źâ:%d, ���� �ӵ�:%d, ���� ����:%d]%n",
				demage,range,safety,recoil,operability,magazine,reloadSpeed,aimCorrection);
	    
		}
		
	}
	
}

public class Destiny {

	public static void main(String[] args) {
		
		
		
		StatsNOptn so = new StatsNOptn();
		
	
		System.out.println("*************");
		System.out.println("����Ƽ�� ���� �Ĺֱ�");
		System.out.println("*************");
		
		System.out.println("�Ĺ��� Ƚ���� �Է��ϼ���");
		
		so.barrelOptn = so.expandsArray(so.barrelOptn, "test"); //���� ���� �߰�
		so.barrelOptn = so.expandsArray(so.barrelOptn, "test1");
		so.farming();

		
		
	}

}
