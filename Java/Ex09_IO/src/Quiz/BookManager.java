package Quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//���� ������ Ŭ����

import java.util.HashMap;

import java.util.Scanner;
import java.util.Set;

    public class BookManager {
    
    	Scanner scan = new Scanner(System.in);
    
    	HashMap<String, Book> book_dic = new HashMap<String, Book>();

	public void Run() {

		int key = 0;

		while ((key = selectMenu()) != 0) {

			switch (key) {

			case 1:
				addBook();
				break;

			case 2:
				removeBook();
				break;

			case 3:
				searchBook();
				break;

			case 4:
				listBook();
				break;

			case 5:
				listISBN();
				break;
				
			case 6:
                save();
                break;
                
			case 7:
                load();
                break;

			default:
				System.out.println("�߸� �����Ͽ����ϴ�.");
				break;

			}

		}

		System.out.println("�����մϴ�...");

	}
	
	private void save() {
        File file = new File("book.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //����ȭ ������ ���� ������Ʈ��
            
            oos.writeObject(book_dic);  //book_dic �ȿ��� ((1, new Book), (2, new Book)...) �̷��� ����
                                        // writeObject �޼��带 �̿��ؼ� ����ȭ ����
            oos.close();
            bos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("�����߻�!!!");
            e.printStackTrace();
        }
        System.out.println("����Ǿ����ϴ�.");
    }
	
	private void load() {
        File file = new File("book.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //������ȭ�� ���� ������Ʈ��
            
            book_dic = (HashMap)oos.readObject(); //readObject�޼��带 �̿��ؼ� ������ȭ
                                                  //���ϰ��� Object�̹Ƿ� �ٿ�ĳ����
            
            Set<String> set = book_dic.keySet();  // ŰSet�� ���� ���� ���
            System.out.println("isbn\t����\t����");
            for (String str : set) {
                String isbn = book_dic.get(str).getIsbn();
                String title = book_dic.get(str).getTitle();
                String price = book_dic.get(str).getPrice();

                System.out.printf("[%s]\t[%s]\t[%s]\n", isbn,title,price);
            }
            oos.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
            e.printStackTrace();
        }
    }
	
	

	int selectMenu() {

		System.out.println("1:�߰� 2:���� 3:�˻� 4:���� ��� 5:ISBN ��� 6:���� 7:�ε� 0:����");

		int key = scan.nextInt();

		scan.nextLine();

		return key;

	}

	void addBook() {

		String isbn;

		System.out.print("�߰��� ���� ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			System.out.println("�̹� �����ϴ� ISBN�Դϴ�.");

			return;

		}

		String title;

		String price;

		System.out.print("���� ����:");

		title = scan.nextLine();

		System.out.print("����:");

		price = scan.nextLine();

		

		Book book = new Book(isbn, title, price);

		book_dic.put(isbn, book);

		System.out.println(book.toString() + " �����Ͽ����ϴ�.");

	}

	void removeBook() {

		String isbn;

		System.out.print("������ ���� ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			book_dic.remove(isbn);

			System.out.println("�����Ͽ����ϴ�.");

		}

		else {

			System.out.println("�������� �ʽ��ϴ�.");

		}

	}

	void searchBook() {

		String isbn;

		System.out.print("�˻��� ���� ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			Book book = book_dic.get(isbn);

			System.out.println("�˻� ���>>" + book.toString());

		}

		else {

			System.out.println("�������� �ʽ��ϴ�.");

		}

	}

	void listBook() {

		System.out.println("���� ���");

		int cnt = book_dic.size();

		System.out.println("���� ��:" + cnt);

		for (Book book : book_dic.values()) {

			System.out.println(book.toString());

		}

	}

	void listISBN() {

		System.out.println("ISBN ���");

		int cnt = book_dic.size();

		System.out.println("���� ��:" + cnt);

		for (String isbn : book_dic.keySet()) {

			System.out.println(isbn);

		}

	}

}