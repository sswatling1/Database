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
class Manage {
    int idManage;
    int idManStaff;
    int idManStore;

    public Manage(int idManage, int idManStaff, int idManStore) {
        this.idManage = idManage;
        this.idManStaff = idManStaff;
        this.idManStore = idManStore;
    }

    public int getIdManage() {
        return idManage;
    }

    public void setIdManage(int idManage) {
        this.idManage = idManage;
    }

    public int getIdManStaff() {
        return idManStaff;
    }

    public void setIdManStaff(int idManStaff) {
        this.idManStaff = idManStaff;
    }

    public int getIdManStore() {
        return idManStore;
    }

    public void setIdManStore(int idManStore) {
        this.idManStore = idManStore;
    }

   
    
}
