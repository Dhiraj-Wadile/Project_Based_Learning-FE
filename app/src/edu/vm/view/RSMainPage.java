package edu.vm.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class RSMainPage extends RSBaseView
{
	/**
     *  View Rides [ Join ] , Create Ride, Exit Application, Reports
     */
    private static final long serialVersionUID = -5643167111537653721L;

    public RSMainPage()
	{
        super("Ride Share - Main");
        cmdExit.setDefaultCapable(true);
		getRootPane().setDefaultButton(cmdExit);

		setSize(new Dimension(600, 300));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        
        cmdWelcome.setText("Welcome  to Ride Share Application.\nYour one stop shop for all your smart travel needs");
        cmdWelcome.setBorder(BorderFactory.createEmptyBorder());
        
        getContentPane().add(cmdWelcome, gbc);

		gbc.gridy = 1;
		gbc.gridwidth = 1;
		        
		getContentPane().add(cmdLogin,gbc);
		cmdCreateOrCancelRide.setVisible(false);
		getContentPane().add(cmdCreateOrCancelRide,gbc);
		
		gbc.gridx = 1;

        getContentPane().add(cmdRegister,gbc);
        cmdViewRides.setVisible(false);
        getContentPane().add(cmdViewRides,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        getContentPane().add(cmdViewRouteMap,gbc);

        gbc.gridx = 1;

		getContentPane().add(cmdReports,gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 3;
        getContentPane().add(cmdAbout,gbc);
        
		gbc.gridx = 1;

		getContentPane().add(cmdExit,gbc);
    }

    public JButton getViewRides()
    {
        return cmdViewRides;
    }
    
    public JButton getCreateOrCancelRide()
    {
        return cmdCreateOrCancelRide;
    }
    
    public JButton getReports()
    {
        return cmdReports;
    }
    
    public JButton getExit()
    {
        return cmdExit;
    }
    
    public JButton getWelcome()
    {
        return cmdWelcome;
    }
    
    public JLabel getProfilePhoto()
    {
        return jlblProfilePhoto;
    }
    
    public JButton getAbout()
    {
        return cmdAbout;
    }
    
    public JButton getLogin()
    {
        return cmdLogin;
    }
    
    public JButton getRegister()
    {
        return cmdRegister;
    }
    
    public JButton getViewRouteMap()
    {
        return cmdViewRouteMap;
    }

    private JLabel jlblProfilePhoto = new JLabel();
    private JButton cmdWelcome = new JButton("Welcome");
    private JButton cmdLogin = new JButton("Login");
    private JButton cmdRegister = new JButton("Register");
    private JButton cmdCreateOrCancelRide = new JButton("Create Ride");
    private JButton cmdViewRides = new JButton("View Rides");
    private JButton cmdViewRouteMap = new JButton("Route Maps");
	private JButton cmdReports = new JButton("Reports");
    private JButton cmdAbout = new JButton("About");
	private JButton cmdExit = new JButton("Exit Application");
}
