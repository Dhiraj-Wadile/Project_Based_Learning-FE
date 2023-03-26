package edu.vm.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import edu.vm.RideShareApp;
import edu.vm.model.RideModel;
import edu.vm.model.RiderModel;
import edu.vm.view.RSCreateRidePage;

public class RSCreateRideCtrl extends RSBaseController implements ActionListener
{
    public RSCreateRideCtrl(RideShareApp parent)
	{
        super(parent, null, new RSCreateRidePage());
        RSCreateRidePage createRidesPage = (RSCreateRidePage) view;
        JComboBox<String> cbo = createRidesPage.getCombo();
        cbo.addItem("Hadapsar");
        cbo.addItem("Nigdi");
        cbo.addItem("Kothrud");
        createRidesPage.getCmd().addActionListener(this);
	}

    public RiderModel getRiderModel()
    {
        return rideShareApp.getLoggedInRiderModel();
    }

    public void show()
    {
        if(rideShareApp.getRsMainCtrl().isRideCancelOn())
        {
            String startLocation = rideShareApp.getRideModel().getStartLocation();
            int result = JOptionPane.showConfirmDialog(view, "Are you sure, you want to cancel the ride: " + startLocation + " --> PICT!", "Ride Cancel", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {
                PersistencyService.removeRide(getRiderModel());
                JOptionPane.showMessageDialog(null,"The ride " + startLocation + " --> PICT is cancelled successfully!", "Ride Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }
        view.pack();
        view.setVisible(true);
        rideShareApp.getRsMainCtrl().hide();
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        RSCreateRidePage createRidesPage = (RSCreateRidePage) view;
        JComboBox<String> cbo = createRidesPage.getCombo();
        try
        {
            RideModel rideModel = rideShareApp.getRideModel();
            if(null == rideModel)
            {
                rideModel = new RideModel();
                rideShareApp.setRideModel(rideModel);
            }
            rideModel.setRideGiver(getRiderModel());
            rideModel.setStartLocation((String) cbo.getSelectedItem());
            PersistencyService.addRide(rideModel);
            JOptionPane.showMessageDialog(createRidesPage,"Ride : " + ((String) cbo.getSelectedItem()) + " --> PICT is created successfully!", "Ride Created", JOptionPane.INFORMATION_MESSAGE);
            hide();
            rideShareApp.getRsMainCtrl().setCreateToCancel();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
