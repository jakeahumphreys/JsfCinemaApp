
package Gateways;
import DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class showingGateway {
    
    Gateway g = new Gateway();    
    public showingDTO get(int showingID){
       System.out.println("Beginning get");
       showingDTO showingdetails = null;       
       try{
            Connection conn = g.getCon();
            String sqlStr = "SELECT showings.showingID,showings.timeslot,films.filmID,films.title,films.bbfcAge,films.runtime, films.lead, screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location"
                    + " FROM showings JOIN films on Showings.filmID = films.filmID"
                    + " JOIN screens on showings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID"
                    + " WHERE showings.showingID = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setInt(1, showingID);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),rs.getString("bbfcAge"),rs.getString("runtime"),rs.getString("Lead"));
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("screenID"),cinema);
                showingdetails = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
       return showingdetails;   
    }
    
    public showingDTO getByFilmID(int filmID){
       System.out.println("Beginning get");
       showingDTO showingdetails = null;       
       try{
            Connection conn = g.getCon();
            String sqlStr = "SELECT showings.showingID,showings.timeslot,films.filmID,films.title,films.bbfcAge,films.runtime, films.lead, screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location"
                    + " FROM showings JOIN films on Showings.filmID = films.filmID"
                    + " JOIN screens on showings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID"
                    + " WHERE showings.filmID = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setInt(1, filmID);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),rs.getString("bbfcAge"),rs.getString("runtime"),rs.getString("Lead"));
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("screenID"),cinema);
                showingdetails = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
       return showingdetails;   
    }
    
//    public showingDTO getFilmFromShowing(int filmID){
//       System.out.println("Beginning get");
//       showingDTO showingdetails = null;
//       
//                
//       try{
//            Connection conn = g.getCon();
//            System.out.println("Getting resultset");
//            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM showings WHERE filmID = ? ");
//            stmt.setInt(1, filmID);
//
//            ResultSet rs = stmt.executeQuery();
//            System.out.println("Constructing DTO");
//            if (rs.next())
//            {
//                System.out.println("Constructing...");
//                showingdetails = new showingDTO(
//                        rs.getInt("SHOWINGID"),
//                        rs.getString("SCREENID"),
//                        rs.getInt("FILMID"),
//                        rs.getString("TIMESLOT"));    
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//            System.out.println("Showing DTO constructed.");
//            
//        }catch(SQLException sqle){
//            System.out.println(sqle);
//        }
//       return showingdetails;   
//    }
    
    public ArrayList<showingDTO> getAll(){
        ArrayList<showingDTO> allShowings = new ArrayList<>();
        try{
            Connection conn = g.getCon();
            String sqlStr = "SELECT showings.showingID,showings.timeslot,films.filmID,films.title,films.bbfcAge,films.runtime, films.lead, screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location"
                    + " FROM showings JOIN films on Showings.filmID = films.filmID"
                    + " JOIN screens on showings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),rs.getString("bbfcAge"),rs.getString("runtime"),rs.getString("Lead"));
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("screenID"),cinema);
                showingDTO showingdetails = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
                allShowings.add(showingdetails);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return allShowings;
    }    
    
    public boolean insert(showingDTO showing){
        System.out.println("inserting showing");
       //dont need userID anymore consider removing
       
      
        try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO SHOWINGS (screenid, filmid, timeslot) VALUES (?,?,?)");
            
            stmt.setString(1, showing.getScreen().getScreenID());
            stmt.setInt(2, showing.getFilm().getFilmID());
            stmt.setString(3, showing.getTimeslot());
         
            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    };
    
    
    public boolean delete(int showingID){
        System.out.println("deleting showing");
        try{
            Connection conn = g.getCon();
        
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SHOWINGS WHERE SHOWINGID=?");
            stmt.setInt(1, showingID);
            int rows = stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM bookings WHERE showingID=?");
            stmt.setInt(1, showingID);
            rows = stmt.executeUpdate();
            
            
            stmt.close();
            conn.close();
            
            
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    }
}
