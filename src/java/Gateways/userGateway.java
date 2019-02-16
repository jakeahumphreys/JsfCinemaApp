
package Gateways;
import DTO.userDTO;
import java.security.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class userGateway
{
    Gateway g = new Gateway();
    Connection conn = g.getCon();
    
    public userDTO get(String username){
       userDTO userdetails = null;
       try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE USERNAME = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                userdetails = new userDTO(
                        
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getString("ADDRESS1"),
                        rs.getString("ADDRESS2"),
                        rs.getString("TOWN"),
                        rs.getString("COUNTY"),
                        rs.getString("POSTCODE"),
                        rs.getDate("REGDATE"),
                        rs.getBoolean("ISADMIN"));    
            }
            rs.close();
            stmt.close();
            conn.close();
        
        }catch(SQLException sqle){
            return null;
        }
       return userdetails;   
    }
    
    public userDTO get(String username, String password){
        Connection conn = g.getCon();
        System.out.println("Beginning get");
       userDTO userdetails = null;
       String hashpass;
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8));
            hashpass = Base64.getEncoder().encodeToString(hash);
            System.out.println("Hashed.");
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
                
       try{
           
            System.out.println("Getting resultset");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ?");
            stmt.setString(1, username);
            stmt.setString(2, hashpass);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Constructing DTO");
            if (rs.next())
            {
                System.out.println("Constructing...");
                userdetails = new userDTO(
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getString("ADDRESS1"),
                        rs.getString("ADDRESS2"),
                        rs.getString("TOWN"),
                        rs.getString("COUNTY"),
                        rs.getString("POSTCODE"),
                        rs.getDate("REGDATE"),
                        rs.getBoolean("ISADMIN"));    
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("User DTO constructed.");
            
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
       return userdetails;   
    }
    
    
    
     public ArrayList<userDTO> getAll(){
        Connection conn = g.getCon();
        ArrayList<userDTO> allUsers = new ArrayList<>();
        userDTO userdetails = null;
        try{
            
            PreparedStatement stmt = conn.prepareStatement("SELECT Username FROM USERS");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                userdetails = new userDTO(
                        rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getString("ADDRESS1"),
                        rs.getString("ADDRESS2"),
                        rs.getString("TOWN"),
                        rs.getString("COUNTY"),
                        rs.getString("POSTCODE"),
                        rs.getDate("REGDATE"),
                        rs.getBoolean("ISADMIN"));    
            }
                allUsers.add(userdetails);

            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException sqle)
        {
        }
        return allUsers;
    }
    public boolean insert(userDTO user){
        System.out.println("inserting");
        java.sql.Date sDate = new java.sql.Date(user.getRegdate().getTime());
       //dont need userID anymore consider removing
       
       String hashpass;
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256").digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
            hashpass = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException ex) {
            return false;
        }
        try{
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD, ADDRESS1, ADDRESS2, TOWN, COUNTY, POSTCODE,REGDATE, ISADMIN) VALUES (?,?,?,?,?,?,?,?,?)");
            
            
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, hashpass);
            stmt.setString(3, user.getAddress1());
            stmt.setString(4, user.getAddress2());
            stmt.setString(5, user.getTown());
            stmt.setString(6, user.getCounty());
            stmt.setString(7, user.getPostcode());
            stmt.setDate(8, sDate);
            stmt.setBoolean(9, user.getIsAdmin());
            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    };
    
    public boolean update(userDTO user){
      try{
          
          
            Connection conn = g.getCon();
            PreparedStatement stmt = conn.prepareStatement("UPDATE USERS SET ADDRESS1 = ?, ADDRESS2 = ?,TOWN = ? , COUNTY= ?, POSTCODE = ? WHERE username = ?");
            
            stmt.setString(1, user.getAddress1());
            stmt.setString(2, user.getAddress2());
            stmt.setString(3, user.getTown());
            stmt.setString(4, user.getCounty());
            stmt.setString(5, user.getPostcode());
            stmt.setString(6, user.getUsername());
            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return true;
    }
    
}
