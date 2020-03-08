/*
instance variable >> class Car {public String color;}
local variable >> class Car {public void move() {int speed}}
main �Լ� �ȿ� �ִ� ��� ������ : lv >> �ʱ�ȭ�� �ʿ��ϴ�
static variable >> ��ü�� �����ڿ�, ��ü ���� ������ memory�� �ö󰡴� �ڿ�
*/

class Variable {
    int iv;
    /*
     * 1. member field, instance variable
     * 2. Variable v = new Variable(); new�����ڸ� ���� �ν��Ͻ� ������ ���� heap�޸𸮿� iv�� ����
     *    Variable v2 = new Variable(); heap�޸𸮿� iv�� �� ����
     * 3. ����: ������ ������ �Ѵ� (������ �´� Type�� ������ �Ѵ�)
     *    -����(�Ӽ�) >> ����, ����, ��ǰ(����)
     *    -������ �����Ǵ� ��ü���� �ٸ� ���� ���� �� �ִ�.
     *    -�׷��� ������ ���� �ʱ�ȭ�� ���� �ʾƵ� �ȴ�.
     *    -�⺻������ default���� ������ �ִ� : int > 0, float > 0.0, boolean >> false, ����Ÿ�� >> null
     * 4. -new��� �����ڸ� ���ؼ� heap ��ü�� ��������� ���� �ٷ� ���� ����
     */
    static int cv;
    /*
     * 1. class variable(Ŭ���� ����), static variable ((��ü ��)���� ����)
     * 2. ����: ������ ��� �� ***�����Ǵ� ��� ��ü�� �����ϴ� �ڿ�*** : ��ü�� �����ڿ�
     *    heap ������ ������ ��ü���� ���� �ڿ�(���� �ڿ�)
     * 3. Ư¡: ���� ��� : Ŭ�����̸�.static������(��ü�� ����� ���� ���� ��Ȳ������ ���� ����)
     * ex) Math.Random()�� ����ϱ� ���ؼ� Math m = new Math() >> m.Random() ���� ����
     *         ���� ���2: ������ �͵� �ƴϱ⿡ >> ��������.static������ 
     * ex) Variable v = new Variable();
     *     Variable v2 = new Variable();
     *     1. variable.cv   Ŭ���� �̸�����
     *     2. v.cv          ���� �ּҷ�
     *     3. v.cv2         ���� �ּҷ�    �� ���� ����
     * 4. ��������: Hello.java > javac Hello.java > Hello.class
     *            >java.exe Hello ���� ����...  
     *            >class loader System�� ���ؼ� 
     *            >Ŭ���� ����(metadata: ����)�� class area(method area)�� �ø�
     *             �� Ŭ������ ���� ������� � �ڿ��� import �ϰ� �ְ� ������ �� ��.. ���...
     *             �� Ŭ���� �ȿ� static variable �Ǵ� static method ������
     *             �� �༮�� memory(class area)�� �÷� ���´�               
    */
    void method() {
        int lv = 0;
        /*
         * local variable (�Լ� ��������: ��� ���� �ݵ�� �ʱ�ȭ)
         * ���� �ֱ�: �Լ� ȣ��Ǹ� �����Ǿ��ٰ�... �Լ� ������ ���� �Ҹ�
         * �Լ� �ȿ��� ��� ���� �� �ȿ� �� ������ ���� ����
         * for(int i...) >> i������ for�� ����Ǹ� ����... for ������ �Ҹ�
        */
    }
    
}



public class Ex05_Variable_Scope {

    public static void main(String[] args) {
        Variable.cv = 100;
        Variable v = new Variable();
        Variable v2 = new Variable();
        v2.cv = 500;
      
        
        
        
        
        
        
        
        
        
        
        
       
    }

}
