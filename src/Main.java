import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CashCompartment lager = new CashCompartment();
        lager.receivePayments(100);
        lager.receivePayments(1000);
        lager.receivePayments(600);
        System.out.println(lager.getCashBalance());
        System.out.println(lager.accountingReceipt(0));
        System.out.println(lager.accountingReceipt(1));
        System.out.println(lager.accountingReceipt(2));
        lager.accountingReceipt(3);
    }
}