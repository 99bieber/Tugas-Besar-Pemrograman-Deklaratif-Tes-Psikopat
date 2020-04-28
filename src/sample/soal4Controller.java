package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jpl7.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class soal4Controller extends semuadata {

    public String nama;
    public int total;

    @FXML
    private TextField input1, input2;

    @FXML
    private Button lanjut;

    @FXML
    private void keSoal5(ActionEvent event) {
        String coba = input1.getText();
        String angka = input2.getText();
        String s1 = "consult('D:/TUBES DEKLARATIF TES PSIKOPAT/src/sample/test.pl')";
        Query q1 = new Query(s1);
        System.out.println(s1+""+(q1.hasSolution()? "Success" : "Failed"));
        Query q3 = new Query(s1);
        q3.hasSolution();
        q3 = new Query("linearList([" + coba + ",["+ angka +"]], Z)");
        if (q3.hasSolution() == true){
            System.out.println("Benar");
            total ++;
        } else
            System.out.println("Salah");
        System.out.println(total);

        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("soal5.fxml"));
            Parent root = loader.load();
            Stage stage1 = new Stage();
            soal5Controller soal5Controller = loader.getController();
            soal5Controller.datakirim(nama, total);
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