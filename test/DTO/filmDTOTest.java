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
public class filmDTOTest {
    
    public filmDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getFilmID method, of class filmDTO.
     */
    @Test
    public void testGetFilmID() {
        System.out.println("getFilmID");
        filmDTO instance = new filmDTO(1,"title","age","runtime","lead");
        int expResult = 1;
        int result = instance.getFilmID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class filmDTO.
     */
    @Test
    public void testGetTitle() {
        filmDTO instance = new filmDTO(1,"title","age","runtime","lead");
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBbfcAge method, of class filmDTO.
     */
    @Test
    public void testGetBbfcAge() {
        filmDTO instance = new filmDTO(1,"title","age","runtime","lead");
        String expResult = "age";
        String result = instance.getBbfcAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRuntime() {
        filmDTO instance = new filmDTO(1,"title","age","runtime","lead");;
        String expResult = "runtime";
        String result = instance.getRuntime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLead method, of class filmDTO.
     */
    @Test
    public void testGetLead() {
        System.out.println("getLead");
        filmDTO instance = new filmDTO(1,"title","age","runtime","lead");
        String expResult = "lead";
        String result = instance.getLead();
        assertEquals(expResult, result);
    }
    
}
