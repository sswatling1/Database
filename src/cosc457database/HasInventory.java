/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457database;

/**
 *
 * @author Scott
 */
class HasInventory {
    int idHasInventory;
    int idHasStore;
    int idHasItem;
    int quantity;

    public HasInventory(int idHasInventory, int idHasStore, int idHasItem, int quantity) {
        this.idHasInventory = idHasInventory;
        this.idHasStore = idHasStore;
        this.idHasItem = idHasItem;
        this.quantity = quantity;
    }

    public int getIdHasInventory() {
        return idHasInventory;
    }

    public void setIdHasInventory(int idHasInventory) {
        this.idHasInventory = idHasInventory;
    }

    public int getIdHasStore() {
        return idHasStore;
    }

    public void setIdHasStore(int idHasStore) {
        this.idHasStore = idHasStore;
    }

    public int getIdHasItem() {
        return idHasItem;
    }

    public void setIdHasItem(int idHasItem) {
        this.idHasItem = idHasItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    
}
