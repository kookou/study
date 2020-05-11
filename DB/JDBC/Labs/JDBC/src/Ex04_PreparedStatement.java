import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.SingletonHelper;

/*
 * 
 * https://devbox.tistory.com/entry/Comporison ����
  PreparedStatement (�غ�� Statement )
  (1) ���� 
     �̸� SQL���� ���õ� Statement�� DB�� ���۵Ǿ�����   �����ϵǾ�����, SQL���� ?(parameter)�� ���߿� �߰� �����ؼ� ���� 
    �� �Ǿ����� �غ�� Statement 
  (2) ���� 
     <1> Statement �� ���ؼ� �ݺ����� SQL���� ����� ��쿡  �� ������. ( Ư��, �˻��� )
  <2> DB�÷�Ÿ�԰� ������� ?�ϳ��� ǥ���ϸ� �ǹǷ�   �����ڰ� ����� �ʰ� ����. ( Ư��, INSERT�� )
       (����: ?�� ������ SQL���� DB���� �̸� �����ϵǾ����� ���)

  (3) ���� 
     SQL������ PreparedStatement ��ü�� ���� �����ؾ� �ϹǷ� ����Ұ�
     (but, Statement ��ü�� SQL���� �޶������� �� ���� �����ؼ�  ������ �����ϴ�. )

  (4) Ư¡ 
     <1> Statement stmt = con.createStatement(); //����       
      stmt.execute(sql);//����
  <2> PreparedStatement pstmt = con.prepareStatement(sql); //����      
      pstmt.execute(); //����

  (5) ���� 
     DB ��ü��(table, ..)�� ����(   ���̺�� or �÷��� or �������� ���� ��ü�� �Ӽ���)�� 
      ?�� ǥ���� �� ����. 
     ��, data �ڸ����� ?�� ǥ���� �� �ִ�.
     cf) �׷���, DDL�������� PreparedStatement�� ������� �ʴ´�.
     
     ����: ����, �̸� ������ ������>> ���� parameter�� ���� ó��(����)
     ����: ������ ����(PreparedStatement pstmt = con.prepareStatement(sql); ����� �ʿ�)
*/

public class Ex04_PreparedStatement {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= SingletonHelper.getConnection("Oracle");
			String sql = "select empno, ename from emp where deptno=?";
			//where id=100 and name='ȫ�浿' and job='IT'
			//where id=? and name=? and job=?
			
//			Statement stmt = conn.createStatement();
			//rs=stmt.executeQuery(sql)
			pstmt = conn.prepareStatement(sql); //����Ŭ ���� �̸� ���� ������...���
			
			//���Ŀ��� parameter ������ �����ؼ� ����
			//? �ڸ�... ����
			pstmt.setInt(1, 30); //where deptno=30  1�� �Ű������� 30�� �Է�
			
			rs=pstmt.executeQuery();
			
			//���İ��� ����
//			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"/"+rs.getString(2));
//			}
			if(rs.next()) {
				//�ּ� �� ���� �����ʹ� �ִ�
				do {
					System.out.println(rs.getInt(1)+"/"+rs.getString(2));
				}while(rs.next()); //1�� �̻��� ���
			}else {
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�");
			}
			
			
		}catch (Exception e) {
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			//������ ��� ���� app����ִ� ��	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
