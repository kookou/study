import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InstanceApp {

	public static void main(String[] args) throws IOException {
		
		PrintWriter p1 = new PrintWriter("result1.txt");
		p1.write("Helllo 1");
		p1.close();
		
		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("Helllo 2");
		p2.close();

	}

}
/*
� Ŭ������ ����� �� ��ȸ������ ����ϴ� ��� ex)Math �� �ְ�, ���� �� �����ؾ� �ϴ� ���
ex)PrintWriter �� �ִ�. �ν��Ͻ��� ���� �� ����ؾ� �ϴ� Ŭ������ ���� ����� �����ϰ� �ϱ� ����
�ʿ��ϴ�. �� ��, ������ �ش� Ŭ���� �Ʒ� �ξ� ex) PrintWriter p1  �� Ŭ������ � ���� �� �� ��
�°��� �����ϱ� ���ؼ� �տ� Ŭ���� ���� ���´�. �ν��Ͻ� ����� ������ Ŭ������ Constructor�� �����ϴµ�
new �ڿ� ���� �ڵ���� Constructor�� �ش��Ѵ�. instance�� new + Constructor�̴�.
 */

/*
 �ʵ� : �ڹٿ����� ������ �ʵ��� ��
�޼ҵ� : Ŭ���� ���� '���'���� ��
Ŭ���� : ����� �ʵ�(����)�� �޼ҵ���� ���� �� ��
��Ű�� : ����� Ŭ�������� ���� �� ��
�ν��Ͻ� : ��ȸ������ ���Ǵ� Ŭ�������� �ƴ϶� �����ϰ� �پ��ϰ� ���� �� �ִ� Ŭ��������
����� �� �����Ǵ� ������
�׷� Ŭ�������� ����Ϸ��� �� Ŭ������ �̿��Ͽ� �ν��Ͻ��� ����� ����ؾ� �Ѵ�.
�׸��� �׷��� Ŭ�������� ������(constructor)�� ������ �ִ�.
��� : �θ�κ��� ������ �޼ҵ���� �޾ƿͼ� �״�� ����� ���� �ְ�
�Ǵ� �ڱ� �Ը���� �����Ͽ�(override) ����� ���� �ִ�.
�ڵ峻������ extends�� �Ἥ ����Ѵ�.	 ex)public class Student extends Teacher
 */