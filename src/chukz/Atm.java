package chukz;

public class Atm {
    private final int number;
    private final int pin;

    private double balance;


    public Atm(int number, int pin) {
        this.number = number;
        this.pin = pin;
    }

    public int getNumber() {
        return number;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
