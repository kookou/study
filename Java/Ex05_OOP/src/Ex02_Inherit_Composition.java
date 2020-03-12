/*
 * ���赵 1��  >> ������ �������� ������ 
 * ������ ����������  1�� �̻��� ���赵 ����
 * ���> ���θ�> ȸ������, �ֹ�����, ��۰��� ... ���赵 5��
 * **������** (����)
 * 
 * 1. ��� ����(is ~ a:) ��~ �̴�.
 * 
 * 2. ���� ����(has ~ a:) ��~ �� ������ �ִ�.
 * 
 * ��)
 * ��Ŭ����  ����Ŭ����
 * >> �� extends ���� (��� ����)
 * 
 * ��Ŭ���� ��Ŭ����
 * >>���� ���̴�(x)
 * >>���� ���� ������ �ִ�(o)
 * >>has ~ a 
 * >>class �� {�� ������} //����ʵ�� ����
 * 
 * ����Ŭ���� ��Ŭ����
 * ������ ���̴�(x)
 * ������ ���� ������ �ִ�(o)
 * class ����{���� ����;}
 * 
 * ��, �ﰢ��, �簢�� ����� ���赵 �ۼ�
 * 
 * ���� �����̴�
 * �ﰢ���� �����̴�
 * �簢���� �����̴�
 * 
 * ����: �߻�ȭ, �Ϲ�ȭ (�׸���, ����) >> ���� �ڿ�
 * 
 * ��: ��üȭ, Ư��ȭ (������, ��) >>���� ���� ������ Ư¡
 * 
 * ��: ��ǥ��(x,y)
 * ���� ���� ������ �ִ�
 * �ﰢ���� ���� ������ �ִ�
 * �簢���� ���� ������ �ִ�
 * 
 * class Shape: �Ϲ�ȭ, �߻�ȭ, ����(�׸���, ����)
 * class Point: ��
 * 
 * circle, triangle, square : ��üȭ, Ư��ȭ
*/
//�߻�ȭ, �Ϲ�ȭ, ����
class Shape {
    String color = "gold";

    void draw() { // ���� ���
        System.out.println("�׸���");
    }
}

//����
class Point {
    int x;
    int y;

    Point() {
        this(1, 1);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//����: ���� ���弼��(���� ����; ���� �� ���� �������� ������ �ִ�)
//1. ���� �����̴� (is ~ a): ����(shape)
//2. ���� ���� ������ �ִ�(has ~ a): ��(point)
//3. ���� �������� ������ �ִ�(Ư����): r
//4. ���� �������� default������ 10�� ������
//5. ���� x, y ��ǥ�� default��(10,15)
//6. �⺻���� �������� ������ �������� ���� ���� �Է¹��� �� �ִ�(���� ������� ��)

class Circle extends Shape {
    Point point;
    int r;

    Circle() {
//        this.point = new Point(10,15);
//        this.r = 10;
        this(10, new Point(10, 15)); // �� ��° �Ű������� new �����ڸ� ���� �� Today Point.
    }

    Circle(int r, Point point) {
        this.r = r;
        this.point = point; // �ּҰ� �Ҵ�
    }
}

//���� 2)
//�ﰢ�� Ŭ������ ���弼��
//����) �ﰢ���� 3���� ���� ����  �׸��� �׸��ٶ�� ����� ������ �ִ�
//Shape, point ���� �޾ƿ�
//hint) (x,y)  (x,y)  (x,y) 3���� ��ǥ�� 
//default �� �׸� �� �ְ� , 3���� ��ǥ���� �޾Ƽ� �׸� �� �ִ�
class Triangle extends Shape {
    Point point1;
    Point point2;
    Point point3;

    Triangle() {
        this(new Point(0, 0), new Point(1, 1), new Point(2, 2));

    }

    Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    // ��üȭ, Ư��ȭ
    // �߰����� ���
    void trianglePoint() {
        System.out.printf("������1: (%d,%d), ������2: (%d,%d), ������3: (%d,%d)%n", point1.x, point1.y, point2.x, point2.y,
                point3.x, point3.y);
    }
}

class Triangle2 extends Shape {
    Point[] pointArray;

    Triangle2() {
//            pointArray = new Point[3];
//            pointArray[0] = new Point(10,20);
//            pointArray[1] = new Point(30,40);
//            pointArray[2] = new Point(50,60);
//            pointArray = {new Point(10,20),new Point(30,40),new Point(50,60)};  �� ��° ����� ����� �Ҵ��� ���ÿ� ���� ������ ������
        this(new Point[] { new Point(10, 20), new Point(30, 40), new Point(50, 60) });
    }

    Triangle2(Point[] pointArray) {
        this.pointArray = pointArray;
    }

    // ��üȭ, Ư��ȭ
    // �߰����� ���
    void triangle2Point() {
        for (Point point : this.pointArray) {   //this�� ��� ������� ������?
            System.out.printf("point : (%d,%d)\t", point.x, point.y);
            System.out.println();
        }
    }
}

//�簢�� ����� ������

class Square extends Shape {
    Point[] squarePointArr;
    
    Square(){
        this(new Point[] {new Point(0,0),new Point(1,1),new Point(2,2),new Point(3,3)});
    }
    Square(Point[] squarePointArr) {
        this.squarePointArr = squarePointArr;
        
    }
}

public class Ex02_Inherit_Composition {
    public static void main(String[] args) {

        Circle circle = new Circle();
        System.out.printf("������: %d / ��: (%d,%d)\n", circle.r, circle.point.x, circle.point.y);
        System.out.println("�θ�: " + circle.color);
        circle.draw();

        Circle circle2 = new Circle(20, new Point(2, 5));
        System.out.printf("������: %d / ��: (%d,%d)\n", circle2.r, circle2.point.x, circle2.point.y);
        System.out.println("�θ�: " + circle2.color);
        circle2.draw();

        Triangle triangle = new Triangle();
        triangle.trianglePoint();
        System.out.println("����: " + triangle.color);
        triangle.draw();

        Triangle triangle1 = new Triangle(new Point(3, 3), new Point(4, 4), new Point(5, 5));
        triangle1.trianglePoint();
        triangle1.color = "coral blue";
        System.out.println("����: " + triangle1.color);
        triangle1.draw();

        Triangle2 triangle2 = new Triangle2();
        triangle2.triangle2Point();
        System.out.println("����: " + triangle2.color);
        triangle2.draw();

        Triangle2 triangle3 = new Triangle2(new Point[] { new Point(3, 3), new Point(4, 4), new Point(5, 5) });
        triangle3.triangle2Point();
        triangle3.color = "coral blue";
        System.out.println("����: " + triangle3.color);
        triangle3.draw();
        

        

    }

}
