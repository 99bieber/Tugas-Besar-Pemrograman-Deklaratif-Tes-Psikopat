package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jpl7.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soal3Controller extends semuadata {

    public String nama;
    public int total;

    @FXML
    private TextField input;

    @FXML
    private Button lanjut;

    @FXML
    private void keSoal4(ActionEvent event) {
        String coba = input.getText();
        String string = coba;
        String[] parts = string.split(",");
            for(int i=0;i<parts.length;i++) {
            System.out.println(parts[i]);
        }
        String s1 = "consult('D:/TUBES DEKLARATIF TES PSIKOPAT/src/sample/test.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));
        Query q2 = new Query(s1);
        q2.hasSolution();
        q2 = new Query("tes_simetris([" + coba + "])");
            if (q2.hasSolution() == true){
                System.out.println("Benar");
                total ++;
            } else
                System.out.println("Salah");

            Node source = (Node) event.getSource();
            Stage stage = (Stage)  source.getScene().getWindow();
            stage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("soal4.fxml"));
                Parent root = loader.load();
                Stage stage1 = new Stage();
                soal4Controller soal4Controller = loader.getController();
                soal4Controller.datakirim(nama, total);
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