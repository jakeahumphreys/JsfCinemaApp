/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.bookingDTO;
import Managers.*;
import DTO.showingDTO;
import DTO.userDTO;
import DTO.cinemaDTO;
import java.util.ArrayList;



public class userUI {
    protected filmManager filmMngr = new filmManager();
    protected userManager userMngr = new userManager();
    protected bookingManager bookMngr = new bookingManager();
    protected showingManager showMngr = new showingManager();
    protected cinemaManager cineMngr = new cinemaManager();
    
    
            
    public userUI() {
    }
    
    public userDTO Register(userDTO user){
        if (userMngr.Register(user)){
            return userMngr.Login(user.getUsername(), user.getPassword());
        }
        return null;    
    }
    
    public userDTO Modify(userDTO user){
        if (userMngr.Modify(user)){
            return userMngr.Login(user.getUsername(), user.getPassword());
        } else{
            return null;
        } 
    }
    
    public userDTO manageAccount(String username, String password){
        return null;
    }
    
    public userDTO login(String username, String password){
        System.out.println("ui");
        return userMngr.Login(username, password);
    }
       
    public userDTO findUser(String username){
        return userMngr.finduser(username);
    }
    
    public cinemaDTO findCinema(int cinemaID){
        return cineMngr.findCinemaByID(cinemaID);
    }
    
    public showingDTO findShowing(int showingID){
        return showMngr.findShowing(showingID);
    }
    
    public boolean makeBooking(bookingDTO booking){
        System.out.println("UI");
       return bookMngr.bookShowing(booking); 
        
    }
    
    public bookingDTO findBooking(String username){
        return bookMngr.findBooking(username);
    }
    
    public ArrayList<bookingDTO>getAllBookings(String username){
        return bookMngr.getAllBookings(username);
    }
    
     public boolean removeBooking(int bookingID){
        return bookMngr.removeBooking(bookingID);
    }
   
    
}
