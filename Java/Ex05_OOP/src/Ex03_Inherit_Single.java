//�� ���� ���赵
class Tv{
    boolean power;
    int chennel;
    void power() {
        this.power = !this.power;
    }
    void chUp() {
        this.chennel++;
        
    }
    void chdown() {
        this.chennel--;
    }
    
}


class Vcr{ //���� �÷��̾�
    boolean power;
    void power() {
        this.power = !this.power;
    }
    void play() {
        System.out.println("����ϱ�");
    }
    void stop() {
        System.out.println("�����ϱ�");
    }
    void rew() {
        
    }
    void ff() {
        
    }
}
// Tv ���赵, Vcr ���赵
// TvVcr ��� ���赵�� ����� �ּ���
// ������ Tv, Vcr ���赵 �� �̿��غ�
// ���, ����

//class TvVcr extends Tv, Vcr{} // ���� ��ӱ����� �ȵ�
//class Tv extends Vcr
//class TvVcr extend Tv //������ ���.. ���� �̸��� ��ɵ��� �浹

//TvVcr �� ���: ���� ��� >> ������ ���� Ŭ������ ��ӹް�, �������� �������� ����

class TvVcr extends Tv{
    Vcr vcr;
    TvVcr(){
        vcr = new Vcr();
    }
}



public class Ex03_Inherit_Single {

    public static void main(String[] args) {
        TvVcr t = new TvVcr();
        t.power();
        System.out.println("Tv ���� ����: "+t.power);
        t.chUp();
        System.out.println("Tv ä�� ����: "+t.chennel);
        
        //����
        t.vcr.power();
        System.out.println("���� ���� ����: "+t.vcr.power);
        t.vcr.play();
        t.vcr.stop();
        
        t.vcr.power();
        t.power();
        System.out.println("Tv ���� ����: "+t.power);
        System.out.println("���� ���� ����: "+t.vcr.power);
        
        
        
        
        
        
        
        
        
    }

}
