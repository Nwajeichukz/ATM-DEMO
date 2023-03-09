package chukz;

import java.util.HashMap;
import java.util.Map;

public class AtmFunctionality extends Atm implements AtmInterface {

    public AtmFunctionality(int number, int pin) {
        super(number, pin);
    }

    Map<Double, String> miniStatement = new HashMap<>();

    public void availableBalance() {
        System.out.println("Available Balance: " + getBalance());
    }

    public void withDrawAmount(double withdrawAmount) {
        if(withdrawAmount >= 500) {
            if(withdrawAmount < getBalance()){
                miniStatement.put(withdrawAmount, "Amount withDrawn");
                System.out.println(withdrawAmount + " Collect your cash");
                setBalance(getBalance() - withdrawAmount);
                availableBalance();
            }else {
                System.out.println("Insufficient Fund");
            }
        }else {
            System.out.println("The Minimum withdrawal is 500");
        }
    }

    public void depositAmount(double depositAmount ) {
        miniStatement.put(depositAmount, "Amount deposited");
        System.out.println(depositAmount + " Money Deposited");
        setBalance(getBalance() + depositAmount);
        availableBalance();
    }

    public void MiniStatement() {
        for (Map.Entry<Double, String> m:miniStatement.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

