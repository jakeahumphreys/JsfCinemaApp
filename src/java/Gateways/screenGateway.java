
package Gateways;
import DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class screenGateway {
    
    Gateway g = new Gateway();
   
    public screenDTO get(String screenID){
       System.out.println("Beginning get"); 
       screenDTO screendetails = null;
       try{
            Connection conn = g.getCon();
            String sqlStr = "SELECT Screens.screenID, Cinemas.CinemaID,Cinemas.name, Cinemas.location"
                    + "FROM screens JOIN Cinemas on Screens.CinemaID = Cinemas.cinemaID"
                    + "WHERE Screens.screenID = ?";
                    
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setString(1,screenID);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                cinemaDTO cinema  = new cinemaDTO(rs.getInt("CinemaID"),rs.getString("name"), rs.getString("location"));
                screendetails = new screenDTO(rs.getString("ScreenID"), cinema);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
       return screendetails;   
    }
    
    public ArrayList<screenDTO> getAll(){
        ArrayList<screenDTO> allScreens = new ArrayList<>();
        try{
            Connection conn = g.getCon();
            String sqlStr = "SELECT Screens.screenID, Cinemas.CinemaID,Cinemas.name, Cinemas.location"
                    + " FROM screens JOIN Cinemas on Screens.CinemaID = Cinemas.cinemaID";
                    
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                cinemaDTO cinema  = new cinemaDTO(rs.getInt("CinemaID"),rs.getString("name"), rs.getString("location"));
                screenDTO screendetails = new screenDTO(rs.getString("ScreenID"), cinema);
                allScreens.add(screendetails);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return allScreens;    
    }
}
