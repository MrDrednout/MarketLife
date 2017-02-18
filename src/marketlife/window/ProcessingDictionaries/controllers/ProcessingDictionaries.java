package marketlife.window.ProcessingDictionaries.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Viktor on 18.02.2017.
 */
public class ProcessingDictionaries {

    public void openProcessingDictionaries() throws IOException {
        Stage stageProcessingDictionaries = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProcessingDictionaries/fxml/ProcessingDictionaries.fxml"));
        stageProcessingDictionaries.setTitle("Работа со словарями");
        stageProcessingDictionaries.setScene(new Scene(root));
        stageProcessingDictionaries.show();
    }
}
