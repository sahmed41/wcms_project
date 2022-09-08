
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class DirectorGeneral extends User{
    
//    public void getElephantMigrationPattern () {
//        
//    }
    
//    public void getElephantPopulation () {
//        
//    }
    
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
                        + "registered_date = ?"
                        + "WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getFirst_name()));
            pst.setString(2, String.valueOf(this.getLast_name()));
//            Setup username
            pst.setString(3, String.valueOf(this.getUsername()));
            pst.setString(4, String.valueOf(this.getAddress()));
            pst.setString(5, String.valueOf(this.getDate_of_birth()));
            pst.setString(6, String.valueOf(this.getEmail()));
            pst.setString(7, String.valueOf(this.getNic()));
//            Set up password
            pst.setString(8, String.valueOf(this.getPassword()));
            pst.setString(10, String.valueOf(this.getId()));
//            Setup a registered day to today
            pst.setString(9, String.valueOf(this.getRegistered_date()) );
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    
    }
    
    public void addWpa (String name, int area, LocalDate date_of_declaration, String province, String department_officer) {
        WildlifeProtectedArea wpa = new WildlifeProtectedArea();
        wpa.setName(name);
        wpa.setArea(area);
        wpa.setDate_of_declaration(date_of_declaration);
        wpa.setProvince(province);
        wpa.setDepartment_officer(department_officer);
        wpa.add();
    }
    
    public void editWpa (String id, String name, int area, String province, String department_officer) {
        WildlifeProtectedArea wpa = new WildlifeProtectedArea();
        wpa.setId(id);
        wpa.setName(name);
        wpa.setArea(area);
        wpa.setProvince(province);
        wpa.setDepartment_officer(department_officer);
        wpa.edit();
    }
    
    public String  deleteWpa (String id) {
        WildlifeProtectedArea wpa = new WildlifeProtectedArea();
        wpa.setId(id);
        String message = wpa.delete();
        return message;
    }
    
}
