
package com.mycompany.oopsproject;

/**
 *
 * @author shash
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;


public class MainWindow extends javax.swing.JFrame {
    public static String serverpath = "jdbc:mysql://localhost:3306/javaprojectlogininfo";
    public static String Name = "user";
    public static String Phone;
    public static String DocName;
    public static String Email = null;
    public static String imgString; 
    public static String DocEmail;
    public static java.sql.Connection con;
    public static int getStatus;
    public static int getAvailGlobal;
    public static Time TimeOfAppoint;
    public static Date dateofBooking;
    public static String[][] DocString = new String[][] {
            { "Demo Doc", "Brain", "9874563210", "demodoc@gmail.com", "4" },
            { "Demo Doc2", "Bones", "9685743216", "demdo@gmail.com", "0" }
    };
    ImageIcon imgicon;
    ImageIcon imgiconBig;


    public MainWindow() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")

    private void initComponents() {

        ImageChooser = new javax.swing.JFileChooser();
        TitleBar = new javax.swing.JPanel();
        getNameLabel = new javax.swing.JLabel();
        Searchtxt = new javax.swing.JTextField();
        SearchBttn = new javax.swing.JButton();
        TabMenu = new javax.swing.JTabbedPane();
        HistoryPanel = new javax.swing.JPanel();
        AppDetail = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        NewNameLabel = new javax.swing.JLabel();
        EmaiLabel = new javax.swing.JLabel();
        PhoneLabel = new javax.swing.JLabel();
        AppIDLabel = new javax.swing.JLabel();
        DocNameLabel = new javax.swing.JLabel();
        TimeOfAppointment = new javax.swing.JLabel();
        DateOFBooking = new javax.swing.JLabel();
        CancelBttn = new javax.swing.JButton();
        GetReci = new javax.swing.JButton();
        DoctorsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DocTable = new javax.swing.JTable();
        RemediesPanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        InfoPhoto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ExportedTxt = new javax.swing.JTextPane();
        ProfilePanel = new javax.swing.JPanel();
        ImageUploadLabel = new javax.swing.JLabel();
        YoueName = new javax.swing.JTextField();
        YourEmail = new javax.swing.JTextField();
        Yourphone = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        ImageChooser.setApproveButtonText("Select");
        ImageChooser.setApproveButtonToolTipText("");
        ImageChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageChooserActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Get Doc Now");
        setName("MainWindow"); 
        setSize(new java.awt.Dimension(1920, 1080));
        setType(java.awt.Window.Type.POPUP);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        getNameLabel.setText("Welcome, User !");

        Searchtxt.setText("Search your problem here");

        SearchBttn.setText("Search");
        SearchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TitleBarLayout = new javax.swing.GroupLayout(TitleBar);
        TitleBar.setLayout(TitleBarLayout);
        TitleBarLayout.setHorizontalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchBttn)
                .addContainerGap())
        );
        TitleBarLayout.setVerticalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Searchtxt)
                        .addComponent(getNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        TabMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TabMenu.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        HistoryPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                HistoryPanelComponentShown(evt);
            }
        });
        HistoryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AppDetail.setFont(new java.awt.Font("Serif", 3, 24)); 
        AppDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppDetail.setText("NO REACENT APPOINTMENTS FOUND");
        AppDetail.setFocusable(false);
        AppDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HistoryPanel.add(AppDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 470, 120));
        HistoryPanel.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        NewNameLabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(NewNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 450, 40));

        EmaiLabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(EmaiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 450, 40));

        PhoneLabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(PhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 450, 40));

        AppIDLabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(AppIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 290, 40));

        DocNameLabel.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(DocNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 450, 40));

        TimeOfAppointment.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(TimeOfAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 450, 40));

        DateOFBooking.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); 
        HistoryPanel.add(DateOFBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        CancelBttn.setBackground(new java.awt.Color(255, 153, 153));
        CancelBttn.setFont(new java.awt.Font("Serif", 1, 24)); 
        CancelBttn.setText("Cancel Appointment");
        CancelBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBttnActionPerformed(evt);
            }
        });
        HistoryPanel.add(CancelBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 363, 290, 50));

        GetReci.setBackground(new java.awt.Color(153, 255, 255));
        GetReci.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
        GetReci.setText("Get Reciept");
        GetReci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetReciActionPerformed(evt);
            }
        });
        HistoryPanel.add(GetReci, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, -1, -1));

        TabMenu.addTab("Appointment History", HistoryPanel);

        DoctorsPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                DoctorsPanelComponentRemoved(evt);
            }
        });

        DocTable.setFont(new java.awt.Font("SimSun", 1, 14)); 
        DocTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Demo Doc", "Brain", "9874563210", "demodoc@gmail.com",  new Integer(4)},
                {"Demo Doc2", "Bones", "9685743216", "demdo@gmail.com",  new Integer(0)}
            },
            new String [] {
                "Name Of The Doc", "Specializes In", "Phone No. ", "Email ID", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DocTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DocTable.setShowHorizontalLines(true);
        DocTable.setShowVerticalLines(true);
        DocTable.getTableHeader().setReorderingAllowed(false);
        DocTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DocTable);

        javax.swing.GroupLayout DoctorsPanelLayout = new javax.swing.GroupLayout(DoctorsPanel);
        DoctorsPanel.setLayout(DoctorsPanelLayout);
        DoctorsPanelLayout.setHorizontalGroup(
            DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        DoctorsPanelLayout.setVerticalGroup(
            DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        TabMenu.addTab("Search For Doctors", DoctorsPanel);

        RemediesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Simplex_IV50", 1, 18)); 
        RemediesPanel.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 9, 178, 41));

        InfoPhoto.setFont(new java.awt.Font("Segoe UI", 3, 14)); 
        InfoPhoto.setText("jLabel2");
        InfoPhoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InfoPhoto.setVisible(false);
        RemediesPanel.add(InfoPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 68, 148, 176));

        ExportedTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        ExportedTxt.setText("Search for Something!");
        ExportedTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ExportedTxt.setEnabled(false);
        ExportedTxt.setVisible(true);
        jScrollPane3.setViewportView(ExportedTxt);

        RemediesPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 440, 330));

        TabMenu.addTab("Search for Info", RemediesPanel);

        ProfilePanel.setEnabled(false);

        ImageUploadLabel.setText("  Upload Image");
        ImageUploadLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ImageUploadLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImageUploadLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImageUploadLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageUploadLabelMouseClicked(evt);
            }
        });

        YoueName.setFont(new java.awt.Font("Segoe Print", 3, 24)); 
        YoueName.setText("jTextField1");
        YoueName.setEnabled(false);

        YourEmail.setFont(new java.awt.Font("Segoe Print", 3, 24)); 
        YourEmail.setText("jTextField2");
        YourEmail.setEnabled(false);
        YourEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YourEmailActionPerformed(evt);
            }
        });

        Yourphone.setFont(new java.awt.Font("Segoe Print", 3, 24));
        Yourphone.setText("jTextField3");
        Yourphone.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 2, 24));
        jButton1.setText("Edit");

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 2, 24));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); 
        jButton3.setText("Edit");

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ImageUploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Yourphone, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(YourEmail)
                    .addComponent(YoueName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfilePanelLayout.createSequentialGroup()
                        .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YoueName)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(YourEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ProfilePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ImageUploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Yourphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(378, Short.MAX_VALUE))
        );

        TabMenu.addTab("Your Profile", ProfilePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GetReciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetReciActionPerformed
        if(evt.getSource()==GetReci)
        {
            RecieptGen.Printreciept(DocName, DocEmail, Name, Email, Phone, String.valueOf(getStatus), dateofBooking.toString(), TimeOfAppoint.toString());
            JOptionPane.showMessageDialog(this, "Successfully Generated!!", "message!", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_GetReciActionPerformed

    private void DocTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_DocTableMouseClicked
        if (evt.getSource() == DocTable) {
            if (evt.getClickCount() > 1) {
                int getRow = DocTable.getSelectedRow();
                int getAvail = Integer.parseInt(DocTable.getValueAt(getRow, 4).toString());
                getAvailGlobal = getAvail;
                try {
                    DocInfoPage.main(DocTable);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                //if (getAvail > 0 && getStatus == 0) {

                    //try {
                        //DocInfoPage.main(DocTable);
                        /*String tTIME = JOptionPane.showInputDialog(this, "Time Of Appointment : ", "Book Appointment",
                                JOptionPane.YES_NO_OPTION);
                        TimeOfAppoint = Time.valueOf(tTIME);
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate now = LocalDate.now();
                        // Timestamp ts = Timestamp.valueOf(dtf.format(now).toString());
                        // String tstamptemp = ts.toString();
                        int tstamp = (int) System.currentTimeMillis();
                        getStatus = tstamp + (int) Math.random() * 1000;
                        int getSele = DocTable.getSelectedRow();
                        String DCNAme = DocTable.getValueAt(getSele, 0).toString();
                        String DCEmail = DocTable.getValueAt(getSele, 3).toString();
                        PreparedStatement psmt = con.prepareStatement(
                                "UPDATE `signup data` SET `Ap. Status`=?,`DocsName`=?,`DateOfBooking`=?,`TimeOfAppointment`=?, `DocEmail` =? WHERE `Email ID`=?");
                        psmt.setInt(1, getStatus);
                        psmt.setString(2, DCNAme);
                        psmt.setString(3, dtf.format(now));
                        psmt.setTime(4, TimeOfAppoint);
                        psmt.setString(5, DCEmail);
                        psmt.setString(6, Email);
                        DocName = DCNAme;
                        DocEmail = DCEmail;
                        dateofBooking = Date.valueOf(now);
                        int st = psmt.executeUpdate();
                        System.out.println(st);
                        if (st >= 1) {

                            JOptionPane.showMessageDialog(this, "Successfully Booked !", null, 1);
                            int newAvail = getAvail - 1;
                            Updatedata.Updater(DCEmail, String.valueOf(getAvail), String.valueOf(newAvail));
                            getAvailGlobal = getAvail;
                            DocEmail = DCEmail;
                           
                        } else {
                            JOptionPane.showMessageDialog(this, " Booking Failed !", null, JOptionPane.ERROR_MESSAGE);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, " Booking Failed !", null, JOptionPane.ERROR_MESSAGE);
                    }

                } else if (getStatus != 0) {
                    JOptionPane.showMessageDialog(this,
                            " You already have a pending appointment, you cant make anothoer one!", "Not Eligible",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (getAvail <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Sorry this Doc has already his schedule packed, wait for him to be available or try someone else!",
                            "Not Available", JOptionPane.INFORMATION_MESSAGE);

                }*/
            }
        }
    }

    private void YourEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_YourEmailActionPerformed
        
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        
    }
    private void HistoryPanelComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_HistoryPanelComponentShown
        if (evt.getSource() == HistoryPanel) {
            CancelBttn.setVisible(false);
            GetReci.setVisible(false);
            if (getStatus != 0) {
                AppIDLabel.setText("Appointment ID:  " + Integer.toString(getStatus));
                DocNameLabel.setText("Doctor's Name:  " + DocName);
                NewNameLabel.setText("Name Of the Patient:  " + Name);
                PhoneLabel.setText("Patient's Phone No.:  " + Phone);
                DateOFBooking.setText("Date Of Booking:  " + dateofBooking.toString());
                TimeOfAppointment.setText("Time of Appointment:  " + TimeOfAppoint.toString());
                EmaiLabel.setText("Patient's Email:  " + Email);
                AppDetail.setVisible(false);
                CancelBttn.setVisible(true);
                GetReci.setVisible(true);
                
            }

        }
    }

    private void CancelBttnActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == CancelBttn) {
            int respo = JOptionPane.showConfirmDialog(this, "Are You sure you want to cancel your appointment?",
                    "Confirmation window !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (respo == 0) {

                try {
                    PreparedStatement psmt = con.prepareStatement(
                            "UPDATE `signup data` SET `Ap. Status`= ?,`DocsName`=?,`DateOfBooking`=?,`TimeOfAppointment`=?, `DocEmail` =? WHERE `Email ID` = ?");
                    psmt.setNull(1, Types.INTEGER);
                    psmt.setNull(2, Types.VARCHAR);
                    psmt.setNull(3, Types.DATE);
                    psmt.setNull(4, Types.TIME);
                    psmt.setNull(5, Types.VARCHAR);
                    psmt.setString(6, Email);
                    psmt.executeUpdate();

                } catch (SQLException e) {

                    e.printStackTrace();
                }

                AppIDLabel.setText(null);
                DocNameLabel.setText(null);
                NewNameLabel.setText(null);
                PhoneLabel.setText(null);
                DateOFBooking.setText(null);
                TimeOfAppointment.setText(null);
                EmaiLabel.setText(null);
                AppDetail.setVisible(true);
                CancelBttn.setVisible(false);
                GetReci.setVisible(false);
                getStatus = 0;
                int valold=0;
                int valnew=0;
                System.out.println(DocEmail);
                try {
                    valold = SearchSeparate.SearchSep(DocEmail);
                    valnew = valold + 1;
                    Updatedata.Updater(DocEmail, String.valueOf(valold), String.valueOf(valnew));
                } catch (Exception e) {
                    System.out.println("Old: " + valold);
                    System.out.println(DocEmail);
                    e.printStackTrace();

                }
            }
        }
    }
    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        if (evt.getComponent() == this) {
            String Build = "Hello, " + Name;
            getNameLabel.setText(Build);

            YoueName.setText(Name);
            YourEmail.setText(Email);
            Yourphone.setText(Phone);
            if (imgString != null) {
                imgiconBig = new ImageIcon(new ImageIcon(imgString).getImage().getScaledInstance(95, 98,
                        java.awt.Image.SCALE_AREA_AVERAGING));
                ImageUploadLabel.setText(null);
                ImageUploadLabel.setIcon(imgiconBig);
            }
        }
    }

    private void SearchBttnActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == SearchBttn) {
            String SrchText = Searchtxt.getText();
            try {
                DocString = Reader.BuildDoc(SrchText);
                DocTable.setModel(new javax.swing.table.DefaultTableModel(DocString,
                        new String[] {
                                "Name Of The Doc", "Specializes In", "Phone No. ", "Email ID", "Available"
                        }) {
                    Class[] types = new Class[] {
                            java.lang.String.class, java.lang.String.class, java.lang.String.class,
                            java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean[] {
                            false, false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String[][] WikiData = Wiki.Searchwiki(SrchText);
                ImageIcon Iphoto = new ImageIcon(new ImageIcon(WikiData[0][3]).getImage().getScaledInstance(148, 176,
                        java.awt.Image.SCALE_AREA_AVERAGING));
                InfoPhoto.setText(null);
                InfoPhoto.setIcon(Iphoto);

                ExportedTxt.setText(WikiData[0][1]);
                Title.setText(WikiData[0][0]);
                InfoPhoto.setVisible(true);
                ExportedTxt.setVisible(true);
            } catch (Throwable e) {
                
                e.printStackTrace();
            }

        }
    }// GEN-LAST:event_SearchBttnActionPerformed

    private void DoctorsPanelComponentRemoved(java.awt.event.ContainerEvent evt) {
        
    }

    private void ImageUploadLabelMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ImageUploadLabelMouseClicked
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "png");
        ImageChooser.setFileFilter(filter);
        int r = ImageChooser.showDialog(this, "Select");
        if (r == JFileChooser.APPROVE_OPTION) {
            imgString = ImageChooser.getSelectedFile().getAbsolutePath();
            imgiconBig = new ImageIcon(
                    new ImageIcon(imgString).getImage().getScaledInstance(95, 98, java.awt.Image.SCALE_DEFAULT));
            ImageUploadLabel.setText(null);
            ImageUploadLabel.setIcon(imgiconBig);
            uploadimg();
        }

    }// GEN-LAST:event_ImageUploadLabelMouseClicked

    private void ImageChooserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ImageChooserActionPerformed
    }// GEN-LAST:event_ImageChooserActionPerformed


    public static void main(String args[]) {
        try {
            Email = args[0];
        } catch (Exception e) {
            Email = null;
        }
        // try {
        // UIManager.setLookAndFeel(new FlatDarkLaf());
        // } catch (Exception ex) {
        // System.err.println("Failed to initialize LaF");
        // }
        try {
            UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Failed to initialize LaF");
        }
        fetchdata();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel AppDetail;
    private javax.swing.JLabel AppIDLabel;
    private javax.swing.JButton CancelBttn;
    private javax.swing.JLabel DateOFBooking;
    private javax.swing.JLabel DocNameLabel;
    javax.swing.JTable DocTable;
    private javax.swing.JPanel DoctorsPanel;
    private javax.swing.JLabel EmaiLabel;
    private javax.swing.JTextPane ExportedTxt;
    private javax.swing.JButton GetReci;
    private javax.swing.JPanel HistoryPanel;
    private javax.swing.JFileChooser ImageChooser;
    private javax.swing.JLabel ImageUploadLabel;
    private javax.swing.JLabel InfoPhoto;
    private javax.swing.JLabel NewNameLabel;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JPanel RemediesPanel;
    private javax.swing.JButton SearchBttn;
    private javax.swing.JTextField Searchtxt;
    private javax.swing.JTabbedPane TabMenu;
    private javax.swing.JLabel TimeOfAppointment;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JTextField YoueName;
    private javax.swing.JTextField YourEmail;
    private javax.swing.JTextField Yourphone;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel getNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
    static void uploadimg() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection newcon = DriverManager.getConnection(serverpath, "root", "");
            PreparedStatement psmt = newcon
                    .prepareStatement("update `signup data` set `Image` = ? where `Email ID` = ?");

            FileInputStream fin = new FileInputStream(imgString);
            DataInputStream din = new DataInputStream(fin);

            byte[] imgdata;
            imgdata = din.readAllBytes();
            din.close();
            Blob blb = null;
            blb = new SerialBlob(imgdata);
            psmt.setBlob(1, blb);
            psmt.setString(2, Email);

            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fetchdata() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(serverpath, "root", "");
            Statement stmt = con.createStatement();
            String querry = "Select `Name`, `Email ID`, `Phone`, `Image`, `Ap. Status`, `DocsName`, `DateOfBooking`, `TimeOfAppointment`, `DocEmail` from `signup data`";
            ResultSet rs = stmt.executeQuery(querry);
            Blob img = null;
            while (rs.next() && Email != null) {
                if (Email.equals(rs.getString(2))) {

                    Name = rs.getString(1);
                    Phone = rs.getString(3);
                    getStatus = rs.getInt(5);
                    DocName = rs.getString(6);
                    dateofBooking = rs.getDate(7);
                    TimeOfAppoint = rs.getTime(8);
                    DocEmail = rs.getString(9);
                    img = rs.getBlob("Image");
                    System.out.println("hello");
                }

            }
            System.out.println(DocEmail);
            if (img != null) {
                byte[] imgdata = img.getBytes(1, (int) img.length());
                try {
                    imgString = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\image.png";
                    FileOutputStream file = new FileOutputStream(
                            "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\image.png");
                    DataOutputStream dout = new DataOutputStream(file);
                    System.out.println("heloo-c");
                    dout.write(imgdata);
                    dout.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else
                JOptionPane.showConfirmDialog(null, "Please Upload Your Picture to Complete setting up your profile",
                        "Image Not Found!", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
