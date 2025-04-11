/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banking_system;

import jaco.mp3.player.MP3Player;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.MessageDigest;
import java.util.GregorianCalendar;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public final class Home_Page extends javax.swing.JFrame {

    String SONG = "C:\\Users\\Kyaw Min Wai\\Desktop\\Banking_System\\Keyboard,_typing_sound_effect(256k).mp3";
    MP3Player mp3player = new MP3Player(new File(SONG));
    CardLayout cardLayout;
    Connection con;
    PreparedStatement pst;
    private String loginData;
    private String signupData;
    private String actualID;
    private static final int LIMIT = 100000000;

    public Home_Page(String loginData, String signupData) {
        initComponents();
        this.loginData = loginData;
        this.signupData = signupData;
        GregorianCalendarExample();
        con = DBconnect.connect();

        if (loginData == null) {
            actualID = signupData;
        } else if (signupData == null) {
            actualID = loginData;
        }

        setupTextFieldListeners();
        displayUserInfo();
        jTextField19.setText(jTextField9.getText());

        cardLayout = (CardLayout) (Cards.getLayout());

        jTable1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(84, 106, 118));
        jTable1.getTableHeader().setForeground(new Color(94, 116, 128));
        jTable1.setRowHeight(25);

    }

    private void displayUserInfo() {

        try {
            // Use a prepared statement with a parameter

            String selectSql = "SELECT name, dob, gender, address, nationality, nrc, ph, accountid,amount FROM sign_up_form WHERE accountid = ? ";

            try (PreparedStatement selectPst = con.prepareStatement(selectSql)) {

                selectPst.setString(1, actualID);

                pst = con.prepareStatement(selectSql);

                try (ResultSet rs = selectPst.executeQuery()) {

                    // Assuming jTextField1 is for ID, jTextField2 is for username, and jTextField3 is for birth date
                    if (rs.next()) {
                        String name = rs.getString("name");
                        String birthDate = rs.getString("dob");
                        String gender = rs.getString("gender");
                        String address = rs.getString("address");
                        String nationality = rs.getString("nationality");
                        String nrc = rs.getString("nrc");
                        String phone = rs.getString("ph");
                        String userid = rs.getString("accountid");
                        long amount = rs.getInt("amount");
                        DecimalFormat df = new DecimalFormat("#,###");
                        String formattedAmount = df.format(amount);

                        // Set the retrieved information to the JTextFields
                        jTextField28.setText(name);
                        jTextField29.setText(name);
                        jTextField3.setText(birthDate);
                        jTextField12.setText(gender);
                        jTextField5.setText(address);
                        jTextField27.setText(nationality);
                        jTextField4.setText(nrc);
                        jTextField23.setText(phone);
                        jTextField9.setText(userid);
                        jPasswordField1.setText(String.valueOf(formattedAmount) + " Ks");
                        loadTransactionHistory(userid);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public void GregorianCalendarExample() {
        // Creating a GregorianCalendar instance and setting a specific date
        GregorianCalendar gregorianCalendar = new GregorianCalendar(); // Year, Month (0-11), Day

        // Getting and printing the set date
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH) + 1; // Adding 1 to the month since it is zero-based
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        jTextField2.setText(+day + "-" + month + "-" + year);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        tabbedPaneCustom1 = new banking_system.TabbedPaneCustom();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        txtfrom = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        txtto = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel11 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        Cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        card2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        a = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        card3 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 225, 222));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 106, 118));
        jLabel1.setText("BK Bank");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 106, 118));
        jLabel4.setText("User Name ::");

        jLabel2.setBackground(new java.awt.Color(84, 106, 118));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/IMG_20240216_112558_936-removebg-preview.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 106, 118));
        jLabel5.setText("Date");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(220, 225, 222));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(84, 106, 118));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(84, 106, 118));
        jLabel55.setText("Balance:: ");

        jTextField28.setEditable(false);
        jTextField28.setBackground(new java.awt.Color(220, 225, 222));
        jTextField28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(84, 106, 118));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });

        jPasswordField1.setEditable(false);
        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(84, 106, 118));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-open-eye-28-white.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        tabbedPaneCustom1.setBackground(new java.awt.Color(84, 106, 118));
        tabbedPaneCustom1.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPaneCustom1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tabbedPaneCustom1.setMinimumSize(new java.awt.Dimension(0, 0));
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(52, 73, 94));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(84, 106, 118));

        jPanel2.setBackground(new java.awt.Color(84, 106, 118));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jPanel12.setBackground(new java.awt.Color(84, 106, 118));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(220, 225, 222));
        jTextField9.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(84, 106, 118));

        jTextField29.setEditable(false);
        jTextField29.setBackground(new java.awt.Color(220, 225, 222));
        jTextField29.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(84, 106, 118));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-national-30.png"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-phone-30.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-name-30.png"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-gender-24.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-destination-32.png"))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-address-30.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-birthday-date-32.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-account-24.png"))); // NOI18N

        jTextField27.setEditable(false);
        jTextField27.setBackground(new java.awt.Color(220, 225, 222));
        jTextField27.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(84, 106, 118));

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(220, 225, 222));
        jTextField23.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(84, 106, 118));

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(220, 225, 222));
        jTextField12.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(84, 106, 118));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Address");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gender");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Account No.");

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(220, 225, 222));
        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(84, 106, 118));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(220, 225, 222));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(84, 106, 118));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ph No.");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NRC");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nationality");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date of Birth");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(220, 225, 222));
        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(84, 106, 118));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36)))))
                .addGap(51, 51, 51))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))))
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addComponent(jLabel36))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel34))))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel32)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(41, 41, 41)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35)
                    .addComponent(jLabel37))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Profile", jPanel2);

        jPanel3.setBackground(new java.awt.Color(84, 106, 118));
        jPanel3.setForeground(new java.awt.Color(253, 255, 247));

        jButton3.setBackground(new java.awt.Color(84, 106, 118));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Confirm");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(84, 106, 118));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Pin");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Account No.");

        jTextField17.setBackground(new java.awt.Color(220, 225, 222));
        jTextField17.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(84, 106, 118));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-account-24.png"))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-coin-35.png"))); // NOI18N

        jTextField15.setBackground(new java.awt.Color(220, 225, 222));
        jTextField15.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(84, 106, 118));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Amount");

        jTextField18.setBackground(new java.awt.Color(220, 225, 222));
        jTextField18.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(84, 106, 118));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-key-30.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(11, 11, 11))
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Deposit", jPanel3);

        jPanel4.setBackground(new java.awt.Color(84, 106, 118));
        jPanel4.setForeground(new java.awt.Color(253, 255, 247));

        jButton6.setBackground(new java.awt.Color(84, 106, 118));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Confirm");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(84, 106, 118));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField14.setBackground(new java.awt.Color(220, 225, 222));
        jTextField14.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(84, 106, 118));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pin");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Amount");

        jTextField16.setBackground(new java.awt.Color(220, 225, 222));
        jTextField16.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(84, 106, 118));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Account No.");

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(220, 225, 222));
        jTextField19.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(84, 106, 118));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-account-24.png"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-coin-35.png"))); // NOI18N

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-key-30.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField19)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(42, 42, 42))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(jLabel45))
                .addGap(34, 34, 34)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Withdraw", jPanel4);

        jPanel5.setBackground(new java.awt.Color(84, 106, 118));
        jPanel5.setForeground(new java.awt.Color(253, 255, 247));

        jButton10.setBackground(new java.awt.Color(84, 106, 118));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Confirm");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(84, 106, 118));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-coin-35.png"))); // NOI18N

        jComboBox1.setBackground(new java.awt.Color(220, 225, 222));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(84, 106, 118));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5BB Broadband", "Electricity Bill", "MBT Broadband", "SKYNET" }));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-account-24.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Operator");

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-key-30.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Amount");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-call-45.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Code No.");

        jTextField24.setBackground(new java.awt.Color(220, 225, 222));
        jTextField24.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(84, 106, 118));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Pin");

        jTextField25.setBackground(new java.awt.Color(220, 225, 222));
        jTextField25.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(84, 106, 118));

        jTextField26.setBackground(new java.awt.Color(220, 225, 222));
        jTextField26.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(84, 106, 118));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField26)
                    .addComponent(jTextField24)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel51)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(jLabel54))
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel51))
                .addGap(41, 41, 41)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel52))
                .addGap(28, 28, 28)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel53))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Billing", jPanel5);

        jPanel6.setBackground(new java.awt.Color(84, 106, 118));
        jPanel6.setForeground(new java.awt.Color(253, 255, 247));

        jButton8.setBackground(new java.awt.Color(84, 106, 118));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Confirm");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(84, 106, 118));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField8.setBackground(new java.awt.Color(220, 225, 222));
        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(84, 106, 118));

        jTextField22.setBackground(new java.awt.Color(220, 225, 222));
        jTextField22.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(84, 106, 118));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-key-30.png"))); // NOI18N

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-coin-35.png"))); // NOI18N

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-name-30.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Amount");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Account No.");

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Pin");

        jTextField1.setBackground(new java.awt.Color(220, 225, 222));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(84, 106, 118));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(jLabel50))
                .addGap(31, 31, 31)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel49))
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(jLabel48))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        tabbedPaneCustom1.addTab("Transaction", jPanel6);

        jPanel7.setBackground(new java.awt.Color(84, 106, 118));
        jPanel7.setForeground(new java.awt.Color(253, 255, 247));

        jButton12.setBackground(new java.awt.Color(84, 106, 118));
        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Confirm");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(84, 106, 118));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtfrom.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtfrom.setForeground(new java.awt.Color(84, 106, 118));
        txtfrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Myanmar Kyat | MMK", "United States Dollar | USD", "Japanese Yen | JPY", "South Korean Won | KRW", "Chinese Yuan | CNY", "Thai Baht | THB", " " }));
        txtfrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfromActionPerformed(evt);
            }
        });

        txtamount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtamount.setForeground(new java.awt.Color(84, 106, 118));

        txtto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtto.setForeground(new java.awt.Color(84, 106, 118));
        txtto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Myanmar Kyat | MMK", "United States Dollar | USD", "Japanese Yen | JPY", "South Korean Won | KRW", "Chinese Yuan | CNY", "Thai Baht | THB", " " }));
        txtto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttoActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("From");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Amount::");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("To");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfrom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtamount)))
                .addGap(33, 33, 33))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Disclaimer : The Exchange Rates being used are from Google(22/Feb/2024).");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel62)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jLabel62)
                .addGap(34, 34, 34))
        );

        tabbedPaneCustom1.addTab("Exchange Converter", jPanel7);

        jPanel8.setBackground(new java.awt.Color(84, 106, 118));
        jPanel8.setForeground(new java.awt.Color(253, 255, 247));

        jTable1.setBackground(new java.awt.Color(84, 106, 118));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 17));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Transcation No.", "Type", "Amount","Date", "Receiver", "Sender",
                "Code_no"

            }
        )
        {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // Make all cells non-editable
            }
        }

    );
    jTable1.setGridColor(new java.awt.Color(0, 0, 102));
    jTable1.setSelectionBackground(new java.awt.Color(94, 116, 118));
    jTable1.setSelectionForeground(new java.awt.Color(94, 116, 118));
    jScrollPane1.setViewportView(jTable1);

    jComboBox2.setBackground(new java.awt.Color(84, 106, 118));
    jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
    jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
    jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No.", "Type", "Amount" }));
    jComboBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox2ActionPerformed(evt);
        }
    });

    jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
    jLabel27.setForeground(new java.awt.Color(255, 255, 255));
    jLabel27.setText("Reset By::");

    jButton1.setBackground(new java.awt.Color(84, 106, 118));
    jButton1.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Filter");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
    jTextField10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField10ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel8Layout.createSequentialGroup()
            .addContainerGap(19, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26))
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE))))
    );
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
            .addContainerGap(24, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel27)
                .addComponent(jButton1)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))
    );

    tabbedPaneCustom1.addTab("History", jPanel8);

    jPanel10.setBackground(new java.awt.Color(84, 106, 118));

    jPanel11.setBackground(new java.awt.Color(52, 73, 94));

    jButton15.setBackground(new java.awt.Color(52, 73, 94));
    jButton15.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton15.setForeground(new java.awt.Color(255, 255, 255));
    jButton15.setText("Change Pin");
    jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton15MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton15MouseReleased(evt);
        }
    });
    jButton15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton15ActionPerformed(evt);
        }
    });

    jButton16.setBackground(new java.awt.Color(52, 73, 94));
    jButton16.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton16.setForeground(new java.awt.Color(255, 255, 255));
    jButton16.setText("Log Out");
    jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton16MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton16MouseReleased(evt);
        }
    });
    jButton16.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton16ActionPerformed(evt);
        }
    });

    jButton17.setBackground(new java.awt.Color(52, 73, 94));
    jButton17.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton17.setForeground(new java.awt.Color(255, 255, 255));
    jButton17.setText("Change Ph No.");
    jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton17MouseClicked(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton17MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton17MouseReleased(evt);
        }
    });
    jButton17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton17ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addGap(110, 110, 110)
            .addComponent(jButton17)
            .addGap(33, 33, 33)
            .addComponent(jButton15)
            .addGap(33, 33, 33)
            .addComponent(jButton16)
            .addContainerGap(144, Short.MAX_VALUE))
    );

    jSplitPane1.setLeftComponent(jPanel11);

    Cards.setLayout(new java.awt.CardLayout());

    card1.setBackground(new java.awt.Color(94, 106, 118));
    card1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            card1MouseEntered(evt);
        }
    });

    jButton2.setBackground(new java.awt.Color(94, 106, 118));
    jButton2.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("CONFIRM");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton2MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton2MouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton2MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton2MouseReleased(evt);
        }
    });
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jPanel18.setBackground(new java.awt.Color(94, 106, 118));
    jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jLabel21.setForeground(new java.awt.Color(255, 255, 255));
    jLabel21.setText("New Ph No.");

    jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jLabel20.setForeground(new java.awt.Color(255, 255, 255));
    jLabel20.setText("Confirm Ph No.");

    jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

    jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

    javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
    jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel18Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(50, Short.MAX_VALUE))
    );
    jPanel18Layout.setVerticalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel18Layout.createSequentialGroup()
            .addGap(60, 60, 60)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel21)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel20)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(60, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
    card1.setLayout(card1Layout);
    card1Layout.setHorizontalGroup(
        card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(card1Layout.createSequentialGroup()
            .addContainerGap(182, Short.MAX_VALUE)
            .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                    .addComponent(jButton2)
                    .addGap(98, 98, 98))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(149, 149, 149))))
    );
    card1Layout.setVerticalGroup(
        card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(card1Layout.createSequentialGroup()
            .addContainerGap(98, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addComponent(jButton2)
            .addGap(40, 40, 40))
    );

    Cards.add(card1, "card2");

    card2.setBackground(new java.awt.Color(94, 106, 118));

    jButton4.setBackground(new java.awt.Color(94, 106, 118));
    jButton4.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setText("CONFIRM");
    jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton4MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton4MouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton4MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton4MouseReleased(evt);
        }
    });
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jPanel19.setBackground(new java.awt.Color(94, 106, 118));
    jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(255, 255, 255));
    jLabel26.setText("Last Pin");

    jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(255, 255, 255));
    jLabel28.setText("New Pin");

    jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jLabel33.setForeground(new java.awt.Color(255, 255, 255));
    jLabel33.setText("Confirm Pin");

    jPasswordField3.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N

    jPasswordField2.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jPasswordField2ActionPerformed(evt);
        }
    });

    jPasswordField4.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N

    a.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    a.setForeground(new java.awt.Color(153, 0, 0));
    a.setText("Please enter only 6 digits number.");
    a.setVisible(false);

    b.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    b.setForeground(new java.awt.Color(153, 0, 0));
    b.setText("Please enter only 6 digits number.");
    b.setVisible(false);

    c.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    c.setForeground(new java.awt.Color(153, 0, 0));
    c.setText("Please enter only 6 digits number.");
    c.setVisible(false);

    jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-open-eye-28-brown.png"))); // NOI18N
    jToggleButton3.setBorder(null);
    jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton3ActionPerformed(evt);
        }
    });

    jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-open-eye-28-brown.png"))); // NOI18N
    jToggleButton2.setBorder(null);
    jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton2ActionPerformed(evt);
        }
    });

    jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-open-eye-28-brown.png"))); // NOI18N
    jToggleButton4.setBorder(null);
    jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton4ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
    jPanel19.setLayout(jPanel19Layout);
    jPanel19Layout.setHorizontalGroup(
        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel19Layout.createSequentialGroup()
            .addGap(60, 60, 60)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(237, 237, 237)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(49, 49, 49))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b)
            .addGap(118, 118, 118))
    );
    jPanel19Layout.setVerticalGroup(
        jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel19Layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addComponent(a)
                    .addGap(33, 33, 33)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(b)
            .addGap(33, 33, 33)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel33)
                .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(c)
            .addContainerGap(43, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
    card2.setLayout(card2Layout);
    card2Layout.setHorizontalGroup(
        card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(card2Layout.createSequentialGroup()
            .addGap(105, 105, 105)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(34, Short.MAX_VALUE))
    );
    card2Layout.setVerticalGroup(
        card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
            .addGap(54, 54, 54)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(43, 43, 43))
        .addGroup(card2Layout.createSequentialGroup()
            .addGap(96, 96, 96)
            .addComponent(jButton4)
            .addContainerGap())
    );

    Cards.add(card2, "card3");

    card3.setBackground(new java.awt.Color(94, 106, 118));

    jLabel56.setFont(new java.awt.Font("Vivaldi", 0, 50)); // NOI18N
    jLabel56.setForeground(new java.awt.Color(255, 255, 255));

    jLabel57.setFont(new java.awt.Font("Vivaldi", 0, 50)); // NOI18N
    jLabel57.setForeground(new java.awt.Color(255, 255, 255));

    jButton9.setBackground(new java.awt.Color(94, 106, 118));
    jButton9.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
    jButton9.setForeground(new java.awt.Color(255, 255, 255));
    jButton9.setText("Confirm");
    jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton9MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton9MouseReleased(evt);
        }
    });
    jButton9.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton9ActionPerformed(evt);
        }
    });

    jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
    jLabel61.setForeground(new java.awt.Color(255, 255, 255));
    jLabel61.setText("Are you want to sure to log out?");

    javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
    card3.setLayout(card3Layout);
    card3Layout.setHorizontalGroup(
        card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(card3Layout.createSequentialGroup()
            .addGap(56, 56, 56)
            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
            .addContainerGap(35, Short.MAX_VALUE)
            .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(card3Layout.createSequentialGroup()
                    .addComponent(jLabel61)
                    .addGap(28, 28, 28)
                    .addComponent(jButton9)))
            .addGap(34, 34, 34))
    );
    card3Layout.setVerticalGroup(
        card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(card3Layout.createSequentialGroup()
            .addGap(94, 94, 94)
            .addComponent(jLabel57)
            .addGap(36, 36, 36)
            .addComponent(jLabel56)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
            .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton9)
                .addComponent(jLabel61))
            .addGap(36, 36, 36))
    );

    Cards.add(card3, "card4");

    jSplitPane1.setRightComponent(Cards);

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSplitPane1)
            .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSplitPane1)
            .addContainerGap())
    );

    tabbedPaneCustom1.addTab("Settings", jPanel10);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(121, 121, 121)
                    .addComponent(jLabel55)
                    .addGap(18, 18, 18)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jToggleButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14))))
        .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(50, 50, 50)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel55)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
               jButton3.setBackground(new java.awt.Color(255, 255, 255));    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
               jButton3.setBackground(new java.awt.Color(84,106,118));     }//GEN-LAST:event_jButton3MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setBackground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setBackground(new java.awt.Color(244, 244, 244));
    }//GEN-LAST:event_jButton10MouseEntered

    public void withdraw(double withdrawAmount) {
        String pword = dataharsh(jTextField14.getText());
        double balance = Double.parseDouble(jPasswordField1.getText());
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            JOptionPane.showMessageDialog(rootPane, "Withdrawal successful. Remaining balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Invalid amount or insufficient funds.");
        }
    }


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Connection con = null;
        String pword = dataharsh(jTextField14.getText());
        try {
            con = DBconnect.connect();

            String dbaccount = "SELECT  `pin`, `amount` FROM `sign_up_form` WHERE `accountid`=?";

            pst = con.prepareStatement(dbaccount);
            pst.setString(1, jTextField19.getText()); // Set the parameter using PreparedStatement
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String password = rs.getString("pin");
                if (password.equals(pword)) {

                    String amtText = jTextField16.getText();
                    if (!amtText.isEmpty()) {
                        long withdrawAmount = Long.parseLong(jTextField16.getText());
                        long balance = rs.getLong("amount");
                        if (amtText.matches("\\d+")) {
                            if (withdrawAmount <= balance) {
                                if (withdrawAmount > 0) {
                                    if (withdrawAmount <= 1000000) {

                                        PreparedStatement updateStatementFrom = con.prepareStatement("UPDATE `sign_up_form` SET `amount` = `amount` - ? WHERE `accountid` = ?");
                                        updateStatementFrom.setDouble(1, withdrawAmount);
                                        updateStatementFrom.setString(2, jTextField19.getText());
                                        updateStatementFrom.executeUpdate();
                                        setVisible(false);
                                        success_Loading ts = new success_Loading(loginData, signupData);
                                        ts.successLoading();
                                        ts.setVisible(true);
                                        insertTransactionIntoDatabase(con, jTextField19.getText(), "-", "Withdraw", withdrawAmount, "-");

                                    } else {
                                        JOptionPane.showMessageDialog(null, "You can only withdraw 1,000,000 KS at one time", "subject", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter a valid amount", "subject", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Insufficient balance!", "subject", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a valid amount", "subject",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please enter an amount", "subject",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid password", "subject", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the database connection
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        jButton10.setForeground(new java.awt.Color(244, 244, 244));
        jButton10.setBackground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.setForeground(new java.awt.Color(244, 244, 244));
        jButton8.setBackground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton8MouseExited

    private boolean isBalanceExceedLimit(String accID, long Amount) {
        try {
            String dbaccount = "SELECT `amount` FROM `sign_up_form` WHERE `accountid`=?";
            pst = con.prepareStatement(dbaccount);
            pst.setString(1, accID); // Set the parameter using PreparedStatement
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                int currentBalance = rs.getInt("amount");
                return (currentBalance + Amount) > LIMIT;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String fromAccount = jTextField9.getText();
        String toAccount = jTextField22.getText();
        String pword = dataharsh(jTextField8.getText());
        if (fromAccount.equals(toAccount)) {
            JOptionPane.showMessageDialog(null, "You can't send money to Yourself", "subject",
                    JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if accounts are the same
        }
        Connection con = null;
        try {
            con = DBconnect.connect();
            String dbaccount = "SELECT `accountid`, `pin`, `amount` FROM `sign_up_form` WHERE `accountid`=?";
            pst = con.prepareStatement(dbaccount);
            pst.setString(1, fromAccount); // Set the parameter using PreparedStatement
            ResultSet rs = pst.executeQuery();
            String dbacc2 = "SELECT `accountid`, `amount` FROM `sign_up_form` WHERE `accountid`=?";
            pst = con.prepareStatement(dbacc2);
            pst.setString(1, toAccount);
            ResultSet rs2 = pst.executeQuery();
            if (rs.next()) {
                if (rs2.next()) {
                    String password = rs.getString("pin");

                    if (password.equals(pword)) {
                        String amtText = jTextField1.getText();
                        if (!amtText.isEmpty()) {
                            // Check if the input consists only of digits
                            if (amtText.matches("\\d+")) {
                                long Amount = Long.parseLong(jTextField1.getText());
                                long balance = rs.getLong("amount");

                                if (Amount <= balance) {
                                    if (Amount > 0) {
                                        if (Amount <= 1000000) {
                                            if (isBalanceExceedLimit(toAccount, Amount)) {
                                                setVisible(false);
                                                fail_Loading ts = new fail_Loading(
                                                        loginData, signupData);
                                                ts.failLoading();
                                                ts.setVisible(true);
                                            } else {
                                                PreparedStatement updateStatementFrom = con
                                                        .prepareStatement(
                                                                "UPDATE `sign_up_form` SET `amount` = `amount` - ? WHERE `accountid` = ?");
                                                updateStatementFrom.setDouble(1, Amount);
                                                updateStatementFrom.setString(2,
                                                        fromAccount);
                                                updateStatementFrom.executeUpdate();
                                                PreparedStatement updateStatementTo = con
                                                        .prepareStatement(
                                                                "UPDATE `sign_up_form` SET `amount` = `amount` + ? WHERE `accountid` = ?");
                                                updateStatementTo.setDouble(1, Amount);
                                                updateStatementTo.setString(2,
                                                        toAccount);
                                                updateStatementTo.executeUpdate();
                                                setVisible(false);
                                                success_Loading ts = new success_Loading(
                                                        loginData, signupData);
                                                ts.successLoading();
                                                ts.setVisible(true);
                                                insertTransactionIntoDatabase(con,
                                                        fromAccount, toAccount,
                                                        "Transaction", Amount, "-");

                                                // JOptionPane.showMessageDialog(rootPane,
                                                // "Transfer successful");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "You can only send 1,000,000 KS at one time",
                                                    "subject",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Please enter a valid amount",
                                                "subject", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Insufficient balance!",
                                            "subject", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Please enter a valid amount",
                                        "subject", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter an amount",
                                    "subject", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid password", "subject",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid user", "subject",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the database connection
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void insertTransactionIntoDatabase  (Connection con,String fromAccount, String toAccount,
            String transactionType, long amount, String codeNo){
         PreparedStatement insertStatement = null;
         try{

            // Set parameters for the SQL statement
            String insertSql = "INSERT INTO Transaction (accountid,receiver_id,transcation_id,transcation_type,date,amount, code_no) VALUES (?,?, ?, ?, ?, ?, ?)";
            insertStatement = con.prepareStatement(insertSql);
            int transactionNumber = getCurrentTransactionNumber();
            insertStatement.setString(1, fromAccount);
            insertStatement.setString(2, toAccount);
            insertStatement.setInt(3, transactionNumber);
            insertStatement.setString(4, transactionType);
            ZoneId myanmarTimeZone = ZoneId.of("Asia/Yangon");
            LocalDateTime currentTime = LocalDateTime.now(myanmarTimeZone);
            Timestamp timestamp = Timestamp.valueOf(currentTime);
            // Set the current time
            insertStatement.setTimestamp(5, timestamp);
            insertStatement.setLong(6, amount);
            insertStatement.setString(7, codeNo);

            // Execute the SQL statement
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Log or handle the exception
        } finally {
            try {
                if (insertStatement != null) {
                    insertStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static int getCurrentTransactionNumber() throws SQLException {
        int transactionNumber;
        try ( // Prepare SQL statement to retrieve the current transaction number
                Connection connection = DBconnect.connect()) {
            String sql = "SELECT  MAX(transcation_id) AS max_id FROM Transaction";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Execute the SQL statement
            ResultSet rs = statement.executeQuery(sql);
            // Retrieve the current transaction number
            transactionNumber = 0;
            if (rs.next()) {
                transactionNumber = rs.getInt("max_id");
            }   // Close resources
            rs.close();
            statement.close();
        }

        return transactionNumber + 1;
    }//MSYM]
    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private boolean balanceVisible = false;//balance visible
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        balanceVisible = !balanceVisible;
        updateBalanceFieldVisibility(jPasswordField1, jToggleButton1);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        mp3player.stop();
        jLabel56.setText("");
        jLabel57.setText("");
        cardLayout.show(Cards, "card3");
    }//GEN-LAST:event_jButton15ActionPerformed
    private void animateText1(String text, int delay) {
        Timer timer = new Timer(delay, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (index < text.length()) {
                    jLabel57.setText(jLabel57.getText() + text.charAt(index));
                    index++;
                } else {
                    animateText2("For Using Our Banking System...........", 140);
                    ((Timer) e.getSource()).stop(); // Stop the timer when all characters are displayed

                }
            }
        });

        timer.start();
    }

    private void animateText2(String text, int delay) {
        Timer timer = new Timer(delay, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < text.length()) {
                    jLabel56.setText(jLabel56.getText() + text.charAt(index));
                    index++;
                } else {
                    jLabel57.setText("");
                    jLabel56.setText("");
                    ((Timer) e.getSource()).stop(); // Stop the timer when all characters are displayed
                }
            }
        });

        timer.start();
    }

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        animateText1("Thank You", 200);
        mp3player.play();
        cardLayout.show(Cards, "card4");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        mp3player.stop();
        jLabel56.setText("");
        jLabel57.setText("");
        cardLayout.show(Cards, "card2");
    }//GEN-LAST:event_jButton17ActionPerformed

    private boolean isValidPIN(String pin) {
        // Implement your PIN validation logic here
        // For example, check if it's a 4-digit number
        return pin.matches("\\d{6}");
    }

    private String validateInputs() {
        StringBuilder validationErrors = new StringBuilder();

        if (!isValidPIN(jPasswordField3.getText())) {
            validationErrors.append("Last Pin is incorrect.Please enter your last pin. \n");
        }
        if (!isValidPIN(jPasswordField2.getText())) {
            validationErrors.append("New Pin is incorrect.Please set 6 digits as new pin.\n");
        }
        if (!isValidPIN(jPasswordField4.getText())) {
            validationErrors.append("Confirm Pin is incorrect.Please set 6 digits as confirm pin. \n");
        }

        return validationErrors.toString();
    }

    private void pinUpdate() {
        jPasswordField3.setText("");
        jPasswordField2.setText("");
        jPasswordField4.setText("");
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);

    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        Double tot;
        String amountText = txtamount.getText().trim();

        if (amountText.isEmpty() || !amountText.matches("\\d*(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a valid numeric amount!");
            return;
        }
        Double amount = Double.parseDouble(amountText);
        if ("Myanmar Kyat | MMK".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "United States Dollar | USD":
                    tot = amount * 0.00048;
                    break;
                case "Japanese Yen | JPY":
                    tot = amount * 0.071;
                    break;
                case "South Korean Won | KRW":
                    tot = amount * 0.64;
                    break;
                case "Chinese Yuan | CNY":
                    tot = amount * 0.0034;
                    break;
                case "Thai Baht | THB":
                    tot = amount * 0.017;
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;

            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());

        } else if ("United States Dollar | USD".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "Myanmar Kyat | MMK":
                    tot = amount * 2099.88;
                    break;
                case "Japanese Yen | JPY":
                    tot = amount * 150.29;
                    break;
                case "South Korean Won | KRW":
                    tot = amount * 1335.43;
                    break;
                case "Chinese Yuan | CNY":
                    tot = amount * 7.19;
                    break;
                case "Thai Baht | THB":
                    tot = amount * 35.90;
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());

        } else if ("Japanese Yen | JPY".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "Myanmar Kyat | MMK":
                    tot = amount * 13.97;
                    break;
                case "United States Dollar | USD":
                    tot = amount * 0.0067;
                    break;
                case "South Korean Won | KRW":
                    tot = amount * 8.89;
                    break;
                case "Chinese Yuan | CNY":
                    tot = amount * 7.19;
                    break;
                case "Thai Baht | THB":
                    tot = amount * 0.048;
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());
        } else if ("South Korean Won | KRW".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "Myanmar Kyat | MMK":
                    tot = amount * 1.57;
                    break;
                case "United States Dollar | USD":
                    tot = amount * 0.00075;
                    break;
                case "Japanese Yen | JPY":
                    tot = amount * 0.11;
                    break;
                case "Chinese Yuan | CNY":
                    tot = amount * 0.0054;
                    break;
                case "Thai Baht | THB":
                    tot = amount * 0.027;
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());
        } else if ("Chinese Yuan | CNY".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "Myanmar Kyat | MMK":
                    tot = amount * 292.07;
                    break;
                case "United States Dollar | USD":
                    tot = amount * 0.14;
                    break;
                case "Japanese Yen | JPY":
                    tot = amount * 20.90;
                    break;
                case "South Korean Won | KRW":
                    tot = amount * 185.68;
                    break;
                case "Thai Baht | THB":
                    tot = amount * 4.99;
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());
        } else if ("Thai Baht | THB".equals(txtfrom.getSelectedItem().toString())) {

            switch (txtto.getSelectedItem().toString()) {
                case "Myanmar Kyat | MMK":
                    tot = amount * 58.50;
                    break;
                case "United States Dollar | USD":
                    tot = amount * 0.028;
                    break;
                case "Japanese Yen | JPY":
                    tot = amount * 4.19;
                    break;
                case "South Korean Won | KRW":
                    tot = amount * 37.19;
                    break;
                case "Chinese Yuan | CNY":
                    tot = amount * 0.20;
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Please Choose Different Currency");
                    return;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            String formattedResult = decimalFormat.format(tot);

            // Display the conversion result
            JOptionPane.showMessageDialog(this, "Your amount will be " + formattedResult + " " + txtto.getSelectedItem().toString());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Unsupported source currency: " + txtfrom.getSelectedItem().toString());
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private boolean isValidPhoneNumber(String ph) {
        return ph.matches("^(09|959)\\d{8,9}$");
    }

    private String validatePhInputs() {
        StringBuilder validationError = new StringBuilder();

        if (!isValidPhoneNumber(jTextField7.getText())) {
            validationError.append("Invalid Phone Number. \n");
        }
        return validationError.toString();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String validationMessages = validatePhInputs();

        String newPhno = jTextField7.getText();
        String confirmPhno = jTextField6.getText();
        if (validationMessages.isEmpty()) {
            try {
                if (newPhno.equals(confirmPhno)) {

                    String dbph = "UPDATE `sign_up_form` SET `ph`=  ?  WHERE `accountid`='" + actualID + "'";
                    pst = con.prepareStatement(dbph);
                    pst.setString(1, newPhno);
                    pst.execute();

                    JOptionPane.showMessageDialog(rootPane, "Phone Number Updated.");
                    jTextField7.setText("");
                    jTextField6.setText("");
                    jTextField23.setText(confirmPhno);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Confirm Phone number does not meet.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // If validation fails, display a consolidated error message
            JOptionPane.showMessageDialog(this, validationMessages, "Validation Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean lastpinVisible = false;
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        lastpinVisible = !lastpinVisible;
        updateLastPinFieldVisibility(jPasswordField3, jToggleButton3);
    }//GEN-LAST:event_jToggleButton3ActionPerformed
    private void updateLastPinFieldVisibility(JPasswordField PasswordField, JToggleButton ToggleButton) {

        if (lastpinVisible) {
            PasswordField.setEchoChar((char) 0); // Show balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-closed-eye-28-brown.png"));
        } else {
            PasswordField.setEchoChar('*'); // Hide balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-open-eye-28-brown.png"));
        }

    }//

    private void updateNewPinFieldVisibility(JPasswordField PasswordField, JToggleButton ToggleButton) {

        if (newpinVisible) {
            PasswordField.setEchoChar((char) 0); // Show balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-closed-eye-28-brown.png"));
        } else {
            PasswordField.setEchoChar('*'); // Hide balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-open-eye-28-brown.png"));
        }

    }//

    private void updateConfirmPinFieldVisibility(JPasswordField PasswordField, JToggleButton ToggleButton) {

        if (confirmpinVisible) {
            PasswordField.setEchoChar((char) 0); // Show balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-closed-eye-28-brown.png"));
        } else {
            PasswordField.setEchoChar('*'); // Hide balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-open-eye-28-brown.png"));
        }

    }//

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String validationMessage = validateInputs();

        String lastPin = jPasswordField3.getText();
        String newPin = jPasswordField2.getText();
        String confirmPin = jPasswordField4.getText();
        if (validationMessage.isEmpty()) {

            try {
                String sq = "SELECT  `accountid`, `pin` FROM `sign_up_form` WHERE `accountid`='" + actualID + "'";
                pst = con.prepareStatement(sq);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String password = rs.getString("pin");
                    String pword = dataharsh(lastPin);
                    if (password.equals(pword)) {
                        if (newPin.equals(confirmPin)) {
                            String sql = "UPDATE `sign_up_form` SET `pin`='" + dataharsh(newPin) + "' WHERE `accountid`='" + actualID + "'";
                            pst = con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(rootPane, "Password Updated Successfully..");
                            pinUpdate();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Confirm Pin does not meet with new pin.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Last Pin is incorrect...");
                    }
                }

            } catch (SQLException e) {
            }
        } else {
            // If validation fails, display a consolidated error message
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid digit with a length of 6.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private boolean newpinVisible = false;
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        newpinVisible = !newpinVisible;
        updateNewPinFieldVisibility(jPasswordField2, jToggleButton2);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private boolean confirmpinVisible = false;
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        mp3player.stop();
        setVisible(false);
        logout_Loading l0f = new logout_Loading();
        l0f.logoutLoading();
        l0f.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked

    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseReleased
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setBackground(new java.awt.Color(52, 73, 94));
    }//GEN-LAST:event_jButton17MouseReleased

    private void jButton17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MousePressed
        jButton17.setForeground(new java.awt.Color(52, 73, 94));
        jButton17.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton17MousePressed

    private void jButton15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MousePressed
        jButton15.setForeground(new java.awt.Color(52, 73, 94));
        jButton15.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton15MousePressed

    private void jButton15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseReleased
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setBackground(new java.awt.Color(52, 73, 94));
    }//GEN-LAST:event_jButton15MouseReleased

    private void jButton16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MousePressed
        jButton16.setForeground(new java.awt.Color(52, 73, 94));
        jButton16.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton16MousePressed

    private void jButton16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseReleased
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setBackground(new java.awt.Color(52, 73, 94));
    }//GEN-LAST:event_jButton16MouseReleased

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed

    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setBackground(new java.awt.Color(94, 106, 118));
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MousePressed
        jButton9.setForeground(new java.awt.Color(94, 106, 118));
        jButton9.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton9MousePressed

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setBackground(new java.awt.Color(94, 106, 118));
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed

    }//GEN-LAST:event_jButton2MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited

        if (Group6Info.instance != null) {
            Group6Info.instance.dispose();
        }
    }//GEN-LAST:event_jLabel2MouseExited

    private void card1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseEntered

    }//GEN-LAST:event_card1MouseEntered

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased

    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed

    }//GEN-LAST:event_jButton12MousePressed

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseReleased

    }//GEN-LAST:event_jButton12MouseReleased

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setForeground(new java.awt.Color(84, 106, 118));
        jButton12.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setBackground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String depositAccount = jTextField17.getText();
        
        try {
            String dbaccount = "SELECT `accountid`,  `amount`,  `pin` FROM `sign_up_form` WHERE `accountid`=?";
            pst = con.prepareStatement(dbaccount);
            pst.setString(1, depositAccount);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String amtText = jTextField15.getText();
                
                if (amtText.matches("\\d+")) {
                    long depositAmount = Long.parseLong(jTextField15.getText());
                    if (depositAmount > 0) {
                        if (depositAmount <= 1000000) {
                            if (isBalanceExceedLimit(depositAccount, depositAmount)) {
                                setVisible(false);
                                fail_Loading ts = new fail_Loading(
                                        loginData, signupData);
                                ts.failLoading();
                                ts.setVisible(true);
                            } else {
                                String dbpin="!@#$%^";
                                String pin=jTextField18.getText();
                                if(dbpin.equals(pin)){
                                PreparedStatement updateStatementFrom = con.prepareStatement("UPDATE `sign_up_form` SET `amount` = `amount` + ? WHERE `accountid` = ?");
                                updateStatementFrom.setDouble(1, depositAmount);
                                updateStatementFrom.setString(2, depositAccount);
                                updateStatementFrom.executeUpdate();
                                setVisible(false);
                                success_Loading ts = new success_Loading(loginData, signupData);
                                ts.successLoading();
                                ts.setVisible(true);
                                insertTransactionIntoDatabase(con, depositAccount, "-", "Deposit", depositAmount, "-");
                                }else{
                                JOptionPane.showMessageDialog(rootPane, "Invalid pin..");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "You can only deposit 1,000,000 KS at one time",
                                    "subject",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid amount",
                                "subject", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid amount", "subject",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid user", "subject",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setForeground(new java.awt.Color(94, 106, 118));
        jButton4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setBackground(new java.awt.Color(94, 106, 118));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setForeground(new java.awt.Color(94, 106, 118));
        jButton2.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setBackground(new java.awt.Color(94, 106, 118));
    }//GEN-LAST:event_jButton2MouseExited

    private void txtfromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfromActionPerformed

    private void txttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttoActionPerformed


    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String accID = jTextField9.getText();
        String CodeNo = jTextField25.getText();
        String pword = dataharsh(jTextField26.getText());

        con = null;
        pst = null;
        try {
            con = DBconnect.connect();
            String dbaccount = "SELECT `accountid`, `pin`, `amount` FROM `sign_up_form` WHERE `accountid`=?";

            pst = con.prepareStatement(dbaccount);
            pst.setString(1, accID); // Set the parameter using PreparedStatement

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (CodeNo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a Code Number", "subject",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if CodeNo is empty
                }

                String password = rs.getString("pin");

                if (password.equals(pword)) {
                    String amtText = jTextField24.getText();
                    if (!amtText.isEmpty()) {
                        // Check if the input consists only of digits
                        if (amtText.matches("\\d+")) {
                            long Amount = Long.parseLong(jTextField24.getText());
                            long balance = rs.getLong("amount");

                            if (Amount <= balance) {
                                if (Amount > 0) {
                                    if (Amount <= 1000000) {
                                        String OP = jComboBox1.getSelectedItem().toString();

                                        PreparedStatement updateStatementFrom = con
                                                .prepareStatement(
                                                        "UPDATE `sign_up_form` SET `amount` = `amount` - ? WHERE `accountid` = ?");
                                        updateStatementFrom.setDouble(1, Amount);
                                        updateStatementFrom.setString(2, accID);
                                        updateStatementFrom.executeUpdate();
                                        PreparedStatement updateStatementTo = con.prepareStatement(
                                                "UPDATE `operator` SET `amount` = `amount` + ? WHERE `name` = ?");
                                        updateStatementTo.setDouble(1, Amount);
                                        updateStatementTo.setString(2, OP);
                                        updateStatementTo.executeUpdate();
                                        setVisible(false);
                                        success_Loading ts = new success_Loading(loginData,
                                                signupData);
                                        ts.successLoading();
                                        ts.setVisible(true);

                                        insertTransactionIntoDatabase(con, accID, OP, "Billing",
                                                Amount, CodeNo);

                                        // JOptionPane.showMessageDialog(rootPane, "Transfer
                                        // successful");
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "You can only send 1,000,000 KS at one time",
                                                "subject", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Please enter a valid amount", "subject",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Insufficient balance!", "subject",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Please enter a valid amount", "subject",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please enter an amount", "subject",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid password", "subject",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close(); // Close the database connection
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed
    private void loadTransactionHistory(String pattern) {
        try {
            // Execute a query to retrieve transaction history from the database
            String query = "SELECT * FROM Transaction";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Clear existing data in the table
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            // Iterate through each transaction
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transcation_id");
                String transactionType = resultSet.getString("transcation_type");
                double transactionAmount = resultSet.getDouble("amount");
                String transactionDate = resultSet.getString("date");
                String transactionRid = resultSet.getString("receiver_id");
                String transactionSid = resultSet.getString("accountid");
                String transactionCode = resultSet.getString("code_no");
                // Convert each transaction field to char array for pattern matching
                char[] transactionIdChars = (transactionId + "").toCharArray();
                char[] transactionTypeChars = transactionType.toCharArray();
                char[] transactionDateChars = transactionDate.toCharArray();
                char[] transactionRidChars = transactionRid.toCharArray();
                char[] transactionSidChars = transactionSid.toCharArray();
                char[] transactionCodeChars = transactionCode.toCharArray();
                // Check if any transaction field matches the pattern
                if (bruteForceStringMatching(transactionIdChars, pattern.toCharArray()) != -1
                        || bruteForceStringMatching(transactionTypeChars,
                                pattern.toCharArray()) != -1
                        || bruteForceStringMatching(transactionDateChars,
                                pattern.toCharArray()) != -1
                        || bruteForceStringMatching(transactionRidChars,
                                pattern.toCharArray()) != -1
                        || bruteForceStringMatching(transactionSidChars,
                                pattern.toCharArray()) != -1) {
                    // Add transaction to table if any field matches the pattern
                    model.addRow(new Object[]{transactionId, transactionType, transactionAmount,
                        transactionDate, transactionRid, transactionSid,
                        transactionCode});
                }
            }

            resultSet.close();
            statement.close();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading transaction history: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int bruteForceStringMatching(char[] T, char[] P) {
        int n = T.length;
        int m = P.length;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && P[j] == T[i + j]) {
                j++;
            }
            if (j == m) {
                return i; // Match found at index i
            }
        }
        return -1; // No match found
    }

    private void loadSortedTransactionHistory(String accountId, String sortOption) {
        int confirmOption = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to sort the transactions?", "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirmOption != JOptionPane.YES_OPTION) {
            return; // User canceled the sorting operation
        }
        try {
            // Execute a query to retrieve transaction history from the database based on
            // the selected sort option
            String query;
            switch (sortOption) {

                case "Type":
                    query = "SELECT * FROM Transaction WHERE accountid = ? OR receiver_id = ? ORDER BY CASE"
                            + " WHEN transcation_type = 'Transaction' THEN 1"
                            + " WHEN transcation_type = 'Billing' THEN 2"
                            + " WHEN transcation_type = 'Withdraw' THEN 3"
                            + " WHEN transcation_type = 'Deposit' THEN 4"
                            + " ELSE 5 END ASC";
                    break;
                case "Amount":
                    // Retrieve the transaction history and store it in a list
                    java.util.List<Transaction> transactions = retrieveTransactions(accountId);
                    // Sort the transactions by amount
                    sortByTransactionAmount(transactions);
                    // Populate the table with sorted data
                    populateTable(transactions);
                    return;
                case "No.":
                default:
                    query = "SELECT * FROM Transaction WHERE accountid = ? OR receiver_id = ? ORDER BY date DESC";
                    break;
            }

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, accountId);
            statement.setString(2, accountId);
            ResultSet resultSet = statement.executeQuery();

            // Clear existing data in the table
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!resultSet.isBeforeFirst()) {
                // No records found, display "-" for all fields
                model.addRow(new Object[]{"-", "-", "-", "-", "-", "-", "-"});
            } else {
                // Records found, populate the table
                while (resultSet.next()) {
                    int transactionId = resultSet.getInt("transcation_id");
                    String transactionType = resultSet.getString("transcation_type");
                    double transactionAmount = resultSet.getDouble("amount");
                    String transactionDate = resultSet.getString("date");
                    String transactionRid = resultSet.getString("receiver_id");
                    String transactionSid = resultSet.getString("accountid");
                    String transactionCode = resultSet.getString("code_no");
                    model.addRow(new Object[]{transactionId, transactionType, transactionAmount,
                        transactionDate, transactionRid, transactionSid,
                        transactionCode});
                }
            }

            resultSet.close();
            statement.close();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading sorted transaction history: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private java.util.List<Transaction> retrieveTransactions(String accountId) throws SQLException {
        // Execute a query to retrieve transaction history from the database
        String query = "SELECT * FROM Transaction WHERE accountid = ? OR receiver_id = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, accountId); // Set the account ID directly
        statement.setString(2, accountId);
        ResultSet resultSet = statement.executeQuery();

        // Store fetched data in a list of Transaction objects
        java.util.List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            int transactionId = resultSet.getInt("transcation_id");
            String transactionType = resultSet.getString("transcation_type");
            double transactionAmount = resultSet.getDouble("amount");
            String transactionDate = resultSet.getString("date");
            String transactionRid = resultSet.getString("receiver_id");
            String transactionSid = resultSet.getString("accountid");
            String transactionCode = resultSet.getString("code_no");
            Transaction transaction = new Transaction(transactionId, transactionType,
                    transactionAmount, transactionDate, transactionRid, transactionSid,
                    transactionCode);
            transactions.add(transaction);
        }

        resultSet.close();
        statement.close();

        return transactions;
    }

// Method to populate the table with sorted data
    private void populateTable(java.util.List<Transaction> transactions) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data in the table

        if (!transactions.isEmpty()) {
            // Populate the table with sorted data
            for (Transaction transaction : transactions) {
                model.addRow(new Object[]{
                    transaction.getTransactionNo(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getDate(),
                    transaction.getReceiver(),
                    transaction.getSender(),
                    transaction.getCode()});
            }
        } else {
            // No records found, display "-"
            model.addRow(new Object[]{"-", "-", "-", "-", "-", "-", "-"});
        }
    }

    private void merge(java.util.List<Transaction> transactions, int low, int mid, int high) {
        java.util.List<Transaction> temp = new ArrayList<>();
        int i = low;
        int j = mid + 1;

        // Merge two sorted lists into temp
        while (i <= mid && j <= high) {
            if (transactions.get(i).getAmount() <= transactions.get(j).getAmount()) {
                temp.add(transactions.get(i));
                i++;
            } else {
                temp.add(transactions.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(transactions.get(i));
            i++;
        }
        while (j <= high) {
            temp.add(transactions.get(j));
            j++;
        }

        // Copy temp back to transactions
        for (int k = low; k <= high; k++) {
            transactions.set(k, temp.get(k - low));
        }
    }

    private void mergeSort(java.util.List<Transaction> transactions, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(transactions, low, mid);
            mergeSort(transactions, mid + 1, high);
            merge(transactions, low, mid, high);
        }
    }

    private void sortByTransactionAmount(java.util.List<Transaction> transactions) {
        mergeSort(transactions, 0, transactions.size() - 1);
    }

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String sortOption = (String) jComboBox2.getSelectedItem();

        // Get the account ID provided by the user
        String accountId = jTextField9.getText();

        // Load sorted transaction history based on the selected sorting option
        loadSortedTransactionHistory(accountId, sortOption);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Prompt the user for confirmation
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to filter the transactions?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        // If user confirms, proceed with filtering
        if (option == JOptionPane.YES_OPTION) {
            // Get the ID provided by the user
            String accountId = jTextField10.getText();

            // Call loadTransactionHistory with the provided ID
            loadTransactionHistory(accountId);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        Group6Info info = new Group6Info();
        info.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        confirmpinVisible = !confirmpinVisible;
        updateConfirmPinFieldVisibility(jPasswordField4, jToggleButton4);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    public static String dataharsh(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : rbt) {
                sb.append(String.format("%02x", b));

            }
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    private void updateBalanceFieldVisibility(JPasswordField PasswordField, JToggleButton ToggleButton) {
        if (balanceVisible) {
            PasswordField.setEchoChar((char) 0); // Show balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-closed-eye-28-white.png"));
        } else {
            PasswordField.setEchoChar('*'); // Hide balance
            ToggleButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyaw Min Wai\\Desktop\\Java Project(Banking System)\\icon Folder\\icons8-open-eye-28-white.png"));
        }
    }//

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Page(null, null).setVisible(true);
            }
        });
    }

    private void setupTextFieldListeners() {
        setupDigitOnlyValidation(jPasswordField3, a);
        setupDigitOnlyValidation(jPasswordField2, b);
        setupDigitOnlyValidation(jPasswordField4, c);
    }

    // Call this method to set up digit-only validation for a specific JTextField
    private void setupDigitOnlyValidation(JPasswordField PasswordField, JLabel label) {
        PasswordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkSixDigitOnly(PasswordField, label);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkSixDigitOnly(PasswordField, label);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });
    }

    // Call this method to check if the text contains only digits and update the visibility of the corresponding JLabel
    private void checkSixDigitOnly(JTextField textField, JLabel label) {
        String text = textField.getText();
        boolean isDigit = text.matches("\\d*"); // Check if it's a digit
        boolean hasLength6 = text.length() == 6; // Check if it has a length of 6
        label.setVisible(!(isDigit && hasLength6));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cards;
    private javax.swing.JLabel a;
    private javax.swing.JLabel b;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel c;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private banking_system.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtfrom;
    private javax.swing.JComboBox<String> txtto;
    // End of variables declaration//GEN-END:variables
}
