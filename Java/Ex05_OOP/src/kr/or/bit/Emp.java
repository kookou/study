package kr.or.bit;
//Ŭ���� >> ����>>  DTO, VO, DOMAIN

public class Emp { // class Emp extends Object
    private int empno;
    private String ename;

    //

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }
    // �ʿ��ϴٸ� setter, getter�� ������ �� �ִ�

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

    // ��� (���� ���)
    public void empInfoPrint() {
        System.out.println(this.empno + "/" + this.ename);
    }

    @Override
    public String toString() {
        return "Emp [empno=" + empno + ", ename=" + ename + "]";
    }

    // toString() �Լ� ������ Object
    // ��� ���迡�� ... toString() �� �ڴ�� �ϰ� �;��
    // private > �����Ѵ�θ� �� , public > ����� �������ؼ� ��
    
    
    
    
    
    
    
    
    

}
