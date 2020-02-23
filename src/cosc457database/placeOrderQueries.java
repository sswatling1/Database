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
public class placeOrderQueries {        
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postPlaceOrder(int idPOOrder, int idPOCustomer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postPlaceOrder = connection.createStatement();
        String querys="INSERT INTO sswatl2db.PlaceOrder (idPOOrder, idPOCustomer) VALUES ('" + idPOOrder + "','" + idPOCustomer + "')";
        
        postPlaceOrder.executeUpdate(querys);

    }   
    
    public static void deletePlaceOrder(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
     
       connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deletePlaceOrder = connection.createStatement();
        String querys="DELETE FROM sswatl2db.PlaceOrder WHERE idPlaceOrder=" + id;
        deletePlaceOrder.executeUpdate(querys);
    }
    
    public static void updatePlaceOrder(int id, int idPOOrder, int idPOCustomer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updatePlaceOrder = connection.createStatement();
        String querys="UPDATE sswatl2db.PlaceOrder SET idPOOrder=" + idPOOrder + ", idPOCustomer=" + idPOCustomer + " WHERE idPlaceOrder=" + id;
        
        updatePlaceOrder.executeUpdate(querys);
    }
        
    public static ArrayList<PlaceOrder> placeOrderList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<PlaceOrder> placeOrderList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement placeOrders = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.PlaceOrder";
        
        ResultSet rs;
        rs = placeOrders.executeQuery(querys);
        
        PlaceOrder placeOrder;
        
        while(rs.next()){
            
            placeOrder = new PlaceOrder(rs.getInt("idPlaceOrder"), rs.getInt("idPOOrder"), rs.getInt("idPOCustomer"));
            placeOrderList.add(placeOrder);
            
        }
        
        return placeOrderList;        
    }
}
