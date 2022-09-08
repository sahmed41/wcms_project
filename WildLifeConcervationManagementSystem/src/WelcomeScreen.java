
import java.awt.Dimension;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class WelcomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeScreen
     */
    public WelcomeScreen() {
        initComponents();
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
        btn_ranger_login = new javax.swing.JButton();
        btn_regular_login = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setPreferredSize(new java.awt.Dimension(740, 760));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        btn_ranger_login.setBackground(new java.awt.Color(33, 37, 41));
        btn_ranger_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_ranger_login.setForeground(new java.awt.Color(248, 249, 250));
        btn_ranger_login.setText("Ranger Login");
        btn_ranger_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ranger_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ranger_login);
        btn_ranger_login.setBounds(310, 650, 160, 50);

        btn_regular_login.setBackground(new java.awt.Color(33, 37, 41));
        btn_regular_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_regular_login.setForeground(new java.awt.Color(248, 249, 250));
        btn_regular_login.setText("Regular Login");
        btn_regular_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regular_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regular_login);
        btn_regular_login.setBounds(140, 650, 140, 50);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_title.setText("Wildlife Conservation Management System (WCMS)");
        lbl_title.setOpaque(true);
        jPanel1.add(lbl_title);
        lbl_title.setBounds(-10, 0, 740, 100);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("<html>Welcome To The Wildlife Conservation Management System (WCMS) of the Department of Wildlife Conservation in Sri Lanka.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 390, 680, 70);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("<html>This project is the first step of automating the wildlife conservation in Sri Lanka. This project only  covers the preservation of elephants but we hope to expand this system to the preservation of all animals in Sri Lanka.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 440, 670, 120);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("<html>Plase if you are a wildlife ranger please click on the Wildlife Ranger Login button but if you are not a wildlie ranger please click on Regular login button");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 550, 690, 40);

        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wildlife_2.jpg"))); // NOI18N
        jPanel1.add(lbl_logo);
        lbl_logo.setBounds(140, 120, 310, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regular_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regular_loginActionPerformed
        // TODO add your handling code here:
        LoginPanel lp = new LoginPanel();
        lp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_regular_loginActionPerformed

    private void btn_ranger_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ranger_loginActionPerformed
        // TODO add your handling code here:
        WildlifeRangerLogin wrl = new WildlifeRangerLogin("xx");
        wrl.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_ranger_loginActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ranger_login;
    private javax.swing.JButton btn_regular_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_title;
    // End of variables declaration//GEN-END:variables
}
