
package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController extends semuadata {

    public String usernamekirim;
    public int total_hasil = 0;

    @FXML
    private Button gosoal1;
    @FXML
    private TextField username1;

    @FXML
    private void keSoal1(ActionEvent event) {
        usernamekirim = username1.getText();
        System.out.println(usernamekirim);
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal1.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            soal1Controller soal1Controller = loader.getController();
            soal1Controller.datakirim(usernamekirim, total_hasil);
            stage1.setTitle("Tes Psikopat");
            stage1.setScene(new Scene(root));
            stage1.show();
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("error saat change stages");
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}