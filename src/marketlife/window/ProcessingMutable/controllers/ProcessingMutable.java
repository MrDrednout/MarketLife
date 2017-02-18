package marketlife.window.ProcessingMutable.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by coole on 18.02.2017.
 */
public class ProcessingMutable {

    @FXML
    private Button button_closeProcwssingMutable;

    public void openProcessingMutable() throws IOException {
        Stage stageProcessingMutable = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProcessingMutable/fxml/ProcessingMutable.fxml"));
        stageProcessingMutable.setTitle("Настройка переменных");
        stageProcessingMutable.setScene(new Scene(root));
        stageProcessingMutable.show();
    }

    public void action_button_closeProcwssingMutable(ActionEvent actionEvent) {
        Stage stage = (Stage) button_closeProcwssingMutable.getScene().getWindow();
        stage.close();
    }
}
