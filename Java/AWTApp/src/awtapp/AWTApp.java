/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package awtapp;

/**
 *
 * @author HHHHH
 */

    /**
     * @param args the command line arguments
     */
    
        import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AWTApp {
    public static void main(String[] args){
    Frame f=new Frame();
    Label label1=new Label("User Name: ");
    Label label2=new Label("First Name: ");
    Label label3=new Label("Last Name: ");
    Label label4=new Label("Email: ");
    final TextField text1=new TextField(20);
    final TextField text2=new TextField(20);
    final TextField text3=new TextField(20);
    final TextField text4=new TextField(20);
    Button b=new Button("Save");
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String v1=text1.getText();
        String v2=text2.getText();
        String v3=text3.getText();
        String v4=text4.getText();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            System.out.println("connected");
           Statement st=con.createStatement();
           int i=st.executeUpdate("insert into users(username,firstname,lastname,email) values('"+v1+"','"+v2+"','"+v3+"','"+v4+"')");
           JOptionPane.showMessageDialog(null,"Data is inserted successfully");
        }
        catch(Exception ex){
        System.out.println(ex);
         }
       }
        });
        Panel p=new Panel(new GridLayout(6,2));
        p.add(label1);
        p.add(text1);
        p.add(label2);
        p.add(text2);
        p.add(label3);
        p.add(text3);
        p.add(label4);
        p.add(text4);
        p.add(b);
        f.add(p);
        f.setVisible(true);
        f.pack();
    }
}
    

