package marketlife.window.ProcessingMutable.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by coole on 18.02.2017.
 */
public class ProcessingMutable {

    public void openProcessingMutable() throws IOException {
        Stage stageProcessingMutable = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProcessingMutable/fxml/ProcessingMutable.fxml"));
        stageProcessingMutable.setTitle("Настройка переменных");
        stageProcessingMutable.setScene(new Scene(root));
        stageProcessingMutable.show();
    }
}
