/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import services.Mail;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class StripeController implements Initializable {

    @FXML
    private TextField adressField;
    @FXML
    private Button Home;
    @FXML
    private Button Return;
    @FXML
    private Button Valider;
    @FXML
    private ChoiceBox<?> Packs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void OnReturnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PackDetails.fxml"));
            Parent root = loader.load();
            Return.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void StripePayement() {
        Stripe.apiKey = "sk_test_51N0lANCneaseIC3dmIVz6ik2V633qHDZRBea6Ra9QTVcdS8licrefwFZmv8fh5PmiccrJSpavxCPDrx0fG2eWFJo00XAsp0PWT";
        RequestOptions requestOptions = RequestOptions.builder()
          .setStripeAccount("acct_1N0lANCneaseIC3d")
          .build();

        CustomerCreateParams params =
            CustomerCreateParams
                .builder()
                .setDescription("New Customer Added")
                .setEmail(adressField.getText())
                .setPaymentMethod("pm_card_visa")  
                .build();
        try {
            Customer customer = Customer.create(params);
            System.out.println(customer);
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void OnValiderClicked(ActionEvent event) throws Exception {
        StripePayement();
        Mail.sendMail(adressField.getText(), "new stripe link");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Succes.fxml"));
            Parent root = loader.load();
            Valider.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddPackController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        
}
