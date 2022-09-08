
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class DepartmentOfficer extends User {
    
    public String registerRanger(
            String first_name, 
            String last_name, 
            String address, 
            LocalDate date_of_birth, 
            String email, String nic,
            String wpa) {
        WildlifeRanger wr = new WildlifeRanger();
        wr.setFirst_name(first_name);
        wr.setLast_name(last_name);
//        Setting up a user name for the ranger
        String user_name = first_name.charAt(0) + last_name;
        user_name = user_name.replaceAll(" ", "");
        user_name = user_name.toLowerCase();
//        Making the username unique to the user.
        int username_post = 1;
        boolean user_name_exists = false;
        while (wpaUsernameCheck(user_name)) {
            user_name = user_name.replace(user_name.substring(user_name.length()-1), "");
            user_name = user_name + String.valueOf(username_post);
            username_post++;           
        }
        
        wr.setUsername(user_name);
        wr.setAddress(address);
        wr.setDate_of_birth(date_of_birth);
        wr.setEmail(email);
        wr.setNic(nic);
        wr.setPassword(last_name.toLowerCase() + "aa11@@");
        wr.setRole("Wildlife Ranger");
        wr.setRegistered_date(LocalDate.now());
        wr.setUrrn();
        wr.setWpa(wpa);
        wr.setDepartment_officer(this.getId());
        wr.add();
        
        return "Username:" + wr.getUsername() + ", password: " + wr.getPassword() + ", URRN: " + wr.getUrrn();
        
    }
    
    public void editRanger (String id, String first_name, String last_name, String address, LocalDate date_of_birth, String email, String nic,  String wpa) {
        WildlifeRanger wr = new WildlifeRanger();
        wr.setId(id);
        wr.setFirst_name(first_name);
        wr.setLast_name(last_name);
        wr.setUsername(getUserNameFromDb(wr.getId()));
        wr.setAddress(address);
        wr.setDate_of_birth(date_of_birth);
        wr.setEmail(email);
        wr.setNic(nic);
        wr.setPassword(getPasswordFromDb(wr.getId()));
        wr.setRole("Wildlife Ranger");
        wr.setWpa(wpa);
        wr.setDepartment_officer(this.getId());
        wr.edit();
    }
    
    public void deleteRanger (String id) {
        User u1 = new User();
        u1.setId(id);
        u1.delete();        
    }
    
    public boolean wpaUsernameCheck(String username) {
        boolean status = false;
        String message;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT username FROM user WHERE username = ?";
//            SELECT column1, column2, ...
//FROM table_name;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }

            conn.close();
        } catch (Exception e) {
            message = "Failiure: " + e;
        }
        return status;
    }
    
    private String getUserNameFromDb (String id) {
        String username = "Thes ranger does not have a username";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT username FROM user WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                username = rs.getString("username");
            } 

            conn.close();
        } catch (Exception e) {
            username = "Failiure: " + e;
        }
        return username;
    }
    
    private String getPasswordFromDb (String id) {
        String password = "Thes ranger does not have a password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT password FROM user WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            } 

            conn.close();
        } catch (Exception e) {
            password = "Failiure: " + e;
        }
        return password;
    }
    
}


