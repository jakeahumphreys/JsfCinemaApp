/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jake
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DTO.userDTOTest.class, DTO.filmDTOTest.class, DTO.cinemaDTOTest.class, DTO.bookingDTOTest.class, DTO.showingDTOTest.class, DTO.screenDTOTest.class})
public class DTOSuite {

    @Before
    public void setUp() throws Exception {
    }
    
}
