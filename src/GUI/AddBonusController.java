/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Bonus;
import entities.Pack;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import services.ServiceBonus;
import services.ServicePack;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddBonusController implements Initializable {

    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Home;

     private ServiceBonus sb = new ServiceBonus();
     private Bonus b = new Bonus();
     private Pack p = new Pack();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

private void SendEmail() {

     
      // Recipient's email ID needs to be mentioned.
      String to = "ayoub.hammoudi@esprit.tn";

      // Sender's email ID needs to be mentioned
      String from = "web@gmail.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("FELICITATION!");

         // Now set the actual message
         message.setText("Merci pour votre achat!Profitez de votre Pack et ses Bonus extraordinaires!");

         // Send message
         Transport.send(message);
          JOptionPane.showMessageDialog(null,"Sent message successfully....");       

      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }

    

    @FXML
    private void OnAjouterClicked(ActionEvent event) {
 if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty()
|| tf4.getText().isEmpty() ) {
// Afficher un message d'erreur si un champ est vide
       JOptionPane.showMessageDialog(null, "veuillez remplire tous les champs !");

}
else{
            b.setBonus1(tf1.getText());
            b.setBonus2(tf2.getText());
            b.setBonus3(tf3.getText());
            b.setBonus4(tf4.getText());
          /*  b.setP(p.id==id_packA);*/
            sb.ajouter(b);
Notifications.create()
        .title("Succès")
        .text("Bonus ajouté !Création Du Pack Terminé !")
        .showInformation();   
SendEmail();
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Bonuss.fxml"));
            Parent root = loader.load();
            Ajouter.getScene().setRoot(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
   private void OnHomeClicked(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackHome.fxml"));
            Parent root = loader.load();
            Home.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
