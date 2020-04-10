import java.sql.*;

/*
 * JDBC (�ڹپ� ���ؼ� DB �ٷ�ڴ�)
 * 1. java���(app)�� ���ؼ� Oracle(����Ʈ����)�� �����ϰ� CRUD �۾�
 * 2. java App �ǻ����(� RDBMS ���) : Oracle, Mysql, MSsql
 * 2.1 � ��ǰ�� �����Ŀ� ���� ... ����̹� �غ� �۾�
 * ex) ������ ���� >> ��ǻ�� >> �����͸� ����
 * CASE1 : ���� ���� (�������� ����̹� ��ǻ�� ����� ���)
 * CASE2 : �ν� �ȵǿ� >> ����̹� ��ġ >>���� ȸ�� >>����̹� �ٿ�ε� >> ����(��ǰ) >> ��ġ
 * 2.2 my-sql : https://dev.mysql.com/downloads/connector/j/ �ٿ�ε�
 *     mysql-connector-java-8.0.19
 * 2.3 Oracle : C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 *              https://www.oracle.com/database/technologies/jdbcdriver-ucp-downloads.html
 *             >>ojdbc.jar
 * 3. ����̹� ����(�۾��ϴ� ������Ʈ���� ����) 
 * 3.1 java ������Ʈ > �Ӽ�> bulid path > add external jar >> �߰�
 * 3.2 ����̹� ����� �غ� �Ϸ� >> �޸𸮿� load�ؼ� ��� (new ...)
 * 3.3 class.forName("Ŭ���� �̸�") >> new ������ ȿ��
 * 4.  java code(jdbc api) : ����� �� class ���� �޾Ƽ� ���
 * 4.1 import java.sql.* >> interface, class >>DB�۾�
 * 4.2 �����ڴ� interface�� ���ؼ� �۾�(������)
 * point: interface ���� �� ������ ���� ...>>
 * import java.sql.Connection
 * import java.sql.ResultSet
 * import java.sql.Statement
 * 
 * 5. �۾�����
 * 5.1 DB���� -> ��� -> ���� -> ó�� -> ��������
 * ���: (CRUD) insert, select, update, delete
 * ����: ������ DB������ ����
 * ó��: ����� ����� �������� ȭ�����, �ٸ� �� ���� �� ���� ó��
 * ���� ����: �ڿ��� ����� ����(����� �ڿ��� ������ �÷��Ͱ� �۵� ����)
*/

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DB����
		Class.forName("oracle.jdbc.OracleDriver");  //����̹� ����.  �ֱ� �������� ���� ����
		System.out.println("����Ŭ ����̹� �ε�");
		
		//DriverManager.getConnection: Oracle �������� ���� �ּҰ�(���� ��ü�� �ּҰ�)�� ����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bit","1004"); //�ּ�ã��
		System.out.println(conn.isClosed()); //false�� ���;� ����� ��
		
		//��� ��ü ������
		Statement stmt = conn.createStatement();
		String sql="select empno, ename, sal from emp";
		
		ResultSet rs = stmt.executeQuery(sql); //��� ����  
		//ResultSet ������ �����ؼ� ������ �о
		
		//ó��(ȭ�� ���)
		while(rs.next()) {
			System.out.println(rs.getInt("empno")+"/"+
							   rs.getString("ename")+"/"+
							   rs.getInt("sal"));
		}

		//��������
		rs.close();
		stmt.close();
		conn.close();
		System.out.println(conn.isClosed());
		
		
		
		
		
		
		
		
		
		

	}

}
