/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alecso;

import alecso.Entity.LibCat;
import alecso.Entity.Prod;
import alecso.Entity.fos_user;
import alecsoServices.CRUDLibCat;
import alecsoServices.CrudProduits;
import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.TouchEvent;

/**
 * FXML Controller class
 *
 * @author LINA
 */
public class AddProdController implements Initializable {

    @FXML
    private ComboBox idCat;
    @FXML
    private Button bntAdd;
    @FXML
    private ImageView UploadImage;
    
      private String imageUpload;
    @FXML
    private TextField idT;
    @FXML
    private TextField idP;
    @FXML
    private TextField idQ;
    @FXML
    private TextArea idD;
    @FXML
    private Button uploadImage;
    @FXML
    private Text labelUser;
    @FXML
    private Label lbl1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CRUDLibCat crud=new CRUDLibCat();
        List<LibCat> c=new ArrayList();
        List l=new ArrayList();
        try {
            c= crud.afficherComb();
        } catch (SQLException ex) {
            Logger.getLogger(AddProdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.forEach((s->l.add(s.getLibelle())) );
        idCat.setItems(FXCollections.observableArrayList(l));

    }   

    @FXML
    private void uploadImage(ActionEvent event) throws IOException  {
         FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.jpg");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.png");
           fc.getExtensionFilters().addAll(ext1,ext2);
           Stage stage = new Stage();
           File file = fc.showOpenDialog(stage);
           BufferedImage bf;
           if( file != null){
               bf = ImageIO.read(file);
           javafx.scene.image.Image image = SwingFXUtils.toFXImage(bf, null);
           UploadImage.setImage(image);
           FileInputStream fin = new FileInputStream(file);
           imageUpload = file.getName();
           }
    }

    private int findId(List<LibCat> c){
        int id=0;
        for(int i=0;i<c.size();i++){
            if(c.get(i).getLibelle().equals(idCat.getValue())){
                id=c.get(i).getIdC();
            }
        }
        return id;
    }
    
 

    @FXML
    private void controle_numero(KeyEvent event) {
         String u=idP.getText();
           String pattern = "^[0-9]$";
           

    if((u.equals("")))
            {
            lbl1.setText("*Champs obligatoire");
            lbl1.setTextFill(Color.web("#b52727  "));
            bntAdd.setDisable(true);
            }
     else if(!u.matches(pattern))
      {
          lbl1.setText("*seulement des nombres");
            lbl1.setTextFill(Color.web("#b52727  "));
            
     bntAdd.setDisable(true);}
  
        else{ 
         lbl1.setText("");
          
        bntAdd.setDisable(false);
        }
    }
              
 
    @FXML
    private void AjoutProd(ActionEvent event) throws SQLException, IOException {
                File outputFile = new File("C:\\wamp64\\www\\alecso\\" + imageUpload);
        BufferedImage bImage = SwingFXUtils.fromFXImage(UploadImage.getImage(), null);
        try {
      ImageIO.write(bImage, "png", outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
         CRUDLibCat crud=new CRUDLibCat();
        List<LibCat> c=new ArrayList();
        List l=new ArrayList();
            c= crud.afficherComb();
        
       
           
          
          
           
        
           
           
       /*    if(Integer.valueOf(idP.getText())<0 || Integer.valueOf(idP.getText())>101 ){
        JOptionPane.showMessageDialog(null, "Veuillez inserer une valeur entre 0 et 100");
        */
                
        /*        else if (Integer.valueOf(idQ.getText())<0 || Integer.valueOf(idQ.getText())>1000) {
           JOptionPane.showMessageDialog(null, "Veuillez inserer une valeur entre 0 et 10000");}
        else if (idT.getText().length()>30 ||idT.getText().length()<4 ){
        JOptionPane.showMessageDialog(null, "Le tire doit avoir 4 caracteres au min et 30 au max");
        }
        
         else if (idD.getText().length()>300 || idD.getText().length()<5 ){
        JOptionPane.showMessageDialog(null, "Le ccommentaire doit avoir 300 caracteres au max et 5 au min");
        } */
         
     Prod p = new Prod(imageUpload,fos_user.getIdcnct(),idT.getText(),idD.getText(),Integer.parseInt(idP.getText()),findId(c),Integer.parseInt(idQ.getText()));
           CrudProduits service =new CrudProduits(); 
            service.AjouterProduit(p);
           JOptionPane.showMessageDialog(null, "Produit ajoutée avec succées");
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("MyProd.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
        
             Parent root = FXMLLoader.load(getClass().getResource("MyProd.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    
    
    
    
}
