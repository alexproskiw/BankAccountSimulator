import java.util.Scanner;

public class Account {

    // Initialize fields

    private final double interestRate = 0.025;
    private String customerName;
    private String customerID;
    private int balance;
    private int previousTransaction;

    // Constructor
    public Account(String name, String id) {
        customerName = name;
        customerID = id;
        balance = 0;
    }

    // Check the account balance
    public int checkBalance() {
        return balance;
    }

    // Make a deposit
    public void deposit(int amount) {
        if (amount <= 0) {
            handleNegativeAmount();
        } else {
            balance += amount;
            previousTransaction = amount;
            System.out.println("Your deposit of $" + amount + " was successful");
            System.out.println("Your new account balance is $" + balance);
            spacing();
        }
    }

    // Make a withdrawal
    public void withdraw(int amount) {
        int newBalance = balance - amount;

        if (amount <= 0) {
            handleNegativeAmount();
        } else if (newBalance < 0) {
            System.out.println("You do not have sufficient funds to withdraw this amount");
            System.out.println("The withdrawal has not been processed");
            spacing();
        } else {
            balance = newBalance;
            previousTransaction = -amount;
            System.out.println("Your withdrawal of $" + amount + " was successful");
            System.out.println("Your new account balance is $" + balance);
            spacing();
        }
    }

    // Get previous transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Your previous transaction was a deposit of: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Your previous transaction was a withdrawal of: " + previousTransaction);
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Calculate interest earned on current balance after a number of years
    public void calculateInterest(int years) {
        int interest = (int) Math.floor(balance * interestRate * years);
        int newBalance = balance + interest;
        System.out.println("After " + years + " years, you could earn $" + interest + " in interest");
        System.out.println("Your new balance would be $" + newBalance);
    }

    // Show the main menu and customer interaction
    public void showMenu() {
        String option;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        spacing();
        System.out.println("Welcome, " + customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("How can ProBank help you today?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest on balance");
        System.out.println("F. Exit");
        spacing();

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            option = scanner.next();

            if (option.equalsIgnoreCase("A")) {
                spacing();
                System.out.println("Balance = $" + balance);
                spacing();
                System.out.println();
            } else if (option.equalsIgnoreCase("B")) {
                spacing();
                System.out.println("Enter an amount to deposit:");
                int amount = scanner.nextInt();
                deposit(amount);
            } else if (option.equalsIgnoreCase("C")) {
                spacing();
                System.out.println("Enter an amount to withdraw:");
                int amount = scanner.nextInt();
                withdraw(amount);
            } else if (option.equalsIgnoreCase("D")) {
                spacing();
                getPreviousTransaction();
                spacing();
                System.out.println();
            } else if (option.equalsIgnoreCase("E")) {
                spacing();
                System.out.println("Our current interest rate is " + (interestRate * 100) + "%");
                System.out.println("How many years would you like to invest your balance for?");
                int years = scanner.nextInt();
                calculateInterest(years);
                spacing();
            } else if (option.equalsIgnoreCase("F")) {
                System.out.println();
                spacing();
                System.out.println("Thank you for banking with ProBank");
                spacing();
            } else {
                spacing();
                System.out.println("Error: invalid entry. Please enter A, B, C, D, E, or F.");
                spacing();
            }
        }
        while (!(option.equalsIgnoreCase("F")));
    }

    private void spacing() {
        System.out.println("============================================================================");
    }

    private void handleNegativeAmount() {
        System.out.println("Sorry, this is an invalid deposit amount.");
        System.out.println("Next time, please enter a positive whole number.");
        spacing();
    }
}
