//the class SoftDrinksCompartment creates the SoftDrinkCompartment, which will be used in every VendingMachine
//It works with two constructor, so the VendingMachine owner can either wish his own capacity, or build a machine with a predefined size
//the class can count how many products are already in stock
//the class can tell how many items of a specified product are on stock
// and the class can either refill the Compartment or take items out of the compartment
//all logic and details are explained within the methods
public class SoftDrinksCompartment {

    //This field can store the capacity of the SoftDrinksCompartment
    private int capacity;

    //This field declares the array which stores the SoftDrinks in the SoftDrinksCompartment
    private SoftDrink[] stock;

    //Constructor
    //The constructor sets the capacity to a default value of 8.
    //8 seems a reasonabale amount to hold SoftDrinks in a SoftDrinksCompartment.
    //additionally the stock of the SoftDrinksComparted is created.
    //The stock is empty in the beginning and therefore only contains null values.
    public SoftDrinksCompartment(){
        capacity = 8;
        stock = new SoftDrink[capacity];
    }

    //This constructor gives the user a choice
    //The user can choose if she wants to manually set the capacity of the vending machine herself or not
    //If she chooses to do so, she has to use this method and set an integer value, which defines the size of the stock
    public SoftDrinksCompartment(int cap){
        capacity = cap;
        stock = new SoftDrink[capacity];
    }

    //The stockCounter method counts the stock of the SoftDrinksCompartment
    //It returns the calculated value.
    //The value is not stored as a field variable and therefore has to be calculated newly with every call
    //This makes sense since we always want to have the newest update of the stock of the SoftDrinksCompartment
    public int stockCounter(){
        int counter = 0;
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] != null){
                counter++;
            }
        }
        return counter;
    }

    //The productCounter method counts the stock of a specific SoftDrink
    //It returns the calculated value.
    //The value is not stored as a field variable and therefore has to be calculated newly with every call
    //This makes sense since we always want to have the newest update of the stock of this specific SoftDrink
    //The method takes a string as an input, which is the product name that should be counted
    //For easier comparison and to avoid typing mistakes all Strings in this method are manipulated to uppercase letters
    //to do what described, the method compares for every stock item if it is the same as the product the user searches
    //if so the counter is increased by one
    //to avoid null pointers we always check first if the slot in the SoftDrinkCompartment is empty or not
    public int productCounter(String product){
        int counter = 0;
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] != null){
                //this manipulates the user input, in a way that all letters are converted to upper cases
                //this should avoid spelling mistakes
                //the products in stock are also converted to uppercase, such that a comparison can happen
                //after the manipulation they are compared to each other and the counter goes up if they match
                if (product.toUpperCase().equals(stock[i].getName().toUpperCase())) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //by calling this method a user can refill a certain amount of a SoftDrink in the SoftDrinkCompartment
    //first the remaining slots are calculated, to check if there are enough slots for the amount the user wants to refill
    //the refill mechanism only starts if enough slots are available, in the other case the user gets its refilling product back and is informed
    //how the refill process works is described in the 'else' clause
    public void refill(int amount, String filling){
        //calculate the remaining slots for SoftDrinks in our vending machine
        int remainingSlots = capacity - stockCounter();

        //If the refiller wants to put more SoftDrinks in the machine as remaining capacity, the method should stop
        // the method should return the products to the user and inform him
        if (remainingSlots < amount){
            System.out.println("Dear refiller, you tried to refill the vending machine with soft drinks. \n" +
                    "Unfortunately, there are only "+remainingSlots+ " left for soft drinks in the machine. \n" +
                    "You tried to put "+ amount+" drinks in the machine. \n" +
                    "Please try again, after removing some.");
        }
        //else: the refiller puts in a correct amount
        //the vending machine gets filled from the top
        //the first empty slot is filled with a new soft drink
        //the SoftDrink is created from the name the refiller gets us
        //the vending machine keeps track on how many items are refilled and fills up the stock in the first empty spot.
        //as soon as the products the user wants to refill are refilled the method stops, for this a helper counter called filled is initialized
        else{
            int filled = 0;
            //go through every product in stock, if the slot in stock is empty, fill it with the desired snack
            //only fill the stock with that many products as the user gave to the Compartment.
            //As soon all products are refilled, stop the method (break)
            for (int i=0; i<stock.length; i++){
                if (filled >= amount){
                    break;
                }
                else if (stock[i] == null){
                    stock[i] =  new SoftDrink(filling);
                    filled++;
                }
            }
        }
    }

    //This method dispends a certain amount of a certain SoftDrink
    //if the amount of dispending is 0, then the list will be empty and no error occurs
    //to logic behind it, is to first check how many products we have on stock from this certain product
    //then check if we have enough products in stock, if not return the maximum products to the user, that we can get him
    //the logic is explained in more detail in the method
    public SoftDrink[] dispender(int amount, String name){
        //initally check how many soft drinks of the asked product are in stock
        int stockOfProduct = productCounter(name);
        //declare returnlist, that has to be filled in a later stage
        SoftDrink[] returnList;
        //if there are enough products in stock,
        // then create a returnList that is big enough to return the full users wish
        if (stockOfProduct >= amount){
            returnList = new SoftDrink[amount];
        }
        //if it is not big enough, return the maximum amount the vending machine has for this product
        // additionally amount, which the user putted gets updated to the nr of product she gets.
        //the users have to be informed that she does not get the full amount or no amount.
        //if we dont have any we can abort the method and just return the empty array
        else{
        //we have some products in stock
            if (stockOfProduct >0) {
                //inform the user
                System.out.println("Hey, we are sorry. We don't have " + amount + " " + name + " in Stock. \n" +
                        "But we can give you " + stockOfProduct);
                //update the amount that the user will get dispended
                amount = stockOfProduct;
                //initialize the return list with the new amount
                returnList = new SoftDrink[amount];
            }
        //we dont have any products in stock
            else {
                //infrom the user
                System.out.println("Hey, we are sorry. We don't have any " + name + " in Stock. \n");
                //set the return amount to 0
                amount = stockOfProduct;
                //initialize the return list with a length of 0 and stop the method
                returnList = new SoftDrink[amount];
                return returnList;
            }

        }

        //until now, the returnlist is only prepared and not filled
        //no products are dispended so far from the Snacks Compartment, this will change now

        //the returnList is prepared, now lets get the drinks out of the vending machine and
        // add them to the customers order = returnList
        //starting with a helping counter, to define the position in which the vending machine has to give out the drink.
        int counter = 0;
        //go through every product in stock
        for (int i = 0; i < stock.length; i++) {
            //if we got all the products we need, then we can exit the for loop and return the products to the user
            if (counter >= amount) {
                break;
            }
            //if it's the correct product add it to the users return and
            // delete it from the stock of the vending machine
            //additionally set the counter one up, since we returned one more item to the user.
            //first check if slot is empty, because if its empty we cannot check the name of the product
            else if (stock[i] != null) {
                if (stock[i].getName().equals(name)) {
                    returnList[counter] = stock[i];
                    counter++;
                    stock[i] = null;
                }
            }
        }
        //this returns the list of drinks the user ordered
        return returnList;
    }

    //this method returns exactly one soft drink with a desired name
    //for this the method simply calls the overloading method with the amount of 1
    //if there is a drink it will be returned as an array
    public SoftDrink[] dispender(String productName){
        return dispender(1, productName);
    }

}
