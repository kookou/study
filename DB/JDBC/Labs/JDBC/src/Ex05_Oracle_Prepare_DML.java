import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.SingletonHelper;

public class Ex05_Oracle_Prepare_DML {

	public static void main(String[] args) {
		//insert
		//insert into dmlemp(empno,ename,deptno) values(?,?,?)
		//update
		//update dmlemp set ename=?, sal=?, job=?, deptno=?
		//where empno=?
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try {
			conn= SingletonHelper.getConnection("Oracle");
			String sql = "update dmlemp set ename=?, sal=?, job=?, deptno=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			//parameter �����ϱ�
			pstmt.setString(1,  "ȫ�浿");
			pstmt.setInt(2, 5000);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 20);
			pstmt.setInt(5,9999);
			
			//����
			int row = pstmt.executeUpdate(); //�������� �̹� DB������ �����ϵż� ����
			if(row>0) {
				System.out.println("update row count : "+ row);
			}else {
				System.out.println("row count" + row);
			}
		} catch (Exception e) {
		}

	}

}
