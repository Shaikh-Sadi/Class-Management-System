package com.fattah;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginComplete extends JFrame{
	
	   JTextField t_name;
	   LoginComplete(){
	         JLabel name=new JLabel("Login has been Completed.....");
	         JPanel mm=new JPanel();
	         mm.add(name);
	         add(mm);
	         setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setSize(300,300);
        }

}