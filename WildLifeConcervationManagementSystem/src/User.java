
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
public class User {
    
    private String id;
    private String first_name;
    private String last_name;
    private String username;
    private String address;
    private LocalDate date_of_birth;
    private String email;
    private String nic;
    private String password;
    private String role;
    private LocalDate registered_date;

    
//    Setters
    public void setId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT id FROM user WHERE username=?";
            PreparedStatement pst = conn.prepareStatement(sql);            
            pst.setString(1, String.valueOf(this.getUsername()));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                this.id = rs.getString("id");
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
        
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRegistered_date(LocalDate registered_date) {
        this.registered_date = registered_date;
    }
    
    
    
    
//    Getters

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }
    
    public String getAddress() {
        return address;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public String getNic() {
        return nic;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getRegistered_date() {
        return registered_date;
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
                        + "password = ?,"
                        + "role = ?"
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
            pst.setString(9, String.valueOf(this.getRole()));
            pst.setString(10, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    }
    
    public String delete() {
        String message = "Failed Deletion";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "DELETE FROM user WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
            message = "Deletion Successful!";              
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            message = "You cannot delete an officer withou asigning another officer for wildlife protected areas he is incharge of.";
        } catch (Exception e) {
            message = "Failiure: " + e;      
        } 
        return message;

    
//    public void login() {
//        
//    }
    }
}

    
    
    
    
    
    

