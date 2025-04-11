/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banking_system;

import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import javax.swing.JRadioButton;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 * @author Kyaw Min Wai
 */
public class Signup_Form extends javax.swing.JFrame {

    private String gender;
    private static Set<String> generatedAccountIds = new HashSet<>();
    private Random random = new Random();
    private String accountid;

    Connection con = null;

    public Signup_Form() {
        initComponents();
        con = DBconnect.connect();
        GregorianCalendar();

        Jcmb_Region.setSelectedItem(null);
        Jcmb_State.setSelectedItem(null);
        Jcmb_Type.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        Jcmb_Region = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField10 = new javax.swing.JTextField();
        Jcmb_Type = new javax.swing.JComboBox<>();
        Jcmb_State = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 225, 222));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Yu Gothic", 0, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 106, 118));
        jLabel3.setText("BK Bank");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/IMG_20240216_112558_936-removebg-preview.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(84, 106, 118));
        jLabel15.setText("Date");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(220, 225, 222));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(84, 106, 118));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(84, 106, 118));

        jPanel2.setBackground(new java.awt.Color(84, 106, 118));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(84, 106, 120), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");

        jTextField2.setBackground(new java.awt.Color(220, 225, 222));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(84, 106, 118));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pin");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nationality");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Address");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date of Birth");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NRC No.");

        jTextField9.setBackground(new java.awt.Color(220, 225, 222));
        jTextField9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(84, 106, 118));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField11.setBackground(new java.awt.Color(220, 225, 222));
        jTextField11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(84, 106, 118));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField8.setBackground(new java.awt.Color(220, 225, 222));
        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(84, 106, 118));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        Jcmb_Region.setBackground(new java.awt.Color(220, 225, 222));
        Jcmb_Region.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Jcmb_Region.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_Region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        Jcmb_Region.setToolTipText("a");
        Jcmb_Region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_RegionActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(84, 106, 118));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Female");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(84, 106, 118));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Male");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField10.setBackground(new java.awt.Color(220, 225, 222));
        jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(84, 106, 118));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        Jcmb_Type.setBackground(new java.awt.Color(220, 225, 222));
        Jcmb_Type.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Jcmb_Type.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C", "AC", "NC", "V", "M", "N" }));
        Jcmb_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_TypeActionPerformed(evt);
            }
        });

        Jcmb_State.setBackground(new java.awt.Color(220, 225, 222));
        Jcmb_State.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        Jcmb_State.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_State.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_StateActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(220, 225, 222));
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(253376188303000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-62135789329000L));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender");

        jTextField12.setBackground(new java.awt.Color(220, 225, 222));
        jTextField12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(84, 106, 118));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-name-30.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-national-30.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-birthday-date-32.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-destination-32.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-gender-24.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-address-30.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-phone-30.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-key-30.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ph No.");

        jButton1.setBackground(new java.awt.Color(84, 106, 118));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(84, 106, 118));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
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

        jButton2.setBackground(new java.awt.Color(84, 106, 118));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nickname");

        jTextField13.setBackground(new java.awt.Color(220, 225, 222));
        jTextField13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(84, 106, 118));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/icons8-name-30.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField12)
                                    .addComponent(jTextField13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel21))
                                .addGap(128, 128, 128))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField2)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(131, 131, 131))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Jcmb_Region, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jcmb_State, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jcmb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(238, 238, 238)
                        .addComponent(jButton2)
                        .addGap(254, 254, 254)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)
                                .addComponent(jLabel12))
                            .addComponent(jLabel13))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Jcmb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Jcmb_State, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Jcmb_Region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19))
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel16))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     public void GregorianCalendar() {
        // Creating a GregorianCalendar instance and setting a specific date
        GregorianCalendar gregorianCalendar = new GregorianCalendar(); // Year, Month (0-11), Day

        // Getting and printing the set date
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH) + 1; // Adding 1 to the month since it is zero-based
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        jTextField1.setText(+day + "-" + month + "-" + year);

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField13.setText("");
        jTextField2.setText("");
        jDateChooser1.setDate(null);
        jTextField12.setText("");
        jTextField8.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField9.setText("");
        buttonGroup1.clearSelection();

        // Clear the selected item in the JComboBox
        Jcmb_Region.setSelectedItem(null);
        Jcmb_State.setSelectedItem(null);
        Jcmb_Type.setSelectedItem(null);

    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean isValidUsername(String username) {
        // Only allow alphanumeric characters and underscores
        // Add your specific username validation logic here
        //return !username.isEmpty();
        String regex = "^[a-zA-Z ]+$";
        return !username.isEmpty() && username.matches(regex);
    }

    private boolean isValidDate(JDateChooser dateChooser) {
        // Check if a date is selected
        //return dateChooser.getDate() != null;
        java.util.Date selectedDate = dateChooser.getDate();

        // Check if a date is selected
        if (selectedDate == null) {
            return false;
        }

        // Convert the selected date to LocalDate
        LocalDate birthDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate age difference
        Period ageDifference = Period.between(birthDate, LocalDate.now());

        // Convert the age difference to a single unit, considering years, months, and days
        int totalAgeInDays = ageDifference.getYears() * 365 + ageDifference.getMonths() * 30 + ageDifference.getDays();

        // Check if the total age in days is within the specified range (18 years to 120 years)
        return totalAgeInDays >= 18 * 365 && totalAgeInDays <= 120 * 365;
    }

    private boolean isValidGender(JRadioButton maleRadioButton, JRadioButton femaleRadioButton) {
        // Check if either the male or female radio button is selected
        return maleRadioButton.isSelected() || femaleRadioButton.isSelected();
    }

    private boolean isValidAddress(String address) {
        // Implement your address validation logic here
        // For example, check if it's not empty
        String regex = "^[a-zA-Z0-9(). ,\\-]+$";
        return !address.isEmpty() && address.matches(regex);

    }

    private boolean isValidNickname(String nickname) {
    // Define a regular expression pattern allowing any combination of characters but no spaces
    String regex = "^[^\\s]+$";

    // Check if the nickname is not empty and matches the regular expression
    return !nickname.isEmpty() && nickname.matches(regex);
}

    private boolean isValidNationality(String nationality) {
        // Implement your nation validation logic here
        // For example, check if it's not empty
        String regex = "^[a-zA-Z]+$";
        return !nationality.isEmpty() && nationality.matches(regex);
    }

    private boolean isValidNRC(String nrc) {
        // Implement your NRC validation logic here
        // For example, check if it's not empty
        return !nrc.isEmpty() && nrc.matches("\\d{6}");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Myanmar phone numbers typically have 9 or 10 digits, and may start with 09
        // Example: 09XXXXXXXXX or 09-XXXXXXXX
        return phoneNumber.matches("^09\\d{8,9}$");
    }

    private boolean isValidPIN(String pin) {
        // Implement your PIN validation logic here
        // For example, check if it's a 4-digit number
        return pin.matches("\\d{6}");
    }

    private boolean isValidDynamicComboBox(String selectedValue) {

        // Check if the selected value is not null and not equal to the default value
        //return selectedValue != null && !defaultValue.equals(selectedValue);
        // Replace "YourDefaultValue" with the appropriate default value
        return selectedValue != null;
    }

    //Finding errors
    private String validateInputs() {
        StringBuilder validationErrors = new StringBuilder();

        // Validate username
        if (!isValidUsername(jTextField2.getText())) {
            validationErrors.append("Invalid username < Please enter only alphanumeric characters. >\n");
        }

        if (!isValidDate(jDateChooser1)) {
            validationErrors.append("Please select a valid date.\n  ");
        }

        if (!isValidGender(jRadioButton1, jRadioButton2)) {
            validationErrors.append("Please select a valid gender.\n  ");
        }

        // Validate address
        if (!isValidAddress(jTextField12.getText())) {
            validationErrors.append("Invalid address < Please re-renter your address correctly.  >\n ");
        }

        if (!isValidNickname(jTextField13.getText())) {
            validationErrors.append("Invalid nickname < Your nickname must not  include space..  >\n ");
        }

        // Validate phone number
        if (!isValidPhoneNumber(jTextField11.getText())) {
            validationErrors.append("Invalid phone number < Please enter Your Phone numbers. >\n ");
        }

        // Validate PIN
        if (!isValidPIN(jTextField9.getText())) {
            validationErrors.append("Invalid PIN < Please enter only six numbers. >\n  ");
        }

        // Validate NRC
        if (!isValidNRC(jTextField10.getText())) {
            validationErrors.append("Invalid NRC < Please enter Your NRC numbers. >\n");
        }

        // Validate nationality (replace "YourDefaultNationality" with an appropriate default value)
        if (!isValidNationality((String) jTextField8.getText())) {
            validationErrors.append("Invalid nationality < Please insert Your nationality >\n");
        }

        // Validate dynamic combo boxes (replace "YourDefaultValue" with an appropriate default value)
        if (!isValidDynamicComboBox((String) Jcmb_Region.getSelectedItem())) {
            validationErrors.append("Invalid NRC <Please enter Your NRC State number...\n ");
        }

        if (!isValidDynamicComboBox((String) Jcmb_State.getSelectedItem())) {
            validationErrors.append("Invalid NRC <Please enter Your NRC District number...\n ");
        }

        if (!isValidDynamicComboBox((String) Jcmb_Type.getSelectedItem())) {
            validationErrors.append("Invalid NRC <Please enter Your NRC Status...\n");
        }

        // Add validation for other fields as needed
        return validationErrors.toString();
    }

    private void insertData(String name, String date, String genderStatus, String address, String nationality, String nrc, String phNo, String accountid, String pin, int amount, String nn) {

        String q = "INSERT INTO `sign_up_form`(`name`, `dob`, `gender`, `address`, `nationality`, `nrc`, `ph`, `accountid`, `pin`,`amount`,`nn`)"
                + " Values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(q);
            pst.setString(1, name);
            pst.setString(2, date);
            pst.setString(3, genderStatus);
            pst.setString(4, address);
            pst.setString(5, nationality);
            pst.setString(6, nrc);
            pst.setString(7, phNo);
            pst.setString(8, accountid);
            pst.setString(9, pin);
            pst.setInt(10, amount);
            pst.setString(11, nn);

            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Account creation is successful.");
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static String dataharsh(String password) {
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

    public void RandomGenerator() {
        String newAccountId;

        do {
            // Generate a new random long and convert it to a string
            long newRandomLong = (random.nextLong() % 90000000L) + 10000000L;
            newAccountId = String.format("%08d", Math.abs(newRandomLong));
        } while (!generatedAccountIds.add(newAccountId));

        // Store the unique account id in the instance variable accountid
        this.accountid = newAccountId;
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String validationMessage = validateInputs();
        RandomGenerator();

        if (validationMessage.isEmpty()) {
            // If validation is successful, display a pop-up message

            String name = jTextField2.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormat.format(jDateChooser1.getDate());
            String genderStatus = gender;
            String address = jTextField12.getText();
            String nationality = jTextField8.getText();
            String nrcValue = Jcmb_Region.getSelectedItem().toString() + " " + Jcmb_State.getSelectedItem().toString() + " " + Jcmb_Type.getSelectedItem().toString();
            String nrcNo = jTextField10.getText();
            String nrc = nrcValue + " " + nrcNo;
            String phNo = jTextField11.getText();
            String pin = dataharsh(jTextField9.getText());
            String accountIdNo = accountid;
            int amount = 0;
            String nn = dataharsh(jTextField13.getText());
            insertData(name, formattedDate, genderStatus, address, nationality, nrc, phNo, accountIdNo, pin, amount,nn);

            setVisible(false);
            userData = accountid;
            Loading_Form lf = new Loading_Form(null, userData);
            lf.setUpLoading();
            lf.setVisible(true);
            // Additional actions, if needed
        } else {
            // If validation fails, display a consolidated error message
            JOptionPane.showMessageDialog(this, validationMessage, "Validation Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    private String userData;//////data sent


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login_form lf = new Login_form();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        gender = "Female";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void Jcmb_StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmb_StateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcmb_StateActionPerformed

    private void Jcmb_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmb_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcmb_TypeActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(new java.awt.Color(220, 225, 222));
        jButton3.setForeground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(new java.awt.Color(84, 106, 118));
        jButton3.setForeground(new java.awt.Color(220, 225, 222));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(new java.awt.Color(220, 225, 222));
        jButton2.setForeground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new java.awt.Color(84, 106, 118));
        jButton2.setForeground(new java.awt.Color(220, 225, 222));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new java.awt.Color(220, 225, 222));
        jButton1.setForeground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new java.awt.Color(84, 106, 118));
        jButton1.setForeground(new java.awt.Color(220, 225, 222));
    }//GEN-LAST:event_jButton1MouseExited

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void Jcmb_RegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmb_RegionActionPerformed
        try {

            if (Jcmb_Region != null) {

                if (Jcmb_Region.getSelectedItem().equals("1")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("WAMANA");
                    Jcmb_State.addItem("KHAPHANA");
                    Jcmb_State.addItem("SALANA");
                    Jcmb_State.addItem("TANANA");
                    Jcmb_State.addItem("AHGAYA");
                    Jcmb_State.addItem("MANYANA");
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("KAMANA");
                    Jcmb_State.addItem("BAMANA");
                    Jcmb_State.addItem("YAKANA");
                    Jcmb_State.addItem("MASANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("PATAAH");
                    Jcmb_State.addItem("SAPABA");
                    Jcmb_State.addItem("MAKHABA");
                    Jcmb_State.addItem("KHABADA");
                    Jcmb_State.addItem("NAMANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("2")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("LAKANA");
                    Jcmb_State.addItem("DAMASA");
                    Jcmb_State.addItem("PHAYASA");
                    Jcmb_State.addItem("YATANA");
                    Jcmb_State.addItem("BALAKHA");
                    Jcmb_State.addItem("MASANA");
                    Jcmb_State.addItem("PHASANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("3")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("BAAHNA");
                    Jcmb_State.addItem("LABANA");
                    Jcmb_State.addItem("THATANA");
                    Jcmb_State.addItem("KAKAYA");
                    Jcmb_State.addItem("KASAKA");
                    Jcmb_State.addItem("MAWATA");
                    Jcmb_State.addItem("PHAPANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("4")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("HAKHANA");
                    Jcmb_State.addItem("HTATALA");
                    Jcmb_State.addItem("MATANA");
                    Jcmb_State.addItem("PALAWA");
                    Jcmb_State.addItem("MATAPA");
                    Jcmb_State.addItem("KAPALA");
                    Jcmb_State.addItem("PHALANA");
                    Jcmb_State.addItem("TATANA");
                    Jcmb_State.addItem("TAZANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("5")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("MAYANA");
                    Jcmb_State.addItem("AHYATA");
                    Jcmb_State.addItem("KHAOUTA");
                    Jcmb_State.addItem("BATALA");
                    Jcmb_State.addItem("SAKANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("MAMATA");
                    Jcmb_State.addItem("KALAHTA");
                    Jcmb_State.addItem("KALAWA");
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("KATHANA");
                    Jcmb_State.addItem("AHTANA");
                    Jcmb_State.addItem("BAMANA");
                    Jcmb_State.addItem("KALATA");
                    Jcmb_State.addItem("PALABA");
                    Jcmb_State.addItem("WATHANA");
                    Jcmb_State.addItem("HTAKHANA");
                    Jcmb_State.addItem("KHATANA");
                    Jcmb_State.addItem("HAMALA");
                    Jcmb_State.addItem("LAYANA");
                    Jcmb_State.addItem("NAYANA");
                    Jcmb_State.addItem("LAHANA");
                    Jcmb_State.addItem("MALANA");
                    Jcmb_State.addItem("PHAPANA");
                    Jcmb_State.addItem("YAMAPA");
                    Jcmb_State.addItem("SALAKA");
                    Jcmb_State.addItem("PALANA");
                    Jcmb_State.addItem("YABANA");
                    Jcmb_State.addItem("KABALA");
                    Jcmb_State.addItem("KHAOUNA");
                    Jcmb_State.addItem("KALANA");
                    Jcmb_State.addItem("TASANA");
                    Jcmb_State.addItem("YAOUNA");
                    Jcmb_State.addItem("WALANA");
                    Jcmb_State.addItem("TAMANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("6")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("HTAWANA");
                    Jcmb_State.addItem("LALANA");
                    Jcmb_State.addItem("THAYAKHA");
                    Jcmb_State.addItem("YAPHANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("TATHAYA");
                    Jcmb_State.addItem("KASANA");
                    Jcmb_State.addItem("PALANA");
                    Jcmb_State.addItem("KATHANA");
                    Jcmb_State.addItem("BAPANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("7")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("PAKHANA");
                    Jcmb_State.addItem("DAOUNA");
                    Jcmb_State.addItem("KATAKHA");
                    Jcmb_State.addItem("KAWANA");
                    Jcmb_State.addItem("NYALAPA");
                    Jcmb_State.addItem("YAKANA");
                    Jcmb_State.addItem("THANAPA");
                    Jcmb_State.addItem("WAMANA");
                    Jcmb_State.addItem("PAMANA");
                    Jcmb_State.addItem("PATANA");
                    Jcmb_State.addItem("KATHANA");
                    Jcmb_State.addItem("PAKHANA");
                    Jcmb_State.addItem("PATATA");
                    Jcmb_State.addItem("YATANA");
                    Jcmb_State.addItem("THAWATA");
                    Jcmb_State.addItem("MANYANA");
                    Jcmb_State.addItem("AHPHANA");
                    Jcmb_State.addItem("LAPATA");
                    Jcmb_State.addItem("MALANA");
                    Jcmb_State.addItem("NATALA");
                    Jcmb_State.addItem("ZAKANA");
                    Jcmb_State.addItem("KAPAKA");
                    Jcmb_State.addItem("TANGANA");
                    Jcmb_State.addItem("HTATAPA");
                    Jcmb_State.addItem("PHAMANA");
                    Jcmb_State.addItem("AHTANA");
                    Jcmb_State.addItem("YATAYA");
                    Jcmb_State.addItem("KAKANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("8")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("NAMANA");
                    Jcmb_State.addItem("MATHANA");
                    Jcmb_State.addItem("TATAKA");
                    Jcmb_State.addItem("YANAKHA");
                    Jcmb_State.addItem("KHAMANA");
                    Jcmb_State.addItem("MABANA");
                    Jcmb_State.addItem("PAPHANA");
                    Jcmb_State.addItem("NGAPHANA");
                    Jcmb_State.addItem("SALANA");
                    Jcmb_State.addItem("SATAYA");
                    Jcmb_State.addItem("GAGANA");
                    Jcmb_State.addItem("HTALANA");
                    Jcmb_State.addItem("SAMANA");
                    Jcmb_State.addItem("THAYANA");
                    Jcmb_State.addItem("SAPAWA");
                    Jcmb_State.addItem("MATANA");
                    Jcmb_State.addItem("AHLANA");
                    Jcmb_State.addItem("MALANA");
                    Jcmb_State.addItem("KAMANA");
                    Jcmb_State.addItem("PAKHAKA");
                    Jcmb_State.addItem("SAPHANA");
                    Jcmb_State.addItem("PAMANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("YASAKA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("9")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("AHMAZA");
                    Jcmb_State.addItem("KHAAHZA");
                    Jcmb_State.addItem("KHAMASA");
                    Jcmb_State.addItem("MAHAMA");
                    Jcmb_State.addItem("PAKAKHA");
                    Jcmb_State.addItem("PATHAKA");
                    Jcmb_State.addItem("AHMAYA");
                    Jcmb_State.addItem("AHMAYA");
                    Jcmb_State.addItem("KASANA");
                    Jcmb_State.addItem("MATHANA");
                    Jcmb_State.addItem("SAKATA");
                    Jcmb_State.addItem("TATAOU");
                    Jcmb_State.addItem("MAHTALA");
                    Jcmb_State.addItem("MALANA");
                    Jcmb_State.addItem("THASANA");
                    Jcmb_State.addItem("WATANA");
                    Jcmb_State.addItem("MAKHANA");
                    Jcmb_State.addItem("NAHTAKA");
                    Jcmb_State.addItem("NGAZANA");
                    Jcmb_State.addItem("TATHANA");
                    Jcmb_State.addItem("NYAOUNA");
                    Jcmb_State.addItem("KAPATA");
                    Jcmb_State.addItem("PAOULA");
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("SAKANA");
                    Jcmb_State.addItem("THAPAKA");
                    Jcmb_State.addItem("MATAYA");
                    Jcmb_State.addItem("YAMATHA");
                    Jcmb_State.addItem("PABANA");
                    Jcmb_State.addItem("DAKHATHA");
                    Jcmb_State.addItem("LAWANA");
                    Jcmb_State.addItem("PAMANA");
                    Jcmb_State.addItem("ZABATHA");
                    Jcmb_State.addItem("OUTATHA");
                    Jcmb_State.addItem("PABATHA");
                    Jcmb_State.addItem("TAKANA");
                    Jcmb_State.addItem("ZAYATHA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("10")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("MALAMA");
                    Jcmb_State.addItem("YAMANA");
                    Jcmb_State.addItem("KHASANA");
                    Jcmb_State.addItem("KAMAYA");
                    Jcmb_State.addItem("MADANA");
                    Jcmb_State.addItem("THAPHAYA");
                    Jcmb_State.addItem("THAHTANA");
                    Jcmb_State.addItem("BALANA");
                    Jcmb_State.addItem("KAHTANA");
                    Jcmb_State.addItem("PAMANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("11")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("SATANA");
                    Jcmb_State.addItem("PATANA");
                    Jcmb_State.addItem("NANATA");
                    Jcmb_State.addItem("YATHATA");
                    Jcmb_State.addItem("KAPHANA");
                    Jcmb_State.addItem("YABANA");
                    Jcmb_State.addItem("AHMANA");
                    Jcmb_State.addItem("MAAHNA");
                    Jcmb_State.addItem("MAOUNA");
                    Jcmb_State.addItem("MAPATA");
                    Jcmb_State.addItem("KATANA");
                    Jcmb_State.addItem("THATANA");
                    Jcmb_State.addItem("GAMANA");
                    Jcmb_State.addItem("MATANA");
                    Jcmb_State.addItem("BATHATA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("12")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("TAMANA");
                    Jcmb_State.addItem("OUKATA");
                    Jcmb_State.addItem("DAGASA");
                    Jcmb_State.addItem("DAGATA");
                    Jcmb_State.addItem("DAGAMA");
                    Jcmb_State.addItem("DAGAYA");
                    Jcmb_State.addItem("DAPANA");
                    Jcmb_State.addItem("PAZATA");
                    Jcmb_State.addItem("BAHTATA");
                    Jcmb_State.addItem("OUKAMA");
                    Jcmb_State.addItem("YAKANA");
                    Jcmb_State.addItem("THAGATA");
                    Jcmb_State.addItem("TAHKATA");
                    Jcmb_State.addItem("MAGATA");
                    Jcmb_State.addItem("TAKANA");
                    Jcmb_State.addItem("HTATAPA");
                    Jcmb_State.addItem("MAGADA");
                    Jcmb_State.addItem("MABANA");
                    Jcmb_State.addItem("YAPATHA");
                    Jcmb_State.addItem("LAKANA");
                    Jcmb_State.addItem("LATHAYA");
                    Jcmb_State.addItem("AHSANA");
                    Jcmb_State.addItem("KATANA");
                    Jcmb_State.addItem("KAKHAKA");
                    Jcmb_State.addItem("KAKAKA");
                    Jcmb_State.addItem("KAMANA");
                    Jcmb_State.addItem("KHAYANA");
                    Jcmb_State.addItem("SAKAKHA");
                    Jcmb_State.addItem("TATANA");
                    Jcmb_State.addItem("DALANA");
                    Jcmb_State.addItem("THALANA");
                    Jcmb_State.addItem("THAKHANA");
                    Jcmb_State.addItem("KAMAYA");
                    Jcmb_State.addItem("KATATA");
                    Jcmb_State.addItem("KAMATA");
                    Jcmb_State.addItem("SAKHANA");
                    Jcmb_State.addItem("SAKANA");
                    Jcmb_State.addItem("DAGANA");
                    Jcmb_State.addItem("BAHANA");
                    Jcmb_State.addItem("MAYAKA");
                    Jcmb_State.addItem("LAMATA");
                    Jcmb_State.addItem("LATHANA");
                    Jcmb_State.addItem("LAMANA");
                    Jcmb_State.addItem("AHLANA");
                    Jcmb_State.addItem("PABATA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("13")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("TAKANA");
                    Jcmb_State.addItem("SASANA");
                    Jcmb_State.addItem("KALANA");
                    Jcmb_State.addItem("YASANA");
                    Jcmb_State.addItem("NYAYANA");
                    Jcmb_State.addItem("PATAYA");
                    Jcmb_State.addItem("PALANA");
                    Jcmb_State.addItem("YANGANA");
                    Jcmb_State.addItem("PHAKHANA");
                    Jcmb_State.addItem("HAPANA");
                    Jcmb_State.addItem("KATANA");
                    Jcmb_State.addItem("MAKHANA");
                    Jcmb_State.addItem("MAYANA");
                    Jcmb_State.addItem("MAPATA");
                    Jcmb_State.addItem("TAKHALA");
                    Jcmb_State.addItem("MAPHANA");
                    Jcmb_State.addItem("MAYATA");
                    Jcmb_State.addItem("PAYANA");
                    Jcmb_State.addItem("MAMATA");
                    Jcmb_State.addItem("MABANA");
                    Jcmb_State.addItem("MASANA");
                    Jcmb_State.addItem("MATANA");
                    Jcmb_State.addItem("MASATA");
                    Jcmb_State.addItem("KAKHANA");
                    Jcmb_State.addItem("NAKHANA");
                    Jcmb_State.addItem("LAKHATA");
                    Jcmb_State.addItem("MANANA");
                    Jcmb_State.addItem("MAPANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("LALANA");
                    Jcmb_State.addItem("KAHANA");
                    Jcmb_State.addItem("LAKHANA");
                    Jcmb_State.addItem("MAKANA");
                    Jcmb_State.addItem("MAYANA");
                    Jcmb_State.addItem("KATHANA");
                    Jcmb_State.addItem("NASANA");
                    Jcmb_State.addItem("LAYANA");
                    Jcmb_State.addItem("THANANA");
                    Jcmb_State.addItem("KALANA");
                    Jcmb_State.addItem("MAYATA");
                    Jcmb_State.addItem("TAYANA");
                    Jcmb_State.addItem("KAMANA");
                    Jcmb_State.addItem("THAPANA");
                    Jcmb_State.addItem("MATATA");
                    Jcmb_State.addItem("NASANA");
                    Jcmb_State.addItem("NAMATA");
                    Jcmb_State.addItem("NAKHATA");
                    Jcmb_State.addItem("LAKANA");
                    Jcmb_State.addItem("KAKANA");
                    Jcmb_State.addItem("HAPANA");
                    Jcmb_State.setSelectedItem(null);
                } else if (Jcmb_Region.getSelectedItem().equals("14")) {
                    Jcmb_State.removeAllItems();
                    Jcmb_State.addItem("PATHANA");
                    Jcmb_State.addItem("KAKAHTA");
                    Jcmb_State.addItem("KAPANA");
                    Jcmb_State.addItem("NGAPATA");
                    Jcmb_State.addItem("THAPANA");
                    Jcmb_State.addItem("KAKANA");
                    Jcmb_State.addItem("YAKANA");
                    Jcmb_State.addItem("MAAHPA");
                    Jcmb_State.addItem("DANAPHA");
                    Jcmb_State.addItem("PATANA");
                    Jcmb_State.addItem("NYATANA");
                    Jcmb_State.addItem("HATHATA");
                    Jcmb_State.addItem("ZALANA");
                    Jcmb_State.addItem("KAKHANA");
                    Jcmb_State.addItem("MAAHNA");
                    Jcmb_State.addItem("AHGAPA");
                    Jcmb_State.addItem("LAMANA");
                    Jcmb_State.addItem("MAMANA");
                    Jcmb_State.addItem("WAKHAMA");
                    Jcmb_State.addItem("AHMANA");
                    Jcmb_State.addItem("PHAPANA");
                    Jcmb_State.addItem("BAKALA");
                    Jcmb_State.addItem("DADAYA");
                    Jcmb_State.addItem("KALANA");
                    Jcmb_State.addItem("LAPATA");
                    Jcmb_State.addItem("MAMAKA");
                    Jcmb_State.setSelectedItem(null);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // TODO add your handling code here:


    }//GEN-LAST:event_Jcmb_RegionActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        gender = "Male";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        if (Group6Info.instance != null) {
            Group6Info.instance.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseExited

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        Group6Info info = new Group6Info();
        info.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseEntered

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Jcmb_Region;
    private javax.swing.JComboBox<String> Jcmb_State;
    private javax.swing.JComboBox<String> Jcmb_Type;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
