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
public class orderQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    
    public static void postOrder(int item, Float total, int qty) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        Statement postCustomer = connection.createStatement();

        String querys="INSERT INTO sswatl2db.Orders (idOrderItem, total, quantity)" + " VALUES ('" + item + "','" + total + "','" + qty + "')";
        
        System.out.println(querys);
        
        postCustomer.executeUpdate(querys);

    }  
    
    public static void deleteOrder(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteOrder = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Orders WHERE idOrder=" + id;
        deleteOrder.executeUpdate(querys);
    }
    
    public static void updateOrder(int id, int idOrderItem, float total, int quantity) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateOrder = connection.createStatement();
        String querys="UPDATE sswatl2db.Orders SET idOrderItem=" + idOrderItem + ", total=" + total + ", quantity=" + quantity + " WHERE idOrder=" + id;
        
        updateOrder.executeUpdate(querys);
    }
    
    public static ArrayList<Order> orderList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Order> orderList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement orders = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Orders";
        
        ResultSet rs;
        rs = orders.executeQuery(querys);
        
        Order order;
        
        while(rs.next()){
            
            order = new Order(rs.getInt("idOrder"), rs.getInt("idOrderItem"), rs.getFloat("total"), rs.getInt("quantity"));
            orderList.add(order);
        }
        
        return orderList;        
    }
    
    public static ArrayList<Item> getOrderItemList(int idOrder) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Item> itemList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement items = connection.createStatement();
        String querys="SELECT idItem, name, price "
                + "FROM sswatl2db.Orders o, sswatl2db.Item i "
                + "WHERE o.idOrderItem=i.idItem "
                + "AND o.idOrder=" + idOrder;
        
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
