package marketlife.window.Users.controllers;

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
public class Users {

    @FXML
    private Button buton_closeUsers;

    public void openUsers() throws IOException {
        Stage stageOpenUsers = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/Users/fxml/Users.fxml"));
        stageOpenUsers.setTitle("Пользователи");
        stageOpenUsers.setScene(new Scene(root));
        stageOpenUsers.show();
    }

    public void action_buton_closeUsers(ActionEvent actionEvent) {
        Stage stage = (Stage) buton_closeUsers.getScene().getWindow();
        stage.close();
    }
}
