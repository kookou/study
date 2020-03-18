import java.util.ArrayList;

public class Account {
    private String accountNo;      //���¹�ȣ
    private String name;    //�����ڸ�
    private long balance;            //�ܰ�    
    private ArrayList<String> Transactions;    //�ŷ�����
    
    Account(String accountNo, String name){
        this.accountNo = accountNo;
        this.name=name;
        this.balance=0;
        this.Transactions = null;
        
        Transactions = new ArrayList<String>();
    }
    
    
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   

    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", Transactions="
                + Transactions + "]";
    }

    public void deposit(long amount) {      //�Ա��Ѵ�
     
          this.balance+=amount;
          System.out.printf("%s���¿� %d���� �Ա�. ���� �ܰ�: %d\n",accountNo,amount,balance);
          System.out.println(toString());
          this.Transactions.add(toString());
        
    }
    public void withdraw(long amount) {    //����Ѵ�
        this.balance-=amount;
        System.out.printf("%s���¿� %d���� ���. ���� �ܰ�: %d\n",accountNo,amount,balance);
        System.out.println(toString());
        this.Transactions.add(toString());
    }
    public long getBalance() {    //�ܰ� Ȯ���Ѵ�
        System.out.printf("%s���� �ܰ� Ȯ��. ���� �ܰ�: %d\n",accountNo,balance);
        System.out.println(toString());
        return balance;
    }
    
    public ArrayList<String> getTransactions() {   //�ŷ������� Ȯ���Ѵ�
        System.out.println("***�ŷ� ����***");
        System.out.println(Transactions.toString());
        return Transactions;
    }
    
    


        
    
    
    

}
