/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jake
 */
public class showingDTOTest {
    
    public showingDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getShowingID method, of class showingDTO.
     */
    @Test
    public void testGetShowingID() {
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO screen = new screenDTO("C3-S1",cinema);
        showingDTO instance = new showingDTO(1,screen,film,"time");
        int expResult = 1;
        int result = instance.getShowingID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScreen() {
         filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO screen = new screenDTO("C3-S1",cinema);
        showingDTO instance = new showingDTO(1,screen,film,"time");
        String expResult = "C3-S1";
        String result = instance.getScreen().getScreenID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFilm() {
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO screen = new screenDTO("C3-S1",cinema);
        showingDTO instance = new showingDTO(1,screen,film,"time");
        int expResult = 1;
        int result = instance.getFilm().getFilmID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTimeslot() {
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO screen = new screenDTO("C3-S1",cinema);
        showingDTO instance = new showingDTO(1,screen,film,"time");
        String expResult = "time";
        String result = instance.getTimeslot();
        assertEquals(expResult, result);
    }
    
}
