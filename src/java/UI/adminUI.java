/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.bookingDTO;
import DTO.showingDTO;
import DTO.filmDTO;
import DTO.screenDTO;
import DTO.userDTO;
import Managers.bookingManager;
import Managers.filmManager;
import Managers.showingManager;
import Managers.screenManager;
import Managers.userManager;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


@Named(value = "adminUI")
@Dependent
public class adminUI extends userUI {

    protected filmManager filmMngr = new filmManager();
    protected userManager userMngr = new userManager();
    protected showingManager showMngr = new showingManager();
    protected screenManager screenMngr = new screenManager();
    
    public adminUI() {
        
    }

    
    public boolean addShowing(showingDTO showing){
       return showMngr.addShowing(showing);
    }
    
    public filmDTO addFilm(filmDTO film){
       if (filmMngr.addFilm(film)){
            return filmMngr.findFilm(film.getFilmID());
        }
        return null;   
    }
    
        public ArrayList<userDTO> getAllUsers()
    {
        return userMngr.getAllUsers();
    }
    
    public boolean removeFilm(int FilmID){
        return filmMngr.removeFilm(FilmID);
        
    }
    
    public filmDTO findFilm(int filmID){
        return filmMngr.findFilm(filmID);
    }
    
     public screenDTO findScreenById(String screenID){
        return screenMngr.findScreen(screenID);
    }
    
    public ArrayList<filmDTO> getAllFilms()
    {
        return filmMngr.getAllFilms();
    }
    
    public ArrayList<showingDTO> getAllShowings()
    {
        return showMngr.getAllShowings();
    }
    
    public ArrayList<screenDTO> findAllScreens(){
        return screenMngr.findAllScreens();
    }
    
    
    public boolean removeShowing(int showingID){
        return showMngr.removeShowing(showingID);
    }
    
   
    
}
