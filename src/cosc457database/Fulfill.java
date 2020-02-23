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
class Fulfill {
    int idFulfill;
    int ifFulStore;
    int idFulOrder;

    public Fulfill(int idFulfill, int ifFulStore, int idFulOrder) {
        this.idFulfill = idFulfill;
        this.ifFulStore = ifFulStore;
        this.idFulOrder = idFulOrder;
    }

    public int getIdFulfill() {
        return idFulfill;
    }

    public void setIdFulfill(int idFulfill) {
        this.idFulfill = idFulfill;
    }

    public int getIfFulStore() {
        return ifFulStore;
    }

    public void setIfFulStore(int ifFulStore) {
        this.ifFulStore = ifFulStore;
    }

    public int getIdFulOrder() {
        return idFulOrder;
    }

    public void setIdFulOrder(int idFulOrder) {
        this.idFulOrder = idFulOrder;
    }


    
}
