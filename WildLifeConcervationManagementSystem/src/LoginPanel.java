
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class LoginPanel extends javax.swing.JFrame {

    /**
     * Creates new form LoginPanel
     */
    
//    User properties necessary for login
    private String id;
    private String username;
    private String password;
    private String role;
    

    
    public LoginPanel() {
        initComponents();
        
    }
    
//    Setters

    public void setId(String id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
//    Getters
    
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_icon = new javax.swing.JLabel();
        lbl_test = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        lbl_test_role_test = new javax.swing.JLabel();
        btn_close = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(248, 249, 250));
        setMinimumSize(new java.awt.Dimension(610, 350));

        main_panel.setBackground(new java.awt.Color(248, 249, 250));
        main_panel.setForeground(new java.awt.Color(248, 249, 250));
        main_panel.setLayout(null);

        lbl_username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_username.setText("Username");
        main_panel.add(lbl_username);
        lbl_username.setBounds(290, 200, 100, 40);

        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        main_panel.add(txt_username);
        txt_username.setBounds(370, 200, 300, 40);

        lbl_password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_password.setText("Password");
        main_panel.add(lbl_password);
        lbl_password.setBounds(290, 260, 90, 40);

        btn_login.setBackground(new java.awt.Color(33, 37, 41));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_login.setForeground(new java.awt.Color(248, 249, 250));
        btn_login.setText("Login");
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        main_panel.add(btn_login);
        btn_login.setBounds(560, 320, 110, 50);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon("C:\\Users\\mws_a\\Desktop\\wcms icon\\logo.png")); // NOI18N
        lbl_title.setText("  Wildlife Concervation Management System");
        lbl_title.setOpaque(true);
        main_panel.add(lbl_title);
        lbl_title.setBounds(0, 0, 880, 110);

        lbl_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wildlife_2.jpg"))); // NOI18N
        main_panel.add(lbl_icon);
        lbl_icon.setBounds(10, 160, 270, 240);

        lbl_test.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_test.setForeground(new java.awt.Color(255, 0, 0));
        main_panel.add(lbl_test);
        lbl_test.setBounds(270, 450, 370, 30);

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        main_panel.add(txt_password);
        txt_password.setBounds(370, 260, 300, 40);
        main_panel.add(lbl_test_role_test);
        lbl_test_role_test.setBounds(10, 430, 220, 70);

        btn_close.setBackground(new java.awt.Color(33, 37, 41));
        btn_close.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_close.setForeground(new java.awt.Color(248, 249, 250));
        btn_close.setText("Close");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        main_panel.add(btn_close);
        btn_close.setBounds(320, 320, 110, 50);

        btn_back.setBackground(new java.awt.Color(33, 37, 41));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(248, 249, 250));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        main_panel.add(btn_back);
        btn_back.setBounds(440, 320, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        if (String.valueOf(txt_username.getText()).equals("Admin") && String.valueOf(txt_password.getText()).equals("cypher")) {
            SystemAdministratorDashboard sad = new SystemAdministratorDashboard("Admin", "cypher");
            sad.setVisible(true); 
            this.setVisible(false);
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT id, username, password, role FROM user WHERE username = ? AND password = ?";
    //            SELECT column1, column2, ...
    //FROM table_name;
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, String.valueOf(txt_username.getText()));
                pst.setString(2, String.valueOf(txt_password.getText()));
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    this.setId(rs.getString("id"));
                    this.setUsername(rs.getString("username"));
                    this.setPassword(rs.getString("password"));
                    this.setRole(rs.getString("role"));
                    
//                  Setting up Logging in for different roles
                    if (this.getRole().equals("Director General")) {
                        DirectorGeneralDashBoard dgd = new DirectorGeneralDashBoard(this.getId(), this.getUsername(), this.getPassword(), this.getRole());
                        dgd.setVisible(true);    
                        this.setVisible(false);
                    } else if (this.getRole().equals("Department Officer")) {
                        DepartmentOfficerDashboard dod = new DepartmentOfficerDashboard(this.getId(), this.getUsername(), this.getPassword(), this.getRole());
                        dod.setVisible(true);    
                        this.setVisible(false);
                    } else if (this.getRole().equals("Wildlife Ranger")) {
                        WildlifeRangerLogin wrd = new WildlifeRangerLogin(this.getId());
                        wrd.setVisible(true);    
                        this.setVisible(false);
                    } else {
                        lbl_test.setText("Invalid role");
                    } 
                    
                } else {
                    lbl_test.setText("Your username or password is wrong!!");
                }
                conn.close();
            } catch (Exception e) {
                System.out.println("Failiure: " + e);
            }
            
                       
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        WelcomeScreen ws = new WelcomeScreen();
        ws.setVisible(true);
        dispose();
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
//            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new LoginPanel().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_test;
    private javax.swing.JLabel lbl_test_role_test;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
