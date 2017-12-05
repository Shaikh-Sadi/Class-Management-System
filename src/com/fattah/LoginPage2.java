/*package com.fattah;

import javax.swing.JFrame;

public class ClassRoutine extends JFrame {

	  public ClassRoutine()
	  {
		  setSize(600,600);
		  setVisible(true);
	  }
}*/

package com.fattah;



import java.awt.*;
import javax.swing.*;

import com.conn.ConnPro;

import java.awt.event.*;


import java.sql.*;




public class LoginPage2 extends JFrame implements ActionListener
{
    JLabel l_name,l_pass;
    JTextField t_name;
    JPasswordField t_pass;     
    JButton button,back_page_but;
    Container c;
    Database db;
 
    LoginPage2()
    {
        super("Login form");
        c=getContentPane();
        c.setLayout(new FlowLayout());
        db=new Database();
        l_name=new JLabel("Username");
        l_pass=new JLabel("Password");
        t_name=new JTextField(10);
        t_pass=new JPasswordField(10);
        button=new JButton("Login");
        back_page_but=new JButton("Back to Home");
        button.addActionListener(this);
        back_page_but.addActionListener(this);
        c.add(l_name);
        c.add(t_name);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        c.add(back_page_but);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
 
    }
  
        public void actionPerformed(ActionEvent ae)
        {
        	if(ae.getSource()==back_page_but)
        		
        	{
        		new HomePage().setVisible(true);
        		this.setVisible(false);
        	}
        	
            if(ae.getSource()==button)
            {
                String pass=t_pass.getText();
                if(db.checkLogin(t_name.getText(), pass))
                {
                	new JTab2().setVisible(true);
                	 
    				 this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
		
   public class Database 
    {
       Connection con;
       PreparedStatement pst;
       ResultSet rs;
       Database()
    {
        try{
           con=ConnPro.getConn();
           pst=con.prepareStatement("select * from STUDENT_REG where name=? and pass=?");  
           }
        catch (Exception e) 
        {
        	 
            System.out.println(e);
        }
    }
    public Boolean checkLogin(String name,String pass)
    {
        try {
                        
            pst.setString(1, name); 
            pst.setString(2, pass);   
            rs=pst.executeQuery();
            if(rs.next())
            {
                
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error while validating"+e);
            return false;
        }
    }
}
}

	



