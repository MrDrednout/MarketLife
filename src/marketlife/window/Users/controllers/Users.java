package marketlife.window.Users.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import marketlife.window.ProductsList.objects.Goods;
import marketlife.window.Users.interfaces.impls.CollectionUsers;
import marketlife.window.Users.objects.UsersObject;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by coole on 18.02.2017.
 */
public class Users {

    CollectionUsers collectionUsers = new CollectionUsers();

    @FXML
    private Button buton_closeUsers;

    @FXML
    private Button batton_update;

    @FXML
    private TableView tableView_Users;

    @FXML
    private TableColumn<UsersObject, Integer> column_id_users;

    @FXML
    private TableColumn<UsersObject, Integer> column_block_flag;

    @FXML
    private TableColumn<UsersObject, String> column_f;

    @FXML
    private TableColumn<UsersObject, String> column_o;

    @FXML
    private TableColumn<UsersObject, String> column_i;

    @FXML
    private TableColumn<UsersObject, String> column_login;

    @FXML
    public void initialize() throws SQLException {
        collectionUsers.fillingUsersList();
        column_id_users.setCellValueFactory(new PropertyValueFactory<UsersObject, Integer>("id_user"));
        column_block_flag.setCellValueFactory(new PropertyValueFactory<UsersObject, Integer>("flg_block"));
        column_f.setCellValueFactory(new PropertyValueFactory<UsersObject, String>("f"));
        column_i.setCellValueFactory(new PropertyValueFactory<UsersObject, String>("i"));
        column_o.setCellValueFactory(new PropertyValueFactory<UsersObject, String>("o"));
        column_login.setCellValueFactory(new PropertyValueFactory<UsersObject, String>("login"));
        tableView_Users.setItems(collectionUsers.getUsersObjects());
    }

    public void showUsersList() throws SQLException {
        collectionUsers.fillingUsersList();
        tableView_Users.setItems(collectionUsers.getUsersObjects());
    }

    public void openUsers() throws IOException, SQLException {
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

    public void action_batton_update(ActionEvent actionEvent) throws SQLException {
        showUsersList();
    }
}
