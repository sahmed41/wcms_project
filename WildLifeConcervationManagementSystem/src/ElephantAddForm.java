
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class ElephantAddForm extends javax.swing.JFrame {

    /**
     * Creates new form ElephantAddForm
     */
    private String rangerId; 
    private String wpa;
    private String username;
    private String password;
    
    
    public ElephantAddForm(String rangerId, String wpa, String username, String password) {
        initComponents();
        setRangerId(rangerId);
        setWpa(wpa);
        setUsername(username);
        setPassword(password);
        
        populateHabitatCmb();
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
        lbl_title = new javax.swing.JLabel();
        lbl_chip_number = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_height = new javax.swing.JLabel();
        lbl_weight = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        lbl_habitat = new javax.swing.JLabel();
        txt_chip_number = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_height = new javax.swing.JTextField();
        txt_weight = new javax.swing.JTextField();
        lbl_error_message = new javax.swing.JLabel();
        cmb_habitat = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        cmb_gender = new javax.swing.JComboBox<>();
        btn_close = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_instructions5 = new javax.swing.JLabel();
        lbl_instructions6 = new javax.swing.JLabel();
        lbl_instructions7 = new javax.swing.JLabel();
        lbl_instructions8 = new javax.swing.JLabel();
        lbl_instructions9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(248, 249, 250));
        setMinimumSize(new java.awt.Dimension(200, 400));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_title.setText("Eliphant Rgistration Form");
        lbl_title.setOpaque(true);
        jPanel1.add(lbl_title);
        lbl_title.setBounds(0, 0, 870, 100);

        lbl_chip_number.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_chip_number.setText("Chip Number");
        jPanel1.add(lbl_chip_number);
        lbl_chip_number.setBounds(20, 130, 150, 40);

        lbl_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_name.setText("Name");
        jPanel1.add(lbl_name);
        lbl_name.setBounds(20, 180, 110, 40);

        lbl_height.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_height.setText("Height (in Meters)");
        jPanel1.add(lbl_height);
        lbl_height.setBounds(20, 280, 150, 40);

        lbl_weight.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_weight.setText("Weight (in Tons)");
        jPanel1.add(lbl_weight);
        lbl_weight.setBounds(20, 330, 150, 40);

        lbl_gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_gender.setText("Gender");
        jPanel1.add(lbl_gender);
        lbl_gender.setBounds(20, 230, 150, 40);

        lbl_habitat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_habitat.setText("Habitat");
        jPanel1.add(lbl_habitat);
        lbl_habitat.setBounds(20, 380, 150, 40);

        txt_chip_number.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_chip_number);
        txt_chip_number.setBounds(170, 130, 250, 40);

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_name);
        txt_name.setBounds(170, 180, 250, 40);

        txt_height.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_height);
        txt_height.setBounds(170, 280, 250, 40);

        txt_weight.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_weight);
        txt_weight.setBounds(170, 330, 250, 40);

        lbl_error_message.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_error_message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_error_message);
        lbl_error_message.setBounds(10, 530, 840, 40);

        cmb_habitat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_habitat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jPanel1.add(cmb_habitat);
        cmb_habitat.setBounds(170, 380, 250, 40);

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
        btn_add.setBounds(320, 450, 100, 50);

        cmb_gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel1.add(cmb_gender);
        cmb_gender.setBounds(170, 230, 250, 40);

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
        btn_close.setBounds(210, 450, 100, 50);

        jPanel2.setBackground(new java.awt.Color(248, 249, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(33, 37, 41))); // NOI18N

        lbl_instructions5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions5.setText("Make sure that you filled all fields.");
        lbl_instructions5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions6.setText("A vlid value from gender should be picked");
        lbl_instructions6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions7.setText("A valid value from habitat should be picked");
        lbl_instructions7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions8.setText("Height and weight must be number values");
        lbl_instructions8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions9.setText("Gender or Habitat value cannot be select");
        lbl_instructions9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_instructions9)
                    .addComponent(lbl_instructions6, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions7, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(741, 741, 741))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_instructions5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_instructions5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_instructions6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_instructions7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_instructions9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_instructions8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(440, 130, 410, 220);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        lbl_error_message.setText("");
        if (txt_chip_number.getText().equals("") ||
            txt_name.getText().equals("") ||
            String.valueOf(cmb_gender.getSelectedItem()).equals("Select") ||
            txt_height.getText().equals("") ||
            !Validator.isNumber(txt_height.getText()) ||
            txt_weight.getText().equals("") ||
            !Validator.isNumber(txt_weight.getText()) ||
            String.valueOf(cmb_habitat.getSelectedItem()).equals("Select")
                ) {
            lbl_error_message.setText("Please read the instructions and enter a vlid input");
        } else {
            Elephant e = new Elephant();
            e.setChip_number(txt_chip_number.getText()); 
            e.setPicture("xxx");
            e.setName(txt_name.getText());   
            e.setGender(String.valueOf(cmb_gender.getSelectedItem()));   
            e.setHeight(txt_height.getText());   
            e.setWeight(txt_weight.getText());   
            e.setHabitat(String.valueOf(cmb_habitat.getSelectedItem()));   
            e.setStatus("Alive");   
            e.setRegistered_date(String.valueOf(LocalDate.now()));   
            e.add();
            
            
            
            
            JOptionPane.showMessageDialog(this, "You have successfully added an elephant!");
            
            WildlifeRangerDashboard wrd = new WildlifeRangerDashboard(getRangerId(), getUsername(), getPassword(), "Wildlife Ranger");
            wrd.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        WildlifeRangerDashboard wrd = new WildlifeRangerDashboard(getRangerId(), getUsername(), getPassword(), "Wildlife Ranger");
            wrd.setVisible(true);
            setVisible(false);
    }//GEN-LAST:event_btn_closeActionPerformed

    
//    Setters
    public void setRangerId(String rangerId) {    

        this.rangerId = rangerId;
    }

    public void setWpa(String wpa) {
        this.wpa = wpa;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

//    Getters

    public String getRangerId() {
        return rangerId;
    }

    public String getWpa() {
        return wpa;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
    
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//        */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ElephantAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ElephantAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ElephantAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ElephantAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ElephantAddForm("87","11").setVisible(true);
////                System.out.println(get);
//            }
//        });
//    }
//    
    private void populateHabitatCmb () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT id FROM habitat WHERE wpa = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getWpa());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmb_habitat.addItem(rs.getString("id"));
            } 
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JComboBox<String> cmb_gender;
    private javax.swing.JComboBox<String> cmb_habitat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_chip_number;
    private javax.swing.JLabel lbl_error_message;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_habitat;
    private javax.swing.JLabel lbl_height;
    private javax.swing.JLabel lbl_instructions5;
    private javax.swing.JLabel lbl_instructions6;
    private javax.swing.JLabel lbl_instructions7;
    private javax.swing.JLabel lbl_instructions8;
    private javax.swing.JLabel lbl_instructions9;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_weight;
    private javax.swing.JTextField txt_chip_number;
    private javax.swing.JTextField txt_height;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_weight;
    // End of variables declaration//GEN-END:variables
}