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
public class manageQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postManage(int idManStore, int idManStaff) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postManage = connection.createStatement();
        String querys="INSERT INTO sswatl2db.Manage (idManStaff, idManStore) VALUES ('" + idManStaff + "','" + idManStore + "')";
        
        postManage.executeUpdate(querys);

    } 
    
    public static void deleteManage(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
     
       connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteManage = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Manage WHERE idManage=" + id;
        deleteManage.executeUpdate(querys);
    }
    
    public static void updateManage(int id, int idManStore, int idManStaff) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateManage = connection.createStatement();
        String querys="UPDATE sswatl2db.Manage SET idManStore=" + idManStore + ", idManStaff=" + idManStaff + " WHERE idManage=" + id;
        
        updateManage.executeUpdate(querys);
    }
    
        
    public static ArrayList<Manage> manageList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Manage> manageList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement manages = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Manage";
        
        ResultSet rs;
        rs = manages.executeQuery(querys);
        
        Manage manage;
        
        while(rs.next()){
            
            manage = new Manage(rs.getInt("idManage"), rs.getInt("idManStaff"), rs.getInt("idManStore"));
            manageList.add(manage);
            
        }
        
        return manageList;        
    }
}
