/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alecsoServices;

import alecso.Entity.BCrypt;
import alecso.Entity.fos_user;
import alecso.Utils.MyBDConnection;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LINA
 */
public class CrudUser {
    String path = "";
    Connection mycon = MyBDConnection.getInstanceBD().getConnection();
    private Statement st;
    private ResultSet res;
    
    
    
    
      
    
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(13);
        System.out.println(salt);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    
    public void register(fos_user user) throws SQLException, FileNotFoundException{
        
        String password  =  hashPassword( user.getPassword());
        
        
         String req1 = "INSERT INTO `fos_user` " + "(`username`,`email`,`password`,`roles`,`nom`,`prenom`)" + " VALUES ('"
                + user.getUsername()+ "','" + user.getEmail() + "','" +user.getPassword()+ "','" 
                        + user.getRoles()+ "','" + user.getNom()+"','" + user.getPrenom() 
                                +"') ";
 
                try {
            PreparedStatement ste = mycon.prepareStatement(req1);
            int x = ste.executeUpdate(req1);
        } catch (SQLException ex) {
        }
                }
  
          
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2y$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }
    
       public fos_user getUser(int id) throws SQLException {
        fos_user user = new fos_user();

        String requete = "select * from `fos_user` where `id`=?";
        PreparedStatement st = mycon.prepareStatement(requete);
        st.setString(1, String.valueOf(id));
        ResultSet res = st.executeQuery();

        while(res.next()){
            System.out.println(res.getString("id"));
            user.setId(res.getInt("id"));
            System.out.println(res.getString("username"));
            user.setUsername(res.getString("username"));
            System.out.println(res.getString("nom"));
            user.setNom(res.getString("nom"));
            System.out.println(res.getString("prenom"));
            user.setPrenom(res.getString("prenom"));
            System.out.println(res.getString("roles"));
            user.setRoles(res.getString("roles"));
            System.out.println(res.getString("email"));
            user.setEmail(res.getString("email"));
         
           
        }

        return user;
    }
    public Boolean login(String username, String password) {
        try {
            String requete = "SELECT * FROM `fos_user` where `username`=? and `password`=?";
            PreparedStatement st = mycon.prepareStatement(requete);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                System.out.println("True");
                 fos_user.setIdcnct(res.getInt("id"));
                 System.out.println("id :" +fos_user.idcnct);
                 return true;
            }
            else{
                System.out.println("username mahouch mawjoud");
               
                return false;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }

        return false;
        
    }
    
    
        public fos_user getconnecteduser(int id) {
     
             MyBDConnection cs=MyBDConnection.getInstanceBD();
        try {
            st=cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            String req = "SELECT * FROM `fos_user` where id="+id;
          fos_user userconnected = null;
        try {
            res=st.executeQuery(req);
           while(res.next()){
   //         rs.next();
            userconnected = new fos_user();
              userconnected.setId(id);
                userconnected.setNom(res.getString("nom"));
                userconnected.setPrenom(res.getString("prenom"));
                userconnected.setEmail(res.getString("email"));
                userconnected.setRoles(res.getString("roles"));
                userconnected.setUsername(res.getString("username"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    return userconnected;
     }
    
    
         
            
        
        
    
}
