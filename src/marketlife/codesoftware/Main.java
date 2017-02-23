package marketlife.codesoftware;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import marketlife.window.EnterPassword.controller.EnterPassword;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    EnterPassword enterPassword = new EnterPassword();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/EnterPassword/fxml/EnterPassword.fxml"));
        primaryStage.setTitle("Введите логин и пароль");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, SQLException {
        launch(args);
    }

}
