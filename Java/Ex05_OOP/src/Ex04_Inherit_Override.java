/*
 * Today Point
 * [��� ����]���� override: ��� ���迡�� �޼���[������]
 * [��� ����]���� [�ڽ� Ŭ����]�� [�θ� Ŭ����]�� �޼��带 ������(���� �ٲ۴�)
 * ������: Ʋ�� ��ȯ(�Լ� �̸�, Ÿ��)�ϴ� ���� �ƴϰ� ����(���Ǻ�)�� �ٲ�
 * ����)
 * 1. �θ� �Լ� �̸��� ����
 * 2. �θ� �Լ� parameter ����
 * 3. �θ��Լ� return Type ����
 * 4. ���Ǻ�{}�� �ٲ�
 * 
 * �����ε��� �������̵��� ����
 * �����ε�: �ϳ��� �̸����� ���� ���
 * �������̵�: ��� ���迡�� �޼��� ������
*/

class Point2{
    int x = 4;
    int y = 5;
    String getPosition() {
        return "x:"+this.x +" y:"+this.y;
    }
}

class Point3D extends Point2 {
    int z = 6;
    //�θ��� �Լ��� Ʋ�� ���� > ���븸 �ٸ�
    //������
    //Annotation�� Java code ������ ������ �� ���� [�ΰ����� ����]�� �����Ϸ�, �������� �����ϴ� ����� ��
    //@Override >> Annotation >> �����Ϸ�, ���������� ������ �˻縦 �϶�� ����
    @Override           //������̼�
    String getPosition() {  //�������̵��� �޼���
        return "x:"+this.x +" y:"+this.y+" z:"+this.z;
    }
}


public class Ex04_Inherit_Override {
    
    public static void main(String[] args) {
        Point3D po = new Point3D();
        System.out.println(po.getPosition());  //�������� �Լ��� ȣ��
        
        
        
        
    }

}
