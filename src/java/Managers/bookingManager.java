
package Managers;
import DTO.bookingDTO;
import Gateways.bookingGateway;
import java.util.ArrayList;

public class bookingManager {
    
    private bookingGateway gateway = new bookingGateway();
    
    public boolean bookShowing(bookingDTO booking){
        System.out.println("manager");
        return gateway.insert(booking);
    }
    
    public bookingDTO findBooking(String username){
        return gateway.findBooking(username);
    } 
    
    public ArrayList<bookingDTO> getAllBookings(String username){
        return gateway.getAll(username);
    }
    
    public boolean removeBooking(int bookingID){
        return gateway.delete(bookingID);
    }
}
