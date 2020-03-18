import java.util.ArrayList;


public class Bank {
    private ArrayList<Account> accounts;  //����(0�� �̻�)
    private int totalAccount;       //�� ���¼�
    
    Bank(){
        accounts = new ArrayList<Account>();
        totalAccount=0;
    }
    
    
    
    //���¸� �����Ѵ�
    public void addAccount(String accountNo, String name) { 
        accounts.add(new Account(accountNo, name));
        System.out.println("���¸� �����߽��ϴ�.");
        System.out.println("������ ����:"+new Account(accountNo, name));        
        totalAccount ++;
    }
    
    //���¸� ã�´�(���¹�ȣ��)
    public Account getAccount(String accountNo) {
        for(Account acc : accounts) {
            if(acc.getAccountNo().equals(accountNo)) {
                System.out.println("�ش� ���¹�ȣ�� ��ġ�ϴ� ���°� �ֽ��ϴ�.");
                System.out.println(acc);
                return acc;
            }else {
                System.out.println("�ش� ���¹�ȣ�� ��ġ�ϴ� ���°� �����ϴ�.");
                return null;
            }
        }
        return null;
    }
    //���¸� ã�´�(�����ڸ�����)
    public ArrayList<Account> findAccounts(String name){
        ArrayList<Account> list = new ArrayList<Account>();
        for(Account acc : accounts) {
            if(acc.getName().equals(name)) {
                System.out.println("��ġ�ϴ� ���� �߰�.");
                list.add(acc);
                
            }else {
                System.out.println("�ش� ����� ��ġ�ϴ� ���¸���� �����ϴ�.");
                return null;
            }   
        }
        System.out.println(list);
        return list;
    }
    //���¸���� ����
    public ArrayList<Account> getAccounts(){
           

        return accounts;
    }
    
    
    //�Ѱ��¼��� ��ȯ�Ѵ�
    public int getTotalAccount() {
        return totalAccount;
    }
    
    public static void main(String[] args) {
        
       Bank bank = new Bank();
       
       //���� ����
       System.out.println("**���� ����**");
       bank.addAccount("00-0000-0001", "�ʱ�");
       bank.addAccount("00-0000-0002", "����");
       bank.addAccount("00-0000-0003", "�ʱ�");
       
       //���� ã��(���¹�ȣ��)
       System.out.println("**���� ã��(���¹�ȣ��)**");
       bank.getAccount("00-0000-0001");  //��ġ�ϴ� ���¹�ȣ �ִ� ���
       bank.getAccount("99-9999-9999");  //��ġ�ϴ� ���¹�ȣ ���� ���
       
       //���� ã��(������ ������)
       System.out.println("**���� ã��(������ ������)**");
       bank.findAccounts("�ʱ�");         //��ġ�ϴ� ���°� �ִ� ���  
       bank.findAccounts("������");        //��ġ�ϴ� ���°� ���� ���
      
       //���¸�� ����
       System.out.println("**���� ��� ����**");
       System.out.println(bank.getAccounts());
       
       //�� ���¼� ��ȯ
       System.out.println("**�� ���¼� ��ȯ**");
       System.out.println(bank.totalAccount);
       
       //�Ա�
       System.out.println("**�Ա�**");
       bank.accounts.get(0).deposit(10000L);
       
       //���
       System.out.println("**���**");
       bank.accounts.get(0).withdraw(5000L);
       
       //�ܰ� Ȯ��
       System.out.println("**�ܰ� Ȯ��**");
       bank.accounts.get(0).getBalance();
       
       //�ŷ����� Ȯ��
       System.out.println("**�ŷ����� Ȯ��**");
       bank.accounts.get(0).getTransactions();
       
     
    }
    
}
