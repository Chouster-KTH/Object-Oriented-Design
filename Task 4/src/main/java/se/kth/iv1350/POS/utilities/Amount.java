/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.utilities;

/**
 * Represent various kinds of amounts.
 */
public class Amount
{

    private final double amount;

    /**
     * Creates an instance of an amount.
     *
     * @param amount The amount that is going to represent a new instance of
     * Amount.
     */
    public Amount(double amount)
    {
        this.amount = amount;
    }

    /**
     *
     * Get the value of amount.
     *
     * @return The value of amount.
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     * Subtracts the specified {@link Amount} from an instance of
     * {@link Amount}.
     *
     * @param other The specified <code>Amount</code> used to subtract
     *
     * @return The result from the subtraction.
     */
    public Amount minus(Amount other)
    {
        return new Amount(this.amount - other.amount);
    }

    /**
     * Adds a specified quantity to an instance of {@link Amount}.
     *
     * @param quantity The specified <code>Amount</code> that is added.
     *
     * @return The result from the addition.
     */
    public Amount plus(Amount quantity)
    {
        return new Amount(this.amount + quantity.amount);
    }

    /**
     * Multiplies the price of an item with an instance of {@link Amount}.
     *
     * @param itemPrice The specified price of an item.
     *
     * @return The result from the multiplication.
     */
    public Amount multiply(Amount itemPrice)
    {
        return new Amount(this.amount * itemPrice.amount);
    }

    /**
     * Changes a percentage {@link Amount} to decimal form.
     *
     * @param percent The specified percentage.
     *
     * @return The percentage in decimal form.
     */
    public Amount percent(Amount percent)
    {
        return new Amount(this.amount * percent.amount / 100);
    }

    /**
     * Checks if an amount is positive.
     *
     * @return true if the amount is positive.
     */
    public boolean isPositive()
    {
        return amount >= 0;
    }

    /**
     * CHanges an amount from a double to a string.
     *
     * @return a string representation of the Amount object.
     */
    @Override
    public String toString()
    {
        return Double.toString(amount);
    }

}
