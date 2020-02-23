/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc457database;
import java.sql.*;
import javax.swing.JFrame;
/**
 *
 * @author S
 */
public class StoreDatabase extends JFrame {
    static final String userName="sswatl2";//put your MySQL user name
    static final String password="Cosc*kc9q";//put your MySQL password
    private static Connection connection=null;
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        // First possibility
        DatabaseGUI mf = new DatabaseGUI();
        mf.setVisible(true);
        
    }    
}
