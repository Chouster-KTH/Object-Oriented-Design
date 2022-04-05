/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.RevenueObserver;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Calculates and shows the total revenue received from sales.
 */
public class TotalRevenueDisplay implements RevenueObserver
{

    private Amount totalRevenue;

    /**
     * Creates a new instance of a TotalRevenueDisplay.
     */
    public TotalRevenueDisplay()
    {
        this.totalRevenue = new Amount(0);
    }

    /**
     * Notifies observers when a sale has been completed and paid for.
     * @param paidAmount The amount received from previous sale.
     */
    @Override
    public void newPaidSale(Amount paidAmount)
    {
        totalRevenue = totalRevenue.plus(paidAmount);
        System.out.println("Total revenue: " + totalRevenue);

    }

}
