/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.StoreInformation;
import se.kth.iv1350.POS.utilities.Amount;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Daniel Chouster
 */
public class InventorySystemTest
{

    InventorySystem inventory;
    Item item;
    StoreInformation storeInformation;
    ExternalSystemCreator externalCreator;

    public InventorySystemTest()
    {
        inventory = new InventorySystem();
        item = new Item(new ItemDTO("Jacket", "Calvin Klein jacket size M", new Amount(1999), new Amount(25)), "001023", new Amount(2));
        storeInformation = new StoreInformation("Exclusive Boutique", "Baker Street 221B");
        externalCreator = new ExternalSystemCreator();
    }

    /**
     * Test of updateInventory method, of class InventorySystem.
     */
    @Test
    public void testUpdateInventory()
    {
        System.out.println("updateInventory");
        Sale sale = new Sale(externalCreator, storeInformation);
        sale.addItemToSale(item);

        inventory.updateInventory(sale);
        HashMap<String, Item> inventoryMap = inventory.getInventoryList();
        Item newItem = inventoryMap.get(item.getItemIdentifier());
        assertEquals(newItem.getQuantity().getAmount(), 10_000 - 2);
    }

    /**
     * Test of itemExistsInInventory method, of class InventorySystem.
     */
    @Test
    public void testItemExistsInInventory_Item()
    {
        System.out.println("itemExistsInInventory");
        boolean expResult = true;
        boolean result = inventory.itemExistsInInventory(item);
        assertEquals(expResult, result);

        Item item1 = new Item(null, "000000", new Amount(0));
        expResult = false;
        result = inventory.itemExistsInInventory(item1);
        assertEquals(expResult, result);
    }

    /**
     * Test of itemExistsInInventory method, of class InventorySystem.
     */
    @Test
    public void testItemExistsInInventory_String()
    {
        System.out.println("itemExistsInInventory");
        boolean expResult = true;
        boolean result = inventory.itemExistsInInventory("001023");
        assertEquals(expResult, result);
        expResult = false;
        result = inventory.itemExistsInInventory("000000");
        assertEquals(expResult, result);

    }

    /**
     * Test of getItem method, of class InventorySystem.
     */
    @Test
    public void testGetItem()
    {
        System.out.println("getItem");
        String itemIdentifier = "001023";
        Amount quantity = new Amount(2);
        Item expResult = item;
        Item result = inventory.getItem(itemIdentifier, quantity);
        assertEquals(expResult.getQuantity().getAmount(), result.getQuantity().getAmount());
        assertEquals(expResult.getItemIdentifier(), result.getItemIdentifier());
    }

}
