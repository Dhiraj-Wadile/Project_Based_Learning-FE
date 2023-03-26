package edu.vm.model;

public class RiderModel extends RSBaseModel
{
    /**
     * 
     */
    private static final long serialVersionUID = 2773165071374813617L;
    private String name;
    private String userId;
    private String password;
    private String cell;
    private String address;
    private String pinCode;
    private String photoFilePath;
    private boolean isGiver; // True if Giver, False if Taker
    
    public String getCell()
    {
        return cell;
    }
    
    public void setCell(String cell)
    {
        this.cell = cell;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPinCode()
    {
        return pinCode;
    }
    
    public void setPinCode(String pinCode)
    {
        this.pinCode = pinCode;
    }
    
    public String toString()
    {
        return userId + "-" + name + "-" + address + "-" + pinCode + "-" + cell;
    }
    
    public String getPhotoFilePath()
    {
        return photoFilePath;
    }
    
    public void setPhotoFilePath(String photoFilePath)
    {
        this.photoFilePath = photoFilePath;
    }
    
    public void setGiver(boolean isGiver)
    {
        this.isGiver = isGiver;
    }
    
    public boolean isGiver()
    {
        return isGiver;
    }
}
