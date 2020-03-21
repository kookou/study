import java.io.File;
import java.util.Arrays;

//�ش� �ڹ������� �ִ� ���� ��ο��� javac�� �̿��� Ŭ�������� ���� �� java ��ɾ� �Է��ϰų�
//��Ŭ���� �� �̿����� ���, bin���� ��η� �̵��� java ��ɾ� �Է�

public class Ex08_File_Directory {

	public static void main(String[] args) {
		// java Ex08_File_Directory aaa ���� //cli �󿡼� ���� �����ϸ鼭 ���ϸ� �ڿ� �Է��� ���� args�� ���޵�
//        System.out.println(args.length);
//        System.out.println(args[0]);

		// ��ɾ� �Է� üũ
		if (args.length != 1) { // ��ɾ ����� �Է��� ��찡 �ƴ� ��
			System.out.println("����: java ���ϸ�[���丮��]");
			System.exit(0); // ���� ����
		}

		// �������� üũ
		File f = new File(args[0]);
		if (!f.exists() || !f.isDirectory()) { // �������� �ʰų� or ���丮(����)�� �ƴ϶��
			System.out.println("��ȿ���� ���� ����Դϴ�.");
		}

		// ���� �����ϴ� ��ο� �ִ� �������
		File[] files = f.listFiles(); // f���� ��� ������ ������ ��ΰ� >> �迭�� ����
		// C:\\Temp\\1.jpg >>�ϳ� �ϳ��� File ��ü�� ���
		// c:\\Temp\\a.txt
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName(); // ���ϸ�, ������
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
		}
	}
}
