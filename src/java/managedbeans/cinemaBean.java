
package managedbeans;

import DTO.cinemaDTO;
import UI.userUI;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;


@Named(value = "cinema")
@SessionScoped
public class cinemaBean implements Serializable {


    private userUI user = new userUI();
    private cinemaDTO cinemadetails = null;
    
    public cinemaBean() {
    }
    
    public cinemaDTO getCinemaDetails(){
        return cinemadetails;
    }
    
//    public String findCinemaNameById(int cinemaID)
//    {
//        cinemadetails = user.findCinema(cinemaID);
//        return cinemadetails.getName();
//       
//    }
    
      
    public void setCinemaDetails(cinemaDTO cinemadetails){
        this.cinemadetails = cinemadetails;
    }
}
