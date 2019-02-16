
package DTO;


public class cinemaDTO
{
    private int cinemaID;
    private String name;
    private String location;

    public cinemaDTO(int cinemaID, String name, String location)
    {
        this.cinemaID = cinemaID;
        this.name = name;
        this.location = location;
    }

    public int getCinemaID()
    {
        return cinemaID;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }
    
    
}
