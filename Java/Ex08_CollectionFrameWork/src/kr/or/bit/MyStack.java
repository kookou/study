package kr.or.bit;


//���� ���� ����� �ڷᱸ��(����)
//�������: �⺻������ Array : Object[] stackarr
//����� ������ �ִ� ��ġ ����(index)
//���: push, pop, empty(����ִ��� Ȯ��), full(�� ä�������� Ȯ��)


public class MyStack {
    
    private Object[] stackarr; //�����
    private int maxsize; //�ִ� ũ�� ����
    private int top; //�迭�� index�� ���� ��ġ ����
    
    public MyStack(int maxsize) {
        this.maxsize = maxsize;
        stackarr = new Object[maxsize];
        top = -1; //�迭�� ���� �������� �ʾ��� �� -1�� ����ϸ� ����
    }
    
    public boolean isEmpty() {
//        if(top<=-1) return true;
//        else return false;
        return(top<=-1);   //�̷��� �ص� �۵��Ѵ�. return ���� ���� �� �� �ִ� ���� ���� �� �ִ�.
    }
    
    public boolean full() {
        if(top==maxsize-1)return true;
        else return false;
    }
    public void push(Object i) {
        //full�� �����ϰ� ����
        if(full()==false) {
            stackarr[top+1]=i;
            top++;
        }else {
            System.out.println("����. Ǫ���� �� �����ϴ�.");
        }
    }
    
    public Object pop() {
        //isEmpty�� �����ϰ�
        if(isEmpty()==false) {            
            return stackarr[top--];
        } else {
            System.out.println("���� �� ���Ұ� �����ϴ�.");
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        MyStack myStack = new MyStack(10);     
        
        System.out.println(myStack.isEmpty());
        
        myStack.push(1);
        
        System.out.println(myStack.isEmpty());
        
        System.out.println(myStack.pop());
        
       for (int i = 0; i < myStack.stackarr.length; i++) {
           myStack.push(i+1);
           System.out.println(myStack.stackarr[i]);
       }

       
      
       System.out.println(myStack.full());
       
       myStack.push(11);
       
       for(Object obj: myStack.stackarr) {
           myStack.pop();
       }

       
       System.out.println(myStack.isEmpty());
       
       myStack.pop();
       


        
        
        
        
    }
    
    
    
    
    
    
    
    

}
