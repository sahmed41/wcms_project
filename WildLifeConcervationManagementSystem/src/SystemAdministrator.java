
import com.mysql.cj.xdevapi.DbDoc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mws_a
 */
public class SystemAdministrator {
    private String username; 
    private String password;
    
//    Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
//    Getters

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    public String registerDepartmentOfficer (String first_name, String last_name, String address, LocalDate date_of_birth, String email, String nic) {
        DepartmentOfficer do_1 = new DepartmentOfficer();
        do_1.setFirst_name(first_name);
        do_1.setLast_name(last_name);
    //                Setup username from firstname and lastname
        String username = (do_1.getFirst_name().substring(0,1) + do_1.getLast_name()).toLowerCase();
        username = username.toLowerCase();
        do_1.setUsername(username);
        do_1.setAddress(address);
        do_1.setDate_of_birth(date_of_birth);
        do_1.setEmail(email);
        do_1.setNic(nic);
    //                Setup password automatically
        String password = do_1.getLast_name().toLowerCase() + "aaAA11@@";
        do_1.setPassword(password);
    //                Set role to department officer
        do_1.setRole("Department Officer");
        do_1.setRegistered_date(LocalDate.now());
        do_1.add();
        do_1.setId();
        
        String message = " Usrname: " + do_1.getUsername() + "and Password: " + do_1.getPassword();
        return message;
                
    }
    
        
    public void editDepartmentOfficer (String id, String first_name, String last_name, String username, String address, LocalDate date_of_birth, String email, String nic, String password) {
        
                User u1 = new User();
                u1.setId(id);
                u1.setFirst_name(first_name);
                u1.setLast_name(last_name);
//                Get the username from the db put it here. 
                u1.setUsername(username);
                u1.setAddress(address);
                u1.setDate_of_birth(date_of_birth);
                u1.setEmail(email);
                u1.setNic(nic);
//                Get password from the the db and put it here
                u1.setPassword(password);
                u1.setRole("Department Officer");
                u1.edit();
        
    }
    
    public String deleteDepartmentOfficer (String id) {     
        String message = "Failed to delete";
        if (Validator.validateRole(id, "Department Officer")) {
            User u1 = new User();
            u1.setId(id);
            message = u1.delete();            
        } else {
            message = "Unable to delete as the role of the user is not Department officer";            
        }
        return message;
    }
    
    public String editDirectorGeneral (String id, String first_name, String last_name, String address, String email, LocalDate dob, String nic) {
        DirectorGeneral dg = new DirectorGeneral();
        dg.setId(id);
        dg.setFirst_name(first_name);
        dg.setLast_name(last_name);
//        Setting up username
        String username = (first_name.substring(0,1) + last_name).toLowerCase();
        dg.setUsername(username);
        dg.setAddress(address);
        dg.setEmail(email);
//        Date should be converted from Date to local date
        dg.setDate_of_birth(dob);
        dg.setNic(nic);
//        Setting up password
        String password = last_name.toLowerCase() + "aaAA!!@@";
        dg.setPassword(password);
        dg.setRegistered_date(LocalDate.now());
        if (Validator.validateRole(dg.getId(), "Director General")) {
            dg.edit();            
        } else {
            System.out.println("The information is not of Director general");
        }
        String message = "Failed";
        message = " Username: " + dg.getUsername() + ". Password: "+ dg.getPassword();
        return message;
        
    
    }
    

    
    
    
    

    

}

    
    
    
    

