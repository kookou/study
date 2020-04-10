import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.utils.SingletonHelper;

/*
create table trans_A(
	num number,
	name varchar2(20)
);

create table trans_B(
	num number constraint pk_trans_B_num primary key,
	name varchar2(20)
);

JDBC >> default(DML) >> auto commit

JDBC >> autocommit >> false >> �����ڰ� (commit, rollback ����)

*/
public class Ex06_Oracle_Transaction {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		conn = SingletonHelper.getConnection("Oracle");
		String sql="insert into trans_A(num,name) values(100,'A')";
		String sql2="insert into trans_B(num,name) values(100,'B')";
		try {
			conn.setAutoCommit(false); //App���� Ŀ��, �ѹ� �� �� �ִ�
			//begin tran
			//transaction�̹Ƿ� �� �� ����, �� �� ����  ��츸 �ִ�
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			pstmt2=conn.prepareStatement(sql2);
			pstmt2.executeQuery();
			
			//������� ���� >> �� �� �����̸�
			conn.commit(); // �� �������� �� �ݿ�
			System.out.println("commit");
			//end tran			
			
		} catch (Exception e) {
			//����ó��
			System.out.println("�����ϸ�..."+e.getMessage());
			try {
				conn.rollback();
				System.out.println("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			SingletonHelper.close(pstmt2);
			SingletonHelper.close(pstmt);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
