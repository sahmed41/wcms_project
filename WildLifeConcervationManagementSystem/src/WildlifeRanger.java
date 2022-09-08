
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class WildlifeRanger extends User {
    
//    private String user_id; 
    private String urrn; 
    private String wpa;
    private String department_officer;
    
    
//    Setters

//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }
   
    public void setUrrn() {
        try {
            boolean repeated_urrn = false;
//            this.urrn = urrn;            
            do {
                int random_int = (int)(Math.random() * 10000);
                String urrn = String.valueOf(random_int);
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT urrn FROM wildliferanger WHERE urrn=?";
                PreparedStatement pst = conn.prepareStatement(sql);            
                pst.setString(1, urrn);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    System.out.println("It is there " + rs.getString("urrn"));
                    repeated_urrn = true;
                } else {
                    System.out.println("It is not there");
                    this.urrn = urrn;
                }
                conn.close();
            } while (repeated_urrn);         
            
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
        
    }

    public void setUrrn(String urrn) {
        this.urrn = urrn;
    }
    

    public void setWpa(String wpa) {
        this.wpa = wpa;
    }

    public void setDepartment_officer(String department_officer) {
        this.department_officer = department_officer;
    }
    
    
    
    
    
//    Getters

//    public String getUser_id() {
//        return user_id;
//    }

      
    public String getUrrn() {
        return urrn;
    }

    public String getWpa() {
        return wpa;
    }

    public String getDepartment_officer() {
        return department_officer;
    }
    
    
    
    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO user (first_name,last_name, username, address, dob, email, nic, password, role, registered_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getFirst_name()));
            pst.setString(2, String.valueOf(this.getLast_name()));
            pst.setString(3, String.valueOf(this.getUsername()));
            pst.setString(4, String.valueOf(this.getAddress()));
            pst.setString(5, String.valueOf(this.getDate_of_birth()));
            pst.setString(6, String.valueOf(this.getEmail()));
            pst.setString(7, String.valueOf(this.getNic()));
            pst.setString(8, String.valueOf(this.getPassword()));
            pst.setString(9, String.valueOf(this.getRole()));
            pst.setString(10, String.valueOf(this.getRegistered_date()));
            pst.executeUpdate();
            this.setId();
            
            
            String sql_1 = "INSERT INTO wildliferanger (user, urrn, wpa, department_officer) VALUES (?, ?, ?, ?)";
            PreparedStatement pst_1 = conn.prepareStatement(sql_1);            
            pst_1.setString(1, String.valueOf(this.getId()));
            pst_1.setString(2, String.valueOf(this.getUrrn()));
            pst_1.setString(3, String.valueOf(this.getWpa()));
            pst_1.setString(4, String.valueOf(this.getDepartment_officer()));
            pst_1.executeUpdate();
            
            
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
    }
    
    public void edit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "UPDATE user SET "
                        + "first_name = ?,"
                        + "last_name = ?,"
                        + "username = ?,"
                        + "address = ?,"
                        + "dob = ?,"
                        + "email = ?,"
                        + "nic = ?,"
                        + "password = ?"
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getFirst_name()));
            pst.setString(2, String.valueOf(this.getLast_name()));
            pst.setString(3, String.valueOf(this.getUsername()));
            pst.setString(4, String.valueOf(this.getAddress()));
            pst.setString(5, String.valueOf(this.getDate_of_birth()));
            pst.setString(6, String.valueOf(this.getEmail()));
            pst.setString(7, String.valueOf(this.getNic()));
            pst.setString(8, String.valueOf(this.getPassword()));
            pst.setString(9, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            
            String sql_1 = "UPDATE wildliferanger SET wpa = ?, department_officer = ?  WHERE user = ?";
            PreparedStatement pst_1 = conn.prepareStatement(sql_1);            
            pst_1.setString(1, String.valueOf(this.getWpa()));
            pst_1.setString(2, String.valueOf(this.getDepartment_officer()));
            pst_1.setString(3, String.valueOf(this.getId()));
            pst_1.executeUpdate();
            
            
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }        
    }
    
    public void addElephantPopulation (int population, String wpa) {
        ElephantPopulation ep = new ElephantPopulation();
        ep.setPopulation(population);
        ep.setWpa(wpa);
        ep.setDate(LocalDate.now());
        ep.add();            
    
    }
    
//    public void login() {
//        
//    }
    
    
    
    
}
