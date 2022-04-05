/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import java.nio.CharBuffer;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import se.kth.iv1350.POS.integration.ExternalSystemCreator;
import se.kth.iv1350.POS.integration.Item;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Represents the receipt.
 */
public class Receipt
{

    /**
     * Creates a new receipt.
     *
     * @param externalCreator A reference to all external systems.
     * @param sale Holds necessary information about the sale.
     * @param paidAmount Amount paid by the customer.
     * @param change Amount to be given back to the customer as change.
     */
    public Receipt(ExternalSystemCreator externalCreator, Sale sale, Amount paidAmount, Amount change)
    {
        if (!change.isPositive())
        {
            return;
        }

        StoreInformation storeInformation = sale.getStoreInformation();
        externalCreator.getPrinter().printStringLn("\n----------------------------------------------------------------------");
        externalCreator.getPrinter().printStringLn("Print receipt\n");

        externalCreator.getPrinter().printStringLn("Time: " + sale.getSaleTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        externalCreator.getPrinter().printStringLn("Store: " + storeInformation.getStoreName() + "\nAddress: " + storeInformation.getStoreAddress() + "\n");

        String sp = CharBuffer.allocate(32).toString().replace('\0', ' ');
        externalCreator.getPrinter().printStringLn("Item name\t" + "Description\t" + sp + "Price\t" + "VATrate\t" + "Quantity\t" + "Total price\t" + "\tVAT");

        HashMap<String, Item> saleList = sale.getSaleList();

        for (Item item : saleList.values())
        {
            ItemDTO itemInformation = item.getItemInformation();
            String space = CharBuffer.allocate(40 - itemInformation.getDescription().length()).toString().replace('\0', ' ');
            TotalPrice totalPrice = new TotalPrice();
            totalPrice.updateTotal(item);

            externalCreator.getPrinter().printString(itemInformation.getName() + "   \t");
            externalCreator.getPrinter().printString(itemInformation.getDescription() + space + "\t");
            externalCreator.getPrinter().printString(itemInformation.getPrice() + "\t");
            externalCreator.getPrinter().printString(itemInformation.getVATrate() + "\t");
            externalCreator.getPrinter().printString(item.getQuantity() + "         \t");
            externalCreator.getPrinter().printString(totalPrice.getTotalIncludingVAT() + "           \t");
            externalCreator.getPrinter().printString(totalPrice.getTotalVAT() + "  \t");

            externalCreator.getPrinter().printString("\n");
        }

        externalCreator.getPrinter().printStringLn("\nTotal:                  \t\t\t\t\t " + sp + sale.getTotalPrice().getTotalIncludingVAT() + "         \t" + sale.getTotalPrice().getTotalVAT().toString() + "\n");
        externalCreator.getPrinter().printStringLn("\nCash from customer " + paidAmount);
        externalCreator.getPrinter().printStringLn("Change: " + change.toString());

        externalCreator.getPrinter().printStringLn("\nThank you for your purchase");
        externalCreator.getPrinter().printStringLn("Goodbye");

    }

}
