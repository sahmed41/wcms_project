
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class WildLifeRangerAddForm extends javax.swing.JFrame {

    /**
     * Creates new form WildLifeRangerAddForm
     */
//    JDatePicker dob;
  
    JTable t;
    private String id;
    private DepartmentOfficer do1;
    public WildLifeRangerAddForm(String id, JTable x) {
        initComponents();
        setId(id); // Setting up the ranger id
        populateCmbWpa();
        do1 = initiateDepartmentOfficer(getId());
        setT(x);
    }
    
//    Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setT(JTable t) {
        this.t = t;
    }
    
    
    
//    Getters

    public String getId() {
        return id;
    }

    public JTable getT() {
        return t;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        txt_first_name = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        lbl_dob = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        dtch_dob = new com.toedter.calendar.JDateChooser();
        lbl_wpa = new javax.swing.JLabel();
        txt_nic = new javax.swing.JTextField();
        lbl_nic = new javax.swing.JLabel();
        cmb_wpa = new javax.swing.JComboBox<>();
        lbl_address = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        lbl_test = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_instructions = new javax.swing.JLabel();
        lbl_instructions1 = new javax.swing.JLabel();
        lbl_instructions2 = new javax.swing.JLabel();
        lbl_instructions4 = new javax.swing.JLabel();
        lbl_instructions3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 760));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        lbl_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_name.setText("Name ");
        jPanel1.add(lbl_name);
        lbl_name.setBounds(20, 120, 70, 22);

        txt_first_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_first_name.setText("First Name");
        txt_first_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_first_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_first_name);
        txt_first_name.setBounds(120, 120, 160, 28);

        txt_last_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_last_name.setText("Last Name");
        jPanel1.add(txt_last_name);
        txt_last_name.setBounds(290, 120, 160, 28);

        jLabel1.setBackground(new java.awt.Color(33, 37, 41));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 249, 250));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jLabel1.setText("Register Wildlifer Ranger");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 980, 100);

        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_address.setRows(5);
        jScrollPane1.setViewportView(txt_address);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(120, 170, 330, 116);

        lbl_dob.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_dob.setText("Date of Birth");
        jPanel1.add(lbl_dob);
        lbl_dob.setBounds(20, 310, 120, 30);

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email);
        txt_email.setBounds(120, 360, 320, 30);

        lbl_email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_email.setText("Email");
        jPanel1.add(lbl_email);
        lbl_email.setBounds(20, 360, 100, 30);

        dtch_dob.setDateFormatString("yyyy-MM-dd");
        dtch_dob.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(dtch_dob);
        dtch_dob.setBounds(120, 310, 200, 30);

        lbl_wpa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_wpa.setText("Wildlife Protected Area");
        jPanel1.add(lbl_wpa);
        lbl_wpa.setBounds(20, 470, 180, 22);

        txt_nic.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nicActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nic);
        txt_nic.setBounds(120, 410, 320, 30);

        lbl_nic.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_nic.setText("NIC");
        jPanel1.add(lbl_nic);
        lbl_nic.setBounds(20, 410, 100, 30);

        cmb_wpa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_wpa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmb_wpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_wpaActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_wpa);
        cmb_wpa.setBounds(220, 470, 220, 28);

        lbl_address.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_address.setText("Address");
        jPanel1.add(lbl_address);
        lbl_address.setBounds(20, 210, 70, 20);

        btn_close.setBackground(new java.awt.Color(33, 37, 41));
        btn_close.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_close.setForeground(new java.awt.Color(248, 249, 250));
        btn_close.setText("Back");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close);
        btn_close.setBounds(120, 540, 90, 50);

        btn_add.setBackground(new java.awt.Color(33, 37, 41));
        btn_add.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(248, 249, 250));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add);
        btn_add.setBounds(350, 540, 90, 50);

        btn_clear.setBackground(new java.awt.Color(33, 37, 41));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(248, 249, 250));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear);
        btn_clear.setBounds(240, 540, 90, 50);

        lbl_test.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_test.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_test);
        lbl_test.setBounds(20, 610, 940, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(33, 37, 41))); // NOI18N

        lbl_instructions.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions.setText("Make sure that you filled all fields.");
        lbl_instructions.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions1.setText("First and last names should be something other than First Name and Last Name.");
        lbl_instructions1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions2.setText("Email should be correctly formatted and cannot exist in WCMS database.");
        lbl_instructions2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions4.setText("NIC should not exist in the WCMS either.");
        lbl_instructions4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions3.setText("A valid wildlife protected area must be selected.");
        lbl_instructions3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbl_instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_instructions1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_instructions2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_instructions4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_instructions3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(490, 130, 470, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_first_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_first_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_first_nameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nicActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        lbl_test.setText("");
        
        if (txt_first_name.getText().equals("First Name") || 
                txt_first_name.getText().equals("") ||
                txt_last_name.getText().equals("Last Name") ||
                txt_last_name.getText().equals("") ||
                txt_address.getText().equals("") ||
                dtch_dob.getDate() == null ||
                txt_email.getText().equals("") ||
                validateEmailFormat(String.valueOf(txt_email.getText())) == false ||
                validateEmail(txt_email.getText()) ||
                txt_nic.getText().equals("") ||
                validateNic(txt_nic.getText()) ||
                String.valueOf(cmb_wpa.getSelectedItem()).equals("Select")                 
                ) {
            lbl_test.setText("Follow the instructions and enter valid values and try again!");
        } else {
            
            Date dob = dtch_dob.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-d");
            String dob_mysql_date_string = formatter.format(dob);
            int dob_year = Integer.parseInt(dob_mysql_date_string.substring(0,4));
            int dob_month = Integer.parseInt(dob_mysql_date_string.substring(5,7));
            int dob_day = Integer.parseInt(dob_mysql_date_string.substring(8));
            String message = do1.registerRanger(txt_first_name.getText(),
                    txt_last_name.getText(), 
                    txt_address.getText(), 
                    LocalDate.of(dob_year, dob_month, dob_day), 
                    txt_email.getText(), 
                    txt_nic.getText(), 
                    setUpWpaValue(String.valueOf(cmb_wpa.getSelectedItem())));
            
//            DepartmentOfficerDashboard dod = new DepartmentOfficerDashboard(id, "xxx", "xxx", "xx");
//            getT().gettableModel.fireTableDataChanged()
//            DefaultTableModel ranger_table = (DefaultTableModel)getT().getModel();
//            ranger_table.fireTableDataChanged();
            JOptionPane.showMessageDialog(this, "Creation Successful! Your information:" + message);
            DepartmentOfficerDashboard dod = new DepartmentOfficerDashboard(getId(), "xx", "xx", "xx");
            dod.setVisible(true);
            dispose();
            
           
                   
        }
        
        


        
    }//GEN-LAST:event_btn_addActionPerformed

    private void cmb_wpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_wpaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_wpaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        txt_first_name.setText("First Name");
        txt_last_name.setText("Last Name");
        txt_address.setText("");
        dtch_dob.setDate(null);
        txt_email.setText("");
        txt_nic.setText("");
        cmb_wpa.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        DepartmentOfficerDashboard dod = new DepartmentOfficerDashboard(getId(), "xxx", "xx", "xx");
        dod.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed
    
    private void populateCmbWpa() {
//        This method will add values of wpa that comes under this department officer to the combo box in the form
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT name FROM wildlifeprotectedarea WHERE department_officer = ?";
//            SELECT column1, column2, ...
//FROM table_name;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(getId()));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmb_wpa.addItem(rs.getString("name"));
            } 

            conn.close();
        } catch (Exception e) {
            lbl_test.setText("Failiure: " + e);
        }
    
    }
    
    private DepartmentOfficer initiateDepartmentOfficer (String id) {
        DepartmentOfficer do1 = new DepartmentOfficer();
        do1.setId(id);
        return do1;
    }
    
    private String setUpWpaValue (String wpa_name) {
        String wpa_id;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT id FROM wildlifeprotectedarea WHERE name = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, wpa_name);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    wpa_id = rs.getString("id");
                } else {
                wpa_id = "No WPAs matches that name";
                }
                 
                
                conn.close();
            } catch (Exception e) {
                wpa_id = "Failiure: " + e;
            }
        return wpa_id;
    }
    
    private boolean validateNic(String nic) {
        boolean status = false;
        String message;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT nic FROM user WHERE nic = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, nic);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    status = true;
                } else {
                    status = false;
                }
                 
                
                conn.close();
            } catch (Exception e) {
                message = "Failiure: " + e;
            }
        return status;
    }
    
    private boolean validateEmailFormat(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    public boolean validateEmail (String email) {
        boolean status = false;
        String message;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT email FROM user WHERE email = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    status = true;
                } else {
                    status = false;
                }
                 
                
                conn.close();
            } catch (Exception e) {
                message = "Failiure: " + e;
            }
        return status;
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(WildLifeRangerAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(WildLifeRangerAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(WildLifeRangerAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(WildLifeRangerAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WildLifeRangerAddForm().setVisible(true);
//            }
//        });
//    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JComboBox<String> cmb_wpa;
    private com.toedter.calendar.JDateChooser dtch_dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_instructions;
    private javax.swing.JLabel lbl_instructions1;
    private javax.swing.JLabel lbl_instructions2;
    private javax.swing.JLabel lbl_instructions3;
    private javax.swing.JLabel lbl_instructions4;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_nic;
    private javax.swing.JLabel lbl_test;
    private javax.swing.JLabel lbl_wpa;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_nic;
    // End of variables declaration//GEN-END:variables
}
