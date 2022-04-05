/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

/**
 * This exception is thrown when an item cannot be found in the inventory
 * system.
 *
 */
public class ItemNotValidException extends Exception
{

    /**
     * Creates a new instance of <code>ItemNotValidException</code>.
     *
     * @param itemIdentifier The identifier of the invalid item.
     */
    public ItemNotValidException(String itemIdentifier)
    {
        super("Item with identifier " + itemIdentifier + " cannot be found.");
    }

}
