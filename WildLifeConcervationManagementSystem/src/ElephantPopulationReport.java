
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class ElephantPopulationReport extends javax.swing.JFrame {

    /**
     * Creates new form ElephantPopulationReport
     */
    private String id;
    private String username;
    private String password;
    private String role;
    
    public ElephantPopulationReport(String id, String username, String password, String role) {
        initComponents();
//        Setting up user variables
        setExtendedState(MAXIMIZED_BOTH);
        setId(id);
        setUsername(username);
        setPassword(password);
        setRole(role);
//        --------------
        populateCmbWpa();
        updateWpaLabel("%");
        createPopulationChart("%");
        createGenderPieChart("%");
        populateWpaPopulationTable("%");
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
    
    

    
    
//    Other Methods
    private void createPopulationChart(String id) {
        DefaultCategoryDataset dod = new DefaultCategoryDataset();
//        dod.setValue(12, "Population1", "2019");
//        dod.setValue(7, "Population1", "2020");
//        dod.setValue(15, "Population1", "2021");
//        dod.setValue(13, "Population1", "2022");
//        
//        Retreiving data from database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT SUM(population) AS total_p, date FROM elephantpopulation WHERE wpa LIKE ? GROUP BY date";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                dod.setValue(rs.getInt("total_p"), "Population", rs.getString("date"));
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }

       
        
//        ---------------------------------
        
        
        JFreeChart chart = ChartFactory.createBarChart("Elephant Population", "Year", "Population", dod, PlotOrientation.VERTICAL, true, true, false);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
//        ChartFrame chframe = new ChartFrame("Elephant Population", chart, true);
//        chframe.setVisible(true);
//        chframe.setSize(300,400);
        
        ChartPanel cp = new ChartPanel(chart);
        pnl_year_chart.removeAll();
        pnl_year_chart.add(cp);
        pnl_year_chart.updateUI();
                     
        
    }
    
    private void createGenderPieChart (String id) {
        int m = 0;
        int f = 0;
        DefaultPieDataset dataset = new DefaultPieDataset( );
//        dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//        dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//        dataset.setValue( "MotoG" , new Double( 40 ) );    
//        dataset.setValue( "Nokia Lumia" , new Double( 10 ) ); 
        
//        Getting value from the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql_wpa = "SELECT wpa, id FROM habitat WHERE wpa Like ?";
            PreparedStatement pst_wpa = conn.prepareStatement(sql_wpa);
            pst_wpa.setString(1, id);
            ResultSet rs_wpa = pst_wpa.executeQuery();
            while (rs_wpa.next()) {
                String sql = "SELECT COUNT(id) AS total_g, gender FROM elephant WHERE habitat = ? GROUP BY gender";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, rs_wpa.getString("id"));
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                    if (rs.getString("gender").equals("Male")) {
                        m += rs.getInt("total_g");
                    } else {
                        f += rs.getInt("total_g");                    
                    }
                    System.out.println("DB Status: " + true);
                }
                
            
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
        System.out.println("Male: " + m);
        System.out.println("Female: " + f);
        dataset.setValue("Male", new Integer (m));
        dataset.setValue("Female", new Integer (f));

//          --------------------------------
        
        JFreeChart chart = ChartFactory.createPieChart(      
         "Elephant Population by Gender",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         true);
        
//        JFreeChart chart1 = createChart(createDataset( ));
        PiePlot plot = (PiePlot)chart.getPlot();
//        plot.setRangeGridlinePaint(Color.black);
//        plot.setForegroundAlpha(TOP_ALIGNMENT);
        
//        ChartFrame chframe = new ChartFrame("Elephant Population", chart);
//        chframe.setVisible(true);
//        chframe.setSize(300,400);
        
        ChartPanel pc = new ChartPanel(chart);
        pnl_gender_chart.removeAll();
        pnl_gender_chart.add(pc);
        pnl_gender_chart.updateUI();     
    
    }
    
    private String getWpaNamebyId (String id) {
        String name = "none";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT name FROM wildlifeprotectedarea Where id Like ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                name = rs.getString("name");
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
        return name;
    
    }
    
    private void populateCmbWpa () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql_wpa = "SELECT id FROM wildlifeprotectedarea";
            PreparedStatement pst_wpa = conn.prepareStatement(sql_wpa);
//            pst_wpa.setString(1, id);
            ResultSet rs_wpa = pst_wpa.executeQuery();
            while (rs_wpa.next()) {            
                cmb_wpa.addItem(rs_wpa.getString("id"));            
            } 
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }        
    }
    
    private void updateWpaLabel (String id) {
        if (id.equals("%")) {
            lbl_wpa_name.setText("All");
        } else {
            String name = getWpaNamebyId(id);
            lbl_wpa_name.setText(name);        
        }              
        
    }
    
    private void populateWpaPopulationTable (String id) {
//        removing table rows before repopulating
        DefaultTableModel wpa__population_table_removal = (DefaultTableModel)tbl_wpa_population_table.getModel();;
        int rowCount = wpa__population_table_removal.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            wpa__population_table_removal.removeRow(i);
        }
        
//        ------------------

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT SUM(population) AS total_p, date FROM elephantpopulation WHERE wpa LIKE ? GROUP BY date";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String date = rs.getString("date");
                String population = rs.getString("total_p");
                
                String wpa_population_info[] = {date, population };

                DefaultTableModel wpa__population_table = (DefaultTableModel)tbl_wpa_population_table.getModel();
                
                wpa__population_table.addRow(wpa_population_info);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_wpa = new javax.swing.JLabel();
        cmb_wpa = new javax.swing.JComboBox<>();
        scr_pnl_wpa_population_table = new javax.swing.JScrollPane();
        tbl_wpa_population_table = new javax.swing.JTable();
        scr_pnl_year_chart = new javax.swing.JScrollPane();
        pnl_year_chart = new javax.swing.JPanel();
        scr_pnl_gender_chart = new javax.swing.JScrollPane();
        pnl_gender_chart = new javax.swing.JPanel();
        lbl_wpa_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setLayout(null);

        btn_back.setBackground(new java.awt.Color(248, 249, 250));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(33, 37, 41));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back);
        btn_back.setBounds(1440, 30, 80, 50);

        lbl_title.setBackground(new java.awt.Color(33, 37, 41));
        lbl_title.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(248, 249, 250));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        lbl_title.setText("Population Report");
        lbl_title.setOpaque(true);
        jPanel1.add(lbl_title);
        lbl_title.setBounds(-6, -5, 1580, 100);

        lbl_wpa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_wpa.setText("Wildlife Protected Area");
        jPanel1.add(lbl_wpa);
        lbl_wpa.setBounds(20, 110, 170, 40);

        cmb_wpa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_wpa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cmb_wpa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_wpaItemStateChanged(evt);
            }
        });
        jPanel1.add(cmb_wpa);
        cmb_wpa.setBounds(190, 110, 110, 40);

        tbl_wpa_population_table.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_wpa_population_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Population"
            }
        ));
        tbl_wpa_population_table.setRowHeight(18);
        tbl_wpa_population_table.setRowMargin(2);
        tbl_wpa_population_table.setSelectionBackground(new java.awt.Color(33, 37, 41));
        tbl_wpa_population_table.setSelectionForeground(new java.awt.Color(248, 249, 250));
        scr_pnl_wpa_population_table.setViewportView(tbl_wpa_population_table);

        jPanel1.add(scr_pnl_wpa_population_table);
        scr_pnl_wpa_population_table.setBounds(20, 210, 820, 200);

        pnl_year_chart.setBackground(new java.awt.Color(248, 249, 250));
        pnl_year_chart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Population by Year", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(33, 37, 41))); // NOI18N
        pnl_year_chart.setLayout(new javax.swing.BoxLayout(pnl_year_chart, javax.swing.BoxLayout.LINE_AXIS));
        scr_pnl_year_chart.setViewportView(pnl_year_chart);

        jPanel1.add(scr_pnl_year_chart);
        scr_pnl_year_chart.setBounds(860, 210, 660, 570);

        pnl_gender_chart.setBackground(new java.awt.Color(248, 249, 250));
        pnl_gender_chart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Population by Gender", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16), new java.awt.Color(33, 37, 41))); // NOI18N
        pnl_gender_chart.setLayout(new javax.swing.BoxLayout(pnl_gender_chart, javax.swing.BoxLayout.LINE_AXIS));
        scr_pnl_gender_chart.setViewportView(pnl_gender_chart);

        jPanel1.add(scr_pnl_gender_chart);
        scr_pnl_gender_chart.setBounds(20, 440, 820, 340);

        lbl_wpa_name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_wpa_name.setText("jLabel1");
        jPanel1.add(lbl_wpa_name);
        lbl_wpa_name.setBounds(440, 110, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_wpaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_wpaItemStateChanged
        // TODO add your handling code here:
        String wpa_item = "Select";
        if (String.valueOf(cmb_wpa.getSelectedItem()).equals("All")) {
            wpa_item = "%";
        } else {
            wpa_item = String.valueOf(cmb_wpa.getSelectedItem());
        }
        
        if (wpa_item.equals("Select")) {
            lbl_wpa_name.setText("Wildlife Protected Area ID not valid");
        } else {
            createPopulationChart(wpa_item);
            createGenderPieChart(wpa_item);
            updateWpaLabel(wpa_item);
            populateWpaPopulationTable(wpa_item);
        
        }
    }//GEN-LAST:event_cmb_wpaItemStateChanged

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        DirectorGeneralDashBoard dgd = new DirectorGeneralDashBoard(getId(), getUsername(), getPassword(), getRole());
        dgd.setVisible(true);
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
//            java.util.logging.Logger.getLogger(ElephantPopulationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ElephantPopulationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ElephantPopulationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ElephantPopulationReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ElephantPopulationReport("35","azar","ahmedzafar","Director General").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> cmb_wpa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_wpa;
    private javax.swing.JLabel lbl_wpa_name;
    private javax.swing.JPanel pnl_gender_chart;
    private javax.swing.JPanel pnl_year_chart;
    private javax.swing.JScrollPane scr_pnl_gender_chart;
    private javax.swing.JScrollPane scr_pnl_wpa_population_table;
    private javax.swing.JScrollPane scr_pnl_year_chart;
    private javax.swing.JTable tbl_wpa_population_table;
    // End of variables declaration//GEN-END:variables
}
