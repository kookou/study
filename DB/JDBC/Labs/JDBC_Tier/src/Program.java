import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DAO.DeptDao;
import DTO.Dept;

public class Program {

	public static void main(String[] args) {
		//ȭ��� ����
//		DeptDao dao = new DeptDao();
//		Dept dept = new Dept();
//		dept.setDetpno(50);
//		dept.setDname("IT");
//		dept.setLoc("SEOUL");
//		int row = dao.insertDept(dept);
		
		Scanner sc = new Scanner(System.in);
		
//		��ü ��ȸ
		DeptDao dao = new DeptDao();
		System.out.println("[��ü��ȸ]**********");
		List<Dept> deptlist = dao.getDeptAllList();
		//ȭ�����
		if(deptlist != null) {
			DeptPrint(deptlist);
		}
		
		//���� ��ȸ
//		DeptDao dao = new DeptDao();
		Dept dept;
		int deptno;
		String dname, loc;
		System.out.println("[���� ��ȸ]***********");	
		System.out.println("��ȸ�� deptno�� �Է��� �ּ���");
		deptno = Integer.parseInt(sc.nextLine());
		dept = dao.getDeptListByDeptno(deptno);
		System.out.println(dept.toString());
	
		//������ ����
		System.out.println("[������ ����]**********");
		System.out.println("�Է��� deptno�� �Է��� �ּ���");
		deptno = Integer.parseInt(sc.nextLine());
		System.out.println("�Է��� dname�� �Է��� �ּ���");
		dname = sc.nextLine();
		System.out.println("�Է��� loc�� �Է��� �ּ���");
		loc = sc.nextLine();
		dao.insertDept(new Dept(deptno, dname, loc));
		
		//������ ����
		System.out.println("[������ ����]**********");
		System.out.println("�ٲٰ��� �ϴ� row�� deptno�� �Է��� �ּ���.");
		deptno = Integer.parseInt(sc.nextLine());
		dept = dao.getDeptListByDeptno(deptno);
		dao.updateDept(dept);
		
		//������ ����
		System.out.println("[������ ����]**********");
		System.out.println("�����ϰ��� �ϴ� row�� deptno�� �Է��� �ּ���.");
		deptno = Integer.parseInt(sc.nextLine());
		dao.deleteDept(deptno);
		if(deptlist != null) {
			DeptPrint(dao.getDeptAllList());
		}
		
	}
	public static void DeptPrint(Dept dept) {
		System.out.println(dept.toString());
	}
	public static void DeptPrint(List<Dept> list) {
		for(Dept dept : list) {
			System.out.println(dept.toString());
		}
	}

}
