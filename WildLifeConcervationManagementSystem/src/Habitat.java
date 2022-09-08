
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
public class Habitat {
    private String id;
    private String location;
    private String wpa;
    private String registered_date;
    
    
//  Setters
    
    public void setId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT MAX(id) FROM habitat";
            PreparedStatement pst = conn.prepareStatement(sql); 
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                this.id = rs.getString("MAX(id)");
            } else {
                System.out.println("Failiure!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
    }

    public void setId(String id) {
        this.id = id;
    }
     
    public void setLocation(String location) {
        this.location = location;
    }

    public void setWpa(String wpa) {
        this.wpa = wpa;
    }
    
    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }
    
    
//    Getters

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getWpa() {
        return wpa;
    }

    public String getRegistered_date() {
        return registered_date;
    }
    
    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO habitat (location, wpa, registered_date) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getLocation()));
            pst.setString(2, String.valueOf(this.getWpa()));
            pst.setString(3, String.valueOf(this.getRegistered_date()));
            pst.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e);
        }
    }
    
    public void edit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "UPDATE habitat SET "
                        + "location = ?,"
                        + "wpa = ?"
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getLocation()));
            pst.setString(2, String.valueOf(this.getWpa()));
            pst.setString(3, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    } 
    
    public void delete() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "DELETE FROM habitat WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure:" + e);
        } 
    } 
    
    
    
    
    
    
   
    
}
