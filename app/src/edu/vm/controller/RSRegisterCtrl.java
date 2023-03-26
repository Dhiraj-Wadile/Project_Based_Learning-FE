package edu.vm.controller;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.vm.RideShareApp;
import edu.vm.model.RideModel;
import edu.vm.model.RiderModel;
import edu.vm.view.RSRegisterPage;

public class RSRegisterCtrl extends RSBaseController implements ActionListener, DocumentListener
{
    public RSRegisterCtrl(RideShareApp rideShareApp)
	{
        super(rideShareApp, new RiderModel(), new RSRegisterPage());
        JSpinner zip = ((RSRegisterPage)view).getSpinner();
        SpinnerNumberModel model = new SpinnerNumberModel(411000, 411000, 411100, 1);
        zip.setModel(model);
        ((RSRegisterPage)view).getRegisterButton().addActionListener(this);
        ((RSRegisterPage)view).getUID().getDocument().addDocumentListener(this);
        ((RSRegisterPage)view).getPWD().getDocument().addDocumentListener(this);
        ((RSRegisterPage)view).getNameTF().getDocument().addDocumentListener(this);
        ((RSRegisterPage)view).getAddress().getDocument().addDocumentListener(this);
        ((RSRegisterPage)view).getCell().setText("9876543210");
        ((RSRegisterPage)view).getCell().getDocument().addDocumentListener(this);
        ((RSRegisterPage)view).getPhoto().addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == ((RSRegisterPage)view).getRegisterButton())
        {
            try
            {
                if(doRegister())
                {
                    RiderModel riderModel = (RiderModel) model;
                    RideModel rideModel = new RideModel();
                    rideModel.setRideGiver(riderModel);
                    rideShareApp.getRsMainCtrl().switchToLoggedInPerspective(riderModel.getUserId(), riderModel.getPhotoFilePath());
                    hide();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(source == ((RSRegisterPage)view).getPhoto())
        {
            try
            {
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(((RSRegisterPage)view));
                JLabel photoLabel = ((RSRegisterPage)view).getPhotoPreviewLabel();
                File f = jf.getSelectedFile();
                if( null == f)
                {
                    return;
                }
                BufferedReader br = new BufferedReader(new FileReader(f));
                int[] photoBytes = new int[(int)f.length()];
                for(int i=0; i<photoBytes.length; i++)
                {
                    photoBytes[i] = br.read();
                }
                br.close();
                ((RiderModel)model).setPhotoFilePath(jf.getSelectedFile().getAbsolutePath());
                Image ii = new ImageIcon(jf.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), BufferedImage.TYPE_INT_RGB);
                photoLabel.setIcon(new ImageIcon(ii));
                enableRegister();
            }
            catch( IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public boolean doRegister() throws IOException, ClassNotFoundException
    {
        String sCell = ((RSRegisterPage)view).getCell().getText();

        try
        {
            long cell = Long.parseLong(sCell);
            if( (cell<6000000000L) || (cell>9999999999L))
            {
                JOptionPane.showMessageDialog(((RSRegisterPage)view),"Incorrect Mobile number entered","Invalid Mobile Number", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(((RSRegisterPage)view),"Incorrect Mobile number entered","Invalid Mobile Number", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        ((RiderModel)model).setName(((RSRegisterPage)view).getNameTF().getText());
        ((RiderModel)model).setUserId(((RSRegisterPage)view).getUID().getText());
        ((RiderModel)model).setAddress(((RSRegisterPage)view).getAddress().getText());
        ((RiderModel)model).setPassword(((RSRegisterPage)view).getPWD().getText());
        ((RiderModel)model).setPinCode(((RSRegisterPage)view).getPinCode().getValue().toString());
        ((RiderModel)model).setCell(((RSRegisterPage)view).getCell().getText());
        if (null != JOptionPane.showInputDialog("Enter the OTP sent to your mobile: " + sCell))
        {
            PersistencyService.addRider(((RiderModel)model));
            return true;
        }
        else
        {
            return false;
        }
    }

    public void enableRegister()
    {
        ((RSRegisterPage)view).getRegisterButton().setEnabled(
                !((RSRegisterPage)view).getPWD().getText().equals("") &&
                !((RSRegisterPage)view).getUID().getText().equals("") &&
                !((RSRegisterPage)view).getAddress().getText().equals("") &&
                !((RSRegisterPage)view).getNameTF().getText().equals("") &&
                !((RSRegisterPage)view).getCell().getText().equals("") &&
                ((RSRegisterPage)view).getPhotoPreviewLabel().getIcon() != null);
    }

    @Override
    public void changedUpdate(DocumentEvent arg0)
    {
        enableRegister();
    }

    @Override
    public void insertUpdate(DocumentEvent arg0)
    {
        enableRegister();
    }

    @Override
    public void removeUpdate(DocumentEvent arg0)
    {
        enableRegister();
    }
}
