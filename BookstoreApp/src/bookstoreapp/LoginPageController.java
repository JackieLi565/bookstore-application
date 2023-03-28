/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

 
import java.net.URL;
import java.util.ResourceBundle;

//fx imports
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Model imports
import backendModel.Bookstore;

/**
 * FXML Controller class
 *
 * @author lijac
 */
public class LoginPageController implements Initializable {
    
    Bookstore bookstore;
    private Stage stage;
    private Scene scene;

    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private javafx.scene.control.PasswordField password;

    @FXML
    public void login(javafx.event.ActionEvent event) {
        Parent root;
        String name = username.getText();
        String pass = password.getText();
        try {
            if (name.equals("Jimmy1") && pass.equals("1")) {
                root = FXMLLoader.load(getClass().getResource("OwnerStartScreen.fxml"));
                scene = new Scene(root);
            } else if (bookstore.login(name, pass)) {
                root = FXMLLoader.load(getClass().getResource("CustomerStartScreen.fxml"));
                scene = new Scene(root);
            } else {
                System.out.println("is neither owner or memeber");
            }
        }catch(Exception e) {
        
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookstore = new Bookstore();
        //TODO: inst owner instance
    }    



    
}