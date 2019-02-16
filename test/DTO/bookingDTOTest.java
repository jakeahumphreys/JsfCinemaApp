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
public class bookingDTOTest {
    
    public bookingDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getBookingID method, of class bookingDTO.
     */
    @Test
    public void testGetBookingID() {
        userDTO user = new userDTO("user",null,null,null,null,null,null,null,false);
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        screenDTO screen = new screenDTO("C3-S1",null);
        showingDTO showing = new showingDTO(1,null,film,null);
        bookingDTO instance = new bookingDTO(1,user,showing,screen);
        int expResult = 1;
        int result = instance.getBookingID();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUser method, of class bookingDTO.
     */
    @Test
    public void testGetUser() {
        userDTO user = new userDTO("user",null,null,null,null,null,null,null,false);
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        screenDTO screen = new screenDTO("C3-S1",null);
        showingDTO showing = new showingDTO(1,null,film,null);
        bookingDTO instance = new bookingDTO(1,user,showing,screen);
        String expResult = "user";
        String result = instance.getUser().getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShowing method, of class bookingDTO.
     */
    @Test
    public void testGetShowing() {
       userDTO user = new userDTO("user",null,null,null,null,null,null,null,false);
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        screenDTO screen = new screenDTO("C3-S1",null);
        showingDTO showing = new showingDTO(1,null,film,null);
        bookingDTO instance = new bookingDTO(1,user,showing,screen);
        int expResult = 1;
        int result = instance.getShowing().getShowingID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScreen method, of class bookingDTO.
     */
    @Test
    public void testGetScreen() {
        userDTO user = new userDTO("user",null,null,null,null,null,null,null,false);
        filmDTO film = new filmDTO(1,"title","age","runtime","lead");
        screenDTO screen = new screenDTO("C3-S1",null);
        showingDTO showing = new showingDTO(1,null,film,null);
        bookingDTO instance = new bookingDTO(1,user,showing,screen);
        String expResult = "C3-S1";
        String result = instance.getScreen().getScreenID();
        assertEquals(expResult, result);
    }
    
}
