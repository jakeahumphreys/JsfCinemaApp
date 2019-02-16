
package DTO;

public class bookingDTO
{
    private int bookingID;
    private userDTO user;
    private showingDTO showing;
    private screenDTO screen;

    public bookingDTO(int bookingID, userDTO user, showingDTO showing,screenDTO screen) {
        this.bookingID = bookingID;
        this.user = user;
        this.showing = showing;
        this.screen = screen;
    }

    public int getBookingID() {
        return bookingID;
    }

    public userDTO getUser() {
        return user;
    }

    public showingDTO getShowing() {
        return showing;
    }

    public screenDTO getScreen() {
        return screen;
    }
    

    
    
}
