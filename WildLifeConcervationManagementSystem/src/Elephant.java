
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
public class Elephant {
    
    private String id;
    private String picture;
    private String chip_number;
    private String name;
    private String gender;
    private String height;
    private String weight;
    private String habitat;
    private String status;
    private String registered_date;
    
    
//    Setters

    public void setId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT MAX(id) FROM elephant";
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
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setChip_number(String chip_number) {
        this.chip_number = chip_number;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }
    
    
//    Getters

    public String getId() {
        return id;
    }

    public String getChip_number() {
        return chip_number;
    }

    public String getPicture() {
        return picture;
    }     

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
    
    public String getHabitat() {
        return habitat;
    }

    public String getStatus() {
        return status;
    }

    public String getRegistered_date() {
        return registered_date;
    }

    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO elephant (picture, chip_number, name, gender, height, weight, habitat, status, registered_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getPicture()));
            pst.setString(2, String.valueOf(this.getChip_number()));
            pst.setString(3, String.valueOf(this.getName()));
            pst.setString(4, String.valueOf(this.getGender()));
            pst.setString(5, String.valueOf(this.getHeight()));
            pst.setString(6, String.valueOf(this.getWeight()));
            pst.setString(7, String.valueOf(this.getHabitat()));
            pst.setString(8, String.valueOf(this.getStatus()));
            pst.setString(9, String.valueOf(this.getRegistered_date()));
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
            String sql = "UPDATE elephant SET "
                        + "picture = ?," 
                        + "name = ?," 
                        + "gender = ?," 
                        + "height = ?," 
                        + "weight = ?," 
                        + "habitat = ?," 
                        + "status = ?" 	
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getPicture()));
            pst.setString(2, String.valueOf(this.getName()));
            pst.setString(3, String.valueOf(this.getGender()));
            pst.setString(4, String.valueOf(this.getHeight()));
            pst.setString(5, String.valueOf(this.getWeight()));
            pst.setString(6, String.valueOf(this.getHabitat()));
            pst.setString(7, String.valueOf(this.getStatus()));
            pst.setString(8, String.valueOf(this.getId()));
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
            String sql = "DELETE FROM elephant WHERE id=?";
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
