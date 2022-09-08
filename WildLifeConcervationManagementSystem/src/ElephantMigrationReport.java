
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class ElephantMigrationReport extends javax.swing.JFrame {

    /**
     * Creates new form ElephantMigrationReport
     */
    private String generalId;
    private String username;
    private String password;
    private String role;
    
    public ElephantMigrationReport(String generalId, String username, String password, String role) {
        initComponents();
        populateElephantCmb();
        populateMigrationTable("%");
        createMigrationLineGraph("%");
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

    public void setRole(String role) {
        this.role = role;
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

    public String getRole() {
        return role;
    }
    
//    Other methods
    private void populateMigrationTable (String id) {
//        Getting rid of existing records
        DefaultTableModel wpa__population_table_removal = (DefaultTableModel)tbl_elephant_migration.getModel();;
        int column_count = wpa__population_table_removal.getColumnCount();
        wpa__population_table_removal.setColumnCount(0);

//--------------------------------------
        Stack<String> elephant_location;
        DefaultTableModel elephant_migration_table = (DefaultTableModel)tbl_elephant_migration.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT id FROM elephant WHERE id LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            
            while (rs.next()) {
                elephant_location = new Stack<String>();
                String sql_location = "SELECT geographic_coordinates FROM elephantlocation WHERE elephant = ?";
                PreparedStatement pst_location = conn.prepareStatement(sql_location);
                pst_location.setString(1, rs.getString("id"));
                ResultSet rs_location = pst_location.executeQuery();
                String column_head = rs.getString("id");
                while (rs_location.next()) {
                    elephant_location.push(rs_location.getString("geographic_coordinates"));                    
                }                
             
                elephant_migration_table.addColumn(column_head, elephant_location);
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
        
//        DefaultTableModel wpa__population_table = (DefaultTableModel)tbl_elephant_migration.getModel();
//        String one[] = {"3","4"};
//                wpa__population_table.addColumn("J",one);
//                TableColumn tc = new TableColumn();
//                tc.setHeaderValue("Cel1");
//                
//               tbl_elephant_migration.addColumn(tc);
                
    }
    
    private void populateElephantCmb () {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT id FROM elephant";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {                
                    cmb_elephant.addItem(rs.getString("id"));
                } 
                conn.close();
            } catch (Exception e) {
                System.out.println("Failiure!" + e);
            }
        
    }
    
    private void createMigrationLineGraph (String id) {
        pnl_migration_graph.removeAll();
        pnl_migration_graph.updateUI();
        if (!id.equals("%")) {
            DefaultCategoryDataset dod = new DefaultCategoryDataset();

        //        Obtaining data from DB
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT geographic_coordinates FROM elephantlocation WHERE elephant LIKE ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {                
                    String location[] = rs.getString("geographic_coordinates").split(",");
                    String latitude = location[0].replaceAll("\\s", "");;
                    String longitude = location[1].replaceAll("\\s", "");
                    dod.setValue(Double.parseDouble(latitude), "Latitude", longitude);
                } 
                conn.close();
            } catch (Exception e) {
                System.out.println("Failiure!" + e);
            }
        //    -------------
            JFreeChart chart = ChartFactory.createLineChart("Elephant Migration", "Longitude", "Latitude", dod, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = chart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);
            ChartPanel cp = new ChartPanel(chart);
            pnl_migration_graph.removeAll();
            pnl_migration_graph.add(cp);
            pnl_migration_graph.updateUI();        
        } else {
            JLabel message = new JLabel("Select and elephant to view migration patterns in graph");
            message.setBounds(3000, 300, 300, 300);
            pnl_migration_graph.add(message);
        }
       
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
        btn_close = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        scr_pnl_elephant_migration = new javax.swing.JScrollPane();
        tbl_elephant_migration = new javax.swing.JTable();
        scr_pnl_migration_graph = new javax.swing.JScrollPane();
        pnl_migration_graph = new javax.swing.JPanel();
        lbl_elephant = new javax.swing.JLabel();
        cmb_elephant = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        btn_close.setBackground(new java.awt.Color(248, 249, 250));
        btn_close.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_close.setForeground(new java.awt.Color(33, 37, 41));
        btn_close.setText("Back");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close);
        btn_close.setBounds(1340, 20, 110, 60);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_title.setText("Elephant Migration Report");
        lbl_title.setOpaque(true);
        jPanel1.add(lbl_title);
        lbl_title.setBounds(0, 0, 1500, 100);

        scr_pnl_elephant_migration.setBackground(new java.awt.Color(248, 249, 250));
        scr_pnl_elephant_migration.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elelphant Migration Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(33, 37, 41))); // NOI18N

        tbl_elephant_migration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scr_pnl_elephant_migration.setViewportView(tbl_elephant_migration);

        jPanel1.add(scr_pnl_elephant_migration);
        scr_pnl_elephant_migration.setBounds(60, 110, 840, 260);

        pnl_migration_graph.setBackground(new java.awt.Color(248, 249, 250));
        pnl_migration_graph.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elephant Migration Line Graph", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(33, 37, 41))); // NOI18N
        pnl_migration_graph.setLayout(new javax.swing.BoxLayout(pnl_migration_graph, javax.swing.BoxLayout.LINE_AXIS));
        scr_pnl_migration_graph.setViewportView(pnl_migration_graph);

        jPanel1.add(scr_pnl_migration_graph);
        scr_pnl_migration_graph.setBounds(60, 380, 840, 320);

        lbl_elephant.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_elephant.setText("Elephant");
        jPanel1.add(lbl_elephant);
        lbl_elephant.setBounds(1120, 160, 130, 50);

        cmb_elephant.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_elephant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cmb_elephant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_elephantItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_elephant);
        cmb_elephant.setBounds(1250, 160, 170, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_elephantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_elephantItemStateChanged
        // TODO add your handling code here:
        
        String elephant;
        if (String.valueOf(cmb_elephant.getSelectedItem()).equals("All")) {
            elephant = "%";
        } else {
            elephant = String.valueOf(cmb_elephant.getSelectedItem());             
        }
        
        populateMigrationTable(elephant);
        createMigrationLineGraph(elephant);
    }//GEN-LAST:event_cmb_elephantItemStateChanged

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
        DirectorGeneralDashBoard dgd = new DirectorGeneralDashBoard(getGeneralId(), getUsername(), getPassword(),"Director General");
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
//            java.util.logging.Logger.getLogger(ElephantMigrationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ElephantMigrationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ElephantMigrationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ElephantMigrationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ElephantMigrationReport().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JComboBox<String> cmb_elephant;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_elephant;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_migration_graph;
    private javax.swing.JScrollPane scr_pnl_elephant_migration;
    private javax.swing.JScrollPane scr_pnl_migration_graph;
    private javax.swing.JTable tbl_elephant_migration;
    // End of variables declaration//GEN-END:variables
}
