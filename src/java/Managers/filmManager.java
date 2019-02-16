/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import java.util.ArrayList;
import DTO.filmDTO;
import Gateways.*;

public class filmManager {
    private filmGateway gateway = new filmGateway();
    private bookingGateway bgateway = new bookingGateway();
    private showingGateway sgateway = new showingGateway();
    
    public boolean addFilm(filmDTO film){
        return gateway.insert(film);
    }
    
    public filmDTO findFilm(int filmID){
        return gateway.get(filmID);
    }
    
    public ArrayList<filmDTO> getAllFilms(){
        return gateway.getAll();
    }
    
    public boolean removeFilm(int filmID){
        int id = sgateway.getByFilmID(filmID).getShowingID();
        int bookingID = bgateway.findBookingByShowing(id).getBookingID();
        bgateway.delete(bookingID);
        return gateway.delete(filmID);
    }
}
