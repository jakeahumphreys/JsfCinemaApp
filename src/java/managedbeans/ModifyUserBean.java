
package managedbeans;

import UI.userUI;
import DTO.userDTO;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;



@Named(value = "modifyUser")
@RequestScoped
public class ModifyUserBean {

private userUI user = new userUI();
    
    @Inject
    UserBean userBean;
    
    
    private String username;
    private String password;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private Date regdate;
    private boolean isAdmin;
    
    public ModifyUserBean() {
    }
    
     public userUI getUser() {
        return user;
    }
    
    public String modifyUser(){
        username = userBean.getUserInfo().getUsername();
        System.out.println(username);
        password = userBean.getUserInfo().getPassword();
        System.out.println(password);
        regdate = userBean.getUserInfo().getRegdate();
        isAdmin = userBean.getUserInfo().getIsAdmin();
        System.out.println(isAdmin);
        user.Modify(new userDTO(username,password,address1,address2,town,county,postcode,regdate,isAdmin));
        return userBean.logOut();
    }
    
    public void setUser(userUI user) {
        this.user = user;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public boolean isIsAdmin() {
        return isAdmin;
    }

    public Date getRegdate() {
        return regdate;
    }
    
    

    
    
    
    

    
    
}
