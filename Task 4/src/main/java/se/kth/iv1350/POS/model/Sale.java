/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import se.kth.iv1350.POS.integration.DatabaseFailureException;
import se.kth.iv1350.POS.integration.ExternalSystemCreator;
import se.kth.iv1350.POS.integration.Item;
import se.kth.iv1350.POS.integration.ItemNotValidException;
import se.kth.iv1350.POS.utilities.Amount;

/**
 * Represents a sale between a customer and a cashier.
 */
public class Sale
{

    private final TotalPrice totalPrice;
    private final ExternalSystemCreator externalSystemCreator;
    private final HashMap<String, Item> saleList = new HashMap<>();
    private final LocalDateTime startSaleTime;
    private final StoreInformation storeInformation;
    private final List<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Creates a new instance of a sale.
     *
     * @param externalSystemCreator A reference to all external systems.
     * @param storeInformation Contains name and address of the store.
     */
    public Sale(ExternalSystemCreator externalSystemCreator, StoreInformation storeInformation)
    {
        this.totalPrice = new TotalPrice();
        this.externalSystemCreator = externalSystemCreator;
        this.storeInformation = storeInformation;
        startSaleTime = LocalDateTime.now();
    }

    /**
     * Searches for item in sale list.
     *
     * @param itemIdentifier Identifier used to identify each item.
     * @param quantity Specified quantity of an item.
     */
    public void scan(String itemIdentifier, Amount quantity)
    {

        if (itemExistsInSaleList(itemIdentifier))
        {
            Item item = getItem(itemIdentifier, quantity);
            updateSale(item);
        } else

        {
            try
            {
                Item item = externalSystemCreator.getInventorySystem().getItem(itemIdentifier, quantity);
                addItemToSale(item);
            } catch (ItemNotValidException ex)
            {
                externalSystemCreator.getDisplay().displayExceptionToUser(ex.getMessage());

            } catch (DatabaseFailureException exception)
            {
                externalSystemCreator.getDisplay().displayExceptionToUser(exception.getMessage());
                externalSystemCreator.getErrorLog().addToLog(exception.getMessage());
            }
        }

    }

    /**
     * Ends a sale. Sends total price to the display.
     */
    public void endSale()
    {
        externalSystemCreator.getDisplay().showTotalPriceOnDisplay(totalPrice);
    }

    /**
     * Creates a hash map with a list of all items in current sale.
     *
     * @return A list of all items in sale.
     */
    public HashMap<String, Item> getSaleList()
    {
        return saleList;
    }

    /**
     * Get the total price for a sale.
     *
     * @return Total price
     */
    public TotalPrice getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Set time of the sale.
     *
     * @return Time of the sale
     */
    public LocalDateTime getSaleTime()
    {
        return startSaleTime;
    }

    public ExternalSystemCreator getExternalSystemCreator()
    {
        return externalSystemCreator;
    }

    /**
     * Creates a payment and ends sale. Accounting and Inventory are updated and
     * observers are notified.
     *
     * @param paidAmount Amount to be paid by the customer.
     * @param cashRegister A reference to CashRegister
     * @return change to be given to the customer.
     */
    public Amount finalizePayment(Amount paidAmount, CashRegister cashRegister)
    {
        Payment cashPayment = new Payment(paidAmount);
        Amount change = cashRegister.addPayment(getTotalPrice(), cashPayment);
        if (change.isPositive())
        {
            externalSystemCreator.getInventorySystem().updateInventory(this);
            externalSystemCreator.getAccounting().updateAccountingSystem(this);
            notifyObserversOfPayment(paidAmount);
        } else
        {
            cancelSale();
        }

        return change;

    }

    /**
     * Get the value of store information.
     *
     * @return The value of store information.
     */
    public StoreInformation getStoreInformation()
    {
        return storeInformation;
    }

    /**
     * Adds item to sale.
     *
     * @param item The item that is being added to the sale.
     */
    public void addItemToSale(Item item)
    {
        addItemAndUpdateTotal(item);
        externalSystemCreator.getDisplay().displayItemInformationAndPrice(item, totalPrice);
    }

    private void addRevenueObserver(RevenueObserver observer)
    {
        revenueObservers.add(observer);
    }

    /**
     * Copies the observer list from Controller class to Sale class.
     *
     * @param observers List of observers that will be added to the list.
     */
    public void addListOfRevenueObservers(List<RevenueObserver> observers)
    {
        for (RevenueObserver observer : observers)
        {
            addRevenueObserver(observer);
        }
    }

    private void notifyObserversOfPayment(Amount paidAmount)
    {
        for (RevenueObserver observer : revenueObservers)
        {
            observer.newPaidSale(paidAmount);
        }
    }

    private void cancelSale()
    {
        externalSystemCreator.getDisplay().showCancellationMessage();
    }

    private void updateSale(Item item)
    {
        updateItemQuantityAndTotal(item);
        externalSystemCreator.getDisplay().displayItemInformationAndPrice(item, totalPrice);
    }

    private boolean itemExistsInSaleList(String itemIdentifier)
    {
        return saleList.containsKey(itemIdentifier);
    }

    private void updateItemQuantityAndTotal(Item item)
    {
        Item existingItem = saleList.get(item.getItemIdentifier());
        existingItem.increaseQuantity(item.getQuantity());
        saleList.put(existingItem.getItemIdentifier(), existingItem);
        totalPrice.updateTotal(item);
    }

    private void addItemAndUpdateTotal(Item addedItem)
    {
        saleList.put(addedItem.getItemIdentifier(), addedItem);
        totalPrice.updateTotal(addedItem);

    }

    private Item getItem(String itemIdentifier, Amount quantity)
    {
        return new Item(saleList.get(itemIdentifier).getItemInformation(), itemIdentifier, quantity);

    }

}
