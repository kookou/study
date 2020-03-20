import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IO_Groupwork {
    static int totalfiles = 0;
    static int totaldirs = 0;

    public static void main(String[] args) throws IOException {

        // java ExDos C:\Temp mkdir newDir
        // java ExDos C:\Temp rename file.txt file2.txt
        // java ExDos C:\Temp delete new.txt

        if (args.length != 2 && args.length != 3 && args.length != 4) {
            System.out.println("���� : [java���ϸ�] [���丮���] mkdir [�������丮��]");
            System.out.println("���� : [java���ϸ�] [���丮���] rename [���ϸ�] [���ο� ���ϸ�]");
            System.out.println("���� : [java���ϸ�] [���丮���] delete [���ϸ�]");
            System.out.println("���� : [java���ϸ�] [���丮���] copy [���ϸ�] [���ο� ���ϸ�]");
            System.out.println("���� : [java���ϸ�] [���丮���] type [���ϸ�]");
            System.out.println("���� : [java���ϸ�] [���丮���] dir");
            System.exit(0);
        }

        File f = new File(args[0]);
        if (!f.exists() || !f.isDirectory()) { // �������� �ʰų� ���丮 �ƴ϶��
            System.out.println("��ȿ���� ���� ���丮�Դϴ�");
            System.exit(0);
        }

        // mkdir
        if (args[1].equals("mkdir")) {
            String path = "";
            path = f + "\\" + args[2];
            File newfile = new File(path);
            if (newfile.exists()) {
                System.out.println("�̹� �����ϴ� ���丮�Դϴ�");
            } else {
                newfile.mkdir();
            }
        }

        // rename
        if (args[1].equals("rename")) {
            String path = "";
            path = f + "\\" + args[2];
            File f1 = new File(path);
            // ���� ������ �������� ���� ��
            if (!f1.exists()) {
                System.out.println("�������� �ʴ� ����(����)�Դϴ�.");
            } else {
                f1.renameTo(new File(f + "\\" + args[3]));
            }

        }

        // delete
        if (args[1].equals("delete")) {
            String path = "";
            path = f + "\\" + args[2];
            File newfile = new File(path);
            if (!newfile.exists()) {
                System.out.println("�������� �ʴ� ����(����)�Դϴ�.");
            } else {
                newfile.delete();
                System.out.println("�����߽��ϴ�.");
            }
        }

        // copy
        if (args[1].equals("copy")) {
            String path = "";
            path = f + "\\" + args[2];
            File f1 = new File(path);
            // ���� ������ �������� ���� ��
            if (!f1.exists()) {
                System.out.println("�������� �ʴ� �����Դϴ�.");
                // �ٲٷ��� ���� �������� üũ
            } else if (!f1.isFile()) {
                System.out.println("������ �ƴմϴ�.");
            } else {
                File f2 = new File(f + "\\" + args[3]);
                f2.createNewFile();
                FileReader fr = new FileReader(path);
                FileWriter fw = new FileWriter(f2.toString());
                try {

                    int data = 0;
                    while ((data = fr.read()) != -1) {
                        fw.write(data);
                    }
                    fw.flush();
                } catch (Exception e) {
                } finally {
                    fr.close();
                    fw.close();
                }
            }

        }
        // type(���ϳ��� �����ֱ�)
        if (args[1].equals("type")) {
            String path = "";
            path = f + "\\" + args[2];
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("�������� �ʴ� �����Դϴ�.");
            } else {
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    String line = "";
                    for (int i = 0; (line = br.readLine()) != null; i++) {
                        System.out.println(line);
                    }
                } catch (Exception e) {

                } finally {
                    fr.close();
                    br.close();
                }
            }
        }
        if (args[1].equals("dir")) {
            File di = new File(args[0]);
            if (!f.exists() || !f.isDirectory()) {// ���������ʰų� ���丮�����ٸ�
                System.out.println("��ȿ���� ���� ���丮 �Դϴ�.");
                System.exit(0);
            } else {
                printFileList(di);
            }
        }
    }

    static void printFileList(File dir) {

        System.out.println("[���� full path: ]" + dir.getAbsolutePath());
        ArrayList<Integer> subdir = new ArrayList<Integer>();
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            String filename = files[i].getName();
            if (files[i].isDirectory()) {
                filename = "<DIR> [" + filename + "]";
                subdir.add(i);
            } else {
                filename = filename + "/" + files[i].length() + "byte";
            }
            System.out.println(" " + filename);
        }
        int dirnum = subdir.size(); // ������ ����
        int filenum = files.length - dirnum; // ���ϰ���

        totaldirs += dirnum; // �� ���� ���� ����
        totalfiles += filenum; // �� ���� ���� ����
        System.out.println("[���� �������� " + dirnum + "]");
        System.out.println("[���� ���ϰ��� " + filenum + "]");
        System.out.println("**************************");

    }

}
