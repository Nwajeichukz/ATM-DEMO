package chukz.atm.classes.mainMethod;

import chukz.atm.classes.functionality.AtmFunctionality;
import chukz.atm.interfaces.AtmInterface;

public class Main {
    public static void main(String[] args){
        AtmInterface atmInterface = new AtmFunctionality(12345, 123);
        atmInterface.enterDetails();
    }
}