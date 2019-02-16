
package managedbeans;

import UI.adminUI;
import DTO.filmDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "addFilm")
@RequestScoped
public class AddFilmBean {

    private adminUI adminUI = new adminUI();
    
    @Inject
    filmBean filmbean;
    
    
    private int filmID;
    private String title;
    private String bbfcAge;
    private String runtime;
    private String lead;
    
    public AddFilmBean() {
    }
    
    public String addFilm(){
        
        filmbean.setFilmInfo(adminUI.addFilm(new filmDTO(filmID,title,bbfcAge,runtime,lead)));
        return "admin";
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBbfcAge() {
        return bbfcAge;
    }

    public void setBbfcAge(String bbfcAge) {
        this.bbfcAge = bbfcAge;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }
    
    
    
}
