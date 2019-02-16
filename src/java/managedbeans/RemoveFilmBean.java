/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;
import UI.adminUI;
import DTO.filmDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "removeFilm")
@RequestScoped
public class RemoveFilmBean {
    
    private adminUI adminUI = new adminUI();
    
    
    @Inject
    filmBean filmbean;
    @Inject
    showingBean showingbean;

    public RemoveFilmBean() {
    }
    
    public filmBean getFilmBean() {
        return filmbean;
    }

    
    public String removeFilm(int FilmID){
        adminUI.removeFilm(FilmID);
        return "admin";
    }
    
    
}
