/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alecsoServices;

import alecso.Entity.Prod;
import alecso.Entity.fos_user;
import alecso.Utils.MyBDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LINA
 */
public class CrudProduits {
     Connection mycon;
    Statement st;
    ResultSet rst;
    
    public CrudProduits() {
    mycon = MyBDConnection.getInstanceBD().getConnection();
  }
    
public void AjouterProduit(Prod p) throws SQLException 
{
    int id = fos_user.getIdcnct();
 String req1 = "INSERT INTO `produits` " + "(`user_id`,`stock_qty`,`nom_image`,`nom`,`description`,`prix`)" + " VALUES ('"
                + id+ "','"+ p.getStockQty()+ "','" + p.getNomImage()+ "','" + p.getNom()+ "','" + p.getDescription()+ "','" + p.getPrix()+ "') ";
        try {
            PreparedStatement ste = mycon.prepareStatement(req1);
            int x = ste.executeUpdate(req1);
        } catch (SQLException ex) {
        }

} 
    
}
