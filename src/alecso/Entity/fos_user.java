/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alecso.Entity;



/**
 *
 * @author LINA
 */
public class fos_user {
    public static int idcnct;
    public static String namecnt;
    private int id;
    private String username;
    private String email;
    private String password;
    private String roles;
    private String nom;
    private String prenom;

    public fos_user() {
    }

    
    
    
    public fos_user( String username, String email, String password, String roles, String nom, String prenom) {
       
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
    }

 

    public static int getIdcnct() {
        return idcnct;
    }

    public static void setIdcnct(int idcnct) {
        fos_user.idcnct = idcnct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static String getNamecnt() {
        return namecnt;
    }

    public static void setNamecnt(String namecnt) {
        fos_user.namecnt = namecnt;
    }
   
    
    
    
}
