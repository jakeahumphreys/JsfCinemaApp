/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DTO.userDTO;
import java.text.SimpleDateFormat;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;
import java.text.ParseException;
import managedbeans.*;
import UI.*;
/**
 *
 * @author Jake
 */
public class UserTest {

    public UserTest(){
    
    }
    @Test
    public void testName(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "username";
        assertEquals(user.getUsername(), exp);
    }
    @Test
    public void testPassword(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "password";
        assertEquals(user.getPassword(), exp);
    }
    @Test
    public void testAddress1(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "12";
        assertEquals(user.getAddress1(), exp);
    }
    
    @Test
    public void testAddress2(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "TEST LANE";
        assertEquals(user.getAddress2(), exp);
    }
    @Test
    public void testTown(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "TESTHAVEN";
        assertEquals(user.getTown(), exp);
    }
    
    @Test
    public void TestCounty(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "TESTFORDSHIRE";
        assertEquals(user.getCounty(), exp);
    }
    
    @Test
    public void testPostcode(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        String exp = "TE44BN";
        assertEquals(user.getPostcode(), exp);
    }
    
    @Test
    public void testReg(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        java.sql.Date exp = sqldate;
        assertEquals(user.getRegdate(), exp);
    }
    
    @Test
    public void testAdmin(){
        java.sql.Date sqldate = null;
        try{
            String testDate = "02-10-1997";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            java.util.Date date = sdf.parse(testDate);
            sqldate = new java.sql.Date(date.getTime());
        }catch(ParseException ex){
            System.out.println("Parsing Error");
        }
            
        
        userDTO user = new userDTO("username","password","12","TEST LANE","TESTHAVEN","TESTFORDSHIRE","TE44BN",sqldate,false);
        boolean exp = false;
        assertEquals(user.getIsAdmin(), exp);
    }
}
