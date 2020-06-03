package Spring_DI4;

import java.util.Scanner;

public class NewRecordView  implements RecordView{
	//점수 출력하는 클래스
	private NewRecord record; //member field (setter 생성)
	
	//1. [생성자]를 통해서 필요한 객체를 생성 or 주입 >> DI 패키지에서
	//2. 함수(setter) 를 통해서 필요한 객체를 주입 >> DI2  >> 집합연관
	//3. 인터페이스를 활용 (다형성)
	
	//record 의  setter 함수
	public void setRecord(Record record) { // parameter type : interface 
		//함수의 parameter 를 통해서 NewRecord 객체의 주소값
		this.record = (NewRecord)record;
	}
	


	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("kor:");
		record.setKor(sc.nextInt());
		
		System.out.println("eng:");
		record.setEng(sc.nextInt());
		
		System.out.println("math:");
		record.setMath(sc.nextInt());
		
	}

	@Override
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
		
	}



	
}
