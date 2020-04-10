import java.util.ArrayList;
import java.util.Scanner;

import DAO.DepartmentDao;
import DTO.Department;

public class Program {

	public static void main(String[] args) {
		DepartmentDao departmentdata = new DepartmentDao();
		while(true)
		{
					String selection = menu();
					//System.out.println(selection);
					switch (selection)
					{
						case "1": //���
							    ArrayList<Department> departments = departmentdata.GetDepartmentList();
							    DepartmentPrint(departments);
								break;
						case "2": //���
								Department dept = new Department();
								InputDepartment(dept, false);
								int row = departmentdata.InsertDepartment(dept);
								System.out.println("INSERT ROW : " + row);
								System.out.println("INSERT DATA : " + dept.getDeptno() + " : " + dept.getDname());
							    break;
						case "3": //���� (���� �μ��� ����)
							    System.out.print("������ �μ��� :");
							    String deptname = scanner.nextLine();
							    ArrayList<Department> departments2 = departmentdata.GetDepartmentListByDname(deptname);
							    	if(DepartmentPrint(departments2,"�μ�����˻�") > 0)
							    	{
							    		System.out.println("[�μ� ���� ���� �Է�]");
									    Department update = new Department();
									    InputDepartment(update, false);
									    int updaterow =departmentdata.UpdateDepartment(update);
									    System.out.println("����� ROW : " + updaterow);
							    	}
							    break;
						case "4" : //����
								 System.out.print("������ �μ��� :");
								 String deptname4 = scanner.nextLine();
								 ArrayList<Department> departments4 = departmentdata.GetDepartmentListByDname(deptname4);
									if(DepartmentPrint(departments4,"�μ������˻�") > 0)
							    	{
										System.out.print("������ �μ� �ڵ�:");
										String deptcode = scanner.nextLine();
										int deleterow = departmentdata.DeleteDepartment(Integer.parseInt(deptcode));
										System.out.println("������ row : " + deleterow);
							    	}	
							    break;
						case "5" : //�˻�
							    System.out.print("�˻��� �μ���:"); 
							    String deptname5 = scanner.nextLine();
							    ArrayList<Department> departments5 = departmentdata.GetDepartmentListByDname(deptname5);
							    DepartmentPrint(departments5,"�˻��μ�");
								break;
							    
						case "6" : //����	
							System.out.println("���α׷� ����");
							return;
					}
	
		}

	}
	private static Scanner scanner = new Scanner(System.in);
	private static String menu(){
		System.out.println("**********************");
		System.out.println("*1.�μ����");
		System.out.println("*2.�μ����");
		System.out.println("*3.�μ�����");
		System.out.println("*4.�μ�����");
		System.out.println("*5.�μ��˻�");
		System.out.println("*6.���α׷�����");
		System.out.println("**********************");
		System.out.print("�۾���ȣ����:");
		return scanner.nextLine();
	}
	private static void InputDepartment(Department department , boolean update){
		if(!update){ //update false ���� ������ IF
			System.out.print("�μ��ڵ�:");
			department.setDeptno(Integer.parseInt(scanner.nextLine()));
		}
		System.out.print("�μ��̸�:");
		department.setDname(scanner.nextLine());
	}
	private static void DepartmentPrint(ArrayList<Department> list){
		for(Department d : list){
			System.out.printf("[%d][%s]\n",d.getDeptno(), d.getDname());
		}
	}
	private static int  DepartmentPrint(ArrayList<Department> list , String Find){
		 int FineRowCount=0;
		 if(list.size() > 0)
		 {
			 for(int i =0 ; i < list.size() ; i++)
		    	{   
				 	FineRowCount++;
		    		System.out.println(list.get(i).toString());
		    	}
		 }
		 else
		 {
			 System.out.println(Find + "FAIL");
		 }
		 
		 return  FineRowCount;
	}
	
}
