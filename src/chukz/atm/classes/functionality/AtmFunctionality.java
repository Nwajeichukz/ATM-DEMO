package chukz.atm.classes.functionality;

import chukz.atm.interfaces.AtmInterface;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AtmFunctionality extends Atm implements AtmInterface {

    public AtmFunctionality(int number, int pin) {
        super(number, pin);
    }

    Map<Double, String> miniStatement = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    private final Logger logger = Logger.getLogger(AtmFunctionality.class.getName());

    public void enterDetails() {
        try{
            logger.log(Level.INFO,"WELCOME TO THE ATM MACHINE" +
                "\nENTER ACCOUNT NUMBER: ");
            int accountNum = validateInt(sc.next());
            logger.log(Level.INFO,"ATM PIN:");
            int atmPin = validateInt(sc.next());
            display(accountNum, atmPin);
        }catch(InputMismatchException ex) {
            logger.log(Level.INFO,"SOMETHING WENT WRONG: INPUT ARE BEING MISMATCHED\nRELOADED PAGE AND INPUT NUMERICAL VALUES\n" + ex);
        }
    }


    public void display(int acctNumber, int atmPin) {
        if ((acctNumber == getNumber()) && (getPin() == atmPin)) {
            while (true) {
                logger.log(Level.INFO,"1. Check Available Balance \n2. Withdraw Amount \n3. Deposit Amount \n4. View Mini Statement \n5. Exit\nEnter Option: ");
                int option = validateInputOption(sc.next());

                if(option == 1){
                    logger.log(Level.INFO,"Check balance");
                    availableBalance();
                }else if (option == 2) {
                    logger.log(Level.INFO,"Enter Amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    withDrawAmount(withdraw);
                }else if (option == 3) {
                    logger.log(Level.INFO,"Deposit Amount");
                    int deposit = sc.nextInt();
                    depositAmount(deposit);
                }else if (option == 4){
                    logger.log(Level.INFO,"Mini Statement");
                    miniStatement();
                } else if (option == 5) {
                    logger.log(Level.INFO,"Remove Your card!!!");
                    System.exit(0);
                    break;
                }else {
                    logger.log(Level.INFO,"\nINVALID OPTION...");
                }
            }

        }else {
            logger.log(Level.INFO,"\nINVALID ACCOUNT NUMBER AND PASSWORD\n");
            enterDetails();
        }

    }

    public void availableBalance() {
        String st =  String.format("Available Balance: %s", getBalance());
        logger.log(Level.INFO,st);
    }


    public void withDrawAmount(double withdrawAmount) {
        if(withdrawAmount >= 500) {
            if(withdrawAmount < getBalance()){
                miniStatement.put(withdrawAmount, "Amount withDrawn");
                String st = "TRANSACTION SUCCESSFUL......\n";
                logger.log(Level.INFO,st);
                setBalance(getBalance() - withdrawAmount);
                availableBalance();
            }else{
                logger.log(Level.INFO,"\nTRANSACTION DECLINED......\nInsufficient Funds...");
            }
        }else{
            logger.log(Level.INFO, "\nThe Minimum withdrawal is 500...");
        }
    }



    public void depositAmount(double depositAmount ) {
        miniStatement.put(depositAmount, "Amount deposited");
        String st = String.format(depositAmount + " Money Deposited");
        logger.log(Level.INFO,st);
        setBalance(getBalance() + depositAmount);
        availableBalance();
    }


    public void miniStatement() {
        for (Map.Entry<Double, String> m:miniStatement.entrySet()){
            String st = String.format(String.valueOf(m.getKey()), m.getValue());
            logger.log(Level.INFO,st);
        }
    }

    public int validateInputOption(String num) {
        Pattern pat = Pattern.compile("([1-5])");
        Matcher mat = pat.matcher(num);
        if (!mat.matches()) {
            logger.log(Level.INFO, "Invalid Number: Please Enter 1,2,3,4 or 5 \n Try again : ");
            String newInput = sc.next();
            return validateInputOption(newInput);
        }
        return Integer.parseInt(num);
    }

    public int validateInt(String num) {
        Pattern pat = Pattern.compile("(\\d+)");
        Matcher mat = pat.matcher(num);
        if (!mat.matches()) {
            logger.log(Level.INFO, "Invalid Number: Numerical Digits Required...... \n Try Again:");
            String newInput = sc.next();
            return validateInt(newInput);
        }
        return Integer.parseInt(num);
    }
}