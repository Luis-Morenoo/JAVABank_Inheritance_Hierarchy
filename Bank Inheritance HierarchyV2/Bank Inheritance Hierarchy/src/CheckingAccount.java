import java.math.BigDecimal;

public class CheckingAccount extends Account {//subclass
    protected double fee;
    //getterFee
    public String getFee(){
        return "User Account Fee: " + fee;
    }
    //setterFee
    public void setFee(double newFee){
        this.fee = newFee;
    }
    //redefinedCredit
    @Override
    public void credit(BigDecimal amount){
        super.credit(amount.subtract(BigDecimal.valueOf(fee)));
    }
    //redefinedDebit
    @Override
    public void debit(BigDecimal amount){
        super.debit(amount.add(BigDecimal.valueOf(fee)));
    }
    //redefinedTostring
    @Override
    public String toString(){
        return "Bank client: " + name + " has $" + balance + "\n" +
                "Account fee: " + fee;
    }
    //constructor
    public CheckingAccount(String name, BigDecimal balance, double fee){
        super(name, balance);
        this.fee = fee;
    }
}
