
package Managers;
import java.util.ArrayList;
import DTO.showingDTO;
import Gateways.*;


public class showingManager {
    private showingGateway gateway = new showingGateway();
    private bookingGateway bgateway = new bookingGateway();
    
    public boolean addShowing(showingDTO showing){
        return gateway.insert(showing);
    }
    
    
    public showingDTO findShowing(int showingID){
        return gateway.get(showingID);
    }
    
//     public showingDTO findFilmFromShowing(int filmID){
//        return gateway.getFilmFromShowing(filmID);
//    }
//    
    public ArrayList<showingDTO> getAllShowings(){
        return gateway.getAll();
    }
    
    public boolean removeShowing(int showingID){
        
        return gateway.delete(showingID);     
    }
    
    
}
