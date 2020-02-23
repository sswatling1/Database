/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457database;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Scott
 */

public class storeQueries {
        
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postStore(String sname, String saddress) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postCustomer = connection.createStatement();
        String querys="INSERT INTO sswatl2db.Store (name, address) VALUES ('" + sname + "','" + saddress + "')";
        postCustomer.executeUpdate(querys);
    }   
    
    public static void deleteStore(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteStore = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Store WHERE idStore=" + id;
        deleteStore.executeUpdate(querys);
    }
    
    public static void updateStore(int id, String sname, String saddress) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateStore = connection.createStatement();
        String querys="UPDATE sswatl2db.Store SET name=" + '"'+ sname +'"' + ", address=" + '"'+ saddress +'"' + " WHERE idStore=" + id;
        
        updateStore.executeUpdate(querys);
    }
    
        
    public static ArrayList<Store> storeList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Store> storeList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement stores = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Store";
        
        ResultSet rs;
        rs = stores.executeQuery(querys);
        
        Store store;
        
        while(rs.next()){
            
            store = new Store(rs.getInt("idStore"), rs.getString("name"), rs.getString("address"));
            storeList.add(store);
        }
        
        return storeList;        
    }
    
    public static ArrayList<Inventory> getStoreInventoryList(int idStore) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement staffs = connection.createStatement();
        String querys="SELECT idItem, i.name, price, quantity "
                + "FROM sswatl2db.Item i, sswatl2db.HasInventory h "
                + "WHERE i.idItem=h.idHasItem "
                + "AND h.idHasStore=" + idStore;
        
        ResultSet rs;
        rs = staffs.executeQuery(querys);
        
        Inventory inv;
        
        while(rs.next()){
            
            inv = new Inventory(rs.getInt("idItem"), rs.getString("name"), rs.getFloat("price"), rs.getInt("quantity"));
            inventoryList.add(inv);
            
        }
        
        return inventoryList;        
    }
    
    public static ArrayList<Staff> getStoreManagerList(int idManStore) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Staff> managerList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement staffs = connection.createStatement();
        String querys="SELECT idStaff, SSN, fName, mName, lName "
                + "FROM sswatl2db.Staff s, sswatl2db.Manage m "
                + "WHERE s.idStaff=m.idManStaff "
                + "AND m.idManStore=" + idManStore;
                
        ResultSet rs;
        rs = staffs.executeQuery(querys);
        
        Staff staff;
        
        while(rs.next()){
            
            staff = new Staff(rs.getInt("idStaff"), rs.getInt("SSN"), rs.getString("fName"), rs.getString("mName"), rs.getString("lName"));
            managerList.add(staff);
            
        }
        
        return managerList;        
    }
    
    public static ArrayList<Staff> getStoreStaffList(int idEmpStore) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Staff> staffList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement staffs = connection.createStatement();
        String querys="SELECT idStaff, SSN, fName, mName, lName "
                + "FROM sswatl2db.Staff s, sswatl2db.Employ e "
                + "WHERE s.idStaff=e.idEmpStaff "
                + "AND e.idEmpStore=" + idEmpStore;
                
        ResultSet rs;
        rs = staffs.executeQuery(querys);
        
        Staff staff;
        
        while(rs.next()){
            
            staff = new Staff(rs.getInt("idStaff"), rs.getInt("SSN"), rs.getString("fName"), rs.getString("mName"), rs.getString("lName"));
            staffList.add(staff);
            
        }
        
        return staffList;        
    }

    static ArrayList<Order> getStoreOrderList(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ArrayList<Order> orderList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement orders = connection.createStatement();
        String querys="SELECT idOrder, idOrderItem, total, quantity "
                + "FROM sswatl2db.Orders o, sswatl2db.Fulfill f "
                + "WHERE o.idOrder=f.idFulOrder "
                + "AND f.idFulStore=" + id;
        
        ResultSet rs;
        rs = orders.executeQuery(querys);
        
        Order order;
        
        while(rs.next()){
            
            order = new Order(rs.getInt("idOrder"), rs.getInt("idOrderItem"), rs.getFloat("total"), rs.getInt("quantity"));
            orderList.add(order);
        }
        
        return orderList;  
    }
}
