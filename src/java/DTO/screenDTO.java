
package DTO;


public class screenDTO
{
    private String screenID;
    private cinemaDTO cinema;

    public screenDTO(String screenID, cinemaDTO cinema) {
        this.screenID = screenID;
        this.cinema = cinema;
    }

    public String getScreenID() {
        return screenID;
    }

    public cinemaDTO getCinema() {
        return cinema;
    }

  

    
    
    
}
