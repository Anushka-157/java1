package java;
import java.util.ArrayList;

class Customer {
    public String name;
    public String address;
    public String phoneNumber;

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

class Bank {
    public ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Other methods for managing customers
}

class Account {
    public double balance;

    public Account() {
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    // Other methods for account operations
}

class SavingsAccount extends Account {
    public double interestRate;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    // Additional methods specific to savings account
}

class CurrentAccount extends Account {
    public double overdraftLimit;

    public CurrentAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // Additional methods specific to current account
}

class ATM extends Account {
    public void withdraw(Account account, double amount) {
        if (account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) account;
            if (amount <= currentAccount.balance+ currentAccount.overdraftLimit) {
                currentAccount.withdraw(amount);
                System.out.println("Withdrawal successful. Remaining balance: " + currentAccount.balance);
            } else {
                System.out.println("Exceeds overdraft limit.");
            }
        } else if (account instanceof SavingsAccount && account.balance >= amount) {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Remaining balance: " + account.balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Updated balance: " + account.balance);
    }

    // Other ATM operations

class ATMTransaction {
    // Define transaction attributes and methods
}
}

public class Bms {
    public static void main(String[] args) {
        // Creating a bank
        Bank bank = new Bank();

        // Creating customers
        Customer customer1 = new Customer("Anushka", "123 kapu", "6363565658");
        Customer customer2 = new Customer("Jishmitha", "456 padubidri", "4567890123");

        // Adding customers to the bank
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        // Creating accounts for customers
        SavingsAccount savingsAccount1 = new SavingsAccount(0.05);
        CurrentAccount currentAccount1 = new CurrentAccount(1000.0);

        SavingsAccount savingsAccount2 = new SavingsAccount(0.03);
        CurrentAccount currentAccount2 = new CurrentAccount(1500.0);
        System.out.println(currentAccount1);
        // Depositing and withdrawing money from accounts
        savingsAccount1.deposit(1000);
        System.out.println(savingsAccount1);
        savingsAccount1.withdraw(500);
        System.out.println(savingsAccount2);

        currentAccount2.deposit(2000);
        currentAccount2.withdraw(1000);

        // Testing ATM operations
        ATM atm = new ATM();
        atm.withdraw(savingsAccount1, 200);
        atm.deposit(currentAccount2, 300);

        // Print customer information
        System.out.println("Customer 1: " + customer1.getName());
        System.out.println("Customer 2: " + customer2.getName());
    }
}

