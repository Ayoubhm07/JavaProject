/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pack;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ServicePack;

import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddPackController implements Initializable {

    @FXML
    private Label imagePath;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextArea tfDesc;
    @FXML
    private ImageView imagePreview;
    @FXML
    private Button addImage;
    @FXML
    private Button ajouter;
    @FXML
    private Button btnREtour;
    @FXML
    private Button goHome;
    
     private ServicePack sp = new ServicePack();
     private Pack p = new Pack();
     
     public static Pack PackAjoute;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        p.setImage("empty");
    }    

    @FXML
    private void OnAddimgClicked(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            p.setImage(SelectedFile.getAbsolutePath());
            imagePath.setText(SelectedFile.getAbsolutePath());
            imagePreview.setImage(new Image(new File(SelectedFile.getAbsolutePath().replace('/', '\\')).toURI().toString()));
        } else {
            Alert A = new Alert(Alert.AlertType.ERROR);
            A.setContentText("Selectionnez une image !  ");
            A.showAndWait();
        }
    }
    private boolean verif() {
        if (tfNom.getText().isEmpty() || !tfNom.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Le champ nom est obligatoire et doit contenir uniquement des lettres de l'alphabet.");
            return false;
        }
        if ( tfPrix.getText().isEmpty() || Integer.valueOf(tfPrix.getText()) <= 0 ) {
            JOptionPane.showMessageDialog(null, "Le champ prix est obligatoire et et doit être positif!");
            return false;
        }
        if (tfDesc.getText().isEmpty() || tfDesc.getText().length() < 10 ) {
            JOptionPane.showMessageDialog(null, "Le champ description est obligatoire et doit contenir au moins 10 lettres de l'alphabet.");
            return false;
        }
        if (p.getImage().equals("empty"))
        {
            JOptionPane.showMessageDialog(null, "selectionnez une image ! ");
            return false;
        }
        
        

        return true;
    }

    @FXML
    private void onAjouterClicked(ActionEvent event) {
            if (verif()) {
                   
            p.setPrix(Integer.parseInt(tfPrix.getText()));            
            p.setDesc(tfDesc.getText());
            p.setNom(tfNom.getText());
            p.setImage(p.getImage().replace('/', '\\'));
            sp.ajouter(p);
            
            
            
          
          
            
        Notifications.create()
        .title("Succès")
        .text("Pack ajouté ! Vous Devez attribuer des Bonus à votre Pack !")
        .showInformation();        
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBonus.fxml"));
            Parent root = loader.load();
            ajouter.getScene().setRoot(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void retourclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Packs.fxml"));
            Parent root = loader.load();
            btnREtour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onHomeclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackHome.fxml"));
            Parent root = loader.load();
            goHome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
