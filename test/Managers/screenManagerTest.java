/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.cinemaDTO;
import DTO.screenDTO;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jake
 */
public class screenManagerTest {
    
    public screenManagerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testFindAllScreens() {
        System.out.println("findAllScreens");
        screenManager instance = new screenManager();
        ArrayList<screenDTO> expResult = null;
        ArrayList<screenDTO> result = instance.findAllScreens();
        assertNotEquals(expResult, result);

    }
    
}
