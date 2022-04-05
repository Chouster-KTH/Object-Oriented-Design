/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.RevenueObserver;
import se.kth.iv1350.POS.utilities.Amount;
import se.kth.iv1350.POS.utilities.FileLogger;

/**
 * Calculates total revenue and prints it to a file.
 *   
 */
public class TotalRevenueFileOutput implements RevenueObserver
{
 
    private final FileLogger logger;
    private Amount totalRevenue;
    
    /**
     * Creates a new instance of a revenue file output.
     */
    public TotalRevenueFileOutput()
    {
        this.totalRevenue = new Amount(0);
        this.logger = new FileLogger();
    }

    /**
     * Updates and writes total revenue to a file.
     * @param paidAmount Amount paid from previous sale.
     */
    @Override
    public void newPaidSale(Amount paidAmount)
    {
        totalRevenue = totalRevenue.plus(paidAmount);
        logger.log("Total revenue: " + totalRevenue);
        
    }
    
}