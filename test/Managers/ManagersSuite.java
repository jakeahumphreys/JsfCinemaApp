/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jake
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Managers.bookingManagerTest.class, Managers.screenManagerTest.class})
public class ManagersSuite {

    @Before
    public void setUp() throws Exception {
    }
    
}
