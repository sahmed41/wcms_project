
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class WpaAddForm extends javax.swing.JFrame {

    /**
     * Creates new form WpaAddForm
     */
    private String generalId;
    private String username;
    private String password;
    
    public WpaAddForm(String generalId, String username, String password) {
        initComponents();
        setGeneralId(generalId);
        setUsername(username);
        setPassword(password);
        populateCmbDepartmentOfficer();
    }
    
//    Setters

    public void setGeneralId(String generalId) {
        this.generalId = generalId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
//    Getters

    public String getGeneralId() {

        return generalId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
//    Other methods
    private void populateCmbDepartmentOfficer () { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT id FROM user WHERE role = ?";
            PreparedStatement pst = conn.prepareStatement(sql);            
            pst.setString(1, "Department Officer");   
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {                
                cmb_department_officer.addItem(rs.getString("id"));               
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_area = new javax.swing.JLabel();
        lbl_province = new javax.swing.JLabel();
        lbl_dpartment_officer = new javax.swing.JLabel();
        lbl_error_message = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_area = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        cmb_department_officer = new javax.swing.JComboBox<>();
        cmb_province = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lbl_instructions = new javax.swing.JLabel();
        lbl_instructions1 = new javax.swing.JLabel();
        lbl_instructions2 = new javax.swing.JLabel();
        lbl_instructions4 = new javax.swing.JLabel();
        lbl_instructions3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 350));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_title.setText("WPA Add Form");
        lbl_title.setOpaque(true);
        jPanel1.add(lbl_title);
        lbl_title.setBounds(0, 0, 930, 100);

        lbl_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_name.setText("Name");
        jPanel1.add(lbl_name);
        lbl_name.setBounds(10, 130, 150, 40);

        lbl_area.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_area.setText("Area");
        jPanel1.add(lbl_area);
        lbl_area.setBounds(10, 180, 150, 40);

        lbl_province.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_province.setText("Province");
        jPanel1.add(lbl_province);
        lbl_province.setBounds(10, 230, 150, 40);

        lbl_dpartment_officer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_dpartment_officer.setText("Department Officer");
        jPanel1.add(lbl_dpartment_officer);
        lbl_dpartment_officer.setBounds(10, 290, 150, 40);

        lbl_error_message.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_error_message.setForeground(new java.awt.Color(255, 255, 255));
        lbl_error_message.setText("jLabel6");
        jPanel1.add(lbl_error_message);
        lbl_error_message.setBounds(10, 450, 890, 50);

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_name);
        txt_name.setBounds(160, 130, 260, 40);

        txt_area.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_area);
        txt_area.setBounds(160, 180, 260, 40);

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
        btn_add.setBounds(320, 360, 100, 50);

        btn_close.setBackground(new java.awt.Color(33, 37, 41));
        btn_close.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_close.setForeground(new java.awt.Color(248, 249, 250));
        btn_close.setText("Back");
        btn_close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close);
        btn_close.setBounds(210, 360, 100, 50);

        cmb_department_officer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_department_officer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jPanel1.add(cmb_department_officer);
        cmb_department_officer.setBounds(160, 290, 260, 40);

        cmb_province.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_province.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Central", "Eastern", "North Central", "Northern", "North Western", "Sabaragamuwa", "Southern", "Uva", "Western" }));
        jPanel1.add(cmb_province);
        cmb_province.setBounds(160, 230, 260, 40);

        jPanel2.setBackground(new java.awt.Color(248, 249, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(33, 37, 41))); // NOI18N

        lbl_instructions.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions.setText("Make sure that you filled all fields.");
        lbl_instructions.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions1.setText("Area has to be a number");
        lbl_instructions1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions2.setText("A value from the provice drop down must be picked up");
        lbl_instructions2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions4.setText("A value from the Department officer should be picked up");
        lbl_instructions4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_instructions3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_instructions3.setText("Province and Department officer values can not be select");
        lbl_instructions3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_instructions1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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
        jPanel2.setBounds(490, 130, 390, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (txt_name.getText().equals("") || 
                txt_area.getText().equals("") ||
                !Validator.isNumber(txt_area.getText()) ||
                String.valueOf(cmb_province.getSelectedItem()).equals("Select") ||
                String.valueOf(cmb_department_officer.getSelectedItem()).equals("Select") 
                ) {
            lbl_error_message.setText("Please refer to the instructions and enter valid inputs!");
            
        } else {
            DirectorGeneral dg = new DirectorGeneral();
            dg.setId(getGeneralId());
            dg.addWpa(txt_name.getText(), 
                    Integer.parseInt(txt_area.getText()) , 
                    LocalDate.now(), 
                    String.valueOf(cmb_province.getSelectedItem()), 
                    String.valueOf(cmb_department_officer.getSelectedItem()));
            JOptionPane.showMessageDialog(this, "WPA Successfully added!");
            DirectorGeneralDashBoard dgd = new DirectorGeneralDashBoard(getGeneralId(), getUsername(), getPassword(), "Director General");
            dgd.setVisible(true);
            dispose();
        }
       
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        DirectorGeneralDashBoard dgd = new DirectorGeneralDashBoard(getGeneralId(), getUsername(), getPassword(), "Director General");
            dgd.setVisible(true);
            dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

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
//            java.util.logging.Logger.getLogger(WpaAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(WpaAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(WpaAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(WpaAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WpaAddForm("35", "azar", "ahmedzafar").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JComboBox<String> cmb_department_officer;
    private javax.swing.JComboBox<String> cmb_province;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_area;
    private javax.swing.JLabel lbl_dpartment_officer;
    private javax.swing.JLabel lbl_error_message;
    private javax.swing.JLabel lbl_instructions;
    private javax.swing.JLabel lbl_instructions1;
    private javax.swing.JLabel lbl_instructions2;
    private javax.swing.JLabel lbl_instructions3;
    private javax.swing.JLabel lbl_instructions4;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_province;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}