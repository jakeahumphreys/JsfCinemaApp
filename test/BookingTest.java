/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DTO.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import UI.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import managedbeans.*;



public class BookingTest {
    
    public BookingTest() {
    }
    
    @Test
    public void testAddBooking(){
        userUI userUI = new userUI();
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
           
        userDTO user = new userDTO("jhumphreys","password1","45","Boughey Road","Stoke on Trent","Staffordshire","ST42BN",sqldate,true);
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        bookingDTO booking = new bookingDTO(1,user,showing,screen);
        
        assertTrue(userUI.makeBooking(booking));
        
    }

}
