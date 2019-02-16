/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jake
 */
public class userDTOTest {
    
    public userDTOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getUsername method, of class userDTO.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "username";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class userDTO.
     */
    @Test
    public void testGetPassword() {
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "password";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress1 method, of class userDTO.
     */
    @Test
    public void testGetAddress1() {
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "address1";
        String result = instance.getAddress1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress2 method, of class userDTO.
     */
    @Test
    public void testGetAddress2() {
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "address2";
        String result = instance.getAddress2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTown method, of class userDTO.
     */
    @Test
    public void testGetTown() {
         userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "town";
        String result = instance.getTown();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCounty method, of class userDTO.
     */
    @Test
    public void testGetCounty() {
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "county";
        String result = instance.getCounty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostcode method, of class userDTO.
     */
    @Test
    public void testGetPostcode() {
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        String expResult = "postco";
        String result = instance.getPostcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegdate method, of class userDTO.
     */
    @Test
    public void testGetRegdate() {
        System.out.println("getRegdate");
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        Date expResult = null;
        Date result = instance.getRegdate();
        assertEquals(expResult, result);
    }

    public void testGetIsAdmin() {
        System.out.println("getIsAdmin");
        userDTO instance = new userDTO("username","password","address1","address2","town","county","postco",null,false) ;
        boolean expResult = false;
        boolean result = instance.getIsAdmin();
        assertEquals(expResult, result);
    }
    
}
