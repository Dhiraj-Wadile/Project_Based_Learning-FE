package edu.vm.model;

public class RideModel extends RSBaseModel
{
    /**
     * 
     */
    private static final long serialVersionUID = 2773165071374813617L;
    private RiderModel rideGiver;
    private RiderModel rideTaker;
    private String startLocation;
    
    public RiderModel getRideGiver()
    {
        return rideGiver;
    }
    
    public void setRideGiver(RiderModel rideGiver)
    {
        this.rideGiver = rideGiver;
    }

    public RiderModel getRideTaker()
    {
        return rideGiver;
    }
    
    public void setRideTaker(RiderModel rideTaker)
    {
        this.rideTaker = rideTaker;
    }

    public String getStartLocation()
    {
        return startLocation;
    }
    
    public void setStartLocation(String startLocation)
    {
        this.startLocation = startLocation;
    }
    
    public String toString()
    {
        if(null != rideGiver)
        {
            if( null != rideTaker)
            {
                return "Giver : " + rideGiver.getUserId() + " - Taker " + rideTaker.getUserId() + " " + startLocation + " --> PICT";
            }
            return "Giver : " + rideGiver.getUserId() + " " + startLocation + " --> PICT";
        }
        return "No Ride found";
    }
}
