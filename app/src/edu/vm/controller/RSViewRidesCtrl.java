package edu.vm.controller;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.vm.RideShareApp;
import edu.vm.view.RSViewRidesPage;

public class RSViewRidesCtrl extends RSBaseController
{
    private final Image imgHadapsar = new ImageIcon(getClass().getResource("../resources/Hadapsar.png")).getImage().getScaledInstance(600, 600, BufferedImage.TYPE_INT_RGB);
    private final Image imgNigdi = new ImageIcon(getClass().getResource("../resources/Nigdi.png")).getImage().getScaledInstance(600, 600, BufferedImage.TYPE_INT_RGB);
    private final Image imgKothrud = new ImageIcon(getClass().getResource("../resources/Kothrud.png")).getImage().getScaledInstance(600, 600, BufferedImage.TYPE_INT_RGB);

    public RSViewRidesCtrl(RideShareApp parent)
	{
        super(parent, null, new RSViewRidesPage());
        RSViewRidesPage vrp = ((RSViewRidesPage)view);
        JTable jtbl = vrp.getViewRides();
        String data[][]={ {"Amit","Ankita","Hadpasar"},    
                {"Ramya","Jai","Kothrud"},    
                {"Vishakha","Abhilasha","Nigdi"}};    
        String column[]={"Ride Giver","Ride Taker","Start Location"};         
        final JTable jt=new JTable(data,column);    
        jt.setCellSelectionEnabled(true);  

        jtbl.setModel(new DefaultTableModel(data, column));
	}
}
