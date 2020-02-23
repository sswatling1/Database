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
public class itemQueries {
    
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    
    public static void postItem(String name, Float price) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        Statement postCustomer = connection.createStatement();

        String querys="INSERT INTO sswatl2db.Item (name, price)" + " VALUES ('" + name + "','" + price + "')";
        
        postCustomer.executeUpdate(querys);

    }
    
    public static void deleteItem(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteItem = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Item WHERE idItem=" + id;
        deleteItem.executeUpdate(querys);
    }
    
    public static void updateItem(int id, String name, float price) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateItem = connection.createStatement();
        String querys="UPDATE sswatl2db.Item SET name=" + '"'+ name +'"'+ ", price=" + price + " WHERE idItem=" + id;
        
        updateItem.executeUpdate(querys);
    }
    
    public static Float getItemPrice(int itemID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        float price;

        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        Statement items = connection.createStatement();

        String querys="SELECT price FROM sswatl2db.Item WHERE idItem=" + itemID;

        ResultSet rs;
        rs = items.executeQuery(querys);
        
        if(rs.next())
        {
            price = rs.getFloat("price");
        }
        else
        {
            price = 0;
        }       
        
        return price;
    }
    
    public static ArrayList<Item> itemList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Item> itemList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement items = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Item";
        
        ResultSet rs;
        rs = items.executeQuery(querys);
        
        Item item;
        
        while(rs.next()){
            item = new Item(rs.getInt("idItem"), rs.getString("name"), rs.getFloat("price"));
            
            itemList.add(item);
        }
        
        return itemList;        
    }
}
