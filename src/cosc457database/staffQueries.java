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
public class staffQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    
    public static void postStaff(String SSN, String fName, String mName, String lName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        Statement postCustomer = connection.createStatement();

        String querys="INSERT INTO sswatl2db.Staff (SSN, fName, mName, lName)" + " VALUES ('" + SSN + "','" + fName + "','" + mName + "','" + lName + "')";
        
        postCustomer.executeUpdate(querys);

    }   
   
    public static void updateStaff(int id, int SSN, String fName, String mName, String lName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateStaff = connection.createStatement();
        String querys="UPDATE sswatl2db.Staff SET SSN=" + SSN + ", fName=" + '"'+ fName +'"'+ ", mName=" + '"'+ mName +'"'+ ", lName=" + '"'+ lName +'"' + " WHERE idStaff=" + id;
        
        updateStaff.executeUpdate(querys);
    }
    
    public static void deleteStaff(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteStaff = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Staff WHERE idStaff=" + id;
        deleteStaff.executeUpdate(querys);
    }
    
        public static ArrayList<Staff> staffList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Staff> staffList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement staffs = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Staff";
        
        ResultSet rs;
        rs = staffs.executeQuery(querys);
        
        Staff staff;
        
        while(rs.next()){
            
            staff = new Staff(rs.getInt("idStaff"), rs.getInt("SSN"), rs.getString("fName"), rs.getString("mName"), rs.getString("lName"));
            
            staffList.add(staff);
        }
        
        return staffList;        
    }
}
