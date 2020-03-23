package kr.or.bit;

import java.io.Serializable;

/*
 * ��ü ���
 * ��ü(Car, Tv) ��Ʈ��ũ, ���� ��(txt���Ͽ� ��ü write/read), ���μ��� ���� ���(a.class, b.class)
 * ����ȭ: ��ü�� �����ؼ� ���� ���� ������ ����
 * ������ȭ: ���ص� ��ü�� �ٽ� �����ϴ� ����
 * �ǽ�
 * ��� >> ���� > ��ü write(����ȭ)
 * ���>> ���� > ��ü read(������ȭ)
 * 
 * �� ����� �پ��ִ� ���� ����ȭ �Ұ�  >> implements Serializable �־�߸� ����ȭ ����
*/




public class UserInfo implements Serializable {
    private String name;
    private String pwd;
    private int age;
    
    public UserInfo() {}
    public UserInfo(String name, String pwd, int age) {
        this.name=name;
        this.pwd=pwd;
        this.age=age;
    }
    @Override
    public String toString() {
        return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
    }
    
    
    
    
}
