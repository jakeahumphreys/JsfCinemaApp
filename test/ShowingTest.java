/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DTO.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import UI.*;
/**
 *
 * @author Jake
 */
public class ShowingTest {
    
    public ShowingTest() {
    }
    
    @Test   
    public void testId(){
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        
        int exp=1;
        assertEquals(showing.getShowingID(),exp);
    }
     @Test   
    public void testGetScreen(){
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        
        String exp="c1s1";
        assertEquals(showing.getScreen().getScreenID(),exp);
    }
       @Test   
    public void testGetFilmTitle(){
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        
        String exp="Inception";
        assertEquals(showing.getFilm().getTitle(),exp);
    }
       @Test   
    public void testGetTimeslot(){
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        
        String exp="3PM";
        assertEquals(showing.getTimeslot(),exp);
    }
    @Test
    public void testAddShowing(){
        adminUI admin = new adminUI();
        cinemaDTO cinema = new cinemaDTO(1,"Cadman","Staffs Uni");
        screenDTO screen = new screenDTO("c1s1",cinema);
        filmDTO film = new filmDTO(1,"Inception","PG","120 Minutes","Leonardo DiCaprio");
        showingDTO showing = new showingDTO(1,screen,film,"3PM");
        assertTrue(admin.addShowing(showing));
        
    }
    
}
