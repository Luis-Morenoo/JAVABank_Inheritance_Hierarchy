import java.math.BigDecimal;//subclass

public class SavingAccount extends Account {
    protected double intrest;
    //getterIntrest
    public String getIntrest(){
        return "User Account Intrest: " + intrest ;
    }
    //setterIntrest
    public void setIntrest(double newIntrest){
        this.intrest = newIntrest;
    }
    //calculate intrest method

    public BigDecimal calculateIntrest(){

        return balance.multiply(BigDecimal.valueOf(intrest));
    }
    
    //constructor
    public SavingAccount(String name, BigDecimal balance, double intrest){
        super(name, balance);
        if(intrest < 0 || intrest > 1){
            System.out.println("Error: Interest rate needs to be between 0 and 1");
        }
        this.intrest = intrest;
    }
    //toString redefined
    @Override
    public String toString(){
        return "Bank client: " + name + " has $" + balance +
                "Account balance: " + balance + "\n" +
                "Account interest: " + intrest;
    }


}
