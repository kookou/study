package kr.or.bit;
/*
�츮 ȸ��� ����⸦ �ֹ� ���� �Ǹ� �ϴ� ȸ���Դϴ�
�츮 ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ� �Ϸ��� �մϴ�
�䱸����
1.����⸦ �����ϰ� ������� �̸��� ��ȣ�� �ο��ؾ� �մϴ�
2.����Ⱑ ����Ǹ� ������� �̸��� ��ȣ �°� �ο��Ǿ��� Ȯ�� �ϴ� �۾��� �ʿ��մϴ� (������� Ȯ��)
3.�������� ������� ������� ������� �Ѵ�� (����)�� Ȯ�� �� �� �ֽ��ϴ�

AirPlane air = new AirPlane();
AirPlane air2 = new AirPlane();
AirPlane air3 = new AirPlane();

��� �Ʒ� �ڵ�� 50�� >> ������ ���� ����
�׷��� ���ݱ��� ��� �ڵ�� 99��>> �Լ� ���
  
2~3�� �ڿ� �ڵ� �����ؼ� 100������ ��ȯ


*/

public class AirPlane{
    private int airnum;               //private���� �ؼ� ����
    private String airname;           //private���� �ؼ� ����  
    private static int airTotalCount; //private���� �Ͽ� makeAirPlane�Լ��� ������� ������ �� �� 
    
    public void makeAirPlane(int num, String name) {
        airnum=num;
        airname=name;
        //������ ����
        airTotalCount++;
        System.out.printf("��ȣ:[%d], �̸�:[%s]\n", airnum, airname); //���� ��ȣ, �̸� ���� ��� ������ getter�� ����ϸ� ��        
    }
    public void airPlaneTotalCount() {
        System.out.printf("�� ����� ���� ��� :[%d]\n",airTotalCount);
    }
}




//public class AirPlane{
//    public static void main(String[] args) {
//        
//        AirPlaneM air = new AirPlaneM();
//        air.number=1;
//        air.name="bita";
//        air.info();
//       
//        
//        
//        AirPlaneM air2 = new AirPlaneM();
//        air.number=2;
//        air.name="bito";
//        air.info();
//        
//        
//        AirPlaneM air3 = new AirPlaneM();
//        air.number=3;
//        air.name="bitu";
//        air.info();
//        
//        air.totalAP();
//        
//    }
//}
//
//
//
//
//class AirPlaneM {
//
//    public int number;
//    public String name;
//    public static int total;  
//    public AirPlaneM() {
//        total++;
//    }
//    
//    
//    public void info() {
//        System.out.printf("����� ��ȣ: %d, ����� �̸�: %s\n", number,name);
//    }
//    
//    public void totalAP() {
//  
//        System.out.println("�� ���� ����� "+total+"�Դϴ�.");
//        
//    }
//    
//    
//}


