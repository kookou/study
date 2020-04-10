import java.sql.*;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex03_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = ConnectionHelper.getConnection("Oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println("���Ῡ��: "+conn.isClosed()); 
		ConnectionHelper.close(conn);
		System.out.println("���Ῡ��: "+conn.isClosed()); 
		
//		Connection conn1 = ConnectionHelper.getConnection("Oracle");
//		System.out.println(conn1.toString());
//		
//		Connection conn2 = ConnectionHelper.getConnection("Oracle");
//		System.out.println(conn2.toString());  
//		oracle.jdbc.driver.T4CConnection@3fd7a715
//		oracle.jdbc.driver.T4CConnection@711f39f9
		//�ּҰ� �ٸ���. getConnection�� ���ο��� new �۾��� ���ؼ� ���� ��ü�� ����
		//�׷��� �ϳ��� APP ���ᰴü �ϳ��� ����ص� ���� �ʳ�?
		//�ϳ��� ���� ����(����)	>> singleton
		
		Connection conn3 = ConnectionHelper.getConnection("Oracle","hr" , "1004");
		System.out.println(conn3.toString());
		System.out.println(conn3.getMetaData().getDatabaseProductName());
		Connection conn4 = ConnectionHelper.getConnection("Oracle","bit" , "1004");
		System.out.println(conn4.toString());
		System.out.println(conn4.getMetaData().getDatabaseProductName());
		
		///////////////////////////////////////
		//�̱��� Ȱ��
		
		Connection sconn = SingletonHelper.getConnection("Oracle");
		System.out.println(sconn.toString());
		sconn = SingletonHelper.getConnection("Oracle");
		System.out.println(sconn.toString());
		//�ٸ� DB�����Ϸ��� �̱��� Ŀ�ؼ� ��ü�� close�ϰ� null �ʱ�ȭ�� ����� �Ѵ�. �� �۾��� �س����� dbclose()
		ConnectionHelper.close(sconn);
		sconn = SingletonHelper.getConnection("mysql");
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
