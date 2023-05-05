/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.PackDetailsController.id_achat;
import entities.Bonus;
import services.ServiceBonus;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import services.ServicePack;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class WheelController implements Initializable {

    @FXML
    private ImageView Wheel;
    @FXML
    private Button Start;
    @FXML
    private ImageView Marker;
    @FXML
    private Button Home;
    
            private ServicePack sp = new ServicePack();

    
         private ServiceBonus sb = new ServiceBonus();
    @FXML
    private AnchorPane idanchor;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnStartClicked(ActionEvent event) { 
        
        System.out.println(PackDetailsController.id_achat); 
     Bonus bonusf = null;
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wiiw", "root", "");
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bonus WHERE bonus_id = ?")) {
        stmt.setInt(1, PackDetailsController.id_achat);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            bonusf = new Bonus();
            bonusf.setId(rs.getInt("id"));
            bonusf.setBonus1(rs.getString("nom_bonus1"));
            bonusf.setBonus2(rs.getString("nom_bonus2"));
            bonusf.setBonus3(rs.getString("nom_bonus3"));
            bonusf.setBonus4(rs.getString("nom_bonus4"));
            bonusf.setP(sp.getOneById(id_achat));
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    String b1, b2, b3, b4;
    if (bonusf != null) {
        b1 = bonusf.getBonus1();
        b2 = bonusf.getBonus2();
        b3 = bonusf.getBonus3();
        b4 = bonusf.getBonus4();
    } else {
        // Si bonusf est null, initialiser les variables avec des valeurs par défaut
        b1 = "";
        b2 = "";
        b3 = "";
        b4 = "";
        // ou générer une erreur
        throw new RuntimeException("Impossible de charger les bonus pour cet achat.");
    }

    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), Wheel); // Crée une transition de rotation de 4 secondes sur l'ImageView Wheel
    rotateTransition.setByAngle(360 * Math.random()*360); // Tourne la roulette de 4 tours complets (360 degrés par tour)
    rotateTransition.play(); // Démarre la transition
    
    // Ajouter un événement de fin de transition pour mettre à jour la couleur du marqueur
    rotateTransition.setOnFinished(e -> {
        // Mettre à jour la couleur du marqueur en fonction de l'angle de la roulette
        double angle = Wheel.getRotate() % 360;
        // Calculer la couleur correspondante à l'angle et mettre à jour l'image du marqueur
        // ...
           if(angle>=0 && angle<10){
             System.out.println(b1);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b1+"!")
        .showInformation();
         }
           if(angle>=10 && angle<20){
              
             System.out.println(b2);
            Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
            if(angle>=20 && angle<30){
             System.out.println(b3);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
            if(angle>=30 && angle<39){
             System.out.println(b2);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
            if(angle>=39 && angle<49){
             System.out.println(b3);
            
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
            if(angle>=49 && angle<59){
             System.out.println(b2);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
            if(angle>=59 && angle<69){
             System.out.println(b3);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
            if(angle>=69 && angle<79){
             System.out.println(b2);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
            if(angle>=79 && angle<89){
             System.out.println(b3);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
            if(angle>=89 && angle<99){
             System.out.println(b2);
             Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=99 && angle<109){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=109 && angle<119){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=119 && angle<129){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=129 && angle<139){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=139 && angle<149){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=149 && angle<159){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=159 && angle<169){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=169 && angle<179){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=179 && angle<189){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=189 && angle<199){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=199 && angle<209){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=209 && angle<219){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=219 && angle<229){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=229 && angle<239){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             
             if(angle>=239 && angle<249){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=249 && angle<259){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=259 && angle<269){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=269 && angle<279){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             
             if(angle>=279 && angle<289){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=289 && angle<299){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=299 && angle<309){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=309 && angle<319){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=319 && angle<329){
             System.out.println(b3);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b3+"!")
        .showInformation();}
             if(angle>=329 && angle<339){
             System.out.println(b2); Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=339 && angle<349){
             System.out.println(b4);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b4+"!")
        .showInformation();}
             if(angle>=349 && angle<359){
             System.out.println(b2);
              Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné  "+b2+"!")
        .showInformation();}
             if(angle>=359 && angle<369){
             System.out.println(b3); Notifications.create()
        .title("Succès")
        .text("Vous Avez Gangné   "+b3+"!")
        .showInformation();}
                
             
             
            
    });
    
    Notifications.create()
        .title("Succès")
        .text("FELICITATION !PROFITEZ DE VOTRE BONUS")
        .showInformation(); 
    }

    @FXML
    private void OnHomeClicked(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BackHome.fxml"));
        Parent root = loader.load();
        PacksController s = new PacksController();
        idanchor.getChildren().clear();
        idanchor.getChildren().setAll(root);
    }

    
    
}
