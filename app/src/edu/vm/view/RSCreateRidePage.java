package edu.vm.view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RSCreateRidePage extends RSBaseView
{
	/**
     * 
     */
    private static final long serialVersionUID = -5643167111537653721L;
    
    public RSCreateRidePage()
	{
        super("Ride Share - Create");

        setSize(new Dimension(300,900));
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
        
        lbl = new JLabel("Starting Point");
        getContentPane().add(lbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cbo = new JComboBox<String>();
        lbl.setLabelFor(cbo);
        getContentPane().add(cbo,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = FIVE_PAD_INSETS;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cmd = new JButton("Create");
        getContentPane().add(cmd,gbc);

	}
    
    public JLabel getLabel()
    {
        return lbl;
    }
    
    public JComboBox<String> getCombo()
    {
        return cbo;
    }
    
    public JButton getCmd()
    {
        return cmd;
    }

    private JComboBox<String> cbo;
    private JLabel lbl;
    private JButton cmd;
}
