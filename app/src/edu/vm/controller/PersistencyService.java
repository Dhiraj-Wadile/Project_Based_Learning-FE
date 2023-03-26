package edu.vm.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.vm.model.RideModel;
import edu.vm.model.RiderModel;

public class PersistencyService
{
    public static final String rideShareRiderFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Riders.rs";
    public static final String rideShareRidesFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Rides.rs";

    public static void addRider(RiderModel riderModel) throws IOException, ClassNotFoundException
    {
        List<RiderModel> riderModels = getAllRiders();
        riderModels.add(riderModel);
        try
        (
            FileOutputStream fos = new FileOutputStream(rideShareRiderFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            oos.writeObject(riderModels);
        }
        System.out.println("The user " + riderModel.getName()  + " registered successfully!");
    }
    
    @SuppressWarnings("unchecked")
    public static List<RiderModel> getAllRiders()
    {
        try
        (
            FileInputStream fis = new FileInputStream(rideShareRiderFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis)
        )
        {
            return (List<RiderModel>) ois.readObject();
        }
        catch(FileNotFoundException fnfe)
        {
            //Ignore
            //fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            // Ignore!
            //e.printStackTrace();
        }
        return new ArrayList<RiderModel>();
    }

    public static void addRide(RideModel rideModel)
    {
        List<RideModel> rideModels = getAllRides();
        rideModels.add(rideModel);
        try
        (
            FileOutputStream fos = new FileOutputStream(rideShareRidesFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            oos.writeObject(rideModels);
        }
        catch(FileNotFoundException fnfe)
        {
            //Ignore
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static RideModel getRide(RiderModel riderModel)
    {
        List<RideModel> rideModels = getAllRides();
        RideModel rideModel = null;
        for(int i=0; i< rideModels.size(); i++)
        {
            rideModel = rideModels.get(i);
            if( null != rideModel.getRideGiver())
            {
                if(rideModel.getRideGiver().getUserId().equals(riderModel.getUserId()))
                {
                    return rideModel;
                }
            }
            if( null != rideModel.getRideTaker())
            {
                if(rideModel.getRideTaker().getUserId().equals(riderModel.getUserId()))
                {
                    return rideModel;
                }
            }
        }
        return null;
    }
    
    public static void removeRide(RiderModel riderModel)
    {
        List<RideModel> rideModels = getAllRides();
        for(int i=0; i<rideModels.size(); i++)
        {
            //RideModel rideModel = rideModels.get(i);
            //if(rideModel != null && rideModel.getRideGiver() != null && rideModel.getRideGiver().getUserId() == riderModel.getUserId())
            {
                if(1==rideModels.size()) // Only element to be deleted
                {                
                    new File(rideShareRidesFilePath).delete();
                    return;
                }
            }
        }
        try
        (
            FileOutputStream fos = new FileOutputStream(rideShareRidesFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            oos.writeObject(rideModels);
        }
        catch(FileNotFoundException fnfe)
        {
            //Ignore
        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void updateRide(RideModel rideModel, RiderModel rideTaker)
    {
        List<RideModel> rideModels = getAllRides();
        for(int i=0; i< rideModels.size(); i++)
        {
            if(rideModels.get(i) == rideModel)
            {
                rideModel.setRideTaker(rideTaker);
                break;
            }
        }
        try
        (
            FileOutputStream fos = new FileOutputStream(rideShareRidesFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            oos.writeObject(rideModels);
            System.out.println("The route " + rideModel.getStartLocation()  + " updated successfully!");
        }
        catch(FileNotFoundException fnfe)
        {
            //Ignore
        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<RideModel> getAllRides()
    {
        try
        (
            FileInputStream fis = new FileInputStream(rideShareRidesFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {
            return (List<RideModel>) ois.readObject();
        }
        catch(FileNotFoundException fnfe)
        {
            //Ignore
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ArrayList<RideModel>();
    }
}
