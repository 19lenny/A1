import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //setting up a vending machine
        VendingMachine monster = new VendingMachine(22.20,15.8);
        //test to do operations on the drink side
        monster.refillDrinks(5, "Coke");
        monster.refillDrinks(2, "Tea");
        System.out.println(monster.getSoftDrinksCompartment().stockCounter());

        //normal case to buy a soft drink
        monster.buySoftDrink(3, "Coke", 100);
        //check if the drink is dispensed.
        System.out.println(monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println(monster.getCashCompartment().accountingReceipt(0));
        System.out.println(monster.getCashCompartment().getCashBalance());

        //not enough funds
        monster.buySoftDrink(3, "Coke", 5);
        //check if the drink is dispensed.
        System.out.println(monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println(monster.getCashCompartment().accountingReceipt(1));
        System.out.println(monster.getCashCompartment().getCashBalance());

        //not enough drinks
        monster.buySoftDrink(30, "Coke", 5000);
        //check if the drink is dispensed.
        System.out.println(monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println(monster.getCashCompartment().accountingReceipt(1));
        System.out.println(monster.getCashCompartment().getCashBalance());

    }
}