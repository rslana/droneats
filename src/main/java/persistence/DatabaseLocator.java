/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

//import com.mysql.jdbc.Connection;
import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rslana
 */
public class DatabaseLocator {
    private static DatabaseLocator instance = new DatabaseLocator();
    public static DatabaseLocator getInstance(){
        return instance;
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/droneats?useUnicode=yes&characterEncoding=ISO-8859-1", Config.DB_NAME, Config.DB_PASS);
    }
}
