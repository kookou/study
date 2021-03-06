package manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import entity.*;
import main.Mall;
import user.*;

public class CustomerManager implements Manager, Serializable {

	public static HashMap<String, User> customerList = new HashMap<String, User>();

	static Scanner sc = new Scanner(System.in);

	// 회원 가입
	public Customer signUp() {
		System.out.println("회원 가입");
		String id, pwd, name, tel, address;

		// ID 입력
		while (true) {
			System.out.println("ID를 입력해주세요. (5~20자. 영어 대소문자, 숫자, _ 만 사용가능)");
			System.out.print(">>");
			String regExpaa = "^[a-zA-Z0-9_]{5,20}+$";
			id = sc.nextLine();
			Mall.setId(id);
			boolean b = id.matches(regExpaa); // true ,false

			if (b == true) {
				if (CustomerManager.customerList.containsKey(id)) {
					System.out.println("이미 존재하는 ID입니다.");
				} else {
					break;
				}

			} else {
				System.out.println("형식이 잘못되었습니다. 다시 입력해 주세요.");
			}
		}

		// 비밀번호 입력
		while (true) {
			System.out.println("비밀번호를 입력해주세요. (8~20자.적어도 하나의 영어대문자 소문자,숫자,특수문자가 각각 포함되어야 함)");
			System.out.print(">>");
			String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
			;

			pwd = sc.nextLine();

			boolean b = pwd.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("형식이 잘못되었습니다. 다시 입력해 주세요.");
			}
		}
		// 이름 입력
		while (true) {
			// ID 입력
			System.out.println("이름을 입력해주세요. (한글만 사용가능)");
			System.out.print(">>");
			String regExp = "^[ㄱ-ㅎ가-힣]+$";

			name = sc.nextLine();

			boolean b = name.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("형식이 잘못되었습니다. 다시 입력해 주세요.");
			}
		}

		// 휴대폰 번호 입력
		while (true) {
			// ID 입력
			System.out.println("휴대폰 번호를 입력해주세요. ex) 010-123(4)-1234)");
			System.out.print(">>");
			String regExp = "(01[01679]{1})-(\\d{3,4})-(\\d{4})";

			tel = sc.nextLine();

			boolean b = tel.matches(regExp); // true ,false

			if (b == true) {
				break;
			} else {
				System.out.println("형식이 잘못되었습니다. 다시 입력해 주세요.");
			}
		}

		// 배송지 주소 입력
		System.out.println("배송지 주소를 입력해주세요");
		System.out.print(">>");
		address = sc.nextLine();

		Customer customer = new Customer(id, pwd, name, tel, address);
		customer.setId(id);
		customer.setPwd(pwd);
		customer.setName(name);
		customer.setTel(tel);
		customer.setAddress(address);

		customerList.put(id, customer);
		save();
		// 가입 고객 카트 생성
		CartManager cartManager = new CartManager();
		cartManager.cartList.put(id, new Cart());
		cartManager.save();

		// 가입 고객 거래내역 배열 생성
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.transactionList.put(id, new ArrayList<Transaction>());
		transactionManager.save();
		return customer;
	}

	public Customer signIn(String id, String pwd) {

		if (customerList.containsKey(id) && ((customerList.get(id).getPwd()).equals(pwd))) {

			System.out.println("로그인 성공");
			Mall.setId(id);
			return (Customer) customerList.get(id);
		} else {
			System.out.println("로그인 실패");
			return null;
		}
	}

	// 관리자 메뉴 >> 회원 정보 조회
	public void userList() {
		System.out.println("**회원 목록 조회**");

		Set<String> set = customerList.keySet();
		ArrayList<String> arraySet = new ArrayList<String>(set);
		Collections.sort(arraySet);
		System.out.println("==========================Vip고객명단==========================");
		System.out.println("       ID    Password    성함           휴대폰 번호                     배송지");

		for (String c : arraySet) {
			if (c.equals("admin")) {
				continue;
			}
			Customer user = (Customer) (customerList.get(c));
			System.out.printf("%10s %10s %5s %15s %17s", user.getId(), user.getPwd(), user.getName(), user.getTel(),
					user.getAddress());
			System.out.println();
		}
	}

	// 마이페이지 >> 내 정보 조회
	public void MyInfo() {
		System.out.println("**내 정보 조회**");
		do {
			try {
				System.out.println("비밀번호를 입력하십시오");
				System.out.print(">>");
				String password = sc.nextLine();
				if (customerList.get(Mall.getId()).getPwd().equals(password)) {
					Customer my = (Customer) customerList.get(Mall.getId()); // (user)타입으로 있는 value값 다운캐스팅필요.
					System.out.printf("[이름 : %s]\n[아이디 : %s]\n[비밀번호 : %s]\n[전화번호 : %s]\n[주소 : %s]\n", my.getName(),
							my.getId(), my.getPwd(), my.getTel(), my.getAddress());
					break;
				} else {
					throw new Exception("");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("<입력 오류>");
				System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력하십시오.");

			}
		} while (true);
	}

	public String toString() {
		return null;
	}

	@Override
	public void add() {
	}

	@Override
	public void remove() {
	}

	// I/O를 위한 직렬화 저장
	public void save() {
		File file = new File("CustomerDB.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // 직렬화 저장을 위한 보조스트림

			oos.writeObject(customerList);
			// writeObject 메서드를 이용해서 직렬화 저장
			oos.close();
			bos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
	}

	// I/O를 위한 역직렬화 로드
	public void load() {
		File file = new File("CustomerDB.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream oos = new ObjectInputStream(bis); // 역직렬화를 위한 보조스트림

			customerList = (HashMap) oos.readObject(); // readObject메서드를 이용해서 역직렬화
			// 리턴값이 Object이므로 다운캐스팅

			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

}