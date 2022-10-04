public class SoftDrinksCompartment {

    //This field can store the capacity of the SoftDrinksCompartment
    private int capacity;

    //This field declares the array which stores the SoftDrinks in the SoftDrinksCompartment
    private SoftDrink [] stock;

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
    //The method takes a string as an input, which is the product that should be counted
    //For easier comparison and to avoid typing mistakes all Strings in this method are manipulated to uppercase letters
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

    public void refill(int amount, String filling){
        //calculate the remaining slots for SoftDrinks in our vending machine
        int remainingSlots = capacity - stockCounter();
        //If the refiller wants to put more SoftDrinks in the machine as remaining capacity, the method should stop
        if (remainingSlots < amount){
            System.out.println("Dear refiller, you tried to refill the vending machine with soft drinks. \n" +
                    "Unfortunately, there are only "+remainingSlots+ "left for soft drinks in the machine. \n" +
                    "You tried to put "+ amount+" drinks in the machine. \n" +
                    "Please try again, after removing some.");
        }
        //else: the refiller puts in a correct amount
        //the vending machine gets filled from the top
        //the first empty slot is filled with a new soft drink
        //the SoftDrink is created from the name the refiller gets us
        //the vending machine keeps track on how many items are refilled and fills up the stock in the first empty spot.
        else{
            int filled = 0;
            for (int i=0; i<stock.length; i++){
                if (stock[i] == null){
                    stock[i] =  new SoftDrink(filling);
                    filled++;
                }
            }
        }
    }

    //This method is a getter method for the field variable stock.
    //It returns the list of SoftDrinks that are in stock.
    public SoftDrink[] getStock() {
        return stock;
    }
}
