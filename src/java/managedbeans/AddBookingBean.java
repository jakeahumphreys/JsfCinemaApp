/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import UI.userUI;
import DTO.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "addBooking")
@RequestScoped
public class AddBookingBean {

    private userUI user = new userUI();
    
    @Inject
    bookingBean bookingBean;
    @Inject
    UserBean userBean;
    @Inject
    showingBean showingBean;
    @Inject
    cinemaBean cinemaBean;
    @Inject
    screenBean screenBean;
   
    
    private int bookingID;
    private String username;
    private int showingID;
    private int cinemaID;
    private String screenID;
            
           
    
    public AddBookingBean() {
    }
    
    public String addBooking(){
        username = userBean.getUserInfo().getUsername();
        showingID = showingBean.getShowingInfo().getShowingID();
        cinemaID = showingBean.getShowingInfo().getScreen().getCinema().getCinemaID();
        screenID = showingBean.getShowingInfo().getScreen().getScreenID();
        

        user.makeBooking(new bookingDTO(bookingID,
        new userDTO(username,"","","","","","",null,false),
        new showingDTO(showingID,null,null,""),
        new screenDTO(screenID,null)));
        return "showings";
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getUsername() {
        return username;
    }


    public int getShowingID() {
        return showingID;
    }


    public int getCinemaID() {
        return cinemaID;
    }



    public String getScreenID() {
        return screenID;
    }

    
    
    
    
}
