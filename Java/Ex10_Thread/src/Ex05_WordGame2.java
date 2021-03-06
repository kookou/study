import javax.swing.JOptionPane;

/*
문제
main 함수 제외한 Thread 2개 생성
1. 시간(time) 제어하는 Thread
2. 단어 입력을 처리하는 Thread

main 함수 2개 실행

단 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추게 하세요
hint) 공유자원 (static)




*/
class WordInputProcess2 extends Thread{
	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("dan" + "단 값을 입력");
		if(inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame2.inputdata = inputdata;
		}
		System.out.println("입력한 값은: " + inputdata);
	}
}


class WordTimeOut2 extends Thread{
	@Override
	public void run() {
		for(int i=10; i > 0 ; i--) {
			
			if(Ex05_WordGame2.inputdata!=null)return; //run함수 탈출
			
			System.out.println("남은 시간: " + i);
			try {
				 Thread.sleep(1000); //대기실에서 1초간 쉬었다 ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
public class Ex05_WordGame2 {
	static String inputdata= null;
	public static void main(String[] args) {
		WordInputProcess2 word = new WordInputProcess2();
		WordTimeOut2 time = new WordTimeOut2();
			
		word.start();
		time.start();
		
		System.out.println("Main END");

	}

}
