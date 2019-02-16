/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jake
 */
public class bookingManagerTest {
    
    public bookingManagerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of bookShowing method, of class bookingManager.
     */
    @Test
    public void testBookShowing() {
        System.out.println("bookShowing");
        userDTO user = new userDTO("user",null,null,null,null,null,null,null,false);
        filmDTO film = new filmDTO(1,null,null,null,null);
        screenDTO screen = new screenDTO("C3-S1",null);
        showingDTO showing = new showingDTO(1,null,film,null);
        bookingDTO booking = new bookingDTO(101,user,showing,screen);
        bookingManager instance = new bookingManager();
        boolean expResult = true;
        boolean result = instance.bookShowing(booking);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindBooking() {
        System.out.println("findBooking");
        String username = "user";
        bookingManager instance = new bookingManager();
        bookingDTO expResult = null;
        bookingDTO result = instance.findBooking(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllBookings method, of class bookingManager.
     */
    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        String username = "";
        bookingManager instance = new bookingManager();
        ArrayList<bookingDTO> expResult = null;
        ArrayList<bookingDTO> result = instance.getAllBookings(username);
        assertNotEquals(expResult, result);

    }

    @Test
    public void testRemoveBooking() {
        System.out.println("removeBooking");
        int bookingID = 101;
        bookingManager instance = new bookingManager();
        boolean expResult = true;
        boolean result = instance.removeBooking(bookingID);
        assertEquals(expResult, result);
    }
    
}
