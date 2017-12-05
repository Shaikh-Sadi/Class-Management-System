package com.fattah;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
 
public class FileUp extends JFrame {
	    JButton back;
	    JPanel backpanel;
        private JTextField addTextField = new JTextField(30);
        public FileUp() {
               super(":::Upload Manager:::");
               setVisible(true);
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               setSize(600,500);
               addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                            System.exit(0);
                    }
                });
                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                fileMenu.setMnemonic(KeyEvent.VK_F);
                JMenuItem fileExitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
                fileExitMenuItem.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                       }
                });
                fileMenu.add(fileExitMenuItem);
                menuBar.add(fileMenu);
                setJMenuBar(menuBar); 
                JPanel addPanel = new JPanel();
                addPanel.add(addTextField);
                JButton addButton = new JButton("Upload");
                JButton backButton = new JButton("Home page");
                addButton.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                                actionAdd();
                          }
                });
                JButton findButton = new JButton("Find File");
                findButton.addActionListener(new ActionListener() {
                          public void actionPerformed(ActionEvent e) {
                                 actionFindfile();
                          }
                 });
                 addPanel.add(findButton);
                 addPanel.add(addButton);
                 addPanel.add(backButton);
                 JPanel buttonsPanel = new JPanel();
                 getContentPane().setLayout(new BorderLayout());
                 getContentPane().add(addPanel, BorderLayout.NORTH);
           }
 
           private void actionAdd() {
           File fileName = new File(addTextField.getText()); 
                 try {
	                  Class.forName("oracle.jdbc.driver.OracleDriver");
	                  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shaikh sadi","01960171418");
                      PreparedStatement ps = con.prepareStatement("insert into PHOTOTABLE (name,photo) values(?,?)");
                      InputStream pt = new FileInputStream(fileName.getAbsolutePath());
                      ps.setString(1, fileName.getName());
                      ps.setBinaryStream(2, pt, (int)pt.available());
                      ps.executeUpdate();
                      ps.close();
                      pt.close();
                      System.out.println("File Upload Completed...... ");
                  }
                   catch(Exception err) {
                      System.err.println("Exception SM code : " + err.getMessage());
                   }
           }
           public File actionFindfile() {
                  JFileChooser fileChooser = new JFileChooser();
                  fileChooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);
                  int result = fileChooser.showOpenDialog(this);
                  if(result == JFileChooser.CANCEL_OPTION)
                  System.exit(1);
                  File fileName = fileChooser.getSelectedFile();
                  if ((fileName == null) || (fileName.getName().equals(""))) {
                      JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
                      System.exit(1);
                   }
                   addTextField.setText(fileName.getAbsolutePath()); 
                   return fileName;
    }

}
 
