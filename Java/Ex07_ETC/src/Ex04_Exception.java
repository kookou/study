import java.io.IOException;

import kr.or.bit.ExceptionClass;

public class Ex04_Exception {

    public static void main(String[] args) {
        ExceptionClass ex = null;   //lv�� �ʱ�ȭ �ʿ�
        try {
            ex = new ExceptionClass("world");
        } catch (NullPointerException| IOException e1) {

            e1.printStackTrace();
        }
        try {
            ex.call();
        } catch (Exception e) {

        }
        
       
    }

}
