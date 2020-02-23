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
class Employ {
    int idEmploy;
    int idEmpStore;
    int idEmpStaff;

    public Employ(int idEmploy, int idEmpStore, int idEmpStaff) {
        this.idEmploy = idEmploy;
        this.idEmpStore = idEmpStore;
        this.idEmpStaff = idEmpStaff;
    }

    public int getIdEmploy() {
        return idEmploy;
    }

    public void setIdEmploy(int idEmploy) {
        this.idEmploy = idEmploy;
    }

    public int getIdEmpStore() {
        return idEmpStore;
    }

    public void setIdEmpStore(int idEmpStore) {
        this.idEmpStore = idEmpStore;
    }

    public int getIdEmpStaff() {
        return idEmpStaff;
    }

    public void setIdEmpStaff(int idEmpStaff) {
        this.idEmpStaff = idEmpStaff;
    }

    
    
}
