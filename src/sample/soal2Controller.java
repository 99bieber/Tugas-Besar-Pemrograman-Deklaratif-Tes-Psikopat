package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jpl7.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soal2Controller extends semuadata {

    String nama;
    int total;

    @FXML
    private Button a,b;

    @FXML
    private Label hasil1;

    @FXML
    private void keSoal3(ActionEvent event) {
        System.out.println(nama);
        System.out.println(total);
        String s1 = "consult('D:/TUBES DEKLARATIF TES PSIKOPAT/src/sample/test.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));
        String jawaban = ((Button)event.getSource()).getId();
        System.out.println(jawaban);
        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("findLast(" + jawaban + ", [a,b])");
        if (q2.hasSolution() == true){
            System.out.println("Benar");
            total ++;
        } else
            System.out.println("Salah");

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal3.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            soal3Controller soal3Controller = loader.getController();
            soal3Controller.datakirim(nama, total);
            stage1.setTitle("Tes Logika");
            stage1.setScene(new Scene(root));
            stage1.show();
        } catch (IOException e) {
            System.out.println("error saat change stages");
        }
    }

    public void datakirim(String usernamekirim, int total_hasil) {
        nama = usernamekirim;
        total = total_hasil;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}