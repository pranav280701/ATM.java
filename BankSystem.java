
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class BankSystem{
 

public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(10000);
        
        System.out.println("Current Balance: " + myAccount.getBalance());
        
        if (myAccount.getCash(2000)) {
            System.out.println("Withdrawal Successful. New Balance: " + myAccount.getBalance());
        } else {
            System.out.println("Insufficient funds!");
        }
        
        myAccount.depositCash(5000);
        System.out.println("After Deposit, Balance: " + myAccount.getBalance());
    }
}