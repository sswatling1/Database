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
public class customerQueries {
    
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    
    public static void postCustomer(String fName, String mName, String lName, String shipAddr, String billAddr) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        Statement postCustomer = connection.createStatement();

        String querys="INSERT INTO sswatl2db.Customer (fName, mName, lName, shipAddr, billAddr)" + " VALUES ('" + fName + "','" + mName + "','" + lName + "','" + shipAddr + "','" + billAddr + "')";
        
        postCustomer.executeUpdate(querys);

    }   
    
    public static void deleteCustomer(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteCustomer = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Customer WHERE idCustomer=" + id;
        deleteCustomer.executeUpdate(querys);
    }
    
    public static void updateCustomer(int id, String fName, String mName, String lName, String billAddr, String shipAddr) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateCustomer = connection.createStatement();
        String querys="UPDATE sswatl2db.Customer SET fName=" +'"'+ fName +'"'+ ", mName=" +'"'+ mName +'"'+ ", lName=" +'"'+ lName +'"'+ ", billAddr=" +'"'+ billAddr +'"'+ ", shipAddr=" +'"'+ shipAddr +'"'+ " WHERE idCustomer=" + id;
        
        updateCustomer.executeUpdate(querys);
    }
    
    public static ArrayList<Customer> customerList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Customer> customerList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement customers = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Customer";
        
        ResultSet rs;
        rs = customers.executeQuery(querys);
        
        Customer customer;
        
        while(rs.next()){
            
            customer = new Customer(rs.getInt("idCustomer"), rs.getString("fname"), rs.getString("mName"), rs.getString("lName"), rs.getString("billAddr"), rs.getString("shipAddr"));
            customerList.add(customer);
        }
        
        return customerList;        
    }

    static ArrayList<Order> getCustomerOrderList(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        ArrayList<Order> customerOrderList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement customers = connection.createStatement();
        String querys="SELECT idOrder, idOrderItem, total, quantity "
                + "FROM sswatl2db.Orders o, sswatl2db.PlaceOrder p "
                + "WHERE o.idOrder=p.idPOOrder "
                + "AND idPOCustomer=" + id;
        
        ResultSet rs;
        rs = customers.executeQuery(querys);
        
        Order order;
        
        while(rs.next()){
            
            order = new Order(rs.getInt("idOrder"), rs.getInt("idOrderItem"), rs.getFloat("total"), rs.getInt("quantity"));
            customerOrderList.add(order);
        }
        
        return customerOrderList; 
    }
}
