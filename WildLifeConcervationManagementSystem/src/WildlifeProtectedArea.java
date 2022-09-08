
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class WildlifeProtectedArea {
    
    private String id;
    private String name;
    private int area;
    private LocalDate date_of_declaration;
    private String province;
    private String department_officer;

//    Setters
    public void setId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "SELECT id FROM wildlifeprotectedarea WHERE name='" + this.getName() + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                this.id = rs.getString("id");
            } else {
                System.out.println("Failiure!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    }

    public void setId(String id) {
        this.id = id;
    }    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setDate_of_declaration(LocalDate date_of_declaration) {
        this.date_of_declaration = date_of_declaration;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDepartment_officer(String department_officer) {
        this.department_officer = department_officer;
    }
    
    

    
//    Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public LocalDate getDate_of_declaration() {
        return date_of_declaration;
    }

    public String getProvince() {
        return province;
    }

    public String getDepartment_officer() {
        return department_officer;
    }
    
    
    
//    Other Methods

    
    public void add() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "INSERT INTO wildlifeprotectedarea (name,area,date_of_declaration,province, department_officer) VALUES ('" + this.getName() + "'," + this.getArea() + ",'" + this.date_of_declaration + "','" + this.getProvince() + "','" + this.getDepartment_officer() + "')";
            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, String.valueOf(this.getName()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    }

    public void edit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "UPDATE wildlifeprotectedarea SET "
                    + "name=?,"
                    + "area=?,"
                    + "province=?,"
                    + "department_officer=?"
                    + "WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getName()));
            pst.setString(2, String.valueOf(this.getArea()));
            pst.setString(3, String.valueOf(this.getProvince()));
            pst.setString(4, String.valueOf(this.getDepartment_officer()));
            pst.setString(5, String.valueOf(this.getId()));
            pst.executeUpdate();
            
            System.out.println("Success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
        }
    }
    
    public String delete() {
        String message = "Failed to delete";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcms","wcms","e3H$l5A@eN^p7T&");
            String sql = "DELETE FROM wildlifeprotectedarea WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf(this.getId()));
            pst.executeUpdate();
            message = "Deletion Successfull";
            System.out.println("Success!");
            conn.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            message = "You cannot delete a Willife protected area without assigning its Elephants to a Habitat in another Wildlife Protected Area.";
        } catch (Exception e) {
            System.out.println("Failiure!" + e);
            message = "Failiure!" + e;
        }
        return message;
    }
    
    
    
}
