//this class defines the product SoftDrink
//when a SoftDrink is produced, its name is saved in a private field variable
//the SoftDrink name can be retrieved by a get method
public class SoftDrink {

    //this field variable stores the name of the SoftDrink.
    private String name;

    //this is the constructor of the SoftDrink class
    //in the constructor a SoftDrink can receive a name
    public SoftDrink(String product)
    {
        name = product;
    }

    //This method returns the name of the field variable
    public String getName() {
        return name;
    }
}
