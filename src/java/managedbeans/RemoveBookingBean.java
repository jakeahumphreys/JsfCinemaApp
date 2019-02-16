/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;
import UI.userUI;
import DTO.bookingDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "removeBooking")
@RequestScoped
public class RemoveBookingBean {
    
    private userUI userUI = new userUI();
    
    @Inject
    bookingBean bookingBean;


    public RemoveBookingBean() {
    }
    
    public bookingBean getBookingBean() {
        return bookingBean;
    }

    
    public String removeBooking(int bookingID){
        
        userUI.removeBooking(bookingID);
        return "viewBookings";
    }
    
    
}
