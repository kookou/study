import kr.or.bit.Singleton;

public class Ex14_Singleton_main {

    public static void main(String[] args) {

//        Singleton singleton = new Singleton();  //private �����ڶ� ����ȵ�
        
        Singleton single = Singleton.getInstance();
        System.out.println(single);
        Singleton single2 = Singleton.getInstance();
        System.out.println(single2);
        Singleton single3= Singleton.getInstance();
        System.out.println(single3);
        
        //kr.or.bit.Singleton@15db9742
        //kr.or.bit.Singleton@15db9742
        //kr.or.bit.Singleton@15db9742  ��� ���� �ּҰ�, �� ��� ���� ��ü�� �����Ѵ� 
        
        
    }

}
