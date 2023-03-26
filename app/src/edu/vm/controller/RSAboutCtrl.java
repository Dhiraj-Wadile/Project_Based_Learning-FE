package edu.vm.controller;
import edu.vm.RideShareApp;
import edu.vm.view.RSAboutPage;

public class RSAboutCtrl extends RSBaseController
{
    public RSAboutCtrl(RideShareApp rideShareApp)
	{
        super(rideShareApp, null, new RSAboutPage());
	}
}