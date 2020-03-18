import java.util.ArrayList;

import kr.or.bit.Emp;
import kr.or.bit.CopyEmp;

class Product{
    int price;
    int bonusPoint;
    
    Product(int price){
        this.price = price;
        this.bonusPoint = (int)(this.price/10.0);
        
    }
    
}

class ktTv extends Product{
    ktTv(){
        super(500);       
    }

    @Override
    public String toString() {
        return "KtTv";
    }     
}

class Audio extends Product{
    Audio(){
        super(100);       
    }

    @Override
    public String toString() {
        return "Audio";
    }     
}

class Notebook extends Product{
    Notebook(){
        super(150);       
    }

    @Override
    public String toString() {
        return "Notebook";
    }     
}


public class Ex07_Generic_Quiz {

    public static void main(String[] args) {
        //1. Array �迭�� ����ؼ� cart ����� ��ǰ�� ��������(tv, audio, notebook)
        Product[] cart = {new ktTv(),new Audio(), new Notebook()};        
        
        //2. ArrayList�� ����ؼ� cart�� ����� ��ǰ�� ��������(tv, audio, notebook)
        //��, generic�� ����ϼ���
        //��ǰ�� �̸��� ����ϼ���
        
        ArrayList<Product> alist = new ArrayList<Product>();
        alist.add(new ktTv());
        alist.add(new Audio());
        alist.add(new Notebook());
        
        for(Product i : alist) {
            System.out.println(i.toString());
        }
        
        
        
        //3. Emp Ŭ������ ����ؼ� ��� 3���� ���弼��
        //��, ArrayList<>�� ����ϼ���
        ArrayList<Emp> emplist = new ArrayList<Emp>();
        emplist.add(new Emp(1, "�ʱ�", "IT"));
        emplist.add(new Emp(2, "����", "IT"));
        emplist.add(new Emp(3, "ȣġ", "IT"));
        
 
        //4. ����� ����(���, �̸�, ����)�� ������ for���� ����ؼ� ����ϼ���
        //��, toString() ��� ����
        
        for (Emp p : emplist) {
            System.out.println("���: "+p.getEmpno()+" �̸�: "+p.getEname()+" ����: "+p.getJob());
        }
        
        //5. ����� ����(���, �̸�, ����)�� �Ϲ� for���� ����ؼ� ����ϼ���
        //��, toString() ��� ����
        
        for (int i = 0; i < emplist.size(); i++) {
            System.out.println("���: "+emplist.get(i).getEmpno()+" �̸�: "+emplist.get(i).getEname()+" ����: "+emplist.get(i).getJob());
        }
        
        //6. CopyEmp��� Ŭ������ ���弼��(Emp�� ������)
        //job member field ��ſ�
        //private int sal; �� �ٲپ ���弼��(getter, setter ����)
        //kr.or.bit.CopyEmp�� �ϼ���
        //ArrayList<> ���׸� ����ؼ� ��� 3�� ���弼��
        //�Ʒ� ������ ���
        //100, "��", 1000
        //200, "��", 2000
        //300, "��", 3000
        
        ArrayList<CopyEmp> blist = new ArrayList<CopyEmp>();
        blist.add(new CopyEmp(100, "��", 1000));
        blist.add(new CopyEmp(200, "��", 2000));
        blist.add(new CopyEmp(300, "��", 3000));
        
        
        //7. 200�� ����� �޿��� 5000���� �����ؼ� ����ϼ���(�Ϲ� for�� �ȿ���...)
        //set �Լ�
        for (int i = 0; i < blist.size(); i++) {
            if(blist.get(i).getEmpno()==200) {
                blist.get(i).setsal(5000);
                System.out.println(blist.get(i).toString());
            }
        }
        
      
        //8. 300�� ����� �̸��� "�ñ���"�� �����ؼ� ����ϼ���(������ for�� �ȿ���)
        //set �Լ�
        
        for(CopyEmp p : blist) {
            if(p.getEmpno()==300) {
                p.setEname("�ñ���");
                System.out.println(p.toString());
            }
        }
        
    
        
        

    }

}
