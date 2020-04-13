package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import Utils.SingletonHelper;

//DAO
//1. DB����
//2. CRUD �Լ�
//3. �ϳ���  ���̺��� ������� () >> Dept ���̺� ������� �Լ� � ������ 
//(select (��ü��ȸ) , select (1�� .. ����(pk) where , insert , update , delete)
public class DeptDao_t {
	//1. ��ü��ȸ >> select ��� >> return Multi row
	public List<Dept> getDeptAllList(){
		//DB���� >> ���  >> ��ɽ���  >> ó��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql="select deptno , dname , loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); //[dept][dept]...
			}
		}catch (Exception e) {
			System.out.println("���� : " + e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return deptlist;
	}
	
	//2. ������ȸ >> select ..where deptno=? >> parameter ���� >> return Single row
	public Dept getDeptListByDeptno(int deptno) {
		//DB���� >> ���  >> ��ɽ���  >> ó��
		Dept dept = null; //

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dept = new Dept(); // �ϳ��� row ��� ���� ��ü
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return dept;
	}
	
	//3. ������ ����
	//public int insertDept(int deptno , String dname, String loc) ... 
	public int insertDept(Dept dept) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setInt(1, dept.getDeptno());
			 pstmt.setString(2, dept.getDname());
			 pstmt.setString(3, dept.getLoc());
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
    
	//4. ������ ���� (������ �÷� ����)
	//update dept set dname=? , loc=? where deptno=?
	public int updateDept(Dept dept) {
		//DB���� >> ���  >> ��ɽ���  >> ó��
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="update dept set dname=? , loc=? where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dept.getDname());
			 pstmt.setString(2, dept.getLoc());
			 pstmt.setInt(3, dept.getDeptno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//5. ������ ���� (1��)
	public int deleteDept(int deptno) {
		//DB���� >> ���  >> ��ɽ���  >> ó��
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from dept where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, deptno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;

	}
}





