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
public class fulfillQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postFulfill(int idFulStore, int idFulOrder) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postFulfill = connection.createStatement();
        String querys="INSERT INTO sswatl2db.Fulfill (idFulStore, idFulOrder) VALUES ('" + idFulStore + "','" + idFulOrder + "')";
        
        postFulfill.executeUpdate(querys);

    }  
    
    public static void deleteFulfill(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
     
       connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteFulfill = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Fulfill WHERE idFulfill=" + id;
        deleteFulfill.executeUpdate(querys);
    }
    
    public static void updateFulfill(int id, int idStore, int idOrder) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateFulfill = connection.createStatement();
        String querys="UPDATE sswatl2db.Fulfill SET idFulStore=" + idStore + ", idFulOrder=" + idOrder + " WHERE idFulfill=" + id;
        
        updateFulfill.executeUpdate(querys);
    }
        
    public static ArrayList<Fulfill> fulfillList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Fulfill> fulfillList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement fulfills = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Fulfill";
        
        ResultSet rs;
        rs = fulfills.executeQuery(querys);
        
        Fulfill fulfill;
        
        while(rs.next()){
            
            fulfill = new Fulfill(rs.getInt("idFulfill"), rs.getInt("idFulStore"), rs.getInt("idFulOrder"));
            fulfillList.add(fulfill);
            
        }
        
        return fulfillList;        
    }
}
