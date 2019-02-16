/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import UI.adminUI;
import DTO.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Date;
import java.text.SimpleDateFormat;

@Named(value = "addShowing")
@RequestScoped
public class AddShowingBean {
    
    private adminUI adminUI = new adminUI();
    
    @Inject
    showingBean showing;
    
    private int showingID = 0;
    private String screenID;
    private int filmID;
    private String timeslot;
    

    
    public AddShowingBean() {
    }
   
    public String addShowing(){
        adminUI.addShowing(new showingDTO(
                showingID,
                new screenDTO(screenID,null),
                new filmDTO(filmID,"","","",""),
                timeslot));
        return "admin";
    }
    
    
    public int getShowingID() {
        return showingID;
    }

    public void setShowingID(int showingID) {
        this.showingID = showingID;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    
    
}
