/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alecso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author LINA
 */
public class backController implements Initializable {

 
   
    @FXML
    private Button btnAnnotation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    } 
    @FXML
       private void test(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("template.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void btnCr(ActionEvent event) {
    }

    @FXML
    private void btnEvent(ActionEvent event) {
    }

    @FXML
    private void btnAnn(ActionEvent event) {
    }
    
    
    
     @FXML
    void btnAnnotation(ActionEvent event) {
        
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/alecso/backEtudiant.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(backController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @FXML
    private void btnLib(ActionEvent event) throws IOException {
        
           Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjoutProd.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }
    
    
}
