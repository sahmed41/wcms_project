
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class ElephantLocation {
    
    private String id; 
    private String geographic_coordinates; 
    private String time; 
    private String elephant; 
    
//    Setters

    public void setId(String id) {
        this.id = id;
    }
    
    public void setId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT MAX(id) FROM elephantlocation";
            PreparedStatement pst = conn.prepareStatement(sql); 
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                this.id = rs.getString("MAX(id)");
            } else {
                System.out.println("Failiure!"); // For testing
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure: " + e); // For testing
        }
    }

    public void setGeographic_coordinates(String geographic_coordinates) {
        this.geographic_coordinates = geographic_coordinates;
    }

    public void setTime(String formatDateTime_now) {
        this.time = formatDateTime_now;
    }

    public void setElephant(String elephant) {
        this.elephant = elephant;
    }
    
    
//    Getters

    public String getId() {
        return id;
    }

    public String getGeographic_coordinates() {
        return geographic_coordinates;
    }

    public String getTime() {
        return time;
    }

    public String getElephant() {
        return elephant;
    }

//    geographic_coordinations,	time, elephant	

    
    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO elephantlocation (geographic_coordinates, time, elephant) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getGeographic_coordinates()));
            pst.setString(2, String.valueOf(this.getTime()));
            pst.setString(3, String.valueOf(this.getElephant()));
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
            String sql = "UPDATE elephantlocation SET "
                        + "geographic_coordinates = ?,"
                        + "elephant = ?"
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getGeographic_coordinates()));
            pst.setString(2, String.valueOf(this.getElephant()));
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
            String sql = "DELETE FROM elephantlocation WHERE id=?";
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

    
