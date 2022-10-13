//
//
public class VendingMachine {

    //Field Variables
    //reference to the soft drink compartment. The machine has 8 slots for soft drinks.
    private SoftDrinksCompartment softDrinksCompartment = new SoftDrinksCompartment();
    //reference to the snack compartment. The machine has 6 slots for snacks.
    private SnacksCompartment snacksCompartment = new SnacksCompartment();
    //reference to the cash compartment.
    private CashCompartment cashCompartment = new CashCompartment();
    //Field variables for snack and soft drink prices
    private double snackPrice;
    private double softDrinkPrice;

    //constructor which gives the vendor the possibility to choose its snack and soft drink prices
    public VendingMachine(double chosenSnackPrice, double chosenSoftDrinkPrice) {
        snackPrice = chosenSnackPrice;
        softDrinkPrice = chosenSoftDrinkPrice;
    }


    //getters to test the compartments from the outside.
    //It is not part of the assignment, but with that it is easier to test.
    public CashCompartment getCashCompartment() {
        return cashCompartment;
    }

    public SnacksCompartment getSnacksCompartment() {
        return snacksCompartment;
    }

    public SoftDrinksCompartment getSoftDrinksCompartment() {
        return softDrinksCompartment;
    }

    //the possibility to buy a wished amount of soft drinks
    //the buyer has to pay for the amount of drinks she wants to purchase
    //big method therefore logic explained in the method on the fly
    public SoftDrink[] buySoftDrink(int numberOfDrinks, String drinkName, double cashInput) {

        //calculate the price the user has to pay for its products
        double priceToPay = numberOfDrinks * softDrinkPrice;
        //check if the buyer gave enough money. If the price to pay is smaller than the cash input the buyer is allowed to buy his drinks
        if (priceToPay <= cashInput) {
            //if the number of drinks the user wants is smaller than our stock we can give everything to the user
            if (numberOfDrinks <= softDrinksCompartment.productCounter(drinkName)) {
                //this is the basic case, the user gave enough money and we have enough of the drink on stock
                //first calculate the change money the buyer gets when buying the drink
                double change = cashInput - priceToPay;

                //take the users money and add it to our accounting system
                cashCompartment.receivePayments(cashInput - change);

                //Inform the user about her purchase
                System.out.println("Thank you for your purchase. You paid " + priceToPay + " for " + numberOfDrinks + " " + drinkName + "\n" +
                        "Your change is " + change + " DKK.");

                //retrieve the soft drinks from the soft drinks compartment and return it to the user
                return softDrinksCompartment.dispender(numberOfDrinks, drinkName);

            } else {
                //else case: user gave enough money, but we don't have enough items on stock
                //we give all the items we have on stock to the user, we inform the user about the missing items
                //and return him the money, we didn't use
                //we add the money we used to our cash compartment

                //calculate what we can provide to the user and what he has to pay for it
                priceToPay = softDrinksCompartment.productCounter(drinkName) * softDrinkPrice;

                //since we don't have enough in stock, we have to overwrite the customer wish.
                // we will give him everything what is left on stock for this drink
                numberOfDrinks =  softDrinksCompartment.productCounter(drinkName);

                //change calculation
                double change = cashInput - priceToPay;

                //take the users money and add it to our accounting system
                cashCompartment.receivePayments(cashInput - change);

                //Inform the user about her purchase
                System.out.println("Thank you for your purchased. We are sorry, that we couldn't provide with all your products. " +
                        "You paid " + priceToPay + " for " + numberOfDrinks + " " + drinkName + "\n" +
                        "Your change is " + change + " DKK.");

                //retrieve the soft drinks from the soft drinks compartment and return it to the user
                return softDrinksCompartment.dispender(numberOfDrinks, drinkName);
            }
        }
        else {
            //if the user didn't provide enough funds, we pay back the money, but we also not give the user any drink.
            System.out.println("Sorry, you provided insufficient funds. You get your money ("+cashInput+" DKK) back.");
            //define an array for the return statement in case we have to return an empty list
            SoftDrink[] notEnoughFunds = new SoftDrink[0];
            return notEnoughFunds;
        }
    }

    //the buySnack method does exactly the same as the buySoftDrink method,
    //but this time for Snacks instead of SoftDrinks.
    //The logic of the method is the same as the above.
    public Snack[] buySnack(int numberOfSnacks, String snackName, double cashInput) {

        //calculate the price the user has to pay for its products
        double priceToPay = numberOfSnacks * snackPrice;
        //check if the buyer gave enough money. If the price to pay is smaller than the cash input the buyer is allowed to buy his snacks
        if (priceToPay <= cashInput) {
            //if the number of snacks is smaller than our stock we can give everything to the user
            if (numberOfSnacks <= snacksCompartment.productCounter(snackName)) {
                //change calculation
                double change = cashInput - priceToPay;

                //take the users money and add it to our accounting system
                cashCompartment.receivePayments(cashInput - change);

                //Inform the user about her purchase
                System.out.println("Thank you for your purchase. You paid " + priceToPay + " for " + numberOfSnacks + " " + snackName + "\n" +
                        "Your change is " + change + " DKK.");

                //retrieve the snacks from the snacks compartment and return it to the user
                return snacksCompartment.dispender(numberOfSnacks, snackName);

            } else {
                //calculate what we can provide to the user and what he has to pay for it
                priceToPay = snacksCompartment.productCounter(snackName) * snackPrice;

                //since we don't have enough in stock, we have to overwrite the customer wish.
                // we will give him everything what is left on stock for this snack
                numberOfSnacks =  snacksCompartment.productCounter(snackName);

                //change calculation
                double change = cashInput - priceToPay;

                //take the users money and add it to our accounting system
                cashCompartment.receivePayments(cashInput - change);

                //Inform the user about her purchase
                System.out.println("Thank you for your purchased. We are sorry, that we couldn't provide with all your products. " +
                        "You paid " + priceToPay + " for " + numberOfSnacks + " " + snackName + "\n" +
                        "Your change is " + change + " DKK.");

                //retrieve the snacks from the snacks compartment and return it to the user
                return snacksCompartment.dispender(numberOfSnacks, snackName);
            }
        }
        else {
            //if the user didn't provide enough funds, we pay back the money, but we also not give the user any snack.
            System.out.println("Sorry, you provided insufficient funds. You get your money ("+cashInput+" DKK) back.");
            //define an array for the return statement in case we have to return an empty list
            Snack[] notEnoughFunds = new Snack[0];
            return notEnoughFunds;
        }
    }

    //refill the drinks with the help of the softDrinksCompartment
    //gives the user the possibility to refill the amount and product he wants
    public void refillDrinks(int amount, String drinkName){
        softDrinksCompartment.refill(amount, drinkName);
    }

    //refill the snacks with the help of the snacksCompartment
    //gives the user the possibility to refill the amount and product he wants
    public void refillSnacks(int amount, String snackName){
        snacksCompartment.refill(amount, snackName);
    }
}
