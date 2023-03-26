package edu.vm.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RSRegisterPage extends RSBaseView
{
	/**
     * 
     */
    private static final long serialVersionUID = -5643167111537653721L;
    
    public RSRegisterPage()
	{
        super("Ride Share - Register");

        cmdRegister.setDefaultCapable(true);
        cmdRegister.setEnabled(false);
		getRootPane().setDefaultButton(cmdRegister);
		cmdRegister.setForeground(Color.BLUE);

		setSize(new Dimension(400,300));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

        JLabel jlblUID = new JLabel("UserID:");
        jlblUID.setLabelFor(txtUID);

        gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;

		getContentPane().add(jlblUID,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		getContentPane().add(txtUID,gbc);

        JLabel jPWD = new JLabel("Password:");
        jPWD.setLabelFor(txtPWD);

        gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(jPWD,gbc);
		
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(txtPWD,gbc);
        
        JLabel jlblName = new JLabel("Full Name:");
        jlblName.setLabelFor(txtName);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(jlblName,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(txtName,gbc);

        JLabel jlblCell = new JLabel("Mobile Number:");
        jlblCell.setLabelFor(txtCell);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(jlblCell,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(txtCell,gbc);

        JLabel jlblAdd = new JLabel("Address:");
        jlblAdd.setLabelFor(txtALoc);
        
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;

		getContentPane().add(jlblAdd,gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 5;
		gbc.insets = FIVE_PAD_INSETS;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(txtALoc,gbc);

        JLabel jlblZip = new JLabel("ZipCode:");
        jlblZip.setLabelFor(spinPin);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(jlblZip,gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(spinPin,gbc);

        JLabel jlblPhoto = new JLabel("Photo:");
        jlblPhoto.setLabelFor(cmdPhoto);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(jlblPhoto,gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        jlblPhotoPreview.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jlblPhotoPreview.setPreferredSize(new Dimension(100, 100));
        getContentPane().add(jlblPhotoPreview,gbc);

        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;

        getContentPane().add(cmdPhoto,gbc);

        gbc.gridx = 2;
        gbc.gridy = 17;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        getContentPane().add(cmdRegister,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.REMAINDER;

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setBorder(BorderFactory.createEtchedBorder());
        sep.setBackground(Color.BLACK);
        getContentPane().add(sep,gbc);
    }

	private	JTextField txtUID = new JTextField();
	private	JPasswordField txtPWD = new JPasswordField();
	private JTextField txtName = new JTextField();
	private JTextField txtCell = new JTextField();
	private JSpinner spinPin = new JSpinner();
	private JTextArea txtALoc = new JTextArea(5,1);
	private JLabel jlblPhotoPreview = new JLabel();
	private JButton cmdPhoto = new JButton("...");
	private JButton cmdRegister = new JButton("Register");

	public JSpinner getSpinner()
	{
	    return spinPin;
	}
	
	public JButton getPhoto()
	{
	    return cmdPhoto;
	}
	
	public JLabel getPhotoPreviewLabel()
	{
	    return jlblPhotoPreview;
	}
	
	public JTextArea getAddress()
	{
	    return txtALoc;
	}
	
	public JButton getRegisterButton()
	{
	    return cmdRegister;
	}
	
	public JTextField getUID()
	{
	    return txtUID;
	}
	
	public JTextField getPWD()
	{
	    return txtPWD;
	}
	
	public JTextField getNameTF()
	{
	    return txtName;
	}
	
	public JSpinner getPinCode()
	{
	    return spinPin;
	}

    public JTextField getCell()
    {
        return txtCell;
    }
}
