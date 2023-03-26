package edu.vm.view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RSViewRidesPage extends RSBaseView
{
	/**
     *  
     */
    private static final long serialVersionUID = -5643167111537653721L;
    
    public RSViewRidesPage()
	{
        super("Ride Share - View Rides");

		setSize(new Dimension(600,600));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

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
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
        getContentPane().add(new JScrollPane(viewRidesTable),gbc);
    }
    
    public JTable getViewRides()
    {
        return viewRidesTable;
    }
    
    private JTable viewRidesTable = new JTable();
}
