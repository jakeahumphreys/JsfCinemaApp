/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import UI.adminUI;
import DTO.screenDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jake
 */
@Named(value = "screen")
@SessionScoped
public class screenBean implements Serializable {

    /**
     * Creates a new instance of screenBean
     */
    public screenBean() {
    }
    
    private adminUI admin = new adminUI();
    private screenDTO screendetails = null;
    
    public screenDTO getScreenDetails(){
        return screendetails;
    }
    
    public ArrayList<screenDTO> findAllScreens(){
        ArrayList<screenDTO> allScreens = admin.findAllScreens();
        return allScreens;
    }
     
    public void setScreenDetails(screenDTO screendetails){
        this.screendetails = screendetails;
    }
    
}
