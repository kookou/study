package kr.or.bit.utils;

import java.util.Calendar;

//���赵
//����� ���ϰ�...
//���� ����ұ�.. ���� ����(�Լ� �̸�).. ������.. ���



public class Edu_Date {
    public static String DateString(Calendar date) {
        return date.get(Calendar.YEAR) + "��" +
               (date.get(Calendar.MONTH)+1) + "��" +
               date.get(Calendar.DATE) + "��"; 
    }
    
    public static String DateString(Calendar date, String opr) {  //���� ��ȣ�� �Ű������� �־ �����ε�
        return date.get(Calendar.YEAR) + opr +
                (date.get(Calendar.MONTH)+1)+ opr +
               date.get(Calendar.DATE); 
    }
    
    //�䱸����
    //2020-3-19
    //1~9�������� >> 01,02 ������
    //10~12�� >> �׳�
    public static String monthFormat_DateString(Calendar date, String opr) {
         if(date.get(Calendar.MONTH)<9) {
             return date.get(Calendar.YEAR) + opr +
                    "0"+(date.get(Calendar.MONTH)+1) + opr +
                    date.get(Calendar.DATE); 
        }else {
               return 
                date.get(Calendar.YEAR) + opr +
                (date.get(Calendar.MONTH)+1) + opr +
                date.get(Calendar.DATE); 
     }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
