package com.mycompany.oopsproject;

/**
 *
 * @author shash
 */

import java.sql.*;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

public class LoginPage extends JFrame {
    LoginPage refthis = this;

    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        EmailField = new javax.swing.JTextField();
        PaageName = new javax.swing.JLabel();
        EmailTxt = new javax.swing.JLabel();
        PassTxt = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        RegButton = new javax.swing.JButton();
        try {
            WarningTxt = (javax.swing.JLabel) java.beans.Beans.instantiate(getClass().getClassLoader(),
                    "com/mycompany/oopsproject.LoginPage_jLabel4");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setBounds(new java.awt.Rectangle(600, 350, 500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EmailField.setBackground(new java.awt.Color(51, 51, 51));
        EmailField.setForeground(new java.awt.Color(255, 255, 255));
        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(EmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 30));

        PaageName.setBackground(new java.awt.Color(0, 0, 255));
        PaageName.setFont(new java.awt.Font("Algerian", 0, 24)); 
        PaageName.setLabelFor(this);
        PaageName.setText("Login Page");
        PaageName.setToolTipText("");
        PaageName.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        getContentPane().add(PaageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, 40));

        EmailTxt.setBackground(new java.awt.Color(51, 51, 51));
        EmailTxt.setFont(new java.awt.Font("Algerian", 0, 12)); 
        EmailTxt.setForeground(new java.awt.Color(255, 255, 255));
        EmailTxt.setText("Email ID :");
        getContentPane().add(EmailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        PassTxt.setBackground(new java.awt.Color(51, 51, 51));
        PassTxt.setFont(new java.awt.Font("Algerian", 0, 12)); 
        PassTxt.setForeground(new java.awt.Color(255, 255, 255));
        PassTxt.setText("Password :");
        getContentPane().add(PassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        PasswordField.setBackground(new java.awt.Color(51, 51, 51));
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 210, 30));

        LoginButton.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); 
        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setFocusPainted(false);
        LoginButton.setFocusable(false);
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setOpaque(true);
        LoginButton.setSelected(true);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, 30));

        RegButton.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); 
        RegButton.setText("Register");
        RegButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        RegButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegButton.setFocusable(false);
        RegButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegButton.setSelected(true);
        RegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegButtonActionPerformed(evt);
            }
        });

        getContentPane().add(RegButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, 30));
        getContentPane().add(WarningTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));
        WarningTxt.setVisible(false);

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(333, 320));
        setLocationRelativeTo(null);
    }

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        char[] pass = PasswordField.getPassword();
        String PASS = new String(pass);
        String getEmail = EmailField.getText();
        if (evt.getSource() == LoginButton) {

            String Serverpath = "jdbc:mysql://localhost:3306/javaprojectlogininfo";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(Serverpath, "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select `Email ID`, `Password` from `signup data`");
                boolean GotUser = false;
                boolean gotPar = false;
                while (rs.next() && !GotUser) {
                    if (getEmail.equals(rs.getString(1)) && PASS.equals(rs.getString(2)) && PASS.length() != 0
                            && getEmail.length() != 0) {
                        GotUser = true;
                        refthis.dispose();
                        String[] argEmail = new String[1];
                        argEmail[0] = getEmail;
                        MainWindow.main(argEmail);
                    } else if (getEmail.equals(rs.getString(1))) {
                        gotPar = true;
                    }
                }
                if (GotUser == false) {
                    if (gotPar) {
                        JOptionPane.showMessageDialog(this,"Incorrect Password !!", "User Error!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        JOptionPane.showMessageDialog(this, "Please register and try again!", "User Not Found! ", 2);
                    }
                }
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please check your internet connection and try again", "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
        };
    }

    private void RegButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == RegButton) {
            refthis.dispose();
            RegistrationPage.main(null);
        }
    }

    public static void main(String args[]) {

       // try {
         //   UIManager.setLookAndFeel(new FlatDarkLaf());
       // } catch (Exception ex) {
         //   System.err.println("Failed to initialize LaF");
        //}
        //IntelliJTheme.setup( LoginPage.class.getResourceAsStream(
          //  "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Night Owl Contrast.theme.json" ) );
           // UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
           //FlatNightOwlContrastIJTheme fl = new FlatNightOwlContrastIJTheme();
           try {
            UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailTxt;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PaageName;
    private javax.swing.JLabel PassTxt;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton RegButton;
    private javax.swing.JLabel WarningTxt;
    // End of variables declaration//GEN-END:variables
}
