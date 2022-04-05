/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.utilities.Amount;

public class InventorySystemTest
{

    @Test
    public void testGetItem() throws Exception
    {

        InventorySystem instance = new InventorySystem();
        HashMap<String, Item> inventoryList = new HashMap();
        inventoryList.put("some identifier", new Item(new ItemDTO("some item", "some description", new Amount(1), new Amount(1)), "some item", new Amount(1)));
        String invalidIdentifier = "invalid identifier";
        try
        {
            Item testItem = instance.getItem(invalidIdentifier, new Amount(1));
            fail("Method did not throw exception!");
        } catch (ItemNotValidException ex)
        {
            assertEquals(ex.getMessage(), "Item with identifier " + invalidIdentifier + " cannot be found.");
        }

    }

    @Test
    public void testGetItem2() throws Exception
    {
        String itemIdentifier = "000000";

        try
        {
            if (itemIdentifier.equals("000000"))
            {
                throw new DatabaseFailureException("Server is not responding");
            } else
            {
                fail("Method did not throw exception!");
            }

        } catch (DatabaseFailureException ex)
        {
            assertEquals(ex.getMessage(), "Database problem. ERROR: Server is not responding.");
        }

    }

}
