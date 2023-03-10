
import java.util.Scanner;
class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register(){
        Scanner sc = new Scanner (System.in);
        System.out.print("\nEnter Your Name = ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username = ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password = ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number = ");
        this.accountNo = sc.nextLine();

        System.out.println("\nRegistration completed..kindly login");

    }

    public boolean login() {
        boolean isLoggedin = false;
        Scanner sc = new Scanner(System.in);
        while(!isLoggedin){
            System.out.print("\nEnter Username = ");
            String Username =sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLoggedin) {
                    System.out.print("\nEnter Password = ");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.print("\nLogin Successful !");
                        isLoggedin = true;
                    }else{
                        System.out.println("\nWrong Password !");
                    }
                }
            } else {
                System.out.println("\nUsername Not Found !");
            }
        }
        
        return isLoggedin;
    }

    public void withdraw(){
        System.out.print("\nEnter the withdraw amount = ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successful !"); 
                String str = "Rs. " + amount + " withdrew\n";
                transactionHistory = transactionHistory.concat(str);
            }else{
                System.out.println("\nInsufficient Balance !");
            }
        }
        catch (Exception e){
        }
    }

    public void deposit(){
        System.out.print("\nEnter amount = ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try{
            if(amount <= 100000f){
                transactions++;
                balance += amount;
                System.out.println("\nDeposited Successfully !");
                String str = "Rs ." + amount + " deposited\n";
                transactionHistory = transactionHistory.concat(str); 
            }else{
                System.out.println("\nThe Limit is ₹1000000.....");
            }
        }
        catch(Exception e){}
    }

    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipients Name = ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter the amount to be transferred = ");
        float amount = sc.nextFloat();

        try{
            if(balance >= amount){
                if(amount <= 50000f){
                    transactions++;
                    balance -= amount;
                    System.out.println("\nTransfer Successful to " + recipient + " !");
                    String str = "Rs. " + amount + " transferred to " + recipient + " !\n";
                    transactionHistory = transactionHistory.concat(str);
                }else{
                    System.out.println("\nLimit is ₹50000 !");
                }
            }else{
                System.out.println("\nInsufficient Balance !");
            }
        }
        catch(Exception e){}
    }

    public void balanceCheck(){
        System.out.println("\n" + "Rs. " + balance);
    }

    public void history(){
        if(transactions == 0){
            System.out.println("\nNO TRANSACTIONS !");
        }else{
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class AtmInterface{

    public static void main(String[] args) {
        System.out.println("\n############## GREETINGS, WELCOME TO THE ATM ! ##############");    
        System.out.println("1. REGISTER ");
        System.out.println("2. EXIT ");
        System.out.print("Enter Your Choice = ");

        int choice = intInput(2);

        if(choice == 1){
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1. LOGIN \n2. EXIT");
                System.out.print("Enter Your Choice = ");
                int ch = intInput(2);

                if(ch == 1){
                    if(b.login()){
                        System.out.println("\n############## WELCOME BACK " + b.name + " ##############\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Balance \n5. History \n6. Exit");
                            System.out.print("\nEnter Your Choice = ");
                            int c = intInput(6);

                            switch (c) {
                                    case 1:
                                    b.withdraw();
                                    break;
                                    case 2:
                                    b.deposit();
                                    break;
                                    case 3:
                                    b.transfer();
                                    break;
                                    case 4:
                                    b.balanceCheck();
                                    break;
                                    case 5:
                                    b.history();
                                    break;
                                    case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }else{
                    System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }
    }

    public static int intInput(int limit){
        int input = 0;
        boolean flag = false;
        while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if(flag && input > limit || input < 1 ){
                    System.out.println("Choose between 1 to " + limit);
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Only Integer Values Accepted !");
                flag = false;
            }
        }
        return input;
    }

}
