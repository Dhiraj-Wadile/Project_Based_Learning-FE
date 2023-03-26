package edu.vm.controller;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.vm.RideShareApp;
import edu.vm.view.RSMainPage;

public class RSMainCtrl extends RSBaseController implements ActionListener
{
    public RSMainCtrl(RideShareApp rideShareApp)
	{
        super(rideShareApp, null, new RSMainPage());
        RSMainPage rsMainPage = (RSMainPage)view;
        rsMainPage.getAbout().setIcon(rideShareApp.IMG_ABOUT);
        rsMainPage.getCreateOrCancelRide().setIcon(rideShareApp.IMG_CREATE_RIDE);
        rsMainPage.getExit().setIcon(rideShareApp.IMG_EXIT);
        rsMainPage.getReports().setIcon(rideShareApp.IMG_REPORTS);
        rsMainPage.getViewRides().setIcon(rideShareApp.IMG_VIEW_RIDES);
        rsMainPage.getLogin().setIcon(rideShareApp.IMG_LOGIN);
        rsMainPage.getRegister().setIcon(rideShareApp.IMG_REGISTER);
        rsMainPage.getViewRouteMap().setIcon(rideShareApp.IMG_ROUTE_MAP);
        
        rsMainPage.getLogin().addActionListener(this);
        rsMainPage.getRegister().addActionListener(this);
        rsMainPage.getViewRides().addActionListener(this);
        rsMainPage.getExit().addActionListener(this);
        rsMainPage.getReports().addActionListener(this);
        rsMainPage.getCreateOrCancelRide().addActionListener(this);
        rsMainPage.getViewRouteMap().addActionListener(this);
        rsMainPage.getAbout().addActionListener(this);
        
        rsMainPage.addWindowListener(new WindowAdapter()
		                                {
                                            @Override
											public void windowClosing(WindowEvent we)
											{
												System.exit(0);
											}
										});
	}

    public boolean isRideCancelOn()
    {
        return ((RSMainPage)view).getCreateOrCancelRide().getText().equals("Cancel Ride");
    }
    
    public void switchToLoggedInPerspective(String loggedInUserId, String profilePicturePath)
    {
        RSMainPage rsMainPage = (RSMainPage)view;
        ImageIcon profilePicture = new ImageIcon(new ImageIcon(profilePicturePath).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
       
        rsMainPage.getWelcome().setText(rsMainPage.getWelcome().getText().replaceAll("  ", " " + loggedInUserId + " "));
        rsMainPage.getWelcome().setIcon(profilePicture);
        rsMainPage.getLogin().setVisible(false);
        rsMainPage.getCreateOrCancelRide().setVisible(true);
        rsMainPage.getRegister().setVisible(false);
        rsMainPage.getViewRides().setVisible(true);
        if(null != rideShareApp.getRideModel() && null != rideShareApp.getRideModel().getRideGiver())
        {
            setCreateToCancel();
        }
    }
    
    public void setCreateToCancel()
    {
        ((RSMainPage)view).getCreateOrCancelRide().setText("Cancel Ride");
        ((RSMainPage)view).getCreateOrCancelRide().setBackground(Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        RSMainPage rsMainPage = (RSMainPage) view;
        if(source == rsMainPage.getViewRides())
        {
            rideShareApp.getRsViewRidesCtrl().show();
        }
        else if(source == rsMainPage.getExit())
        {
            System.exit(0);
        }
        else if(source == rsMainPage.getReports())
        {
            rideShareApp.getRsReportCtrl().show();
        }
        else if(source == rsMainPage.getCreateOrCancelRide())
        {
            String rideActionType = rsMainPage.getCreateOrCancelRide().getText();
            if(rideActionType.equals("Cancel Ride"))
            {
                String startLocation = rideShareApp.getRideModel().getStartLocation();
                int result = JOptionPane.showConfirmDialog(((RSMainPage)view), "Are you sure, you want to cancel the ride: " + startLocation + " --> PICT!", "Ride Cancel", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        PersistencyService.removeRide(rideShareApp.getLoggedInRiderModel());
                        rsMainPage.getCreateOrCancelRide().setText("Create Ride");
                    }
                    catch (Exception ex)
                    {
                       ex.printStackTrace();
                    }
                }
                return;
            }
            else
            {
                rideShareApp.getRsCreateRideCtrl().show();
            }
        }
        else if(source == rsMainPage.getLogin())
        {
            rideShareApp.getRsLoginCtrl().show();
        }
        else if(source == rsMainPage.getRegister())
        {
            rideShareApp.getRsRegisterCtrl().show();
        }
        else if(source == rsMainPage.getViewRouteMap())
        {
            rideShareApp.getRsViewRouteMapCtrl().show();
        }
        else if(source == rsMainPage.getAbout())
        {
            rideShareApp.getRsAboutCtrl().show();
        }
    }
}
