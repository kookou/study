
//�������� ���/���԰��� �ó����� �����


class Coffee {
    int water;
    int coffeeBean;
    
    void roasting() {
        System.out.println("�ν����Ѵ�");
    }
    
    Coffee(){
        this(50,5);
    }
    
    Coffee(int water, int coffeeBean){
        this.water=water;
        this.coffeeBean=coffeeBean;
    }
    
}

class Caffelatte extends Coffee {
    Milk milk;
    
    Caffelatte(){
        this(new Milk());
    }
    Caffelatte(Milk milk){
        this.milk = milk;
        
    }
    
}

class Milk {
    String origin;
    String level;
    
    Milk(){
        this("�����", "1���");
    }
    Milk(String origin, String level){
        this.origin = origin;
        this.level = level;
    }
}



public class Inherit_composition_groupwork {

    public static void main(String[] args) {
        
        Caffelatte caffelatte = new Caffelatte();
        System.out.println("Ŀ������ ����: "+ caffelatte.coffeeBean);
        System.out.println("���� ��: "+ caffelatte.water);  
        System.out.println("���� ������: "+caffelatte.milk.origin+"���� ���: "+ caffelatte.milk.level);
        caffelatte.roasting();

        
    }

}
