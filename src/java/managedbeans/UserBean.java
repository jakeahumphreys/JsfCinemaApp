
package managedbeans;
import UI.userUI;
import UI.adminUI;
import DTO.userDTO;
import java.util.ArrayList;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;


@Named(value = "user")
@SessionScoped
public class UserBean implements Serializable {

    private userUI user = new userUI();
    private userDTO userdetails = null;
    private boolean loginOK = false;
    private String username;
    private String password;
   
    
    public userDTO getUserInfo(){
        return userdetails;
    }
    
    public void setUserInfo(userDTO userdetails){
        this.userdetails = userdetails;
    }
    
     public void findUserDetails(String username)
    {
        userdetails = user.findUser(username);
       
    }
     

     //login stuff
     
    public String checkLogin(){
        try{
           this.setUserInfo(user.login(username, password));
           loginOK = true;
           if (loginOK){
            if (getUserInfo().getIsAdmin()){
                System.out.println("I've found an admin");
                return "admin";
            }else{
                System.out.println("Standard User found");
                return "showings";
            }
            
        }
        }catch(Exception ex){
          return null;  
        }
        
        
        return null;
    }
    private void clearLogin(){
        this.username = "";
        this.password= "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public String logOut(){
        clearLogin();
        return "index";
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
}