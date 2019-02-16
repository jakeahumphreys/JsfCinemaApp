
package managedbeans;

import UI.userUI;
import DTO.bookingDTO;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;


@Named(value = "booking")
@SessionScoped
public class bookingBean implements Serializable {

    private userUI user = new userUI();
    private bookingDTO bookingdetails = null;
    
    public bookingBean() {
    }
    
    public bookingDTO getBookingInfo(){
        return bookingdetails;
    }
    
    public void setBookingDetails(bookingDTO booking){
        this.bookingdetails = booking;
    }
    
    public void findBooking(String username){
        bookingdetails = user.findBooking(username);
    }
    
    public ArrayList<bookingDTO>findUserBookings(String username){
       ArrayList<bookingDTO> allBookings = user.getAllBookings(username);
       return allBookings; 
    }
    
    
    
    
    
}
