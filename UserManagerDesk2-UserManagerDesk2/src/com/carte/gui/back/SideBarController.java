/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carte.gui.back;

import com.carte.MainApp;
import com.carte.utils.Animations;
import com.carte.utils.Constants;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SideBarController implements Initializable {

    @FXML
    private Button btnComptes;
    @FXML
    private Button btnTransactions;
    @FXML
    private Button btnCarteBancaires;
    @FXML
    private Button btnTypes;
    @FXML
    private Button btnUser;
    @FXML
    private Button btnRole;
    @FXML
    private Button packs;
    
     private final Color COLOR_GRAY = new Color(0.9, 0.9, 0.9, 1);
    private final Color COLOR_PRIMARY = Color.web("#000000");
    private final Color COLOR_DARK = new Color(1, 1, 1, 0.65);
    private Button[] liens;
    @FXML
    private AnchorPane mainComponent;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         liens = new Button[]{
            btnComptes,
            btnTransactions,
            btnCarteBancaires,
            btnTypes,
            btnTypes,
            btnRole,
            packs,};

        mainComponent.setBackground(new Background(new BackgroundFill(COLOR_PRIMARY, CornerRadii.EMPTY, Insets.EMPTY)));

        for (Button lien : liens) {
            lien.setTextFill(COLOR_DARK);
            lien.setBackground(new Background(new BackgroundFill(COLOR_PRIMARY, CornerRadii.EMPTY, Insets.EMPTY)));
            Animations.animateButton(lien, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
        }
        btnComptes.setTextFill(Color.WHITE);
        btnTransactions.setTextFill(Color.WHITE);
        btnCarteBancaires.setTextFill(Color.WHITE);
        btnTypes.setTextFill(Color.WHITE);
        btnRole.setTextFill(Color.WHITE);
        btnUser.setTextFill(Color.WHITE);
        packs.setTextFill(Color.WHITE);
    }    
    
    
       private void goToLink(String link) {
        for (Button lien : liens) {
            lien.setTextFill(COLOR_DARK);
            Animations.animateButton(lien, COLOR_GRAY, COLOR_DARK, COLOR_PRIMARY, 0, false);
        }
        MainWindowController.getInstance().loadInterface(link);
    }

    @FXML
    private void afficherComptes(ActionEvent event) {
          goToLink(Constants.FXML_BACK_DISPLAY_ALL_COMPTE);

        btnComptes.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnComptes, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void afficherTransactions(ActionEvent event) {
         goToLink(Constants.FXML_BACK_DISPLAY_ALL_TRANSACTION);

        btnTransactions.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnTransactions, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void afficherCarteBancaires(ActionEvent event) {
          goToLink(Constants.FXML_BACK_DISPLAY_ALL_CARTEBANCAIRE);

        btnCarteBancaires.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnCarteBancaires, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void afficherTypes(ActionEvent event) {
         goToLink(Constants.FXML_BACK_DISPLAY_ALL_TYPE);

        btnTypes.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnTypes, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void UsersManagement(ActionEvent event) {
        goToLink(Constants.FXML_UsersManagement);

        btnUser.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnUser, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void RolesManagement(ActionEvent event) {
               goToLink(Constants.FXML_RolesManagement);

        btnRole.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(btnRole, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }

    @FXML
    private void OnPacksClicked(ActionEvent event) {
               goToLink(Constants.FXML_packs);

        packs.setTextFill(COLOR_PRIMARY);
        Animations.animateButton(packs, COLOR_GRAY, Color.WHITE, COLOR_PRIMARY, 0, false);
    }
    
     @FXML
    public void logout(ActionEvent actionEvent) {
        MainApp.getInstance().logout();
    }
    
}
