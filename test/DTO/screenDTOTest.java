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
public class screenDTOTest {
    
    public screenDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getScreenID method, of class screenDTO.
     */
    @Test
    public void testGetScreenID() {
        System.out.println("getScreenID");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO instance = new screenDTO("C3-S1",cinema);
        String expResult = "C3-S1";
        String result = instance.getScreenID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCinema method, of class screenDTO.
     */
    @Test
    public void testGetCinema() {
        System.out.println("getCinema");
        cinemaDTO cinema = new cinemaDTO(1,"name","location");
        screenDTO instance = new screenDTO("C3-S1",cinema);
        int expResult = 1;
        int result = instance.getCinema().getCinemaID();
        assertEquals(expResult, result);
    }
    
}
