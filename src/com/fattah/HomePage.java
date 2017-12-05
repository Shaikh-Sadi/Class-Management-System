package com.fattah;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{

        JLabel  heading,name,age,dob,gender,city;
        JButton class_route_but,class_lec_but,class_notice_but,class_attend_but,reg_but;
        JPanel main_panel,heading_panel,form_panel,reg_panel,gender_panel; 
	    HomePage(){
	    	
                setLayout(new FlowLayout());
                main_panel=new JPanel();  
                main_panel.setLayout(new BorderLayout(10,50));
                heading_panel=new JPanel();
                form_panel=new JPanel();
                form_panel.setLayout(new GridLayout(2,2,50,50));
                reg_panel=new JPanel();
                heading= new JLabel("Class Management System");
                heading_panel.add(heading);
                class_route_but=new JButton("Class Routine");
                class_lec_but=new JButton("Class Lecture Document");
                class_notice_but=new JButton("Class Notice Board");
                class_attend_but=new JButton("Class Attendence System");
                reg_but=new JButton("Create an Account ");
                form_panel.add(class_route_but);
                form_panel.add(class_lec_but);
                form_panel.add( class_notice_but);
                form_panel.add( class_attend_but);
                reg_panel.add(reg_but);
                main_panel.add(heading_panel,BorderLayout.NORTH);
                main_panel.add(form_panel,BorderLayout.CENTER);
                main_panel.add(reg_panel,BorderLayout.SOUTH);
                add(main_panel);
                reg_but.addActionListener(this);
                class_lec_but.addActionListener(this);
                class_route_but.addActionListener(this);
                class_attend_but.addActionListener(this);
                this.setSize(1100, 1100);
         }
	 
         public  void actionPerformed(ActionEvent ae){
		
		         if(ae.getSource()==reg_but){
			           new ClassRoutine().setVisible(true);
			           this.setVisible(false);
	             }
		
		         if(ae.getSource()==class_lec_but){
		               new LoginPage().setVisible(true);
		               this.setVisible(false);
		          } 
		
		         if(ae.getSource()==class_route_but){
			            new LoginPage2().setVisible(true);
			            this.setVisible(false);
		          }
		
		
		          if(ae.getSource()==class_attend_but){
			            new LoginPage().setVisible(true);
			            this.setVisible(false);
		           }
			 }
	
	        public static void main(String[] args) {
		
	        	JFrame jf=new HomePage();
	        	jf.setSize(1100, 1100);
	        	jf.setVisible(true);
		     }

 }











