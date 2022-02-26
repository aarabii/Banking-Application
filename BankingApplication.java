import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args){

        Scanner user = new Scanner(System.in);
        System.out.println("Please enter your name.\n");
        String userName = user.nextLine().toLowerCase();

//        int min = 2564;
//        int max = 9548764;
//        int id = (int)(Math.random() * (max-min+1)+min);

        BankAccount obj1 = new BankAccount(userName, "BA00001");
        obj1.showMenu();
    }

}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname,String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount != 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        if(amount != 0)
        {
            balance = balance - amount;
            previousTransaction = amount;
        }
    }

    void getPreviousTransaction()
    {
        if(previousTransaction > 0)
        {
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction < 0)
        {
            System.out.println("Withdrawn: "+Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No transaction occured.");
        }
    }

    void showMenu()
    {
        char option='\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do
        {
            System.out.println("========================================================================================");
            System.out.println("Enter an option.");
            System.out.println("========================================================================================");
            option = scanner.next().toLowerCase().charAt(0);
            System.out.println("\n");

            switch(option)
            {
                case 'a':
                    System.out.println("----------------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                case 'b':
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("----------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'c':
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("----------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'd':
                    System.out.println("----------------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("----------------------------------------");
                    break;

                default:
                    System.out.println("Invalid option!!! \nPlease enter again.");
                    break;

            }
        } while (option != 'e');

        System.out.println("Thank you for using our services.");

    }

}
