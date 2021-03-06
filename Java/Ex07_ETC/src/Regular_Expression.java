import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
 
public class Regular_Expression {
//    static String data = "";
//    static String regExp;
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
        //+앞에는 한 글자 이상의 단어가 반드시 와야 한다.
        //$문장의 끝
        String regExpaa = "^[ㄱ-ㅎ가-힣]+$";
        
        String data = sc.nextLine();
        
       //정규표현식이 패턴에 일치하는지 여부를 테스트한다.
       //java.util.regex 패키지에 있는 Match 클래스와 Pattern 클래스를 사용하여 
       //문자열을 정규표현식으로 검증할 수 있다.
       boolean b = data.matches(regExpaa); // true ,false
 
        if (b == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("이름에는 한글만 들어올수 있어요.");
        }
 
    }
 
    public static void pwd() {
        System.out.println("2.비밀번호 입력:");
        //[] 대괄호 안의 형식 일치를 의미
        //[A-Za-z 소문자a부터 대문자Z 까지와 0-9 숫자
        //^ :문자열의 시작을 나타냄
        //{} : 선행문자가 나타나는 횟수 또는 범위를 나타낸다
        //!@#$%^~*+=- 특수문자 포함
        //{6,20} 반복갯수를 의미
        //?=.* 적어도 하나
        String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
        String data = sc.nextLine();
 
        boolean b1 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b1 == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("잘못 입력하셨습니다. 8~20자 사이에 적어도 하나의 영어대문자,숫자, 특수문자가 포함되어야 합니다.");
        }
    }
 
    public static void phone() {
        System.out.println("3.휴대번호 입력:");
        // (01[1679]{1}) : 01 뒤에 1,6,7,9 중 하나가 와야함
        // [-.\\s]? : -,.,공백이 있을수도 없을수도 있음
        // (\\d{3,4}) : 3~4자리 숫자
        // (\\d{4}) : 4자리 숫자
        // \d 숫자(정수)
        //{} 괄호 안의 숫자만큼 앞의 문자열을 반복
 
        String regExp = "(01[01679]{1})[-.\\s]?(\\d{3,4})[-.\\s]?(\\d{4})";
        String data = sc.nextLine();
 
        boolean b2 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b2 == true) {
            System.out.println("올바른 형식입니다, 짝짝짝!!!");
        } else {
            System.out.println("잘못된 형식입니다. 다시 입력해주세요!! ex) 010-1234-1234, 011.123.1234, 01612341234, 019 1234 1234");
        }
 
    }
 
    public static void email() {
        //^ :문자열의 시작
        //([a-zA-Z0-9_-\\.]{5,}) : 적어도 5글자 이상의 영어 대/소문자, 숫자, _ ,- 
        //@[a-zA-Z0-9] : @뒤에 영어 대/소문자, 숫자만
        //\\.[a-zA-Z] : . 뒤에 영어 대/소문자만
        //$ :문자열의 끝
        System.out.println("4.E-Mail 입력:");
 
        String regExp = "^([a-zA-Z0-9_-]{5,})@[a-zA-Z0-9]+\\.[a-zA-Z] {2,3}+$";
        String data = sc.nextLine();
 
        boolean b3 = data.matches(regExp); // true ,false 유효성 검사
 
        if (b3 == true) {
            System.out.println("올바른 형식입니다 , 짝짝짝!!");
        } else {
            System.out.println("E-mail 형식은 ex)abcde@aaa.bbb (아이디 부분 최소 5자 이상)입니다. 다시 입력 하세요 ");
        }
    }
    public static void jumin(){
          System.out.println("5.주민번호 입력:");
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