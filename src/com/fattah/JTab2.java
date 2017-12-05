package com.fattah;

import java.awt.FlowLayout;
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class JTab2 extends JFrame {
	DefaultTableModel model; 
	JTable table; 
	String col[] = {"DAY","9-10am","10-11am","11-12pm","12-1pm","2-3pm","3-4pm"};
	JTab2() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		start();
    }
	
	public void start(){ 
	       model = new DefaultTableModel(col,6);
	       table=new JTable(model){
	              public boolean isCellEditable(int arg0,int arg1){ 
	              return true; 
	       }};
	
	JScrollPane	pane = new JScrollPane(table);
	table.setValueAt("Sunday",0,0); 
	table.setValueAt("Monday",1,0); 
	table.setValueAt("Tuesday",2,0); 
	table.setValueAt("Wednesday",3,0); 
	table.setValueAt("Thursday",4,0); 
	
	
	table.setValueAt("CSE300",0,1); 
	table.setValueAt("CSE302",1,1); 
	table.setValueAt("CSE320",2,1); 
	table.setValueAt("CSE320",3,1); 
	table.setValueAt("CSE320",4,1); 
	

	table.setValueAt("CSE310",0,2); 
	table.setValueAt("CSE312",1,2); 
	table.setValueAt("CSE302",2,2); 
	table.setValueAt("CSE302",3,2); 
	table.setValueAt("CSE301",4,2); 
	
	
	table.setValueAt("CSE320",0,3); 
	table.setValueAt("CSE300",1,3); 
	table.setValueAt("CSE310",2,3); 
	table.setValueAt("CSE310",3,3); 
	table.setValueAt("CSE312",4,3); 
	
	
	table.setValueAt("CSE313",0,4); 
	table.setValueAt("CSE321",1,4); 
	table.setValueAt("CSE310",2,4); 
	table.setValueAt("CSE3104",3,4); 
	
	
	
	table.setValueAt("CSE313",0,5); 
	table.setValueAt("CSE321",1,5); 
	table.setValueAt("CSE303",2,5); 
	table.setValueAt("CSE303",3,5); 
	table.setValueAt("CSE302",4,5);  
	
	
	table.setValueAt("CSE312",0,6); 
	table.setValueAt("CSE302",1,6);  
	table.setValueAt("CSE312",4,6); 
	add(pane); setVisible(true); 
	setLayout(new FlowLayout()); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	} }