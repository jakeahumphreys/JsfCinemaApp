
package Gateways;
import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author h024470h
 */
public class Gateway
{
    public Connection getCon(){
        
        try
            {
                DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                return DriverManager.getConnection("jdbc:derby://localhost:1527/cdata", "root", "admin");
                
                
            }
            catch (SQLException sqle)
            {
                return null;
            }
        
    }
        
}
