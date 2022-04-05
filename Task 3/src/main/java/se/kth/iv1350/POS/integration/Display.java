/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.time.format.DateTimeFormatter;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.StoreInformation;
import se.kth.iv1350.POS.model.TotalPrice;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * This class represents the display which is viewed as an external system.
 */
public class Display
{

    /**
     * Displays the total price.
     *
     * @param totalPrice Represents the total price.
     * @return Total price including VAT.
     */
    public String displayTotalPrice(TotalPrice totalPrice)
    {
        return totalPrice.getTotalIncludingVAT().toString();
    }

    /**
     * Used in addSale and updateSale methods in class Sale. Displays item
     * information and running total.
     *
     * @param item The item that has been added to the sale.
     * @param totalPrice The new running total after adding the new item.
     */
    public void displayItemInformationAndPrice(Item item, TotalPrice totalPrice)
    {
        System.out.println(item.getItemInformation().toString() + ", quantity: " + item.getQuantity() + ", running total: " + displayTotalPrice(totalPrice));
    }

    /**
     * Display the final price.
     *
     * @param totalPrice The final price to be paid by the customer.
     */
    public void showTotalPriceOnDisplay(TotalPrice totalPrice)
    {
        System.out.println("\nFinal price: " + displayTotalPrice(totalPrice) + " including VAT: " + totalPrice.getTotalVAT().toString() + "\n");
    }

    /**
     * Display the amount of change that the customer is to receive.
     *
     * @param change The amount of change given to the customer.
     */
    public void displayChange(Amount change)
    {
        System.out.println("Change: " + change.toString());
    }

    /**
     * Display a message that confirms a sale has been initiated.
     *
     * @param sale A new sale.
     */
    public void displayStartSale(Sale sale)
    {
        System.out.println("A new sale has been initiated\n" + sale.getSaleTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        StoreInformation storeInformation = sale.getStoreInformation();
        System.out.println("Store: " + storeInformation.getStoreName() + "\nAddress: " + storeInformation.getStoreAddress() + "\n");
        System.out.println("Scanning items... \n");
    }

    /**
     * Display the amount of cash that the customer has paid.
     *
     * @param amount The amount paid.
     */
    public void displayPayment(Amount amount)
    {
        System.out.println("Cash from customer " + amount);
    }

    /**
     * Display a cancellation message if not enough money has been paid.
     */
    public void showCancellationMessage()
    {
        System.out.println("Not enough money");

    }
}
