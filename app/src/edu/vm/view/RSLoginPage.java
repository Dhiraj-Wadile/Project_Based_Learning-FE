package edu.vm.view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class RSLoginPage extends RSBaseView
{
	/**
     *  View Rides [ Join ] , Create Ride, Exit Application, Reports
     */
    private static final long serialVersionUID = -5643167111537653721L;
    public RSLoginPage()
	{
        super("Ride Share - Login");

		cmdLogin.setDefaultCapable(true);
		cmdLogin.setEnabled(false);
		getRootPane().setDefaultButton(cmdLogin);

		setSize(new Dimension(300,200));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel jlblUID = new JLabel("UserID:");
		jlblUID.setLabelFor(txtUID);
		getContentPane().add(jlblUID,gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;

		getContentPane().add(txtUID,gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		JLabel jPWD = new JLabel("Password:");
		getContentPane().add(jPWD,gbc);
		jPWD.setLabelFor(txtPWD);
		
		gbc.gridx = 1;
		gbc.gridy = 1;

		getContentPane().add(txtPWD,gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;

		getContentPane().add(cmdLogin,gbc);

    }

	private	JTextField txtUID = new JTextField();
	private	JPasswordField txtPWD = new JPasswordField();
	private JButton cmdLogin = new JButton("Login");
	public JButton getLoginButton()
	{
	    return cmdLogin;
	}
	
	public JTextField getUID()
	{
	    return txtUID;
	}
	
	public JTextField getPWD()
	{
	    return txtPWD;
	}
}
