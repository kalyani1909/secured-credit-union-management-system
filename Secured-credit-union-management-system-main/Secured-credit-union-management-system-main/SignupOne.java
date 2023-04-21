package SecuredCreditSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, dobTextField, emailTextField;
    JButton next;
    JDateChooser dateChooser;
    
    SignupOne() {
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 200, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 200, 400, 30);
        add(dateChooser);
        
        
        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dobTextField.setBounds(300, 200, 400, 30);
        add(dobTextField);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 260, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 260, 400, 30);
        add(emailTextField);
        
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
        String formno = "" + random;
        String name = nameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String email = emailTextField.getText();
        
        
        try{
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+dob+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupOne();
        
    }
}

