package chukz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmInterface atmInterface = new AtmFunctionality(12345, 123);

        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE ATM MACHINE");
        System.out.println("ENTER ATM NUMBER:");
        int atmNumber = sc.nextInt();
        System.out.println("ATM PIN:");
        int atmPin = sc.nextInt();

        if ((atmNumber == atmInterface.getNumber()) && (atmInterface.getPin() == atmPin)) {
            while (true) {
                System.out.println("1. Check Available Balance \n2. Withdraw Amount \n3. Deposit Amount \n4. View Mini Statement \n5. Exit\nEnter Option: " );
                int option = sc.nextInt();

                if(option == 1){
                    System.out.println("Check balance");
                    atmInterface.availableBalance();
                }else if (option == 2) {
                    System.out.print("Enter Amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    atmInterface.withDrawAmount(withdraw);

                }else if (option == 3) {
                    System.out.println("Deposit Amount");
                    int deposit = sc.nextInt();
                    atmInterface.depositAmount(deposit);
                }else if (option == 4){
                    System.out.println("Mini Statement");
                    atmInterface.MiniStatement();
                } else if (option == 5) {
                    System.out.println("Remove Your card!!!");
                    System.exit(0);

                }

            }

        }else {
            System.out.println("Wrong ATM number & Pin!!!");
        }
    }
}