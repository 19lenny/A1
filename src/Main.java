import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SoftDrinksCompartment lager = new SoftDrinksCompartment();

        lager.refill(3, "Cola");
        lager.refill(2, "Tea");

        System.out.println(lager.stockCounter()); //5
        System.out.println(lager.productCounter("Cola")); //3

        lager.refill(1, "Cola");

        System.out.println(lager.stockCounter()); //6
        System.out.println(lager.productCounter("Cola")); //4

        lager.dispender(2, "Cola");
        System.out.println(lager.stockCounter()); //4
        System.out.println(lager.productCounter("Cola")); //2

        lager.dispender("Cola");
        System.out.println(lager.stockCounter()); //3
        System.out.println(lager.productCounter("Cola")); //1

        lager.dispender("Cola");
        System.out.println(lager.stockCounter()); //2
        System.out.println(lager.productCounter("Cola")); //0

        lager.dispender("Cola");
        System.out.println(lager.stockCounter()); //2
        System.out.println(lager.productCounter("Cola")); //0

        lager.dispender(7,"Tea");
        System.out.println(lager.stockCounter()); //0
        System.out.println(lager.productCounter("Tea")); //0

    }
}