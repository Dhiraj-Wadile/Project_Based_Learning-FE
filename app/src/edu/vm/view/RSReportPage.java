package edu.vm.view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RSReportPage extends RSBaseView
{
	/**
     *  
     */
    private static final long serialVersionUID = -5643167111537653721L;
    
    public RSReportPage()
	{
        super("Ride Share - Reports");

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
		
        cbo = new JComboBox<String>();
        getContentPane().add(cbo,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;

        lbl = new JLabel();
        
        getContentPane().add(lbl, gbc);
    }
    
    public JLabel getLabel()
    {
        return lbl;
    }
    
    public JComboBox<String> getCombo()
    {
        return cbo;
    }
    
    private JComboBox<String> cbo;
    private JLabel lbl;
}
