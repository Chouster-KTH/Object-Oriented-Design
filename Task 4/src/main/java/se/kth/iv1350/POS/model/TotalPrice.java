/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.Item;
import se.kth.iv1350.POS.utilities.Amount;

/**
 * Represents the total amount to be paid for a sale.
 */
public class TotalPrice
{

    private Amount totalPrice;
    private Amount totalVAT;

    /**
     * Creates a new instance, representing the total price.
     */
    public TotalPrice()
    {
        this.totalPrice = new Amount(0);
        this.totalVAT = new Amount(0);
    }

    /**
     * Get total price.
     *
     * @return The value of total price.
     */
    public Amount getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Get total VAT.
     *
     * @return The total VAT.
     */
    public Amount getTotalVAT()
    {
        return totalVAT;
    }

    /**
     * Add VAT to the total price and return new {@link Amount}.
     *
     * @return The total price including VAT.
     */
    public Amount getTotalIncludingVAT()
    {
        return totalPrice.plus(totalVAT);
    }

    /**
     * Update total price and total VAT.
     *
     * @param item The item that is added to the sale.
     */
    public void updateTotal(Item item)
    {
        if (item == null)
        {
            return;
        }
        Amount amountOfItems = item.getQuantity();
        Amount itemPrice = item.getItemInformation().getPrice();
        Amount itemVATrate = item.getItemInformation().getVATrate();
        Amount itemTax = itemPrice.percent(itemVATrate);

        this.totalVAT = this.totalVAT.plus(amountOfItems.multiply(itemTax));
        this.totalPrice = this.totalPrice.plus(amountOfItems.multiply(itemPrice));
    }

}
