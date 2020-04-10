package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DTO.Dept;
import Utils.SingletonHelper;

/*
 * DAO
 * 1. DB����
 * 2. CRUD �Լ�
 * 3. �ϳ��� ���̺��� ������� () >> Dept ���̺� ������� �� �� �� �� ������
 * (select(��ü��ȸ), select(1�� ... ����(pk)), insert, update, delete)
*/
public class DeptDao {
	
	//1. ��ü��ȸ >> select ��� >> return Multi row
	public List<Dept> getDeptAllList(){
		//DB���� >> ��� >> ��ɽ��� >> ó��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			conn = SingletonHelper.getConnection("Oracle");
			String sql = "select deptno , dname , loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	//excuteQuery: select ���� ó���ϴ� �޼���
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); // [dept][dept]...
			}
		} catch (Exception e) {
			System.out.println("���� : " + e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
	
		return deptlist;
	}
	
	//2. ������ȸ>> select .. where deptno=? >> parameter ���� >> deptno�� pk�̹Ƿ� return�� single row
	public Dept getDeptListByDeptno(int deptno) {
		//DB���� >> ��� >> ��ɽ��� >> ó��		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "select deptno, dname, loc from dept where deptno="+deptno;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}			
			
		} catch (Exception e) {
			System.out.println("����: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//������ ��� ���� app����ִ� ��	
		}	
		return dept;
	}
	
	//3. ������ ����
//	public int insertDept(int deptno, String dname, String loc) �̺��ٴ�
	public int insertDept(Dept dept) {
		//DB���� >> ��� >> ��ɽ��� >> ó��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//��ü �����ϱ�
			pstmt.setInt(1,  dept.getDetpno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			//����
			row = pstmt.executeUpdate(); // excuteUpdate: insert, update, delete�� ó���ϴ� �޼���
			if(row>0) {
				System.out.println("insert row count : "+ row);
				System.out.println(getDeptListByDeptno(dept.getDeptno()).toString());
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("����: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//������ ��� ���� app����ִ� ��	
			
		}	
		return row;
	}
	//4. ������ ����(������ �÷� ����)
	//update dept set dname=?, loc=? where deptno=?
	public int updateDept(Dept dept) {
		//DB���� >> ��� >> ��ɽ��� >> ó��
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "update dept set dname=?, loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			//parameter �����ϱ�
			pstmt.setInt(3, dept.getDetpno());
			System.out.println("������ dname�� �Է��� �ּ���.");
			String dname = sc.nextLine();
			pstmt.setString(1, dname);
			System.out.println("������ loc�� �Է��� �ּ���.");
			String loc = sc.nextLine();
			pstmt.setString(2, loc);
								
			//����
			row = pstmt.executeUpdate(); //�������� �̹� DB������ �����ϵż� ����
			if(row>0) {
				System.out.println("update row count : "+ row);
				System.out.println(getDeptListByDeptno(dept.getDeptno()).toString());
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("����: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//������ ��� ���� app����ִ� ��	
			
		}	
		return row;
	}
	
	//5. ������ ����(1��)
	public int deleteDept(int deptno) {
		//delete from copyemp where deptno
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		try {
			conn=SingletonHelper.getConnection("Oracle");
			String sql = "delete from dept where deptno="+deptno;
			pstmt = conn.prepareStatement(sql);						
			//����
			row = pstmt.executeUpdate(); //�������� �̹� DB������ �����ϵż� ����
			if(row>0) {
				System.out.println("delete row count : "+ row);
			}else {
				System.out.println("row count" + row);
			}
					
		
			
		} catch (Exception e) {
			System.out.println("����: "+ e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//������ ��� ���� app����ִ� ��	
			
		}	
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
