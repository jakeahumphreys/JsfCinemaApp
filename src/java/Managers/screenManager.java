/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import DTO.screenDTO;
import Gateways.screenGateway;
import java.util.ArrayList;

public class screenManager {
    private screenGateway gateway = new screenGateway();
    
     public screenDTO findScreen(String screenID){
        return gateway.get(screenID);
    }
     
     public ArrayList<screenDTO> findAllScreens(){
        return gateway.getAll();
    }

}
