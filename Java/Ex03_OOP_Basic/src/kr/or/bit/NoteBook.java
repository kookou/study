package kr.or.bit;

public class NoteBook {
    public String color;
    private int year;
    //private�� �� ����: ���� �Ҵ��� ���� �����Ҵ��� ���ؼ� �ڷḦ ��ȣ�ϰڴ�
    
    public void setYear(int y) {  //�����Ҵ����� �Է¹޴� ���� ������ ������  
        if(y<0) {
            year = 1999;
        }else {
            year = y;            
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public Mouse handle(Mouse m) { //point: m�� Mouse�� ����ִ� heap�� �ּҰ��� ���̴�.
        m.x=100;
        m.y=200;
        return m;
    }

    
    
    
    
    
    
}
