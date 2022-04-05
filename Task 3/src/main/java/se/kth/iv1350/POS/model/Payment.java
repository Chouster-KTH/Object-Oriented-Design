/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Represents a payment between customer and cashier.
 */
public class Payment
{

    private final Amount payment;

    /**
     * Creates a new payment.
     *
     * @param payment
     */
    public Payment(Amount payment)
    {
        this.payment = payment;
    }

    /**
     * Get the amount received from the customer.
     *
     * @return amount paid.
     */
    public Amount getPayment()
    {
        return this.payment;
    }

}
