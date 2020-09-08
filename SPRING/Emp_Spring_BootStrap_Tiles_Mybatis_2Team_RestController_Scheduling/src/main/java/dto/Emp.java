package dto;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*
이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER       //pk
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER       
HIREDATE          DATE         
SAL               NUMBER       
COMM              NUMBER       
DEPTNO            NUMBER       
IMG				  VARCHAR2(30) 
데이터 row 1건을 담을 수 있는 클래스 (DTO)
 */
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;  // 타입 date로 해야하나?
	private int sal;
	private int comm;
	private int deptno;
	private String img;
	
	public Emp() {}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	//다중 파일 업로드 >> List<>//////////////////////////////
	private List<CommonsMultipartFile> files;
	
	public List<CommonsMultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<CommonsMultipartFile> files) {
		this.files = files;
	}
	//////////////////////////////////////////////////////
	

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}