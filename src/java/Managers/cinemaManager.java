/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import java.util.ArrayList;
import DTO.cinemaDTO;
import Gateways.cinemaGateway;


public class cinemaManager {
    private cinemaGateway gateway = new cinemaGateway();
    
     public cinemaDTO findCinemaByID(int cinemaID){
        return gateway.get(cinemaID);
    }

     
}
