/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banking_system;

import com.toedter.calendar.JDateChooser;
import java.security.MessageDigest;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class ForgetPassword extends javax.swing.JFrame {

    Connection con = null;
    private static Set<String> generatedPins = new HashSet<>();
    private String generatedpin;
    private Random random = new Random();

    public ForgetPassword() {
        initComponents();
        con = DBconnect.connect();
        GregorianCalendar();
        Jcmb_Region.setSelectedItem(null);
        Jcmb_State.setSelectedItem(null);
        Jcmb_Type.setSelectedItem(null);
    }

    public void GregorianCalendar() {
        // Creating a GregorianCalendar instance and setting a specific date
        GregorianCalendar gregorianCalendar = new GregorianCalendar(); // Year, Month (0-11), Day

        // Getting and printing the set date
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH) + 1; // Adding 1 to the month since it is zero-based
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        jTextField4.setText(+day + "-" + month + "-" + year);

    }

    private boolean isValidAccountno(String pin) {
        // Implement your PIN validation logic here
        // For example, check if it's a 4-digit number
        return pin.matches("\\d{8}");
    }

    private boolean isValidNRC(String nrc) {
        // Implement your NRC validation logic here
        // For example, check if it's not empty
        return !nrc.isEmpty() && nrc.matches("\\d{6}");
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

    private boolean isValidNickname(String nickname) {
        // Define a regular expression pattern allowing any combination of characters but no spaces
        String regex = "^[^\\s]+$";

        // Check if the nickname is not empty and matches the regular expression
        return !nickname.isEmpty() && nickname.matches(regex);
    }

    private boolean isValidDynamicComboBox(String selectedValue) {

        // Check if the selected value is not null and not equal to the default value
        //return selectedValue != null && !defaultValue.equals(selectedValue);
        // Replace "YourDefaultValue" with the appropriate default value
        return selectedValue != null;
    }

    public void RandomGenerator() {
        String newPin;

        do {
            // Generate a new random long and convert it to a string
            long newRandomLong = (random.nextLong() % 900000L) + 100000L;
            newPin = String.format("%06d", Math.abs(newRandomLong));
        } while (!generatedPins.add(newPin));

        // Store the unique account id in the instance variable accountid
        this.generatedpin = newPin;
    }

    private String validateInputs() {
        StringBuilder validationErrors = new StringBuilder();

        // Validate username
        if (!isValidAccountno(jTextField1.getText())) {
            validationErrors.append("Invalid Account No. \n");
        }

        if (!isValidDate(jDateChooser1)) {
            validationErrors.append("Please select a valid date.\n  ");
        }

        if (!isValidNickname(jTextField2.getText())) {
            validationErrors.append("Invalid nickname < Your nickname must not include space..  >\n ");
        }

        // Validate NRC
        if (!isValidNRC(jTextField3.getText())) {
            validationErrors.append("Invalid NRC < Please enter Your NRC numbers. >\n");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Jcmb_Type = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Jcmb_Region = new javax.swing.JComboBox<>();
        Jcmb_State = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 225, 222));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_system/images/IMG_20240216_112558_936-removebg-preview.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 0, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 106, 118));
        jLabel6.setText("BK Bank");

        jPanel2.setBackground(new java.awt.Color(84, 106, 118));

        jPanel3.setBackground(new java.awt.Color(84, 106, 118));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        Jcmb_Type.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Jcmb_Type.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C", "AC", "NC", "V", "M", "N" }));
        Jcmb_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_TypeActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(84, 106, 118));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date of Birth");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NRC");

        jDateChooser1.setBackground(new java.awt.Color(220, 225, 222));
        jDateChooser1.setForeground(new java.awt.Color(84, 106, 118));
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateChooser1.setMaxSelectableDate(new java.util.Date(253376188303000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-62135789329000L));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(84, 106, 118));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nickname");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(84, 106, 118));

        Jcmb_Region.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Jcmb_Region.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_Region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        Jcmb_Region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_RegionActionPerformed(evt);
            }
        });

        Jcmb_State.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        Jcmb_State.setForeground(new java.awt.Color(84, 106, 118));
        Jcmb_State.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmb_StateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Account No.");

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(84, 106, 118));

        jButton2.setBackground(new java.awt.Color(84, 106, 118));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Get Pin");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Jcmb_Region, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jcmb_State, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jcmb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcmb_Region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jcmb_State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jcmb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(84, 106, 118));
        jLabel15.setText("Date");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(220, 225, 222));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(84, 106, 118));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jcmb_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmb_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcmb_TypeActionPerformed

    private void Jcmb_StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmb_StateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcmb_StateActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        Login_form lf = new Login_form();
        lf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new java.awt.Color(220, 225, 222));
        jButton1.setForeground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new java.awt.Color(84, 106, 118));
        jButton1.setForeground(new java.awt.Color(220, 225, 222));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(new java.awt.Color(220, 225, 222));
        jButton2.setForeground(new java.awt.Color(84, 106, 118));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new java.awt.Color(84, 106, 118));
        jButton2.setForeground(new java.awt.Color(220, 225, 222));
    }//GEN-LAST:event_jButton2MouseExited
    private void pinUpdate() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");

        Jcmb_Region.setSelectedItem(null);
        Jcmb_State.setSelectedItem(null);
        Jcmb_Type.setSelectedItem(null);
        jDateChooser1.setCalendar(null);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String validationMessage = validateInputs();
        RandomGenerator();
        if (validationMessage.isEmpty()) {
            String accountNo = jTextField1.getText();
            String nrcValue = Jcmb_Region.getSelectedItem().toString() + " " + Jcmb_State.getSelectedItem().toString() + " " + Jcmb_Type.getSelectedItem().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormat.format(jDateChooser1.getDate());
            String nrcNo = jTextField3.getText();
            String nrc = nrcValue + " " + nrcNo;
            String nickName = dataharsh(jTextField2.getText());
            String pin = generatedpin;
            try {
                String dbaccount = "SELECT  `dob`,  `nrc`,  `accountid`,   `nn` FROM `sign_up_form` WHERE  `accountid`=?";
                PreparedStatement pst = con.prepareStatement(dbaccount);
                pst.setString(1, accountNo); // Set the parameter using PreparedStatement
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String dbnrc = rs.getString("nrc");
                    if (dbnrc.equals(nrc)) {
                        String dob = rs.getString("dob");
                        if (dob.equals(formattedDate)) {
                            String dobnn = rs.getString("nn");
                            if (dobnn.equals(nickName)) {
                                JOptionPane.showMessageDialog(rootPane, "Your Otp :" + pin + "\nYou can change the pin in Home_Page>> Settings>> Change Pin");
                                String sql = "UPDATE `sign_up_form` SET `pin`='" + dataharsh(pin) + "' WHERE `accountid`='" + accountNo + "'";
                                pst = con.prepareStatement(sql);
                                pst.execute();
                                pinUpdate();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Wrong Nickname..");
                            }

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Wrong Date of Birth. ");

                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Wrong NRC ");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid user");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }

        } else {
            // If validation fails, display a consolidated error message
            JOptionPane.showMessageDialog(this, validationMessage, "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        Group6Info info = new Group6Info();
        info.setVisible(true);
        
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        if (Group6Info.instance != null) {
            Group6Info.instance.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseExited
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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Jcmb_Region;
    private javax.swing.JComboBox<String> Jcmb_State;
    private javax.swing.JComboBox<String> Jcmb_Type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
