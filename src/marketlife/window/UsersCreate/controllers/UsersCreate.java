package marketlife.window.UsersCreate.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import marketlife.codesoftware.AlertForm;
import marketlife.codesoftware.sql.SQLConnect;
import marketlife.window.UsersCreate.sql.UsersCreateSql;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.SQLException;

/**
 * Created by coole on 18.02.2017.
 */
public class UsersCreate {

    @FXML
    private Button button_closeUsersCreate;

    @FXML
    private TextField textField_idUser;

    @FXML
    private TextField textField_i;

    @FXML
    private TextField textField_o;

    @FXML
    private TextField textField_f;

    @FXML
    private TextField textField_logg;

    @FXML
    private PasswordField passwordField_pass;

    @FXML
    private CheckBox checkBox_flgBlock;

    UsersCreateSql usersCreateSql = new UsersCreateSql();
    AlertForm alertForm = new AlertForm();

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

    public void action_button_createUsers(ActionEvent actionEvent) throws SQLException, IOException {
        int id_user = 0;
        if ((textField_f.getLength() == 0)
            || (textField_i.getLength() == 0)
            || (textField_o.getLength() == 0)
            || (textField_logg.getLength() == 0)
            || (passwordField_pass.getLength() == 0)
           ) alertForm.alertWarning("Заполнены не все поля", "Поверьте, пожалуйста");
        else {
            int i = 0;
            if (checkBox_flgBlock.isSelected() == true) i = 1;
            id_user = usersCreateSql.executeCreateUser(textField_f.getText(), textField_i.getText(), textField_o.getText(), textField_logg.getText(), passwordField_pass.getText(), i);

        }
        if (id_user != 0) textField_idUser.setText(Integer.toString(id_user));
    }
}
