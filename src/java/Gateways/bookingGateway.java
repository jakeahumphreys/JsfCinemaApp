
package Gateways;
import DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class bookingGateway {
   
    Gateway g = new Gateway();
    
    public bookingDTO findBooking(String username){
        bookingDTO bookingdetails = null;
         try{
            Connection conn = g.getCon();
            String sqlStr="SELECT bookings.bookingID, showings.showingID, showings.timeslot,screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location,films.filmID,films.title,users.username"
                    + " FROM bookings JOIN users on bookings.username = users.username"
                    + " JOIN showings on bookings.showingID = showings.showingID"
                    + " JOIN films on films.filmID = showings.filmID "
                    + " JOIN screens on bookings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID"
                    + " WHERE bookings.username = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                userDTO user = new userDTO(rs.getString("username"),"","","","","","",null,false);
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),"","","");
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("ScreenID"),cinema);
                showingDTO showing = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
                bookingdetails = new bookingDTO(rs.getInt("bookingID"),user,showing,screen);
            }

            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
       return bookingdetails;
    }
    
    public bookingDTO findBookingByShowing(int showingID){
        bookingDTO bookingdetails = null;
         try{
            Connection conn = g.getCon();
            String sqlStr="SELECT bookings.bookingID, showings.showingID, showings.timeslot,screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location,films.filmID,films.title,users.username"
                    + " FROM bookings JOIN users on bookings.username = users.username"
                    + " JOIN showings on bookings.showingID = showings.showingID"
                    + " JOIN films on films.filmID = showings.filmID "
                    + " JOIN screens on bookings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID"
                    + " WHERE bookings.showingID = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setInt(1, showingID);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                userDTO user = new userDTO(rs.getString("username"),"","","","","","",null,false);
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),"","","");
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("ScreenID"),cinema);
                showingDTO showing = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
                bookingdetails = new bookingDTO(rs.getInt("bookingID"),user,showing,screen);
            }

            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
       return bookingdetails;
    }
    
    
    public boolean insert(bookingDTO booking){
         System.out.println("inserting booking");

        try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKINGS (USERNAME, SHOWINGID,SCREENID) VALUES (?,?,?)");
            
            stmt.setString(1, booking.getUser().getUsername());
            stmt.setInt(2, booking.getShowing().getShowingID());
            //stmt.setInt(3, booking.getScreen().getCinema().getCinemaID());
            stmt.setString(3, booking.getScreen().getScreenID());

            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            System.out.println("Booking created");
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;

    };
    
     public ArrayList<bookingDTO> getAll(String username){
        ArrayList<bookingDTO> allBookings = new ArrayList<>();
        try{
            Connection conn = g.getCon();
            String sqlStr="SELECT bookings.bookingID,showings.showingID, showings.timeslot,screens.screenID,cinemas.cinemaID,cinemas.name,cinemas.location,films.filmID,films.title,users.username"
                    + " FROM bookings JOIN users on bookings.username = users.username"
                    + " JOIN showings on bookings.showingID = showings.showingID"
                    + " JOIN films on films.filmID = showings.filmID "
                    + " JOIN screens on bookings.screenID = screens.screenID"
                    + " JOIN cinemas on Screens.cinemaID = cinemas.cinemaID"
                    + " WHERE bookings.username = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlStr);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                userDTO user = new userDTO(rs.getString("username"),"","","","","","",null,false);
                filmDTO film = new filmDTO(rs.getInt("filmID"),rs.getString("title"),"","","");
                cinemaDTO cinema = new cinemaDTO(rs.getInt("cinemaID"),rs.getString("name"),rs.getString("location"));
                screenDTO screen = new screenDTO(rs.getString("ScreenID"),cinema);
                showingDTO showing = new showingDTO(rs.getInt("showingID"),screen,film,rs.getString("timeslot"));
                bookingDTO booking = new bookingDTO(rs.getInt("bookingID"),user,showing,screen);
                allBookings.add(booking);
            }

            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return allBookings;

        
    }
    
    

    
    public boolean delete(int bookingID){
         System.out.println("deleting booking");
        try{
            Connection conn = g.getCon();
        
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKINGS WHERE bookingID=?");
            stmt.setInt(1, bookingID);
            int rows = stmt.executeUpdate();
            
            
            stmt.close();
            conn.close();
            
            
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    }
}
