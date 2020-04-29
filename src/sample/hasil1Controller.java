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

public class hasil1Controller extends semuadata {

    public String nama;
    public int total;
    public String hasil_akhir;

    @FXML
    private Button selesai;

    @FXML
    private Label kesimpulan,name,score;

    @FXML
    private void selesai(ActionEvent event) {
        System.out.println(nama);
        System.out.println(total);
        Node source = (Node) event.getSource();
        Stage stage = (Stage)  source.getScene().getWindow();
        stage.close();
    }

    public void datakirim(String usernamekirim, int total_hasil) {
        nama = usernamekirim;
        total = total_hasil * 20;
        if (total >= 50){
            hasil_akhir = "Psikopat, yang menyukai angka - angka kecil \n            dan tidak menyukai kekalahan.";
        } else {
            hasil_akhir = "Bukan Psikopat, karena sangat terampil \n           dan berhati - hati dalam pemilihan jawaban";
        }
        name.setText(nama);
        score.setText(String.valueOf(total));
        kesimpulan.setText(hasil_akhir);
    }

    public void tampil() {
        name.setText(nama);
        score.setText(String.valueOf(total));
        kesimpulan.setText(hasil_akhir);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tampil();
        System.out.println(nama);
        System.out.println(total);
    }

}