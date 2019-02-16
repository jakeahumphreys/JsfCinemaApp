
package Gateways;
import DTO.cinemaDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class cinemaGateway {
    Gateway g = new Gateway();
        
    public cinemaDTO get(int cinemaID){
       System.out.println("Beginning get");
       cinemaDTO cinemadetails = null;
       
                
       try{
            Connection conn = g.getCon();
            System.out.println("Getting resultset");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cinemas WHERE cinemaID = ? ");
            stmt.setInt(1, cinemaID);

            ResultSet rs = stmt.executeQuery();
            System.out.println("Constructing DTO");
            if (rs.next())
            {
                System.out.println("Constructing...");
                cinemadetails = new cinemaDTO(
                        rs.getInt("cinemaID"),
                        rs.getString("NAME"),
                        rs.getString("LOCATION"));    
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Cinema DTO constructed.");
            
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
       return cinemadetails;   
    }
}
