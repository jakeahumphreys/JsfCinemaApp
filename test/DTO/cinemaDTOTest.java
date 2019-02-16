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
public class cinemaDTOTest {
    
    public cinemaDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getCinemaID method, of class cinemaDTO.
     */
    @Test
    public void testGetCinemaID() {
        System.out.println("getCinemaID");
        cinemaDTO instance = new cinemaDTO(1,"name","location");
        int expResult = 1;
        int result = instance.getCinemaID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class cinemaDTO.
     */
    @Test
    public void testGetName() {
        cinemaDTO instance = new cinemaDTO(1,"name","location");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocation method, of class cinemaDTO.
     */
    @Test
    public void testGetLocation() {
        cinemaDTO instance = new cinemaDTO(1,"name","location");
        String expResult = "location";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }
    
}
