
    import java.util.*;

    class Grade_Management { 
       static ArrayList record = new ArrayList();  //List ����
       static Scanner s = new Scanner(System.in);

       public static void main(String args[]) { 
          while(true) { 
             switch(displayMenu()) { 
                case 1 : 
                   inputRecord(); 
                   break; 
                case 2 : 
                   deleteRecord(); 
                   break; 
                case 3 : 
                   sortRecord(); 
                   break; 
                case 4 : 
                   System.out.println("���α׷��� �����մϴ�."); 
                   System.exit(0); 
             } 
          } // while(true) 
       }

       // menu�� �����ִ� �޼��� 
       static int displayMenu(){ 
          System.out.println("**************************************************"); 
          System.out.println("*                ���� ���� ���α׷�                                      *"); 
          System.out.println("*                   version 1.0                  *"); 
          System.out.println("*             excerpt from Java�� ����                          *"); 
          System.out.println("**************************************************"); 
          System.out.println(); 
          System.out.println(); 
          System.out.println(" 1. �л����� �Է��ϱ� "); 
          System.out.println(); 
          System.out.println(" 2. �л����� �����ϱ� "); 
          System.out.println(); 
          System.out.println(" 3. �л����� �����Ͽ�����(�̸���, ������) "); 
          System.out.println(); 
          System.out.println(" 4. ���α׷� ���� "); 
          System.out.println(); 
          System.out.println(); 
          System.out.print("���ϴ� �޴��� �����ϼ���.(1~4) : ");

          int menu = 0;

          do { 
             try { 
                menu = Integer.parseInt(s.nextLine()); //�Է¹��� ���ڿ��� ���ڷ� ��ȯ

                if(menu >= 1 && menu <= 4) { 
                   break; 
                } else { 
                   throw new Exception(); 
                } 
             } catch(Exception e) { //1~4�� �����ϰ� ����ó��
                System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���."); 
                System.out.print("���ϴ� �޴��� �����ϼ���.(1~4) : "); 
             } 
          } while(true);

          return menu; 
       } // public static int displayMenu(){

       // �����͸� �Է¹޴� �޼��� 
       static void inputRecord() { 
          System.out.println("1. �л����� �Է��ϱ�"); 
       System.out.println("�̸�,�й�,�����,�����,���м���'�� ������ ������� �Է��ϼ���."); 
          System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�.");

          while(true) { 
             System.out.print(">>");

             do { 
                try { 
                   String input = s.nextLine().trim(); //�Է¹��� s�� �������� �� input������ ����

                   if(!input.equalsIgnoreCase("q")) {  //input���� ��ҹ��� ���о��� q�� �ƴҶ�, if�� ����
                      Scanner s2 = new Scanner(input).useDelimiter(","); //�Է¹��� ���ڿ��� ','�� �����Ͽ� ���ڿ� ��ȯ

                      record.add(new Student2(s2.next(), s2.next(), s2.nextInt()
                                   , s2.nextInt(), s2.nextInt())); //List�� �Է°��� Student2Ŭ���� ���·� �߰�
                      System.out.println("���ԷµǾ����ϴ�. �Է��� ��ġ���� q�� �Է��ϼ���."); 
                      break; 
                   } else { 
                      return;                         
                   } 
                } catch(Exception e) { //����ó��
                   System.out.println("�Է¿����Դϴ�. �̸�, �й�, �����, �����, ���м���'�� ������ �Է��ϼ���."); 
                   break; 
                } 
             } while(true); 
          } // do-while(true) 
       } // public static void inputRecord() {

       // �����͸� �����ϴ� �޼��� 
       static void deleteRecord() { 
          while(true) { 
             displayRecord(); 
             System.out.println("�����ϰ��� �ϴ� �������� �й��� �Է��ϼ���.(q:����ȭ��)"); 
             System.out.print(">>");

             do { 
                try { 
                   String input = s.nextLine().trim(); //�Է¹��� s�� �������� �� input������ ����

                   if(!input.equalsIgnoreCase("q")) {  //input���� ��ҹ��� ���о��� q�� �ƴҶ�, if�� ����
                      int length = record.size();    //record(List)�� ����� ���� �� 
                      boolean found = false;

                      for(int i=0; i < length; i++) {  //���ڵ��� ���̸�ŭ for���� ����
                         Student2 student = (Student2)record.get(i);  //����� List���� �л������� ������
                         if(input.equals(student.studentNo)) {  //�����ϰ��� �ϴ� �й��� �Է°��� List���� ������ �л� �������� �й��� ��
                            found = true;  //������ found���� true��
                            record.remove(i);  //List���� �ش� �й��� �����͸� ����
                            break; 
                         } 
                      } // for(int i=0; i < length; i++) {

                      if(found) {  //found�� true�� ��
                         System.out.println("�����Ǿ����ϴ�."); 
                      } else { 
                         System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�."); 
                      } 
                      break; 
                   } else { 
                      return;                         
                   } 
                } catch(Exception e) {  //����ó��
                   System.out.println("�Է¿����Դϴ�. �ٽ� �Է��� �ּ���."); 
                   break; 
                } 
             } while(true); 
          } // do-while(true) 
       } // public static void deleteRecord() {

       // �����͸� �����ϴ� �޼���       
       static void sortRecord() { 
          while(true) { 
             System.out.print(" ���ı����� ��Ź�ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : ");

             int sort = 0;

             do { 
                try { 
                   sort = Integer.parseInt(s.nextLine()); //�Է¹��� ���ڿ��� ���ڷ� ��ȯ�Ͽ� sort����������

                   if(sort >= 1 && sort <= 3) { 
                      break; 
                   } else { //1~3�� �ƴ� �� ����ó��
                      throw new Exception(); 
                   } 
                } catch(Exception e) { 
                   System.out.println("��ȿ���� ���� �Է°��Դϴ�. �ٽ� �Է����ּ���."); 
                   System.out.print(" ���ı����� ��Ź�ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : "); 
                } 
             } while(true);

             if(sort==1) {
             //Collections.sort(List, Comparator)->Comparator�� ����Ű�� ������ ���� List�� ����
                Collections.sort(record, new NameAscending()); //�̸������� ����
                displayRecord(); 
             } else if(sort==2) { 
                Collections.sort(record, new TotalDescending()); //���������� ����
                displayRecord(); 
             } else { 
                return;             
             } 
          } // while(true) 
       }

       // ������ ����� �����ִ� �޼��� 
       static void displayRecord() { 
          int koreanTotal = 0; 
          int englishTotal = 0; 
          int mathTotal = 0; 
          int total = 0;

          System.out.println(); 
          System.out.println("�̸� ��ȣ ���� ���� ���� ���� "); 
          System.out.println("======================================");

          int length = record.size();

          if(length > 0) { 
             for (int i = 0; i < length ; i++) { 
                Student2 student = (Student2)record.get(i); 
                System.out.println(student); 
                koreanTotal += student.koreanScore; 
                mathTotal += student.mathScore; 
                englishTotal += student.englishScore; 
                total += student.total; 
             } 
          } else { 
             System.out.println(); 
             System.out.println(" �����Ͱ� �����ϴ�."); 
             System.out.println(); 
          }

          System.out.println("======================================"); 
          System.out.println("����: " 
             + Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
             + Student2.format(englishTotal+"", 6, Student2.RIGHT) 
             + Student2.format(mathTotal+"", 6, Student2.RIGHT) 
             + Student2.format(total+"", 8, Student2.RIGHT) 
          ); 
          System.out.println(); 
       } // static void displayRecord() { 
    } // end of class

    // �̸��� ��������(�����ټ�)���� �����ϴ� �� ���Ǵ� Ŭ���� 
    class NameAscending implements Comparator { 
       public int compare(Object o1, Object o2){ //���� �񱳸� ���� �μ� ��
          if(o1 instanceof Student2 && o2 instanceof Student2){ //o1�� o2�� ���������� Student2 Ŭ����Ÿ������ ����ȯ�� �����ϴٸ� if�� ����
             Student2 s1 = (Student2)o1;  //o1�� ���������� Student2 Ŭ����Ÿ������ ����ȯ �Ͽ� s1���� ����
             Student2 s2 = (Student2)o2;

             return (s1.name).compareTo(s2.name);  //s1.name�� s2.name�� �񱳰� ����
          } 
          return -1; 
       } 
    }

    // ������ ��������(ū������ ������)���� �����ϴ� �� ���Ǵ� Ŭ���� 
    class TotalDescending implements Comparator { 
       public int compare(Object o1, Object o2){ 
          if(o1 instanceof Student2 && o2 instanceof Student2){ 
             Student2 s1 = (Student2)o1; 
             Student2 s2 = (Student2)o2;

             return (s1.total < s2.total)? 1 : (s1.total == s2.total ? 0 : -1);
             //s2�� total���� ũ�ٰ� true�� �� 1, false�� �� s1��s2�� �� �� ������ 0, �ٸ��� -1 ����
          } 
          return -1; 
       } 
    }

    class Student2 implements Comparable {  //Student2 Ŭ���� ����
       final static int LEFT = 0;   //Ŭ��������, �ν��Ͻ��鰣�� ��������
       final static int CENTER = 1; 
       final static int RIGHT = 2;

       String name = "";   //�ν��Ͻ� ����, �ʱ�ȭ
       String studentNo = ""; 
       int koreanScore = 0;
       int mathScore = 0; 
       int englishScore = 0; 
       int total = 0;

       Student2(String name, String studentNo, int koreanScore, int mathScore, int englishScore) { //������
          this.name = name; 
          this.studentNo = studentNo; 
          this.koreanScore = koreanScore; 
          this.mathScore = mathScore; 
          this.englishScore = englishScore; 
          total = koreanScore + mathScore + englishScore; 
       }

       public String toString() { 
          return format(name, 4, LEFT) 
             + format(studentNo, 4, RIGHT) 
             + format(""+koreanScore,6, RIGHT) 
             + format(""+mathScore,6, RIGHT) 
             + format(""+englishScore, 6, RIGHT) 
             + format(""+total,8, RIGHT); 
       }

       static String format(String str, int length, int alignment) { 
          int diff = length - str.length();  //�Ű������� ���� length���� String�� ���̸� �� ���� diff ���� 
          if(diff < 0) return str.substring(0, length);  //diff�� 0���� ������ str�� index 0����  length-1���� ����

          char[] source = str.toCharArray();  //str�� ���ڿ��� �����Ͽ� source�迭�� ����
          char[] result = new char[length];  //�Ű������� ���� length�� �迭 ����

          // �迭 result�� �������� ä���. 
          for(int i=0; i < result.length; i++) 
             result[i] = ' ';

          switch(alignment) {  //���Ĺ�� ����
             case CENTER :   //��� ����
                System.arraycopy(source, 0, result, diff/2, source.length); 
                break; 
             case RIGHT :   //������ ����
                System.arraycopy(source, 0, result, diff, source.length); 
                break; 
             case LEFT :  //��������
             default : 
                System.arraycopy(source, 0, result, 0, source.length); 
          } 
          return new String(result); 
       } // static String format(String str, int length, int alignment) {

       public int compareTo(Object obj) { 
          int result = -1; 
          if(obj instanceof Student2) {  //�������� obj�� Student2 Ŭ����Ÿ������ ����ȯ�� �����ϸ� if�� ����
             Student2 tmp = (Student2)obj;  //obj�� tmp�� ����
             result = (this.name).compareTo(tmp.name); //���ڿ� �� �� ������ 0, �ٸ��� �ƽ�Ű�ڵ��� ���̰� ��ȯ
          } 
          return result; 
       } 
    } // class Student2 implements Comparable {


