
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class Validator {
    private static Validator v1 = new Validator();
    
    private Validator () {}
    
    public static Validator getInstance() {
        return v1;
    }
    
    public static boolean validateNic(String nic) {
        boolean status = false;
        String message;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT nic FROM user WHERE nic = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, nic);
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
    
    public static boolean validateEmailFormat(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    public static boolean validateEmail (String email) {
        boolean status = false;
        String message;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT email FROM user WHERE email = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, email);
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
    
    public static boolean validatePassword (String id, String password) {
        boolean status = false;
        String message;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT password FROM user WHERE id = ? AND password = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);                
                pst.setString(2, password);
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
    
    public static boolean isNumber(String number) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (number == null) {
            return false; 
        }
        return pattern.matcher(number).matches();
        
        
    }
    
    public static boolean validateRole (String id, String role) {
        boolean roleValidation = false;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
                String sql = "SELECT role FROM user WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    if (role.equals((rs.getString("role")))) {
                        roleValidation = true;
                    }               
                } 

                conn.close();
            } catch (Exception e) {
                System.out.println("Failiure: " + e);
            }
        return roleValidation;
    }    
}
