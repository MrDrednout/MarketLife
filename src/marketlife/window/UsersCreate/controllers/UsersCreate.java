package marketlife.window.UsersCreate.controllers;

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
public class UsersCreate {

    @FXML
    private Button button_closeUsersCreate;

    public void openUsersCreate() throws IOException {
        Stage stageUsersCreate = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/UsersCreate/fxml/UsersCreate.fxml"));
        stageUsersCreate.setTitle("Создание пользователя");
        stageUsersCreate.setScene(new Scene(root));
        stageUsersCreate.setResizable(false);
        stageUsersCreate.show();
    }

    public void action_button_closeUsersCreate(ActionEvent actionEvent) {
        Stage stage = (Stage) button_closeUsersCreate.getScene().getWindow();
        stage.close();
    }
}
