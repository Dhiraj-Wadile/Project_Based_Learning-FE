package edu.vm;

import java.awt.Image;

import javax.swing.ImageIcon;

import edu.vm.controller.RSAboutCtrl;
import edu.vm.controller.RSCreateRideCtrl;
import edu.vm.controller.RSLoginCtrl;
import edu.vm.controller.RSMainCtrl;
import edu.vm.controller.RSRegisterCtrl;
import edu.vm.controller.RSReportCtrl;
import edu.vm.controller.RSViewRidesCtrl;
import edu.vm.controller.RSViewRouteMapCtrl;
import edu.vm.model.RideModel;
import edu.vm.model.RiderModel;

public class RideShareApp
{
    public static final String rideShareFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "RideShare";

    public final ImageIcon IMG_LOGIN;
    public final ImageIcon IMG_REGISTER;
    public final ImageIcon IMG_ABOUT;
    public final ImageIcon IMG_EXIT;
    public final ImageIcon IMG_CREATE_RIDE;
    public final ImageIcon IMG_CANCEL_RIDE;
    public final ImageIcon IMG_ROUTE_MAP;
    public final ImageIcon IMG_VIEW_RIDES;
    public final ImageIcon IMG_REPORTS;
    public final ImageIcon IMG_REQUEST_RIDE;
    public final ImageIcon IMG_REPORT_TREND;
    public final ImageIcon IMG_REPORT_VEHICLE;
    
    private RideModel rideModel;
    private RSMainCtrl rsMainCtrl;
    private RSCreateRideCtrl rsCreateRideCtrl;
    private RSLoginCtrl rsLoginCtrl;
    private RSRegisterCtrl rsRegisterCtrl;
    private RSViewRidesCtrl rsViewRidesCtrl;
    private RSReportCtrl rsReportCtrl;
    private RSViewRouteMapCtrl rsViewRouteMapCtrl;
    private RSAboutCtrl rsAboutCtrl;
    
    
    public RideShareApp()
    {
        IMG_LOGIN = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Login.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_REGISTER = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Register.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_ABOUT = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Logo.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_EXIT = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Exit.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_CREATE_RIDE = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/CreateRide.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_CANCEL_RIDE = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/CancelRide.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_ROUTE_MAP = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/ViewRouteMap.png")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_VIEW_RIDES = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/ViewRides.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_REPORTS = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Reports.png")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_REQUEST_RIDE = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/RequestRide.jpeg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        IMG_REPORT_TREND = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Co2Trend.png")).getImage().getScaledInstance(601, 301, Image.SCALE_SMOOTH));
        IMG_REPORT_VEHICLE = new ImageIcon(new ImageIcon(this.getClass().getResource("resources/Co2Vehicle.png")).getImage().getScaledInstance(601, 301, Image.SCALE_SMOOTH));
        rideModel = new RideModel();
    }
    
    public static void main(String[] args)
	{
        RideShareApp rsa = new RideShareApp();
        rsa.getRsMainCtrl().show();
	}
    
    public final RideModel getRideModel()
    {
        return rideModel;
    }
    
    public final void setRideModel(RideModel rideModel)
    {
        this.rideModel = rideModel;
    }
    

    public final ImageIcon getLoginImage()
    {
        return IMG_LOGIN;
    }
    
    public final ImageIcon getRegisterImage()
    {
        return IMG_REGISTER;
    }
    
    public final ImageIcon getAboutImage()
    {
        return IMG_ABOUT;
    }
    
    public final ImageIcon getExitImage()
    {
        return IMG_EXIT;
    }
    
    public final ImageIcon getCreateRideImage()
    {
        return IMG_CREATE_RIDE;
    }
    
    public final ImageIcon getCancelRideImage()
    {
        return IMG_CANCEL_RIDE;
    }
    
    public final ImageIcon getRoutMapImage()
    {
        return IMG_ROUTE_MAP;
    }
    
    public final ImageIcon getViewRidesImage()
    {
        return IMG_VIEW_RIDES;
    }
    
    public final ImageIcon getReportsImage()
    {
        return IMG_REPORTS;
    }
    
    public final ImageIcon getRequestRideImage()
    {
        return IMG_REQUEST_RIDE;
    }
    
    public RSMainCtrl getRsMainCtrl()
    {
        if(null == rsMainCtrl)
        {
            rsMainCtrl = new RSMainCtrl(this);
        }
        return rsMainCtrl;
    }

    public void setRsMainCtrl(RSMainCtrl rsMainCtrl)
    {
        this.rsMainCtrl = rsMainCtrl;
    }

    public RSCreateRideCtrl getRsCreateRideCtrl()
    {
        if( null == rsCreateRideCtrl)
        {
            rsCreateRideCtrl = new RSCreateRideCtrl(this);
        }
        return rsCreateRideCtrl;
    }

    public void setRsCreateRideCtrl(RSCreateRideCtrl rsCreateRideCtrl)
    {
        this.rsCreateRideCtrl = rsCreateRideCtrl;
    }

    public RSLoginCtrl getRsLoginCtrl()
    {
        if(null == rsLoginCtrl)
        {
            rsLoginCtrl = new RSLoginCtrl(this, null);
        }
        return rsLoginCtrl;
    }

    public void setRsLoginCtrl(RSLoginCtrl rsLoginCtrl)
    {
        if(null == this.rsLoginCtrl)
        {
            this.rsLoginCtrl = rsLoginCtrl;
        }
    }

    public RSRegisterCtrl getRsRegisterCtrl()
    {
        if( null == rsRegisterCtrl)
        {
            rsRegisterCtrl = new RSRegisterCtrl(this);
        }
        return rsRegisterCtrl;
    }

    public void setRsRegisterCtrl(RSRegisterCtrl rsRegisterCtrl)
    {
        this.rsRegisterCtrl = rsRegisterCtrl;
    }

    public RSViewRidesCtrl getRsViewRidesCtrl()
    {
        if(null == rsViewRidesCtrl)
        {
            rsViewRidesCtrl = new RSViewRidesCtrl(this);
        }
        return rsViewRidesCtrl;
    }

    public void setRsViewRidesCtrl(RSViewRidesCtrl rsViewRidesCtrl)
    {
        this.rsViewRidesCtrl = rsViewRidesCtrl;
    }
    
    public RiderModel getLoggedInRiderModel()
    {
        return getRsLoginCtrl().getRiderModel();
    }

    public RSReportCtrl getRsReportCtrl()
    {
        if(null == rsReportCtrl)
        {
            rsReportCtrl = new RSReportCtrl(this);
        }
        return rsReportCtrl;
    }

    public void setRsReportCtrl(RSReportCtrl rsReportCtrl)
    {
        this.rsReportCtrl = rsReportCtrl;
    }

    public RSViewRouteMapCtrl getRsViewRouteMapCtrl()
    {
        if(null == rsViewRouteMapCtrl)
        {
            rsViewRouteMapCtrl = new RSViewRouteMapCtrl(this);
        }
        return rsViewRouteMapCtrl;
    }

    public void setRsViewRouteMapCtrl(RSViewRouteMapCtrl rsViewRouteMapCtrl)
    {
        this.rsViewRouteMapCtrl = rsViewRouteMapCtrl;
    }
    
    public RSAboutCtrl getRsAboutCtrl()
    {
        if(null == rsAboutCtrl)
        {
            rsAboutCtrl = new RSAboutCtrl(this);
        }
        return rsAboutCtrl;
    }

    public void setRsAboutCtrl(RSAboutCtrl rsAboutCtrl)
    {
        this.rsAboutCtrl = rsAboutCtrl;
    }
}
