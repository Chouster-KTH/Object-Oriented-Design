/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.integration;

import java.util.HashMap;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.utilities.Amount;

/**
 *
 * Represents a fake inventory system.
 */
public class InventorySystem
{

    private final HashMap<String, Item> inventoryList = new HashMap();

    /**
     * Creates a new instance of a fake inventory system.
     */
    public InventorySystem()
    {
        addItems();
    }

    /**
     * Removes sold items from the inventory.
     *
     * @param sale Information about the sale.
     */
    public void updateInventory(Sale sale)
    {
        HashMap<String, Item> items = sale.getSaleList();
        for (Item item : items.values())
        {

            if (itemExistsInInventory(item))
            {
                decreaseQuantityOfItem(item);
            }
        }
    }

    /**
     * Checks if the item exists in the inventory.
     *
     * @param itemIdentifier the identifier that is entered by the cashier.
     * @return True if the item is in the inventory.
     */
    public boolean itemExistsInInventory(String itemIdentifier)
    {
        return inventoryList.containsKey(itemIdentifier);
    }

    private void decreaseQuantityOfItem(Item item)
    {
        Item currentItem = inventoryList.get(item.getItemIdentifier());
        currentItem.decreaseQuantity(item.getQuantity());
        inventoryList.put(item.getItemIdentifier(), currentItem);
    }

    /**
     * Get an item.
     *
     * @param itemIdentifier The identifier that is entered by the cashier.
     * @param quantity The quantity of a specific item.
     * @return A new item object with the specified quantity.
     * @throws se.kth.iv1350.POS.integration.DatabaseFailureException when
     * identifier 000000 is called to simulate a database error.
     * @throws se.kth.iv1350.POS.integration.ItemNotValidException when the item
     * cannot be found in the inventory.
     */
    public Item getItem(String itemIdentifier, Amount quantity) throws ItemNotValidException, DatabaseFailureException
    {
        if (itemIdentifier.equals("000000"))
        {
            throw new DatabaseFailureException("Server is not responding");
        }
        if (itemExistsInInventory(itemIdentifier))
        {
            return new Item(inventoryList.get(itemIdentifier).getItemInformation(), itemIdentifier, quantity);
        }
        throw new ItemNotValidException(itemIdentifier);
    }

    private void addItems()
    {

        inventoryList.put("001023", new Item(new ItemDTO("Jacket", "Calvin Klein jacket size M", new Amount(1999), new Amount(25)), "Jacket", new Amount(10_000)));
        inventoryList.put("923845", new Item(new ItemDTO("Jeans", "Levis jeans size 31:30", new Amount(699), new Amount(25)), "Jeans", new Amount(10_000)));
        inventoryList.put("503405", new Item(new ItemDTO("Fragrance", "Versace 100 ml", new Amount(679), new Amount(25)), "Fragrance", new Amount(10_000)));
        inventoryList.put("000000", new Item(new ItemDTO("Birkin bag", "Hermés", new Amount(500_000), new Amount(25)), "Birkin bag", new Amount(10_000)));

    }

    /**
     * Get inventory list.
     *
     * @return Inventory list.
     */
    public HashMap<String, Item> getInventoryList()
    {
        return inventoryList;
    }

    /**
     * Checks if the item exists in the inventory.
     *
     * @param item The specified item.
     * @return True if the item is in the inventory.
     */
    public boolean itemExistsInInventory(Item item)
    {
        return inventoryList.containsKey(item.getItemIdentifier());

    }

}
