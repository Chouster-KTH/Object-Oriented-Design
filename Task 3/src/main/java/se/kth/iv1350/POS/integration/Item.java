/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Represents an item in the inventory system.
 */
public class Item
{

    private final ItemDTO itemInformation;
    private final String itemIdentifier;
    private Amount quantity;

    /**
     * Creates a new instance of an item.
     *
     * @param itemInformation Name, description, price and VAT rate.
     * @param itemIdentifier Identifier used to search for the specific item.
     * @param quantity The quantity of an item.
     */
    public Item(ItemDTO itemInformation, String itemIdentifier, Amount quantity)
    {
        this.itemInformation = itemInformation;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
    }

    /**
     * Decreases the quantity of items with the another {@link Amount}.
     *
     * @param anotherQuantity The {@link Amount} that will be subtracted from
     * the quantity.
     */
    public void decreaseQuantity(Amount anotherQuantity)
    {
        this.quantity = this.quantity.minus(anotherQuantity);
    }

    /**
     * Get quantity of an item.
     *
     * @return The quantity of the item.
     */
    public Amount getQuantity()
    {
        return quantity;
    }

    /**
     * Get itemInformation.
     *
     * @return itemInformation, i.e. name, description, price and VAT rate.
     */
    public ItemDTO getItemInformation()
    {
        return itemInformation;
    }

    /**
     * Get the itemIdentifier for a specific item.
     *
     * @return The itemIdentifier.
     */
    public String getItemIdentifier()
    {
        return itemIdentifier;
    }

    /**
     * Increases the quantity of an item.
     *
     * @param quantity The new quantity.
     */
    public void increaseQuantity(Amount quantity)
    {
        this.quantity = this.quantity.plus(quantity);
    }
}
