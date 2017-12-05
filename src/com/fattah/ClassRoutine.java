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

import javax.swing.*;

import com.conn.ConnPro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClassRoutine extends JFrame implements ActionListener {
	
	JLabel  name,id,pass,head;
    JButton done_but;
    JPanel main_panel,done_but_panel,form_panel,heading_panel;
    JTextField name_txt,id_txt;
    JPasswordField pwd;

	
	ClassRoutine()
	{
		setSize(600,500);
	    setVisible(true);
	    setLayout(new FlowLayout());
	  
        main_panel=new JPanel(); 
        main_panel.setLayout(new BorderLayout(10,10));
        heading_panel=new JPanel();
        head= new JLabel("SignUp Page");
        heading_panel.add(head);
        form_panel=new JPanel(); 
        form_panel.setLayout(new GridLayout(3,2,5,5));
        name= new JLabel("User Name:");
        id= new JLabel("ID:");
        pass= new JLabel("Password:");
        
        name_txt=new JTextField(20);
        id_txt=new JTextField(20);
        pwd=new JPasswordField(20);
        
        done_but_panel=new JPanel(); 
        done_but_panel.setLayout(new FlowLayout());
        done_but=new JButton("Done");
        
        done_but_panel.add(done_but);
        form_panel.add(name);
        form_panel.add(name_txt);
        form_panel.add(id);
        form_panel.add(id_txt);
        form_panel.add(pass);
        form_panel.add(pwd);

        main_panel.add(heading_panel,BorderLayout.NORTH);
        main_panel.add(form_panel,BorderLayout.CENTER);
        main_panel.add(done_but_panel,BorderLayout.SOUTH);
         
        add(main_panel);
        done_but.addActionListener(this);  
         
  }


	@Override
		
		 public void actionPerformed(ActionEvent ae)
         {
                   String act=ae.getActionCommand();
                   if(act.equals(done_but.getLabel()))
                         {
                                 String name=name_txt.getText();                                         
                                 int id=Integer.parseInt(id_txt.getText());
                                 String pass=pwd.getText(); 
                                
                                 try{
                                	 Connection con=ConnPro.getConn();      
                                     PreparedStatement ps=con.prepareStatement("insert into STUDENT_REG values(?,?,?)");
                                     ps.setString(1,name);
                                     ps.setInt(2,id);
                                     ps.setString(3,pass);
                                     ps.executeQuery();
                                     JOptionPane.showMessageDialog(this,"Successfully Registered....");
                                      }catch(Exception e)
                                            {
                                                  System.out.println("Error in Data Base:"+e);
                                            }
                                    
                         }
                                  
                   
         }

		
}
	    



