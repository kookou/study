
public class Ex06 {
	//6-4
	//�� �� (x,y)�� (x1,y1)���� �Ÿ��� ���Ѵ�.
//	static double getDistance(int x, int y, int x1, int y1) {
//		return Math.sqrt((Math.pow(x1-x,2)+Math.pow(y1-y, 2)));
//		
//	}
	
	public static void main(String[] args) {
//		
		//6-2
//		Student s = new Student("ȫ�浿", 1, 1, 100, 60, 76);
//		
//		String str = s.info();
//		System.out.println(str);
		
		
		//6-4
//		System.out.println(getDistance(1,1,2,2));
		
		
		//6-5
		//Ŭ���� ����(static ����): width, height
		//�ν��Ͻ� ����: kind, num
		//��������: k, n, (card, args) < �� �ѵ� ��������!
		
		//6-6
//		MyPoint p =new MyPoint(1,1);
//		System.out.println(p.getDistance(2, 2));
		
		//6-16
		//���ڿ��� ���뺯�� �Ұ�. ���������� �ϸ� ���ο� �޸� �����ϰ� ��
		
		
	}

	

}
//6-1~3
//class Student {
//	
//	String name;
//	int ban, no, kor, eng, math;
//
//	Student (String name, int ban, int no, int kor, int eng, int math) {
//	this.name = name;
//	this.ban = ban;
//	this.no = no;
//	this.kor = kor;
//	this.eng = eng;
//	this.math = math;
//	}
//	
//	public String info() {
//	
//		return name+","+ban+","+no+","+kor
//				+","+eng+","+math+","+(kor+eng+math)+","
//				+((int)(((kor+eng+math)/3f+0.05f)*10))/10f;
//	}
//	public int getTotal() {
//		return kor+eng+math;
//	}
//	public float getAverage() {
//		return ((int)(((kor+eng+math)/3f+0.05f)*10))/10f;
//	}
//
//}
//6-6
class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	double getDistance(int x1, int y1) {
		return Math.sqrt((Math.pow(x,x1)+Math.pow(y, y1)));
	}
	
	
}

