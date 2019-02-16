/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;


import UI.adminUI;
import DTO.showingDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
/**
 *
 * @author Jake
 */
@Named(value = "removeShowing")
@RequestScoped
public class RemoveShowingBean {

    private adminUI adminUI = new adminUI();
    
    @Inject
    showingBean showingbean;
    
    public RemoveShowingBean() {
    }
    
    public showingBean getShowingBean() {
        return showingbean;
    }

    
    public String removeShowing(int showingID){
        adminUI.removeShowing(showingID);  
        return "admin";
    }
    
}
