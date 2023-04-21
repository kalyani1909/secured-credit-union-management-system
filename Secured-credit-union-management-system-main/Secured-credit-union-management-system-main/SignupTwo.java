package SecuredCreditSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    
    //JTextField nameTextField, dobTextField, emailTextField;
    JButton next;
    JComboBox income, education, occupation;
    String formno;
        
    
    SignupTwo(String formno) {
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Income:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 140, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel edu = new JLabel("Education:");
        edu.setFont(new Font("Raleway", Font.BOLD, 22));
        edu.setBounds(100, 200, 200, 30);
        add(edu);
        
        String educationValues[] = {"Graduate", "Non-Graduate", "Post Graduate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 200, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
       
        
        JLabel email = new JLabel("Occupation:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 260, 200, 30);
        add(email);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Buisness", "Retired", "Student", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 260, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 350, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 500);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        
        try{
            
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"')";
            c.s.executeUpdate(query);
            
            //Signup3
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
            
      
    
    public static void main(String args[]) {
        new SignupTwo("");
        
    }
}
