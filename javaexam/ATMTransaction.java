import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, Customer customer, double overdraftLimit) {
        super(accountNumber, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class ATMTransaction {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your address:");
        String address = sc.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = sc.nextLine();

        Customer customer = new Customer(name, address, phoneNumber);
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1000, customer, 5);
        CurrentAccount currentAccount = new CurrentAccount("CA456", 2000, customer, 1000);

        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        ATM atm = new ATM(bank);

        // Perform transactions
        System.out.println("Choose transaction:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character
        System.out.println("Enter account number:");
        String accountNumber = sc.nextLine();
        System.out.println("Enter amount:");
        double amount = sc.nextDouble();
        sc.close();
        switch (choice) {
            case 1:
                atm.deposit(accountNumber, amount);
                break;
            case 2:
                atm.withdraw(accountNumber, amount);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}