//����: unit(����)

//unit ������ (�̵� ��ǥ, �̵�, �����)
//unit �̵� ����� �ٸ���(�̵������ unit���� ������ ���� �ʿ� > �����ϰ� �ʹ�)
//abstract class �̸� {abstract �̵�();}

abstract class Unit{
    int x, y;
    void stop() {
        System.out.println("Unit stop");
    }
    //�̵� (����)
    abstract void move(int x, int y);   //�߻��ڿ�
}

//Tank
class Tank extends Unit{

    @Override
    void move(int x, int y) {
        this.x =x;
        this.y =y;
        
        System.out.println("Tank �̵�: "+this.x+","+this.y);
    }
    //Tank Ư��ȭ(��üȭ)
    void changeMode() {
        System.out.println("�ʱ� ��ȯ ���");
    }
    
}

class Marine extends Unit{

    @Override
    void move(int x, int y) {
        this.x =x;
        this.y=y;
        System.out.println("Marine �̵�: "+this.x+","+this.y);
    }
    void stimpack() {
        System.out.println("�����ѱ��");
    }
     
}
class Dropship extends Unit{
    @Override
    void move(int x, int y) {
        this.x =x;
        this.y=y;
        System.out.println("Dropship �̵�: "+this.x+","+this.y);
    }
    void load() {
        System.out.println("Unit load");
    }
    void unload() {
        System.out.println("Unit unload");
    }
}


public class Ex02_abstract_class {

    public static void main(String[] args) {
        Tank t = new Tank();
        t.move(500,200);
        t.stop();
        t.changeMode();
        
        Marine m = new Marine();
        m.move(500, 300);
        m.stop();
        m.stimpack();
        
        //1. ��ũ 3�븦 ����� [���� ��ǥ]�� �̵� (33,44)
        
        Tank[] tanklist = {new Tank(), new Tank(), new Tank()};
        for(Tank tank : tanklist) {
            tank.move(33, 44);
        }        
        
        //2. ���� ���� Unit(Tank1, Marine 1, Dropship 1)�� ���� ��ǥ�� �̵���Ű����.
        
        Unit[] unitlist = {new Tank(), new Marine(), new Dropship()};
        for(Unit unit: unitlist) {
            unit.move(111, 222);
        }
        
        
        
        
        
        
        
        
        
        
        

        
        
        
        
        
        
        
        
    }

}
