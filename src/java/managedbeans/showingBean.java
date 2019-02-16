/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;



import DTO.showingDTO;
import UI.adminUI;
import UI.userUI;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "showing")
@SessionScoped
public class showingBean implements Serializable  {
    
    private adminUI admin = new adminUI();
    private userUI user = new userUI();
    private showingDTO showingdetails = null;
    
    
    @Inject
    screenBean screenBean;
    @Inject
    cinemaBean cinemaBean;
    
    public showingBean() {
    }
    
    public showingDTO getShowingInfo(){
        return showingdetails;
    }
    
    public String getShowingDetails(int showingID){
        showingdetails = user.findShowing(showingID);
        return "makebooking";
    }
    
    public void setShowingInfo(showingDTO showingdetails){
        this.showingdetails = showingdetails;
    }

    
    public ArrayList<showingDTO> getAllShowings(){
         ArrayList<showingDTO> allShowings = admin.getAllShowings();
         return allShowings;
     }
    
}
