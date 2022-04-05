/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.POS.model;

/**
 *
 * A class that contains name and address of the store.
 */
public class StoreInformation
{

    private final String storeName;
    private final String storeAddress;

    /**
     * Initializing store information.
     *
     * @param storeName Name of the store.
     * @param storeAddress Address of the store.
     */
    public StoreInformation(String storeName, String storeAddress)
    {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
    }

    /**
     * Get store name.
     *
     * @return Name of the store.
     */
    public String getStoreName()
    {
        return storeName;
    }

    /**
     * Get address of the store.
     *
     * @return Address of the store.
     */
    public String getStoreAddress()
    {
        return storeAddress;
    }

}
