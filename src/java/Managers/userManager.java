
package Managers;

import DTO.userDTO;
import DTO.cinemaDTO;
import Gateways.userGateway;
import java.util.ArrayList;

public class userManager {
    
    private userGateway gateway = new userGateway();
    
    public boolean Register(userDTO user){
        return gateway.insert(user);
    }
    
    public boolean Modify(userDTO user){
        return gateway.update(user);
    }
    
    public userDTO finduser(String username){
        return gateway.get(username);
    }
    
    
    public userDTO Login(String username, String password){
        return gateway.get(username, password);
    }
    
    public ArrayList<userDTO> getAllUsers(){
        return gateway.getAll();
    }
    
    
    public boolean manageAccount(userDTO userDTO){
        return gateway.update(userDTO);
    }
}
