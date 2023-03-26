package edu.vm.controller;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import edu.vm.RideShareApp;
import edu.vm.view.RSReportPage;

public class RSReportCtrl extends RSBaseController implements ActionListener
{
    private final Image imgTrend = new ImageIcon(getClass().getResource("../resources/Co2Trend.png")).getImage().getScaledInstance(600, 600, BufferedImage.TYPE_INT_RGB);
    private final Image imgVehicle = new ImageIcon(getClass().getResource("../resources/Co2Vehicle.png")).getImage().getScaledInstance(600, 600, BufferedImage.TYPE_INT_RGB);

    public RSReportCtrl(RideShareApp parent)
	{
        super(parent, null, new RSReportPage());
        JComboBox<String> cbo = ((RSReportPage)view).getCombo();
        cbo.addItem("Trends");
        cbo.addItem("Vehicle");
        ((RSReportPage)view).getLabel().setIcon(new ImageIcon(imgTrend));
        cbo.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        JComboBox<String> cbo = ((RSReportPage)view).getCombo();
        JLabel lbl = ((RSReportPage)view).getLabel();
        if(((String) cbo.getSelectedItem()).equals("Trends"))
        {
            lbl.setIcon(new ImageIcon(imgTrend));
        }
        else if(((String) cbo.getSelectedItem()).equals("Vehicle"))
        {
            lbl.setIcon(new ImageIcon(imgVehicle));
        }
    }
}
