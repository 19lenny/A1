import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SnacksCompartment lager = new SnacksCompartment();

        lager.refill(3, "Nuts");
        lager.refill(2, "Chips");

        System.out.println(lager.stockCounter()); //5
        System.out.println(lager.productCounter("Nuts")); //3

        lager.refill(1, "Nuts");

        System.out.println(lager.stockCounter()); //6
        System.out.println(lager.productCounter("Nuts")); //4

        lager.dispender(2, "Nuts");
        System.out.println(lager.stockCounter()); //4
        System.out.println(lager.productCounter("Nuts")); //2

        lager.dispender("Nuts");
        System.out.println(lager.stockCounter()); //3
        System.out.println(lager.productCounter("Nuts")); //1

        lager.dispender("Nuts");
        System.out.println(lager.stockCounter()); //2
        System.out.println(lager.productCounter("Nuts")); //0

        lager.dispender("Nuts");
        System.out.println(lager.stockCounter()); //2
        System.out.println(lager.productCounter("Nuts")); //0

        lager.dispender(7,"Chips");
        System.out.println(lager.stockCounter()); //0
        System.out.println(lager.productCounter("Chips")); //0

    }
}