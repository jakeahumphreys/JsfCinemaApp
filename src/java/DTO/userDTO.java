/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

public class userDTO
{
    
    private String username;
    private String password;
    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;
    private Date regdate;
    private boolean isAdmin;

    public userDTO(String username, String password, String address1, String address2, String town, String county, String postcode,Date regdate, boolean isAdmin)
    {
        
        this.username = username;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.regdate = regdate;
        this.isAdmin = isAdmin;
    }

    

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getAddress1()
    {
        return address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public String getTown()
    {
        return town;
    }

    public String getCounty()
    {
        return county;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public Date getRegdate() {
        return regdate;
    }
    

    public boolean getIsAdmin()
    {
        return isAdmin;
    }
    
    
    
    
}
