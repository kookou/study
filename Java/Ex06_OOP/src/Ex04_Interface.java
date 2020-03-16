//���� �ٸ� Ŭ������ �ϳ��� �θ�� �����ִ� ����
interface Irepairable {

}

class Unit2 {
    int hitpoint; // �⺻ ������
    final int MAX_HP;

    Unit2(int hp) {
        this.MAX_HP = hp;
    }
}

//��������
class GroundUnit extends Unit2 {

    GroundUnit(int hp) {
        super(hp);
    }

}

class CommandCenter implements Irepairable {

}

//��������
class AirUnit extends Unit2 {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank2 extends GroundUnit implements Irepairable {
    Tank2() {
        super(500);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Tank2";
    }
}

class Marine2 extends GroundUnit{
    Marine2() {
        super(50);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Marine2";
    }
}

class Scv extends GroundUnit implements Irepairable {

    Scv() {
        super(60);
        this.hitpoint = this.MAX_HP;
    }



    @Override
    public String toString() {
        return "Scv";
    }
    // Scv ��üȭ, Ư��ȭ, ������ ���
    // repair(�����ϴ�)
//    void repair(Tank2 tank) {
//        if(tank.hitpoint!=tank.MAX_HP) {
//            tank.hitpoint+=5;
//        }
//    }
//    
//    void repair(Scv scv) {
//        if(scv.hitpoint!=scv.MAX_HP) {
//            scv.hitpoint+=5;
//        }
//    }
    /*
     * Scv�� repair�ϴ� Unit ������ �����ϸ� Unit ������ŭ repair �Լ� �߰� ���: �ϳ��� repair �Լ��� ���
     * repair ������ Unit�� ������ �� ������ ������ Ȱ���ϸ� ���ٵ�, �츮�� ������ �ִ� ��� Unit�� repair ����� �ƴϴ�
     */

//    void repair(GroundUnit unit) {   //�̷��� �ϸ� ������ ������ϰ� ��. �츮�� ���ǰ� �ȸ���. 
//        if(unit.hitpoint!=unit.MAX_HP) {
//            unit.hitpoint+=5;
//        }
//    }

//    void repair(Unit2 unit) {   //�̷��� �ϸ� AirUnit�� ������ ������ϰ� ��. �Դٰ� Ŀ�ǵ弾�ʹ� �������� ���� 
//        if(unit.hitpoint!=unit.MAX_HP) {
//            unit.hitpoint+=5;
//        }
//    }

    // �� �ᱹ���� ���� �������� ����

    // �ذ��: Interface
    // 1. ���� �������� ���� Ŭ������ ���ؼ� �ϳ��� ���� ��� ����(���� �θ� ����)
    // -> interface�� �ϳ��� Ÿ���̱� ����

    void repair(Irepairable repairableUnit) {
        // repairableUnit ������ Tank2, CommandCenter, Scv

        /*
         * repair�ϴ� ��� CommandCenter�� �� �� ������ Unit�� �ƴϴ� >> ���� ����� �ٸ��� reparableUnit�� �ڱ�
         * ���� ���� �θ�� �ڽ��� �͸� Unit2 >> hitpoint, MAX_HP ���� (Irepairable repairableUnit) ��
         * Tank2 Ÿ������ �ٿ�ĳ���� �ʿ� downcasting -> Tank2 tank =(Tank2)repairableInit (���� Ÿ����
         * ���� Ÿ������) downcasting -> Scv scv = (Scv)repariableUnit(���� Ÿ���� ���� Ÿ������)
         * 
         * ��� Tank2 > GroundUnit > Unit2 Scv > GroundUnit > Unit2 ������: Unit2
         * 
         * CommandCenter > Unit2(x)
         */
        // ���� ������ ���ָ� parameter�� �޴µ�
        // �� parameter�� �ٸ� ������ĵ� ����
        if (repairableUnit instanceof Unit2) {
            Unit2 unit = (Unit2) repairableUnit;    // �ٿ�ĳ�����ؼ� hitpoint�� MAX_HP�� ��� �����ϰ� �ϴ� ���� ����Ʈ.>> Irepairable�� �ƹ� ������ ���� �������̽��̱� ����
            if (unit.hitpoint != unit.MAX_HP) {
                unit.hitpoint = unit.MAX_HP;
            } else { // Unit2�� �θ�� ������ ���� ������
                     // �ڵ� ����
                System.out.println("Unit2�� �ƴϿ���. �ٸ� ������� repair�մϴ�.");
            }

        }

    }
}

public class Ex04_Interface {

    public static void main(String[] args) {
        
        Tank2 tank = new Tank2();
        Marine2 marine = new Marine2();
        Scv scv = new Scv();
        CommandCenter commandCenter = new CommandCenter();
        
        //����
        tank.hitpoint -=20;
        System.out.println("��ũ: "+ tank.hitpoint);
        System.out.println("Scv ���� ��û");
        scv.repair(tank);   // repari �޼��� �ϳ��� tank, scv, commandCenter ��� ���� ����������.
        System.out.println("��ũ ���� �Ϸ�: "+tank.hitpoint);
        
        
        
 
        
        
        
        
        
        
        
        
        
        

    }

}
