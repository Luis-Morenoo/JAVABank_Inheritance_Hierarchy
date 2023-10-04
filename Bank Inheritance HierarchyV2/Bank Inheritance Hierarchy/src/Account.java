import java.math.BigDecimal;
public class Account {//super class
    protected String name;
    protected BigDecimal balance;

    //getterName
    public String getName(){
        return name ;
    }
    //setterName
    public void setName(String newName){
        this.name = newName;
    }
    //getterBalance
    public BigDecimal getBalance(){
        return balance;
    }
    //setterBalance
    public void setBalance(BigDecimal newBalance){
        this.balance = newBalance;
    }
    //credit money to account
    public void credit(BigDecimal amount){
        balance = balance.add(amount);
    }
    //debit money from account
    public void debit( BigDecimal amount){
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        }
        else{
            System.out.println("Debit amount exceeded account balance");
        }
    }
    //constructor
    public Account(String name, BigDecimal balance){
        this.name = name;
        if (balance.compareTo(BigDecimal.ZERO) >= 0 ){
            this.balance = balance;
        }
        else{
            System.out.println("Error: initial balance was invalid \n");
            this.balance = BigDecimal.valueOf(0.0);
        }
    }
    //toString
    public String toString(){
        return "Account name: " + name + "\n" +
                "Account balance: " + balance;
    }
}
