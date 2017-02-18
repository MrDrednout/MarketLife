package marketlife.window.AboutTheProgram.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oracle.jdbc.proxy.annotation.GetCreator;

import java.io.IOException;

/**
 * Created by Viktor on 12.02.2017.
 */
public class AboutTheProgram {

    @FXML
    private Button button_closeAboutTheProgram;

    public void openAboutTheProgramm() throws IOException {
        Stage stageAboutTheProgramm = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/AboutTheProgram/fxml/AboutTheProgram.fxml"));
        stageAboutTheProgramm.setTitle("О программе.");
        stageAboutTheProgramm.setScene(new Scene(root));
        stageAboutTheProgramm.setResizable(false);
        stageAboutTheProgramm.show();
    }


    public void ation_button_closeAboutTheProgram(ActionEvent actionEvent) {
        Stage stage = (Stage) button_closeAboutTheProgram.getScene().getWindow();
        stage.close();
    }
}
