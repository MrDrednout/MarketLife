package marketlife.window.ProductCreate.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by coole on 21.01.2017.
 */
public class ProductCreate {

    public void openProductCreate() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProductCreate/fxml/ProductCreate.fxml"));
        primaryStage.setTitle("Заполните поля и нажмите \"Создать\"");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
