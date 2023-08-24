package com.mycompany.oopsproject;

/**
 *
 * @author shash
 */

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

public class RegistrationPage extends javax.swing.JFrame {
    RegistrationPage refthis = this;

    public RegistrationPage() {
        initComponents();
    }

    private void initComponents() {

        PageTxt = new javax.swing.JLabel();
        NameTxt = new javax.swing.JLabel();
        PhoneTxt = new javax.swing.JLabel();
        EmailTxt = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        PassTxt = new javax.swing.JLabel();
        PassField = new javax.swing.JPasswordField();
        RegButton = new javax.swing.JButton();
        LogButton = new javax.swing.JButton();
        WarningTxt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Page");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(600, 350, 500, 444));
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PageTxt.setFont(new java.awt.Font("Algerian", 1, 18)); 
        PageTxt.setText("New Registration");
        PageTxt.setOpaque(true);
        getContentPane().add(PageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 75));

        NameTxt.setFont(new java.awt.Font("Algerian", 0, 14)); 
        NameTxt.setText("Name : ");
        getContentPane().add(NameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 96, 66, -1));

        PhoneTxt.setFont(new java.awt.Font("Algerian", 0, 12)); 
        PhoneTxt.setText("Phone No. : ");
        getContentPane().add(PhoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 130, -1, 19));

        EmailTxt.setFont(new java.awt.Font("Algerian", 0, 12)); 
        EmailTxt.setText("Email ID : ");
        getContentPane().add(EmailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 172, 66, -1));

        NameField.setFocusTraversalPolicyProvider(true);
        NameField.setOpaque(true);
        getContentPane().add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 93, 178, -1));
        getContentPane().add(PhoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 127, 178, -1));
        getContentPane().add(EmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 167, 178, -1));

        PassTxt.setFont(new java.awt.Font("Algerian", 0, 12)); 
        PassTxt.setText("password : ");
        getContentPane().add(PassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 212, -1, -1));
        getContentPane().add(PassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 207, 179, -1));

        RegButton.setText("Register");
        RegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RegButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 247, 152, 36));

        LogButton.setText("Login Page");
        LogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 247, 106, 36));

        WarningTxt.setForeground(new java.awt.Color(255, 0, 0));
        WarningTxt.setText("Invalid Entries found! please try again {!-!}");
        getContentPane().add(WarningTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 240, 20));
        WarningTxt.setVisible(false);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 110, -1));

        setSize(new java.awt.Dimension(377, 369));
        setLocationRelativeTo(null);
    }

    private void RegButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == RegButton) {
            char[] pass = PassField.getPassword();
            String PASS = new String(pass);
            String getEmail = EmailField.getText();
            String getName = NameField.getText();
            String getPhone = PhoneField.getText();
            boolean GotUser = false;
            String Serverpath = "jdbc:mysql://localhost:3306/javaprojectlogininfo";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(Serverpath, "root", "");
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("select `Email ID` from `signup data`");
                while (rs.next() && !GotUser) {
                    if (getEmail.equals(rs.getString(1))) {
                        GotUser = true;
                        JOptionPane.showMessageDialog(this,"User Already exists please use login window to login through that page !", "Dublicate found!!"
                                , 2);

                    }
                }
                stmt.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please check your internet connection and try again", "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!GotUser) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conup = DriverManager.getConnection(Serverpath, "root", "");
                    PreparedStatement stmt1 = conup.prepareStatement(
                            "insert into `signup data` (Name,`Email ID`,Phone,Password) values (?,?,?,?)");
                            stmt1.setString(1, getName);
                            stmt1.setString(2, getEmail);
                            stmt1.setString(3, getPhone);
                            stmt1.setString(4, PASS);
                    int stats = stmt1.executeUpdate();
                    if (stats != 0) {
                        JOptionPane.showMessageDialog(this,
                                "You have successfully registered!!", "Registration Complete",
                                1);
                                refthis.dispose();
                                LoginPage.main(null);
                    }else{
                        JOptionPane.showMessageDialog(this, "Failed to Register please check your internet connection and try again","Registration Failed!!", 2);
                    }
                }
                 catch (Exception e) {
                    e.getStackTrace();
                }
            }

        }
    }

    private void LogButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == LogButton) {
            refthis.dispose();
            LoginPage.main(null);
        }
    }


    public static void main(String args[]) {
       // try {
        //    UIManager.setLookAndFeel(new FlatDarkLaf());
       // } catch (Exception ex) {
        //    System.err.println("Failed to initialize LaF");
       // }
       try {
        UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
    } catch (UnsupportedLookAndFeelException e) {
        System.err.println("Failed to initialize LaF");
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationPage().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailTxt;
    private javax.swing.JButton LogButton;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameTxt;
    private javax.swing.JLabel PageTxt;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JLabel PassTxt;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JLabel PhoneTxt;
    private javax.swing.JButton RegButton;
    private javax.swing.JLabel WarningTxt;
    private javax.swing.JLabel jLabel7;
}
