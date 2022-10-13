import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //testing
        //the following lines, test every function with the following lines
        //they are not proper expection tests, but work in kind of a similiar way
        //it creates a lot of outputs to the terminal
        //the best way of doing is just running method by method and comment out the rest of the methods

        testVendingMachineCaseSnack();
        testVendingMachineCaseSoftDrink();
        testSoftDrinkCompartment();
        testSnackCompartment();
        testCashCompartment();
        testSnack();
        testSoftDrink();


    }
    public static void testVendingMachineCaseSnack(){
        System.out.println("\nThese method tests the function of the Vending Machine, testcase Snack \n");
        //setting up a vending machine
        VendingMachine monster = new VendingMachine(22.20,15.8);

        //test to do operations on the snack side
        System.out.println("\nTest Case: Add 4 bags of Chips and 2 Cookies, check the stock of all products");
        monster.refillSnacks(4, "Chips");
        monster.refillSnacks(2, "Cookie");
        System.out.println("stock of all products: The result should be 6: " +monster.getSnacksCompartment().stockCounter());

        //normal case to buy a soft drink
        System.out.println("\nTest Case: buy 3 bag of chips, check stock of chips and check the accounting of this 3 chips ");
        monster.buySnack(3, "Chips", 100);
        //check if the drink is dispensed.
        System.out.println("stock chips: The result should be 4-3 = 1: " +monster.getSnacksCompartment().productCounter("Chips"));
        System.out.println("cost of the transaction: The result should be 3*22.2 = 66.60: " +monster.getCashCompartment().accountingReceipt(0));
        System.out.println("total cash balance: only one purchase --> result: 66.60: " +monster.getCashCompartment().getCashBalance());

        //not enough funds
        System.out.println("\nTest Case: buy 3 bag of chips without enough funds, check stock of chips and check the accounting of the purchase, without funds ");
        monster.buySnack(3, "Chips", 5);
        //check if the drink is dispensed.
        System.out.println("stock chips: The result should be 1: " +monster.getSnacksCompartment().productCounter("Chips"));
        System.out.println("cost for this transaction: no transaction --> error message and return 0: " +monster.getCashCompartment().accountingReceipt(1));
        System.out.println("total cash balance: The result should be 66.60: " +monster.getCashCompartment().getCashBalance());

        //not enough snacks
        System.out.println("\nTest Case: buy 30 bag of chips without enough chips in stock, check stock of chips and check the accounting of the purchase");
        monster.buySnack(30, "Chips", 5000);
        //check if the drink is dispensed.
        System.out.println("stock chips: The result should be 0: " +monster.getSnacksCompartment().productCounter("Chips"));
        System.out.println("cost for this transaction: The result should be 22.2: "+monster.getCashCompartment().accountingReceipt(1));
        System.out.println("total cash balance: The result should be 88.80: " +monster.getCashCompartment().getCashBalance());

        System.out.println("\nTest ending of the function of the Vending Machine, testcase Snack \n");

    }

    public static void testVendingMachineCaseSoftDrink(){
        System.out.println("\nThese method tests the function of the Vending Machine, testcase SoftDrink \n");
        //setting up a vending machine
        VendingMachine monster = new VendingMachine(15.8,22.2);

        //test to do operations on the snack side
        System.out.println("\nTest Case: Add 4 cans of Coke and 2 Teas, check the stock of all products");
        monster.refillDrinks(4, "Coke");
        monster.refillDrinks(2, "Tea");
        System.out.println("stock of all products: The result should be 6: " +monster.getSoftDrinksCompartment().stockCounter());

        //normal case to buy a soft drink
        System.out.println("\nTest Case: buy 3 cans of Coke, check stock of Coke and check the accounting of this 3 Coke ");
        monster.buySoftDrink(3, "Coke", 100);
        //check if the drink is dispensed.
        System.out.println("stock Coke: The result should be 4-3 = 1: " +monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println("cost of the transaction: The result should be 3*22.2 = 66.60: " +monster.getCashCompartment().accountingReceipt(0));
        System.out.println("total cash balance: only one purchase --> result: 66.60: " +monster.getCashCompartment().getCashBalance());

        //not enough funds
        System.out.println("\nTest Case: buy 3 cans of Coke without enough funds, check stock of Coke and check the accounting of the purchase, without funds ");
        monster.buySoftDrink(3, "Coke", 5);
        //check if the drink is dispensed.
        System.out.println("stock Coke: The result should be 1: " +monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println("cost for this transaction: no transaction --> error message and return 0: " +monster.getCashCompartment().accountingReceipt(1));
        System.out.println("total cash balance: The result should be 66.60: " +monster.getCashCompartment().getCashBalance());

        //not enough drinks
        System.out.println("\nTest Case: buy 30 cans of Coke without enough Coke in stock, check stock of Coke and check the accounting of the purchase");
        monster.buySoftDrink(30, "Coke", 5000);
        //check if the drink is dispensed.
        System.out.println("stock Coke: The result should be 0: " +monster.getSoftDrinksCompartment().productCounter("Coke"));
        System.out.println("cost for this transaction: The result should be 22.2: "+monster.getCashCompartment().accountingReceipt(1));
        System.out.println("total cash balance: The result should be 88.80: " +monster.getCashCompartment().getCashBalance());

        System.out.println("\nTest ending of the function of the Vending Machine, testcase SoftDrinks \n");

    }

    public static void testSoftDrinkCompartment(){
        System.out.println("\nThese method tests the function of the SoftDrinkCompartment \n");
        SoftDrinksCompartment lager = new SoftDrinksCompartment();

        lager.refill(3, "Cola");
        lager.refill(2, "Tea");

        System.out.println("\nTest Case: add 3 Cola, add 2 Tea, check stock and product counter");
        System.out.println("stock Total: The result should be 5: "+lager.stockCounter()); //5
        System.out.println("stock Cola: The result should be 3: "+lager.productCounter("Cola")); //3

        lager.refill(1, "Cola");

        System.out.println("\nTest Case: Refill Cola, check stock and product counter");
        System.out.println("stock Total: The result should be 6: "+lager.stockCounter());
        System.out.println("stock Cola: The result should be 4: "+lager.productCounter("Cola"));

        System.out.println("\nTest Case: Dispend 2 Cola, check stock and product counter");
        lager.dispender(2, "Cola");
        System.out.println("stock Total: The result should be 4: "+lager.stockCounter());
        System.out.println("stock Cola: The result should be 2: "+lager.productCounter("Cola"));

        System.out.println("\nTest Case: second dispender function, where only one Cola gets dispended, check stock and product counter");
        lager.dispender("Cola");
        System.out.println("stock Total: The result should be 3: "+lager.stockCounter());
        System.out.println("stock Cola: The result should be 1: "+lager.productCounter("Cola"));

        System.out.println("\nTest Case: second dispender function, where only one Cola gets dispended, check stock and product counter");
        lager.dispender("Cola");
        System.out.println("stock Total: The result should be 2: "+lager.stockCounter());
        System.out.println("stock Cola: The result should be 0: "+lager.productCounter("Cola"));

        System.out.println("\nTest Case: second dispender function, where only one Cola gets dispended, but this time not enough Cola" +
                "check stock and product counter");
        lager.dispender("Cola");
        System.out.println("stock Total: The result should be 2: "+lager.stockCounter());
        System.out.println("stock Cola: error message + return 0: "+lager.productCounter("Cola"));

        System.out.println("\nTest Case: Dispend 7 Tea, but only 2 Tea available, give out this 2 Tea and" +
                " check stock and product counter");
        System.out.println("stock Tea before dispension: result 2: "+lager.productCounter("Tea")); //0
        lager.dispender(7,"Tea");
        System.out.println("stock Total: The result should be 0: "+lager.stockCounter());
        System.out.println("stock Tea (after dispension: error message + return 0: "+lager.productCounter("Cola"));

        System.out.println("\nTest ending of the function of DrinkCompartment \n");
    }

    public static void testSnackCompartment(){
        System.out.println("\nThese method tests the function of the SnacksCompartment \n");
        SnacksCompartment lager = new SnacksCompartment();

        lager.refill(3, "Chips");
        lager.refill(2, "Cookie");

        System.out.println("\nTest Case: add 3 Chips, add 2 Cookie, check stock and product counter");
        System.out.println("stock Total: The result should be 5: "+lager.stockCounter()); //5
        System.out.println("stock Chips: The result should be 3: "+lager.productCounter("Chips")); //3

        lager.refill(1, "Chips");

        System.out.println("\nTest Case: Refill Chips, check stock and product counter");
        System.out.println("stock Total: The result should be 6: "+lager.stockCounter());
        System.out.println("stock Chips: The result should be 4: "+lager.productCounter("Chips"));

        System.out.println("\nTest Case: Dispend 2 Chips, check stock and product counter");
        lager.dispender(2, "Chips");
        System.out.println("stock Total: The result should be 4: "+lager.stockCounter());
        System.out.println("stock Chips: The result should be 2: "+lager.productCounter("Chips"));

        System.out.println("\nTest Case: second dispender function, where only one Chips gets dispended, check stock and product counter");
        lager.dispender("Chips");
        System.out.println("stock Total: The result should be 3: "+lager.stockCounter());
        System.out.println("stock Chips: The result should be 1: "+lager.productCounter("Chips"));

        System.out.println("\nTest Case: second dispender function, where only one Chips gets dispended, check stock and product counter");
        lager.dispender("Chips");
        System.out.println("stock Total: The result should be 2: "+lager.stockCounter());
        System.out.println("stock Chips: The result should be 0: "+lager.productCounter("Chips"));

        System.out.println("\nTest Case: second dispender function, where only one Chips gets dispended, but this time not enough Chips" +
                "check stock and product counter");
        lager.dispender("Chips");
        System.out.println("stock Total: The result should be 2: "+lager.stockCounter());
        System.out.println("stock Chips: error message + return 0: "+lager.productCounter("Chips"));

        System.out.println("\nTest Case: Dispend 7 Cookie, but only 2 Cookie available, give out this 2 Cookie and" +
                " check stock and product counter");
        System.out.println("stock Cookie before dispension: result 2: "+lager.productCounter("Cookie")); //0
        lager.dispender(7,"Cookie");
        System.out.println("stock Total: The result should be 0: "+lager.stockCounter());
        System.out.println("stock Cookie (after dispension: error message + return 0: "+lager.productCounter("Cookie"));

        System.out.println("\nTest ending of the function of SnackCompartment \n");
    }

    public static void testCashCompartment(){
        System.out.println("\nThese method tests the function of the Cash Compartment \n");
        CashCompartment lager = new CashCompartment();
        System.out.println("\nTest Case: add 100 + 1000 + 600, check total balance and each entry");
        lager.receivePayments(100);
        lager.receivePayments(1000);
        lager.receivePayments(600);

        System.out.println("test total cash: result 1700: "+lager.getCashBalance());
        System.out.println("test first entry: result 100: "+lager.accountingReceipt(0));
        System.out.println("test second entry: result 1000: "+lager.accountingReceipt(1));
        System.out.println("test third entry: result 600: "+lager.accountingReceipt(2));

        System.out.println("\nTest Case: check cash balance with invalid balance - result: error message");
        lager.accountingReceipt(3);

        System.out.println("\nTest ending of the function of CashCompartment \n");
    }

    public static void testSoftDrink(){
        System.out.println("\nThese method tests the function of the Soft Drink \n");
        SoftDrink softDrink = new SoftDrink("Coke");
        System.out.println("\nTest Case: retrieve name of soft drink - result Coke");
        System.out.println(softDrink.getName());
        System.out.println("\nTest ending of the function of softDrink \n");
    }
    public static void testSnack(){
        System.out.println("\nThese method tests the function of the Snack \n");
        SoftDrink softDrink = new SoftDrink("Cookie");
        System.out.println("\nTest Case: retrieve name of Snack - result Cookie");
        System.out.println(softDrink.getName());
        System.out.println("\nTest ending of the function of Snack \n");
    }
}