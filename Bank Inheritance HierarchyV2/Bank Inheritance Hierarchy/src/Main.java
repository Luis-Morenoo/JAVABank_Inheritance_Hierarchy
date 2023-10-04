import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import java.util.Scanner; // used for user input
import java.math.BigDecimal;// used for big decimal
import java.util.ArrayList;// used for arraylist

public class Main{
    //used as the main
    public static void main(String[] args) {
        //scanner for user input
        Scanner userName = new Scanner(System.in);
        // asks user to enter amount of accounts are going to be created
        System.out.print("Enter amount of accounts to create:");
        int userAccount = userName.nextInt();

        ArrayList<Account> newAccounts = new ArrayList<>();
        userName.nextLine();

        // for loops to create each account and fill it up with its correct information
        for (int i = 0; i < userAccount; i++){
            System.out.print("Enter the name of the account No. "+ (i + 1) + ":");
            String accountNames = userName.nextLine();
            //checks if account is for checking or saving
            System.out.print("Type of account? 1 for checking 2 for saving: ");
            int option = userName.nextInt();
            //enter the beginning balance
            System.out.print("Enter the initial balance: ");
            BigDecimal userBalance = userName.nextBigDecimal();
            //if else statement to check if saving or checking
            Account account = null;
            if (option == 1){
                System.out.print("Enter the fee: ");
                double userFee = userName.nextDouble();
                account = new CheckingAccount(accountNames, userBalance, userFee);

            }else if(option == 2){
                System.out.print("Enter the interest rate: ");
                double userInterest = userName.nextDouble();
                account = new SavingAccount(accountNames, userBalance, userInterest);
            }
            userName.nextLine();
            newAccounts.add(account);
            System.out.println("\n");
        }
        //processing accounts part
        System.out.println(
                "\n" + "======================================" + "\n" +
                "Processing all accounts:" + "\n" +
                        "======================================" + "\n");

        int accountPlace = 1;
        for (Account account: newAccounts){
            System.out.println("Account"+"("+accountPlace+")");
            System.out.println("Bank client: "+account.getName() + " has $"+account.getBalance());
            //amount to be withdrawn from account
            System.out.println("Enter an amount to withdraw from Account("+accountPlace+")");
            BigDecimal withdraw = userName.nextBigDecimal();
            account.debit(withdraw);
            //amount to be debited to the account
            System.out.println("Enter an amount to deposit into Account("+accountPlace+")");
            BigDecimal deposit = userName.nextBigDecimal();
            account.credit(deposit);
            //instanceof is used to test whether the object is an instance of specified type
            if (account instanceof SavingAccount) {
                SavingAccount savings = (SavingAccount) account;
                BigDecimal userInterest = savings.calculateIntrest();
                savings.credit(userInterest);
                //adding the intrest to the savings account accounts
                System.out.println("Adding $"+userInterest+ " interest to Account "+accountPlace+ " (a SavingsAccount)");
            }
            System.out.println("Updated Account("+accountPlace+") Name: "+account.getName()+ " balance:$"+account.getBalance());
            System.out.println("\n");
            accountPlace++;

        }

    }
}



