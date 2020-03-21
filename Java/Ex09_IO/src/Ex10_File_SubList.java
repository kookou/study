import java.io.File;
import java.util.ArrayList;

public class Ex10_File_SubList {
	static int totalfiles = 0;
	static int totaldirs = 0;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("����: java [������ ���ϸ�] [��θ�]");
			System.out.println("����: java Ex10_File_SubList C:\\Temp");
			System.exit(0);
		}

		File f = new File(args[0]);

		// ��θ� üũ(�������� ��)
		if (!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮");
			System.exit(0);
		}

		// �������� ���, ����
		printFileList(f);
		System.out.println("���� �� ���� ��: " + totalfiles);
		System.out.println("���� �� ���� ��: " + totaldirs);

	}

	static void printFileList(File dir) {
		System.out.println("[Full Path: " + dir.getAbsolutePath() + "]");
		ArrayList<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles();
		// C:\\Temp
		// files[0] >> a.txt
		// files[1] >> aaaa

		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getName(); // ������ or ���ϸ�
			if (files[i].isDirectory()) {
				filename = "<DIR> [" + filename + "]"; // ������� �̷���
				subdir.add(i); // �������� ��̸���Ʈ files�迭���� ������ ���� �ε����� ����
			} else {
				filename = filename + "/" + files[i].length() + "Byte"; // �����̶�� �̷���
			}
			System.out.println("   " + filename);

		}
		int dirnum = subdir.size(); // ���� ����
		int filenum = files.length - dirnum; // ���ϰ���

		// ������(���� ���� ���� �)
		totaldirs += dirnum;
		totalfiles += filenum;

		System.out.println("[Current dirNum] : " + dirnum);
		System.out.println("[Current fileNum] : " + filenum);
		System.out.println("******************************");

		// Point
		for (int i = 0; i < subdir.size(); i++) {
			int index = subdir.get(i);
			printFileList(files[index]); // subdir�� ������ files�� index�� �̿�
		}
	}
}
