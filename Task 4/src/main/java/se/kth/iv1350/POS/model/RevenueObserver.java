/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Creates an interface for RevenueObserver.
 */
public interface RevenueObserver
{
    void newPaidSale(Amount amount);
}
