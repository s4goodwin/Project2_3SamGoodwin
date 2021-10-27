import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.jar.Attributes;

public class BuisnessCustomer extends Customer {

    private double purchaseOrderBalance;

    public BuisnessCustomer(String Name, int ID,double purchaseOrderBalance) {
        super(Name, ID);
        this.purchaseOrderBalance=purchaseOrderBalance;
    }

    public double payOutstandingBalance(){
        var discountBalance =1000;
        var outstandingBalance=0;
        if (purchaseOrderBalance > discountBalance)
            return purchaseOrderBalance*.95;
        purchaseOrderBalance=outstandingBalance;
        return purchaseOrderBalance;
    }
    public void arrangeDelivery(){
        System.out.println(getName()+" , all deliveries must be from 9-5 Mon-Fri");
    }


    @Override
    public double payForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        System.out.println("This order is for "+getName()+" and will be payed with a purchase order");
        printTaxMenu();
        Scanner inputReader = new Scanner(System.in);
        var userChoice=inputReader.nextInt();
        double sum = 0;
        switch (userChoice){
            case 1:
                var genTax = purchaseOrderBalance*1.0625;
                return genTax;
            case 2:
                var foodTax=purchaseOrderBalance;
                return foodTax;
            case 3:
                if (purchaseOrderBalance<=175){
                    return purchaseOrderBalance;
                }
                else {
                    var clothingTaxGreaterThan= (purchaseOrderBalance - 175) * 1.0625;
                    return clothingTaxGreaterThan;
                }

            default:
                System.out.println("\n === Invalid ===");
        }
    }
    private void printTaxMenu(){
        System.out.println("======================");
        System.out.println("Please enter the item type for purchase: ");
        System.out.println("   [1] General Merchandise");
        System.out.println("   [2] Food");
        System.out.println("   [3] Clothing");
        System.out.println("======================");
        System.out.print("Enter the number of your choice:");
}


