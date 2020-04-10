import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

public class Program_t {

	public static void main(String[] args) {
		//UI & ��û
		DeptDao dao = new DeptDao();
		
		System.out.println("[��ü��ȸ]*******");
		List<Dept> deptlist= dao.getDeptAllList(); //��û
		//ȭ�鱸��
		if(deptlist != null) {
			DeptPrint(deptlist);
		}
		
		System.out.println("[������ȸ]********");
		Dept dept = dao.getDeptListByDeptno(10);
		if(dept != null) {
			DeptPrint(dept);
		}else {
			System.out.println("SELECT FAIL");
		}

		System.out.println("[������ ����]********");
		Dept insertdept = new Dept();
		insertdept.setDeptno(100);
		insertdept.setDname("IT");
		insertdept.setLoc("SEOUL");
		
		int insertrow = dao.insertDept(insertdept);
		if(insertrow > 0) {
			System.out.println("INSERT ROW : " + insertrow);
		}else {
			System.out.println("INSERT FAIL");
		}
		
		System.out.println("[����� INSERT �� ������ ��ȸ]********");
		deptlist = dao.getDeptAllList(); //����� ���� �ٽ� ��ȸ
		if(deptlist != null) {
			DeptPrint(deptlist);
		}
		
		
		System.out.println("[����� INSERT �� ������ �����ϱ�]********");
		Dept updatedept = new Dept();
		updatedept.setDeptno(100);
		updatedept.setDname("IT_UP");
		updatedept.setLoc("SEOUL_UP");
		
		int updaterow = dao.updateDept(updatedept);
		if(updaterow > 0) {
			System.out.println("UPDATE ROW : " + updaterow);
		}else {
			System.out.println("UPDATE FAIL");
		}
		
		
		System.out.println("[����� UPDATE �� ������ ��ȸ]********");
		deptlist = dao.getDeptAllList(); //����� ���� �ٽ� ��ȸ
		if(deptlist != null) {
			DeptPrint(deptlist);
		}
		
		
		System.out.println("[����� UPDATE �� ������ �����ϱ�]********");
		int deleterow = dao.deleteDept(100);
		if(deleterow > 0) {
			System.out.println("DELETE ROW : " + deleterow );
		}else {
			System.out.println("DELETE FAIL");
		}
		
		
		System.out.println("[����� DELETE �� ������ ��ȸ]********");
		deptlist = dao.getDeptAllList(); //����� ���� �ٽ� ��ȸ
		if(deptlist != null) {
			DeptPrint(deptlist);
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



