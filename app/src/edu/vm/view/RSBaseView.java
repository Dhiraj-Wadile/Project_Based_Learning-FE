package edu.vm.view;

import javax.swing.JFrame;

public abstract class RSBaseView extends JFrame implements IViewConstants
{
    /**
     * 
     */
    private static final long serialVersionUID = 1739743778638779256L;

    public RSBaseView()
    {
        super();
    }
    
    public RSBaseView(String s)
    {
        super(s);
    }
}
