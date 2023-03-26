package edu.vm.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import edu.vm.RideShareApp;
import edu.vm.model.RSBaseModel;
import edu.vm.view.RSBaseView;

public abstract class RSBaseController
{
    protected RSBaseView view;
    protected RSBaseModel model;
    protected RideShareApp rideShareApp;
    
    public RSBaseController(RideShareApp rideShareApp, RSBaseModel model, RSBaseView view)
    {
        this.rideShareApp = rideShareApp;
        this.model = model;
        this.view = view;
        view.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                hide();
            }
        });
    }
    
    public void show()
    {
        view.pack();
        view.setVisible(true);
        if( view != rideShareApp.getRsMainCtrl().view)
        {
            rideShareApp.getRsMainCtrl().view.pack();
            rideShareApp.getRsMainCtrl().view.setVisible(false);
        }
    }
    
    public void hide()
    {
        view.pack();
        view.setVisible(false);
        if( view != rideShareApp.getRsMainCtrl().view)
        {
            rideShareApp.getRsMainCtrl().view.pack();
            rideShareApp.getRsMainCtrl().view.setVisible(true);
        }
    }
}
