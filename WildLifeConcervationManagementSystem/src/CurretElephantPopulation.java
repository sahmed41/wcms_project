
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class CurretElephantPopulation {
    
    private static int totalElephantPopulation;
    
    private CurretElephantPopulation() {
        setTotalElephantPopulation();
        
    }
    
//    Setters

    private static void setTotalElephantPopulation() {
        Stack<Integer> total_population = new Stack<Integer>();
        int population = 0;
        try {
//            Database connection
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
//           Getting WPA ids
            String sql = "SELECT id FROM wildlifeprotectedarea";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {       
                String sql_max_pop_id = "SELECT MAX(id) AS max_id FROM elephantpopulation WHERE wpa = ?";
                PreparedStatement pst_max_pop_id = conn.prepareStatement(sql_max_pop_id);
                pst_max_pop_id.setString(1, rs.getString("id"));
                ResultSet rs_max_pop_id = pst_max_pop_id.executeQuery();
                
                if (rs_max_pop_id.next()) {
                    String sql_lat_pop = "SELECT population FROM elephantpopulation WHERE id = ?";
                    PreparedStatement pst_pat_pop = conn.prepareStatement(sql_lat_pop);
                    pst_pat_pop.setString(1, rs_max_pop_id.getString("max_id"));
                    ResultSet rs_lat_pop = pst_pat_pop.executeQuery();
                    
                    if (rs_lat_pop.next()) {
//                        total_population.add(rs_lat_pop.getInt("population"));
                        population += rs_lat_pop.getInt("population");
                    }
                }




            } 
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
        totalElephantPopulation = population;
    }
    
    
//    Getters

    public static int getTotalElephantPopulation() {
        return totalElephantPopulation;
    }
    
    
    
    public static CurretElephantPopulation instentiateCurrentElephantPopulation () {
        CurretElephantPopulation cep = new CurretElephantPopulation();
        return cep;
    }
    
}
