import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * read, write 대상이 File인 경우(물리적인 파일>> 1.txt, data.txt)
 * FileInputStream
 * FileOutputStream
 * 
 * c:\\IOtemp\\a.txt\\HELLO
*/



public class Ex02_POINT_File_read_write {

    public static void main(String[] args) {
        /*
        try {
            //POINT: I/O 작업은 대부분 가비지 컬렉터의 대상이 아니다
            //명시적인 자원의 해제를 해야 함(반환 작업 필요 >>close() >>내부적으로 소멸자 호출)
        FileInputStream fs = new FileInputStream("D:\\tae\\IOTemp\\a.txt");
        int data = 0;
        while((data=fs.read())!=-1) {
            System.out.println("정수(숫자): "+data);  //data는 int형이기 때문에 문자가 아닌 아스키코드값이 나온다
            //문자값으로..
            char c =(char)data;
            System.out.println(c);
        }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {    //finally 정상/비정상 모두 거쳐가야 하는 구문
            fs.close();  //스코프 때문에 작동안함
        }
        */
        
        FileInputStream fs=null;  //try블럭 밖에서 변수 선언해야 한다
        FileOutputStream fos=null;
        String path = "D:\\tae\\IOTemp\\a.txt";
        try {
            //POINT: I/O 작업은 대부분 가비지 컬렉터의 대상이 아니다
            //명시적인 자원의 해제를 해야 함(반환 작업 필요 >>close() >>내부적으로 소멸자 호출)
        fs = new FileInputStream(path);
        fos = new FileOutputStream("D:\\tae\\IOTemp\\new.txt",false);  //false가 기본값: 기존 데이터를 덮어씀
//        fos = new FileOutputStream("D:\\tae\\IOTemp\\new.txt",true);  // true는 append 한다.

        //write
        //FileOutputStream은 파일 생성기능을 가지고 있을까
        //>> 파일에 write할 때 파일이 존재하지 않으면 [파일을 생성]
        int data = 0;
        while((data=fs.read())!=-1) {
//            System.out.println("정수(숫자): "+data);  //data는 int형이기 때문에 문자가 아닌 아스키코드값이 나온다
//            //문자값으로..
//            char c =(char)data;
//            System.out.println(c);
              fos.write(data); //data값을 read >>write D:\\tae\\IOTemp\\a.txt
              
        }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {    //finally 정상/비정상 모두 거쳐가야 하는 구문
            try{fs.close();             //어떤 경우에도 자원을 닫는 작업을 한다(리소스 관리)
                fos.close();
            }catch (IOException e) {
               e.printStackTrace();
           }
        }
        
        
    
    
    
    
    
    
    
    
    
    }

}
