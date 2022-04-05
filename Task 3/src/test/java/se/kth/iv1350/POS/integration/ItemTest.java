/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * @author Daniel Chouster
 */
public class ItemTest
{

    /**
     * Test of decreaseQuantity method, of class Item.
     */
    @Test
    public void testDecreaseQuantity()
    {

        System.out.println("decreaseQuantity");
        Amount quantityRemoved = new Amount(1);
        Amount expectedResult = new Amount(0);
        Item instance = new Item(new ItemDTO("TestItem", "Not a real item", new Amount(1), new Amount(25)), "41099", new Amount(1));
        instance.decreaseQuantity(quantityRemoved);
        assertEquals(instance.getQuantity().getAmount(), expectedResult.getAmount());

    }

    /**
     * Test of getQuantity method, of class Item.
     */
    @Test
    public void testGetQuantity()
    {
        System.out.println("getQuantity");
        Item anItem = new Item(new ItemDTO("An item", "Not a real item", new Amount(1), new Amount(25)), "43152", new Amount(10_000));
        Amount expResult = new Amount(10_000);
        Amount result = anItem.getQuantity();
        assertEquals(expResult.getAmount(), result.getAmount());

    }

    /**
     * Test of getItemInformation method, of class Item.
     */
    @Test
    public void testGetItemInformation()
    {
        System.out.println("getItemInformation");
        ItemDTO expResult = new ItemDTO("itemTest", "Not a real item", new Amount(1), new Amount(25));
        Item myItem = new Item(expResult, "52351", new Amount(1));
        ItemDTO result = myItem.getItemInformation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getItemIdentifier method, of class Item.
     */
    @Test
    public void testGetItemIdentifier()
    {
        System.out.println("getItemIdentifier");
        Item itemTest = new Item(new ItemDTO("itemTest", "Not a real item", new Amount(1), new Amount(25)), "12345", new Amount(1));
        String expResult = "12345";
        String result = itemTest.getItemIdentifier();
        assertEquals(expResult, result);

    }

    /**
     * Test of increaseQuantity method, of class Item.
     */
    @Test
    public void testIncreaseQuantity()
    {
        System.out.println("increaseQuantity");
        Amount quantity = new Amount(1);
        Amount expectedResult = new Amount(1 + 1);
        Item instance = new Item(new ItemDTO("itemTest", "Not a real item", new Amount(1), new Amount(25)), "52366", new Amount(1));
        instance.increaseQuantity(quantity);
        assertEquals(instance.getQuantity().getAmount(), expectedResult.getAmount());

    }

}
