
public class Ex07_Cinema {
	public static void main(String[] args) {
		String[][] seat = new String[3][5];
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "___";
			}
		}
		seat[2][1] = "ȫ�浿"; // ����
		seat[0][0] = "������"; // ����

		// �¼����� �����ֱ�
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].equals("___") ? "�ڸ�" : "����");
			}
			System.out.println();
		}

		int row, col;
		row = 0;
		col = 0;
		if (seat[row][col].equals("___")) {
			System.out.println("���� �����մϴ�");
		} else {
			System.out.println("�̹� ���� �Ǿ����ϴ�");
		}

		// �¼��ʱ�ȭ
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "___";
			}
		}
	}

}
