/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import DTO.filmDTO;
import UI.adminUI;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;



@Named(value = "film")
@SessionScoped
public class filmBean implements Serializable {


    
    private adminUI admin = new adminUI();
    private filmDTO filmdetails = null;
   
    
    public filmBean() {
    }
    
    public filmDTO getFilmDetails(){
        return filmdetails;
    }
    
     public String findFilm(int filmID)
    {
        filmdetails = admin.findFilm(filmID);
        return filmdetails.getTitle();
       
    }
    
    public void setFilmInfo(filmDTO filmdetails){
        this.filmdetails = filmdetails;
    }
    
    public ArrayList<filmDTO> getAllFilms(){
         ArrayList<filmDTO> allFilms = admin.getAllFilms();
         return allFilms;
     }
    
}
