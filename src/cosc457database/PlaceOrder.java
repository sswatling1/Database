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
class PlaceOrder {
    int idPlaceOrder;
    int idPOOrder;
    int idPOCustomer;

    public PlaceOrder(int idPlaceOrder, int idOrder, int idCustomer) {
        this.idPlaceOrder = idPlaceOrder;
        this.idPOOrder = idOrder;
        this.idPOCustomer = idCustomer;
    }

    public int getIdPlaceOrder() {
        return idPlaceOrder;
    }

    public void setIdPlaceOrder(int idPlaceOrder) {
        this.idPlaceOrder = idPlaceOrder;
    }

    public int getIdPOOrder() {
        return idPOOrder;
    }

    public void setIdPOOrder(int idPOOrder) {
        this.idPOOrder = idPOOrder;
    }

    public int getIdPOCustomer() {
        return idPOCustomer;
    }

    public void setIdPOCustomer(int idPOCustomer) {
        this.idPOCustomer = idPOCustomer;
    }

    
    
}
