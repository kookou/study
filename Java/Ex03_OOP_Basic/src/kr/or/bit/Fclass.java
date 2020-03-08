package kr.or.bit;
/*
 * ���, ���� ����� ���
 * �Լ�(function)(method)
 * 
 * �Լ�(method): ���� �Ǵ� ����� �ּҴ���  >> [**�ϳ��� ��ɸ� ����**]
 * ex) �Դ´�, �ȴ´�, �ܴ�....
 * 
 * 
 * Ŭ����: �ʵ�+�Լ�+������
 * 
 * ex)���ӹ�: ���ӱ� �����ְ�.... �Լ�����
 *          �����̱� �����ְ� ������ �޴� �� .... �Լ�����
 *          
 * Java �Լ� ����(4����)
 * 1. void, parameter(O) : void print(String str){�����ڵ�}
 * 2. void, parameter(X) : void print(){�����ڵ�}
 * 3. return Type, parameter(O) : int print(int data){�����ڵ� ���� return�� �־�� ��}
 * 4. return Type, parameter(x) : int print(){return 200;}
 * 
 *  void > �����ִ� ���� ����. return value�� ����
 *  return Type: (8���� �⺻ Ÿ�� + ����Ÿ��) + Array + Collection + Interface
 *  ex) Car print(){return new Car()}
 *  ex) boolean print(){return true;}
 * 
 * parameter(����, �μ�, �Ű���, ���ް�): ���ӱ� ���� ����(���� �� �� �� �� ����)
 * ���������� �� ���� �� �� �� ���� �־�� �����
 * ex) void print(int a, int b, int c, int d, int f) >
 * print(10,20,30,40,50); �̷��� �����
 * 
 * 
 * �Լ��� �̸��� : ù ���ڴ� �ҹ���. ������ ǥ��. �ǹ��ִ� �ܾ����� 
 * :getChannelNumber(), getEmpListByEmpno()
 * 
 * �Լ���� ���� �ݵ�� ȣ��(call) �Ǿ�߸� ����ȴ�: ������ ���� �̸��� �θ��� ������ ������ �ȵȴ�
*/




public class Fclass {
    public int data;
    
    //void m()
    public void m() {
        System.out.println("�Ϲ��Լ�: void, parameter(x)");
    }
    
    //void m(parameter)
    public void m2(int i) {
        System.out.println("parameter value (scope: �Լ�����) :"+i);
        System.out.println("�Ϲ��Լ�: void, parameter(O)");
    }
    
    public int m3() {
        return 100; //return type �ִ� �Լ��� �ݵ�� return Ű���带 ���
    }
    
    public int m4(int data) {
        return data+1; //�̷� ���ĵ� ����
    }
    
    //Ȯ��
    
    public int sum(int i, int j, int k) {
        return i+j+k;
    }
    

    //�Լ��� ������µ�
    // ������ ���� > default  
    //int subSum(int i) {
//        return i+100;
//    }
    
    //�Լ��� �ٸ� �Լ� �θ��� �� ����
    //�������� �ǵ�: subSum �Լ��� Ȱ���� ���ο� �ٸ� �Լ��� �����ִ� �Լ�..
    //but ���� ���� �������� ������ �ʴ´� > ��밡���ϴ�
    //�ǵ�: subSum()�� ��ü(��������)�� ���� ���ϰ�.. ���ο��� ���
    //�׷����� private�� ��� �Ѵ�
    //private ������, ������
    //1. Ŭ���� ���ο����� �ǹ̰� ����
    //2. ���� ����(Fclass f = new Fclass())����  f.private�� �� �� ����
    
    //subSbum �Լ��� ***�ٸ� �Լ��� ����***�ϴ� �Լ���. �׷��� ȣ��Ǿ�� �ȵȴ�.
    //���ο��� �ٸ� �Լ��� ȣ���ؼ� ����Ѵ�.
    //�ٸ� �Լ��� ����ϴ� [���� �Լ�]
    private int subSum(int i) {
        return i+100;
    }
    //��´���Լ� �����
    private void print(int data) {
        System.out.println("data : "+data);
    }
    
    public void CallSubSum() {
        int result = subSum(100);
        print(result);    //��´�� �Լ� ����ؼ� ���ϰ� �������� ���
    }
    
    
    //�Լ��� �Լ��� ȣ���� ���� �־, �Լ� �ȿ� �Լ��� ���� ���� ���� main�Լ��� ��������
    
    
    private int operationMethod(int data) {
        return data * 200;
    }
    
    public int opSum(int data) {
        int result=operationMethod(data);
        if(result>0) {
            return 1;
        }else {
            return -1;
        }
    }
    
    //Quiz
    //a�� b �� �߿� ū ���� return�ϴ� �Լ��� ���弼��
    //ex) max(500,300) return���� 500�ް� �ϸ� �ǿ�
    //public int max(int a, int b)
    
//    public int max(int a, int b) {  //����! ������ �ִ� �Լ��� ��� ��쿡�� ������ ���� �� �־�� ��
        
        //60��
//        int result = 0;
//        if(a>b) {
//            return a;
//        }else {
//            return b;
//        }
              
 
        
        //90��
//        int result;
//        result = (a>b)?a:b;
//        return result;
        
        
        //100��
//        return (a>b)?a:b;        //3�׿����ڸ� �� �����
//     }
    
    
    public String concat(String s, String s1, String s2) {
        String result = s + "/" +s1+"/"+s2;
        return s +"/"+s1+"/"+s2;     //�ٷ� �̷��� ���൵ ���� ����
    }
    
    
    //��������� �Լ��� �⺻��
    
    
    
    //**Ŭ������ Ÿ���̴�.**
    /*
     * public int call(int i, int j){return i + j;}
     * public Tv call(){  }
    */
    
//    public Tv tcall() {
//       return new Tv();// Ÿ�԰� ���� ��ü
//       Tv t = new Tv(); //�ν��Ͻ� ���� �� ����
//       return t;
//        return null; //������� ������ ������ ������ �ƴϴ�
//    }
    
    
//    public Tv tcall() {return new Tv();}
    
    public Tv tcall(Tv t) {  // �Ű����� �̿��� �̷��Ե� �ȴ�
        return t;
//        return new Tv();
    }
    
    //Today Point
    //Ŭ������ memory �÷��� ��밡���ϴ�
    //Tv t = new Tv(); >> t��� ������ TvŸ�԰�ü�� �ּҸ� ���´�
    
    public Tv objMethod() { //Tv��� Ÿ���� ��ü �ּҸ� ������
        Tv tv = new Tv();
        return tv;
    }
    
    public Tv objMethod2() {
        return new Tv();
    }
  
    public Tv objMethod3(Tv t) {  //Tv��� Ÿ���� ���� ��ü�� �ּҸ� �ްڴ�
        return  t;
    }
    

 

  
    
    


    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
