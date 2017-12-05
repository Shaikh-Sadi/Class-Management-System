package com.fattah;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class SetImage extends JFrame 
{
       JButton b,b1,fetch;
       JLabel l;
       String path;
       Connection con;
       Statement statement;
       ResultSet resultSet;
       PreparedStatement ps;
       FileInputStream fin;
       Icon image;
       File img;
       JTextField tf;
      public SetImage()
      {
	      setSize(500,500);
	      setLayout(null);
          l=new JLabel("40*60");
	      l.setBackground(new java.awt.Color(150,150,250));
	      l.setBounds(20,20,100,80);
	      add(l);
          b=new JButton("Browse");
	      b.setBackground(new Color(234,21,67));
	      b.setBounds(100,20,100,30);
	      b.addActionListener(new browseFile());
	      add(b);
          b1=new JButton("Save");
	      b1.setBackground(new Color(200,200,230));
	      b1.setBounds(200,20,100,30);
	      b1.addActionListener(new SaveFile());
	      add(b1); 
          tf=new JTextField();
	      tf.setBounds(260,60,80,30);
	      add(tf);
          fetch=new JButton("Nikalo");
	      fetch.setBounds(300,20,100,30);
	      fetch.addActionListener(new Nikalo());
	      add(fetch);
	      show();
       }

      private class Nikalo implements ActionListener
        {
          public void actionPerformed(ActionEvent ae)
            {
              int index=1;
              if(ae.getSource()==fetch)
                {
                 try
                   {
	                 System.out.println("error noki 1");
	                 index=Integer.parseInt(tf.getText());
                     System.out.println("error noki 2");	
                     ps = con.prepareStatement("select* from uptable where id='"+ index + "'");
                     System.out.println("error noki 200");
                     resultSet= ps.executeQuery();
                     System.out.println("index valu: " +index);
                     System.out.println("error noki 3");	
                     while(resultSet.next())
                         {
	                       System.out.println("error noki 4");
                           Blob imageData = resultSet.getBlob("photo");
                           System.out.println("error noki 5");

                           if( imageData != null )
                             {
                              try 
                                 {
	                               System.out.println("error noki 6");
                                   File tmpFile = new File("tmpImage");
                                   System.out.println("error noki 7");
                                   FileOutputStream fos = new FileOutputStream(tmpFile);
                                   System.out.println("error noki 8");
                                   fos.write( imageData.getBytes(1L, (int)imageData.length()) );
                                   System.out.println("error noki 9");
                                   fos.close();
                                   String ss=tmpFile.getAbsolutePath();
                                   System.out.println(ss);
                                  }
                                   catch(IOException ioe)
                                       {
                                           ioe.printStackTrace();
                                           JOptionPane.showMessageDialog(null, "Failed To Load Image Data", "Load Error", JOptionPane.ERROR_MESSAGE); 
                                        } 
                                }
                             }
                        }
                         catch(Exception asw)
                             {
                               System.out.println("error noki :" +asw);	
                              }

                   }
               }
         }
      
         private class SaveFile implements ActionListener
                {
                  public void actionPerformed(ActionEvent ae)
                        {
                         if(ae.getSource()==b1)
                            {
                             try
                                {
	                              Class.forName("oracle.jdbc.driver.OracleDriver");
	                              Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sadi","01960171418");
                                  ps = con.prepareStatement("insert into uptable (name,photo) values(?,?)");
                                  ps.setString(1,img.getName());
                                  ps.setBinaryStream(2,fin,(int)img.length());
                                  ps.executeUpdate();
                                  System.out.println("Data Saved");
                                }
                                 catch(Exception sqlException)
                                     {
                                         sqlException.printStackTrace(); 
                                      }
                              }
                          }
                 }

                 public static void main(String args[])
                       {
                         new SetImage();
                        }
                 private class browseFile implements ActionListener
                        {
                          public void actionPerformed(ActionEvent ae)
                               {
                               if(ae.getSource()==b)
                                 {
                                  analizepath();
                                  }
                                }
                         }
                  private File getFile()
                         {
                           JFileChooser filechooser=new JFileChooser();
                           filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                           int result =filechooser.showOpenDialog(this);
                           File filename=filechooser.getSelectedFile();
                           if((filename==null) || (filename.getName().equals("")))
                             {
                              JOptionPane.showMessageDialog(this,"invalid filename" ,"invalidfilename",JOptionPane.ERROR_MESSAGE);
                              }
                               return filename;
                           }
                   public void analizepath()
                          {
                            File name=getFile();
                            path=name.getAbsolutePath();
                            image=new ImageIcon(path);
                            img=new File(path);
                            l.setIcon(image);
                            try
                              {
                               fin=new FileInputStream(img);
                               }
                   catch(Exception d){}
                   System.out.println(image.getIconWidth());
                   System.out.print(path);
       }
 }