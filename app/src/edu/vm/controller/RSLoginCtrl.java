package edu.vm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.vm.RideShareApp;
import edu.vm.model.RiderModel;
import edu.vm.view.RSLoginPage;

public class RSLoginCtrl extends RSBaseController implements ActionListener, DocumentListener
{
    public RSLoginCtrl(RideShareApp parent, RiderModel riderModel)
	{
        super(parent, riderModel, new RSLoginPage());
        ((RSLoginPage)view).getLoginButton().addActionListener(this);
        ((RSLoginPage)view).getUID().getDocument().addDocumentListener(this);
        ((RSLoginPage)view).getPWD().getDocument().addDocumentListener(this);
	}

    public RiderModel getRiderModel()
    {
        return (RiderModel)model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        doLogin();
    }

    public void doLogin()
    {
        try
        {
            RSLoginPage rsLoginPage = (RSLoginPage)view;
            List<RiderModel> riderModels = PersistencyService.getAllRiders();
            String loginUserId = rsLoginPage.getUID().getText();
            String loginPwd = rsLoginPage.getPWD().getText();
            for(int i=0; i<riderModels.size(); i++)
            {
                RiderModel riderModel = riderModels.get(i);
                if(riderModel.getUserId().equals(loginUserId))
                {
                    if(riderModel.getPassword().equals(loginPwd))
                    {
                        model = riderModel; // Very Important !!
                        // Check if the logged-in user already has a ride going on, if so then set the cancel button on
                        rideShareApp.setRideModel(PersistencyService.getRide(riderModel));
                        rideShareApp.getRsMainCtrl().switchToLoggedInPerspective(riderModel.getUserId(), riderModel.getPhotoFilePath());
                        hide();
                        return;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rsLoginPage,"Incorrect password entered for user : " + loginUserId,"Invalid Password", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(rsLoginPage,"Invaid user : " + loginUserId, "Invalid User", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void enableLogin()
    {
        RSLoginPage rsLoginPage = (RSLoginPage)view;
        rsLoginPage.getLoginButton().setEnabled(
                !rsLoginPage.getPWD().getText().equals("") &&
                !rsLoginPage.getUID().getText().equals(""));
    }

    @Override
    public void changedUpdate(DocumentEvent arg0)
    {
        enableLogin();
    }

    @Override
    public void insertUpdate(DocumentEvent arg0)
    {
        enableLogin();
    }

    @Override
    public void removeUpdate(DocumentEvent arg0)
    {
        enableLogin();
    }

    public void setRiderModel(RiderModel riderModel)
    {
        model = riderModel;
    }
}
