/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.nio.CharBuffer;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Represents necessary data of an item.
 */
public class ItemDTO
{

    private final String itemName;
    private final String itemDescription;
    private final Amount price;
    private final Amount VATrate;

    /**
     * Creates an instance of an itemDTO.
     *
     * @param itemName Name of the item
     * @param itemDescription A short description of the item
     * @param price Cost of the item
     * @param VATrate VAT tax rate for the specific item
     */
    public ItemDTO(String itemName, String itemDescription, Amount price, Amount VATrate)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
        this.VATrate = VATrate;
    }

    /**
     * Get the item description.
     *
     * @return Item description.
     */
    public String getDescription()
    {
        return itemDescription;
    }

    /**
     * Get price of an item.
     *
     * @return Item price.
     */
    public Amount getPrice()
    {
        return price;
    }

    /**
     * Get VAT rate of an item.
     *
     * @return VAT rate.
     */
    public Amount getVATrate()
    {
        return VATrate;
    }

    public String getName()
    {
        return itemName;
    }

    /**
     * Enables the instance to be written as <code>String</code>.
     *
     * @return A string builder of the instance with all attributes.
     */
    @Override
    public String toString()
    {
        String space = CharBuffer.allocate(50 - itemDescription.length()).toString().replace('\0', ' ');
        String builder;
        builder = "item name: " + itemName + "\t"
                + "description: " + itemDescription + space + "\t"
                + "price: " + price + "\t"
                + "VAT rate: " + VATrate + "%" + "\t";
        return builder;
    }

}
