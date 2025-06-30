import java.util.ArrayList;
import java.util.Date;
class Account
{
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactions;
    public Account(String accountHolder, double initialBalance)
    {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account opened for " + accountHolder + " with balance Rs." + initialBalance);
    }
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            transactions.add("Deposited Rs." + amount + " on " + new Date());
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount + " on " + new Date());
        } else {
            System.out.println("Withdrawal failed: invalid amount/insufficient funds.");
        }
    }
    public void printBalance()
    {
        System.out.println("Current balance for " + accountHolder + ": Rs." + balance);
    }
    public void printTransactions()
    {
        System.out.println("Transaction history for " + accountHolder + ":");
        for(String transaction : transactions)
        {
            System.out.println(transaction);
        }
    }
}
class SavingsAccount extends Account
{
    private double interestRate;
    public SavingsAccount(String accountHolder, double initialBalance, double interestRate)
    {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }
    @Override
    public void deposit(double amount)
    {
        super.deposit(amount);
        double interest = (amount * interestRate) / 100;
        balance += interest;
        transactions.add("Interest of Rs." + interest + " added for deposit on " + new Date());
    }
}
public class BankSimulation
{
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount("Teja", 5000, 2.4);
        myAccount.deposit(2000);
        myAccount.withdraw(1500);
        myAccount.deposit(1000);
        myAccount.withdraw(3000);
        myAccount.printBalance();
        myAccount.printTransactions();
    }
}