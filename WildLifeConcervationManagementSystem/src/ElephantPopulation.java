
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
public class ElephantPopulation {
    
    private String id; 
    private String wpa; 
    private LocalDate date; 
    private int population;
    
//    Setters

    public void setId(String id) {
        this.id = id;
    }
    
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

    public void setWpa(String wpa) {
        this.wpa = wpa;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    
//    Getters

    public String getId() {
        return id;
    }

    public String getWpa() {
        return wpa;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPopulation() {
        return population;
    }
    
    
    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO elephantpopulation (wpa, date, population) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getWpa()));
            pst.setString(2, String.valueOf(this.getDate()));
            pst.setString(3, String.valueOf(this.getPopulation()));
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
            String sql = "UPDATE elephantpopulation SET "
                        + "population = ?"
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getPopulation()));
            pst.setString(2, String.valueOf(this.getId()));
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
            String sql = "DELETE FROM elephantpopulation WHERE id=?";
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
