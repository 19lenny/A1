//this class defines the product Snack
//when a Snack is produced, its name is saved in a private field variable
//the Snack name can be retrieved by a get method
public class Snack {

    //this field variable stores the name of the Snack.
    private String name;

    //this is the constructor of the Snack class
    // in the constructor a Snack receives a name
    public Snack(String product)
    {
        name = product;
    }

    //This method returns the name of the field variable
    public String getName() {
        return name;
    }
}
