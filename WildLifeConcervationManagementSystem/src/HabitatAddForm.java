
import java.time.LocalDate;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class HabitatAddForm extends javax.swing.JFrame {

    /**
     * Creates new form HabitatAddForm
     */
    private String rangerId;
    private String wpa;
    private String username;
    private String password;
    
    public HabitatAddForm(String rangerId, String wpa, String username, String password) {
        initComponents();
        setRangerId(rangerId);
        setWpa(wpa);
        setUsername(username);
        setPassword(password);
//        System.out.println("ID: " + getRangerId());
//        System.out.println("WPA: " + getWpa());
//        System.out.println("Username:" + getUsername());
//        System.out.println("Password: " + getPassword());
        System.out.println("XID: " + rangerId);
        System.out.println("XWPA: " + wpa);
        System.out.println("XUsername: " + username);
        System.out.println("XPassword: " + password);
        
    }

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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_heading = new javax.swing.JLabel();
        lbl_latitude = new javax.swing.JLabel();
        txt_latitude = new javax.swing.JTextField();
        lbl_longitude = new javax.swing.JLabel();
        txt_longitude = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        lbl_error_message = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 350));
        setSize(new java.awt.Dimension(400, 400));

        jPanel1.setLayout(null);

        lbl_heading.setBackground(new java.awt.Color(33, 37, 41));
        lbl_heading.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(248, 249, 250));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_heading.setText("Add Habitat");
        lbl_heading.setOpaque(true);
        jPanel1.add(lbl_heading);
        lbl_heading.setBounds(0, 0, 400, 94);

        lbl_latitude.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_latitude.setText("Latitude");
        jPanel1.add(lbl_latitude);
        lbl_latitude.setBounds(20, 120, 120, 40);

        txt_latitude.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_latitude);
        txt_latitude.setBounds(170, 120, 210, 40);

        lbl_longitude.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_longitude.setText("Longitude");
        jPanel1.add(lbl_longitude);
        lbl_longitude.setBounds(20, 170, 120, 40);

        txt_longitude.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txt_longitude);
        txt_longitude.setBounds(170, 170, 210, 40);

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
        btn_add.setBounds(280, 230, 100, 40);

        lbl_error_message.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_error_message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_error_message);
        lbl_error_message.setBounds(20, 310, 360, 40);

        btn_back.setBackground(new java.awt.Color(33, 37, 41));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(248, 249, 250));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back);
        btn_back.setBounds(170, 230, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        lbl_error_message.setText("");
        if (txt_latitude.getText().equals("") || 
                !Validator.isNumber(txt_latitude.getText()) ||
                txt_longitude.getText().equals("") ||
                !Validator.isNumber(txt_longitude.getText()) ) {
            lbl_error_message.setText("Lattitude and longitude are required to add habitat as numbers");
        } else {
            String latitude = txt_latitude.getText();
            String longitude = txt_longitude.getText();
            String location = latitude + ", " + longitude;

            Habitat h = new Habitat();
            h.setLocation(location);
            h.setWpa(getWpa());
            h.setRegistered_date(String.valueOf(LocalDate.now()));
            h.add();
            
            JOptionPane.showMessageDialog(this, "Habitat Successfully Added!");
            WildlifeRangerDashboard wrd = new WildlifeRangerDashboard(getRangerId(), getUsername(), getPassword(), "Wildlife Ranger");
            wrd.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        WildlifeRangerDashboard wrd = new WildlifeRangerDashboard(getRangerId(), getUsername(), getPassword(), "Wildlife Ranger");
        wrd.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

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
//            java.util.logging.Logger.getLogger(HabitatAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HabitatAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HabitatAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HabitatAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HabitatAddForm("87", "11").setVisible(true);
//            }
//        });
//    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_error_message;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_latitude;
    private javax.swing.JLabel lbl_longitude;
    private javax.swing.JTextField txt_latitude;
    private javax.swing.JTextField txt_longitude;
    // End of variables declaration//GEN-END:variables
}
