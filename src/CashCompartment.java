import java.util.*;
public class CashCompartment {
    //this private field variable stores the total amount of cash received from purchases
    private double cashBalance;
    // Create an ArrayList object, which stores the individual purchase payments
    // initialize it empty
    private ArrayList<Double> paymentList = new ArrayList<Double>();

    //no constructor needed

    //this method returns the current cash balance of the CashCompartment
    public double getCashBalance() {
        return cashBalance;
    }

    //this method can receive payments
    //the payment is added to the cash balance field variable and
    //the payment is added to the payment list (accounting)
    public void receivePayments(double cashBalance) {
        this.cashBalance += cashBalance;
        this.paymentList.add(cashBalance);
    }

    //This method searches for a payment on a specific index
    //If the method finds a value it returns the value
    //If not it returns 0.0
    public double accountingReceipt(int index){
        //only smaller if it would be smaller or equal than there would be a chance for a zero pointer
        if (index < paymentList.size()){
            return paymentList.get(index);
        }
        else {
            System.out.println("Sorry, no value on this index");
            return 0.0;
        }
    }
}
