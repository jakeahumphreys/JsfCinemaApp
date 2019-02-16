
package Gateways;
import DTO.filmDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class filmGateway {
    Gateway g = new Gateway();

    
    public filmDTO get(int filmID){
       System.out.println("Beginning get film");
       filmDTO filmdetails = null;
       
                
       try{
            Connection conn = g.getCon();
            System.out.println("Getting resultset");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FILMS WHERE FILMID = ? ");
            stmt.setInt(1, filmID);
            ResultSet rs = stmt.executeQuery();
            
            System.out.println("Constructing DTO");
            if (rs.next())
            {
                System.out.println("Constructing...");
                filmdetails = new filmDTO(
                        rs.getInt("FILMID"),
                        rs.getString("TITLE"),
                        rs.getString("BBFCAGE"),
                        rs.getString("RUNTIME"),
                        rs.getString("LEAD"));    
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Film DTO constructed.");
            
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
       return filmdetails;   
    }
    
     public ArrayList<filmDTO> getAll(){
        ArrayList<filmDTO> allFilms = new ArrayList<>();
        try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("SELECT FilmID, TITLE,BBFCAGE,RUNTIME,LEAD FROM FILMS");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                filmDTO filmdetails = new filmDTO(
                rs.getInt("FILMID"),
                rs.getString("TITLE"),
                rs.getString("BBFCAGE"),
                rs.getString("RUNTIME"),
                rs.getString("LEAD"));
                System.out.println(filmdetails.getTitle());
                allFilms.add(filmdetails);
            }
            
            
            System.out.println(allFilms.size());
            rs.close();
            stmt.close();
            conn.close();
            
        }catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return allFilms;

        
    }
    
    public boolean insert(filmDTO film){
        System.out.println("inserting film");
       //dont need userID anymore consider removing
       
      
        try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FILMS (TITLE, BBFCAGE, RUNTIME, LEAD) VALUES (?,?,?,?)");
            
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getBbfcAge());
            stmt.setString(3, film.getRuntime());
            stmt.setString(4, film.getLead());
         
            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    };
    
    
    public boolean delete(int filmID){
        
        System.out.println("deleting film");
        try{
            Connection conn = g.getCon();            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SHOWINGS WHERE FILMID=?");
            stmt.setInt(1, filmID);
            int rows = stmt.executeUpdate();
            stmt= conn.prepareStatement("DELETE FROM FILMS WHERE FILMID=?");
            stmt.setInt(1, filmID);
            rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    };
    
    
}
