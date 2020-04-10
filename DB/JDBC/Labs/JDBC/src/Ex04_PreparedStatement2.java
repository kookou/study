import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.SingletonHelper;

/*
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

public class Ex04_PreparedStatement2 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("Oracle");
			String sql = "select empno, ename from emp where deptno=?";
			//where id = 100 and ename = 'ȫ�浿' and job = 'it'
			//������ ���� �ڸ��� ?�� ���� �ȴ�.
			//->where id = ? and ename = ? and job = ?
			
			pstmt = conn.prepareStatement(sql);//stmt�� ����� ������ �ʿ�, pstmt�� ��ü ������ �ʿ� -> ����Ŭ������ sql���� �̸� �����ؼ� ������ ���ѳ��� ���
			
			//���Ŀ��� parameter�� ������ �����ؼ� �����ϸ� �˴ϴ�.
			//?�ڸ��� ���𰡸� ����������Ѵ�.
			pstmt.setInt(1, 10);  // where deptno = 30
			
			rs = pstmt.executeQuery();//�̹� ��ü������ �������� �������� sql�� �ʿ� ����
			//���İ��� ���� �ܿ���....
			//while(rs.next()) {
			//	System.out.println(rs.getInt(1) + "/" + rs.getString(2));
			//}
			//while���� ������
			//�����Ͱ� ���°�� ǥ���� �ȵȴ�.
			//��¥ ���ķ���, �ϱ�!!
			if(rs.next()) {
				//�ּ� �� ���� �����ʹ� �ִ�.->������ 1���� ����ȴ�.
				do {
					System.out.println(rs.getInt(1) + "/" + rs.getString(2));
				} while (rs.next());//-> ���� �����Ͱ� �ֳ�? ������ out!!!! 1�� �̻��� ��� true�ϱ� �ٽ� do���� ����.
			}else {
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
			}
			
		} catch (Exception e) {
			
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);//������ ��� ������ ���̴� APP�� ����ִ� ��
			
			
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
