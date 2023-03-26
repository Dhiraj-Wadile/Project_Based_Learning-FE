package edu.vm.controller;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import edu.vm.RideShareApp;
import edu.vm.view.RSViewRouteMapPage;

public class RSViewRouteMapCtrl extends RSBaseController implements ActionListener
{
    private final Image imgHadapsar = new ImageIcon(getClass().getResource("../resources/Hadapsar.png")).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
    private final Image imgNigdi = new ImageIcon(getClass().getResource("../resources/Nigdi.png")).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
    private final Image imgKothrud = new ImageIcon(getClass().getResource("../resources/Kothrud.png")).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);

    public RSViewRouteMapCtrl(RideShareApp parent)
	{
        super(parent, null, new RSViewRouteMapPage());
        RSViewRouteMapPage viewRouteMapPage = (RSViewRouteMapPage) view;
        JComboBox<String> cbo = viewRouteMapPage.getCombo();
        cbo.addItem("Route 1: Hadapsar --> PICT");
        cbo.addItem("Route 2: Nigdi    --> PICT");
        cbo.addItem("Route 3: Kothrud  --> PICT");
        viewRouteMapPage.getLabel().setIcon(new ImageIcon(imgHadapsar));
        cbo.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        RSViewRouteMapPage viewRouteMapPage = (RSViewRouteMapPage) view;
        JComboBox<String> cbo = viewRouteMapPage.getCombo();
        JLabel lbl = viewRouteMapPage.getLabel();
        if(-1 != ((String) cbo.getSelectedItem()).indexOf("Hadapsar"))
        {
            lbl.setIcon(new ImageIcon(imgHadapsar));
        }
        else if(-1 != ((String) cbo.getSelectedItem()).indexOf("Nigdi"))
        {
            lbl.setIcon(new ImageIcon(imgNigdi));
        }
        else if(-1 != ((String) cbo.getSelectedItem()).indexOf("Kothrud"))
        {
            lbl.setIcon(new ImageIcon(imgKothrud));
        }
    }
}
