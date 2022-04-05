/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.ExternalSystemCreator;
import se.kth.iv1350.POS.utilities.Amount;

/**
 * Represents a cash register.
 *
 */
public class CashRegister
{

    private final Amount cashBalance;
    private final ExternalSystemCreator externalCreator;

    /**
     * Initializes the cash register.
     *
     * @param cashBalance The amount of money in the cash register.
     * @param externalCreator A reference to all external systems.
     */
    public CashRegister(Amount cashBalance, ExternalSystemCreator externalCreator)
    {
        this.cashBalance = cashBalance;
        this.externalCreator = externalCreator;
    }

    /**
     * Adds paid cash to the cash register. Sends necessary to Display.
     *
     * @param totalPrice Final price that the customer is supposed to pay.
     * @param cashPayment Cash received from the customer.
     * @return change to be given to the customer.
     */
    public Amount addPayment(TotalPrice totalPrice, Payment cashPayment)
    {
        Amount change = cashPayment.getPayment().minus(totalPrice.getTotalIncludingVAT());
        externalCreator.getDisplay().displayChange(change);
        cashBalance.plus(totalPrice.getTotalIncludingVAT());
        return change;
    }

}
