package chukz;

public interface AtmInterface  {
    void withDrawAmount(double withdrawAmount);

    void depositAmount(double depositAmount );

    void availableBalance();

    void MiniStatement();

    int getNumber();

    int getPin();
}
