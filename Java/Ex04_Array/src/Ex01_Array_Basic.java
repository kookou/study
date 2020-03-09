import java.util.Arrays;

//�迭��(Array) ��ü��
//1. �迭�� ��ü�̹Ƿ� (new�� ���ؼ� ����)
//2. new�� ���ؼ� heap �޸𸮿� �����ȴ�
//3. �����迭(���� �迭) : �迭�� ũ��� �� �� �������� �����ȴ�
//4. �ڷᱸ���� �⺻




public class Ex01_Array_Basic {

    public static void main(String[] args) {
        int s, s1, s2, s3;
        int[] score = new int[3]; //���� 3�� ����   //�� ��ȣ(÷��, index)
       
        score[0]=10; //������ �濡 (index)
        score[1]=20;
        score[2]=30;
        System.out.println(score[0]);
        
        //���� ������ �׻� index ������ 1 ũ��
        
//        score[3] = 40;  //������ ���� index >> 2
        //java.lang.ArrayIndexOutOfBoundsException
        //���ܰ� �߻��߾��(������ ������)
        //�׷��� �����Ϸ��� ������ ���α׷��� ����
        //������ �߻����� �� �ϴ� ������ �� �ִ� ���:
        //-> try catch����: ������ �ذ��ϴ� ���� �ƴ� ���α׷��� �������Ḧ ����
        
        //Array �迭(for���� �� ��︲)
        for(int i=0;i<score.length;i++) {
            System.out.printf("[%d]=%d\t",i,score[i]);
        }
        System.out.println();
        
        //Tip. Array�� �����ִ� Ŭ����
        //toString()
        String result=Arrays.toString(score);  //���� ���� ������ for�� ����� �����ϰ�
        System.out.println(result);
        
        //sort()
        Arrays.sort(score);  //���� ���� ���� ������ �� ���� ������
        
        //�Ի� �迭 sort ���� ���� ����
        
        //Today Point
        //�迭 3����
        int[] arr=new int[5]; //�⺻(���� ����)
        int[] arr2=new int[] {100,200,300}; // �ʱⰪ�� ���ؼ� ���� ��������� �ʱ�ȭ
        int[] arr3= {11,22,33,44,55}; //�����Ϸ��� �˾Ƽ� new �ڵ� ����
        //javascript : (var)let cararr =[1,2,3,4,5];
        
        
        for(int i =0; i<arr3.length;i++) {
            System.out.println(arr3[i]);
        }
        
        //�迭�� ��ü��(new...memory >>heap)
        int[] arr4;
        arr4 = new int[] {21,22,23,24,25};
        System.out.println("arr4: "+arr4);
        //�迭�� �Ҵ�(�ּҰ� �Ҵ�)
        int[] arr5 = arr4;
        //����
        System.out.println(arr4==arr5);  //���� �ּҰ��� ������
        
        String[] strarr = new String[] {"��","��","�ٶ�"};
        char[] ch = new char [10];  //���� '\u0000'
        for(int i =0; i<ch.length;i++) {
            System.out.println(">"+ch[i]+"<");  //���� ���̰� �ϱ� ���� ���� ����
        }
        
        //8���� �⺻Ÿ�� + String >> Array Ÿ�� ����
        //***Ŭ����Ÿ��(����� ���� Ÿ��) >>Array Ÿ�� ����
        //Car c = new Car();
        //Car c2 = new Car();
        //Car c3 = new Car();
        //.....
        //�̷��� �ϴ� �ͺ���,
        
        //Car[] cars = new Car[10];  //�̷��� ���°� ���ϴ�. �迭�� ����
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
