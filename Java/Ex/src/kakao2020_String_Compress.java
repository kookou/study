public class kakao2020_String_Compress {

	public static void main(String[] args) {

		String s = "xcvaaaaabb";
				
		int answer=s.length(); 
		
	
		for(int i = 1; i<=s.length()/2;i++) {  //���� ū ����� ��ü ���ڿ� ������ �����̹Ƿ�
			String str = s.substring(0,i); //�� ������ �Ǵ� ���ڿ� �ڸ���
			System.out.println("str: "+str);
			String result="";
			int count=1; //�����  ǥ�� ����
			for(int j=i;j<=s.length()-i;j+=i) { //���ڿ��� iũ�⸸ŭ �߶� ��
				if(str.equals(s.substring(j,j+i))){ 
					System.out.println("com: "+(s.substring(j,j+i)));
					count++;	
					
				}else {	//���� ���ڿ��� �ƴ� ���
					if(count==1) {
						result += str;
					}else {
						result +=(count+str);
					}
					str=s.substring(j,j+i);
					System.out.println("���� �� ����: " + str);
					count=1;
					System.out.println("result: "+result);
					System.out.println("j: "+j);
				}
			}
			//���� for���� �� ���� ���� ���ڿ��� i�� ���� �Ϳ� �������� �ִ� ��� result�ڿ� �߰��ϱ�
			if(s.length()%i !=0) {
				result+=str+(s.substring((s.length()/i)*i));
				
			}else {
				if(count==1) {
					result+=str;
				}else {
					result +=(count+str);
				}
			
			}
			System.out.println("���� ���: " + result);
			answer= result.length()<answer?result.length():answer;
			System.out.println("answer: " + answer);
		}
		
	}

}
