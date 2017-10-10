package PANCHA;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.*;


public class Input_Frame extends JFrame {
	
	public JPanel jp = new JPanel();
    public JLabel jl = new JLabel();
    public JTextField jt = new JTextField(30);
    public JButton jb = new JButton("Enter");
    public String YEAR_INPUT;
    public JTextField YEAR_EPOCH, MONTH_EPOCH;
    String YEAR_II;
    public Input_Frame( String INPUT_YEAR)
    {
           setTitle("INPUT");
           setVisible(true);
           setSize(800, 600);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           
           JFrame rect = new JFrame("Input Information");
           rect.setSize(200, 200);
           rect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
          
         
           YEAR_EPOCH = new JTextField(5);
        
           
           
           MONTH_EPOCH = new JTextField(5);
           
           jp.add(YEAR_EPOCH);
           jp.add(MONTH_EPOCH); 

           jp.add(jt);

           jt.addActionListener(new ActionListener()
           {
        	   
        	   
                  public void actionPerformed(ActionEvent e)
                  {
                        String input = jt.getText();
                        jl.setText(input); 
                  }
           });
           jp.add(jb);
           jb.addActionListener(new ActionListener()
           {
                   public void actionPerformed(ActionEvent e)
                   {
                          String input = jt.getText();
                          //jl.setText(input);
                         
                          YEAR_INPUT = input;
                          System.out.println(  "  INPUT    _    YEAR = " + YEAR_INPUT);
                          
                          
                   }
                   
                   public String get() 
                   { 
                   return jt.getText(); 

                   } 
                   
                    
                   
           });
           
           jp.add(jl);
           add(jp);
           
       System.out.println(  "  YEAR _  INPUT = " + YEAR_INPUT);
       //System.out.println(  "  YEAR _  INPUT = " + jt.get());
           
    }
	
   
    
    
    
   
    
    public String get_YEAR_INPUT() {
    	System.out.println(  "  YEAR _  INPUT = " + YEAR_INPUT);
		return YEAR_INPUT;					// Return Input
	}

}
