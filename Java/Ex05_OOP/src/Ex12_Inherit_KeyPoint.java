/*
�ó�����(�䱸����)
����� ������ǰ ���� �ַ���� �����ϴ� ������Դϴ�
A��� ������ǰ ������ ���µǸ� 
[Ŭ���̾�Ʈ �䱸����]
������ǰ��  ��ǰ�� ���� , ��ǰ�� ����Ʈ ������ ���������� ������ �ֽ��ϴ�
������ ������ǰ�� ��ǰ�� ������ �̸��� ������ �ִ�
ex)
������ ������ǰ�� �̸��� ������ �ִ�(ex: Tv , Audio , Computer)
������ ������ǰ�� �ٸ� ������ ������ �ִ�(Tv:5000, Audio:6000 ....)
��ǰ�� ����Ʈ�� ������ 10% �����Ѵ�
 
�ùķ��̼� �ó�����
������ : ��ǰ�� �����ϱ� ���� �ݾ����� , ����Ʈ ������ ������ �ִ� 
���� ��� : 10����  , ����Ʈ 0
�����ڴ� ��ǰ�� ������ �� �ִ� , ���������� �ϰԵǸ� ������ �ִ� ����  �����ϰ� ����Ʈ�� �ö󰣴�
�����ڴ� ó�� �ʱ� �ݾ��� ���� �� �ִ�
*/

class Buyer{
    int money = 1000;
    int bonusPoint;
    
    //�������� (���)
    //��������(�ܾ�, ����Ʈ ���� ����)
    //**�����ڴ� ������ ��� ������ ������ �� �ִ�
    
    //������ 3��... ������ �� �ִ� ��� 3��
    
    //1�� ���� ���� ����..
    //�Ͽ��� �ް� .... ^^
    
    //���� ����
    //���忡 ��ǰ�� 1000���� �ٸ� ��ǰ�� �߰�(��ǰ ���: POS ��� �ڵ�ȭ)
    //1000���� �ٸ� ��ǰ�� ��ġ
    //����
    //1. ���忡�� ������ 997���� ��ǰ�� �Ǹ��� �� �������? >����
    // ������ 997���� ��ǰ�� ������ �� �ִ� ����� ������ �ʾ���
    //2. ���� >> ���ͳ� >> ���� ���� ���� >> �ް� >> 997���� �Լ� �����... �ް��� end...
    //> ��ȭ�� �������� ���� ��
    
    //��ſ� �ް��� ������ ���� ����� �����ϼ���
    
        
    //1�� �ڵ�
//    void kttvBuy(ktTv n) {  //�Լ��� ��ǰ ��ü�� parameter �޾Ƽ� (����, ����Ʈ)
//        if(this.money< n.price) {
//            System.out.println("���� �ܾ��� �����մϴ�^^! "+this.money);
//            return; //�Լ� ���� > kttvBuy Ż�� (���� ���� ����)
//        }
//        
//        //�� ���� ����
//        this.money -= n.price;  //�ܾ�
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("������ ������: "+n.toString());
//    }
//    
//    void audioBuy(Audio n) {  //�Լ��� ��ǰ ��ü�� parameter �޾Ƽ� (����, ����Ʈ)
//        if(this.money< n.price) {
//            System.out.println("���� �ܾ��� �����մϴ�^^! "+this.money);
//            return; //�Լ� ���� > kttvBuy Ż�� (���� ���� ����)
//        }
//        
//        //�� ���� ����
//        this.money -= n.price;  //�ܾ�
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("������ ������: "+n.toString());
//    }
//    
//    void notebookBuy(Notebook n) {  //�Լ��� ��ǰ ��ü�� parameter �޾Ƽ� (����, ����Ʈ)
//        if(this.money< n.price) {
//            System.out.println("���� �ܾ��� �����մϴ�^^! "+this.money);
//            return; //�Լ� ���� > kttvBuy Ż�� (���� ���� ����)
//        }
//        
//        //�� ���� ����
//        this.money -= n.price;  //�ܾ�
//        this.bonusPoint += n.bonusPoint;
//        System.out.println("������ ������: "+n.toString());
//    }
    
    //2�� �ڵ� ����(�����丵)
    //[�ϳ��� �̸�]���� ���� ���� ���(method overloading)
//    void buy(�� ��ü �Ű�����){}
    
    
    //3�� �ڵ� ����(�ߺ� �ڵ� ����)
    //��ǰ�� �߰� �Ǵ��� ���������� ��ӵǾ�� �Ѵ�
    //why: ��ſ� �ް��� ������ ���ؼ�
    //�ϳ��� �̸����� ... �ݺ��ڵ� ����..
    //KEY POINT: ��� ��ǰ�� Product�� ����ϰ� �ִ�
    //��� ��ǰ�� �θ�� Product
    //Product P;
    //Audio audio = new Audio
    //p = new Audio();
    //�� �θ�� �ڽ� �͸� ���� ����
    //***toString() �ڽ��� �������̵� > �θ�Ÿ���� �����ص� �ڽ� �������̵��� �Ѿ��
    
    void buy(Product n) {
        if(this.money< n.price) {
            System.out.println("���� �ܾ��� �����մϴ�^^! ���� �ܾ�:"+this.money);
            return; //�Լ� ���� > kttvBuy Ż�� (���� ���� ����)
        }
        
        //�� ���� ����
        this.money -= n.price;  //�ܾ�
        this.bonusPoint += n.bonusPoint;  
        System.out.println("������ ������: "+n.toString());
        System.out.println("�ܾ�: "+this.money);
        System.out.println("����Ʈ: "+this.bonusPoint);
    } 
}



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


public class Ex12_Inherit_KeyPoint {

	public static void main(String[] args) {
		
	     ktTv kttv = new ktTv();
	     System.out.println(kttv.toString());
	     
	     Audio audio  = new Audio();
         System.out.println(audio.toString());
         
         Notebook notebook = new Notebook();
         System.out.println(notebook.toString());
         
         Buyer buyer = new Buyer(); //��
         
         //1�� ���� �׽�Ʈ
         //��������
         buyer.buy(kttv);
         buyer.buy(notebook);
         buyer.buy(audio);
         buyer.buy(kttv);
         buyer.buy(kttv);
         

         
         
	    
	    
	    
	    
         
         
         
         
	    
	    
	    
	}

}
