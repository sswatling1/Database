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
public class hasInventoryQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postHasInventory(int idHasStore, int idHasItem, int quantity) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postHasInventory = connection.createStatement();
        String querys="INSERT INTO sswatl2db.HasInventory (idHasStore, idHasItem, quantity) VALUES ('" + idHasStore + "','" + idHasItem + "','" + quantity + "')";
        
        postHasInventory.executeUpdate(querys);

    }   
    
    public static void deleteHasInventory(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
     
       connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteHasInventory = connection.createStatement();
        String querys="DELETE FROM sswatl2db.HasInventory WHERE idHasInventory=" + id;
        deleteHasInventory.executeUpdate(querys);
    }
    
    public static void updateHasInventory(int id, int idHasStore, int idHasItem, int quantity) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateHasInventory = connection.createStatement();
        String querys="UPDATE sswatl2db.HasInventory SET idHasStore=" + idHasStore + ", idHasItem=" + idHasItem + ", quantity=" + quantity + " WHERE idHasInventory=" + id;
        
        updateHasInventory.executeUpdate(querys);
    }
        
    public static ArrayList<HasInventory> hasInventoryList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<HasInventory> hasInventoryList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement hasInventorys = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.HasInventory";
        
        ResultSet rs;
        rs = hasInventorys.executeQuery(querys);
        
        HasInventory hasInventory;
        
        while(rs.next()){
            
            hasInventory = new HasInventory(rs.getInt("idHasInventory"), rs.getInt("idHasStore"), rs.getInt("idHasItem"), rs.getInt("quantity"));
            hasInventoryList.add(hasInventory);
            
        }
        
        return hasInventoryList;        
    }
}
