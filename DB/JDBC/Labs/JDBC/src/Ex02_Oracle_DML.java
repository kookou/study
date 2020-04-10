import java.sql.*;
import java.util.Scanner;

/*
 * DML(insert, update, delete)
 * JDBC API ���ؼ�
 * 1. ��� ������ ���� <-> select(��� ���� �ִ�)
 * 2. �ݿ� ��� row return
 * java �ڵ�
 * update emp set sal=0 >>14�� ���� >>return 14
 * update emp set sal=0 where empno=11111 >> return 0 >>11111 ����� ���� ������
 * java �ڵ带 Ȱ���ؼ� return�� Ȱ���� ������ © �� �ִ�
 * 
 * KEY POINT
 * 1. Oracle���� DML �۾�(Tool, cmd)�ϸ� �ݵ�� commit or rollback ����
 * 2. JDBC API������ �⺻���� auto commit
 * 3. java code: delete from emp >> ���� >> �ڵ� commit >> �ǹݿ�
 * 4. >> �ʿ信 ���� commit(), rollback()�� java�ڵ忡�� ���� ����
 * 
 * 
ex)
����
 A���� ����(update)
  ..
 B���� �Ա�(update)
��(commit�� ������ �� �ִ�.)
>>�ϳ��� ���� ����(transaction)�ν��� �۾��� �ʿ�
>>auto commit�ɼ��� >> false�� ����
>>�ڹ��ڵ忡�� ��������� commit�� rollback�� ȣ���� �� �ִ�.
*/



public class Ex02_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//DriverManager.getConnection: Oracle �������� ���� �ּҰ�(���� ��ü�� �ּҰ�)�� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bit","1004"); //�ּ�ã��
			System.out.println(conn.isClosed()); //false�� ���;� ����� ��
			
			stmt = conn.createStatement();
			
			
			int empno=0;
			String ename="";
			int deptno=0;
			
			/*
			//insert
			Scanner sc = new Scanner(System.in);
			System.out.println("����Է�:");
			empno = Integer.parseInt(sc.nextLine());
			
			System.out.println("�̸��Է�:");
			ename=sc.nextLine();
			
			
			System.out.println("�μ���ȣ�Է�:");
			deptno=Integer.parseInt(sc.nextLine());
						
			//insert into dmlemp(empno,ename,deptno) values(100,'ȫ�浿',10);
			
			//������ �ڵ�
			String sql="insert into dmlemp(empno,ename,deptno) ";
			sql+="values("+empno+",'"+ename+"',"+deptno+")";
			
			//����) parameter ���
			//values(?,?,?);
			
			//executeUpdate() >> insert, update, delete �� �Ѵ�
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("�ݿ��� ���� �� : "+ resultrowcount);
			}else {
				//0�Ǵ� ���� ���..
				System.out.println("����: "+resultrowcount);
			}
			
			//insert ������ ���: stmt.executeUpdate(sql) ���� �� �߻� ����
			//resultrowcount ���� ��ȯ �ޱ� ���� �߻�
			//1. pk ����
			//2. �÷��� ����
			//3. Ÿ�� ���� ����
			*/
			
			/*
			//update
			Scanner sc = new Scanner(System.in);
			System.out.println("�μ���ȣ�Է�:");
			deptno=Integer.parseInt(sc.nextLine());
			
			String sql="update dmlemp set sal=0 where deptno="+deptno;
			
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("�ݿ��� ���� �� : "+ resultrowcount);
			}else {
				//0�Ǵ� ���� ���..
				System.out.println("����: "+resultrowcount);
			}
			*/
			
			//delete
			//delete from dmlemp where deptno=?
			Scanner sc = new Scanner(System.in);
			System.out.println("�μ���ȣ�Է�:");
			deptno=Integer.parseInt(sc.nextLine());
			
			String sql="delete from dmlemp where deptno="+deptno;
			
			int resultrowcount = stmt.executeUpdate(sql);
			
			if(resultrowcount >0) {
				System.out.println("�ݿ��� ���� �� : "+ resultrowcount);
			}else {
				//0�Ǵ� ���� ���..
				System.out.println("����: "+resultrowcount);
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
