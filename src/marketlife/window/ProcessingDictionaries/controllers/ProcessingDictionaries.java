package marketlife.window.ProcessingDictionaries.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Viktor on 18.02.2017.
 */
public class ProcessingDictionaries {

    @FXML
    private Button button_closeProcessingDictionaries;

    public void openProcessingDictionaries() throws IOException {
        Stage stageProcessingDictionaries = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProcessingDictionaries/fxml/ProcessingDictionaries.fxml"));
        stageProcessingDictionaries.setTitle("Работа со словарями");
        stageProcessingDictionaries.setScene(new Scene(root));
        stageProcessingDictionaries.show();
    }

    public void action_button_closeProcessingDictionaries(ActionEvent actionEvent) {
        Stage stage = (Stage) button_closeProcessingDictionaries.getScene().getWindow();
        stage.close();
    }
}
