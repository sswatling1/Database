/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Scott
 */
public class employQueries {
    private static final String userName="sswatl2";
    private static final String password="Cosc*kc9q";
    private static Connection connection=null;
    private static ResultSet rs = null;
    
    public static void postEmploy(int idEmpStore, int idEmpStaff) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement postEmploy = connection.createStatement();
        String querys="INSERT INTO sswatl2db.Employ (idEmpStore, idEmpStaff) VALUES ('" + idEmpStore + "','" + idEmpStaff + "')";
        
        postEmploy.executeUpdate(querys);

    }   
    
    public static void deleteEmploy(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
     
       connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement deleteEmploy = connection.createStatement();
        String querys="DELETE FROM sswatl2db.Employ WHERE idEmploy=" + id;
        deleteEmploy.executeUpdate(querys);
    }
    
    public static void updateEmploy(int id, int idEmpStore, int idEmpStaff) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement updateEmploy = connection.createStatement();
        String querys="UPDATE sswatl2db.Employ SET idEmpStore=" + idEmpStore + ", idEmpStaff=" + idEmpStaff + " WHERE idEmploy=" + id;
        
        updateEmploy.executeUpdate(querys);
    }
    
        
    public static ArrayList<Employ> employList() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{             
        
        ArrayList<Employ> employList = new ArrayList<>();
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/sswatl2db", userName, password);
        
        Statement employs = connection.createStatement();
        String querys="SELECT * FROM sswatl2db.Employ";
        
        ResultSet rs;
        rs = employs.executeQuery(querys);
        
        Employ employ;
        
        while(rs.next()){
            
            employ = new Employ(rs.getInt("idEmploy"), rs.getInt("idEmpStore"), rs.getInt("idEmpStaff"));
            employList.add(employ);
            
        }
        
        return employList;        
    }
}
