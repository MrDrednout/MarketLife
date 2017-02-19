package marketlife.codesoftware;

import javafx.scene.control.Alert;

import java.io.IOException;

/**
 * Created by coole on 19.02.2017.
 */
public class AlertForm {

    // Создание информационного окна
    public void alertWarning(String hText, String cText) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ooops");
        alert.setHeaderText(hText);
        alert.setContentText(cText);
        alert.showAndWait();
    }
}
