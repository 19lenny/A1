import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Snack x = new Snack("Chips");
        String y = x.getName();
        System.out.println(y);

        SoftDrink z = new SoftDrink("Coke");
        y = z.getName();
        System.out.println(y);

        SoftDrinksCompartment lager = new SoftDrinksCompartment();
        System.out.println(Arrays.toString(lager.getStock()));
        int c = lager.stockCounter();
        System.out.println(c);
        SoftDrinksCompartment lager2 = new SoftDrinksCompartment(3);
        System.out.println(Arrays.toString(lager2.getStock()));
        String str = "test";
        str = str.toUpperCase();
        System.out.println(str);
    }
}