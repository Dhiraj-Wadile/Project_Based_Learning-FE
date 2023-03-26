package edu.vm.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RSAboutPage extends RSBaseView
{
	/**
     *  View Rides [ Join ] , Create Ride, Exit Application, Reports
     */
    private static final long serialVersionUID = -5643167111537653721L;

    public RSAboutPage()
	{
        super("Ride Share - About");

		setSize(new Dimension(600, 300));
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
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        
        txtAbout.setText("Ride Share Application is one stop shop for all smart travel needs\nIt allows user to create, cancel, view"
                + "Rides.\nIt shows how the carbon footprint of emission is controlled.\nIt is safe, secure, and environment friendly.");
        ImageIcon profilePicture = new ImageIcon(new ImageIcon(this.getClass().getResource("../resources/Vishakha.jpg")).getImage().getScaledInstance(51, 51, Image.SCALE_SMOOTH));
        jlblAuthorPhoto.setIcon(profilePicture);
        getContentPane().add(jlblAuthorPhoto, gbc);
        txtAbout.setEnabled(false);
        jlblAuthorPhoto.setLabelFor(txtAbout);
		gbc.gridx = 1;
		jlblAuthorPhoto.setVisible(false);
		getContentPane().add(txtAbout,gbc);
    }

    private JLabel jlblAuthorPhoto = new JLabel();
    private JTextArea txtAbout = new JTextArea(5,1);
}
