import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
 
public class temp {
    // static 선언 끼리끼리 놀아라
    static String data = "";
    static String regExp;
    static Scanner sc = new Scanner(System.in); //입력
 
    public static void main(String[] args) throws Exception {
 
        while (true) {
            System.out.println("1.이름 2.비밀번호 3.핸드폰번호 4.이메일 5.주민번호 6.끝내기");
            int a = sc.nextInt();
            sc.nextLine();
 
            switch (a) {
            
            case 1:
                name();
                break;
            case 2:
                pwd();
                break;
            case 3:
                phone();
                break;
            case 4:
                email();
                break;
            case 5:
                jumin();
                break;
            case 6:
                System.out.println("종료합니다");
                System.exit(0);
                break;
                
            default:System.out.println("잘못입력하셨습니다.");
            break;
 
            }
        }
    }
 
    public static void name() {
        
        System.out.println("1.이름 입력:");
        // ^ 라인의 처음이나 문자열의 처음을 표시
        //[] 안에 있는 문자 중 하나, 범위는 '-'로 지정
        //+앞에는 한 글자 이상의 단어가 반드시 와야 한다. 0번이상 반복
        //$문장의 끝
        String regExp = "^[ㄱ-ㅎ가-힣]+$";
        
        String data = sc.nextLine();
        
       //정규표현식이 패턴에 일치하는지 여부를 테스트한다.
       //java.util.regex 패키지에 있는 Match 클래스와 Pattern 클래스를 사용하여 
       //문자열을 정규표현식으로 검증할 수 있다.
       boolean b = data.matches(regExp); // true ,false
 
        if (b == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("이름에는 한글만 들어올수 있어요.");
        }
 
    }
 
    public static void pwd() {
        System.out.println("2.비밀번호 입력:");
        //[] 대괄호 안의 형식 일치를 의미
        //[A-Za-z ~소문자a부터 대문자Z 까지와 0-9 숫자
        //^ :문자열의 시작을 나타냄
        //{} : 선행문자가 나타나는 횟수 또는 범위를 나타낸다
        //_@./#&+=?~] 특수문자 포함
        //{6,20} 반복갯수를 의미
        String regExp = "^[A-Za-z0-9_@./#&+-?~]*.{6,20}$";
        String data = sc.nextLine();
 
        boolean b1 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b1 == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("6~20자 사이에 영어대소문자,특수문자도 들어올수 있습니다.");
        }
    }
 
    public static void phone() {
        System.out.println("3.휴대번호 입력:");
        // 핸드폰 앞자리(010)
        // 가운데 4자리
        // 마지막 4자리
        //010은 확정지어놓고
        // \d 숫자(정수)
        //{} 괄호 안의 숫자만큼 앞의 문자열을 반복
 
        String regExp = "(010)-?\\d{4}-?\\d{4}";
        String data = sc.nextLine();
 
        boolean b2 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b2 == true) {
            System.out.println("올바른 형식입니다, 짝짝짝!!!");
        } else {
            System.out.println("휴대전화는 010-xxxx-xxxx 만 들어올수 있어요. 다시 입력해주세요!!");
        }
 
    }
 
    public static void email() {
        //@앞에 영어대소문자 숫자만
        //@뒤에는 영어대소문자만
        //.(점)뒤에는 영어대소문자만
        //{} : 선행문자가 나타나는 횟수 또는 범위를 나타낸다
        System.out.println("4.E-Mail 입력:");
 
        String regExp = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        String data = sc.nextLine();
 
        boolean b3 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b3 == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("E-mail 형식은 ex)csyong92@kosta.com 입니다. 다시 입력 하세요 ");
        }
    }
    public static void jumin(){
          System.out.println("5.주민번호 입력:");
          //| : or를 나타냄
          //\d 숫자(정수) (0~9)
          //{} 문자열 반복 갯수를 의미 - 자리수
          //[1-4] 1~4까지 숫자 형식을 의미
          String regExp = "^\\d{6}-[1-4]\\d{6}";
          String data = sc.nextLine();
          
          boolean b4 = data.matches(regExp); // true ,false 유효성 검사
          
          if(b4 == true){
             System.out.println("올바른 형식입니다 , 짝짝짝!!");
          }
          else {
             System.out.println("주민번호 형식은 xxxxxx-xxxxxxx이고, 뒷자리 첫번째 번호는 1~4만 입력 가능 합니다.");
          }
       }
 
    
}